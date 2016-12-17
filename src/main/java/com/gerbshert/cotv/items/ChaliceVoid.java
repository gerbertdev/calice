package com.gerbshert.cotv.items;

import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
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
                int block_id = GameData.getBlockRegistry().getId(block);
                if (block instanceof BlockFluidBase || block instanceof BlockFluidFinite || block instanceof BlockFluidClassic || block instanceof BlockLiquid || block instanceof BlockStaticLiquid) {
                    if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                        return new ActionResult(EnumActionResult.PASS, itemstack);
                    } else if (Arrays.asList(fluidBlacklist).contains(block.toString())) {
                        return new ActionResult(EnumActionResult.PASS, itemstack);
                    } else {
                        int count = 0;
                        while (count != 5) {
                            Random rand = new Random();
                            int randomNum = rand.nextInt(5) % 5;
                            int randomNum2 = rand.nextInt(5) % 5;
                            worldIn.spawnParticle(EnumParticleTypes.BLOCK_DUST, blockpos.getX() + randomNum * .2, blockpos.getY(), blockpos.getZ() + randomNum2 * .2, 0, 0, 0, block_id);
                            count++;
                        }
                        if (playerIn.isSneaking()) {
                            worldIn.setBlockToAir(blockpos);
                            Block blockN = worldIn.getBlockState(blockpos.north()).getBlock();
                            Block blockE = worldIn.getBlockState(blockpos.east()).getBlock();
                            Block blockS = worldIn.getBlockState(blockpos.south()).getBlock();
                            Block blockW = worldIn.getBlockState(blockpos.west()).getBlock();
                            Block blockNW = worldIn.getBlockState(blockpos.north().west()).getBlock();
                            Block blockNE = worldIn.getBlockState(blockpos.north().east()).getBlock();
                            Block blockSE = worldIn.getBlockState(blockpos.south().east()).getBlock();
                            Block blockSW = worldIn.getBlockState(blockpos.south().west()).getBlock();
                            if (blockN instanceof BlockFluidBase || blockN instanceof BlockFluidFinite || blockN instanceof BlockFluidClassic || blockN instanceof BlockLiquid || blockN instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.north());
                            }
                            if (blockE instanceof BlockFluidBase || blockE instanceof BlockFluidFinite || blockE instanceof BlockFluidClassic || blockE instanceof BlockLiquid || blockE instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.east());
                            }
                            if (blockS instanceof BlockFluidBase || blockS instanceof BlockFluidFinite || blockS instanceof BlockFluidClassic || blockS instanceof BlockLiquid || blockS instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.south());
                            }
                            if (blockW instanceof BlockFluidBase || blockW instanceof BlockFluidFinite || blockW instanceof BlockFluidClassic || blockW instanceof BlockLiquid || blockW instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.west());
                            }
                            if (blockNW instanceof BlockFluidBase || blockNW instanceof BlockFluidFinite || blockNW instanceof BlockFluidClassic || blockNW instanceof BlockLiquid || blockNW instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.north().west());
                            }
                            if (blockNE instanceof BlockFluidBase || blockNE instanceof BlockFluidFinite || blockNE instanceof BlockFluidClassic || blockNE instanceof BlockLiquid || blockNE instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.north().east());
                            }
                            if (blockSE instanceof BlockFluidBase || blockSE instanceof BlockFluidFinite || blockSE instanceof BlockFluidClassic || blockSE instanceof BlockLiquid || blockSE instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.south().east());
                            }
                            if (blockSW instanceof BlockFluidBase || blockSW instanceof BlockFluidFinite || blockSW instanceof BlockFluidClassic || blockSW instanceof BlockLiquid || blockSW instanceof BlockStaticLiquid) {
                                worldIn.setBlockToAir(blockpos.south().west());
                            }
                        } else {
                            worldIn.setBlockToAir(blockpos);
                        }
                        return new ActionResult(EnumActionResult.PASS, itemstack);
                    }
                }
            }
        }
        return new ActionResult(EnumActionResult.PASS, itemstack);
    }
}
