//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz.GameValues;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.AI.AI_Playstyle.AIPlaystyle;
import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Alliance;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Army;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Budget;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_CivPersonality;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_CivPersonalityType;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_CivsInRange;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Colonization;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_DeclareWar;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Diplomacy;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_FormCiv;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Invest;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Loan;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Nuke;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Province;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Relations;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Rivals;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_Vassals;
import age.of.civilizations2.jakowski.lukasz.GameValues.AI.GV_AI_War;
import com.badlogic.gdx.utils.Json;

public class GameValues {
    public static GV_DefensivePosition gvDefensivePosition = new GV_DefensivePosition();
    public static GV_Military gvMilitary = new GV_Military();
    public static GV_Assimilate gvAssimilate = new GV_Assimilate();
    public static GV_RebelsSupport gvRebelsSupport = new GV_RebelsSupport();
    public static GV_Rebels gvRebels = new GV_Rebels();
    public static GV_Technology gvTechnology = new GV_Technology();
    public static GV_Civilize gvCivilize = new GV_Civilize();
    public static GV_Happiness gvHappiness = new GV_Happiness();
    public static GV_Stability gvStability = new GV_Stability();
    public static GV_Diplomacy gvDiplomacy = new GV_Diplomacy();
    public static GV_MovementPoints gvMovementPoints = new GV_MovementPoints();
    public static GV_Achievements gvAchievements = new GV_Achievements();
    public static GV_Logs gvLogs = new GV_Logs();
    public static GV_AI_CivPersonalityType gvAiCivPersonalityType = new GV_AI_CivPersonalityType();
    public static GV_Loan gvLoan = new GV_Loan();
    public static GV_Ceasefire gvCeasefire = new GV_Ceasefire();
    public static GV_Taxation gvTaxation = new GV_Taxation();
    public static GV_Goods gvGoods = new GV_Goods();
    public static GV_Development gvDevelopment = new GV_Development();
    public static GV_PopulationGrowth gvPopulationGrowth = new GV_PopulationGrowth();
    public static GV_EconomyGrowth gvEconomyGrowth = new GV_EconomyGrowth();
    public static GV_RevolutionaryRisk gvRevolutionaryRisk = new GV_RevolutionaryRisk();
    public static GV_RelationDecrease gvRelationDecrease = new GV_RelationDecrease();
    public static GV_RelationImprove gvRelationImprove = new GV_RelationImprove();
    public static GV_Plunder gvPlunder = new GV_Plunder();
    public static GV_Government gvGovernment = new GV_Government();
    public static GV_Relations gvRelations = new GV_Relations();
    public static GV_Update gvUpdate = new GV_Update();
    public static GV_PeaceTreaty gvPeaceTreaty = new GV_PeaceTreaty();
    public static GV_Ultimatum gvUltimatum = new GV_Ultimatum();
    public static GV_Gift gvGift = new GV_Gift();
    public static GV_Province gvProvince = new GV_Province();
    public static GV_Colonize gvColonize = new GV_Colonize();
    public static GV_Festival gvFestival = new GV_Festival();
    public static GV_InvestDevelopment gvInvestDevelopment = new GV_InvestDevelopment();
    public static GV_InvestEconomy gvInvestEconomy = new GV_InvestEconomy();
    public static GV_RelationsReactions gvRelationsReactions = new GV_RelationsReactions();
    public static GV_DipTruce gvDipTruce = new GV_DipTruce();
    public static GV_DipDefensivePact gvDipDefensivePact = new GV_DipDefensivePact();
    public static GV_DipNonAggression gvDipNonAggression = new GV_DipNonAggression();
    public static GV_DipGuarantee gvDipGuarantee = new GV_DipGuarantee();
    public static GV_DipMilitaryAccess gvDipMilitaryAccess = new GV_DipMilitaryAccess();
    public static GV_Capitulation gvCapitulation = new GV_Capitulation();
    public static GV_DiplomacyPoints gvDiplomacyPoints = new GV_DiplomacyPoints();
    public static GV_AllianceOffer gvAllianceOffer = new GV_AllianceOffer();
    public static GV_DipVassalization gvDipVassalization = new GV_DipVassalization();
    public static GV_Trade gvTrade = new GV_Trade();
    public static GV_WarPreparations gvWarPreparations = new GV_WarPreparations();
    public static GV_DipUnion gvDipUnion = new GV_DipUnion();
    public static GV_DipTransferControl gvDipTransferControl = new GV_DipTransferControl();
    public static GV_DipCallToArms gvDipCallToArms = new GV_DipCallToArms();
    public static GV_GoldenAge gvGoldenAge = new GV_GoldenAge();
    public static GV_GoldenAgeProsperity gvGoldenAgeProsperity = new GV_GoldenAgeProsperity();
    public static GV_GoldenAgeMilitary gvGoldenAgeMilitary = new GV_GoldenAgeMilitary();
    public static GV_GoldenAgeScience gvGoldenAgeScience = new GV_GoldenAgeScience();
    public static GV_Difficulty gvDifficulty = new GV_Difficulty();
    public static GV_ProvinceAnimation gvProvinceAnimation = new GV_ProvinceAnimation();
    public static GV_ProvinceBorder gvProvinceBorder = new GV_ProvinceBorder();
    public static GV_Vassal gvVassal = new GV_Vassal();
    public static GV_Timelapse gvTimelapse = new GV_Timelapse();
    public static GV_HRE gvHre = new GV_HRE();
    public static GV_RebelsIndependence gvRebelsIndependence = new GV_RebelsIndependence();
    public static GV_Battle gvBattle = new GV_Battle();
    public static GV_ArmyRecruitable gvArmyRecruitable = new GV_ArmyRecruitable();
    public static GV_Move gvMove = new GV_Move();
    public static GV_Economy gvEconomy = new GV_Economy();
    public static GV_Dices gvDices = new GV_Dices();
    public static GV_Capital gvCapital = new GV_Capital();
    public static GV_Buildings gvBuildings = new GV_Buildings();
    public static GV_ProvinceNotSupplied gvProvinceNotSupplied = new GV_ProvinceNotSupplied();
    public static GV_ArmyRecruit gvArmyRecruit = new GV_ArmyRecruit();
    public static GV_FormCiv gvFormCiv = new GV_FormCiv();
    public static GV_BuildingArmoury gvBuildingArmoury = new GV_BuildingArmoury();
    public static GV_RankStars gvRankStars = new GV_RankStars();
    public static GV_RankScore gvRankScore = new GV_RankScore();
    public static GV_MoveCapital gvMoveCapital = new GV_MoveCapital();
    public static GV_ArmyDisband gvArmyDisband = new GV_ArmyDisband();
    public static GV_Migrate gvMigrate = new GV_Migrate();
    public static GV_Research gvResearch = new GV_Research();
    public static GV_BuildingFort gvBuildingFort = new GV_BuildingFort();
    public static GV_BuildingWatchTower gvBuildingWatchTower = new GV_BuildingWatchTower();
    public static GV_BuildingPort gvBuildingPort = new GV_BuildingPort();
    public static GV_BuildingSupplyCamp gvBuildingSupplyCamp = new GV_BuildingSupplyCamp();
    public static GV_BuildingFarm gvBuildingFarm = new GV_BuildingFarm();
    public static GV_BuildingLibrary gvBuildingLibrary = new GV_BuildingLibrary();
    public static GV_BuildingWorkshop gvBuildingWorkshop = new GV_BuildingWorkshop();
    public static GV_BuildingMarket gvBuildingMarket = new GV_BuildingMarket();
    public static GV_Income gvIncome = new GV_Income();
    public static GV_IncomeTaxation gvIncomeTaxation = new GV_IncomeTaxation();
    public static GV_IncomeProduction gvIncomeProduction = new GV_IncomeProduction();
    public static GV_Inflation gvInflation = new GV_Inflation();
    public static GV_Administration gvAdministration = new GV_Administration();
    public static GV_ServiceRibbon gvServiceRibbon = new GV_ServiceRibbon();
    public static GV_War gvWar = new GV_War();
    public static GV_ProvinceValue gvProvinceValue = new GV_ProvinceValue();
    public static GV_Leader gvLeader = new GV_Leader();
    public static GV_InGame gvInGame = new GV_InGame();
    public static GV_MapOverlays gvMapOverlays = new GV_MapOverlays();
    public static GV_Core gvCore = new GV_Core();
    public static GV_About gvAbout = new GV_About();
    public static GV_Outliner gvOutliner = new GV_Outliner();
    public static GV_WarWeariness gvWarWeariness = new GV_WarWeariness();
    public static GV_Atomic gvAtomic = new GV_Atomic();
    public static GV_PopRelocate gvPopRelocate = new GV_PopRelocate();
    public static GV_VassalLiberty gvVassalLiberty = new GV_VassalLiberty();
    public static GV_Commands gvCommands = new GV_Commands();
    public static GV_Tribal gvTribal = new GV_Tribal();
    public static GV_EnforcePeace gvEnforcePeace = new GV_EnforcePeace();
    public static GV_InvestForeign gvInvestForeign = new GV_InvestForeign();
    public static GV_Summit gvSummit = new GV_Summit();
    public static GV_Propaganda gvPropaganda = new GV_Propaganda();
    public static GV_OverInvestment gvOverInvestment = new GV_OverInvestment();
    public static GV_Ships gvShips = new GV_Ships();
    public static GV_Wonder gvWonder = new GV_Wonder();
    public static GV_Sanctions gvSanctions = new GV_Sanctions();
    public static GV_AdministrationPolicy gvAdministrationPolicy = new GV_AdministrationPolicy();
    public static GV_AI_Nuke gvAiNuke = new GV_AI_Nuke();
    public static GV_AI_DeclareWar gvAiDeclareWar = new GV_AI_DeclareWar();
    public static GV_AI_Rivals gvAiRivals = new GV_AI_Rivals();
    public static GV_AI_Relations gvAiRelations = new GV_AI_Relations();
    public static GV_AI_CivsInRange gvAiCivsInRange = new GV_AI_CivsInRange();
    public static GV_AI_FormCiv gvAiFormCiv = new GV_AI_FormCiv();
    public static GV_AI_Vassals gvAiVassals = new GV_AI_Vassals();
    public static GV_AI_Alliance gvAiAlliance = new GV_AI_Alliance();
    public static GV_AI_Colonization gvAiColonization = new GV_AI_Colonization();
    public static GV_AI_Loan gvAiLoan = new GV_AI_Loan();
    public static GV_AI_Army gvAiArmy = new GV_AI_Army();
    public static GV_AI_Province gvAiProvince = new GV_AI_Province();
    public static GV_AI_Diplomacy gvAiDiplomacy = new GV_AI_Diplomacy();
    public static GV_AI_Invest gvAiInvest = new GV_AI_Invest();
    public static GV_AI_CivPersonality gvAiCivPersonality = new GV_AI_CivPersonality();
    public static GV_AI_War gvAiWar = new GV_AI_War();
    public static GV_AI_Budget gvAiBudget = new GV_AI_Budget();
    public static GV_MapScroll gvMapScroll = new GV_MapScroll();
    public static int DEFAULT_FONT_SIZE = 18;

    public GameValues() {
    }

    public static final void init() {
        Json json = new Json();

        try {
            if (FileManager.loadFile("game/gameValues/gvDefensivePosition.json").exists()) {
                gvDefensivePosition = (GV_DefensivePosition)json.fromJson(GV_DefensivePosition.class, FileManager.loadFile("game/gameValues/gvDefensivePosition.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvMilitary.json").exists()) {
                gvMilitary = (GV_Military)json.fromJson(GV_Military.class, FileManager.loadFile("game/gameValues/gvMilitary.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAssimilate.json").exists()) {
                gvAssimilate = (GV_Assimilate)json.fromJson(GV_Assimilate.class, FileManager.loadFile("game/gameValues/gvAssimilate.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRebelsSupport.json").exists()) {
                gvRebelsSupport = (GV_RebelsSupport)json.fromJson(GV_RebelsSupport.class, FileManager.loadFile("game/gameValues/gvRebelsSupport.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRebels.json").exists()) {
                gvRebels = (GV_Rebels)json.fromJson(GV_Rebels.class, FileManager.loadFile("game/gameValues/gvRebels.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvTechnology.json").exists()) {
                gvTechnology = (GV_Technology)json.fromJson(GV_Technology.class, FileManager.loadFile("game/gameValues/gvTechnology.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvCivilize.json").exists()) {
                gvCivilize = (GV_Civilize)json.fromJson(GV_Civilize.class, FileManager.loadFile("game/gameValues/gvCivilize.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvHappiness.json").exists()) {
                gvHappiness = (GV_Happiness)json.fromJson(GV_Happiness.class, FileManager.loadFile("game/gameValues/gvHappiness.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvStability.json").exists()) {
                gvStability = (GV_Stability)json.fromJson(GV_Stability.class, FileManager.loadFile("game/gameValues/gvStability.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDiplomacy.json").exists()) {
                gvDiplomacy = (GV_Diplomacy)json.fromJson(GV_Diplomacy.class, FileManager.loadFile("game/gameValues/gvDiplomacy.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvMovementPoints.json").exists()) {
                gvMovementPoints = (GV_MovementPoints)json.fromJson(GV_MovementPoints.class, FileManager.loadFile("game/gameValues/gvMovementPoints.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAchievements.json").exists()) {
                gvAchievements = (GV_Achievements)json.fromJson(GV_Achievements.class, FileManager.loadFile("game/gameValues/gvAchievements.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvLogs.json").exists()) {
                gvLogs = (GV_Logs)json.fromJson(GV_Logs.class, FileManager.loadFile("game/gameValues/gvLogs.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        boolean gvAiCivPersonalityTypeLoaded = false;

        try {
            if (FileManager.loadFile("game/gameValues/gvAiCivPersonalityType.json").exists()) {
                gvAiCivPersonalityType = (GV_AI_CivPersonalityType)json.fromJson(GV_AI_CivPersonalityType.class, FileManager.loadFile("game/gameValues/gvAiCivPersonalityType.json"));
                gvAiCivPersonalityTypeLoaded = true;
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvLoan.json").exists()) {
                gvLoan = (GV_Loan)json.fromJson(GV_Loan.class, FileManager.loadFile("game/gameValues/gvLoan.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvCeasefire.json").exists()) {
                gvCeasefire = (GV_Ceasefire)json.fromJson(GV_Ceasefire.class, FileManager.loadFile("game/gameValues/gvCeasefire.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvTaxation.json").exists()) {
                gvTaxation = (GV_Taxation)json.fromJson(GV_Taxation.class, FileManager.loadFile("game/gameValues/gvTaxation.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvGoods.json").exists()) {
                gvGoods = (GV_Goods)json.fromJson(GV_Goods.class, FileManager.loadFile("game/gameValues/gvGoods.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDevelopment.json").exists()) {
                gvDevelopment = (GV_Development)json.fromJson(GV_Development.class, FileManager.loadFile("game/gameValues/gvDevelopment.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvPopulationGrowth.json").exists()) {
                gvPopulationGrowth = (GV_PopulationGrowth)json.fromJson(GV_PopulationGrowth.class, FileManager.loadFile("game/gameValues/gvPopulationGrowth.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvEconomyGrowth.json").exists()) {
                gvEconomyGrowth = (GV_EconomyGrowth)json.fromJson(GV_EconomyGrowth.class, FileManager.loadFile("game/gameValues/gvEconomyGrowth.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRevolutionaryRisk.json").exists()) {
                gvRevolutionaryRisk = (GV_RevolutionaryRisk)json.fromJson(GV_RevolutionaryRisk.class, FileManager.loadFile("game/gameValues/gvRevolutionaryRisk.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRelationDecrease.json").exists()) {
                gvRelationDecrease = (GV_RelationDecrease)json.fromJson(GV_RelationDecrease.class, FileManager.loadFile("game/gameValues/gvRelationDecrease.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRelationImprove.json").exists()) {
                gvRelationImprove = (GV_RelationImprove)json.fromJson(GV_RelationImprove.class, FileManager.loadFile("game/gameValues/gvRelationImprove.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvPlunder.json").exists()) {
                gvPlunder = (GV_Plunder)json.fromJson(GV_Plunder.class, FileManager.loadFile("game/gameValues/gvPlunder.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvGovernment.json").exists()) {
                gvGovernment = (GV_Government)json.fromJson(GV_Government.class, FileManager.loadFile("game/gameValues/gvGovernment.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRelations.json").exists()) {
                gvRelations = (GV_Relations)json.fromJson(GV_Relations.class, FileManager.loadFile("game/gameValues/gvRelations.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvUpdate.json").exists()) {
                gvUpdate = (GV_Update)json.fromJson(GV_Update.class, FileManager.loadFile("game/gameValues/gvUpdate.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvPeaceTreaty.json").exists()) {
                gvPeaceTreaty = (GV_PeaceTreaty)json.fromJson(GV_PeaceTreaty.class, FileManager.loadFile("game/gameValues/gvPeaceTreaty.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvUltimatum.json").exists()) {
                gvUltimatum = (GV_Ultimatum)json.fromJson(GV_Ultimatum.class, FileManager.loadFile("game/gameValues/gvUltimatum.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvGift.json").exists()) {
                gvGift = (GV_Gift)json.fromJson(GV_Gift.class, FileManager.loadFile("game/gameValues/gvGift.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvProvince.json").exists()) {
                gvProvince = (GV_Province)json.fromJson(GV_Province.class, FileManager.loadFile("game/gameValues/gvProvince.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvColonize.json").exists()) {
                gvColonize = (GV_Colonize)json.fromJson(GV_Colonize.class, FileManager.loadFile("game/gameValues/gvColonize.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvFestival.json").exists()) {
                gvFestival = (GV_Festival)json.fromJson(GV_Festival.class, FileManager.loadFile("game/gameValues/gvFestival.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvInvestDevelopment.json").exists()) {
                gvInvestDevelopment = (GV_InvestDevelopment)json.fromJson(GV_InvestDevelopment.class, FileManager.loadFile("game/gameValues/gvInvestDevelopment.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvInvestEconomy.json").exists()) {
                gvInvestEconomy = (GV_InvestEconomy)json.fromJson(GV_InvestEconomy.class, FileManager.loadFile("game/gameValues/gvInvestEconomy.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRelationsReactions.json").exists()) {
                gvRelationsReactions = (GV_RelationsReactions)json.fromJson(GV_RelationsReactions.class, FileManager.loadFile("game/gameValues/gvRelationsReactions.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipTruce.json").exists()) {
                gvDipTruce = (GV_DipTruce)json.fromJson(GV_DipTruce.class, FileManager.loadFile("game/gameValues/gvDipTruce.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipDefensivePact.json").exists()) {
                gvDipDefensivePact = (GV_DipDefensivePact)json.fromJson(GV_DipDefensivePact.class, FileManager.loadFile("game/gameValues/gvDipDefensivePact.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipNonAggression.json").exists()) {
                gvDipNonAggression = (GV_DipNonAggression)json.fromJson(GV_DipNonAggression.class, FileManager.loadFile("game/gameValues/gvDipNonAggression.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipGuarantee.json").exists()) {
                gvDipGuarantee = (GV_DipGuarantee)json.fromJson(GV_DipGuarantee.class, FileManager.loadFile("game/gameValues/gvDipGuarantee.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipMilitaryAccess.json").exists()) {
                gvDipMilitaryAccess = (GV_DipMilitaryAccess)json.fromJson(GV_DipMilitaryAccess.class, FileManager.loadFile("game/gameValues/gvDipMilitaryAccess.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvCapitulation.json").exists()) {
                gvCapitulation = (GV_Capitulation)json.fromJson(GV_Capitulation.class, FileManager.loadFile("game/gameValues/gvCapitulation.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDiplomacyPoints.json").exists()) {
                gvDiplomacyPoints = (GV_DiplomacyPoints)json.fromJson(GV_DiplomacyPoints.class, FileManager.loadFile("game/gameValues/gvDiplomacyPoints.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAllianceOffer.json").exists()) {
                gvAllianceOffer = (GV_AllianceOffer)json.fromJson(GV_AllianceOffer.class, FileManager.loadFile("game/gameValues/gvAllianceOffer.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipVassalization.json").exists()) {
                gvDipVassalization = (GV_DipVassalization)json.fromJson(GV_DipVassalization.class, FileManager.loadFile("game/gameValues/gvDipVassalization.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvTrade.json").exists()) {
                gvTrade = (GV_Trade)json.fromJson(GV_Trade.class, FileManager.loadFile("game/gameValues/gvTrade.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvWarPreparations.json").exists()) {
                gvWarPreparations = (GV_WarPreparations)json.fromJson(GV_WarPreparations.class, FileManager.loadFile("game/gameValues/gvWarPreparations.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipUnion.json").exists()) {
                gvDipUnion = (GV_DipUnion)json.fromJson(GV_DipUnion.class, FileManager.loadFile("game/gameValues/gvDipUnion.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipTransferControl.json").exists()) {
                gvDipTransferControl = (GV_DipTransferControl)json.fromJson(GV_DipTransferControl.class, FileManager.loadFile("game/gameValues/gvDipTransferControl.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDipCallToArms.json").exists()) {
                gvDipCallToArms = (GV_DipCallToArms)json.fromJson(GV_DipCallToArms.class, FileManager.loadFile("game/gameValues/gvDipCallToArms.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAge.json").exists()) {
                gvGoldenAge = (GV_GoldenAge)json.fromJson(GV_GoldenAge.class, FileManager.loadFile("game/gameValues/gvGoldenAge.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAgeProsperity.json").exists()) {
                gvGoldenAgeProsperity = (GV_GoldenAgeProsperity)json.fromJson(GV_GoldenAgeProsperity.class, FileManager.loadFile("game/gameValues/gvGoldenAgeProsperity.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAgeMilitary.json").exists()) {
                gvGoldenAgeMilitary = (GV_GoldenAgeMilitary)json.fromJson(GV_GoldenAgeMilitary.class, FileManager.loadFile("game/gameValues/gvGoldenAgeMilitary.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvGoldenAgeScience.json").exists()) {
                gvGoldenAgeScience = (GV_GoldenAgeScience)json.fromJson(GV_GoldenAgeScience.class, FileManager.loadFile("game/gameValues/gvGoldenAgeScience.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDifficulty.json").exists()) {
                gvDifficulty = (GV_Difficulty)json.fromJson(GV_Difficulty.class, FileManager.loadFile("game/gameValues/gvDifficulty.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceAnimation.json").exists()) {
                gvProvinceAnimation = (GV_ProvinceAnimation)json.fromJson(GV_ProvinceAnimation.class, FileManager.loadFile("game/gameValues/gvProvinceAnimation.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceBorder.json").exists()) {
                gvProvinceBorder = (GV_ProvinceBorder)json.fromJson(GV_ProvinceBorder.class, FileManager.loadFile("game/gameValues/gvProvinceBorder.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvVassal.json").exists()) {
                gvVassal = (GV_Vassal)json.fromJson(GV_Vassal.class, FileManager.loadFile("game/gameValues/gvVassal.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvTimelapse.json").exists()) {
                gvTimelapse = (GV_Timelapse)json.fromJson(GV_Timelapse.class, FileManager.loadFile("game/gameValues/gvTimelapse.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvHre.json").exists()) {
                gvHre = (GV_HRE)json.fromJson(GV_HRE.class, FileManager.loadFile("game/gameValues/gvHre.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRebelsIndependence.json").exists()) {
                gvRebelsIndependence = (GV_RebelsIndependence)json.fromJson(GV_RebelsIndependence.class, FileManager.loadFile("game/gameValues/gvRebelsIndependence.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBattle.json").exists()) {
                gvBattle = (GV_Battle)json.fromJson(GV_Battle.class, FileManager.loadFile("game/gameValues/gvBattle.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvArmyRecruitable.json").exists()) {
                gvArmyRecruitable = (GV_ArmyRecruitable)json.fromJson(GV_ArmyRecruitable.class, FileManager.loadFile("game/gameValues/gvArmyRecruitable.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvMove.json").exists()) {
                gvMove = (GV_Move)json.fromJson(GV_Move.class, FileManager.loadFile("game/gameValues/gvMove.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvEconomy.json").exists()) {
                gvEconomy = (GV_Economy)json.fromJson(GV_Economy.class, FileManager.loadFile("game/gameValues/gvEconomy.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvDices.json").exists()) {
                gvDices = (GV_Dices)json.fromJson(GV_Dices.class, FileManager.loadFile("game/gameValues/gvDices.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvCapital.json").exists()) {
                gvCapital = (GV_Capital)json.fromJson(GV_Capital.class, FileManager.loadFile("game/gameValues/gvCapital.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildings.json").exists()) {
                gvBuildings = (GV_Buildings)json.fromJson(GV_Buildings.class, FileManager.loadFile("game/gameValues/gvBuildings.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceNotSupplied.json").exists()) {
                gvProvinceNotSupplied = (GV_ProvinceNotSupplied)json.fromJson(GV_ProvinceNotSupplied.class, FileManager.loadFile("game/gameValues/gvProvinceNotSupplied.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvArmyRecruit.json").exists()) {
                gvArmyRecruit = (GV_ArmyRecruit)json.fromJson(GV_ArmyRecruit.class, FileManager.loadFile("game/gameValues/gvArmyRecruit.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvFormCiv.json").exists()) {
                gvFormCiv = (GV_FormCiv)json.fromJson(GV_FormCiv.class, FileManager.loadFile("game/gameValues/gvFormCiv.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingArmoury.json").exists()) {
                gvBuildingArmoury = (GV_BuildingArmoury)json.fromJson(GV_BuildingArmoury.class, FileManager.loadFile("game/gameValues/gvBuildingArmoury.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public static final void init2() {
        Json json = new Json();

        try {
            if (FileManager.loadFile("game/gameValues/gvRankStars.json").exists()) {
                gvRankStars = (GV_RankStars)json.fromJson(GV_RankStars.class, FileManager.loadFile("game/gameValues/gvRankStars.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvRankScore.json").exists()) {
                gvRankScore = (GV_RankScore)json.fromJson(GV_RankScore.class, FileManager.loadFile("game/gameValues/gvRankScore.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvMoveCapital.json").exists()) {
                gvMoveCapital = (GV_MoveCapital)json.fromJson(GV_MoveCapital.class, FileManager.loadFile("game/gameValues/gvMoveCapital.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvArmyDisband.json").exists()) {
                gvArmyDisband = (GV_ArmyDisband)json.fromJson(GV_ArmyDisband.class, FileManager.loadFile("game/gameValues/gvArmyDisband.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvMigrate.json").exists()) {
                gvMigrate = (GV_Migrate)json.fromJson(GV_Migrate.class, FileManager.loadFile("game/gameValues/gvMigrate.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvResearch.json").exists()) {
                gvResearch = (GV_Research)json.fromJson(GV_Research.class, FileManager.loadFile("game/gameValues/gvResearch.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingFort.json").exists()) {
                gvBuildingFort = (GV_BuildingFort)json.fromJson(GV_BuildingFort.class, FileManager.loadFile("game/gameValues/gvBuildingFort.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingWatchTower.json").exists()) {
                gvBuildingWatchTower = (GV_BuildingWatchTower)json.fromJson(GV_BuildingWatchTower.class, FileManager.loadFile("game/gameValues/gvBuildingWatchTower.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingPort.json").exists()) {
                gvBuildingPort = (GV_BuildingPort)json.fromJson(GV_BuildingPort.class, FileManager.loadFile("game/gameValues/gvBuildingPort.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingSupplyCamp.json").exists()) {
                gvBuildingSupplyCamp = (GV_BuildingSupplyCamp)json.fromJson(GV_BuildingSupplyCamp.class, FileManager.loadFile("game/gameValues/gvBuildingSupplyCamp.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingFarm.json").exists()) {
                gvBuildingFarm = (GV_BuildingFarm)json.fromJson(GV_BuildingFarm.class, FileManager.loadFile("game/gameValues/gvBuildingFarm.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingLibrary.json").exists()) {
                gvBuildingLibrary = (GV_BuildingLibrary)json.fromJson(GV_BuildingLibrary.class, FileManager.loadFile("game/gameValues/gvBuildingLibrary.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingWorkshop.json").exists()) {
                gvBuildingWorkshop = (GV_BuildingWorkshop)json.fromJson(GV_BuildingWorkshop.class, FileManager.loadFile("game/gameValues/gvBuildingWorkshop.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvBuildingMarket.json").exists()) {
                gvBuildingMarket = (GV_BuildingMarket)json.fromJson(GV_BuildingMarket.class, FileManager.loadFile("game/gameValues/gvBuildingMarket.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvIncome.json").exists()) {
                gvIncome = (GV_Income)json.fromJson(GV_Income.class, FileManager.loadFile("game/gameValues/gvIncome.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvIncomeTaxation.json").exists()) {
                gvIncomeTaxation = (GV_IncomeTaxation)json.fromJson(GV_IncomeTaxation.class, FileManager.loadFile("game/gameValues/gvIncomeTaxation.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvIncomeProduction.json").exists()) {
                gvIncomeProduction = (GV_IncomeProduction)json.fromJson(GV_IncomeProduction.class, FileManager.loadFile("game/gameValues/gvIncomeProduction.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvInflation.json").exists()) {
                gvInflation = (GV_Inflation)json.fromJson(GV_Inflation.class, FileManager.loadFile("game/gameValues/gvInflation.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAdministration.json").exists()) {
                gvAdministration = (GV_Administration)json.fromJson(GV_Administration.class, FileManager.loadFile("game/gameValues/gvAdministration.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvServiceRibbon.json").exists()) {
                gvServiceRibbon = (GV_ServiceRibbon)json.fromJson(GV_ServiceRibbon.class, FileManager.loadFile("game/gameValues/gvServiceRibbon.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvWar.json").exists()) {
                gvWar = (GV_War)json.fromJson(GV_War.class, FileManager.loadFile("game/gameValues/gvWar.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvProvinceValue.json").exists()) {
                gvProvinceValue = (GV_ProvinceValue)json.fromJson(GV_ProvinceValue.class, FileManager.loadFile("game/gameValues/gvProvinceValue.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvLeader.json").exists()) {
                gvLeader = (GV_Leader)json.fromJson(GV_Leader.class, FileManager.loadFile("game/gameValues/gvLeader.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvInGame.json").exists()) {
                gvInGame = (GV_InGame)json.fromJson(GV_InGame.class, FileManager.loadFile("game/gameValues/gvInGame.json"));
                CFG.map.getMpB().updateMinimapResolution(1);
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvMapOverlays.json").exists()) {
                gvMapOverlays = (GV_MapOverlays)json.fromJson(GV_MapOverlays.class, FileManager.loadFile("game/gameValues/gvMapOverlays.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvCore.json").exists()) {
                gvCore = (GV_Core)json.fromJson(GV_Core.class, FileManager.loadFile("game/gameValues/gvCore.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAbout.json").exists()) {
                gvAbout = (GV_About)json.fromJson(GV_About.class, FileManager.loadFile("game/gameValues/gvAbout.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvOutliner.json").exists()) {
                gvOutliner = (GV_Outliner)json.fromJson(GV_Outliner.class, FileManager.loadFile("game/gameValues/gvOutliner.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvWarWeariness.json").exists()) {
                gvWarWeariness = (GV_WarWeariness)json.fromJson(GV_WarWeariness.class, FileManager.loadFile("game/gameValues/gvWarWeariness.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAtomic.json").exists()) {
                gvAtomic = (GV_Atomic)json.fromJson(GV_Atomic.class, FileManager.loadFile("game/gameValues/gvAtomic.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvPopRelocate.json").exists()) {
                gvPopRelocate = (GV_PopRelocate)json.fromJson(GV_PopRelocate.class, FileManager.loadFile("game/gameValues/gvPopRelocate.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvVassalLiberty.json").exists()) {
                gvVassalLiberty = (GV_VassalLiberty)json.fromJson(GV_VassalLiberty.class, FileManager.loadFile("game/gameValues/gvVassalLiberty.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvCommands.json").exists()) {
                gvCommands = (GV_Commands)json.fromJson(GV_Commands.class, FileManager.loadFile("game/gameValues/gvCommands.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvTribal.json").exists()) {
                gvTribal = (GV_Tribal)json.fromJson(GV_Tribal.class, FileManager.loadFile("game/gameValues/gvTribal.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvEnforcePeace.json").exists()) {
                gvEnforcePeace = (GV_EnforcePeace)json.fromJson(GV_EnforcePeace.class, FileManager.loadFile("game/gameValues/gvEnforcePeace.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvInvestForeign.json").exists()) {
                gvInvestForeign = (GV_InvestForeign)json.fromJson(GV_InvestForeign.class, FileManager.loadFile("game/gameValues/gvInvestForeign.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvSummit.json").exists()) {
                gvSummit = (GV_Summit)json.fromJson(GV_Summit.class, FileManager.loadFile("game/gameValues/gvSummit.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvPropaganda.json").exists()) {
                gvPropaganda = (GV_Propaganda)json.fromJson(GV_Propaganda.class, FileManager.loadFile("game/gameValues/gvPropaganda.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvOverInvestment.json").exists()) {
                gvOverInvestment = (GV_OverInvestment)json.fromJson(GV_OverInvestment.class, FileManager.loadFile("game/gameValues/gvOverInvestment.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvShips.json").exists()) {
                gvShips = (GV_Ships)json.fromJson(GV_Ships.class, FileManager.loadFile("game/gameValues/gvShips.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvWonder.json").exists()) {
                gvWonder = (GV_Wonder)json.fromJson(GV_Wonder.class, FileManager.loadFile("game/gameValues/gvWonder.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvSanctions.json").exists()) {
                gvSanctions = (GV_Sanctions)json.fromJson(GV_Sanctions.class, FileManager.loadFile("game/gameValues/gvSanctions.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAdministrationPolicy.json").exists()) {
                gvAdministrationPolicy = (GV_AdministrationPolicy)json.fromJson(GV_AdministrationPolicy.class, FileManager.loadFile("game/gameValues/gvAdministrationPolicy.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiNuke.json").exists()) {
                gvAiNuke = (GV_AI_Nuke)json.fromJson(GV_AI_Nuke.class, FileManager.loadFile("game/gameValues/gvAiNuke.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiDeclareWar.json").exists()) {
                gvAiDeclareWar = (GV_AI_DeclareWar)json.fromJson(GV_AI_DeclareWar.class, FileManager.loadFile("game/gameValues/gvAiDeclareWar.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiRivals.json").exists()) {
                gvAiRivals = (GV_AI_Rivals)json.fromJson(GV_AI_Rivals.class, FileManager.loadFile("game/gameValues/gvAiRivals.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiRelations.json").exists()) {
                gvAiRelations = (GV_AI_Relations)json.fromJson(GV_AI_Relations.class, FileManager.loadFile("game/gameValues/gvAiRelations.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiCivsInRange.json").exists()) {
                gvAiCivsInRange = (GV_AI_CivsInRange)json.fromJson(GV_AI_CivsInRange.class, FileManager.loadFile("game/gameValues/gvAiCivsInRange.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiFormCiv.json").exists()) {
                gvAiFormCiv = (GV_AI_FormCiv)json.fromJson(GV_AI_FormCiv.class, FileManager.loadFile("game/gameValues/gvAiFormCiv.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiVassals.json").exists()) {
                gvAiVassals = (GV_AI_Vassals)json.fromJson(GV_AI_Vassals.class, FileManager.loadFile("game/gameValues/gvAiVassals.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiAlliance.json").exists()) {
                gvAiAlliance = (GV_AI_Alliance)json.fromJson(GV_AI_Alliance.class, FileManager.loadFile("game/gameValues/gvAiAlliance.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiColonization.json").exists()) {
                gvAiColonization = (GV_AI_Colonization)json.fromJson(GV_AI_Colonization.class, FileManager.loadFile("game/gameValues/gvAiColonization.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiLoan.json").exists()) {
                gvAiLoan = (GV_AI_Loan)json.fromJson(GV_AI_Loan.class, FileManager.loadFile("game/gameValues/gvAiLoan.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiArmy.json").exists()) {
                gvAiArmy = (GV_AI_Army)json.fromJson(GV_AI_Army.class, FileManager.loadFile("game/gameValues/gvAiArmy.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiProvince.json").exists()) {
                gvAiProvince = (GV_AI_Province)json.fromJson(GV_AI_Province.class, FileManager.loadFile("game/gameValues/gvAiProvince.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiDiplomacy.json").exists()) {
                gvAiDiplomacy = (GV_AI_Diplomacy)json.fromJson(GV_AI_Diplomacy.class, FileManager.loadFile("game/gameValues/gvAiDiplomacy.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiInvest.json").exists()) {
                gvAiInvest = (GV_AI_Invest)json.fromJson(GV_AI_Invest.class, FileManager.loadFile("game/gameValues/gvAiInvest.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiCivPersonality.json").exists()) {
                gvAiCivPersonality = (GV_AI_CivPersonality)json.fromJson(GV_AI_CivPersonality.class, FileManager.loadFile("game/gameValues/gvAiCivPersonality.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiWar.json").exists()) {
                gvAiWar = (GV_AI_War)json.fromJson(GV_AI_War.class, FileManager.loadFile("game/gameValues/gvAiWar.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvAiBudget.json").exists()) {
                gvAiBudget = (GV_AI_Budget)json.fromJson(GV_AI_Budget.class, FileManager.loadFile("game/gameValues/gvAiBudget.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        try {
            if (FileManager.loadFile("game/gameValues/gvMapScroll.json").exists()) {
                gvMapScroll = (GV_MapScroll)json.fromJson(GV_MapScroll.class, FileManager.loadFile("game/gameValues/gvMapScroll.json"));
            }
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }

    public static void updateCivPersonalityType() {
        try {
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_HAPPINESS_DEFAULT = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_HAPPINESS_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_HAPPINESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_FORGIVENESS_DEFAULT = gvAiCivPersonalityType.DEFAULT_PERSONALITY_FORGIVENESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_FORGIVENESS_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_FORGIVENESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).USE_OF_BUDGET_FOR_SPENDINGS = gvAiCivPersonalityType.DEFAULT_USE_OF_BUDGET_FOR_SPENDINGS;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = gvAiCivPersonalityType.DEFAULT_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_GOODS_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_GOODS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_INVESTMENTS_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_INVESTMENTS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_RESEARCH_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_RESEARCH_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_PLUNDER_MIN = gvAiCivPersonalityType.DEFAULT_PERSONALITY_PLUNDER_MIN;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_PLUNDER_RANDOM = gvAiCivPersonalityType.DEFAULT_PERSONALITY_PLUNDER_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_PLUNDER_LOCK = gvAiCivPersonalityType.DEFAULT_PERSONALITY_PLUNDER_LOCK;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_AGGRESSION_DEFAULT = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(0)).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = gvAiCivPersonalityType.DEFAULT_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_HAPPINESS_DEFAULT = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_HAPPINESS_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_HAPPINESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_FORGIVENESS_DEFAULT = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_FORGIVENESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_FORGIVENESS_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_FORGIVENESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).USE_OF_BUDGET_FOR_SPENDINGS = gvAiCivPersonalityType.COMMUNISM_USE_OF_BUDGET_FOR_SPENDINGS;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = gvAiCivPersonalityType.COMMUNISM_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_GOODS_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_GOODS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_INVESTMENTS_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_INVESTMENTS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_RESEARCH_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_RESEARCH_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_PLUNDER_MIN = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_PLUNDER_MIN;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_PLUNDER_RANDOM = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_PLUNDER_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_PLUNDER_LOCK = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_PLUNDER_LOCK;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_AGGRESSION_DEFAULT = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(1)).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = gvAiCivPersonalityType.COMMUNISM_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_HAPPINESS_DEFAULT = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_HAPPINESS_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_HAPPINESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_FORGIVENESS_DEFAULT = gvAiCivPersonalityType.HORDE_PERSONALITY_FORGIVENESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_FORGIVENESS_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_FORGIVENESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).USE_OF_BUDGET_FOR_SPENDINGS = gvAiCivPersonalityType.HORDE_USE_OF_BUDGET_FOR_SPENDINGS;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = gvAiCivPersonalityType.HORDE_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_GOODS_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_GOODS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_INVESTMENTS_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_INVESTMENTS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_RESEARCH_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_RESEARCH_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_PLUNDER_MIN = gvAiCivPersonalityType.HORDE_PERSONALITY_PLUNDER_MIN;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_PLUNDER_RANDOM = gvAiCivPersonalityType.HORDE_PERSONALITY_PLUNDER_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_PLUNDER_LOCK = gvAiCivPersonalityType.HORDE_PERSONALITY_PLUNDER_LOCK;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_AGGRESSION_DEFAULT = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(2)).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = gvAiCivPersonalityType.HORDE_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_HAPPINESS_DEFAULT = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_HAPPINESS_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_HAPPINESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_FORGIVENESS_DEFAULT = gvAiCivPersonalityType.FASCISM_PERSONALITY_FORGIVENESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_FORGIVENESS_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_FORGIVENESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).USE_OF_BUDGET_FOR_SPENDINGS = gvAiCivPersonalityType.FASCISM_USE_OF_BUDGET_FOR_SPENDINGS;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = gvAiCivPersonalityType.FASCISM_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_GOODS_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_GOODS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_INVESTMENTS_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_INVESTMENTS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_RESEARCH_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_RESEARCH_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_PLUNDER_MIN = gvAiCivPersonalityType.FASCISM_PERSONALITY_PLUNDER_MIN;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_PLUNDER_RANDOM = gvAiCivPersonalityType.FASCISM_PERSONALITY_PLUNDER_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_PLUNDER_LOCK = gvAiCivPersonalityType.FASCISM_PERSONALITY_PLUNDER_LOCK;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_AGGRESSION_DEFAULT = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(3)).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = gvAiCivPersonalityType.FASCISM_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_HAPPINESS_DEFAULT = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_HAPPINESS_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_HAPPINESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_FORGIVENESS_DEFAULT = gvAiCivPersonalityType.CITY_PERSONALITY_FORGIVENESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_FORGIVENESS_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_FORGIVENESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).USE_OF_BUDGET_FOR_SPENDINGS = gvAiCivPersonalityType.CITY_USE_OF_BUDGET_FOR_SPENDINGS;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = gvAiCivPersonalityType.CITY_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_GOODS_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_GOODS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_INVESTMENTS_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_INVESTMENTS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_RESEARCH_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_RESEARCH_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_PLUNDER_MIN = gvAiCivPersonalityType.CITY_PERSONALITY_PLUNDER_MIN;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_PLUNDER_RANDOM = gvAiCivPersonalityType.CITY_PERSONALITY_PLUNDER_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_PLUNDER_LOCK = gvAiCivPersonalityType.CITY_PERSONALITY_PLUNDER_LOCK;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_AGGRESSION_DEFAULT = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(4)).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = gvAiCivPersonalityType.CITY_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_MILITARY_SPENDINGS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_MILITARY_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_DIFFERENCE_IN_DEVELOPMENT_TO_TECHNOLOGY_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_HAPPINESS_DEFAULT = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_HAPPINESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_HAPPINESS_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_HAPPINESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_FORGIVENESS_DEFAULT = gvAiCivPersonalityType.TRIBAL_PERSONALITY_FORGIVENESS_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_FORGIVENESS_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_FORGIVENESS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).USE_OF_BUDGET_FOR_SPENDINGS = gvAiCivPersonalityType.TRIBAL_USE_OF_BUDGET_FOR_SPENDINGS;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).USE_OF_BUDGET_FOR_SPENDINGS_RANDOM = gvAiCivPersonalityType.TRIBAL_USE_OF_BUDGET_FOR_SPENDINGS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_GOODS_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_GOODS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_INVESTMENTS_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_INVESTMENTS_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_RESEARCH_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_RESEARCH_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_PLUNDER_MIN = gvAiCivPersonalityType.TRIBAL_PERSONALITY_PLUNDER_MIN;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_PLUNDER_RANDOM = gvAiCivPersonalityType.TRIBAL_PERSONALITY_PLUNDER_RANDOM;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_PLUNDER_LOCK = gvAiCivPersonalityType.TRIBAL_PERSONALITY_PLUNDER_LOCK;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_AGGRESSION_DEFAULT = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_AGGRESSION_DEFAULT;
            ((AIPlaystyle)CFG.oAI.aiPlaystyles.get(5)).PERSONALITY_MIN_AGGRESSION_RANDOM_100 = gvAiCivPersonalityType.TRIBAL_PERSONALITY_MIN_AGGRESSION_RANDOM_100;
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

    }
}
