package team.rainfall.ctap_mingsha;

import team.rainfall.finality.luminosity2.annotations.Mixin;

@Mixin(mixinClass = "age.of.civilizations2.jakowski.lukasz.MapBG")
public class MixinMapBG {
    private int iMinimapHeight;
    private int iMinimapWidth;
    public final int getMinimapWidth() {
        return Math.max(iMinimapWidth,0);
    }

    public final int getMinimapHeight() {
        return Math.max(iMinimapHeight,0);
    }
}
