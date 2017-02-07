package com.gerbshert.chalice.block.cauldrons;

import com.gerbshert.chalice.block.ModBlocks;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class CauldronBoundless extends CauldronBase {
    boolean fallenUpon = false;

    public CauldronBoundless() {
        super("cauldronBoundless", 3);
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
        if (worldIn.getBlockState(pos.up()).getBlock() instanceof BlockAnvil && fallenUpon) {
            worldIn.setBlockState(pos, ModBlocks.cauldronLeaking.getDefaultState());
        }
        worldIn.scheduleBlockUpdate(pos, this, this.tickRate(worldIn), 1);
        super.updateTick(worldIn, pos, state, rand);
    }

    //Checks if fallen on.
    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (entityIn instanceof EntityFallingBlock) {
            this.fallenUpon = true;
            worldIn.scheduleBlockUpdate(pos, this, this.tickRate(worldIn), 1);
        }
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
    }
}
