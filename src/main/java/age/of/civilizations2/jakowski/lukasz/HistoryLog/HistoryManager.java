//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz.HistoryLog;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;
import age.of.civilizations2.jakowski.lukasz.IMGManager;
import age.of.civilizations2.jakowski.lukasz.Images;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("unused")
public class HistoryManager {
    public static List<String> lHistoryDates = new ArrayList();
    public static List<Integer> lHistoryDatesWidth = new ArrayList();
    public static int HISTORY_LIMIT = 200;

    public HistoryManager() {
        CFG.timelapseManager.timelapseStatsHistory.lHistory = new ArrayList();
        this.addNewTurn();
        HistoryLog.ICON_WIDTH = (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploWar));
        if (HistoryLog.ICON_WIDTH < (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploTruce))) {
            HistoryLog.ICON_WIDTH = (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploTruce));
        }

        if (HistoryLog.ICON_WIDTH < (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploAlliance))) {
            HistoryLog.ICON_WIDTH = (int)((float)IMGManager.getIMG(Images.diploWar).getWidth() * HistoryLog.getImageScale(Images.diploAlliance));
        }

        for(int i = 0; i < CFG.ideologiesMgr.getIdeologiesSize(); ++i) {
            if (HistoryLog.ICON_WIDTH < (int)((float)CFG.ideologiesMgr.getIdeologyID(i).getiCrownVassalImage().getWidth() * HistoryLog.getImageScale_CrownVassal(i))) {
                HistoryLog.ICON_WIDTH = (int)((float)CFG.ideologiesMgr.getIdeologyID(i).getiCrownVassalImage().getWidth() * HistoryLog.getImageScale_CrownVassal(i));
            }
        }

        HistoryLog.ICON_WIDTH += CFG.PADD * 3;
        HISTORY_LIMIT = CFG.getIsDesktop() ? 200 : 50;
        this.clearHistory();
    }

    public final void updateLanguage() {
        for(int i = 0; i < CFG.timelapseManager.timelapseStatsHistory.lHistory.size(); ++i) {
            for(int j = 0; j < CFG.timelapseManager.timelapseStatsHistory.lHistory.get(j).size(); ++j) {
                ((HistoryLog)((List)CFG.timelapseManager.timelapseStatsHistory.lHistory.get(i)).get(j)).updateLanguage();
            }
        }

    }

    public static final void buildHistoryDates() {
        clearHistoryDates();

        for(int i = 1; i < GameCalendar.TURNID; ++i) {
            lHistoryDates.add(GameCalendar.getDate_ByTurnID(i));
        }

        lHistoryDates.add(GameCalendar.getCurrDate());
        int i = 0;

        for(int iSize = lHistoryDates.size(); i < iSize; ++i) {
            CFG.glyphLay.setText(CFG.fontMain.get(0), lHistoryDates.get(i) + ": ");
            lHistoryDatesWidth.add((int)(CFG.glyphLay.width * 0.7F));
        }

    }

    public static final void clearHistoryDates() {
        lHistoryDates.clear();
        lHistoryDatesWidth.clear();
    }

    public final boolean haveHistory() {
        for(int i = 0; i < CFG.timelapseManager.timelapseStatsHistory.lHistory.size(); ++i) {
            if (CFG.timelapseManager.timelapseStatsHistory.lHistory.get(i).size() > 0) {
                return true;
            }
        }

        return false;
    }

    public final void addNewTurn() {
        List<HistoryLog> turnHistory = new ArrayList();
        CFG.timelapseManager.timelapseStatsHistory.lHistory.add(turnHistory);
        if (CFG.timelapseManager.timelapseStatsHistory.lHistory.size() > HISTORY_LIMIT) {
            CFG.timelapseManager.timelapseStatsHistory.lHistory.remove(0);
        }

    }

    public final void addHistoryLog(HistoryLog tHL) {
        try {
            CFG.timelapseManager.timelapseStatsHistory.lHistory.get(CFG.timelapseManager.timelapseStatsHistory.lHistory.size() - 1).add(tHL);
            if (CFG.menus.getVisibleInGame_History()) {
                CFG.menus.rebuildInGame_History();
            }
        } catch (Exception var3) {
        }

    }

    public final void addHistory(int iTurnID, HistoryLog nHistory) {
        CFG.timelapseManager.timelapseStatsHistory.lHistory.get(iTurnID).add(nHistory);
    }

    public final HistoryLog getHistory(int iTurnID, int i) {
        return (HistoryLog)((List)CFG.timelapseManager.timelapseStatsHistory.lHistory.get(iTurnID)).get(i);
    }

    public final void clearHistory() {
        CFG.timelapseManager.timelapseStatsHistory.lHistory.clear();

    }

    public final int getHistorySize() {
        return CFG.timelapseManager.timelapseStatsHistory.lHistory.size();
    }

    public final int getHistoryTurnSize(int iTurnID) {
        return CFG.timelapseManager.timelapseStatsHistory.lHistory.get(iTurnID).size();
    }
}
