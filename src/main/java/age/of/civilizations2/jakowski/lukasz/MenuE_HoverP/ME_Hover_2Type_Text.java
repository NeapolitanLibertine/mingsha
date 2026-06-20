//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ME_Hover_2Type_Text implements ME_Hover_2Type {
    private String sText;
    private int iTextWidth;
    private Color oColor;

    public ME_Hover_2Type_Text(String sText) {
        this.init(sText, new Color(0.9843137F, 0.9843137F, 0.9843137F, 1.0F));
    }

    public ME_Hover_2Type_Text(String sText, Color nColor) {
        this.init(sText, nColor);
    }

    private final void init(String sText, Color oColor) {
        this.sText = sText;
        this.oColor = oColor;
        CFG.glyphLay.setText(CFG.fontMain.get(0), sText);
        this.iTextWidth = (int)CFG.glyphLay.width;
    }

    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        Renderer.drawText(oSB, this.sText, nPosX, nPosY + CFG.PADD, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
    }

    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        Renderer.drawText(oSB, this.sText, nPosX, nPosY + CFG.PADD, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
    }

    public int getWidth() {
        return this.iTextWidth;
    }

    public int getHeight() {
        return CFG.TEXT_HEIGHT_DEFAULT + CFG.PADD;
    }
}
