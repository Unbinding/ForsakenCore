package com.unbinding.forsakencore.cmds;

import com.unbinding.forsakencore.CoreCommand;
import com.unbinding.forsakencore.Main;
import com.unbinding.forsakencore.managers.MM;
import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.MessageRequest;
import org.bukkit.command.CommandSender;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

/**
 * Created by Unbinding
 * Date: May 13, 2016
 * Time: 21:40
 */
public class AlertCommand extends CoreCommand {

    private Main plugin;

    public AlertCommand(Main main){
        super(main, "alert", "forsakencore.alert", true);
        plugin = main;
    }

    public void execute(CommandSender sender, String[] args){
        if(args.length == 0){
            sender.sendMessage(MM.COMMAND_ALERT);
            return;
        }

        String message = null;
        for(int i = 0; i < args.length; i++){
            message += args[i] + " ";
        }

        message = message.trim();

        MessageRequest request = null;
        try{
            request = new MessageRequest(Collections.<String> emptyList(), "alert", colorize(message));
        }catch(UnsupportedEncodingException ex){
            //
        }
        try{
            plugin.getConnect().request(request);
        }catch(RequestException ex2){
            //
        }
        sender.sendMessage(colorize("&cThat message was broadcasted to all servers."));
    }

}
