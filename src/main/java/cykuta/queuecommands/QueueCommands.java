package cykuta.queuecommands;

import Utils.Chat;
import cykuta.queuecommands.commands.qc;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class QueueCommands extends JavaPlugin {
    public String cfgPath;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Chat.color("&bQueueCommands &f| &aLoaded"));
        LoadCfg();
        this.getCommand("qc").setExecutor(new qc(this));
        new Queue(this).runTaskTimer(this, 0L, 6000L);//6000
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Chat.color("&bQueueCommands &f| &cDisabled"));
    }

    public void LoadCfg(){
        File config = new File(this.getDataFolder(),"config.yml");
        cfgPath = config.getPath();
        if(!config.exists()){
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
