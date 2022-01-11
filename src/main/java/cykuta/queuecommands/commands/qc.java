package cykuta.queuecommands.commands;

import Utils.Chat;
import cykuta.queuecommands.QueueCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class qc implements CommandExecutor {
    public QueueCommands plugin;

    public qc(QueueCommands plugin) {
        this.plugin = plugin;
    };

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /qc add user /comando
        if(!sender.hasPermission("qc.add") || !sender.isOp()) return false;
        FileConfiguration config = plugin.getConfig();
        if (args.length < 3){
            sender.sendMessage(Chat.color("&cUse: /qc add <username> <command...>"));
            return false;
        }
        if (!("add".equals(args[0]))) {
            sender.sendMessage(Chat.color("&cUse: /qc add <username> <command...>"));
            return false;
        }

        List<String> commands;
        String cmd = "";
        for (int i = 2; i < args.length; i++) cmd += args[i] + " ";
        cmd = cmd.trim();

        if (config.contains("Data." + args[1])) {
            commands = config.getStringList("Data." + args[1]);
        } else {
            commands = new ArrayList<>();
        }
        commands.add(cmd);
        config.set("Data." + args[1], commands);
        plugin.saveConfig();
        sender.sendMessage(Chat.color("&aCommand added to queue successfully"));
        return true;
    }
}
