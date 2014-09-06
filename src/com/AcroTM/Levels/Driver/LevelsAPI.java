package com.AcroTM.Levels.Driver;

import com.AcroTM.Levels.Config.Config;

/**
 * Created by Tyler on 05/09/2014.
 */
public class LevelsAPI {
    public static Levels plugin = Levels.getInstance();
    public static Config config;
    public static Levels getLevels() {
        return plugin;
    }

    public static Config getConfigUtil() {
        if (config == null) config = new Config();
        return config;
    }
}
