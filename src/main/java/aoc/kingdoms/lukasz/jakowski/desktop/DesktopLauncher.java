//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package aoc.kingdoms.lukasz.jakowski.desktop;

import age.of.civilizations2.jakowski.lukasz.CFG;
import aoc.kingdoms.lukasz.jakowski.AA_Game;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DesktopLauncher {
    public DesktopLauncher() {
    }

    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Age of History 2: Definitive Edition");

        try {
            config.setWindowIcon(FileType.Internal, "UI/ic_16x16.png");
            config.setWindowIcon(FileType.Internal, "UI/ic_32x32.png");
            config.setWindowIcon(FileType.Internal, "UI/ic_128x128.png");
        } catch (Exception ex) {
            CFG.exceptionStack(ex);
        }

        config.setResizable(false);
        int tWidth = -1;
        int tHeight = -1;
        boolean tFullscreen = true;
        int tSamples = -1;
        boolean tVSync = false;
        FileReader fr = null;
        String sLine = "";
        System.out.println(System.getProperty("file.encoding"));

        try {
            fr = new FileReader("settings/config.txt");
            BufferedReader bfr = new BufferedReader(fr);

            while((sLine = bfr.readLine()) != null) {
                String[] tempR = sLine.replace(";", "").split("=");

                try {
                    if (tempR[0].equals("FULLSCREEN")) {
                        tFullscreen = Boolean.parseBoolean(tempR[1]);
                    } else if (tempR[0].equals("WIDTH")) {
                        tWidth = Integer.parseInt(tempR[1]);
                    } else if (tempR[0].equals("HEIGHT")) {
                        tHeight = Integer.parseInt(tempR[1]);
                    } else if (tempR[0].equals("ANTIALIASING")) {
                        tSamples = Integer.parseInt(tempR[1]);
                    } else if (tempR[0].equals("VSYNC")) {
                        tVSync = Boolean.parseBoolean(tempR[1]);
                    }
                } catch (IndexOutOfBoundsException var13) {
                    tWidth = -1;
                    tHeight = -1;
                    tFullscreen = true;
                    tSamples = -1;
                    tVSync = false;
                    break;
                } catch (IllegalArgumentException var14) {
                    tWidth = -1;
                    tHeight = -1;
                    tFullscreen = true;
                    tSamples = -1;
                    tVSync = false;
                    break;
                }
            }

            fr.close();
        } catch (IOException var15) {
            tWidth = -1;
            tHeight = -1;
            tFullscreen = true;
            tSamples = -1;
            tVSync = false;
        }

        if (tWidth < 0 && tHeight < 0) {
            Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode();
            config.setWindowedMode(displayMode.width + 1, displayMode.height + 1);
            config.setDecorated(false);
        } else {
            config.setWindowedMode(tWidth, tHeight);
            config.setDecorated(true);
            if (tFullscreen) {
                Graphics.DisplayMode displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode();
                config.setWindowedMode(displayMode.width + 1, displayMode.height + 1);
                config.setDecorated(false);
            }
        }
        config.setAutoIconify(false);
        config.useVsync(tVSync);
        config.setAudioConfig(32, 512, 18);
        config.setForegroundFPS(60);
        new Lwjgl3Application(new AA_Game(), config);
    }
}
