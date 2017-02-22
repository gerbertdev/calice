package com.gerbshert.chalice.item.misc;

import com.gerbshert.chalice.block.ModBlocks;
import com.gerbshert.chalice.item.ModIBase;
import com.gerbshert.chalice.utility.BlockUtil;
import net.minecraft.block.Block;
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
public class SeedBase extends ModIBase {
    private int range = 0;

    public SeedBase(String seedName, int rangeSize) {
        super("seed" + seedName, 64, true);
        this.range = rangeSize;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos posIn, EnumHand handIn, EnumFacing facingIn, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        Block block = worldIn.getBlockState(posIn.offset(facingIn)).getBlock();

        if (playerIn.canPlayerEdit(posIn.offset(facingIn), facingIn, itemstack) && (BlockUtil.isBlockAirOrFluid(block))) {
            worldIn.setBlockState(posIn.offset(facingIn), ModBlocks.waterRushing.getDefaultState().withProperty(STAGE, range));
            --itemstack.stackSize;
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }

    }
}
