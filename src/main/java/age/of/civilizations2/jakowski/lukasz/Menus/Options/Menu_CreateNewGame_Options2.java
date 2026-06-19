//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz.Menus.Options;

import age.of.civilizations2.jakowski.lukasz.AoCGame;
import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Colors;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;
import age.of.civilizations2.jakowski.lukasz.LeaderOfCiv_GameData;
import age.of.civilizations2.jakowski.lukasz.MapScale;
import age.of.civilizations2.jakowski.lukasz.Menu;
import age.of.civilizations2.jakowski.lukasz.RenderProvince;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.VictoryManager;
import age.of.civilizations2.jakowski.lukasz.View;
import age.of.civilizations2.jakowski.lukasz.Button.MenuElemUI;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options;
import age.of.civilizations2.jakowski.lukasz.Button.CNG.Button_CNG_Options2;
import age.of.civilizations2.jakowski.lukasz.Core.Core;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Space;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Menus.NewGame.Menu_CreateNewGame;
import age.of.civilizations2.jakowski.lukasz.Sliders.ZRest.Slider_CNG;
import age.of.civilizations2.jakowski.lukasz.Title.TitleM_TextSmall;
import age.of.civilizations2.jakowski.lukasz.Z_Other.DialogType;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ColorPicker.ColorPicker_AoC;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class Menu_CreateNewGame_Options2 extends Menu {
    public static short NUM_OF_OPTIONS = 60;
    public static final int ANIMATION_TIME = 125;
    public static long lTime = 0L;
    public static boolean hideAnimation = true;

    public Menu_CreateNewGame_Options2() {
        int tempW = (int)((float)CFG.CIV_INFO_MENU_WIDTH * 1.35F);
        int tempMaxH = CFG.GAMEHEIGHT - (IMGManager.getIMG(Images.topBar2).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4) - (CFG.BUTTON_H + CFG.PADD * 2) - CFG.PADD;
        int tempElemH = CFG.BUTTON_H * 3 / 4;
        List<MenuElemUI> menuElements = new ArrayList();
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2 + CFG.map.getIcon(CFG.map.getActiveMapIDN()).getWidth(), 0, 0, tempW, tempElemH, true) {
            @Override
            public void actionElem(int iID) {
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                CFG.backToMenu = View.eCREATE_NEW_GAME;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
            }

            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                oSB.setColor(Color.WHITE);
                CFG.map.getIcon(CFG.map.getActiveMapIDN()).drawO(oSB, this.getPosXE() + CFG.PADD + iTranslateX, this.getPosY() + Menu_CreateNewGame_Options2.this.getMenuPosY() + this.getHeightE() / 2 - CFG.map.getIcon(CFG.map.getActiveMapIDN()).getHeight() / 2);
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.map.getMapName_Just(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Provinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.map.getMapNumOfProvinces(CFG.map.getActiveMapIDN()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LandProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countLandProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SeaProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countSeaProvinces(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AverageGrowthRateOfProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.countAvarageGrowthRate() + "%", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 25, 0) {
            public String getDrawText() {
                return this.getTextE() + ": " + (int)((1.0F + (float)this.getCurr() * 0.1F) * 100.0F) + "%";
            }

            @Override
            public void actionElem(int iID) {
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                MapScale.STANDARD_SCALE = 1.0F + (float)this.getCurr() * 0.1F;
                CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
                CFG.map.getMpS().setScaleBeforeReset(MapScale.STANDARD_SCALE >= 3.0F ? 2.0F : (MapScale.STANDARD_SCALE > 1.0F ? 1.0F : 0.5F));
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefaultScaleOfMap") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 2, tempW, tempElemH, true) {
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                super.drawTextE(oSB, iTranslateX, iTranslateY, isActive);

                for(int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    if (CFG.core.getPlayer(i).getCivId() > 0) {
                        CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getFlagC().drawO(oSB, this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getFlagC().getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                        oSB.setColor(new Color((float)CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getR() / 255.0F, (float)CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getG() / 255.0F, (float)CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getB() / 255.0F, 1.0F));
                        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() + iTranslateY - 2 - (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE), CFG.CIV_FLAG_WIDTH, (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE));
                    } else {
                        IMGManager.getIMG(Images.randomCivilizationFlag).drawO(oSB, this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 - IMGManager.getIMG(Images.randomCivilizationFlag).getHeight() + iTranslateY, CFG.CIV_FLAG_WIDTH, CFG.CIV_FLAG_HEIGHT);
                        IMGManager.getIMG(Images.flagRectSmall).drawO(oSB, this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() / 2 - CFG.CIV_FLAG_HEIGHT / 2 + iTranslateY);
                        oSB.setColor(CFG.RANDOM_CIVILIZATION_COLOR);
                        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getTextPosElem() + this.getTextWidthU() + CFG.PADD + CFG.CIV_FLAG_WIDTH * i + CFG.PADD * i + iTranslateX, this.getPosY() + this.getHeightE() + iTranslateY - 2 - (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE), CFG.CIV_FLAG_WIDTH, (int)((float)CFG.CIV_COLOR_W * CFG.GUI_SCALE));
                    }

                    oSB.setColor(Color.WHITE);
                }

            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Players") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getPlayersSize()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();

                for(int i = 0; i < CFG.core.getPlayersSize(); ++i) {
                    nData.add(new ME_Hover_2Type_Flag(CFG.core.getPlayer(i).getCivId()));
                    nData.add(new ME_Hover_2Type_Text(CFG.core.getPlayer(i).getCivId() > 0 ? CFG.core.getCiv(CFG.core.getPlayer(i).getCivId()).getCivName() : CFG.lang.get("RandomCivilization")));
                    nElements.add(new MEHover_2E(nData));
                    nData.clear();
                }

                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 3, tempW, tempElemH, true) {
            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, CFG.PADD));
                nData.add(new ME_Hover_2Type_Text(GameCalendar.getCurrDate(), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.gameAges.getAge(CFG.core.getGameScenars().getScenarioAgeID(CFG.core.getScenarioID())).getName()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Civilizations") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioNumOfCivs(CFG.core.getScenarioID()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Author") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.core.getGameScenars().getScenarioAuthorID(CFG.core.getScenarioID()), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();

                try {
                    if (FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + (String)CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/Desc.txt").exists()) {
                        String tText = FileManager.loadFile("map/" + CFG.map.getFileActiveMapPath() + "scenarios/" + (String)CFG.core.getGameScenars().lScenarios_TagsList.get(CFG.core.getScenarioID()) + "/Desc.txt").readString();
                        String[] splited = tText.split(";");
                        String fullText = "";

                        for(int q = 0; q < splited.length; ++q) {
                            fullText = fullText + CFG.lang.get(splited[q]) + " ";
                        }

                        if (fullText != null && fullText.length() > 0) {
                            nData.add(new ME_Hover_2Type_Space());
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                            nData.add(new ME_Hover_2Type_TextDesc(fullText, CFG.FONT_REGULAR_SMALL));
                            nElements.add(new MEHover_2E(nData));
                            nData.clear();
                        }
                    }
                } catch (Exception var7) {
                }

                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 4, tempW, tempElemH, true) {
            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("VictoryConditions") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Domination")));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ControlProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + VictoryManager.VICTORY_CONTROL_PROVINCES_PERC + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnsLimit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (VictoryManager.VICTORY_LIMIT_OF_TURNS == 0 ? CFG.lang.get("NoThanks") : CFG.lang.get("TurnsX", VictoryManager.VICTORY_LIMIT_OF_TURNS)), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Technology") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (VictoryManager.VICTORY_TECHNOLOGY == 0.0F ? CFG.lang.get("Disabled") : (float)((int)(VictoryManager.VICTORY_TECHNOLOGY * 100.0F)) / 100.0F), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 5 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 9, CFG.DIFFICULTY * 2 + 1) {
            public String getDrawText() {
                return this.getTextE();
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DifficultyLevel") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.getDifficultyName(CFG.DIFFICULTY)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Beginner")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Normal")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Hard")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Extreme")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Legendary")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 6 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 5, CFG.FOG_OF_WAR * 2 + 1) {
            public String getDrawText() {
                return this.getTextE();
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Fogofwar") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.getFogOfWarName(CFG.FOG_OF_WAR)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Off") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TheWholeMapAndSoldiersAreVisibleAtAllTimes") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Classic") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ProvinceOwnershipIsKnownButSoldiersCanOnlyBeSeenInAdjacentProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Discovery") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TheWorldIsCoveredByFogCivilizationsMustBeDiscoveredBeforeTheyCanBeInteractedWith") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 13, tempW, tempElemH, true) {
            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ChangeDiplomaticRelationsBetweenCivilizations") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 14, tempW, tempElemH, true, CFG.FILL_THE_MAP) {
            public boolean getCheckboxSt() {
                return CFG.FILL_THE_MAP;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("IfDisabledAllCivilizationsStartWithOnlyTheirCapitalProvince") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 16, tempW, tempElemH, true, CFG.RANDOM_PLACEMENT) {
            public boolean getCheckboxSt() {
                return CFG.RANDOM_PLACEMENT;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("PlacesCapitalsInRandomProvinces") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 17, tempW, tempElemH, true, CFG.RANDOM_FILL) {
            public boolean getCheckboxSt() {
                return CFG.RANDOM_FILL;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("RandomnlyFillsTheWorldWithDifferentCivilizations") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 18, tempW, tempElemH, true) {
            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SwapCivilizationsToRandomPlaces") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 20, tempW, tempElemH, true, CFG.SANDBOX_MODE) {
            public boolean getCheckboxSt() {
                return CFG.SANDBOX_MODE;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Sandbox"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.editorGame, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SandboxDescN")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 24, tempW, tempElemH, true, CFG.TOTAL_WARMODE) {
            public boolean getCheckboxSt() {
                return CFG.TOTAL_WARMODE;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("NoneoftheseCivilizationshasthewordforPeaceintheirlanguage") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2("", CFG.PADD * 2, 0, tempElemH * 15, tempW, tempElemH, true) {
            public void drawTextE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive) {
                if (CFG.palletManager.getActivePalletID() == 0) {
                    CFG.palletManager.drawSampleColors_Standard(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, this.getWidthE() - CFG.PADD * 4, this.getHeightE() - CFG.PADD * 4, 0, isActive);
                } else {
                    CFG.palletManager.drawSampleColors(oSB, this.getPosXE() + CFG.PADD * 2 + iTranslateX, this.getPosY() + CFG.PADD * 2 + iTranslateY, this.getWidthE() - CFG.PADD * 4, this.getHeightE() - CFG.PADD * 4, CFG.palletManager.getActivePalletID() - 1, isActive);
                }

            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SetsOfTheColorsForCivilizations") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 21, tempW, tempElemH, true, CFG.SPECTATOR_MODE) {
            public boolean getCheckboxSt() {
                return CFG.SPECTATOR_MODE;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ObserveCivilizationsAndTheirStruggleForSupremacy") + ".", CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 22, tempW, tempElemH, true, GameCalendar.ENABLE_COLONIZATION) {
            public boolean getCheckboxSt() {
                return GameCalendar.ENABLE_COLONIZATION;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enable") + "/" + CFG.lang.get("Disable") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(" " + CFG.lang.get("ColonizationofWastelandProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 23, tempW, tempElemH, true, GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES) {
            public boolean getCheckboxSt() {
                return GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(this.getTextE(), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Enable") + "/" + CFG.lang.get("Disable") + ": ", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonizationofNeutralProvinces") + "."));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 7 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, (int)(GameCalendar.GAME_SPEED_MIN * 10.0F), (int)(GameCalendar.GAME_SPEED_MAX * 10.0F), (int)(GameCalendar.GAME_SPEED * 10.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() * 10 + "%";
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 8 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, GameCalendar.MAX_AI_AGGRESSIVENESS, (int)(GameCalendar.AI_AGGRESSIVENESS * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.65F);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 9 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 10, 1000, (int)(CFG.REBELS_POWER * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NEGATIVE_1.r, CFG.COLOR_NEGATIVE_1.g, CFG.COLOR_NEGATIVE_1.b, 0.65F);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 10, tempW, tempElemH, true, CFG.AGE_OF_CHAOS_MODE) {
            public boolean getCheckboxSt() {
                return CFG.AGE_OF_CHAOS_MODE;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AgeOfChaos"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EveryXTurnsYouWillHaveToChangeTheCivilization", CFG.AGE_OF_CHAOS_TURNS)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("YouWillBeGivenRandomCivilizationsToChooseFrom")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PickOneAndContinueYourJourney")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                String hx = "416f48323a4445";
                StringBuilder out = new StringBuilder();

                for(int i = 0; i < hx.length(); i += 2) {
                    String part = hx.substring(i, i + 2);
                    out.append((char)Integer.parseInt(part, 16));
                }

                nData.add(new ME_Hover_2Type_Text(out.toString()));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 11 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 1, 100, CFG.AGE_OF_CHAOS_TURNS / 10) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() * 10;
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AgeOfChaos"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EveryXTurnsYouWillHaveToChangeTheCivilization", CFG.AGE_OF_CHAOS_TURNS)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("YouWillBeGivenRandomCivilizationsToChooseFrom")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PickOneAndContinueYourJourney")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 12 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 99, (int)(CFG.ARMY_RETREAT * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NEUTRAL2.r, CFG.COLOR_NEUTRAL2.g, CFG.COLOR_NEUTRAL2.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ArmyRetreat") + ": " + (int)(CFG.ARMY_RETREAT * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmyMove, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PercentageOfADefeatedArmyThatRetreatsToANeighboringProvince")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MinimumArmyToRetreat") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.getNumberWthSpaces("" + GameValues.gvMove.MIN_ARMY_TO_RETREAT), CFG.COLOR_TEXT_NUM_OF_PROVINCES));
                nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 25, tempW, tempElemH, true, CFG.USE_NEW_DECLARE_WAR_SYSTEM) {
            public boolean getCheckboxSt() {
                return CFG.USE_NEW_DECLARE_WAR_SYSTEM;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("UseNewAIWarDeclarationSystem") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.USE_NEW_DECLARE_WAR_SYSTEM ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 26 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 100, CFG.USE_OLD_DECLARE_WAR_CHANGE_100) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NEGATIVE_2.r, CFG.COLOR_NEGATIVE_2.g, CFG.COLOR_NEGATIVE_2.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ChanceToUseOldAIWarDeclarationSystem") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.USE_OLD_DECLARE_WAR_CHANGE_100 + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 27, tempW, tempElemH, true, CFG.ENABLE_NUKES) {
            public boolean getCheckboxSt() {
                return CFG.ENABLE_NUKES;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EnableNuclearWeapons") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.ENABLE_NUKES ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.nuke, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 28 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 2000, CFG.MIN_ARMY_REQUIRED_TO_ATTACK) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr();
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_MOVEMENT.r, CFG.COLOR_MOVEMENT.g, CFG.COLOR_MOVEMENT.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MinArmyRequiredToAttack") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.MIN_ARMY_REQUIRED_TO_ATTACK, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.attack, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 29 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 100, CFG.PROPOSE_ALLIANCE_CHANCE_100) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.r, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.g, CFG.COLOR_GRADIENT_TITLE_BLUE_LIGHT_ALLIANCE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI: " + CFG.lang.get("AllianceProposalChance") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.PROPOSE_ALLIANCE_CHANCE_100 + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploAlliance, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 30 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 1000, CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL) {
            public String getDrawText() {
                return this.getTextE() + (this.getCurr() == 0 ? CFG.lang.get("NoLimit") : this.getCurr());
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.r, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.g, CFG.COLOR_GRADIENT_LIGHTER_DARK_BLUE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI: " + CFG.lang.get("AllianceProposalMaxProvinces") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL == 0 ? CFG.lang.get("NoLimit") : CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.diploAlliance, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("CivilizationsWithFewerThanXProvincesWillProposeAnAlliance")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 31 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 50, (int)(CFG.CAPITULATION * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_WAR_BRIGHT.r, CFG.COLOR_WAR_BRIGHT.g, CFG.COLOR_WAR_BRIGHT.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Capitulation") + ": "));
                nData.add(new ME_Hover_2Type_Text((int)(CFG.CAPITULATION * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.provinces, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ACivilizationWillCapitulateDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 32, tempW, tempElemH, true, CFG.AI_UNIONS_ENABLED) {
            public boolean getCheckboxSt() {
                return CFG.AI_UNIONS_ENABLED;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI: " + CFG.lang.get("Unions") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.AI_UNIONS_ENABLED ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploUnion, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 33, tempW, tempElemH, true, CFG.AI_CONQUER_VASSALS) {
            public boolean getCheckboxSt() {
                return CFG.AI_CONQUER_VASSALS;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI: " + CFG.lang.get("ConquerVassals") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.AI_CONQUER_VASSALS ? CFG.lang.get("On") : CFG.lang.get("Off")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploVassal, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text("AI, " + CFG.lang.get("VassalLimit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.AI_CONQUER_OWN_VASSALS_IF_OVER, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploVassal, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AIWillTryToConquerItsOwnVassals")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 34 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 100, CFG.AI_CONQUER_OWN_VASSALS_IF_OVER) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr();
            }

            public Color getColorLEFT() {
                return new Color(Colors.COLOR_GRADIENT_OVER_GREEN.r, Colors.COLOR_GRADIENT_OVER_GREEN.g, Colors.COLOR_GRADIENT_OVER_GREEN.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI, " + CFG.lang.get("VassalLimit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.AI_CONQUER_OWN_VASSALS_IF_OVER, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploVassal, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AIWillTryToConquerItsOwnVassals")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 35 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 50, GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE_LIMIT, CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE) {
            public String getDrawText() {
                return this.getTextE() + (float)this.getCurr() / 100.0F;
            }

            public Color getColorLEFT() {
                return new Color(Colors.HOVER_DEFENSE.r, Colors.HOVER_DEFENSE.g, Colors.HOVER_DEFENSE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyDefenseModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE / 100.0F, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.defense, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AttackDefenseDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 36 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 50, GameValues.gvBattle.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK_LIMIT, CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK) {
            public String getDrawText() {
                return this.getTextE() + (float)this.getCurr() / 100.0F;
            }

            public Color getColorLEFT() {
                return new Color(Colors.HOVER_ATTACK.r, Colors.HOVER_ATTACK.g, Colors.HOVER_ATTACK.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TechnologyAttackModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (float)CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK / 100.0F, CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.attack, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.technology, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AttackDefenseDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 37, tempW, tempElemH, true, CFG.AI_VASSALS_CAN_DECLARE_WARS) {
            public boolean getCheckboxSt() {
                return CFG.AI_VASSALS_CAN_DECLARE_WARS;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI: " + CFG.lang.get("Vassals") + ": " + CFG.lang.get("CanDeclareWars") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.AI_VASSALS_CAN_DECLARE_WARS ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploVassal, CFG.PADD, 0));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 38 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, GameValues.gvPopulationGrowth.CREATE_NEW_GAME_MIN_POPULATION_GROWTH, GameValues.gvPopulationGrowth.CREATE_NEW_GAME_MAX_POPULATION_GROWTH, (int)(CFG.POPULATION_GROWTH_RATE * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(Colors.COLOR_POPULATION_ACTIVE.r, Colors.COLOR_POPULATION_ACTIVE.g, Colors.COLOR_POPULATION_ACTIVE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PopulationGrowth") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.POPULATION_GROWTH_RATE * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.popGrowth, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("PopulationGrowthDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 39 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, GameValues.gvEconomy.CREATE_NEW_GAME_MIN_ECONOMY_GROWTH, GameValues.gvEconomy.CREATE_NEW_GAME_MAX_ECONOMY_GROWTH, (int)(CFG.ECONOMY_GROWTH_RATE * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(Colors.COLOR_TEXT_ECONOMY_ACTIVE.r, Colors.COLOR_TEXT_ECONOMY_ACTIVE.g, Colors.COLOR_TEXT_ECONOMY_ACTIVE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("EconomyGrowthModifier") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.ECONOMY_GROWTH_RATE * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("EconomyGrowthDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 40 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 100, CFG.MOVEMENT_POINTS_EXTRA) {
            public String getDrawText() {
                return this.getTextE() + (float)this.getCurr() / 10.0F;
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_MOVEMENT.r, CFG.COLOR_MOVEMENT.g, CFG.COLOR_MOVEMENT.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Extra") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2((float)CFG.MOVEMENT_POINTS_EXTRA / 10.0F, 100), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn")));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 41 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 100, 500, (int)(CFG.MOVEMENT_POINTS_MAX_MODIFIER * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_MOVEMENT.r, CFG.COLOR_MOVEMENT.g, CFG.COLOR_MOVEMENT.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Limit") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(CFG.MOVEMENT_POINTS_MAX_MODIFIER * 100.0F, 100) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 42 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 100, CFG.DIPLOMACY_POINTS_EXTRA) {
            public String getDrawText() {
                return this.getTextE() + (float)this.getCurr() / 10.0F;
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_GRADIENT_DIPLOMACY.r, CFG.COLOR_GRADIENT_DIPLOMACY.g, CFG.COLOR_GRADIENT_DIPLOMACY.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DiplomacyPoints") + ", " + CFG.lang.get("Extra") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2((float)CFG.DIPLOMACY_POINTS_EXTRA / 10.0F, 100), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.topDiplomacyPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PerTurn")));
                nData.add(new ME_Hover_2Type_Image(Images.time, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 43, tempW, tempElemH, true, CFG.SANDBOX_MODE_AI) {
            public boolean getCheckboxSt() {
                return CFG.SANDBOX_MODE_AI;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SandboxAIDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 46 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 1000, CFG.BUILD_NUKES_EXTRA_COST / 1000) {
            public String getDrawText() {
                return this.getTextE() + "+" + CFG.getNumberWthSpaces("" + this.getCurr() * 1000);
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_NUKE.r, CFG.COLOR_NUKE.g, CFG.COLOR_NUKE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AtomicBombCost") + ", " + CFG.lang.get("Extra") + ": "));
                nData.add(new ME_Hover_2Type_Text("+" + CFG.getNumberWthSpaces("" + CFG.BUILD_NUKES_EXTRA_COST), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.nuke, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 48 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 10, GameValues.gvPlunder.CREATE_NEW_GAME_MAX, (int)(CFG.PLUNDER_MODIFIER * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_WAR_DARK.r, CFG.COLOR_WAR_DARK.g, CFG.COLOR_WAR_DARK.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Plunder") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.PLUNDER_MODIFIER * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.actPlunder, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("PlunderModifierDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 49, tempW, tempElemH, true, CFG.AI_PLUNDER_ENABLED) {
            public boolean getCheckboxSt() {
                return CFG.AI_PLUNDER_ENABLED;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI: " + CFG.lang.get("Plunder") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.AI_PLUNDER_ENABLED ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploPlunder, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 50 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 200, CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS) {
            public String getDrawText() {
                return this.getTextE() + CFG.lang.get("TurnsX", this.getCurr());
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_WAR_BRIGHT.r, CFG.COLOR_WAR_BRIGHT.g, CFG.COLOR_WAR_BRIGHT.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AWarCantBeDeclaredInFirstXTurns", CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploWar, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 51 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 10, GameValues.gvPeaceTreaty.CREATE_NEW_GAME_SLIDER_MAX_SCORE, (int)(CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_TEXT_GOLDEN_AGE.r, CFG.COLOR_TEXT_GOLDEN_AGE.g, CFG.COLOR_TEXT_GOLDEN_AGE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("PeaceTreaty") + ", " + CFG.lang.get("Score") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.victoryPoints, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 47 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 10, (int)(GameValues.gvTechnology.MAX_TECHNOLOGY_LEVEL * 100.0F), (int)(CFG.NUKES_REQUIRED_TECH_LVL * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + (float)this.getCurr() / 100.0F;
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_TEXT_CHECKBOX_FALSE.r, CFG.COLOR_TEXT_CHECKBOX_FALSE.g, CFG.COLOR_TEXT_CHECKBOX_FALSE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Nuke") + ", " + CFG.lang.get("RequiredTechnologyLevel") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2(CFG.NUKES_REQUIRED_TECH_LVL, 100), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.nuke, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 52 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 5, GameValues.gvAssimilate.CREATE_NEW_GAME_MAX_ASSIMILATE_SPEED, (int)(CFG.ASSIMILATION_SPEED_MODIFIER * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_PROVINCE_STABILITY_MAX.r, CFG.COLOR_PROVINCE_STABILITY_MAX.g, CFG.COLOR_PROVINCE_STABILITY_MAX.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Assimilate") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.ASSIMILATION_SPEED_MODIFIER * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AssimilateSpeedDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 53 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 5, GameValues.gvAssimilate.CREATE_NEW_GAME_MAX_ASSIMILATE_SPEED, (int)(CFG.ASSIMILATION_COST_MODIFIER * 100.0F)) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_PROVINCE_STABILITY_MAX.r / 2.0F, CFG.COLOR_PROVINCE_STABILITY_MAX.g, CFG.COLOR_PROVINCE_STABILITY_MAX.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (int)(CFG.ASSIMILATION_COST_MODIFIER * 100.0F) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploStability, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 54, tempW, tempElemH, true, CFG.VASSALS_CAN_DECLARE_INDEPENDENCE) {
            public boolean getCheckboxSt() {
                return CFG.VASSALS_CAN_DECLARE_INDEPENDENCE;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text("AI: " + CFG.lang.get("VassalIndependence") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.VASSALS_CAN_DECLARE_INDEPENDENCE ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploVassal, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("AIVassalsIndependenceDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 44, tempW, tempElemH, true, CFG.NUKES_MIN_YEAR_ENABLED) {
            public boolean getCheckboxSt() {
                return CFG.NUKES_MIN_YEAR_ENABLED;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MinimumYearForNukes") + ": " + GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR + ": "));
                nData.add(new ME_Hover_2Type_Text("" + (CFG.NUKES_MIN_YEAR_ENABLED ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.nuke, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 55, tempW, tempElemH, true, false) {
            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("TurnOffLeaders"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("TurnOffLeadersDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 56 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 100, CFG.COLONIZATION_AUTO_EXPAND_CHANCE) {
            public String getDrawText() {
                return this.getTextE() + this.getCurr() + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_HOVER_TITLE.r, CFG.COLOR_HOVER_TITLE.g, CFG.COLOR_HOVER_TITLE.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ColonyAutoExpansion") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.COLONIZATION_AUTO_EXPAND_CHANCE + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.editorCity, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("ColonyAutoExpansionDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 57 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 0, 1000, CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000) {
            public String getDrawText() {
                return this.getTextE() + CFG.getPrecision2((float)this.getCurr() / 10.0F, 10) + "%";
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_TEXT_NUM_OF_PROVINCES.r, CFG.COLOR_TEXT_NUM_OF_PROVINCES.g, CFG.COLOR_TEXT_NUM_OF_PROVINCES.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("SpyMessageChance") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getPrecision2((float)CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000 / 10.0F, 10) + "%", CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.spy, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SpyPreparingForWarDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("SpyPreparingForWarDesc2")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 58, tempW, tempElemH, true, CFG.LEADERS_CAN_DIE) {
            public boolean getCheckboxSt() {
                return CFG.LEADERS_CAN_DIE;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("LeadersCanDie") + ": "));
                nData.add(new ME_Hover_2Type_Text(CFG.LEADERS_CAN_DIE ? CFG.lang.get("On") : CFG.lang.get("Off"), CFG.COLOR_HOVER_TITLE));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 19, tempW, tempElemH, true, CFG.INGAME_WORLD_EDITOR) {
            public boolean getCheckboxSt() {
                return CFG.INGAME_WORLD_EDITOR;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("InGameWorldEditor"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.editorGame, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("InGameWorldEditorDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("InGameWorldEditorDesc2")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Slider_CNG("", CFG.PADD * 2, tempElemH * 45 + CFG.PADD, tempW - CFG.PADD * 4, tempElemH - CFG.PADD * 2, 1, 100, CFG.NUKES_TOP_CIVS) {
            public String getDrawText() {
                return this.getTextE() + "" + CFG.getNumberWthSpaces("" + this.getCurr());
            }

            public Color getColorLEFT() {
                return new Color(CFG.COLOR_ECONOMY_HOVER.r, CFG.COLOR_ECONOMY_HOVER.g, CFG.COLOR_ECONOMY_HOVER.b, 0.65F);
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("NukesRestrictedToTopCivilizations") + ": "));
                nData.add(new ME_Hover_2Type_Text("" + CFG.getNumberWthSpaces("" + CFG.NUKES_TOP_CIVS), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.rank, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("NuclearWeaponsCanOnlyBeBuiltByTheTopRankedCivs")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options2((String)null, CFG.PADD * 2, 0, tempElemH * 59, tempW, tempElemH, true, CFG.DISABLE_DISEASES) {
            public boolean getCheckboxSt() {
                return !CFG.DISABLE_DISEASES;
            }

            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Diseases"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.skull, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        menuElements.add(new Button_CNG_Options((String)null, CFG.PADD * 2, 0, tempElemH * 60, tempW, tempElemH, true) {
            public void buildElemHover() {
                List<MEHover_2E> nElements = new ArrayList();
                List<ME_Hover_2Type> nData = new ArrayList();
                nData.add(new ME_Hover_2Type_Text(CFG.lang.get("RemoveAllAlliances"), CFG.COLOR_HOVER_TITLE));
                nData.add(new ME_Hover_2Type_Image(Images.diploAlliance, CFG.PADD, 0));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get("RemoveAllAlliancesDesc")));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                this.menuElemHover = new ME_Hover_v2(nElements);
            }
        });
        this.initMenu(new TitleM_TextSmall((String)null, CFG.BUTTON_H * 3 / 4, false, false) {
            public void drawT(SpriteBatch oSB, int iTranslateX, int nPosX, int nPosY, int nWidth, boolean sliderMenuIsActive) {
                IMGManager.getIMG(Images.gameTopEdgeTitle).draw2O(oSB, Menu_CreateNewGame_Options2.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options2.this.getPosY() - Core.PADDING - IMGManager.getIMG(Images.gameTopEdgeTitle).getHeight() - this.getHeightT(), Menu_CreateNewGame_Options2.this.getWidthM() + 2 + Core.PADDING, this.getHeightT() + Core.PADDING, true, false);
                oSB.setColor(new Color(0.4F, 0.2F, 0.6F, 0.165F));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() + 2 - IMGManager.getIMG(Images.line32Off1).getHeight(), nWidth, this.getHeightT() - 2, false, true);
                oSB.setColor(new Color(0.4F, 0.2F, 0.6F, 0.375F));
                IMGManager.getIMG(Images.gradient).drawO(oSB, nPosX + iTranslateX, nPosY - this.getHeightT() * 2 / 3 - IMGManager.getIMG(Images.gradient).getHeight(), nWidth, this.getHeightT() * 2 / 3, false, true);
                oSB.setColor(new Color(0.011F, 0.014F, 0.019F, 0.25F));
                IMGManager.getIMG(Images.gradient).drawO(oSB, Menu_CreateNewGame_Options2.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options2.this.getPosY() - IMGManager.getIMG(Images.gradient).getHeight() - this.getHeightT() * 3 / 4, Menu_CreateNewGame_Options2.this.getWidthM(), this.getHeightT() * 3 / 4, false, true);
                oSB.setColor(CFG.COLOR_NEW_GAME_EDGE_LINE);
                IMGManager.getIMG(Images.pix255).drawO(oSB, Menu_CreateNewGame_Options2.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options2.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight(), Menu_CreateNewGame_Options2.this.getWidthM());
                oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4F));
                IMGManager.getIMG(Images.line32Off1).drawO(oSB, Menu_CreateNewGame_Options2.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options2.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight(), Menu_CreateNewGame_Options2.this.getWidthM(), 1);
                if (AoCGame.LEFT != 0) {
                    oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
                    IMGManager.getIMG(Images.pix255).draw2O(oSB, Menu_CreateNewGame_Options2.this.getPosX() + iTranslateX, Menu_CreateNewGame_Options2.this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - this.getHeightT(), 1, this.getHeightT(), true, false);
                    oSB.setColor(Color.WHITE);
                }

                oSB.setColor(Color.WHITE);
                IMGManager.getIMG(Images.editorGame).drawO(oSB, nPosX + CFG.PADD * 2 + iTranslateX, Menu_CreateNewGame_Options2.this.getPosY() - this.getHeightT() / 2 - IMGManager.getIMG(Images.editorGame).getHeight() / 2);
                Renderer.drawText(oSB, CFG.FONT_BOLD_SMALL, this.getText(), nPosX + nWidth / 2 - this.getTextWidth() / 2 + iTranslateX, nPosY - this.getHeightT() + this.getHeightT() / 2 + 1 - this.getTextHeight() / 2, CFG.COLOR_TEXT_GRAY_LEFT_NS);
            }
        }, AoCGame.LEFT, IMGManager.getIMG(Images.topBar2).getHeight() + CFG.PADD * 2 + CFG.BUTTON_H * 3 / 4, tempW, tempMaxH < tempElemH * menuElements.size() ? tempMaxH : tempElemH * menuElements.size(), menuElements);
        this.setVisibleM(false);
        this.updateLang();
    }

    public void updateLang() {
        this.getTitleM().setText(CFG.lang.get("NewGame") + ": " + CFG.lang.get("Options"));
        this.getMenuElem(0).setTextE(CFG.lang.get("MapType") + ": " + CFG.map.getMapName(CFG.map.getActiveMapIDN()));
        this.getMenuElem(1).setTextE(CFG.lang.get("ScaleOfMap"));
        this.getMenuElem(2).setTextE(CFG.lang.get("Players") + ":");
        this.getMenuElem(3).setTextE(CFG.lang.get(CFG.core.getGameScenars().getScenarioNameID(CFG.core.getScenarioID())) + " | " + CFG.core.getGameScenars().getScenarioNumOfCivs(CFG.core.getScenarioID()) + " " + CFG.lang.get("Civilizations"));
        this.getMenuElem(4).setTextE(CFG.lang.get("VictoryConditions") + ": " + CFG.lang.get("Domination"));
        this.getMenuElem(5).setTextE(CFG.lang.get("Difficulty") + ": " + CFG.getDifficultyName(CFG.DIFFICULTY));
        this.getMenuElem(6).setTextE(CFG.lang.get("Fogofwar") + ": " + CFG.getFogOfWarName(CFG.FOG_OF_WAR));
        this.getMenuElem(7).setTextE(CFG.lang.get("ManageDiplomacy"));
        this.getMenuElem(8).setTextE(CFG.lang.get("FillTheMap"));
        this.getMenuElem(9).setTextE(CFG.lang.get("RandomPlacement"));
        this.getMenuElem(10).setTextE(CFG.lang.get("RandomFill"));
        this.getMenuElem(11).setTextE(CFG.lang.get("ShuffleCivilizations"));
        this.getMenuElem(12).setTextE(CFG.lang.get("SandboxMode"));
        this.getMenuElem(13).setTextE(CFG.lang.get("EternalWar"));
        this.getMenuElem(15).setTextE(CFG.lang.get("SpectatorMode"));
        this.getMenuElem(16).setTextE(CFG.lang.get("ColonizationofWastelandProvinces"));
        this.getMenuElem(17).setTextE(CFG.lang.get("NeutralProvinces") + ": " + (GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES ? CFG.lang.get("Colonization") : CFG.lang.get("Conquering")));
        this.getMenuElem(18).setTextE(CFG.lang.get("GameSpeed") + ": ");
        this.getMenuElem(19).setTextE(CFG.lang.get("AIAggressiveness") + ": ");
        this.getMenuElem(20).setTextE(CFG.lang.get("RebelsStrength") + ": ");
        this.getMenuElem(21).setTextE(CFG.lang.get("AgeOfChaos"));
        this.getMenuElem(22).setTextE(CFG.lang.get("Turns") + ": ");
        this.getMenuElem(23).setTextE(CFG.lang.get("ArmyRetreat") + ": ");
        this.getMenuElem(24).setTextE(CFG.lang.get("UseNewAIWarDeclarationSystem"));
        this.getMenuElem(25).setTextE(CFG.lang.get("OldAIWar") + ": ");
        this.getMenuElem(26).setTextE(CFG.lang.get("EnableNuclearWeapons"));
        this.getMenuElem(27).setTextE(CFG.lang.get("MinArmy") + ": ");
        this.getMenuElem(28).setTextE(CFG.lang.get("AllianceProposalChance") + ": ");
        this.getMenuElem(29).setTextE(CFG.lang.get("AllianceProvinces") + ": ");
        this.getMenuElem(30).setTextE(CFG.lang.get("Capitulation") + ": ");
        this.getMenuElem(31).setTextE("AI: " + CFG.lang.get("Unions"));
        this.getMenuElem(32).setTextE("AI: " + CFG.lang.get("ConquerVassals"));
        this.getMenuElem(33).setTextE("AI: " + CFG.lang.get("VassalLimit") + ": ");
        this.getMenuElem(34).setTextE(CFG.lang.get("TechnologyDefenseModifier") + ": ");
        this.getMenuElem(35).setTextE(CFG.lang.get("TechnologyAttackModifier") + ": ");
        this.getMenuElem(36).setTextE("AI: " + CFG.lang.get("Vassals") + ": " + CFG.lang.get("CanDeclareWars"));
        this.getMenuElem(37).setTextE(CFG.lang.get("PopulationGrowth") + ": ");
        this.getMenuElem(38).setTextE(CFG.lang.get("EconomyGrowthModifier") + ": ");
        this.getMenuElem(39).setTextE(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Extra") + ": ");
        this.getMenuElem(40).setTextE(CFG.lang.get("MovementPoints") + ", " + CFG.lang.get("Limit") + ": ");
        this.getMenuElem(41).setTextE(CFG.lang.get("DiplomacyPoints") + ", " + CFG.lang.get("Extra") + ": ");
        this.getMenuElem(42).setTextE(CFG.lang.get("SandboxMode") + ": AI");
        this.getMenuElem(43).setTextE(CFG.lang.get("AtomicBombCost") + ": " + CFG.lang.get("Extra") + ": ");
        this.getMenuElem(44).setTextE(CFG.lang.get("Plunder") + ": ");
        this.getMenuElem(45).setTextE("AI: " + CFG.lang.get("Plunder"));
        this.getMenuElem(46).setTextE(CFG.lang.get("WarDeclarationDelay") + ": ");
        this.getMenuElem(47).setTextE(CFG.lang.get("PeaceTreaty") + ", " + CFG.lang.get("Score") + ": ");
        this.getMenuElem(48).setTextE(CFG.lang.get("Nuke") + ", " + CFG.lang.get("RequiredTechnology") + ": ");
        this.getMenuElem(49).setTextE(CFG.lang.get("Assimilate") + ": ");
        this.getMenuElem(50).setTextE(CFG.lang.get("Assimilate") + ", " + CFG.lang.get("Cost") + ": ");
        this.getMenuElem(51).setTextE(CFG.lang.get("VassalIndependence"));
        this.getMenuElem(52).setTextE(CFG.lang.get("MinimumYearForNukes") + ": " + GameValues.gvAtomic.ATOMIC_BOMB_MIN_YEAR);
        this.getMenuElem(53).setTextE(CFG.lang.get("TurnOffLeaders"));
        this.getMenuElem(54).setTextE(CFG.lang.get("ColonyAutoExpansion") + ": ");
        this.getMenuElem(55).setTextE(CFG.lang.get("SpyMessageChance") + ": ");
        this.getMenuElem(56).setTextE(CFG.lang.get("LeadersCanDie") + ": " + (CFG.LEADERS_CAN_DIE ? CFG.lang.get("On") : CFG.lang.get("Off")));
        this.getMenuElem(57).setTextE(CFG.lang.get("InGameWorldEditor") + ": " + (CFG.INGAME_WORLD_EDITOR ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")));
        this.getMenuElem(58).setTextE(CFG.lang.get("NukeAccessRestricted") + ": ");
        this.getMenuElem(59).setTextE(CFG.lang.get("Diseases") + ": " + (!CFG.DISABLE_DISEASES ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")));
        this.getMenuElem(60).setTextE(CFG.lang.get("RemoveAllAlliances"));
    }

    public void draw(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if (lTime + 125L >= System.currentTimeMillis()) {
            if (hideAnimation) {
                iTranslateX -= (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 125.0F));
            } else {
                iTranslateX += -this.getWidthM() + (int)((float)this.getWidthM() * ((float)(System.currentTimeMillis() - lTime) / 125.0F));
            }

            CFG.setRenderO(true);
        } else if (hideAnimation) {
            super.setVisibleM(false);
            return;
        }

        IMGManager.getIMG(Images.gameTopEdgeLine).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.gameTopEdgeLine).getHeight() + iTranslateY, this.getWidthM() + 2 + Core.PADDING, this.getHeightM(), true, true);
        super.draw(oSB, iTranslateX, iTranslateY, sliderMenuIsActive);
        oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + this.getHeightM(), this.getWidthM());
        oSB.setColor(new Color(CFG.COLOR_FLAG_FRAME.r, CFG.COLOR_FLAG_FRAME.g, CFG.COLOR_FLAG_FRAME.b, 0.4F));
        IMGManager.getIMG(Images.line32Off1).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() - IMGManager.getIMG(Images.line32Off1).getHeight() + this.getHeightM(), this.getWidthM(), 1);
        oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.5F));
        IMGManager.getIMG(Images.pix255).drawO(oSB, this.getPosX() + iTranslateX, this.getPosY() + this.getHeightM(), this.getWidthM() + 2);
        oSB.setColor(Color.WHITE);
        if (AoCGame.LEFT != 0) {
            oSB.setColor(CFG.COLOR_CREATE_NEW_GAME_BOX_PLAYERS);
            IMGManager.getIMG(Images.pix255).draw2O(oSB, this.getPosX() + iTranslateX, this.getPosY() - IMGManager.getIMG(Images.pix255).getHeight() + iTranslateY, 1, this.getHeightM(), true, true);
            oSB.setColor(Color.WHITE);
        }

    }

    public void drawScrollPos(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean sliderMenuIsActive) {
        if ((sliderMenuIsActive || this.getScrollModeY()) && !CFG.menus.getSliderMode()) {
            super.drawScrollPos(oSB, iTranslateX - 2, iTranslateY, sliderMenuIsActive);
        }

    }

    public static final void clickFillTheMap() {
        CFG.mapModesManager.disableAllViews();
        CFG.FILL_THE_MAP = !CFG.FILL_THE_MAP;
        CFG.core.disableDrawCivlizationsRegions_Players();
        if (CFG.FILL_THE_MAP) {
            CFG.core.getGameScenars().enableFillTheMap();
            CFG.core.setActiveProvID(CFG.core.getActiveProvID());
        } else {
            CFG.core.getGameScenars().disableFillTheMap();

            try {
                if (CFG.getActiveCivInfoId() > 0) {
                    CFG.core.setActiveProvID(CFG.core.getCiv(CFG.getActiveCivInfoId()).getCapitalProvID());
                } else {
                    CFG.core.setActiveProvID(CFG.core.getActiveProvID());
                }
            } catch (Exception var1) {
            }
        }

        CFG.core.enableDrawCivlizationsRegions_Players();
        CFG.setActiveCivInfoId(CFG.core.getProv(CFG.core.getActiveProvID()).getCivId());
        CFG.updateActiveCivInfo_CreateNewGame();
    }

    public void actionEL(int iID) {
        CFG.brushMode = false;
        switch (iID) {
            case 0:
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                CFG.backToMenu = View.eCREATE_NEW_GAME;
                CFG.menus.setMenuID(View.eSELECT_MAP_TYPE);
                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                break;
            case 1:
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                MapScale.STANDARD_SCALE = 1.0F + (float)this.getMenuElem(iID).getCurr() * 0.1F;
                CFG.map.getMpS().setCurrScale(MapScale.STANDARD_SCALE);
                CFG.map.getMpS().setScaleBeforeReset(MapScale.STANDARD_SCALE >= 3.0F ? 2.0F : (MapScale.STANDARD_SCALE > 1.0F ? 1.0F : 0.5F));
                break;
            case 2:
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                CFG.menus.setMenuID(View.eNEWGAME_PLAYERS);
                break;
            case 3:
                Menu_CreateNewGame.CHALLENGE_MODE_NG = -1;
                CFG.core.disableDrawCivlizationsRegions_Players();
                CFG.menus.setMenuID(View.eCHOOSE_SCENARIO);
                CFG.backToMenu = View.eCREATE_NEW_GAME;
                CFG.goToMenu = View.eCREATE_NEW_GAME;
                if (CFG.menus.getColorPicker().getVisible()) {
                    CFG.menus.getColorPicker().setVisible(false, (ColorPicker_AoC.PickerAction)null);
                }

                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                break;
            case 4:
                CFG.backToMenu = View.eCREATE_NEW_GAME;
                CFG.menus.setMenuID(View.eVICTORY_CONDITIONS);
                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                break;
            case 5:
                if (CFG.DIFFICULTY != this.getMenuElem(iID).getCurr() / 2) {
                    CFG.DIFFICULTY = this.getMenuElem(iID).getCurr() / 2;
                    this.getMenuElem(iID).setTextE(CFG.lang.get("Difficulty") + ": " + CFG.getDifficultyName(CFG.DIFFICULTY));
                }
                break;
            case 6:
                if (CFG.FOG_OF_WAR != this.getMenuElem(iID).getCurr() / 2) {
                    CFG.FOG_OF_WAR = this.getMenuElem(iID).getCurr() / 2;
                    this.getMenuElem(iID).setTextE(CFG.lang.get("Fogofwar") + ": " + CFG.getFogOfWarName(CFG.FOG_OF_WAR));
                }
                break;
            case 7:
                CFG.core.setActiveProvID(-1);
                CFG.menus.rebuildManageDiplomacy_Alliances();
                CFG.core.disableDrawCivlizationsRegions_Players();
                CFG.chosenAlphabetCharachter = null;
                CFG.resetManageDiplomacyIDs();
                CFG.backToMenu = View.eCREATE_NEW_GAME;
                CFG.menus.setMenuID(View.eMANAGE_DIPLOMACY);
                RenderProvince.updateDrawProvinces();
                CFG.map.getTouchMgr().ueExA();
                CFG.menus.setVisible_CreateNewGame_AddCiv(false);
                CFG.menus.setVisible_CreateNewGame_AddCiv_Gov(false);
                break;
            case 8:
                clickFillTheMap();
                break;
            case 9:
                CFG.RANDOM_PLACEMENT = !CFG.RANDOM_PLACEMENT;
                this.getMenuElem(iID).setCheckboxSt(CFG.RANDOM_PLACEMENT);
                break;
            case 10:
                CFG.RANDOM_FILL = !CFG.RANDOM_FILL;
                this.getMenuElem(iID).setCheckboxSt(CFG.RANDOM_FILL);
                break;
            case 11:
                CFG.setDialogType(DialogType.SHUFFLE_CIVILIZATIONS);
                break;
            case 12:
                CFG.SANDBOX_MODE = !CFG.SANDBOX_MODE;
                this.getMenuElem(iID).setCheckboxSt(CFG.SANDBOX_MODE);
                break;
            case 13:
                CFG.TOTAL_WARMODE = !CFG.TOTAL_WARMODE;
                this.getMenuElem(iID).setCheckboxSt(CFG.TOTAL_WARMODE);
                if (CFG.TOTAL_WARMODE) {
                    CFG.toastM.addM(CFG.lang.get("TotalWar") + " - " + CFG.lang.get("Enabled"));
                } else {
                    CFG.toastM.addM(CFG.lang.get("TotalWar") + " - " + CFG.lang.get("Disabled"));
                }
                break;
            case 14:
                CFG.menus.setVisible_CreateNewGame_Options_Pallets(true);
                break;
            case 15:
                CFG.SPECTATOR_MODE = !CFG.SPECTATOR_MODE;
                this.getMenuElem(iID).setCheckboxSt(CFG.SPECTATOR_MODE);
                break;
            case 16:
                GameCalendar.ENABLE_COLONIZATION = !GameCalendar.ENABLE_COLONIZATION;
                if (GameCalendar.ENABLE_COLONIZATION) {
                    CFG.toastM.addM(CFG.lang.get("Colonization") + " - " + CFG.lang.get("Enabled"));
                } else {
                    CFG.toastM.addM(CFG.lang.get("Colonization") + " - " + CFG.lang.get("Disabled"));
                }
                break;
            case 17:
                GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES = !GameCalendar.ENABLE_COLONIZATION_NEUTRAL_PROVINCES;
                this.updateLang();
                CFG.toastM.addM(this.getMenuElem(iID).getTextE());
                break;
            case 18:
                GameCalendar.GAME_SPEED = (float)this.getMenuElem(iID).getCurr() / 10.0F;
                break;
            case 19:
                GameCalendar.AI_AGGRESSIVENESS = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 20:
                CFG.REBELS_POWER = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 21:
                CFG.AGE_OF_CHAOS_MODE = !CFG.AGE_OF_CHAOS_MODE;
                break;
            case 22:
                CFG.AGE_OF_CHAOS_TURNS = this.getMenuElem(iID).getCurr() * 10;
                break;
            case 23:
                CFG.ARMY_RETREAT = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 24:
                CFG.USE_NEW_DECLARE_WAR_SYSTEM = !CFG.USE_NEW_DECLARE_WAR_SYSTEM;
                break;
            case 25:
                CFG.USE_OLD_DECLARE_WAR_CHANGE_100 = this.getMenuElem(iID).getCurr();
                break;
            case 26:
                CFG.ENABLE_NUKES = !CFG.ENABLE_NUKES;
                break;
            case 27:
                CFG.MIN_ARMY_REQUIRED_TO_ATTACK = this.getMenuElem(iID).getCurr();
                break;
            case 28:
                CFG.PROPOSE_ALLIANCE_CHANCE_100 = this.getMenuElem(iID).getCurr();
                break;
            case 29:
                CFG.MAX_PROVINCES_FOR_ALLIANCE_PROPOSAL = this.getMenuElem(iID).getCurr();
                break;
            case 30:
                CFG.CAPITULATION = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 31:
                CFG.AI_UNIONS_ENABLED = !CFG.AI_UNIONS_ENABLED;
                break;
            case 32:
                CFG.AI_CONQUER_VASSALS = !CFG.AI_CONQUER_VASSALS;
                break;
            case 33:
                CFG.AI_CONQUER_OWN_VASSALS_IF_OVER = this.getMenuElem(iID).getCurr();
                break;
            case 34:
                CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_DEFENSE = this.getMenuElem(iID).getCurr();
                break;
            case 35:
                CFG.TECHNOLOGY_LEVEL_BONUS_ARMY_ATTACK = this.getMenuElem(iID).getCurr();
                break;
            case 36:
                CFG.AI_VASSALS_CAN_DECLARE_WARS = !CFG.AI_VASSALS_CAN_DECLARE_WARS;
                break;
            case 37:
                CFG.POPULATION_GROWTH_RATE = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 38:
                CFG.ECONOMY_GROWTH_RATE = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 39:
                CFG.MOVEMENT_POINTS_EXTRA = this.getMenuElem(iID).getCurr();
                break;
            case 40:
                CFG.MOVEMENT_POINTS_MAX_MODIFIER = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 41:
                CFG.DIPLOMACY_POINTS_EXTRA = this.getMenuElem(iID).getCurr();
                break;
            case 42:
                CFG.SANDBOX_MODE_AI = !CFG.SANDBOX_MODE_AI;
                this.getMenuElem(iID).setCheckboxSt(CFG.SANDBOX_MODE_AI);
                break;
            case 43:
                CFG.BUILD_NUKES_EXTRA_COST = this.getMenuElem(iID).getCurr() * 1000;
                break;
            case 44:
                CFG.PLUNDER_MODIFIER = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 45:
                CFG.AI_PLUNDER_ENABLED = !CFG.AI_PLUNDER_ENABLED;
                break;
            case 46:
                CFG.WAR_CANT_BE_DECLARED_IN_FIRST_X_TURNS = this.getMenuElem(iID).getCurr();
                break;
            case 47:
                CFG.PEACE_TREATY_VICTORY_POINTS_MODIFIER = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 48:
                CFG.NUKES_REQUIRED_TECH_LVL = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 49:
                CFG.ASSIMILATION_SPEED_MODIFIER = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 50:
                CFG.ASSIMILATION_COST_MODIFIER = (float)this.getMenuElem(iID).getCurr() / 100.0F;
                break;
            case 51:
                CFG.VASSALS_CAN_DECLARE_INDEPENDENCE = !CFG.VASSALS_CAN_DECLARE_INDEPENDENCE;
                break;
            case 52:
                CFG.NUKES_MIN_YEAR_ENABLED = !CFG.NUKES_MIN_YEAR_ENABLED;
                break;
            case 53:
                this.getMenuElem(iID).setCheckboxSt(true);

                try {
                    for(int a = 1; a < CFG.core.getCivsSize(); ++a) {
                        if (CFG.core.getCiv(a).civGD.leaderData != null) {
                            CFG.core.getCiv(a).setLeaderN((LeaderOfCiv_GameData)null);
                        }
                    }
                } catch (Exception ex) {
                    CFG.exceptionStack(ex);
                }
                break;
            case 54:
                CFG.COLONIZATION_AUTO_EXPAND_CHANCE = this.getMenuElem(iID).getCurr();
                break;
            case 55:
                CFG.GET_SPY_MESSAGE_ABOUT_AI_PREPARING_FOR_WAR_CHANCE_1000 = this.getMenuElem(iID).getCurr();
                break;
            case 56:
                CFG.LEADERS_CAN_DIE = !CFG.LEADERS_CAN_DIE;
                this.getMenuElem(56).setTextE(CFG.lang.get("LeadersCanDie") + ": " + (CFG.LEADERS_CAN_DIE ? CFG.lang.get("On") : CFG.lang.get("Off")));
                break;
            case 57:
                CFG.INGAME_WORLD_EDITOR = !CFG.INGAME_WORLD_EDITOR;
                this.getMenuElem(iID).setCheckboxSt(CFG.INGAME_WORLD_EDITOR);
                this.getMenuElem(57).setTextE(CFG.lang.get("InGameWorldEditor") + ": " + (CFG.INGAME_WORLD_EDITOR ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")));
                break;
            case 58:
                CFG.NUKES_TOP_CIVS = this.getMenuElem(iID).getCurr();
                break;
            case 59:
                CFG.DISABLE_DISEASES = !CFG.DISABLE_DISEASES;
                this.getMenuElem(iID).setCheckboxSt(CFG.DISABLE_DISEASES);
                this.getMenuElem(59).setTextE(CFG.lang.get("Diseases") + ": " + (!CFG.DISABLE_DISEASES ? CFG.lang.get("Enabled") : CFG.lang.get("Disabled")));
                break;
            case 60:
                CFG.core.lAlliances.clear();
                CFG.core.iAlliancesSize = 0;
                CFG.core.buildAlliances();

                for(int i = 1; i < CFG.core.getCivsSize(); ++i) {
                    CFG.core.getCiv(i).setAlliance(0);
                }

                CFG.toastM.addM(CFG.lang.get("Done"), CFG.COLOR_POSITIVE);
        }

    }

    public void setVisibleM(boolean visible) {
        if (visible) {
            super.setVisibleM(true);
            this.setHideAnimation(false);
        } else {
            this.setHideAnimation(true);
        }

    }

    public final void setHideAnimation(boolean nHideAnimation) {
        if (nHideAnimation != hideAnimation) {
            if (lTime > System.currentTimeMillis() - 125L) {
                lTime = System.currentTimeMillis() - (125L - (System.currentTimeMillis() - lTime));
            } else {
                lTime = System.currentTimeMillis();
            }

            CFG.setRenderO(true);
        }

        hideAnimation = nHideAnimation;
    }
}
