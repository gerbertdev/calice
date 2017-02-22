package com.gerbshert.chalice.block.misc;

import com.gerbshert.chalice.block.ModBBase;
import com.gerbshert.chalice.utility.BlockUtil;
import com.gerbshert.chalice.utility.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Gabriel on 17-Dec-16.
 */
public class SpreadingVoid extends ModBBase {
    static int maxVoidReach = 200;
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, maxVoidReach);
    static int voidStage = maxVoidReach;

    public SpreadingVoid() {
        super("voidreaching", Material.ICE, true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, maxVoidReach));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{STAGE});
    }

    @Override
    public int tickRate(World worldIn) {
        return 1;
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos blockPos, IBlockState state) {
        worldIn.scheduleBlockUpdate(blockPos, this, this.tickRate(worldIn), 1);
        super.onBlockAdded(worldIn, blockPos, state);
    }

    @Override
    public void updateTick(World worldIn, BlockPos blockPos, IBlockState state, Random rand) {
        worldIn.scheduleBlockUpdate(blockPos, this, this.tickRate(worldIn), 1);
        int voidStage = state.getValue(STAGE);
        if (voidStage == 0) {
            worldIn.setBlockToAir(blockPos);
        } else {
            grow(worldIn, voidStage, blockPos, state);
            voidStage--;
            worldIn.setBlockToAir(blockPos);
        }
    }

    public int getMetaFromState(IBlockState state) {
        int i = 1;
        return i;
    }

    public void grow(World world, int life, BlockPos pos, IBlockState state) {
        List<String> blacklist = Arrays.asList(ConfigHandler.blacklistedFluids);
        Block NORTH = world.getBlockState(pos.north()).getBlock();
        Block SOUTH = world.getBlockState(pos.south()).getBlock();
        Block EAST = world.getBlockState(pos.east()).getBlock();
        Block WEST = world.getBlockState(pos.west()).getBlock();
        Block UP = world.getBlockState(pos.up()).getBlock();
        Block DOWN = world.getBlockState(pos.down()).getBlock();
        if (BlockUtil.isBlockFluid(NORTH)) {
            world.setBlockState(pos.north(), this.getDefaultState().withProperty(STAGE, life - 1));
        }
        if (BlockUtil.isBlockFluid(SOUTH)) {
            world.setBlockState(pos.south(), this.getDefaultState().withProperty(STAGE, life - 1));
        }
        if (BlockUtil.isBlockFluid(EAST)) {
            world.setBlockState(pos.east(), this.getDefaultState().withProperty(STAGE, life - 1));
        }
        if (BlockUtil.isBlockFluid(WEST)) {
            world.setBlockState(pos.west(), this.getDefaultState().withProperty(STAGE, life - 1));
        }
        if (BlockUtil.isBlockFluid(UP)) {
            world.setBlockState(pos.up(), this.getDefaultState().withProperty(STAGE, life - 1));
        }
        if (BlockUtil.isBlockFluid(DOWN)) {
            world.setBlockState(pos.down(), this.getDefaultState().withProperty(STAGE, life - 1));
        }
    }
}
