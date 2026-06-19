//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import team.rainfall.finality.FinalityLogger;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TerrainTypesManager {
    private List<String> lNames;
    private List<String> lTerrainTags;
    private List<Color> lColors;
    private List<Image> lTerrainIcons;
    private List<Float> lDefense;
    private List<Float> lMilitaryUpkeep;
    private List<Float> lPopulationGrowth;
    private List<Float> lEconomyGrowth;
    private List<Float> lBuildCost;
    private List<Float> lMovementCost;
    private List<Float> lBaseDevelopment;
    private List<Integer> lBaseProvinceValue;
    private int iTerrainTypesSize;

    public TerrainTypesManager() {
        this.loadTerrainTypes();
    }

    public final void loadTerrainTypes() {
        if (this.lTerrainIcons != null) {
            int i = 0;

            while(i < this.lTerrainIcons.size()) {
                ((Image)this.lTerrainIcons.get(i)).getTexture().dispose();
                this.lTerrainIcons.remove(i);
            }
        }

        this.lNames = new ArrayList();
        this.lTerrainTags = new ArrayList();
        this.lTerrainIcons = new ArrayList();
        this.lColors = new ArrayList();
        this.lDefense = new ArrayList();
        this.lMilitaryUpkeep = new ArrayList();
        this.lPopulationGrowth = new ArrayList();
        this.lEconomyGrowth = new ArrayList();
        this.lBuildCost = new ArrayList();
        this.lMovementCost = new ArrayList();
        this.lBaseDevelopment = new ArrayList();
        this.lBaseProvinceValue = new ArrayList();

        try {
            FileHandle tempFileT = FileManager.loadFile("game/terrain_types/Age_of_Civilizations");
            String tempT = tempFileT.readString();
            String[] tagsSPLITED = tempT.split(";");
            this.iTerrainTypesSize = tagsSPLITED.length;
            this.addSea();

            for(int i = 0; i < this.iTerrainTypesSize; ++i) {
                FileHandle fileData = FileManager.loadFile("game/terrain_types/" + tagsSPLITED[i]);
                Terrain_GameData3 tempData = null;
                // Zetvl Terrain
                try {
                    if (tagsSPLITED[i].endsWith(".json")) {
                        Json json = new Json();
                        tempData = json.fromJson(Terrain_GameData3.class, fileData);
                    }
                }catch (Exception e){
                    FinalityLogger.error("Failed to parse Zetvl terrain because ",e);
                }
                try {
                    if (tempData == null) {
                        tempData = (Terrain_GameData3) CFG.deserialize(fileData.readBytes());
                    }
                    this.lNames.add(CFG.lang.get(tempData.getName()));
                    this.lTerrainTags.add(tagsSPLITED[i]);
                    this.lColors.add(new Color(tempData.getColor().getR(), tempData.getColor().getG(), tempData.getColor().getB(), 0.55F));
                    this.lDefense.add(tempData.getDefensiveModifier());
                    this.lMilitaryUpkeep.add(tempData.getMilitaryUpkeepModifier());
                    this.lPopulationGrowth.add(tempData.getPopulationGrowthModifier());
                    this.lEconomyGrowth.add(tempData.getEconomyGrowthModifier());
                    this.lBuildCost.add(tempData.getBuildCostModifier());
                    this.lMovementCost.add(tempData.getMovementCost());
                    this.lBaseDevelopment.add(tempData.getBaseDevelopmentLevel());
                    this.lBaseProvinceValue.add(tempData.getBaseProvinceValue());

                    try {
                        this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + tempData.getIconName() + ".png"), Format.RGBA8888, true), TextureFilter.Linear));
                    } catch (GdxRuntimeException var8) {
                        this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + "notfound.png"), Format.RGBA8888, true), TextureFilter.Linear));
                    }
                } catch (ClassNotFoundException var9) {
                } catch (IOException var10) {
                }
            }

            Object var13 = null;
        } catch (GdxRuntimeException var11) {
        }

        this.iTerrainTypesSize = this.lNames.size();
    }

    private void addSea() {
        this.lNames.add(CFG.lang.get("Sea"));
        this.lTerrainTags.add("");
        this.lColors.add(new Color(1.0F, 1.0F, 1.0F, 0.0F));
        this.lDefense.add(0.0F);
        this.lMilitaryUpkeep.add(0.08F);
        this.lPopulationGrowth.add(0.0F);
        this.lEconomyGrowth.add(0.0F);
        this.lBuildCost.add(0.0F);
        this.lMovementCost.add(0.0F);
        this.lBaseDevelopment.add(0.0F);
        this.lBaseProvinceValue.add(0);

        try {
            this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + "sea.png"), Format.RGBA8888, true), TextureFilter.Linear));
        } catch (GdxRuntimeException var2) {
            this.lTerrainIcons.add(new Image(new Texture(FileManager.loadFile("UI/" + CFG.getResPath() + "terrain/" + "notfound.png"), Format.RGBA8888, true), TextureFilter.Linear));
        }

    }

    public final int getTerrainTypeID(String sTag) {
        for(int i = 1; i < this.iTerrainTypesSize; ++i) {
            if (this.getTag(i).equals(sTag)) {
                return i;
            }
        }

        return 1;
    }

    public final void saveTerrainData() {
        OutputStream os = null;

        try {
            FileHandle fileData = FileManager.getSaveType("game/terrain_types/" + CFG.EDITOR_ACTIVE_GAMEDATA_TAG);
            fileData.writeBytes(CFG.serialize(CFG.editorTerrain_Data2), false);

            try {
                FileHandle file = FileManager.loadFile("game/terrain_types/Age_of_Civilizations");
                String tempTags = file.readString();
                if (!tempTags.contains(CFG.EDITOR_ACTIVE_GAMEDATA_TAG)) {
                    FileHandle fileSave = FileManager.getSaveType("game/terrain_types/Age_of_Civilizations");
                    fileSave.writeString(tempTags + CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
                }
            } catch (GdxRuntimeException var15) {
                FileHandle fileSave = FileManager.getSaveType("game/terrain_types/Age_of_Civilizations");
                fileSave.writeString(CFG.EDITOR_ACTIVE_GAMEDATA_TAG + ";", false);
            }
        } catch (IOException var16) {
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception var14) {
                }
            }

        }

    }

    public final String getName(int i) {
        return (String)this.lNames.get(i);
    }

    public final String getTag(int i) {
        return (String)this.lTerrainTags.get(i);
    }

    public final Color getColor(int i) {
        return (Color)this.lColors.get(i);
    }

    public final Image getIcon(int i) {
        return (Image)this.lTerrainIcons.get(i);
    }

    public final int getTerrainsSize() {
        return this.iTerrainTypesSize;
    }

    public final float getDefense(int i) {
        return (Float)this.lDefense.get(i);
    }

    public final float getMilitaryUpkeep(int i) {
        return (Float)this.lMilitaryUpkeep.get(i);
    }

    public final float getPopulationGrowth(int i) {
        return (Float)this.lPopulationGrowth.get(i);
    }

    public final float getEconomyGrowth(int i) {
        return (Float)this.lEconomyGrowth.get(i);
    }

    public final float getBuildCost(int i) {
        return (Float)this.lBuildCost.get(i);
    }

    public final float getMovementCost(int i) {
        return (Float)this.lMovementCost.get(i);
    }

    public final float getBaseDevelopmentModifier(int i) {
        return (Float)this.lBaseDevelopment.get(i);
    }

    public final int getBaseProvinceValue(int i) {
        return (Integer)this.lBaseProvinceValue.get(i);
    }
}
