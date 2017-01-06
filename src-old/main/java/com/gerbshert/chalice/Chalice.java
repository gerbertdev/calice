package com.gerbshert.chalice;

import com.gerbshert.chalice.blocks.ChaliceBlocks;
import com.gerbshert.chalice.client.ChaliceTab;
import com.gerbshert.chalice.items.ChaliceItems;
import com.gerbshert.chalice.libraries.Config;
import com.gerbshert.chalice.libraries.Strings;
import com.gerbshert.chalice.recipes.ChaliceRecipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;


/**
 * Created by Gabriel on 14-Dec-16.
 */
@Mod(modid = Strings.MOD_ID, version = Strings.MOD_VERSION, name = Strings.MOD_NAME)
public class Chalice {
    public static CreativeTabs chaliceTab = new ChaliceTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Calling methods to create and read config.
        Config.setupConfig(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Calling methods to register blocks, items, and recipes
        ChaliceBlocks.registerBlocks();
        ChaliceItems.registerItems();
        ChaliceRecipes.registerRecipes();

        /* Just a check to see if mod is running on a client or server.
           If it is running on a client this registers item renderers
           Also outputs a message to aware users viewing console output, based on whether running on a client or server.
         */
        if (event.getSide() == Side.CLIENT) {
            System.out.println("You are running Chalice of the Void on a client! Thanks so much :3 for the support this mod! ~ Gerb");
            ChaliceItems.renderItems();
        } else {
            System.out.println("You are running Chalice of the Void on a server! Thanks so much :3 for the support this mod! ~ Gerb");
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
