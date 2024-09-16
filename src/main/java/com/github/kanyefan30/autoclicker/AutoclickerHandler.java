package com.github.kanyefan30.autoclicker;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class AutoclickerHandler {
    private final Minecraft mc = Minecraft.getMinecraft();
    private long lastFrameTime = 0;

    @SubscribeEvent
    public void onMouseEvent(InputEvent.MouseInputEvent event) {
        Mouse.poll();
        if (Mouse.isButtonDown(0)) {
            System.out.println("mouse clicked down");
            Autoclicker.start();
        } else {
            System.out.println("mouse unclicked");
            Autoclicker.stop();
        }
    }

    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (mc.theWorld == null || mc.thePlayer == null) return;
        long currentTime = System.currentTimeMillis();
        Autoclicker.update(currentTime - lastFrameTime);
        lastFrameTime = currentTime;
    }
}
