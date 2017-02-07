package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.block.cauldrons.CauldronBoundless;
import com.gerbshert.chalice.block.cauldrons.CauldronLeaking;
import com.gerbshert.chalice.block.cauldrons.CauldronVoid;
import com.gerbshert.chalice.block.misc.SolidWater;
import com.gerbshert.chalice.block.misc.SpreadingVoid;
import com.gerbshert.chalice.block.misc.SpreadingWater;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 30-Jan-17.
 */
public class ModBlocks {
    //Creates Block Objects
    public static Block cauldronBoundless = new CauldronBoundless();
    public static Block cauldronLeaking = new CauldronLeaking();
    public static Block cauldronVoid = new CauldronVoid();

    public static Block voidReaching = new SpreadingVoid();

    public static Block waterSolid = new SolidWater();
    public static Block waterRushing = new SpreadingWater();

    //Registers Block Objects
    public static void registerBlocks() {
        registerBlockWithItem(cauldronBoundless);
        registerBlockWithItem(cauldronLeaking);
        registerBlockWithItem(cauldronVoid);

        GameRegistry.register(voidReaching);

        GameRegistry.register(waterSolid);
        GameRegistry.register(waterRushing);
    }

    //Registers A Block Object With An Item
    public static void registerBlockWithItem(Block block) {
        GameRegistry.register(block);
        Item item = new ItemBlock(block).setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
        if (Chalice.getIsClient()) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
