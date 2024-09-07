package com.github.kanyefan30.autoclicker;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class AutoclickerHandler {
    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean isAutoClicking = false;
    private long lastClickTime = 0;

    @SubscribeEvent
    public void onMouseEvent(InputEvent.MouseInputEvent event) {
        Mouse.poll();
        if (Mouse.isButtonDown(0)) {
            if (!isAutoClicking) {
                isAutoClicking = true;
            }
        } else {
            isAutoClicking = false;
        }
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (mc.theWorld == null || mc.thePlayer == null) return;
        if (isAutoClicking) {
            long currentTime = System.currentTimeMillis();
            long clickDelay = AutoclickerConfig.getClickDelay();
            if (currentTime - lastClickTime >= clickDelay) {
                lastClickTime = currentTime;
            }
        }
    }
}
