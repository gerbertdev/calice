package com.gerbshert.cotv.items;

import com.gerbshert.cotv.blocks.ChaliceBlocks;
import com.gerbshert.cotv.blocks.ReachingVoid;
import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fml.common.registry.GameData;

import java.util.Arrays;
import java.util.Random;

import static com.gerbshert.cotv.libraries.Configs.fluidBlacklist;

/**
 * Created by Gabriel on 14-Dec-16.
 */
public class ChaliceVoid extends Item {
    public ChaliceVoid() {
        String name = "chaliceVoid";
        setUnlocalizedName(Strings.MOD_ID + "." + name);
        setRegistryName(Strings.MOD_ID, name);
        maxStackSize = 1;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (raytraceresult == null) {
            return new ActionResult(EnumActionResult.PASS, itemstack);
        } else {
            if ((raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)) {
                BlockPos blockpos = raytraceresult.getBlockPos();
                Block block = worldIn.getBlockState(blockpos).getBlock();

                if (block instanceof BlockFluidBase || block instanceof BlockFluidFinite || block instanceof BlockFluidClassic || block instanceof BlockLiquid || block instanceof BlockStaticLiquid || block instanceof BlockDynamicLiquid || block instanceof BlockLiquid)  {
                    if (playerIn.isSneaking()){worldIn.setBlockState(blockpos, ChaliceBlocks.reachingVoid.getDefaultState());

                    }
                    else{
                        worldIn.setBlockToAir(blockpos);
                    }
                }
            }
        }
        return new ActionResult(EnumActionResult.PASS, itemstack);
    }
}
