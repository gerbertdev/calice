package com.gerbshert.chalice.block.cauldrons;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class CauldronLeaking extends CauldronBase {
    public CauldronLeaking() {
        super("cauldronLeaking", 2);
    }

    //Starts block ticking
    @Override
    public void onBlockAdded(World worldIn, BlockPos blockPos, IBlockState state) {
        worldIn.scheduleBlockUpdate(blockPos, this, this.tickRate(worldIn), 1);
        super.onBlockAdded(worldIn, blockPos, state);
    }

    //Sets tick rate
    @Override
    public int tickRate(World worldIn) {
        return 5;
    }

    //Tick updates
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.getBlockState(pos.down()).getMaterial() == Material.AIR) {
            worldIn.setBlockState(pos.down(), Blocks.WATER.getDefaultState());
        }
        worldIn.scheduleBlockUpdate(pos, this, this.tickRate(worldIn), 1);
        super.updateTick(worldIn, pos, state, rand);
    }
}
