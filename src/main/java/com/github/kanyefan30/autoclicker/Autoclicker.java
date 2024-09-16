package com.github.kanyefan30.autoclicker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class Autoclicker {
    private static int cps = 3;
    private static boolean isAutoClicking = false;
    private static long lastClickTime = 0;

    public static void setCps(int newCps) {
        cps = newCps;
    }

    public static long getClickDelay() {
        return 1000 / cps;
    }

    public static void update(long deltaTime) {
        if (!isAutoClicking) return;
        lastClickTime += deltaTime;
        if (lastClickTime >= getClickDelay()) {
            Minecraft.getMinecraft().thePlayer.swingItem();
            KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindAttack.getKeyCode());
            lastClickTime = 0;
        }
    }

    public static void start() {
        isAutoClicking = true;
    }


    public static void stop() {
        isAutoClicking = false;
    }
}
