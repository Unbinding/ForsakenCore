package com.unbinding.forsakencore;

import com.unbinding.forsakencore.managers.ConfigurationManager;
import com.unbinding.forsakencore.managers.MM;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Unbinding
 * Date: May 13, 2016
 * Time: 21:27
 */
public abstract class CoreCommand implements CommandExecutor {

    String commandName;
    String permission;
    boolean canConsoleUse;
    Main plugin;
    public ConfigurationManager c = new ConfigurationManager();

    public CoreCommand(Main main, String commandName, String permission, boolean canConsoleUse){
        this.commandName = commandName;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;
        plugin = main;
        plugin.getCommand(commandName).setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(!commandLabel.equalsIgnoreCase(commandName)){
            return true;
        }

        if(!sender.hasPermission(permission)){
            sender.sendMessage(MM.NO_PERMISSION);
            return true;
        }

        if(!canConsoleUse && !(sender instanceof Player)){
            sender.sendMessage(colorize("Only players can execute this command."));
            return true;
        }

        execute(sender, args);
        return true;
    }

    public abstract void execute(CommandSender sender, String[] args);

    public String colorize(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
