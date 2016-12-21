package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.gerbshert.cotv.libraries.Configs.*;

/**
 * Created by Gabriel on 17-Dec-16.
 */
public class ChaliceBlocks {
    public static Block reachingVoid = new ReachingVoid();
    public static Block cauldronBoundless = new BoundlessCauldron(Material.IRON);
    public static Block cauldronVoid = new VoidCauldron(Material.IRON);
    public static Block cauldronLeaking = new LeakingCauldron(Material.IRON);

    public static void registerBlocks() {
        if (enableVoidChalice) {
            GameRegistry.register(reachingVoid);
        }
        if ((enableBoundlessCauldron && enableSeaPearl) || !disableOnRegentRemoved) {
            GameRegistry.registerWithItem(cauldronBoundless);

        }
        if ((enableVoidCauldron && enableVoidPearl) || !disableOnRegentRemoved) {
            GameRegistry.registerWithItem(cauldronVoid);
        }
        if ((enableLeakingCauldron && enableSeaPearl) || !disableOnRegentRemoved) {
            GameRegistry.registerWithItem(cauldronLeaking);
        }

    }
}
