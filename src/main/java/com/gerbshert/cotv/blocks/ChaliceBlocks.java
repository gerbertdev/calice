package com.gerbshert.cotv.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.gerbshert.cotv.libraries.Configs.enableVoidChalice;

/**
 * Created by Gabriel on 17-Dec-16.
 */
public class ChaliceBlocks {
    public static Block reachingVoid = new ReachingVoid();

    public static void registerBlocks() {
        if (enableVoidChalice) {
            GameRegistry.register(reachingVoid);
        }
    }
}
