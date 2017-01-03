package com.gerbshert.chalice.block;

import com.gerbshert.chalice.libraries.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

    public static Block tanktest = new TankTest("tanktest");

    //Registers Block Objects
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

        GameRegistry.registerWithItem(tanktest);
    }
}
