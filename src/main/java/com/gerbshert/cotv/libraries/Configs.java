package com.gerbshert.cotv.libraries;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Gabriel on 16-Dec-16.
 */
public class Configs {
    public static String[] defaultBlackList = {"minecraft:Grass", "minecraft:dirt"};
    public static String[] fluidBlacklist;
    public static int maxLiquidVoid;

    public static Boolean disableOnRegentRemoved;

    public static Boolean enableVoidChalice;
    public static Boolean enableSeaChalice;
    public static Boolean enableWAPCChalice;
    public static Boolean enableVoidPearl;
    public static Boolean enableSeaPearl;

    public static Boolean enableBoundlessCauldron;
    public static Boolean enableVoidCauldron;
    public static Boolean enableLeakingCauldron;

    public static void setupConfig(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        config.setCategoryComment(config.CATEGORY_GENERAL, "General Settings");
        fluidBlacklist = config.get(config.CATEGORY_GENERAL, "Black-listed Fluids:", defaultBlackList).getStringList();
        maxLiquidVoid = config.get(config.CATEGORY_GENERAL, "Max Void Chalice Range:", 10).getInt();


        config.setCategoryComment("Content Configuration", "Use this area to choose what content you see in-game. This is mostly for mod-pack devs");
        disableOnRegentRemoved = config.get("Content Configuration", "Disable content if a required ingredient is removed", true).getBoolean();
        enableVoidChalice = config.get("Content Configuration", "Enable Void Chalice", true).getBoolean();
        enableSeaChalice = config.get("Content Configuration", "Enable Sea Chalice", true).getBoolean();
        enableWAPCChalice = config.get("Content Configuration", "Enable WAPC Cup", true).getBoolean();
        enableVoidPearl = config.get("Content Configuration", "Enable Void Pearl", true).getBoolean();
        enableSeaPearl = config.get("Content Configuration", "Enable Sea Pearl", true).getBoolean();
        enableBoundlessCauldron = config.get("Content Configuration", "Enable Boundless Cauldron", true).getBoolean();
        enableVoidCauldron = config.get("Content Configuration", "Enable Void Cauldron", true).getBoolean();
        enableLeakingCauldron = config.get("Content Configuration", "Enable Leaking Cauldron", true).getBoolean();

        config.setCategoryComment("COTV", "If this is set to 'false' ONLY the Void Chalice will appear in-game");
        enableLeakingCauldron = config.get("COTV", "Disable New Content", false).getBoolean();

        config.save();
    }
}
