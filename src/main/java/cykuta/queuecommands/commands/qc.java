package cykuta.queuecommands.commands;

import cykuta.queuecommands.QueueCommands;
import cykuta.queuecommands.config.File;
import cykuta.queuecommands.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class qc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /qc add user /command
        if(!sender.hasPermission("qc.add") || !sender.isOp()) {
            sender.sendMessage(Chat.color("&cYou do not have permission to use this command"));
            return false;
        }

        File dataFile = QueueCommands.getDataFile();
        FileConfiguration data = dataFile.getFileConfiguration();

        if (args.length < 3 || !(args[0].equals("add")) ){
            sender.sendMessage(Chat.color("&cUse: /qc add <username> [command...]"));
            return false;
        }

        List<String> commands;
        String cmd = "";
        for (int i = 2; i < args.length; i++) cmd += args[i] + " ";
        cmd = cmd.trim();

        if (data.contains("Data." + args[1])) {
            commands = data.getStringList("Data." + args[1]);
        } else {
            commands = new ArrayList<>();
        }
        commands.add(cmd);
        data.set("Data." + args[1], commands);
        dataFile.save();
        sender.sendMessage(Chat.color("&aCommand added to queue successfully"));
        return true;
    }
}
