package com.unbinding.forsakencore.cmds;

import com.unbinding.forsakencore.CoreCommand;
import com.unbinding.forsakencore.Main;
import com.unbinding.forsakencore.managers.MM;
import org.bukkit.command.CommandSender;

/**
 * Created by Unbinding
 * Date: May 13, 2016
 * Time: 22:31
 */
public class ServerCommand extends CoreCommand {

    private Main plugin;
    public ServerCommand(Main main){
        super(main, "server", "forsakencore.server", false);
        plugin = main;
    }

    public void execute(CommandSender sender, String[] args){
        if(args.length == 0){
            String servers = null;
            boolean firstserver = true;
            String currentServer = plugin.getConnect().getSettings().getUsername();
            for(String s : plugin.serverList.values()){
                if(firstserver){
                    firstserver = false;
                    servers = colorize("&c" + s);
                }else{
                    servers += s;
                    servers += MM.COMMA_COLOR;
                }
            }
            sender.sendMessage(MM.CURRENT_SERVER.replace("{SERVER}", currentServer));
            sender.sendMessage(MM.ONLINE_SERVERS.replace("{SERVERLIST}", servers));
        }else{
            if(plugin.serverList.containsValue(args[0].toLowerCase())){
                //Redirect request
            }
        }
    }

}
