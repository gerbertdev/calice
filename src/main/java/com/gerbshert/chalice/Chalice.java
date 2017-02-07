package com.gerbshert.chalice;

import com.gerbshert.chalice.block.ModBlocks;
import com.gerbshert.chalice.client.ChaliceTab;
import com.gerbshert.chalice.item.ModItems;
import com.gerbshert.chalice.library.Strings;
import com.gerbshert.chalice.recipe.ModRecipes;
import com.gerbshert.chalice.utility.Achievements;
import com.gerbshert.chalice.utility.ConfigHandler;
import com.gerbshert.chalice.utility.EventHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;


/**
 * Created by Gabriel on 14-Dec-16.
 */
@Mod(modid = Strings.MOD_ID, version = Strings.MOD_VERSION, name = Strings.MOD_NAME, updateJSON = "https://gist.githubusercontent.com/GerbShert/1598adefe76e7df581f333c87412a498/raw/")
public class Chalice {
    public static CreativeTabs chaliceTab = new ChaliceTab();
    private static Boolean isClient;

    //Util Methods
    public static boolean getIsClient() {
        return isClient;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.setupConfig(new Configuration(event.getSuggestedConfigurationFile()));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
         /*
           Just a check to see if mod is running on a client or server.
           Also outputs a message to aware users viewing console output, based on whether running on a client or server.
         */
        if (event.getSide() == Side.CLIENT) {
            System.out.println("You are running Chalice on a client! Thanks so much :3 for the support this mod! ~ Gerb");
            isClient = true;
        } else {
            System.out.println("You are running Chalice on a server! Thanks so much :3 for the support this mod! ~ Gerb");
            isClient = false;
        }

        //Calls methods to register blocks, items, tiles and recipes
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModRecipes.registerRecipes();
        Achievements.registerAchievements();
        registerEventHandler();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    public void registerEventHandler(){
        Object handler = new EventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }
}
