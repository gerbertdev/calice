package com.gerbshert.chalice.item.tools;

import com.gerbshert.chalice.block.ModBlocks;
import com.gerbshert.chalice.item.ModIBase;
import com.gerbshert.chalice.utility.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.gerbshert.chalice.block.misc.SpreadingWater.STAGE;

/**
 * Created by Gabriel on 03-Feb-17.
 */
public class ChaliceWater extends ModIBase {
    static int range = 3;

    public ChaliceWater() {
        super("chaliceWater", 1, true);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos posIn, EnumHand handIn, EnumFacing facingIn, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        Block block = worldIn.getBlockState(posIn.offset(facingIn)).getBlock();

        if (playerIn.canPlayerEdit(posIn.offset(facingIn), facingIn, itemstack) && (BlockUtil.isBlockAirOrFluid(block))) {
            if (playerIn.isSneaking()) {
                worldIn.setBlockState(posIn.offset(facingIn), ModBlocks.waterRushing.getDefaultState().withProperty(STAGE, range));
            } else {
                worldIn.setBlockState(posIn.offset(facingIn), BlockLiquid.getStaticBlock(Material.WATER).getDefaultState());
            }
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }

    }
}

