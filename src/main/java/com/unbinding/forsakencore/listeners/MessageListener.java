package com.unbinding.forsakencore.listeners;

import com.unbinding.forsakencore.Main;
import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.event.EventListener;
import lilypad.client.connect.api.event.MessageEvent;
import lilypad.client.connect.api.request.impl.MessageRequest;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

/**
 * Created by Unbinding
 * Date: May 13, 2016
 * Time: 20:48
 */
public class MessageListener {

    Connect connect;
    Main plugin;

    public MessageListener(Connect connect, Main plugin){
        this.connect = connect;
        this.plugin = plugin;
    }

    @EventListener
    public void onMessage(MessageEvent e){
        if(e.getChannel().equalsIgnoreCase("syncserverscall")){
            MessageRequest request = null;
            try{
                request = new MessageRequest(Collections.<String> emptyList(),"syncserversresponse", connect.getSettings().getUsername() + "");
            }catch(UnsupportedEncodingException ex){
                //
            }
        }else if(e.getChannel().equalsIgnoreCase("syncserversresponse")){
            try{
                String server = e.getMessageAsString();
                plugin.serverList.put(server, server);
            }catch(UnsupportedEncodingException ex){
                //
            }
        }
    }

}
