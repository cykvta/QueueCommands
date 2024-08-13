package cykuta.queuecommands;

import cykuta.queuecommands.config.File;
import cykuta.queuecommands.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class QueueTimer extends BukkitRunnable {
    @Override
    public void run() {
        FileConfiguration config = QueueCommands.getConfigFile().getFileConfiguration();

        if (config.getBoolean("announce-check")) {
            Chat.ServerConsoleMessage("&bQueueCommands &f| &cChecking commands queue");
        }

        File dataFile = QueueCommands.getDataFile();
        FileConfiguration data = dataFile.getFileConfiguration();

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        for(Player all : Bukkit.getServer().getOnlinePlayers())
        {
            String name = all.getName();
            if(data.contains("Data."+ name)){
                List<String> commands = data.getStringList("Data."+ name);
                Chat.ServerConsoleMessage("&bQueueCommands &f| &aFound a player: " + name);

                for (String command : commands) {
                    Bukkit.dispatchCommand(console, command);
                }

                data.set("Data."+name, null);
                dataFile.save();
            }
        }
    }
}
