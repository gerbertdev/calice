package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.Chalice;
import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class LeakingCauldron extends BoundlessCauldron {

    public LeakingCauldron(Material blockMaterialIn) {
        super(blockMaterialIn);
        setRegistryName(Strings.MOD_ID, "cauldronLeaking");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronLeaking");
        setCreativeTab(Chalice.chaliceTab);
    }
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.setWaterLevel(worldIn, pos, state, 3);
        if (worldIn.getBlockState(pos.down()).getMaterial() == Material.AIR){
            worldIn.setBlockToAir(pos.down());
        }
        worldIn.scheduleBlockUpdate(pos, this, this.tickRate(worldIn), 1);
        super.updateTick(worldIn, pos, state, rand);
    }
}
