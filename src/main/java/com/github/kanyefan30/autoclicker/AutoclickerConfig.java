package com.github.kanyefan30.autoclicker;

public class AutoclickerConfig {
    public static int cps = 10;

    public static int getCps() {
        return cps;
    }

    public static void setCps(int newCps) {
        cps = newCps;
    }

    public static long getClickDelay() {
        return 1000 / cps;
    }
}
