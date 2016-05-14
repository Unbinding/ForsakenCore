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
 * Time: 22:18
 */
public class DispatchCommand extends CoreCommand {

    private Main plugin;

    public DispatchCommand(Main main){
        super(main, "dispatch", "forsakencore.dispatch", true);
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
            message +=  args[i] + " ";
        }

        message = message.trim();
        try{
            request = new MessageRequest(Collections.<String>emptyList(), "dispatch", message);
        }catch(UnsupportedEncodingException ex){
            //
        }
        try{
            plugin.getConnect().request(request);
        }catch(RequestException ex2){
            //
        }
        sender.sendMessage(MM.DISPATCH_SENT);
    }

}
