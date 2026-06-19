package team.rainfall.ctap_mingsha;

import age.of.civilizations2.jakowski.lukasz.CFG;
import team.rainfall.finality.luminosity2.annotations.Mixin;

@Mixin(mixinClass = "age.of.civilizations2.jakowski.lukasz.TouchManager")
public class MixinTouchManager {
    private boolean enableScaling = false;
    public static final boolean ALWAYS_ENABLE_SCALING = true;
    public final void updateEnableScaling() {
        if(ALWAYS_ENABLE_SCALING){
            this.enableScaling = true;
            return;
        }
        try {
            this.enableScaling = !CFG.menus.getIn_MainMenu() && !CFG.menus.getIn_AboutMenu() && !CFG.menus.getIn_SKMenu() && !CFG.menus.getIn_MMMenu() && !CFG.menus.getIn_FBMenu() && !CFG.menus.getIn_NVMenu() && !CFG.menus.getIn_InitMenu() && !CFG.menus.getInLoadMap() && !CFG.menus.getInLoadSave();
        }catch (Exception e){
            this.enableScaling = true;
            throw e;
        }
    }
}
