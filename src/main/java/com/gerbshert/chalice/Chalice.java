package com.gerbshert.chalice;

import com.gerbshert.chalice.block.ChaliceBlocks;
import com.gerbshert.chalice.client.ChaliceTab;
import com.gerbshert.chalice.item.ChaliceItems;
import com.gerbshert.chalice.libraries.Config;
import com.gerbshert.chalice.libraries.Strings;
import com.gerbshert.chalice.recipe.RecipeBlocks;
import com.gerbshert.chalice.recipe.RecipeItems;
import com.gerbshert.chalice.tile.ChaliceTiles;
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
        //Calls method to create and read config
        Config.setupConfig(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Calls methods to register blocks, items, tiles and recipes
        ChaliceBlocks.registerBlocks();
        ChaliceItems.registerItems();
        ChaliceTiles.registerTiles();
        RecipeBlocks.registerRecipes();
        RecipeItems.registerRecipes();

        /*
           Just a check to see if mod is running on a client or server.
           If it is running on a client this calls a method to register item rendering.
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
