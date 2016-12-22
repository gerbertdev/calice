package com.gerbshert.chalice.blocks;

import com.gerbshert.chalice.libraries.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 17-Dec-16.
 */
public class ChaliceBlocks {
    //Create Block
    public static Block reachingVoid = new ReachingVoid();
    public static Block cauldronBoundless = new BoundlessCauldron(Material.IRON);
    public static Block cauldronVoid = new VoidCauldron(Material.IRON);
    public static Block cauldronLeaking = new LeakingCauldron(Material.IRON);

    //Register Block
    public static void registerBlocks() {
        if (Config.enableVoidChalice) {
            GameRegistry.register(reachingVoid);
        }
        if ((Config.enableSeaCauldron && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.registerWithItem(cauldronBoundless);

        }
        if ((Config.enableVoidCauldron && Config.enableVoidPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.registerWithItem(cauldronVoid);
        }
        if ((Config.enableLeakCauldron && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.registerWithItem(cauldronLeaking);
        }

    }
}
