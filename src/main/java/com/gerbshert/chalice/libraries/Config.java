package com.gerbshert.chalice.libraries;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Gabriel on 21-Dec-16.
 */
public class Config {
    //Config variables for fluid blacklisting
    public static String[] defaultBlackList = {"minecraft:Grass", "minecraft:dirt"};
    public static String[] fluidBlacklist;

    //Config variables for items
    public static Boolean enableVoidChalice;
    public static Boolean enableVoidChalice_WAPC;
    public static Boolean enableSeaChalice;
    public static Boolean enableVoidPearl;
    public static Boolean enableSeaPearl;

    //Config variables for items
    public static Boolean enableSeaCauldron;
    public static Boolean enableVoidCauldron;
    public static Boolean enableLeakCauldron;

    //Other config variables
    public static int maxVoidReach;
    public static Boolean disableOnIngredientRemoved;
    public static Boolean cotvMode;
    public static Boolean enableSlimeVoiding;


    public static void setupConfig(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        config.setCategoryComment(config.CATEGORY_GENERAL, "General Settings");
        fluidBlacklist = config.get(config.CATEGORY_GENERAL, "Black-Listed Fluids:", defaultBlackList).getStringList();
        maxVoidReach = config.get(config.CATEGORY_GENERAL, "Max Void Chalice Range:", 10).getInt();
        enableSlimeVoiding = config.get(config.CATEGORY_GENERAL, "Allow Slime Voiding", true).getBoolean();

        config.setCategoryComment("Content Config", "Use this area to choose what content you see in-game. This is mostly for mod-pack devs");
        disableOnIngredientRemoved = config.get("Content Config", "Disable content if a required ingredient is removed", true).getBoolean();
        enableVoidChalice = config.get("Content Config", "Enable Void Chalice", true).getBoolean();
        enableSeaChalice = config.get("Content Config", "Enable Sea Chalice", true).getBoolean();
        enableVoidChalice_WAPC = config.get("Content Config", "Enable WAPC Cup", true).getBoolean();
        enableVoidPearl = config.get("Content Config", "Enable Void Pearl", true).getBoolean();
        enableSeaPearl = config.get("Content Config", "Enable Sea Pearl", true).getBoolean();
        enableSeaCauldron = config.get("Content Config", "Enable Boundless Cauldron", true).getBoolean();
        enableVoidCauldron = config.get("Content Config", "Enable Void Cauldron", true).getBoolean();
        enableLeakCauldron = config.get("Content Config", "Enable Leaking Cauldron", true).getBoolean();

        config.setCategoryComment("COTV", "If this is set to 'false' ONLY the Void Chalice will appear in-game");
        cotvMode = config.get("COTV", "Disable New Content", false).getBoolean();

        config.save();
    }
}
