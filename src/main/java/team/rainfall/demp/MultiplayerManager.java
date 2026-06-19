package team.rainfall.demp;

import age.of.civilizations2.jakowski.lukasz.Save.SaveGameManager;

public class MultiplayerManager {
    public static MultiplayerManager multiplayerManager = new MultiplayerManager();
    private boolean isMultiplayer = false;
    private boolean isHost = false;
    private String nickname = "Player123";
    private String roomID = null;
    public boolean isMultiplayer() {
        return isMultiplayer;
    }
    public void joinRoom(String roomID){
        this.roomID = roomID;
        isMultiplayer = true;
        isHost = false;
    }
    public void createRoom(String roomID){
        this.roomID = roomID;
        isMultiplayer = true;
        isHost = true;
    }
    public void leaveRoom(){
        isMultiplayer = false;
        isHost = false;
        roomID = null;
    }
    public void createSnapshot(){
        SaveGameManager.saveGame_0();
    }
}
