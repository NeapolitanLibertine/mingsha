//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz;

import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Flag;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Image;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_Text;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Event_Outcome_ChangeLeader extends Event_Outcome {
    private static final long serialVersionUID = 6045654316483668628L;
    public int iCivID = -1;
    public LeaderOfCiv_GameData leaderOfCiv;

    public Event_Outcome_ChangeLeader() {
    }

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

    public void outcomeAction() {
        if (this.getCivID() >= 0 && this.getCivID() < CFG.core.getCivsSize()) {
            try {
                CFG.core.getCiv(this.getCivID()).setLeaderN(this.leaderOfCiv);
            } catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }

    }

    public String getConditionText() {
        try {
            return CFG.lang.get("Leader") + ": " + this.leaderOfCiv.getName();
        } catch (Exception var2) {
            return CFG.lang.get("Leader") + ": ---";
        }
    }

    public boolean canMakeAction() {
        return false;
    }

    public String getText() {
        try {
            return CFG.lang.get("Leader") + ": " + this.leaderOfCiv.getName();
        } catch (Exception var2) {
            return CFG.lang.get("Leader") + ": ---";
        }
    }

    public void setText(String nText) {
        try {
            Leader_GameData tLeaderGD = null;

            try {
                try {
                    FileHandle file = Gdx.files.local(nText);
                    tLeaderGD = (Leader_GameData)CFG.deserialize(file.readBytes());
                } catch (GdxRuntimeException var5) {
                    FileHandle file = FileManager.loadFile(nText);
                    tLeaderGD = (Leader_GameData)CFG.deserialize(file.readBytes());
                }
            } catch (ClassNotFoundException var6) {
            } catch (IOException var7) {
            }
            if (tLeaderGD != null) {
                this.leaderOfCiv = tLeaderGD.getLeaderOfCiv();
            }
        } catch (Exception var8) {
        }

    }

    public List<MEHover_2E> getHoverText() {
        try {
            List<MEHover_2E> tElements = new ArrayList();
            List<ME_Hover_2Type> tData = new ArrayList();
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Leader") + ": "));
            tData.add(new ME_Hover_2Type_Text(this.leaderOfCiv.getName(), CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Image(Images.editorLeaders, CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        } catch (Exception var4) {
            List<MEHover_2E> tElements = new ArrayList();
            List<ME_Hover_2Type> tData = new ArrayList();
            tData.add(new ME_Hover_2Type_Flag(this.getCivID()));
            tData.add(new ME_Hover_2Type_Text(CFG.lang.get("Leader") + ": "));
            tData.add(new ME_Hover_2Type_Text("---", CFG.COLOR_HOVER_TITLE));
            tData.add(new ME_Hover_2Type_Image(Images.editorLeaders, CFG.PADD, 0));
            tElements.add(new MEHover_2E(tData));
            tData.clear();
            return tElements;
        }
    }

    public final void editViewID() {
        CFG.menus.setMenuID(View.eCREATE_SCENARIO_EVENTS_OUT_LEADER);
    }
}
