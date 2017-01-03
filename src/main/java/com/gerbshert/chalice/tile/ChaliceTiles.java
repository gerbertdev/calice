package com.gerbshert.chalice.tile;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class ChaliceTiles {
    public static void registerTiles() {
        GameRegistry.registerTileEntity(TankTestTile.class, "test_tank");
    }
}
