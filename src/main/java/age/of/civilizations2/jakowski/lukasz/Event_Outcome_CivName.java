package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;

import java.util.ArrayList;
import java.util.List;

public final class Event_Outcome_CivName extends Event_Outcome {
    private static final long serialVersionUID = 114514L;

    private int iCivID = -1;
    public String nCivName = "";


    public int getCivID() {
        return this.iCivID;
    }

    public void setCivID(int nCivID) {
        this.iCivID = nCivID;
    }

    public boolean updateCivIDAfterRemove(int nRemovedCivID) {
        if (this.iCivID == nRemovedCivID) {
            this.iCivID = -1;
            return true;
        } else {
            if (nRemovedCivID < this.iCivID) {
                --this.iCivID;
            }

            return false;
        }
    }

    public void setText(String nText) {
        this.nCivName = nText;
    }

    public String getText() {
        return this.nCivName;
    }

    public void outcomeAction() {

        if (this.canMakeAction()) {
            CFG.core.getCiv(this.getCivID()).setCivName(this.nCivName);
        }

    }

    public List<MEHover_2E> getHoverText() {
        try {
            List<MEHover_2E> tElements = new ArrayList<>();
            List<ME_Hover_2Type> tData = new ArrayList<>();
            if (this.canMakeAction()) {
                tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
                tData.add(new ME_Hover_2Type_Text(CFG.lang.get("CivilizationName") + ": "));
                tData.add(new ME_Hover_2Type_Text(CFG.core.getCiv(this.getCivID()).getCivName() + " -> "));
                tData.add(new ME_Hover_2Type_Text(this.nCivName, CFG.COLOR_HOVER_TITLE));
                tElements.add(new MEHover_2E(tData));
                tData.clear();
            }

            return tElements;
        } catch (Exception var3) {
            return new ArrayList<>();
        }
    }

    public boolean canMakeAction() {
        try {

            return this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize() && !this.nCivName.isEmpty();
        } catch (Exception var2) {
            return false;
        }
    }

    public String getConditionText() {
        try {
            return CFG.lang.get("CivilizationName") + ": " + CFG.core.getCiv(this.getCivID()).getCivName();
        } catch (IndexOutOfBoundsException var2) {
            return CFG.lang.get("CivilizationName");
        }
    }

    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_RENAME_CIV);
    }
}