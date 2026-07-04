package team.rainfall.mingsha;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.EventsJ;
import age.of.civilizations2.jakowski.lukasz.Events_GameData;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.Menus.Menu_InitGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import team.rainfall.finality.luminosity2.annotations.Mixin;

import java.util.ArrayList;
import java.util.List;
@Mixin(mixinClass = "age.of.civilizations2.jakowski.lukasz.Game_Scenarios")
public class MixinGame_Scenarios {
    public List<String> lScenarios_TagsList = new ArrayList<>();
    public List<Boolean> isInternal = new ArrayList<>();
    public final void loadEventsData() {
        try {
            CFG.eventsManager.events = new Events_GameData();
            if (!Menu_InitGame.DJE && EventsJ.loadEventsJ()) {
                CFG.eventsManager.FXABF();
            } else {
                try {
                    FileHandle file = null;

                    try {
                        if (this.isInternal.get(CFG.core.getScenarioID())) {
                            file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + (String)this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "events/" + (String)this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_E");
                        } else {
                            try {
                                file = Gdx.files.local("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + (String)this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "events/" + (String)this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_E");
                            } catch (Exception var4) {
                                file = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + (String)this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/" + "events/" + (String)this.lScenarios_TagsList.get(CFG.core.getScenarioID()) + "_E");
                            }
                        }
                    } catch (Exception ex) {
                        CFG.exceptionStack(ex);
                    }

                    try {
                        CFG.eventsManager.events = (Events_GameData)CFG.deserializeIgnoringUID(file.readBytes());
                        CFG.eventsManager.FXABF();
                    } catch (Exception e) {
                        CFG.eventsManager.events = new Events_GameData();
                        CFG.eventsManager.FXABF();
                        CFG.exceptionStack(e);
                    }
                } catch (Exception ex) {
                    CFG.eventsManager.events = new Events_GameData();
                    CFG.eventsManager.FXABF();
                    CFG.exceptionStack(ex);
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }
}
