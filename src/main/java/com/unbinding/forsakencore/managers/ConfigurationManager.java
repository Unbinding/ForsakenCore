package com.unbinding.forsakencore.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Unbinding
 * Date: May 13, 2016
 * Time: 21:31
 */
public class ConfigurationManager {



    Plugin p;
    FileConfiguration language;
    File lfile;


    public void setup(Plugin p){
        this.p = p;
        lfile = new File(p.getDataFolder(), "language.yml");
        language = YamlConfiguration.loadConfiguration(lfile);
        language.options().copyDefaults(true);
        save();
    }

    public FileConfiguration getLanguage(){
        return language;
    }

    public void save(){
        try{
            language.save(lfile);
        }catch(IOException e){
            p.getLogger().log(Level.SEVERE, "Could not save the language file.");
        }
    }

    public void reload(){
        save();
        YamlConfiguration.loadConfiguration(lfile);
    }

}
