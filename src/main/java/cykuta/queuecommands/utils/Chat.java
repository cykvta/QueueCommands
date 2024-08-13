package cykuta.queuecommands.utils;

import org.bukkit.Bukkit;

public class Chat {
    public static String color(String message) {
        return message.replaceAll("&", "§");
    }

    public static void ServerConsoleMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(color(message));
    }
}
