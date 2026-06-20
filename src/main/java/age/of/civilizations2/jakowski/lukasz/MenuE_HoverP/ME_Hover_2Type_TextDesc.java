//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz.MenuE_HoverP;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.Renderer;
import age.of.civilizations2.jakowski.lukasz.Z_Other.GlyphLayout_Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import team.rainfall.ctap_mingsha.CTAP;

import java.util.ArrayList;
import java.util.List;

public class ME_Hover_2Type_TextDesc implements ME_Hover_2Type {
    public List<String> sLines = new ArrayList();
    public int iLineSize = 0;
    private String sText;
    private int iTextWidth;
    private Color oColor;
    public int fontID;
    public int iTextHeight;

    public ME_Hover_2Type_TextDesc(String sText) {
        this.init(sText, new Color(0.9843137F, 0.9843137F, 0.9843137F, 1.0F));
    }

    public ME_Hover_2Type_TextDesc(String sText, int fontID) {
        this.init(sText, new Color(0.9843137F, 0.9843137F, 0.9843137F, 1.0F), fontID);
    }

    public ME_Hover_2Type_TextDesc(String sText, Color nColor) {
        this.init(sText, nColor);
    }

    public ME_Hover_2Type_TextDesc(String sText, Color nColor, int fontID) {
        this.init(sText, nColor, fontID);
    }

    private final void init(String sText, Color oColor) {
        this.init(sText, oColor, CFG.FONT_BOLD_SMALL);
    }

    private final void init(String sText, Color oColor, int fontID) {
        this.oColor = oColor;
        this.fontID = fontID;
        this.iTextHeight = fontID == CFG.FONT_BOLD ? CFG.TEXT_HEIGHT_DEFAULT : CFG.TEXT_HEIGHT_DEFAULT_SMALL;
        ArrayList<String> words = CTAP.tokenize(sText);
        int textPosX = 0;
        int maxW = (int)((float)CFG.BUTTON_W * 4.0F);
        StringBuilder currentLine = new StringBuilder();
        int i = 0;

        for(int iSize = words.size(); i < iSize; ++i) {
            GlyphLayout_Game glyphLayout = new GlyphLayout_Game();
            glyphLayout.setText(CFG.fontMain.get(this.fontID), words.get(i));
            this.iTextWidth = (int)glyphLayout.width;
            glyphLayout.setText(CFG.fontMain.get(this.fontID), currentLine+words.get(i));
            textPosX = (int) glyphLayout.width;
            if (textPosX < maxW) {
                currentLine.append(words.get(i));
            } else {
                if (currentLine.length() > 0) {
                    this.sLines.add(currentLine.toString());
                }

                currentLine = new StringBuilder(words.get(i));
            }
        }

        if (currentLine.length() > 0) {
            this.sLines.add(currentLine.toString());
        }

        GlyphLayout_Game glyphLayout = new GlyphLayout_Game();
        if (!this.sLines.isEmpty() && !this.sLines.get(0).isEmpty()) {
            glyphLayout.setText(CFG.fontMain.get(this.fontID), this.sLines.get(0));
        } else {
            glyphLayout.setText(CFG.fontMain.get(this.fontID), "ABC");
        }
        this.iTextHeight = (int)glyphLayout.height;

        this.iLineSize = this.sLines.size();

        for(int i2 = 0; i2 < this.iLineSize; ++i2) {
            glyphLayout = new GlyphLayout_Game();
            glyphLayout.setText(CFG.fontMain.get(fontID), (CharSequence)this.sLines.get(i2));
            if (glyphLayout.width > (float)this.iTextWidth) {
                this.iTextWidth = (int)glyphLayout.width;
            }
        }

    }

    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha) {
        for(int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, this.fontID, (String)this.sLines.get(i), nPosX, nPosY + CFG.PADD + (this.iTextHeight + CFG.PADD * 2) * i, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
        }

    }

    public void draw(SpriteBatch oSB, int nPosX, int nPosY, float nAlpha, int iMaxWidth) {
        for(int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, this.fontID, (String)this.sLines.get(i), nPosX, nPosY + CFG.PADD + (this.iTextHeight + CFG.PADD * 2) * i, new Color(this.oColor.r, this.oColor.g, this.oColor.b, nAlpha));
        }

    }

    public int getWidth() {
        return this.iTextWidth;
    }

    public int getHeight() {
        return CFG.PADD + CFG.TEXT_HEIGHT_DEFAULT * this.iLineSize + CFG.PADD * 2 * (this.iLineSize - 1);
    }
}
