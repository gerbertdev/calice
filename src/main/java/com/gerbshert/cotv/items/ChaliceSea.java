package com.gerbshert.cotv.items;

import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
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
import net.minecraftforge.fml.common.registry.GameData;

import java.util.Arrays;
import java.util.Random;

import static com.gerbshert.cotv.Chalice.fluidBlacklist;

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
                        Block blockU = worldIn.getBlockState(blockpos.up()).getBlock();
                        Block blockN = worldIn.getBlockState(blockpos.north().up()).getBlock();
                        Block blockE = worldIn.getBlockState(blockpos.east().up()).getBlock();
                        Block blockS = worldIn.getBlockState(blockpos.south().up()).getBlock();
                        Block blockW = worldIn.getBlockState(blockpos.west().up()).getBlock();
                        Block blockNW = worldIn.getBlockState(blockpos.north().west().up()).getBlock();
                        Block blockNE = worldIn.getBlockState(blockpos.north().east().up()).getBlock();
                        Block blockSE = worldIn.getBlockState(blockpos.south().east().up()).getBlock();
                        Block blockSW = worldIn.getBlockState(blockpos.south().west().up()).getBlock();
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
                    } else {
                        Block blockU = worldIn.getBlockState(blockpos.up()).getBlock();
                        if (blockU instanceof BlockAir) {
                            worldIn.setBlockState(blockpos.up(), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
                        }
                    }
                    return new ActionResult(EnumActionResult.PASS, itemstack);
                }
            }
        }

        return new ActionResult(EnumActionResult.PASS, itemstack);
    }
}
