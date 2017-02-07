package com.gerbshert.chalice.item.tools;

import com.gerbshert.chalice.block.ModBlocks;
import com.gerbshert.chalice.item.ModIBase;
import com.gerbshert.chalice.utility.BlockUtil;
import com.gerbshert.chalice.utility.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

import static com.gerbshert.chalice.block.misc.SpreadingWater.STAGE;

/**
 * Created by Gabriel on 03-Feb-17.
 */
public class ChaliceVoid extends ModIBase {
    public ChaliceVoid() {
        super("chaliceVoid", 1, true);
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if ((entity instanceof EntitySlime) && ConfigHandler.allowSlimeVoid) {
            BlockPos pos = entity.getPosition();
            entity.setPosition(pos.getX(), pos.getY() - 400, pos.getZ());
            entity.setDead();
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (this.rayTrace(worldIn, playerIn, true) != null) {
            RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);
            BlockPos posIn = raytraceresult.getBlockPos();
            Block block = worldIn.getBlockState(posIn).getBlock();
            List<String> blacklist = Arrays.asList(ConfigHandler.blacklistedFluids);
            if (playerIn.canPlayerEdit(posIn, playerIn.getHorizontalFacing(), itemstack) && (BlockUtil.isBlockFluid(block) && (!blacklist.contains(block.getRegistryName())))) {
                if (playerIn.isSneaking()) {
                    worldIn.setBlockState(posIn, ModBlocks.voidReaching.getDefaultState().withProperty(STAGE, ConfigHandler.voidChaliceRange));
                } else {
                    worldIn.setBlockToAir(posIn);
                }
                return new ActionResult(EnumActionResult.PASS, itemstack);
            } else {
                return new ActionResult(EnumActionResult.FAIL, itemstack);
            }
        }
        else {
            return new ActionResult(EnumActionResult.FAIL, itemstack);
        }
    }
}
