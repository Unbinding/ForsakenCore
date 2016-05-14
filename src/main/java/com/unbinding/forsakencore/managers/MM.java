package com.unbinding.forsakencore.managers;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by Unbinding
 * Date: May 13, 2016
 * Time: 21:59
 */
public class MM {

    public static String NO_PERMISSION;
    public static String ALERT_PREFIX;
    public static String DISPATCH_SENT;
    public static String ADMIN_CHAT_FORMAT;
    public static String CURRENT_SERVER;
    public static String COMMA_COLOR;
    public static String ONLINE_SERVERS;
    public static String COMMAND_SERVER;
    public static String COMMAND_ADMINCHAT;
    public static String COMMAND_DISPATCH;
    public static String COMMAND_ALERT;


    public MM(){
        this.setupStrings();
    }

    private void setupStrings(){
        ConfigurationManager c = new ConfigurationManager();
        FileConfiguration language = c.getLanguage();
        DISPATCH_SENT = language.getString(colorize("dispatchsent"));
        NO_PERMISSION =  language.getString(colorize("nopermission"));
        ALERT_PREFIX = language.getString(colorize("alertprefix"));
        COMMAND_SERVER = language.getString(colorize("servercommand"));
        COMMAND_ADMINCHAT = language.getString(colorize("adminchatcommand"));
        COMMAND_DISPATCH = language.getString(colorize("dispatchcommand"));
        COMMAND_ALERT = language.getString(colorize("alertcommand"));
        ADMIN_CHAT_FORMAT = language.getString(colorize("adminchatformat"));
        CURRENT_SERVER = language.getString(colorize("currentserverformat"));
        COMMA_COLOR = language.getString(colorize("commacolorformat"));
        ONLINE_SERVERS = language.getString(colorize("serverlistformat"));
    }

    public String colorize(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
