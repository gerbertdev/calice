package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.tile.TankTestTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class TankTest extends BlockContainer {

    protected TankTest(String objectName) {
        super(Material.WOOD);
        setUnlocalizedName(objectName);
        setRegistryName(objectName);
        setCreativeTab(Chalice.chaliceTab);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TankTestTile();
    }
}
