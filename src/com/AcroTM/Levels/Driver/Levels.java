package com.AcroTM.Levels.Driver;

import com.AcroTM.Levels.Config.Config;
import com.AcroTM.Levels.Listeners.LevelsListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tyler on 05/09/2014.
 */
public class Levels extends JavaPlugin {
    public static Levels plugin;
    public FileConfiguration kitConfig = new YamlConfiguration();
    private Config config;

    public static Levels getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {

        Logger logger = Bukkit.getLogger();

        logger.log(Level.INFO, "Starting Levels");
        logger.log(Level.INFO, "Version: " + Bukkit.getVersion());
        plugin = this;
        logger.log(Level.INFO, "Saving default config...");
        saveDefaultConfig();
        logger.log(Level.INFO, "Finished saving! Reloading Config...");
        reloadConfig();
        logger.log(Level.INFO, "Finished reloading, saving again...");
        saveConfig();
        logger.log(Level.INFO, "Saving completed. Starting Listeners...");
        config = LevelsAPI.getConfigUtil();
        new LevelsListener();
        logger.log(Level.INFO, "Listeners completed.");
    }

    @Override
    public void onDisable(){
        Logger logger = Bukkit.getLogger();
        logger.log(Level.INFO, "Disabling pluign Levels...");
        logger.log(Level.INFO, "Thank you for using this plugin!");
    }
}
