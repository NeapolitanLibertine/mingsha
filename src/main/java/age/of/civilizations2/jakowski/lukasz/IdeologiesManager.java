//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.*;
import age.of.civilizations2.jakowski.lukasz.Z_Other.ST.sUM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;
import java.util.List;

public class IdeologiesManager {
    public static int MAX_CROWN_WIDTH = 0;
    public int REBELS_ID = 0;
    private List<Ideology> lIdeologies = null;

    public IdeologiesManager() {
    }

    public static final int getChangeGovernmentCost(int nCivID) {
        return (int) ((float) CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvGovernment.CHANGE_GOV_BASE_COST_MULTIPLIER + GameValues.gvGovernment.CHANGE_GOV_TECH_LEVEL_COST_MULTIPLIER * CFG.core.getCiv(nCivID).getTechLevel() + GameValues.gvGovernment.CHANGE_GOV_PROVINCE_COST_MULTIPLIER * (float) Math.min(CFG.core.getCiv(nCivID).getNumOfProvs(), GameValues.gvGovernment.CHANGE_GOV_MAX_PROVINCES_FOR_COST)));
    }

    public static final int getChangeReligionCost(int nCivID) {
        return (int) ((float) CFG.core.getGameScenars().getScenario_StartingPopulation() * (GameValues.gvGovernment.CHANGE_GOV_BASE_COST_MULTIPLIER + GameValues.gvGovernment.CHANGE_GOV_TECH_LEVEL_COST_MULTIPLIER * CFG.core.getCiv(nCivID).getTechLevel() + GameValues.gvGovernment.CHANGE_GOV_PROVINCE_COST_MULTIPLIER * (float) Math.min(CFG.core.getCiv(nCivID).getNumOfProvs(), GameValues.gvGovernment.CHANGE_GOV_MAX_PROVINCES_FOR_COST)) * GameValues.gvGovernment.CHANGE_RELIGION_COST_MODIFIER);
    }

    public final void loadIdeologies() {
        if (this.lIdeologies != null) {
            this.lIdeologies.clear();
        }

        this.lIdeologies = new ArrayList();

        try {
            FileHandle fileList = null;
            if (CFG.getIsDesktop()) {
                for (int i = 0; i < sUM.sUFS; ++i) {
                    if (FileManager.IS_MAC) {
                        if (Gdx.files.external(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) {
                            fileList = Gdx.files.absolute(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                            break;
                        }
                    } else if (Gdx.files.internal(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) {
                        fileList = Gdx.files.absolute(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                        break;
                    }
                }

                for (int i = 0; i < sUM.sUII.size(); ++i) {
                    if (Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json").exists()) {
                        fileList = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json");
                        break;
                    }
                }
            }

            if (fileList == null) {
                fileList = FileManager.loadFile("game/Governments.json");
            }

            String fileContent = fileList.readString();
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
            new ConfigIdeologiesData();
            ConfigIdeologiesData data = json.fromJson(ConfigIdeologiesData.class, fileContent);
            for (Object e : data.Government) {
                Data_Ideologies tempData = (Data_Ideologies) e;
                String desc;
                if (tempData.DESC.isEmpty() && tempData.TEXT.isEmpty()) {
                    desc = "";
                } else if (tempData.DESC.isEmpty()) {
                    desc = tempData.TEXT;
                } else {
                    desc = tempData.DESC;
                }
                this.lIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, desc));
                this.lIdeologies.get(this.lIdeologies.size() - 1).Image = tempData.Image;
            }
        } catch (GdxRuntimeException var15) {
        }

        try {
            for (int i = 0; i < sUM.sUFS; ++i) {
                if (FileManager.IS_MAC) {
                    if (Gdx.files.external(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) {
                        FileHandle fileList = null;
                        fileList = Gdx.files.external(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                        String fileContent = fileList.readString();
                        Json json = new Json();
                        json.setIgnoreUnknownFields(true);
                        json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
                        new ConfigIdeologiesData();
                        ConfigIdeologiesData var40 = json.fromJson(ConfigIdeologiesData.class, fileContent);

                        for (Object e : var40.Government) {
                            Data_Ideologies tempData = (Data_Ideologies) e;
                            String desc;
                            if (tempData.DESC.isEmpty() && tempData.TEXT.isEmpty()) {
                                desc = "";
                            } else if (tempData.DESC.isEmpty()) {
                                desc = tempData.TEXT;
                            } else {
                                desc = tempData.DESC;
                            }
                            String tempTag = !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "";
                            boolean add = true;

                            for (int z = this.lIdeologies.size() - 1; z >= 0; --z) {
                                if (this.lIdeologies.get(z).extraTag.equals(tempTag)) {
                                    add = false;
                                    break;
                                }
                            }

                            if (add) {
                                this.lIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, desc));
                                this.lIdeologies.get(this.lIdeologies.size() - 1).Image = tempData.Image;
                            }
                        }
                    }
                } else if (Gdx.files.internal(sUM.sUF.get(i) + "game/" + "Governments" + ".json").exists()) {
                    FileHandle fileList = null;
                    fileList = Gdx.files.internal(sUM.sUF.get(i) + "game/" + "Governments" + ".json");
                    String fileContent = fileList.readString();
                    Json json = new Json();
                    json.setIgnoreUnknownFields(true);
                    json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
                    new ConfigIdeologiesData();
                    ConfigIdeologiesData var39 = json.fromJson(ConfigIdeologiesData.class, fileContent);

                    for (Object e : var39.Government) {
                        Data_Ideologies tempData = (Data_Ideologies) e;
                        String desc;
                        if (tempData.DESC.isEmpty() && tempData.TEXT.isEmpty()) {
                            desc = "";
                        } else if (tempData.DESC.isEmpty()) {
                            desc = tempData.TEXT;
                        } else {
                            desc = tempData.DESC;
                        }
                        String tempTag = !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "";
                        boolean add = true;

                        for (int z = this.lIdeologies.size() - 1; z >= 0; --z) {
                            if (this.lIdeologies.get(z).extraTag.equals(tempTag)) {
                                add = false;
                                break;
                            }
                        }

                        if (add) {
                            this.lIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, desc));
                            this.lIdeologies.get(this.lIdeologies.size() - 1).Image = tempData.Image;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            for (int i = 0; i < sUM.sUII.size(); ++i) {
                if (Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json").exists()) {
                    FileHandle fileList = null;
                    fileList = Gdx.files.absolute(sUM.sUII.get(i).getFolder() + "/" + "game/" + "Governments" + ".json");
                    String fileContent = fileList.readString();
                    Json json = new Json();
                    json.setIgnoreUnknownFields(true);
                    json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
                    new ConfigIdeologiesData();
                    ConfigIdeologiesData var41 = json.fromJson(ConfigIdeologiesData.class, fileContent);

                    for (Object e : var41.Government) {
                        Data_Ideologies tempData = (Data_Ideologies) e;
                        String desc;
                        if (tempData.DESC.isEmpty() && tempData.TEXT.isEmpty()) {
                            desc = "";
                        } else if (tempData.DESC.isEmpty()) {
                            desc = tempData.TEXT;
                        } else {
                            desc = tempData.DESC;
                        }
                        String tempTag = !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "";
                        boolean add = true;

                        for (int z = this.lIdeologies.size() - 1; z >= 0; --z) {
                            if (this.lIdeologies.get(z).extraTag.equals(tempTag)) {
                                add = false;
                                break;
                            }
                        }

                        if (add) {
                            this.lIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, desc));
                            this.lIdeologies.get(this.lIdeologies.size() - 1).Image = tempData.Image;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            FileHandle fileList = null;
            fileList = Gdx.files.internal("game/Governments.json");
            String fileContent = fileList.readString();
            Json json = new Json();
            json.setIgnoreUnknownFields(true);
            json.setElementType(ConfigIdeologiesData.class, "Government", Data_Ideologies.class);
            new ConfigIdeologiesData();
            ConfigIdeologiesData var38 = json.fromJson(ConfigIdeologiesData.class, fileContent);

            for (Object e : var38.Government) {
                Data_Ideologies tempData = (Data_Ideologies) e;
                String desc;
                if (tempData.DESC.isEmpty() && tempData.TEXT.isEmpty()) {
                    desc = "";
                } else if (tempData.DESC.isEmpty()) {
                    desc = tempData.TEXT;
                } else {
                    desc = tempData.DESC;
                }
                String tempTag = !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "";
                boolean add = true;

                for (int z = this.lIdeologies.size() - 1; z >= 0; --z) {
                    if (this.lIdeologies.get(z).extraTag.equals(tempTag)) {
                        add = false;
                        break;
                    }
                }

                if (add) {
                    this.lIdeologies.add(new Ideology(CFG.lang.get(tempData.Name), !tempData.Extra_Tag.isEmpty() ? "_" + tempData.Extra_Tag : "", tempData.R, tempData.G, tempData.B, tempData.MIN_GOODS, tempData.MIN_INVESTMENTS, tempData.COST_OF_MOVE, tempData.COST_OF_MOVE_TO_THE_SAME_PROV, tempData.COST_OF_MOVE_OWN_PROV, tempData.RESEARCH_COST, tempData.ACCEPTABLE_TAXATION, tempData.DEFENSE_BONUS, tempData.MILITARY_UPKEEP, tempData.ADMINISTRATION_COST, tempData.ADMINISTRATION_COST_DISTANCE, tempData.INCOME_TAXATION, tempData.INCOME_PRODUCTION, tempData.COST_OF_RECRUIT, tempData.COST_OF_DISBAND, tempData.COST_OF_PLUNDER, tempData.CAN_BECOME_CIVILIZED, tempData.AVAILABLE_SINCE_AGE_ID, tempData.ADMINISTRATION_COST_CAPITAL, tempData.CIVILIZE_TECH_LEVEL, tempData.AI_TYPE, tempData.REVOLUTIONARY, tempData.GOV_GROUP_ID, desc));
                    this.lIdeologies.get(this.lIdeologies.size() - 1).Image = tempData.Image;
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        for (int i = 0; i < this.getIdeologiesSize(); ++i) {
            if (this.getIdeologyID(i).REVOLUTIONARY) {
                this.REBELS_ID = i;
                break;
            }
        }

        for (int i = 0; i < this.getIdeologiesSize(); ++i) {
            if (this.getIdeologyID(i).getCrownImageScaled().getWidth() > MAX_CROWN_WIDTH) {
                MAX_CROWN_WIDTH = this.getIdeologyID(i).getCrownImageScaled().getWidth();
            }
        }

    }

    public final String getRealTag(String sIn) {
        try {
            if (sIn.indexOf(95) > 0) {
                return sIn.substring(0, sIn.indexOf(95));
            }
        } catch (IndexOutOfBoundsException var3) {
        }

        return sIn;
    }

    public final int getIdeologyID(String nCivTag) {
        try {
            int lastUnderscore = nCivTag.lastIndexOf(95);
            if (lastUnderscore > 0 && lastUnderscore + 1 < nCivTag.length()) {
                String ideologyTag = nCivTag.substring(lastUnderscore);

                for (int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
                    if (ideologyTag.equals(CFG.ideologiesMgr.getIdeologyID(i).getExtraTag())) {
                        return i;
                    }
                }
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        return 0;
    }

    public final ME_Hover_v2 getIdeologyHover(int nCivID) {
        List<MEHover_2E> nElements = new ArrayList();
        List<ME_Hover_2Type> nData = new ArrayList();
        nData.add(new ME_Hover_2Type_Image(this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getImageID()));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Flag_Big(nCivID));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Government") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getName(), this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getColor()));
        nData.add(new ME_Hover_2Type_Ideology_Big(CFG.core.getCiv(nCivID).getIdeology(), CFG.PADD, this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).CAN_BECOME_CIVILIZED >= 0 ? CFG.PADD : 0));
        if (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).CAN_BECOME_CIVILIZED >= 0) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Uncivilized").toUpperCase(), CFG.COLOR_NEGATIVE_2));
        }

        nElements.add(new MEHover_2E(nData));
        nData.clear();

        try {
            if (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).DESC != null && !this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).DESC.isEmpty()) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get(this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).DESC)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        } catch (Exception var5) {
        }

        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
        nData.add(new ME_Hover_2Type_Text((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).ACCEPTABLE_TAXATION * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
        nData.add(new ME_Hover_2Type_Text((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).getMin_Goods(nCivID) * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
        nData.add(new ME_Hover_2Type_Text((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).MIN_INVESTMENTS * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_TAXATION != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_TAXATION * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_TAXATION * 100.0F) - 100) + "%", (int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_TAXATION * 100.0F) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        if (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_PRODUCTION != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_PRODUCTION * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_PRODUCTION * 100.0F) - 100) + "%", (int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).INCOME_PRODUCTION * 100.0F) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        if (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).ADMINISTRATION_COST != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).ADMINISTRATION_COST * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).ADMINISTRATION_COST * 100.0F) - 100) + "%", (int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).ADMINISTRATION_COST * 100.0F) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        if (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).RESEARCH_COST != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).RESEARCH_COST * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).RESEARCH_COST * 100.0F) - 100) + "%", (int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).RESEARCH_COST * 100.0F) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfMove") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float) this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).COST_OF_MOVE / 10.0F, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfRecruit") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float) this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).COST_OF_RECRUIT / 10.0F, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).MILITARY_UPKEEP != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).MILITARY_UPKEEP * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).MILITARY_UPKEEP * 100.0F) - 100) + "%", (int) (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).MILITARY_UPKEEP * 100.0F) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
        nData.add(new ME_Hover_2Type_Text((this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).DEFENSE_BONUS > 0 ? "+" : "") + this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).DEFENSE_BONUS + "%", this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).DEFENSE_BONUS > 0 ? CFG.COLOR_POSITIVE : (this.getIdeologyID(CFG.core.getCiv(nCivID).getIdeology()).DEFENSE_BONUS == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }

    public final ME_Hover_v2 getIdeologyHover_Just(int nIdeologyID) {
        List<MEHover_2E> nElements = new ArrayList();
        List<ME_Hover_2Type> nData = new ArrayList();
        nData.add(new ME_Hover_2Type_Image(this.getIdeologyID(nIdeologyID).getImageID()));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Government") + ": ", CFG.COLOR_TEXT_NUM_OF_PROVINCES));
        nData.add(new ME_Hover_2Type_Text_Big(this.getIdeologyID(nIdeologyID).getName(), this.getIdeologyID(nIdeologyID).getColor()));
        nData.add(new ME_Hover_2Type_Ideology_Big(nIdeologyID, CFG.PADD, this.getIdeologyID(nIdeologyID).CAN_BECOME_CIVILIZED >= 0 ? CFG.PADD : 0));
        if (this.getIdeologyID(nIdeologyID).CAN_BECOME_CIVILIZED >= 0) {
            nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("Uncivilized").toUpperCase(), CFG.COLOR_NEGATIVE_2));
        }

        nElements.add(new MEHover_2E(nData));
        nData.clear();

        try {
            if (this.getIdeologyID(nIdeologyID).DESC != null && !this.getIdeologyID(nIdeologyID).DESC.isEmpty()) {
                nData.add(new ME_Hover_2Type_Space());
                nElements.add(new MEHover_2E(nData));
                nData.clear();
                nData.add(new ME_Hover_2Type_TextDesc(CFG.lang.get(this.getIdeologyID(nIdeologyID).DESC)));
                nElements.add(new MEHover_2E(nData));
                nData.clear();
            }
        } catch (Exception var5) {
        }

        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
        nData.add(new ME_Hover_2Type_Text((int) (this.getIdeologyID(nIdeologyID).ACCEPTABLE_TAXATION * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
        nData.add(new ME_Hover_2Type_Text((int) (this.getIdeologyID(nIdeologyID).getMin_Goods() * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
        nData.add(new ME_Hover_2Type_Text((int) (this.getIdeologyID(nIdeologyID).MIN_INVESTMENTS * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
        nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID(nIdeologyID).INCOME_TAXATION != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeTaxation") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(nIdeologyID).INCOME_TAXATION * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(nIdeologyID).INCOME_TAXATION * 100.0F) - 100) + "%", (int) (this.getIdeologyID(nIdeologyID).INCOME_TAXATION * 100.0F) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        if (this.getIdeologyID(nIdeologyID).INCOME_PRODUCTION != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(nIdeologyID).INCOME_PRODUCTION * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(nIdeologyID).INCOME_PRODUCTION * 100.0F) - 100) + "%", (int) (this.getIdeologyID(nIdeologyID).INCOME_PRODUCTION * 100.0F) - 100 > 0 ? CFG.COLOR_POSITIVE : CFG.COLOR_NEGATIVE_2));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        if (this.getIdeologyID(nIdeologyID).ADMINISTRATION_COST != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(nIdeologyID).ADMINISTRATION_COST * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(nIdeologyID).ADMINISTRATION_COST * 100.0F) - 100) + "%", (int) (this.getIdeologyID(nIdeologyID).ADMINISTRATION_COST * 100.0F) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        if (this.getIdeologyID(nIdeologyID).RESEARCH_COST != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(nIdeologyID).RESEARCH_COST * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(nIdeologyID).RESEARCH_COST * 100.0F) - 100) + "%", (int) (this.getIdeologyID(nIdeologyID).RESEARCH_COST * 100.0F) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfMove") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float) this.getIdeologyID(nIdeologyID).COST_OF_MOVE / 10.0F, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("CostOfRecruit") + ": "));
        nData.add(new ME_Hover_2Type_Text("" + (float) this.getIdeologyID(nIdeologyID).COST_OF_RECRUIT / 10.0F, CFG.COLOR_MOVEMENT));
        nData.add(new ME_Hover_2Type_Image(Images.topMovementPoints, CFG.PADD, 0));
        nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        if (this.getIdeologyID(nIdeologyID).MILITARY_UPKEEP != 1.0F) {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text(((int) (this.getIdeologyID(nIdeologyID).MILITARY_UPKEEP * 100.0F) - 100 > 0 ? "+" : "") + ((int) (this.getIdeologyID(nIdeologyID).MILITARY_UPKEEP * 100.0F) - 100) + "%", (int) (this.getIdeologyID(nIdeologyID).MILITARY_UPKEEP * 100.0F) - 100 > 0 ? CFG.COLOR_NEGATIVE_2 : CFG.COLOR_POSITIVE));
            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        }

        nData.add(new ME_Hover_2Type_Text(CFG.lang.get("DefenseBonus") + ": "));
        nData.add(new ME_Hover_2Type_Text((this.getIdeologyID(nIdeologyID).DEFENSE_BONUS > 0 ? "+" : "") + this.getIdeologyID(nIdeologyID).DEFENSE_BONUS + "%", this.getIdeologyID(nIdeologyID).DEFENSE_BONUS > 0 ? CFG.COLOR_POSITIVE : (this.getIdeologyID(nIdeologyID).DEFENSE_BONUS == 0 ? CFG.COLOR_NEUTRAL : CFG.COLOR_NEGATIVE_2)));
        nData.add(new ME_Hover_2Type_Image(Images.defense, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        return new ME_Hover_v2(nElements);
    }

    public float getAcceptableTaxation(int ideologyID, int civID) {
        return Math.max(0.01F, this.getIdeologyID(ideologyID).ACCEPTABLE_TAXATION + CFG.religionManager.getReligion(CFG.core.getCiv(civID).getReligionID()).ACCEPTABLE_TAXATION + GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[CFG.core.getCiv(civID).civGD.policyID] + (CFG.core.getCiv(civID).civGD.nationalBankBuilt ? GameValues.gvIncome.BANK_ACCEPTABLE_TAXATION : 0.0F) + CFG.gameAction.modifierAcceptableTaxation_CivID(civID));
    }

    public float getInvestments(int ideologyID, int civID) {
        return Math.max(0.01F, this.getIdeologyID(ideologyID).MIN_INVESTMENTS + CFG.religionManager.getReligion(CFG.core.getCiv(civID).getReligionID()).MIN_INVESTMENTS + GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[CFG.core.getCiv(civID).civGD.policyID]);
    }

    public float getResearch(int ideologyID, int civID) {
        return this.getIdeologyID(ideologyID).RESEARCH_COST + CFG.religionManager.getReligion(CFG.core.getCiv(civID).getReligionID()).RESEARCH_COST + GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[CFG.core.getCiv(civID).civGD.policyID];
    }

    public float getAdministration(int ideologyID, int civID) {
        return this.getIdeologyID(ideologyID).ADMINISTRATION_COST + GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[CFG.core.getCiv(civID).civGD.policyID];
    }

    public float getIncomeProduction(int ideologyID, int civID) {
        return this.getIdeologyID(ideologyID).INCOME_PRODUCTION + GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[CFG.core.getCiv(civID).civGD.policyID];
    }

    public float getMilitaryUpkeep(int ideologyID, int civID) {
        return this.getIdeologyID(ideologyID).MILITARY_UPKEEP + CFG.religionManager.getReligion(CFG.core.getCiv(civID).getReligionID()).MILITARY_UPKEEP + GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[CFG.core.getCiv(civID).civGD.policyID];
    }

    public int getChangeAdministrationPolicyCost(int civID) {
        return (int) ((float) CFG.core.getCiv(civID).incomeTaxation * GameValues.gvAdministrationPolicy.CHANGE_COST_INCOME_TAXATION_PERC + (float) CFG.core.getCiv(civID).incomeProduction * GameValues.gvAdministrationPolicy.CHANGE_COST_INCOME_PRODUCTION_PERC);
    }

    public final ME_Hover_v2 getHover_AdministrationPolicy(int policyID, int civID) {
        List<MEHover_2E> nElements = new ArrayList();
        List<ME_Hover_2Type> nData = new ArrayList();
        if (civID > 0) {
            nData.add(new ME_Hover_2Type_Flag_Big(civID, 0, CFG.PADD));
        }

        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get("AdministrationPolicy") + ": "));
        nData.add(new ME_Hover_2Type_Text_Big(CFG.lang.get(GameValues.gvAdministrationPolicy.POLICY_NAME[policyID]), CFG.COLOR_HOVER_TITLE));
        nData.add(new ME_Hover_2Type_Image_Big(Images.gov, CFG.PADD, 0));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        nData.add(new ME_Hover_2Type_Space());
        nElements.add(new MEHover_2E(nData));
        nData.clear();

        try {
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AcceptableTaxation") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[policyID] > 0.0F ? "+" : "") + (int) (GameValues.gvAdministrationPolicy.POLICY_ACCEPTABLE_TAXATION[policyID] * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.topGold(), CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Goods") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_MIN_GOODS[policyID] > 0.0F ? "+" : "") + (int) (GameValues.gvAdministrationPolicy.POLICY_MIN_GOODS[policyID] * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.goods, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("Investments") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[policyID] > 0.0F ? "+" : "") + (int) (GameValues.gvAdministrationPolicy.POLICY_MIN_INVESTMENTS[policyID] * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.development, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("ResearchCost") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[policyID] > 0.0F ? "+" : "") + (int) (GameValues.gvAdministrationPolicy.POLICY_RESEARCH_COST[policyID] * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.research, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("AdministrationCost") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[policyID] > 0.0F ? "+" : "") + (int) (GameValues.gvAdministrationPolicy.POLICY_ADMINISTRATION_COST[policyID] * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.administration, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("IncomeProduction") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[policyID] > 0.0F ? "+" : "") + (int) (GameValues.gvAdministrationPolicy.POLICY_INCOME_PRODUCTION[policyID] * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.economy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
            nData.add(new ME_Hover_2Type_Text(CFG.lang.get("MilitaryUpkeep") + ": "));
            nData.add(new ME_Hover_2Type_Text((GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[policyID] > 0.0F ? "+" : "") + (int) (GameValues.gvAdministrationPolicy.POLICY_MILITARY_UPKEEP[policyID] * 100.0F) + "%", CFG.COLOR_NEUTRAL2));
            nData.add(new ME_Hover_2Type_Image(Images.diploArmy, CFG.PADD, 0));
            nElements.add(new MEHover_2E(nData));
            nData.clear();
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        return new ME_Hover_v2(nElements);
    }

    public boolean canBeAdded(int nCivID, int nIdeologyID) {
        String tTag = CFG.ideologiesMgr.getRealTag(CFG.core.getCiv(nCivID).getCivTag()) + CFG.ideologiesMgr.getIdeologyID(nIdeologyID).getExtraTag();

        for (int i = 0; i < CFG.core.getCivsSize(); ++i) {
            if (CFG.core.getCiv(i).getCivTag().equals(tTag)) {
                return false;
            }

            for (int j = 0; j < CFG.core.getCiv(i).getTagsCanFormCSize(); ++j) {
                if (CFG.core.getCiv(i).getTagsCanFormC(j).equals(tTag)) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<Boolean> canChangeToIdeology(int nCivID) {
        List<Boolean> out = new ArrayList();

        for (int i = 0; i < this.getIdeologiesSize(); ++i) {
            if (i == CFG.core.getCiv(nCivID).getIdeology()) {
                out.add(false);
            } else if (GameCalendar.CURRENT_AGEID < CFG.ideologiesMgr.getIdeologyID(i).AVAILABLE_SINCE_AGE_ID) {
                out.add(false);
            } else if (!this.canBeAdded(nCivID, i)) {
                out.add(false);
            } else if (i == this.REBELS_ID) {
                out.add(false);
            } else {
                out.add(true);
            }
        }

        return out;
    }

    public List<Boolean> canChangeToIdeology_All() {
        List<Boolean> out = new ArrayList();

        for (int i = 0; i < this.getIdeologiesSize(); ++i) {
            out.add(true);
        }

        return out;
    }

    public final int getIdeologiesSize() {
        return this.lIdeologies.size();
    }

    public final Ideology getIdeologyID(int i) {
        return this.lIdeologies.get(i);
    }

    public static class ConfigIdeologiesData {
        public String Age_of_Civilizations;
        public ArrayList Government;

        public ConfigIdeologiesData() {
        }
    }

    public static class Data_Ideologies {
        public String Name;
        public String Extra_Tag;
        public String Image;
        public int GOV_GROUP_ID;
        public float ACCEPTABLE_TAXATION;
        public float MIN_GOODS;
        public float MIN_INVESTMENTS;
        public float RESEARCH_COST;
        public int COST_OF_MOVE;
        public int COST_OF_MOVE_TO_THE_SAME_PROV;
        public int COST_OF_MOVE_OWN_PROV;
        public int COST_OF_RECRUIT;
        public int COST_OF_DISBAND;
        public int COST_OF_PLUNDER;
        public int DEFENSE_BONUS;
        public float MILITARY_UPKEEP;
        public float ADMINISTRATION_COST;
        public float ADMINISTRATION_COST_DISTANCE;
        public float ADMINISTRATION_COST_CAPITAL;
        public float INCOME_TAXATION;
        public float INCOME_PRODUCTION;
        public int CAN_BECOME_CIVILIZED;
        public float CIVILIZE_TECH_LEVEL;
        public int AVAILABLE_SINCE_AGE_ID;
        public boolean REVOLUTIONARY;
        public String DESC = "";
        // Zetvl Ideology desc
        public String TEXT = "";
        public String AI_TYPE;
        public int R;
        public int G;
        public int B;

        public Data_Ideologies() {

        }
    }
}
