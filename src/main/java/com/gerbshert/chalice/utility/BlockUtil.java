package com.gerbshert.chalice.utility;

import net.minecraft.block.*;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;

/**
 * Created by Gabriel on 05-Feb-17.
 */
public class BlockUtil {

    //Returns if block is air
    public static boolean isBlockAir(Block block) {
        return block instanceof BlockAir;
    }

    //Returns if block is a fluid
    public static boolean isBlockFluid(Block block) {
        return (block instanceof BlockFluidBase || block instanceof BlockFluidFinite || block instanceof BlockFluidClassic || block instanceof BlockLiquid || block instanceof BlockStaticLiquid || block instanceof BlockDynamicLiquid || block instanceof BlockLiquid);
    }

    //Returns if block is air or fluid
    public static boolean isBlockAirOrFluid(Block block) {
        return isBlockFluid(block) || isBlockAir(block);
    }

}
