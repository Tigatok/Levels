package com.AcroTM.Levels.Config;

import com.AcroTM.Levels.Driver.LevelsAPI;
import com.AcroTM.Levels.com.AcroTM.Levels.Utils;

/**
 * Created by Tyler on 05/09/2014.
 */
public class Config {

    public String insufficientLevelMessage = LevelsAPI.getLevels().getConfig().getString("Game.InsufficientLevelMessage");

    public String getInsufficientLevelMessage(){
        return Utils.colorizeMe(insufficientLevelMessage);
    }
}
