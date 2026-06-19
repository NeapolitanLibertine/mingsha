package team.rainfall.ctap_mingsha;

import age.of.civilizations2.jakowski.lukasz.CFG;
import team.rainfall.finality.luminosity2.annotations.Mixin;

import static age.of.civilizations2.jakowski.lukasz.GameCalendar.*;

@Mixin(mixinClass = "age.of.civilizations2.jakowski.lukasz.GameCalendar")
public class MixinGameCalendar {
    public static final String getCurrDate() {
        if(CFG.settingsGD.LANG_TAG.contains("cn")) return DateUtil.getCurrDate();
        return "" + currDay + " " + getMonthName(currMonth) + " " + CFG.gameAges.getYear(currYear);
    }

    public static final String getCurrDate2() {
        if(CFG.settingsGD.LANG_TAG.contains("cn")) return DateUtil.getCurrDate2();
        return TURNID < 10 && currDay == 1 && currMonth == 4 ? "April Fools " + CFG.gameAges.getYear(currYear) : "" + currDay + " " + getMonthName(currMonth) + " " + CFG.gameAges.getYear(currYear);
    }

    public static final String getCurrDate_CreateEvent() {
        if(CFG.settingsGD.LANG_TAG.contains("cn")) return DateUtil.getCurrDate_CreateEvent();
        return "" + CFG.eventsManager.iCreateEvent_Day + " " + getMonthName(CFG.eventsManager.iCreateEvent_Month) + " " + CFG.gameAges.getYear(CFG.eventsManager.iCreateEvent_Year);
    }

    public static final String getCurrDate_Simple() {
        if(CFG.settingsGD.LANG_TAG.contains("cn")) return DateUtil.getCurrDate_Simple();
        return "" + currDay + " " + currMonth + " " + CFG.gameAges.getYear(currYear);
    }
}
