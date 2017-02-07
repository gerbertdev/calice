package com.gerbshert.chalice.utility;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.util.List;


/**
 * Created by Gabriel on 05-Feb-17.
 */
public class ConfigHandler {
    public static Configuration config;

    //Configuration Options Variables
    public static boolean cotvMode = false;
    public static Property prop_cotvMode;

    public static boolean allowSlimeVoid = true;
    public static Property prop_allowSlimeVoid;

    public static int voidChaliceRange = 15;
    public static Property prop_voidChaliceRange;

    public static String[] blacklistedFluids = {"minecraft:grass", "minecraft:dirt"};
    public static Property prop_blacklistedFluids;


    public static void setupConfig(Configuration config_) {
        config = config_;
        config.load();
        loadConfiguration();
    }


    private static void loadConfiguration() {
        String general = "General Options";
        String item = "Item Control";
        String block = "Block Control";

        //Configuration Options

        prop_allowSlimeVoid = config.get(general, "allowSlimeVoiding", allowSlimeVoid);
        prop_allowSlimeVoid.setComment("True: allows \"Chalice of Void's Reach\" to void slimes."); ;
        allowSlimeVoid = prop_allowSlimeVoid.getBoolean();

        prop_voidChaliceRange = config.get(general, "voidChaliceRange", voidChaliceRange);
        prop_voidChaliceRange.setComment("Range that \"Chalice of Void's Reach\" will void liquids."); ;
        voidChaliceRange = prop_voidChaliceRange.getInt();

        prop_blacklistedFluids = config.get(general, "blacklistedFluids", blacklistedFluids);
        prop_blacklistedFluids.setComment("Fluids that \"Chalice of Void's Reach\" will not effect."); ;
        blacklistedFluids = prop_blacklistedFluids.getStringList();


        //Saves config if changes were made
        if(config.hasChanged())
            config.save();
    }
}
