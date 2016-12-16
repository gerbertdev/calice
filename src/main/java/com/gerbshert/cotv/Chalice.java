package com.gerbshert.cotv;

import com.gerbshert.cotv.client.ChaliceTab;
import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import static com.gerbshert.cotv.items.ChaliceItems.*;

/**
 * Created by Gabriel on 14-Dec-16.
 */
@Mod(modid = Strings.MOD_ID, version = Strings.MOD_VERSION, name = Strings.MOD_NAME)
public class Chalice {
    public static String[] defaultBlackList = {"example", "fluids"};
    public static String[] fluidBlacklist;
    public static CreativeTabs chaliceTab = new ChaliceTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Config
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        fluidBlacklist = config.get(config.CATEGORY_GENERAL, "Black-listed Fluids", defaultBlackList).getStringList();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        registerItems();
        registerItemsRecipes();
        if (event.getSide() == Side.CLIENT) {
            System.out.println("You are running Chalice of the Void on a client! Thanks so much :3 for the support this mod! ~ Gerb");
            renderItems();
        } else {
            System.out.println("You are running Chalice of the Void on a server! Thanks so much :3 for the support this mod! ~ Gerb");
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
