package team.rainfall.ctap_mingsha;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import team.rainfall.finality.FinalityLogger;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CTAP {
    public static final Lock lock = new ReentrantLock();
    public static final Condition finished = lock.newCondition();
    public static boolean hasGlyph(BitmapFont font,char c){
        if(font == null){
            FinalityLogger.warn("CTAP - hasGlyph got a null BitmapFont!!!");
            return false;
        }

        return hasGlyph(font.getData(),c);
    }
    public static boolean hasGlyph(BitmapFont.BitmapFontData data, char ch) {
        if (data.missingGlyph != null) {
            return true;
        } else {
            return getGlyph(data,ch) != null;
        }
    }
    public static BitmapFont.Glyph getGlyph(BitmapFont.BitmapFontData data, char ch) {
        BitmapFont.Glyph[] page = data.glyphs[ch / 512];
        return page != null ? page[ch & 511] : null;
    }
    public static void getGlyphLayoutData(BitmapFont font, CharSequence str) {
        lock.lock();
        try {
            AtomicReference<GlyphLayout> ref = new AtomicReference<>();
            Gdx.app.postRunnable(() -> {
                lock.lock();
                try {
                    GlyphLayout glyphLayout = new GlyphLayout();
                    glyphLayout.setText(font, str);
                    ref.set(glyphLayout);
                    finished.signal();
                } finally {
                    lock.unlock();
                }
            });
            finished.await();
            ref.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
    private static boolean isCJK(char c) {
        Character.UnicodeScript script = Character.UnicodeScript.of(c);
        return script == Character.UnicodeScript.HAN ||
                script == Character.UnicodeScript.HIRAGANA ||
                script == Character.UnicodeScript.KATAKANA ||
                script == Character.UnicodeScript.HANGUL;
    }
    public static ArrayList<String > tokenize(String s){
        ArrayList<String> token = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isCJK(c)){
                if(sb.length() > 0){
                    token.add(sb.toString());
                    sb.setLength(0);
                }
                token.add(String.valueOf(c));
            } else if (c == ' ') {
                if (sb.length() > 0) {
                    token.add(sb +" ");
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            token.add(sb.toString());
        }
        sb.setLength(0);
        for (String string : token) {
            sb.append(string);
        }
        FinalityLogger.debug("Tokenize "+ sb+" Original "+s);
        return token;
    }
}
