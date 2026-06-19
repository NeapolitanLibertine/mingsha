//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package age.of.civilizations2.jakowski.lukasz.Button2;

import age.of.civilizations2.jakowski.lukasz.*;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.MEHover_2E;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_2Type_TextDesc;
import age.of.civilizations2.jakowski.lukasz.MenuE_HoverP.ME_Hover_v2;
import age.of.civilizations2.jakowski.lukasz.Z_Other.GlyphLayout_Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import team.rainfall.ctap_mingsha.CTAP;

import java.util.ArrayList;
import java.util.List;

public class Text_Desc extends Text_Static {
    public List<String> sLines = new ArrayList();
    public int iLineSize = 0;

    public Text_Desc(String sText, int iPosX, int iPosY, int iWidth) {
        this.init(sText, iPosX, iPosY, iWidth, CFG.FONT_REGULAR_SMALL);
    }

    public Text_Desc(String sText, int iPosX, int iPosY, int iWidth, int nFontID) {
        this.init(sText, iPosX, iPosY, iWidth, nFontID);
    }

    public void init(String sText, int iPosX, int iPosY, int iWidth, int nFontID) {
        this.typeOfMenuElemUI = TypeOfMenuElemUI.TEXT;
        this.fontID = nFontID;
        this.iTextPositionX = 0;
        this.setPosX(iPosX);
        this.setPosY(iPosY);
        this.setWidthE(iWidth);
        this.updateTextPosition();
        ArrayList<String> words = CTAP.tokenize(sText);
        int textPosX;
        int maxW = iWidth - this.getPadding() * 2;
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

        for(i = 0; i < this.iLineSize; ++i) {
            glyphLayout.setText(CFG.fontMain.get(this.fontID), this.sLines.get(i));
            if (glyphLayout.width > (float)this.getWidthE()) {
                this.setWidthE((int)glyphLayout.width);
            }
        }

        this.setHeightE(this.iTextHeight * this.sLines.size() + (this.sLines.size() - 1) * CFG.PADD * 2 + this.getPaddingY() * 2);
    }

    public void drawE(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        this.drawBG(oSB, iTranslateX, iTranslateY, isActive, scrollableY);

        for(int i = 0; i < this.iLineSize; ++i) {
            Renderer.drawText(oSB, this.fontID, this.sLines.get(i), this.getPosXE() + this.getPadding() + iTranslateX, this.getPosY() + this.getPaddingY() + (this.iTextHeight + CFG.PADD * 2) * i + iTranslateY, this.getColor(isActive));
        }

    }

    public void drawBG(SpriteBatch oSB, int iTranslateX, int iTranslateY, boolean isActive, boolean scrollableY) {
        oSB.setColor(new Color(Colors.COLOR_STATS_RECT_BG.r, Colors.COLOR_STATS_RECT_BG.g, Colors.COLOR_STATS_RECT_BG.b, getBoxAlpha(this.getIsClickable(), this.getIsHovered(), isActive)));
        Renderer.drawBox2(oSB, Images.statsRectBG, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 0.8F);
        oSB.setColor(new Color(Colors.COLOR_GRADIENT.r, Colors.COLOR_GRADIENT.g, Colors.COLOR_GRADIENT.b, 0.175F));
        IMGManager.getIMG(Images.gradientFull).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE());
        oSB.setColor(new Color(Colors.COLOR_GRADIENT.r, Colors.COLOR_GRADIENT.g, Colors.COLOR_GRADIENT.b, 0.3F));
        IMGManager.getIMG(Images.gradientXY).draw(oSB, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), false, true);
        oSB.setColor(new Color(0.0F, 0.0F, 0.0F, 0.45F));
        Renderer.drawBox2(oSB, Images.statsRectBGBorder, this.getPosXE() + iTranslateX, this.getPosY() + iTranslateY, this.getWidthE(), this.getHeightE(), 1.0F);
        oSB.setColor(Color.WHITE);
    }

    public static final float getBoxAlpha(boolean clickable, boolean isHovered, boolean isActive) {
        return clickable ? (isActive ? 0.85F : (isHovered ? 0.7F : 0.5F)) : 0.2F;
    }

    protected Color getColor(boolean isActive) {
        if (isActive) {
            return Colors.BUTTON_TEXT_ACTIVE;
        } else if (this.getIsHovered()) {
            return Colors.BUTTON_TEXT_HOVERED;
        } else {
            return this.getIsClickable() ? Colors.BUTTON_TEXT : Colors.BUTTON_TEXT_DISABLED;
        }
    }

    public final int getPadding() {
        return CFG.PADD * 2;
    }

    public final int getPaddingY() {
        return CFG.PADD * 3;
    }

    public void buildElemHover() {
        List<MEHover_2E> nElements = new ArrayList();
        List<ME_Hover_2Type> nData = new ArrayList();
        StringBuilder text = new StringBuilder();

        for (String sLine : this.sLines) {
            text.append(sLine);
        }

        nData.add(new ME_Hover_2Type_TextDesc(text.toString(), CFG.COLOR_NEUTRAL));
        nElements.add(new MEHover_2E(nData));
        nData.clear();
        this.menuElemHover = new ME_Hover_v2(nElements);
    }
}
