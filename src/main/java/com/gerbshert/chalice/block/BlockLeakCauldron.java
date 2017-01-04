package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.libraries.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class BlockLeakCauldron extends CCauldronBase {

    public BlockLeakCauldron(Material blockMaterialIn) {
        //super(blockMaterialIn);
        setRegistryName(Strings.MOD_ID, "cauldronLeaking");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronLeaking");
        setCreativeTab(Chalice.chaliceTab);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos blockPos, IBlockState state) {
        worldIn.scheduleBlockUpdate(blockPos, this, this.tickRate(worldIn), 1);
        super.onBlockAdded(worldIn, blockPos, state);
    }

    @Override
    public int tickRate(World worldIn) {
        return 5;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.setWaterLevel(worldIn, pos, state, 3);
        if (worldIn.getBlockState(pos.down()).getMaterial() == Material.AIR) {
            worldIn.setBlockState(pos.down(), Blocks.WATER.getDefaultState());
        }
        worldIn.scheduleBlockUpdate(pos, this, this.tickRate(worldIn), 1);
        super.updateTick(worldIn, pos, state, rand);
    }
}
