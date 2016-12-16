package com.gerbshert.cotv.items;

import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fml.common.registry.GameData;

import java.util.Random;

/**
 * Created by Gabriel on 14-Dec-16.
 */
public class ChaliceSea extends Item {
    public ChaliceSea() {
        String name = "chaliceSea";
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

                if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                    return new ActionResult(EnumActionResult.PASS, itemstack);
                } else if (worldIn.provider.doesWaterVaporize()) {
                    int l = blockpos.getX();
                    int i = blockpos.getY();
                    int j = blockpos.getZ();
                    worldIn.playSound(playerIn, blockpos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);
                    for (int k = 0; k < 8; ++k) {
                        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) l + Math.random(), (double) i + Math.random(), (double) j + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
                    }
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
                        Block blockU = worldIn.getBlockState(blockpos.up()).getBlock();
                        Block blockN = worldIn.getBlockState(blockpos.north().up()).getBlock();
                        Block blockE = worldIn.getBlockState(blockpos.east().up()).getBlock();
                        Block blockS = worldIn.getBlockState(blockpos.south().up()).getBlock();
                        Block blockW = worldIn.getBlockState(blockpos.west().up()).getBlock();
                        Block blockNW = worldIn.getBlockState(blockpos.north().west().up()).getBlock();
                        Block blockNE = worldIn.getBlockState(blockpos.north().east().up()).getBlock();
                        Block blockSE = worldIn.getBlockState(blockpos.south().east().up()).getBlock();
                        Block blockSW = worldIn.getBlockState(blockpos.south().west().up()).getBlock();
                        if (block instanceof BlockFluidBase || block instanceof BlockFluidFinite || block instanceof BlockFluidClassic || block instanceof BlockLiquid || block instanceof BlockStaticLiquid) {
                            if (block instanceof BlockAir) {
                                worldIn.setBlockState(blockpos, BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockN instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.north(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockE instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.east(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockS instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.south(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockW instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.west(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockNW instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.north().west(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockNE instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.north().east(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockSE instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.south().east(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockSW instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.south().west(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                        } else {
                            if (blockU instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockN instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.north().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockE instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.east().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockS instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.south().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockW instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.west().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockNW instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.north().west().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockNE instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.north().east().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockSE instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.south().east().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                            if (blockSW instanceof BlockAir) {
                                worldIn.setBlockState(blockpos.south().west().up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                        }
                    } else {
                        Block blockU = worldIn.getBlockState(blockpos.up()).getBlock();
                        if (blockU instanceof BlockAir) {
                            if (block instanceof BlockFluidBase || block instanceof BlockFluidFinite || block instanceof BlockFluidClassic || block instanceof BlockLiquid || block instanceof BlockStaticLiquid) {
                                worldIn.setBlockState(blockpos, BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            } else {
                                worldIn.setBlockState(blockpos.up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                            }
                        }
                    }
                    return new ActionResult(EnumActionResult.PASS, itemstack);
                }
            }
        }

        return new ActionResult(EnumActionResult.PASS, itemstack);
    }
}
