package com.gerbshert.cotv.libraries;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Gabriel on 16-Dec-16.
 */
public class Configs {
    public static String[] defaultBlackList = {"minecraft:Grass", "minecraft:dirt"};
    public static String[] fluidBlacklist;
    public static String endlessSeaLiquid;
    public static String endlessSeaLiquidDefault = "minecraft:water";
    public static int maxLiquidVoid;
    public static Boolean enableVoidChalice;
    public static Boolean enableSeaChalice;
    public static Boolean enableVoidPearl;
    public static Boolean enableSeaPearl;
    public static Boolean enableBoundlessBarrel;
    public static Boolean enableVoidBarrel;
    public static Boolean enableLeakingBarrel;

    public static void setupConfig(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        config.setCategoryComment(config.CATEGORY_GENERAL, "Chalice Config Settings:");
        fluidBlacklist = config.get(config.CATEGORY_GENERAL, "Black-listed Fluids:", defaultBlackList).getStringList();
        endlessSeaLiquid = config.get(config.CATEGORY_GENERAL, "Liquid Endless Seas Places:", endlessSeaLiquidDefault).getString();
        maxLiquidVoid = config.get(config.CATEGORY_GENERAL, "Max Void Chalice Range:", 10).getInt();
        enableVoidChalice = config.get(config.CATEGORY_GENERAL, "Enable Void Chalice", true).getBoolean();
        enableSeaChalice = config.get(config.CATEGORY_GENERAL, "Enable Sea Chalice", true).getBoolean();
        enableVoidPearl = config.get(config.CATEGORY_GENERAL, "Enable Void Pearl", true).getBoolean();
        enableSeaPearl = config.get(config.CATEGORY_GENERAL, "Enable Sea Pearl", true).getBoolean();
        enableBoundlessBarrel = config.get(config.CATEGORY_GENERAL, "Enable Boundless Barrel", true).getBoolean();
        enableVoidBarrel = config.get(config.CATEGORY_GENERAL, "Enable Void Barrel", true).getBoolean();
        enableLeakingBarrel = config.get(config.CATEGORY_GENERAL, "Enable Leaking Barrel", true).getBoolean();
        config.save();
    }
}
