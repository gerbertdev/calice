package com.gerbshert.chalice.item;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.item.misc.SeedBase;
import com.gerbshert.chalice.item.tools.ChaliceVoid;
import com.gerbshert.chalice.item.tools.ChaliceWater;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 02-Feb-17.
 */
public class ModItems {
    //Creates Item Objects
    public static Item chaliceVoid = new ChaliceVoid();
    public static Item chaliceWater = new ChaliceWater();

    public static Item corporealVoid = new ModIBase("corporealVoid", 16, true);

    public static Item pearlVoid = new ModIBase("pearlVoid", 16, true);
    public static Item pearlWater = new ModIBase("pearlWater", 16, true);

    public static Item seedWater = new SeedBase("Water", 1);
    public static Item seedPond = new SeedBase("Pond", 8);
    public static Item seedLake = new SeedBase("Lake", 15);
    public static Item seedOcean = new SeedBase("Ocean", 25);

    //Registers Item Objects
    public static void registerItems() {
        GameRegistry.register(chaliceVoid);
        GameRegistry.register(chaliceWater);

        GameRegistry.register(corporealVoid);

        GameRegistry.register(pearlVoid);
        GameRegistry.register(pearlWater);

        GameRegistry.register(seedWater);
        GameRegistry.register(seedPond);
        GameRegistry.register(seedLake);
        GameRegistry.register(seedOcean);

        //Checks if mod is running on a client this calls a method to register item rendering.
        if (Chalice.getIsClient()) {
            renderItems();
        }
    }

    //Registers Item Rendering
    public static void renderItems() {
        renderMe(chaliceVoid);
        renderMe(chaliceWater);

        renderMe(corporealVoid);

        renderMe(pearlVoid);
        renderMe(pearlWater);

        renderMe(seedWater);
        renderMe(seedPond);
        renderMe(seedLake);
        renderMe(seedOcean);
    }

    public static void renderMe(Item myItem) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(myItem, 0, new ModelResourceLocation(myItem.getRegistryName(), "inventory"));
    }
}
