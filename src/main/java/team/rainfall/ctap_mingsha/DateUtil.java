package team.rainfall.ctap_mingsha;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.GameCalendar;

import static age.of.civilizations2.jakowski.lukasz.GameCalendar.*;
import static age.of.civilizations2.jakowski.lukasz.GameCalendar.currYear;

public class DateUtil {
    public static final String getCurrDate() {
        return CFG.gameAges.getYear(currYear) + CFG.lang.get("Year") + " " + getMonthName(currMonth) + " " + currDay + CFG.lang.get("Day");
    }

    public static final String getCurrDate2() {
        return TURNID < 10 && currDay == 1 && currMonth == 4 ? "April Fools " + CFG.gameAges.getYear(currYear) : (
                CFG.gameAges.getYear(currYear) + CFG.lang.get("Year") + " " + getMonthName(currMonth) + " " + currDay + CFG.lang.get("Day")
        );
    }

    public static final String getCurrDate_CreateEvent() {
        return CFG.gameAges.getYear(CFG.eventsManager.iCreateEvent_Year) + CFG.lang.get("Year") + " " + getMonthName(CFG.eventsManager.iCreateEvent_Month) + " " + CFG.eventsManager.iCreateEvent_Day + CFG.lang.get("Day");
    }

    public static final String getCurrDate_Simple() {
        return CFG.gameAges.getYear(currYear) + "." + currMonth + "." + currDay;
    }
    public static final String getCurrDate_Leader(int nCivID) {
        return CFG.gameAges.getYear(CFG.core.getCiv(nCivID).civGD.leaderData.getYear()) + CFG.lang.get("Year") + " " + GameCalendar.getMonthName(CFG.core.getCiv(nCivID).civGD.leaderData.getMonth()) + " " + CFG.core.getCiv(nCivID).civGD.leaderData.getDay() + CFG.lang.get("Day");
    }
}
