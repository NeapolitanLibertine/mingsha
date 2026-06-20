// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package age.of.civilizations2.jakowski.lukasz.MapA.Plagues;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.HistoryLog.HistoryLog_Disease;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import java.util.ArrayList;
import java.util.List;

public class PlagueManager {
   public static final int PLAGUE_PAUSE_FOR_X_TURNS = 38;
   public List<Plagues_GameData> lPlagues = new ArrayList();
   private int iPlaguesSize = 0;
   public List<Plague_GD> plaguesActive = new ArrayList();
   public int radiationID = -1;
   public static final int OUTBREAK_RANDOM = 12500;
   public static final int OUTBREAK_MODIFY = 1000000;

   public final void runPlagues() {
      try {
         for(int i = this.plaguesActive.size() - 1; i >= 0; --i) {
            ((Plague_GD)this.plaguesActive.get(i)).runDisease();
         }

         try {
            for(int i = this.plaguesActive.size() - 1; i >= 0; --i) {
               if (--((Plague_GD)this.plaguesActive.get(i)).iDurationTurnsLeft < 1 && ((Plague_GD)this.plaguesActive.get(i)).lProvinces_Active.size() == 0) {
                  for(int k = i + 1; k < this.plaguesActive.size(); ++k) {
                     for(int o = 0; o < ((Plague_GD)this.plaguesActive.get(k)).lProvinces_Active.size(); ++o) {
                        if (CFG.core.getProv((Integer)((Plague_GD)this.plaguesActive.get(k)).lProvinces_Active.get(o)).provGD.provincePlague != null && CFG.core.getProv((Integer)((Plague_GD)this.plaguesActive.get(k)).lProvinces_Active.get(o)).provGD.provincePlague.iPlagueID_InGame == ((Plague_GD)this.plaguesActive.get(k)).getPlagueID_InGame()) {
                           --CFG.core.getProv((Integer)((Plague_GD)this.plaguesActive.get(k)).lProvinces_Active.get(o)).provGD.provincePlague.iPlagueID_InGame;
                        }
                     }

                     ((Plague_GD)this.plaguesActive.get(k)).setPlagueID_InGame(((Plague_GD)this.plaguesActive.get(k)).getPlagueID_InGame() - 1);
                  }

                  this.plaguesActive.remove(i);
               }
            }
         } catch (IndexOutOfBoundsException ex) {
            CFG.exceptionStack(ex);
         } catch (NullPointerException e) {
            CFG.exceptionStack(e);
         }

         if (CFG.DISABLE_DISEASES) {
            return;
         }

         for(int i = this.plaguesActive.size() - 1; i >= 0; --i) {
            ((Plague_GD)this.plaguesActive.get(i)).spreadDisease();
         }

         this.startDisease();
      } catch (IndexOutOfBoundsException ex) {
         CFG.exceptionStack(ex);
      } catch (NullPointerException ex) {
         CFG.exceptionStack(ex);
      }

   }

   public final void startDisease() {
      int tRandScore = CFG.oR.nextInt(12500);
      if ((float)tRandScore < 12500.0F * CFG.gameAges.getAge_DiseaseChance(GameCalendar.CURRENT_AGEID)) {
         List<Integer> tempIDsToSpawn = new ArrayList();
         int tScoreTotal = 0;

         for(int i = 0; i < this.iPlaguesSize; ++i) {
            if (GameCalendar.currYear >= ((Plagues_GameData)this.lPlagues.get(i)).BeginningYear && GameCalendar.currYear <= ((Plagues_GameData)this.lPlagues.get(i)).EndYear) {
               tempIDsToSpawn.add(i);
               tScoreTotal = (int)((float)tScoreTotal + ((Plagues_GameData)this.lPlagues.get(i)).OUTBREAK_CHANCE * 1000000.0F);
            }
         }

         if (tempIDsToSpawn.size() > 0) {
            int spawnID = 0;
            if (tScoreTotal > 0) {
               int i = tempIDsToSpawn.size() - 1;

               for(int tCurrentScore = 0; i >= 0; --i) {
                  tCurrentScore += (int)(((Plagues_GameData)this.lPlagues.get((Integer)tempIDsToSpawn.get(i))).OUTBREAK_CHANCE * 1000000.0F);
                  tRandScore = CFG.oR.nextInt(tScoreTotal);
                  if (tCurrentScore > tRandScore) {
                     spawnID = i;
                     break;
                  }
               }
            } else {
               spawnID = CFG.oR.nextInt(tempIDsToSpawn.size());
            }

            this.startDisease((Integer)tempIDsToSpawn.get(spawnID));
         }
      }

   }

   public final void startDisease(int nID) {
      int nOutbreakProvinces = ((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_PROVINCES;
      if (((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_PROVINCES_EXTRA > 0) {
         nOutbreakProvinces += CFG.oR.nextInt(((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_PROVINCES_EXTRA);
      }

      List<Integer> lPossibleProvinces = new ArrayList();

      for(int i = 0; i < CFG.core.getProvinSize(); ++i) {
         if (CFG.core.getProv(i).getWastelandLvl() < 0 && !CFG.core.getProv(i).getSeaProv() && CFG.core.getProv(i).getCivId() > 0 && CFG.core.getProv(i).provGD.provincePlague == null && GameCalendar.TURNID - CFG.core.getProv(i).provGD.iLastPlagueTurnID > 38) {
            lPossibleProvinces.add(i);
         }
      }

      if (lPossibleProvinces.size() > 0) {
         List<Integer> lSpreadPropositions = new ArrayList();
         int nToCheck = 8 + (int)(10.0F * Math.min(((Plagues_GameData)this.lPlagues.get(nID)).DEATH_RATE_MIN, 1.0F));

         while(lPossibleProvinces.size() > 0 && nToCheck-- > 0) {
            int tRandID = CFG.oR.nextInt(lPossibleProvinces.size());
            lSpreadPropositions.add((Integer)lPossibleProvinces.get(tRandID));
            lPossibleProvinces.remove(tRandID);
         }

         lPossibleProvinces.clear();
         if (lSpreadPropositions.size() > 0) {
            List<Float> lSpreadPropositions_Score = new ArrayList();
            int tMaxPopulation = 0;
            int tMaxEconomy = 0;
            float tMaxDevelopemnt = 0.0F;
            float tMaxHappiness = 0.0F;

            for(int i = lSpreadPropositions.size() - 1; i >= 0; --i) {
               if (CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getPop().getPops() > tMaxPopulation) {
                  tMaxPopulation = CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getPop().getPops();
               }

               if (CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getEco() > tMaxEconomy) {
                  tMaxEconomy = CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getEco();
               }

               if (CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getDeveLvl() > tMaxDevelopemnt) {
                  tMaxDevelopemnt = CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getDeveLvl();
               }

               if (CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getHappi() > tMaxHappiness) {
                  tMaxHappiness = CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getHappi();
               }
            }

            for(int i = lSpreadPropositions.size() - 1; i >= 0; --i) {
               lSpreadPropositions_Score.add(((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_POPULATION * (float)CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getPop().getPops() / (float)tMaxPopulation + ((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_ECONOMY * (float)CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getEco() / (float)tMaxEconomy + (((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_DEVELOPMENT_LOW - ((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_DEVELOPMENT_LOW * CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getDeveLvl() / tMaxDevelopemnt) + ((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_DEVELOPMENT * CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getDeveLvl() / tMaxDevelopemnt + (((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_HAPPINESS_LOW - ((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_HAPPINESS_LOW * CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getHappi() / tMaxHappiness) + ((Plagues_GameData)this.lPlagues.get(nID)).OUTBREAK_SCORE_HAPPINESS * CFG.core.getProv((Integer)lSpreadPropositions.get(i)).getHappi() / tMaxHappiness);
            }

            int tBestID = 0;

            for(int i = lSpreadPropositions_Score.size() - 1; i > 0; --i) {
               if ((Float)lSpreadPropositions_Score.get(tBestID) < (Float)lSpreadPropositions_Score.get(i)) {
                  tBestID = i;
               }
            }

            int nPlagueID_InGame = this.plaguesActive.size();
            this.plaguesActive.add(new Plague_GD((Integer)lSpreadPropositions.get(tBestID), ((Plagues_GameData)this.lPlagues.get(nID)).getName(), ((Plagues_GameData)this.lPlagues.get(nID)).fR, ((Plagues_GameData)this.lPlagues.get(nID)).fG, ((Plagues_GameData)this.lPlagues.get(nID)).fB, nPlagueID_InGame, ((Plagues_GameData)this.lPlagues.get(nID)).DEATH_RATE_MIN + (float)CFG.oR.nextInt((int)(((Plagues_GameData)this.lPlagues.get(nID)).DEATH_RATE_EXTRA * 100000.0F + 1.0F)) / 100000.0F, ((Plagues_GameData)this.lPlagues.get(nID)).DURATION_TURNS_MIN + (((Plagues_GameData)this.lPlagues.get(nID)).DURATION_TURNS_EXTRA > 0 ? CFG.oR.nextInt(((Plagues_GameData)this.lPlagues.get(nID)).DURATION_TURNS_EXTRA) : 0), ((Plagues_GameData)this.lPlagues.get(nID)).EXPANSION_MODIFIER + (float)CFG.oR.nextInt((int)(((Plagues_GameData)this.lPlagues.get(nID)).EXPANSION_MODIFIER_EXTRA * 100000.0F + 1.0F)) / 100000.0F));

            try {
               CFG.historyManager.addHistoryLog(new HistoryLog_Disease((Integer)lSpreadPropositions.get(tBestID)));
            } catch (Exception var14) {
            }

            lSpreadPropositions.clear();
            lSpreadPropositions_Score.clear();
            --nOutbreakProvinces;
            if (nOutbreakProvinces > 0) {
               ((Plague_GD)this.plaguesActive.get(nPlagueID_InGame)).spreadDisease(nOutbreakProvinces);
            }
         }
      }

   }

   public final void addPlague_Radiation(int provinceID) {
      if (this.radiationID >= 0) {
         try {
            int nPlagueID_InGame = this.plaguesActive.size();
            this.plaguesActive.add(new Plague_GD(provinceID, ((Plagues_GameData)this.lPlagues.get(this.radiationID)).getName(), ((Plagues_GameData)this.lPlagues.get(this.radiationID)).fR, ((Plagues_GameData)this.lPlagues.get(this.radiationID)).fG, ((Plagues_GameData)this.lPlagues.get(this.radiationID)).fB, nPlagueID_InGame, ((Plagues_GameData)this.lPlagues.get(this.radiationID)).DEATH_RATE_MIN + (float)CFG.oR.nextInt((int)(((Plagues_GameData)this.lPlagues.get(this.radiationID)).DEATH_RATE_EXTRA * 100000.0F + 1.0F)) / 100000.0F, ((Plagues_GameData)this.lPlagues.get(this.radiationID)).DURATION_TURNS_MIN + (((Plagues_GameData)this.lPlagues.get(this.radiationID)).DURATION_TURNS_EXTRA > 0 ? CFG.oR.nextInt(((Plagues_GameData)this.lPlagues.get(this.radiationID)).DURATION_TURNS_EXTRA) : 0), ((Plagues_GameData)this.lPlagues.get(this.radiationID)).EXPANSION_MODIFIER + (float)CFG.oR.nextInt((int)(((Plagues_GameData)this.lPlagues.get(this.radiationID)).EXPANSION_MODIFIER_EXTRA * 100000.0F + 1.0F)) / 100000.0F));
            int nOutbreakProvinces = ((Plagues_GameData)this.lPlagues.get(this.radiationID)).OUTBREAK_PROVINCES;
            if (((Plagues_GameData)this.lPlagues.get(this.radiationID)).OUTBREAK_PROVINCES_EXTRA > 0) {
               nOutbreakProvinces += CFG.oR.nextInt(((Plagues_GameData)this.lPlagues.get(this.radiationID)).OUTBREAK_PROVINCES_EXTRA);
            }

            --nOutbreakProvinces;
            if (nOutbreakProvinces > 0) {
               ((Plague_GD)this.plaguesActive.get(nPlagueID_InGame)).spreadDisease(nOutbreakProvinces);
            }
         } catch (Exception ex) {
            CFG.exceptionStack(ex);
         }
      }

   }

   public PlagueManager() {
      this.loadPlagues();
   }

   public final void loadPlagues() {
      this.lPlagues = new ArrayList();

      try {
         FileHandle fileList = FileManager.loadFile("game/Diseases.json");
         String fileContent = fileList.readString();
         Json json = new Json();
         json.setElementType(ConfigDiseasesData.class, "Disease", Data_Diseases.class);
         new ConfigDiseasesData();
         ConfigDiseasesData data = (ConfigDiseasesData)json.fromJson(ConfigDiseasesData.class, fileContent);

         for(Object e : data.Disease) {
            Data_Diseases tempData = (Data_Diseases)e;
            this.lPlagues.add(new Plagues_GameData(tempData.Name, tempData.BeginningYear, tempData.EndYear, tempData.DURATION_TURNS_MIN, tempData.DURATION_TURNS_EXTRA, tempData.DEATH_RATE_MIN, tempData.DEATH_RATE_EXTRA, tempData.EXPANSION_MODIFIER, tempData.EXPANSION_MODIFIER_EXTRA, tempData.R, tempData.G, tempData.B, tempData.OUTBREAK_CHANCE, tempData.OUTBREAK_PROVINCES, tempData.OUTBREAK_PROVINCES_EXTRA, tempData.OUTBREAK_SCORE_POPULATION, tempData.OUTBREAK_SCORE_ECONOMY, tempData.OUTBREAK_SCORE_DEVELOPMENT, tempData.OUTBREAK_SCORE_HAPPINESS, tempData.OUTBREAK_SCORE_DEVELOPMENT_LOW, tempData.OUTBREAK_SCORE_HAPPINESS_LOW, tempData.Radiation));
         }
      } catch (GdxRuntimeException ex) {
         CFG.exceptionStack(ex);
      }

      this.iPlaguesSize = this.lPlagues.size();

      for(int i = 0; i < this.iPlaguesSize; ++i) {
         if (((Plagues_GameData)this.lPlagues.get(i)).Radiation) {
            this.radiationID = i;
            break;
         }
      }

   }

   public final Plagues_GameData getPlague(int nID) {
      return (Plagues_GameData)this.lPlagues.get(nID);
   }

   public final Color getPlagueColor(int nID, float nAlpha) {
      return new Color(((Plagues_GameData)this.lPlagues.get(nID)).fR, ((Plagues_GameData)this.lPlagues.get(nID)).fG, ((Plagues_GameData)this.lPlagues.get(nID)).fB, nAlpha);
   }

   public final Plague_GD getPlague_InGame(int nID) {
      return (Plague_GD)this.plaguesActive.get(nID);
   }

   public final Color getPlagueColor_InGame(int nProvinceID, int nID, float nAlpha) {
      return new Color(((Plague_GD)this.plaguesActive.get(nID)).fR, ((Plague_GD)this.plaguesActive.get(nID)).fG, ((Plague_GD)this.plaguesActive.get(nID)).fB, nAlpha * (0.625F + 0.375F * ((Plague_GD)this.plaguesActive.get(nID)).getDurationPercLEFT((int)CFG.core.getProv(nProvinceID).provGD.provincePlague.iDurationTurnsLeft)));
   }

   public final Color getPlagueColor_InGame(int nID, float nAlpha) {
      return new Color(((Plague_GD)this.plaguesActive.get(nID)).fR, ((Plague_GD)this.plaguesActive.get(nID)).fG, ((Plague_GD)this.plaguesActive.get(nID)).fB, nAlpha);
   }

   public final int getPlaguesSize() {
      return this.iPlaguesSize;
   }

   public static class ConfigDiseasesData {
      public String Age_of_Civilizations;
      public ArrayList Disease;

      public ConfigDiseasesData() {
      }
   }

   public static class Data_Diseases {
      public String Name;
      public int BeginningYear;
      public int EndYear;
      public float OUTBREAK_CHANCE;
      public int OUTBREAK_PROVINCES;
      public int OUTBREAK_PROVINCES_EXTRA;
      public float OUTBREAK_SCORE_POPULATION;
      public float OUTBREAK_SCORE_ECONOMY;
      public float OUTBREAK_SCORE_DEVELOPMENT;
      public float OUTBREAK_SCORE_HAPPINESS;
      public float OUTBREAK_SCORE_DEVELOPMENT_LOW;
      public float OUTBREAK_SCORE_HAPPINESS_LOW;
      public int DURATION_TURNS_MIN;
      public int DURATION_TURNS_EXTRA;
      public float DEATH_RATE_MIN;
      public float DEATH_RATE_EXTRA;
      public float EXPANSION_MODIFIER;
      public float EXPANSION_MODIFIER_EXTRA;
      public int R;
      public int G;
      public int B;
      public boolean Radiation = false;

      public Data_Diseases() {
      }
   }
}
