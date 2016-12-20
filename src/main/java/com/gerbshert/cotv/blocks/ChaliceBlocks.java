package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.Chalice;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.gerbshert.cotv.libraries.Configs.enableVoidChalice;

/**
 * Created by Gabriel on 17-Dec-16.
 */
public class ChaliceBlocks {
    public static Block reachingVoid = new ReachingVoid().setCreativeTab(Chalice.chaliceTab);

    public static void registerBlocks() {
        if (enableVoidChalice) {
            GameRegistry.register(reachingVoid);
            GameRegistry.register(new ItemBlock(reachingVoid).setRegistryName(reachingVoid.getRegistryName()));
        }
    }
}
