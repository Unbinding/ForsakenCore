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
 * Date: May 14, 2016
 * Time: 00:07
 */
public class Adminchatcommand extends CoreCommand {

    private Main plugin;

    public Adminchatcommand(Main main){
        super(main, "a", "forsakencore.adminchat", true);
        plugin = main;
    }

    public void execute(CommandSender sender, String[] args){
        MessageRequest request = null;
        if(args.length == 0){
            sender.sendMessage(MM.COMMAND_DISPATCH);
            return;
        }

        String message = null;
        for(int i = 0; i < args.length; i++){
            message += args[i] + " ";
        }

        message = message.trim();
        message = MM.ADMIN_CHAT_FORMAT.replace("{SERVERNAME}", plugin.getConnect().getSettings().getUsername()).replace("{PLAYER}", sender.getName()).replace("{MESSAGE}", message);
        try{
            request = new MessageRequest(Collections.<String>emptyList(), "adminchat", message);
        }catch(UnsupportedEncodingException ex){
            //
        }

        try{
            plugin.getConnect().request(request);
        }catch(RequestException ex){
            //
        }

    }

}
