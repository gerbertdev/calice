package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.Chalice;
import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.fluids.capability.templates.EmptyFluidHandler;

import java.util.Random;

import static net.minecraftforge.fluids.FluidUtil.tryFillContainer;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class BoundlessCauldron extends BlockCauldron{

    public BoundlessCauldron(Material materialIn) {
        //super(materialIn);
        setRegistryName(Strings.MOD_ID, "cauldronBoundless");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronBoundless");
        setCreativeTab(Chalice.chaliceTab);

    }
    @Override
    public void onBlockAdded(World worldIn, BlockPos blockPos, IBlockState state) {
        worldIn.scheduleBlockUpdate(blockPos, this, this.tickRate(worldIn), 1);
        super.onBlockAdded(worldIn, blockPos, state);
    }
    @Override
    public int tickRate(World worldIn) {
        return 40;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.setWaterLevel(worldIn, pos, state, 3);
        worldIn.scheduleBlockUpdate(pos, this, this.tickRate(worldIn), 1);
        super.updateTick(worldIn, pos, state, rand);
    }
}
