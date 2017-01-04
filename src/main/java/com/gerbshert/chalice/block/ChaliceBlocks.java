package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.libraries.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class ChaliceBlocks {
    //Creates Block Objects
    public static Block reachingVoid = new BlockReachingVoid();
    public static Block cauldronBoundless = new BlockFullCauldron(Material.IRON);
    public static Block cauldronVoid = new BlockVoidCauldron(Material.IRON);
    public static Block cauldronLeaking = new BlockLeakCauldron(Material.IRON);

    //Registers Block Objects
    public static void registerBlocks() {
        if (Config.enableVoidChalice) {
            GameRegistry.register(reachingVoid);
        }
        if ((Config.enableSeaCauldron && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            registerBlockWithItem(cauldronBoundless);

        }
        if ((Config.enableVoidCauldron && Config.enableVoidPearl) || !Config.disableOnIngredientRemoved) {
            registerBlockWithItem(cauldronVoid);
        }
        if ((Config.enableLeakCauldron && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            registerBlockWithItem(cauldronLeaking);
        }
    }

    //Registers A Block Object With An Item
    public static void registerBlockWithItem(Block block) {
        GameRegistry.register(block);
        Item item = new ItemBlock(block).setRegistryName(block.getRegistryName());
        GameRegistry.register(item);
        if (Chalice.isClient){
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
