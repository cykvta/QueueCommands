package cykuta.queuecommands;

import cykuta.queuecommands.commands.qc;
import cykuta.queuecommands.config.File;
import cykuta.queuecommands.config.Files;
import cykuta.queuecommands.utils.Chat;
import cykuta.queuecommands.utils.Time;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class QueueCommands extends JavaPlugin {
    private static QueueCommands plugin;
    private static File dataFile;
    private static File configFile;

    @Override
    public void onEnable() {
        plugin = this;
        dataFile = Files.DATA.getFile();
        configFile = Files.CONFIG.getFile();

        Chat.ServerConsoleMessage("&bQueueCommands &f| &aLoaded");
        FileConfiguration config = configFile.getFileConfiguration();
        this.getCommand("qc").setExecutor(new qc());
        new QueueTimer().runTaskTimer(this, 0L, Time.secondsToTicks(config.getLong("check-interval")));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Chat.color("&bQueueCommands &f| &cDisabled"));
    }

    public static QueueCommands getPlugin() {
        return plugin;
    }

    public static File getDataFile() {
        return dataFile;
    }

    public static File getConfigFile() {
        return configFile;
    }
}
