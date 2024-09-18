package com.github.kanyefan30.autoclicker;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.Objects;

public class AutoclickerCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "autoclicker";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Current autoclicker cps is set to §3" + Autoclicker.getCps()));
        } else {
            if (Objects.equals(args[0], "set")) {
                if (Integer.parseInt(args[1]) > 20) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Max cps is 20"));
                } else {
                    Autoclicker.setCps(Integer.parseInt(args[1]));
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Autoclicker cps set to §3" + Autoclicker.getCps()));
                }
            } else {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Usage:"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Change cps: §r/autoclicker set §3<cps>"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Get current message: §r/autoclicker"));
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§6Display this message: §r/autoclicker §3help"));
            }
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
