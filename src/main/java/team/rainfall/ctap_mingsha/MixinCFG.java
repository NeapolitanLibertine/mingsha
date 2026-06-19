package team.rainfall.ctap_mingsha;

import age.of.civilizations2.jakowski.lukasz.Files.FileManager;
import age.of.civilizations2.jakowski.lukasz.GameValues.GameValues;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.GdxRuntimeException;
import team.rainfall.finality.luminosity2.annotations.Mixin;

import static age.of.civilizations2.jakowski.lukasz.CFG.*;
@Mixin(mixinClass = "age.of.civilizations2.jakowski.lukasz.CFG")
public class MixinCFG {
    public static final void loadFont(String sFont, String charset, int fontSize) {
        float texSize = charset.getBytes().length;
        int texSize2 = (int) (texSize * ((float) 2 / 3) + 1024);
        if (texSize2 < 4096) {
            texSize2 = 4096;
        }
        FreeTypeFontGenerator.setMaxTextureSize(texSize2);

        FreeTypeFontGenerator generator = null;
        if (fontSize < 0) {
            fontSize = (int)((float) GameValues.DEFAULT_FONT_SIZE * GUI_SCALE);
        }

        try {
            generator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        } catch (Exception var5) {
            generator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }

        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

        params.characters = charset;
        params.incremental = true;
        params.size = Math.max(fontSize, 6);
        params.color = Color.WHITE;
        params.minFilter = Texture.TextureFilter.Linear;
        params.magFilter = Texture.TextureFilter.Linear;
        fontMain.add(generator.generateFont(params));
        if (fontMain.size() == 1) {
            glyphLay.setText(fontMain.get(0), "AyӏdZOP38901ERLj");
            TEXT_HEIGHT_DEFAULT = (int)glyphLay.height;
        }
        fontMain.get(fontMain.size() - 1).getData().markupEnabled = true;
        settingsGD.updateCitiesFontScale();
    }

    public static final void loadFontArmy() {
        if (fontArmy != null) {
            fontArmy.dispose();
            fontArmy = null;
        }

        String sFont = lang.get("fontArmy");
        if (sFont.equals("fontArmy")) {
            sFont = "rbold.ttf";
        }

        FreeTypeFontGenerator genaratorArmy = null;

        try {
            genaratorArmy = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        } catch (GdxRuntimeException var3) {
            genaratorArmy = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }

        FreeTypeFontGenerator.FreeTypeFontParameter paramsArmy = new FreeTypeFontGenerator.FreeTypeFontParameter();
        paramsArmy.size = Math.max(settingsGD.FONT_ARMY_SIZEX, 6);
        paramsArmy.color = Color.WHITE;
        paramsArmy.minFilter = Texture.TextureFilter.Linear;
        paramsArmy.magFilter = Texture.TextureFilter.Linear;
        paramsArmy.characters = "0123456789+-.,%?!ABCDEFGHIJKLMNOPQRSTUVWXYZ百千万亿";
        fontArmy = genaratorArmy.generateFont(paramsArmy);
        genaratorArmy.dispose();
        glyphLay.setText(fontArmy, "-+1234567890");
        ARMY_HEIGHT = (int)glyphLay.height;
    }

    public static final void loadFontBorder() {
        if (fontBorder != null) {
            fontBorder.dispose();
            fontBorder = null;
        }

        String sFont = lang.get("fontCivNames");
        if (sFont.equals("font2")) {
            sFont = "rbold.ttf";
        }

        FreeTypeFontGenerator genarator = null;

        try {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        } catch (GdxRuntimeException var3) {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }

        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.incremental = true;
        params.characters = lang.get("charset");
        params.size = settingsGD.FONT_BORDER_SIZEX;
        params.color = new Color(settingsGD.civNamesFontColor.getR(), settingsGD.civNamesFontColor.getG(), settingsGD.civNamesFontColor.getB(), settingsGD.civNamesFontColor_ALPHA);
        params.minFilter = Texture.TextureFilter.Linear;
        params.magFilter = Texture.TextureFilter.Linear;
        params.borderColor = new Color(settingsGD.civNamesFontColorBorder.getR(), settingsGD.civNamesFontColorBorder.getG(), settingsGD.civNamesFontColorBorder.getB(), settingsGD.civNamesFontColorBorder_ALPHA);
        params.borderWidth = (float)settingsGD.FONT_BORDER_WIDTH;
        fontBorder = genarator.generateFont(params);
        //genarator.dispose();
        loadFontBorder2();
    }

    public static final void loadFontBorder2() {
        if (fontBorder2 != null) {
            fontBorder2.dispose();
            fontBorder2 = null;
        }

        String sFont = lang.get("fontCivNames");
        if (sFont.equals("font2")) {
            sFont = "rbold.ttf";
        }

        FreeTypeFontGenerator genarator = null;

        try {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/" + sFont));
        } catch (GdxRuntimeException var3) {
            genarator = new FreeTypeFontGenerator(FileManager.loadFile("game/fonts/rbold.ttf"));
        }
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.incremental = true;
        params.characters = lang.get("charset");
        params.size = settingsGD.FONT_BORDER_SIZEX;
        params.color = new Color(settingsGD.civNamesFontColor.getR(), settingsGD.civNamesFontColor.getG(), settingsGD.civNamesFontColor.getB(), settingsGD.civNamesFontColor_ALPHA);
        params.minFilter = Texture.TextureFilter.Linear;
        params.magFilter = Texture.TextureFilter.Linear;
        params.borderColor = new Color(settingsGD.civNamesFontColorBorder.getR(), settingsGD.civNamesFontColorBorder.getG(), settingsGD.civNamesFontColorBorder.getB(), settingsGD.civNamesFontColorBorder_ALPHA);
        params.borderWidth = (float)settingsGD.FONT_BORDER_WIDTH;
        fontBorder2 = genarator.generateFont(params);
        //genarator.dispose();
    }
    public static final String getNumber_SHORT(int nValue) {
        if(settingsGD.LANG_TAG.contains("cn")){
            return NumberShortenUtil.getNumber_SHORT(nValue);
        }
        if (nValue < 1000) {
            return "" + nValue;
        } else if (nValue < 1000000) {
            String outValue = "" + (float)nValue / 1000.0F;

            try {
                return outValue.charAt(outValue.indexOf(".") + 1) == '0' ? nValue / 1000 + lang.get("Value_Thousand") : outValue.substring(0, outValue.indexOf(".") + 2) + lang.get("Value_Thousand");
            } catch (IndexOutOfBoundsException var3) {
                return nValue / 1000 + lang.get("Value_Thousand");
            }
        } else {
            String outValue = "" + (float)nValue / 1000000.0F;

            try {
                return outValue.charAt(outValue.indexOf(".") + 1) == '0' ? nValue / 1000 + lang.get("Value_Million") : outValue.substring(0, outValue.indexOf(".") + 2) + lang.get("Value_Million");
            } catch (IndexOutOfBoundsException var4) {
                return nValue / 1000 + lang.get("Value_Million");
            }
        }
    }

    public static String getNumber_SHORT_ARMY(int nValue) {
        if(settingsGD.LANG_TAG.contains("cn")){
            return NumberShortenUtil.getNumber_SHORT_ARMY(nValue);
        }
        if (nValue < settingsGD.SHORTEN_ARMY_OVER) {
            return "" + nValue;
        } else if (nValue < 1000000) {
            String outValue = "" + (float)nValue / 1000.0F;

            try {
                return outValue.charAt(outValue.indexOf(".") + 1) == '0' ? nValue / 1000 + lang.get("Value_Thousand") : outValue.substring(0, outValue.indexOf(".") + 2) + lang.get("Value_Thousand");
            } catch (IndexOutOfBoundsException var3) {
                return nValue / 1000 + lang.get("Value_Thousand");
            }
        } else {
            String outValue = "" + (float)nValue / 1000000.0F;

            try {
                return outValue.charAt(outValue.indexOf(".") + 1) == '0' ? nValue / 1000 + lang.get("Value_Million") : outValue.substring(0, outValue.indexOf(".") + 2) + lang.get("Value_Million");
            } catch (IndexOutOfBoundsException var4) {
                return nValue / 1000 + lang.get("Value_Million");
            }
        }
    }

    public static String getNumber_SHORT(long nValue) {
        if(settingsGD.LANG_TAG.contains("cn")){
            return NumberShortenUtil.getNumber_SHORT(nValue);
        }
        if (nValue < 1000L) {
            return "" + nValue;
        } else if (nValue < 1000000L) {
            float thousands = (float)nValue / 1000.0F;
            String outValue = String.format("%.1f", thousands);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }

            return outValue.replace(',', '.') + lang.get("Value_Thousand");
        } else {
            float millions = (float)nValue / 1000000.0F;
            String outValue = String.format("%.1f", millions);
            if (outValue.endsWith(".0")) {
                outValue = outValue.substring(0, outValue.length() - 2);
            }

            return outValue.replace(',', '.') + lang.get("Value_Million");
        }
    }
}
