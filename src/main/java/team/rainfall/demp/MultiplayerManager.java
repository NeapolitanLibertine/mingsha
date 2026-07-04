package team.rainfall.demp;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Civilization;
import age.of.civilizations2.jakowski.lukasz.GameAction;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Save.SaveGameData.*;
import team.rainfall.ctap_mingsha.MixinCore;
import team.rainfall.demp.actions.DiplomaticAction;
import team.rainfall.demp.actions.DiplomaticActionHandler;
import team.rainfall.demp.network.GameClient;
import team.rainfall.demp.network.GameServer;
import team.rainfall.demp.network.MultiplayerPlayer;
import team.rainfall.demp.network.NetworkManager;
import team.rainfall.demp.network.NetworkMessage;
import age.of.civilizations2.jakowski.lukasz.Save.Save_CivDiplo_GameData;
import age.of.civilizations2.jakowski.lukasz.VictoryManager;
import com.badlogic.gdx.Gdx;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

public class MultiplayerManager {
    public static MultiplayerManager multiplayerManager =
        new MultiplayerManager();
    private boolean isMultiplayer = false;
    private boolean isHost = false;
    private boolean waitingForSnapshot = false;
    private String nickname = "Player123";
    private String roomID = null;
    private int hostPort = 25565;
    private String hostPassword = "";
    private volatile boolean pendingHostStart = false;
    private final List<MultiplayerPlayer> players = new ArrayList<>();
    private MultiplayerPlayer hostPlayer;

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public boolean isHost() {
        return isHost;
    }

    public void joinRoom(String roomID) {
        this.roomID = roomID;
        isMultiplayer = true;
        isHost = false;
    }

    public void startJoinGame(String host, int port, String password, String username) {
        this.nickname = username;
        this.hostPort = port;
        this.hostPassword = password;
        this.isMultiplayer = true;
        this.isHost = false;
        try {
            NetworkManager.getInstance().connect(host, port, username, password);
            new Thread(this::waitForScenarioAndSnapshot, "client-join-watcher").start();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void waitForScenarioAndSnapshot() {
        GameClient client = NetworkManager.getInstance().getClient();
        if (client == null) return;
        try {
            while (client.isConnected() && !client.hasHelloAcknowledged()) {
                Thread.sleep(100);
            }
            if (!client.isConnected()) return;
            while (client.isConnected() && !client.hasPendingScenarioTag()) {
                Thread.sleep(100);
            }
            client.consumePendingScenarioTag();
            if (!client.isConnected()) return;
            while (client.isConnected() && !client.hasPendingSnapshot()) {
                Thread.sleep(100);
            }
            if (!client.isConnected()) return;
            byte[] snapshot = client.consumePendingSnapshot();
            if (snapshot != null) {
                Gdx.app.postRunnable(() -> {
                    loadSnapshot(snapshot);
                    CFG.menus.setMenuID(View.eCREATE_NEW_GAME);
                });
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void sendDiplomaticAction(DiplomaticAction action) {
        if (isHost) {
            DiplomaticActionHandler.handle(action);
            GameServer server = NetworkManager.getInstance().getServer();
            if (server != null) {
                server.broadcastMessage(NetworkMessage.createGameAction(action.toBytes()));
            }
        } else {
            GameClient client = NetworkManager.getInstance().getClient();
            if (client != null) {
                client.sendMessage(NetworkMessage.createGameAction(action.toBytes()));
            }
        }
    }

    public void createRoom(String roomID) {
        this.roomID = roomID;
        isMultiplayer = true;
        isHost = true;
    }

    public void leaveRoom() {
        releaseTurnWait();
        resetAllReadiness();
        isMultiplayer = false;
        isHost = false;
        roomID = null;
        hostPlayer = null;
        synchronized (players) { players.clear(); }
        NetworkManager.getInstance().stopAll();
    }

    public void startHostGame(int port, String password, String username) {
        this.hostPort = port;
        this.hostPassword = password;
        this.nickname = username;
        this.isMultiplayer = true;
        this.isHost = true;
        this.pendingHostStart = true;
        this.hostPlayer = MultiplayerPlayer.createHost(username);
        synchronized (players) { players.add(hostPlayer); }

        new Thread(() -> {
            while (pendingHostStart) {
                try {
                    Thread.sleep(300);
                    if (CFG.startTheGameData != null && CFG.startTheGameData.getIsDone()) {
                        NetworkManager.getInstance().startServer(hostPort, hostPassword);
                        GameServer server = NetworkManager.getInstance().getServer();
                        if (server != null) {
                            byte[] initialSnapshot = createSnapshot();
                            if (initialSnapshot != null) {
                                server.setCurrentSnapshot(initialSnapshot);
                            }
                            server.setEventListener(new GameServer.GameEventListener() {
                                @Override
                                public void onPlayerConnected(int clientId, String username) {
                                    onClientPlayerConnected(clientId, username);
                                }

                                @Override
                                public void onPlayerDisconnected(int clientId) {
                                    onClientPlayerDisconnected(clientId);
                                }

                                @Override
                                public void onTurnReady(int clientId) {
                                    Gdx.app.postRunnable(() -> onClientTurnReady(clientId));
                                }
                            });
                        }
                        pendingHostStart = false;
                        break;
                    }
                } catch (InterruptedException e) {
                    break;
                } catch (Exception ignored) {
                    try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
                }
            }
        }, "host-start-watcher").start();
    }

    public void stopHostGame() {
        pendingHostStart = false;
        NetworkManager.getInstance().stopAll();
    }

    private void onClientPlayerConnected(int clientId, String username) {
        MultiplayerPlayer player = MultiplayerPlayer.createClient(clientId, username);
        synchronized (players) { players.add(player); }
    }

    private void onClientPlayerDisconnected(int clientId) {
        synchronized (players) {
            players.removeIf(p -> p.clientId == clientId);
        }
    }

    private void onClientTurnReady(int clientId) {
        MultiplayerPlayer player = getPlayerByClientId(clientId);
        if (player != null) {
            player.turnReady = true;
        }
        if (hostPlayer != null && hostPlayer.turnReady && allPlayersReady()) {
            advanceTurn();
        }
    }

    private MultiplayerPlayer getPlayerByClientId(int clientId) {
        synchronized (players) {
            for (MultiplayerPlayer p : players) {
                if (p.clientId == clientId) return p;
            }
        }
        return null;
    }

    private boolean allPlayersReady() {
        synchronized (players) {
            if (players.isEmpty()) return true;
            for (MultiplayerPlayer p : players) {
                if (!p.turnReady) return false;
            }
            return true;
        }
    }

    public int getPlayerCount() {
        synchronized (players) {
            return players.size();
        }
    }

    public void markPlayerReadyAndCheck() {
        if (isHost) {
            if (hostPlayer != null) {
                hostPlayer.turnReady = true;
            }
            if (allPlayersReady()) {
                advanceTurn();
            } else {
                waitForSnapshot();
            }
        } else {
            sendTurnReadyToServer();
            waitForSnapshot();
        }
    }

    private void sendTurnReadyToServer() {
        if (NetworkManager.getInstance().getClient() != null) {
            NetworkManager.getInstance().getClient().sendMessage(NetworkMessage.createTurnReady());
        }
    }

    private void advanceTurn() {
        if (waitingForSnapshot) {
            releaseTurnWait();
        }
        CFG.gameAction.takeNextTurn();
        byte[] snapshot = createSnapshot();
        if (snapshot != null) {
            GameServer server = NetworkManager.getInstance().getServer();
            if (server != null) {
                server.setCurrentSnapshot(snapshot);
                if (server.getClientCount() > 0) {
                    server.broadcastSnapshot(snapshot);
                }
            }
        }
        resetAllReadiness();
    }

    public void resetAllReadiness() {
        synchronized (players) {
            for (MultiplayerPlayer p : players) {
                p.turnReady = false;
            }
        }
    }

    public boolean isWaitingForSnapshot() {
        return waitingForSnapshot;
    }

    public void waitForSnapshot() {
        this.waitingForSnapshot = true;
        try {
            CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(false);
            CFG.menus.getInGameProvInfo().getMenuElem(0).setTextE("Waiting...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void releaseTurnWait() {
        this.waitingForSnapshot = false;
        try {
            CFG.gameAction.setActiveTurnState(GameAction.TurnStates.INPUT_ORDERS);
            CFG.menus.getInGameProvInfo().getMenuElem(0).setClickable(true);
            CFG.menus.getInGameProvInfo().getMenuElem(0).setTextE(CFG.lang.get("NextTurn"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSnapshot(byte[] data) {
        try {
            Inflater inflater = new Inflater(true);
            inflater.setInput(data);
            ByteArrayOutputStream baos = new ByteArrayOutputStream(data.length);
            byte[] buf = new byte[4096];
            while (!inflater.finished()) {
                int n = inflater.inflate(buf);
                baos.write(buf, 0, n);
            }
            inflater.end();
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(baos.toByteArray()));

            Save_GameData_1 g1 = (Save_GameData_1) CFG.deserialize(readBytes(dis));
            Save_GameData_2 g2 = (Save_GameData_2) CFG.deserialize(readBytes(dis));
            Save_GameData_3 g3 = (Save_GameData_3) CFG.deserialize(readBytes(dis));

            Save_GameData_4 g4 = (Save_GameData_4) CFG.deserialize(readBytes(dis));
            Save_GameData_5 g5 = (Save_GameData_5) CFG.deserialize(readBytes(dis));
            Save_GameData_6 g6 = (Save_GameData_6) CFG.deserialize(readBytes(dis));
            Save_GameData_7 g7 = (Save_GameData_7) CFG.deserialize(readBytes(dis));
            Save_GameData_8 g8 = (Save_GameData_8) CFG.deserialize(readBytes(dis));
            Save_GameData_9 g9 = (Save_GameData_9) CFG.deserialize(readBytes(dis));
            Save_GameData_10 g10 = (Save_GameData_10) CFG.deserialize(readBytes(dis));
            Save_GameData_11 g11 = (Save_GameData_11) CFG.deserialize(readBytes(dis));
            Save_GameData_12 g12 = (Save_GameData_12) CFG.deserialize(readBytes(dis));

            dis.close();

            CFG.DIFFICULTY = g1.DIFFICULTY;
            CFG.SANDBOX_MODE = g1.SANDBOX_MODE;
            GameCalendar.TURNID = g1.iTurnID;
            GameCalendar.TURNS_SINCE_LAST_WAR = g1.TURNS_SINCE_LAST_WAR;
            GameCalendar.currDay = g1.iDay;
            GameCalendar.currMonth = g1.iMonth;
            GameCalendar.currYear = g1.iYear;
            GameCalendar.CURRENT_AGEID = CFG.gameAges.getAgeOfYear(GameCalendar.currYear);
            GameCalendar.ENABLE_COLONIZATION = g1.ENABLE_COLONIZATION;
            GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = g1.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
            GameCalendar.COLONIZATION_TECH_LEVEL = g1.COLONIZATION_TECH_LEVEL;
            GameCalendar.GAME_SPEED = g1.GAME_SPEED;
            CFG.core.getGameScenars().setScenarioStartingPopulation(g1.STARTING_POPULATION);
            CFG.core.getGameScenars().setScenarioStartingEconomy(g1.STARTING_ECONOMY);
            CFG.core.getGameScenars().setScenario_PopulationGrowthRate_Modifier(g1.POPULATION_GROWTH_RATE_MODIFIER);
            CFG.core.getGameScenars().setScenario_EconomyGrowthRate_Modifier(g1.ECONOMY_GROWTH_RATE_MODIFIER);
            CFG.core.getGameScenars().setScenario_DiseasesDeathRate_Modifier(g1.DISEASES_DEATH_RATE_MODIFIER);
            VictoryManager.VICTORY_CONTROL_PROVINCES_PERC = g1.VICTORY_CONTROL_PROVINCES_PERC;
            VictoryManager.VICTORY_LIMIT_OF_TURNS = g1.VICTORY_LIMIT_OF_TURNS;
            VictoryManager.VICTORY_TECHNOLOGY = g1.VICTORY_TECHNOLOGY;
            CFG.core.getGameScenars().sActiveScenarioTag = g1.sActiveScenarioTag;

            java.util.List<Civilization> tempCivs = CFG.core.getGameScenars().loadCivilizationsLoadGame(g2.lCivsData, 0);
            MixinCore.get_lCivs(CFG.core).clear();
            for (int i = 0; i < tempCivs.size(); i++) {
                MixinCore.get_lCivs(CFG.core).add(tempCivs.get(i));
            }
            MixinCore.set_iCivsSize(CFG.core, MixinCore.get_lCivs(CFG.core).size());

            for (int i = 0; i < CFG.core.getCivsSize(); i++) {
                CFG.core.getCiv(i).buildRegroupLines_AfterLoading();
            }
            for (int i = 1; i < CFG.core.getCivsSize(); i++) {
                CFG.core.getCiv(i).buildDiplomacy(false);
            }

            for (int i = 0; i < g3.lCivsDiploData.size(); i++) {
                Save_CivDiplo_GameData diplo = (Save_CivDiplo_GameData) g3.lCivsDiploData.get(i);
                for (int j = 0; j < diplo.lNonAggressionPacts.size(); j++) {
                    CFG.core.getCiv(i + 1).setNonAggPact(
                        diplo.lNonAggressionPacts.get(j).id,
                        diplo.lNonAggressionPacts.get(j).iValue
                    );
                }
                for (int j = 0; j < diplo.lDefensivePact.size(); j++) {
                    CFG.core.getCiv(i + 1).setDefensivePact4(
                        diplo.lDefensivePact.get(j).id,
                        diplo.lDefensivePact.get(j).iValue
                    );
                }
                for (int j = 0; j < diplo.lGuarantee.size(); j++) {
                    CFG.core.getCiv(i + 1).setGuarantee2(
                        diplo.lGuarantee.get(j).id,
                        diplo.lGuarantee.get(j).iValue
                    );
                }
                for (int j = 0; j < diplo.lMilitaryAccess.size(); j++) {
                    CFG.core.getCiv(i + 1).setMilitaryAccess7(
                        diplo.lMilitaryAccess.get(j).id,
                        diplo.lMilitaryAccess.get(j).iValue
                    );
                }
                for (int j = 0; j < diplo.lTruce.size(); j++) {
                    CFG.core.getCiv(i + 1).setTruce3(
                        diplo.lTruce.get(j).id,
                        diplo.lTruce.get(j).iValue
                    );
                }
            }

            for (int i = 0; i < g4.lProvincesData.size(); i++) {
                CFG.core.getProv(i).provGD = g4.lProvincesData.get(i);
            }
            for (int i = 0; i < CFG.core.getProvinSize(); i++) {
                if (CFG.core.getProv(i).getCivId() > 0) {
                    if (CFG.core.getProv(i).getSeaProv()) {
                        CFG.core.getProv(i).setCivId(0, false);
                    } else {
                        CFG.core.getCiv(CFG.core.getProv(i).getCivId()).addProv_Just(i);
                    }
                }
            }

            CFG.eventsManager.events = g11.eventsGameData;
            CFG.hreMgr.holyRomanEmpire = g10.holyRomanEmpire_GameData;
            CFG.core.buildAlliances(g6.lAlliances);
            MixinCore.get_lWars(CFG.core).clear();
            for (int i = 0; i < g7.lWars.size(); i++) {
                MixinCore.get_lWars(CFG.core).add(g7.lWars.get(i));
            }
            MixinCore.set_iWarsSize(CFG.core, MixinCore.get_lWars(CFG.core).size());
            CFG.core.lPeaceTreaties.clear();
            for (int i = 0; i < g8.lPeaceTreaties.size(); i++) {
                CFG.core.lPeaceTreaties.add(g8.lPeaceTreaties.get(i));
            }
            CFG.plagueManager.plaguesActive.clear();
            for (int i = 0; i < g9.lPlagues_INGAME.size(); i++) {
                CFG.plagueManager.plaguesActive.add(g9.lPlagues_INGAME.get(i));
            }

            releaseTurnWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] createSnapshot() {
        Save_GameData_1 saveGameData1 = new Save_GameData_1();
        saveGameData1.buildData();
        Save_GameData_2 nSaveData2 = new Save_GameData_2();
        nSaveData2.buildData(0);
        Save_GameData_3 nSaveData3 = new Save_GameData_3();
        nSaveData3.buildData();
        Save_GameData_4 nSaveData4 = new Save_GameData_4();
        nSaveData4.buildData(0);
        Save_GameData_5 nSaveData5 = new Save_GameData_5();
        nSaveData5.buildData();
        Save_GameData_6 nSaveData6 = new Save_GameData_6();
        nSaveData6.buildData();
        Save_GameData_7 nSaveData7 = new Save_GameData_7();
        nSaveData7.buildData();
        Save_GameData_8 nSaveData8 = new Save_GameData_8();
        nSaveData8.buildData();
        Save_GameData_9 nSaveData9 = new Save_GameData_9();
        nSaveData9.buildData();
        Save_GameData_10 nSaveData10 = new Save_GameData_10();
        nSaveData10.buildData();
        Save_GameData_11 nSaveData11 = new Save_GameData_11();
        nSaveData11.buildData();
        Save_GameData_12 nSaveData12 = new Save_GameData_12();
        nSaveData12.buildData();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);

            byte[][] serialized = new byte[][]{
                CFG.serialize(saveGameData1),
                CFG.serialize(nSaveData2),
                CFG.serialize(nSaveData3),
                CFG.serialize(nSaveData4),
                CFG.serialize(nSaveData5),
                CFG.serialize(nSaveData6),
                CFG.serialize(nSaveData7),
                CFG.serialize(nSaveData8),
                CFG.serialize(nSaveData9),
                CFG.serialize(nSaveData10),
                CFG.serialize(nSaveData11),
                CFG.serialize(nSaveData12)
            };

            for (byte[] b : serialized) {
                dos.writeInt(b.length);
                dos.write(b);
            }

            dos.close();

            Deflater deflater = new Deflater(1, true);
            deflater.setInput(baos.toByteArray());
            deflater.finish();
            ByteArrayOutputStream compressedBaos = new ByteArrayOutputStream(baos.size());
            byte[] buf = new byte[4096];
            while (!deflater.finished()) {
                int n = deflater.deflate(buf);
                compressedBaos.write(buf, 0, n);
            }
            deflater.end();
            return compressedBaos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] readBytes(DataInputStream dis) throws IOException {
        int length = dis.readInt();
        byte[] data = new byte[length];
        dis.readFully(data);
        return data;
    }
}
