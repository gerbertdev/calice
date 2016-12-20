package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;

import java.util.Random;


import static com.gerbshert.cotv.libraries.Configs.maxLiquidVoid;

/**
 * Created by Gabriel on 17-Dec-16.
 */
public class ReachingVoid extends Block {
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, maxLiquidVoid);
    static int voidStage = maxLiquidVoid;

    public ReachingVoid() {
        super(Material.ICE);
        String name = "reachingVoid";
        setRegistryName(Strings.MOD_ID + "." + name);
        setUnlocalizedName(Strings.MOD_ID + ":" + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, maxLiquidVoid));
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
        System.out.println("Start Update Tick @ " + blockPos + ". Current Stage:" + voidStage);
        if (voidStage == 0) {
            worldIn.setBlockToAir(blockPos);
            System.out.println("End Update Tick @ " + blockPos + ". Removal.");
        } else {
            grow(worldIn, voidStage, blockPos, state);
            voidStage--;
            worldIn.setBlockToAir(blockPos);
            System.out.println("End Update Tick @ " + blockPos + ". Current Stage:" + voidStage);
        }
    }

    public int getMetaFromState(IBlockState state) {
        int i = ((Integer) state.getValue(STAGE)).intValue();
        return i;
    }

    public void grow(World world, int life, BlockPos pos, IBlockState state){
        System.out.println("GROW @ " + pos + ". Current Stage:" + voidStage);
        Block NORTH = world.getBlockState(pos.north()).getBlock();
        Block SOUTH = world.getBlockState(pos.south()).getBlock();
        Block EAST = world.getBlockState(pos.east()).getBlock();
        Block WEST = world.getBlockState(pos.west()).getBlock();
        Block UP = world.getBlockState(pos.up()).getBlock();
        Block DOWN = world.getBlockState(pos.down()).getBlock();
        if ((NORTH instanceof BlockFluidBase) || (NORTH instanceof BlockFluidFinite) || (NORTH instanceof BlockFluidClassic) || (NORTH instanceof BlockLiquid) || (NORTH instanceof BlockStaticLiquid)){
            world.setBlockState(pos.north(), this.getDefaultState().withProperty(STAGE, life-1));
        }
        if ((SOUTH instanceof BlockFluidBase) || (SOUTH instanceof BlockFluidFinite) || (SOUTH instanceof BlockFluidClassic) || (SOUTH instanceof BlockLiquid) || (SOUTH instanceof BlockStaticLiquid)){
            world.setBlockState(pos.south(), this.getDefaultState().withProperty(STAGE, life-1));
        }
        if ((EAST instanceof BlockFluidBase) || (EAST instanceof BlockFluidFinite) || (EAST instanceof BlockFluidClassic) || (EAST instanceof BlockLiquid) || (EAST instanceof BlockStaticLiquid)){
            world.setBlockState(pos.east(), this.getDefaultState().withProperty(STAGE, life-1));
        }
        if ((WEST instanceof BlockFluidBase) || (WEST instanceof BlockFluidFinite) || (WEST instanceof BlockFluidClassic) || (WEST instanceof BlockLiquid) || (WEST instanceof BlockStaticLiquid)){
            world.setBlockState(pos.west(), this.getDefaultState().withProperty(STAGE, life-1));
        }
        if ((UP instanceof BlockFluidBase) || (UP instanceof BlockFluidFinite) || (UP instanceof BlockFluidClassic) || (UP instanceof BlockLiquid) || (UP instanceof BlockStaticLiquid)){
            world.setBlockState(pos.up(), this.getDefaultState().withProperty(STAGE, life-1));
        }
        if ((DOWN instanceof BlockFluidBase) || (DOWN instanceof BlockFluidFinite) || (DOWN instanceof BlockFluidClassic) || (DOWN instanceof BlockLiquid) || (DOWN instanceof BlockStaticLiquid)){
            world.setBlockState(pos.down(), this.getDefaultState().withProperty(STAGE, life-1));
        }
    }
}