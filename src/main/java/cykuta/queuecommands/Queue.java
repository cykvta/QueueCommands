package cykuta.queuecommands;

import Utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class Queue extends BukkitRunnable {
    public QueueCommands plugin;

    public Queue(QueueCommands plugin) {
        this.plugin = plugin;
    };
    @Override
    public void run() {
        Bukkit.getConsoleSender().sendMessage(
                Chat.color("&bQueueCommands &f| &cChecking commands queue"));
        FileConfiguration config = plugin.getConfig();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        for(Player all : Bukkit.getServer().getOnlinePlayers())
        {
            String name = all.getName();
            if(config.contains("Data."+ name)){
                List<String> commands = config.getStringList("Data."+ name);
                Bukkit.getConsoleSender().sendMessage(
                        Chat.color("&bQueueCommands &f| &aFound a player: " + name));
                for(int i = 0; i < commands.size(); i++){
                    Bukkit.dispatchCommand(console, commands.get(i));
                }
                config.set("Data."+name, null);
                plugin.saveConfig();
            }
        }
    }
}
