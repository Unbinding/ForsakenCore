package com.unbinding.forsakencore;

import com.unbinding.forsakencore.listeners.MessageListener;
import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.MessageRequest;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;

/**
 * Created by Unbinding
 * Date: May 13, 2016
 * Time: 20:45
 */
public class Main extends JavaPlugin {

    //Instance Variables
    public HashMap<String, String> serverList = new HashMap<String, String>();
    public int totalSendCount = 0;
    Connect connect;

    public void onLoad(){
        Plugin lilyPadAPI = this.getServer().getPluginManager().getPlugin("LilyPad-Connect");
        if(lilyPadAPI == null){
            getLogger().log(Level.SEVERE, "Could not find LilyPad-Connect, disabling.");
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    public void onEnable(){
        connect = getServer().getServicesManager().getRegistration(Connect.class).getProvider();
        connect.registerEvents(new MessageListener(connect, this));
        registerCommands();
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
                public void run(){
                    syncServers();
                    //Debug
                    getLogger().info(serverList.keySet() + "");
                }
        },20L, 20L);
    }

    public void syncServers(){
        serverList.clear();
        MessageRequest request = null;
        try{
            request = new MessageRequest(Collections.<String> emptyList(), "syncserverscall", "");
            connect.request(request);
        }catch(UnsupportedEncodingException ex){
            //
        } catch (RequestException e) {
            e.printStackTrace();
        }
    }

    public void registerCommands(){

    }



}
