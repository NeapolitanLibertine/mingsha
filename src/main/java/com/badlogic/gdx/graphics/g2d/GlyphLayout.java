//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.badlogic.gdx.graphics.g2d;

import age.of.civilizations2.jakowski.lukasz.CFG;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Colors;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import team.rainfall.ctap_mingsha.CTAP;

public class GlyphLayout implements Pool.Poolable {
    private static final Pool<GlyphRun> glyphRunPool = Pools.get(GlyphRun.class);
    private static final IntArray colorStack = new IntArray(4);
    private static final float epsilon = 1.0E-4F;
    public final Array<GlyphRun> runs = new Array(1);
    public final IntArray colors = new IntArray(2);
    public int glyphCount;
    public float width;
    public float height;

    public GlyphLayout() {
    }

    public GlyphLayout(BitmapFont font, CharSequence str) {
        this.setText(font, str);
    }

    public GlyphLayout(BitmapFont font, CharSequence str, Color color, float targetWidth, int halign, boolean wrap) {
        this.setText(font, str, color, targetWidth, halign, wrap);
    }

    public GlyphLayout(BitmapFont font, CharSequence str, int start, int end, Color color, float targetWidth, int halign, boolean wrap, String truncate) {
        this.setText(font, str, start, end, color, targetWidth, halign, wrap, truncate);
    }

    public void setText(BitmapFont font, CharSequence str) {
        if(!Thread.currentThread().getName().contains("main") && CFG.getIsDesktop()) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!CTAP.hasGlyph(font, c)) {
                    CTAP.getGlyphLayoutData(font,str);
                    break;
                }
            }
        }
        this.setText(font, str, 0, str.length(), font.getColor(), 0.0F, 8, false, (String)null);
    }

    public void setText(BitmapFont font, CharSequence str, Color color, float targetWidth, int halign, boolean wrap) {
        this.setText(font, str, 0, str.length(), color, targetWidth, halign, wrap, (String)null);
    }

    public void setText(BitmapFont font, CharSequence str, int start, int end, Color color, float targetWidth, int halign, boolean wrap, @Null String truncate) {
        this.reset();
        BitmapFont.BitmapFontData fontData = font.data;
        if (start == end) {
            this.height = fontData.capHeight;
        } else {
            if (wrap) {
                targetWidth = Math.max(targetWidth, fontData.spaceXadvance * 3.0F);
            }

            boolean wrapOrTruncate = wrap || truncate != null;
            int currentColor = color.toIntBits();
            int nextColor = currentColor;
            this.colors.add(0, currentColor);
            boolean markupEnabled = fontData.markupEnabled;
            if (markupEnabled) {
                colorStack.add(currentColor);
            }

            boolean isLastRun = false;
            float y = 0.0F;
            float down = fontData.down;
            GlyphRun lineRun = null;
            BitmapFont.Glyph lastGlyph = null;
            int runStart = start;

            label134:
            while(true) {
                boolean newline = false;
                int runEnd;
                if (start == end) {
                    if (runStart == end) {
                        break;
                    }

                    runEnd = end;
                    isLastRun = true;
                } else {
                    switch (str.charAt(start++)) {
                        case '\n':
                            runEnd = start - 1;
                            newline = true;
                            break;
                        case '[':
                            if (markupEnabled) {
                                int length = this.parseColorMarkup(str, start, end);
                                if (length < 0) {
                                    if (length == -2) {
                                        ++start;
                                    }
                                } else {
                                    runEnd = start - 1;
                                    start += length + 1;
                                    if (start == end) {
                                        isLastRun = true;
                                    } else {
                                        nextColor = colorStack.peek();
                                    }
                                    break;
                                }
                            }
                        default:
                            continue;
                    }
                }

                GlyphRun run = (GlyphRun)glyphRunPool.obtain();
                run.x = 0.0F;
                run.y = y;
                fontData.getGlyphs(run, str, runStart, runEnd, lastGlyph);
                this.glyphCount += run.glyphs.size;
                if (nextColor != currentColor) {
                    if (this.colors.get(this.colors.size - 2) == this.glyphCount) {
                        this.colors.set(this.colors.size - 1, nextColor);
                    } else {
                        this.colors.add(this.glyphCount);
                        this.colors.add(nextColor);
                    }

                    currentColor = nextColor;
                }

                label157: {
                    if (run.glyphs.size == 0) {
                        glyphRunPool.free(run);
                        if (lineRun == null) {
                            break label157;
                        }
                    } else if (lineRun == null) {
                        lineRun = run;
                        this.runs.add(run);
                    } else {
                        lineRun.appendRun(run);
                        glyphRunPool.free(run);
                    }

                    if (!newline && !isLastRun) {
                        lastGlyph = (BitmapFont.Glyph)lineRun.glyphs.peek();
                    } else {
                        this.setLastGlyphXAdvance(fontData, lineRun);
                        lastGlyph = null;
                    }

                    if (wrapOrTruncate && lineRun.glyphs.size != 0 && (newline || isLastRun)) {
                        float runWidth = lineRun.xAdvances.first() + lineRun.xAdvances.get(1);

                        for(int i = 2; i < lineRun.xAdvances.size; ++i) {
                            BitmapFont.Glyph glyph = (BitmapFont.Glyph)lineRun.glyphs.get(i - 1);
                            float glyphWidth = this.getGlyphWidth(glyph, fontData);
                            if (runWidth + glyphWidth - 1.0E-4F <= targetWidth) {
                                runWidth += lineRun.xAdvances.items[i];
                            } else {
                                if (truncate != null) {
                                    this.truncate(fontData, lineRun, targetWidth, truncate);
                                    break label134;
                                }

                                int wrapIndex = fontData.getWrapIndex(lineRun.glyphs, i);
                                if (wrapIndex == 0 && lineRun.x == 0.0F || wrapIndex >= lineRun.glyphs.size) {
                                    wrapIndex = i - 1;
                                }

                                lineRun = this.wrap(fontData, lineRun, wrapIndex);
                                if (lineRun == null) {
                                    break;
                                }

                                this.runs.add(lineRun);
                                y += down;
                                lineRun.x = 0.0F;
                                lineRun.y = y;
                                runWidth = lineRun.xAdvances.first() + lineRun.xAdvances.get(1);
                                i = 1;
                            }
                        }
                    }
                }

                if (newline) {
                    lineRun = null;
                    lastGlyph = null;
                    if (runEnd == runStart) {
                        y += down * fontData.blankLineScale;
                    } else {
                        y += down;
                    }
                }

                runStart = start;
            }

            this.height = fontData.capHeight + Math.abs(y);
            this.calculateWidths(fontData);
            this.alignRuns(targetWidth, halign);
            if (markupEnabled) {
                colorStack.clear();
            }

        }
    }

    private void calculateWidths(BitmapFont.BitmapFontData fontData) {
        float width = 0.0F;
        Object[] runsItems = this.runs.items;
        int i = 0;

        for(int n = this.runs.size; i < n; ++i) {
            GlyphRun run = (GlyphRun)runsItems[i];
            float[] xAdvances = run.xAdvances.items;
            float runWidth = run.x + xAdvances[0];
            float max = 0.0F;
            Object[] glyphs = run.glyphs.items;
            int ii = 0;

            for(int nn = run.glyphs.size; ii < nn; runWidth += xAdvances[ii]) {
                BitmapFont.Glyph glyph = (BitmapFont.Glyph)glyphs[ii];
                float glyphWidth = this.getGlyphWidth(glyph, fontData);
                max = Math.max(max, runWidth + glyphWidth);
                ++ii;
            }

            run.width = Math.max(runWidth, max) - run.x;
            width = Math.max(width, run.x + run.width);
        }

        this.width = width;
    }

    private void alignRuns(float targetWidth, int halign) {
        if ((halign & 8) == 0) {
            boolean center = (halign & 1) != 0;
            Object[] runsItems = this.runs.items;
            int i = 0;

            for(int n = this.runs.size; i < n; ++i) {
                GlyphRun run = (GlyphRun)runsItems[i];
                run.x += center ? 0.5F * (targetWidth - run.width) : targetWidth - run.width;
            }
        }

    }

    private void truncate(BitmapFont.BitmapFontData fontData, GlyphRun run, float targetWidth, String truncate) {
        int glyphCount = run.glyphs.size;
        GlyphRun truncateRun = (GlyphRun)glyphRunPool.obtain();
        fontData.getGlyphs(truncateRun, truncate, 0, truncate.length(), (BitmapFont.Glyph)null);
        float truncateWidth = 0.0F;
        if (truncateRun.xAdvances.size > 0) {
            this.setLastGlyphXAdvance(fontData, truncateRun);
            float[] xAdvances = truncateRun.xAdvances.items;
            int i = 1;

            for(int n = truncateRun.xAdvances.size; i < n; ++i) {
                truncateWidth += xAdvances[i];
            }
        }

        targetWidth -= truncateWidth;
        int count = 0;
        float width = run.x;

        for(float[] xAdvances = run.xAdvances.items; count < run.xAdvances.size; ++count) {
            float xAdvance = xAdvances[count];
            width += xAdvance;
            if (width > targetWidth) {
                break;
            }
        }

        if (count > 1) {
            run.glyphs.truncate(count - 1);
            run.xAdvances.truncate(count);
            this.setLastGlyphXAdvance(fontData, run);
            if (truncateRun.xAdvances.size > 0) {
                run.xAdvances.addAll(truncateRun.xAdvances, 1, truncateRun.xAdvances.size - 1);
            }
        } else {
            run.glyphs.clear();
            run.xAdvances.clear();
            run.xAdvances.addAll(truncateRun.xAdvances);
        }

        int droppedGlyphCount = glyphCount - run.glyphs.size;
        if (droppedGlyphCount > 0) {
            this.glyphCount -= droppedGlyphCount;
            if (fontData.markupEnabled) {
                while(this.colors.size > 2 && this.colors.get(this.colors.size - 2) >= this.glyphCount) {
                    IntArray var10000 = this.colors;
                    var10000.size -= 2;
                }
            }
        }

        run.glyphs.addAll(truncateRun.glyphs);
        this.glyphCount += truncate.length();
        glyphRunPool.free(truncateRun);
    }

    private GlyphRun wrap(BitmapFont.BitmapFontData fontData, GlyphRun first, int wrapIndex) {
        Array<BitmapFont.Glyph> glyphs2 = first.glyphs;
        int glyphCount = first.glyphs.size;
        FloatArray xAdvances2 = first.xAdvances;

        int firstEnd;
        for(firstEnd = wrapIndex; firstEnd > 0 && fontData.isWhitespace((char)((BitmapFont.Glyph)glyphs2.get(firstEnd - 1)).id); --firstEnd) {
        }

        int secondStart;
        for(secondStart = wrapIndex; secondStart < glyphCount && fontData.isWhitespace((char)((BitmapFont.Glyph)glyphs2.get(secondStart)).id); ++secondStart) {
        }

        GlyphRun second = null;
        if (secondStart < glyphCount) {
            second = (GlyphRun)glyphRunPool.obtain();
            Array<BitmapFont.Glyph> glyphs1 = second.glyphs;
            glyphs1.addAll(glyphs2, 0, firstEnd);
            glyphs2.removeRange(0, secondStart - 1);
            first.glyphs = glyphs1;
            second.glyphs = glyphs2;
            FloatArray xAdvances1 = second.xAdvances;
            xAdvances1.addAll(xAdvances2, 0, firstEnd + 1);
            xAdvances2.removeRange(1, secondStart);
            xAdvances2.items[0] = this.getLineOffset(glyphs2, fontData);
            first.xAdvances = xAdvances1;
            second.xAdvances = xAdvances2;
            int firstGlyphCount = first.glyphs.size;
            int secondGlyphCount = second.glyphs.size;
            int droppedGlyphCount = glyphCount - firstGlyphCount - secondGlyphCount;
            this.glyphCount -= droppedGlyphCount;
            if (fontData.markupEnabled && droppedGlyphCount > 0) {
                int reductionThreshold = this.glyphCount - secondGlyphCount;

                for(int i = this.colors.size - 2; i >= 2; i -= 2) {
                    int colorChangeIndex = this.colors.get(i);
                    if (colorChangeIndex <= reductionThreshold) {
                        break;
                    }

                    this.colors.set(i, colorChangeIndex - droppedGlyphCount);
                }
            }
        } else {
            glyphs2.truncate(firstEnd);
            xAdvances2.truncate(firstEnd + 1);
            int droppedGlyphCount = secondStart - firstEnd;
            if (droppedGlyphCount > 0) {
                this.glyphCount -= droppedGlyphCount;
                if (fontData.markupEnabled && this.colors.get(this.colors.size - 2) > this.glyphCount) {
                    int lastColor;
                    IntArray var10000;
                    for(lastColor = this.colors.peek(); this.colors.get(this.colors.size - 2) > this.glyphCount; var10000.size -= 2) {
                        var10000 = this.colors;
                    }

                    this.colors.set(this.colors.size - 2, this.glyphCount);
                    this.colors.set(this.colors.size - 1, lastColor);
                }
            }
        }

        if (firstEnd == 0) {
            glyphRunPool.free(first);
            this.runs.pop();
        } else {
            this.setLastGlyphXAdvance(fontData, first);
        }

        return second;
    }

    private void setLastGlyphXAdvance(BitmapFont.BitmapFontData fontData, GlyphRun run) {
        BitmapFont.Glyph last = (BitmapFont.Glyph)run.glyphs.peek();
        if (!last.fixedWidth) {
            run.xAdvances.items[run.xAdvances.size - 1] = this.getGlyphWidth(last, fontData);
        }

    }

    private float getGlyphWidth(BitmapFont.Glyph glyph, BitmapFont.BitmapFontData fontData) {
        return (float)(glyph.width + glyph.xoffset) * fontData.scaleX - fontData.padRight;
    }

    private float getLineOffset(Array<BitmapFont.Glyph> glyphs, BitmapFont.BitmapFontData fontData) {
        return (float)(-((BitmapFont.Glyph)glyphs.first()).xoffset) * fontData.scaleX - fontData.padLeft;
    }

    private int parseColorMarkup(CharSequence str, int start, int end) {
        if (start == end) {
            return -1;
        } else {
            switch (str.charAt(start)) {
                case '#':
                    int color = 0;
                    int i = start + 1;

                    for(; i < end; ++i) {
                        char ch = str.charAt(i);
                        if (ch == ']') {
                            if (i >= start + 2 && i <= start + 9) {
                                if (i - start < 8) {
                                    color = color << (9 - (i - start) << 2) | 255;
                                }

                                colorStack.add(Integer.reverseBytes(color));
                                return i - start;
                            }
                            break;
                        }

                        color = (color << 4) + ch;
                        if (ch >= '0' && ch <= '9') {
                            color -= 48;
                        } else if (ch >= 'A' && ch <= 'F') {
                            color -= 55;
                        } else {
                            if (ch < 'a' || ch > 'f') {
                                break;
                            }

                            color -= 87;
                        }
                    }

                    return -1;
                case '[':
                    return -2;
                case ']':
                    if (colorStack.size > 1) {
                        colorStack.pop();
                    }

                    return 0;
                default:
                    for(i = start + 1; i < end; ++i) {
                        char ch = str.charAt(i);
                        if (ch == ']') {
                            Color color2 = Colors.get(str.subSequence(start, i).toString());
                            if (color2 == null) {
                                return -1;
                            }

                            colorStack.add(color2.toIntBits());
                            return i - start;
                        }
                    }

                    return -1;
            }
        }
    }

    public void reset() {
        glyphRunPool.freeAll(this.runs);
        this.runs.clear();
        this.colors.clear();
        this.glyphCount = 0;
        this.width = 0.0F;
        this.height = 0.0F;
    }

    public String toString() {
        if (this.runs.size == 0) {
            return "";
        } else {
            StringBuilder buffer = new StringBuilder(128);
            buffer.append(this.width);
            buffer.append('x');
            buffer.append(this.height);
            buffer.append('\n');
            int i = 0;

            for(int n = this.runs.size; i < n; ++i) {
                buffer.append(((GlyphRun)this.runs.get(i)).toString());
                buffer.append('\n');
            }

            buffer.setLength(buffer.length() - 1);
            return buffer.toString();
        }
    }

    public static class GlyphRun implements Pool.Poolable {
        public Array<BitmapFont.Glyph> glyphs = new Array();
        public FloatArray xAdvances = new FloatArray();
        public float x;
        public float y;
        public float width;

        public GlyphRun() {
        }

        void appendRun(GlyphRun run) {
            this.glyphs.addAll(run.glyphs);
            if (this.xAdvances.notEmpty()) {
                --this.xAdvances.size;
            }

            this.xAdvances.addAll(run.xAdvances);
        }

        public void reset() {
            this.glyphs.clear();
            this.xAdvances.clear();
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder(this.glyphs.size + 32);
            Array<BitmapFont.Glyph> glyphs = this.glyphs;
            int i = 0;

            for(int n = glyphs.size; i < n; ++i) {
                BitmapFont.Glyph g = (BitmapFont.Glyph)glyphs.get(i);
                buffer.append((char)g.id);
            }

            buffer.append(", ");
            buffer.append(this.x);
            buffer.append(", ");
            buffer.append(this.y);
            buffer.append(", ");
            buffer.append(this.width);
            return buffer.toString();
        }
    }
}
