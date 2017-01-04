package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;

import java.util.Random;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class BlockVoidCauldron extends CCauldronBase {
    public BlockVoidCauldron(Material materialIn) {
        //super(materialIn);
        setRegistryName(Strings.MOD_ID, "cauldronVoid");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronVoid");
        setCreativeTab(Chalice.chaliceTab);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos blockPos, IBlockState state) {
        worldIn.scheduleBlockUpdate(blockPos, this, this.tickRate(worldIn), 1);
        super.onBlockAdded(worldIn, blockPos, state);
    }

    @Override
    public int tickRate(World worldIn) {
        return 1;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.setWaterLevel(worldIn, pos, state, 0);

        Block block = worldIn.getBlockState(pos.up()).getBlock();
        if (block instanceof BlockFluidBase || block instanceof BlockFluidFinite || block instanceof BlockFluidClassic || block instanceof BlockLiquid || block instanceof BlockStaticLiquid || block instanceof BlockDynamicLiquid || block instanceof BlockLiquid) {
            worldIn.setBlockToAir(pos.up());
        }
        worldIn.scheduleBlockUpdate(pos, this, this.tickRate(worldIn), 1);
        super.updateTick(worldIn, pos, state, rand);
    }

}
