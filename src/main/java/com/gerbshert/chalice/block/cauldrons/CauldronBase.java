package com.gerbshert.chalice.block.cauldrons;

import com.gerbshert.chalice.block.ModBBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class CauldronBase extends ModBBase {
    protected static final AxisAlignedBB AABB_LEGS = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.125D);
    protected static final AxisAlignedBB AABB_WALL_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.875D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_EAST = new AxisAlignedBB(0.875D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_WALL_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.125D, 1.0D, 1.0D);
    int level = 1;

    public CauldronBase(String objectName, int level) {
        super(objectName, Material.IRON, true);
        this.level = level;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_LEGS);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_WEST);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_NORTH);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_EAST);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WALL_SOUTH);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return FULL_BLOCK_AABB;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        int i = level;
        float f = (float) pos.getY() + (6.0F + (float) (3 * i)) / 16.0F;

        if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getEntityBoundingBox().minY <= (double) f) {
            entityIn.extinguish();
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if ((heldItem == null)) {
            return true;
        } else {
            int i = level;
            Item item = itemstack.getItem();
            if (item == Items.WATER_BUCKET) {
                if (i < 3 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
                    }
                    worldIn.playSound((EntityPlayer) null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
                return true;
            } else if (item == Items.LAVA_BUCKET) {
                if (i < 3 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
                    }
                    worldIn.playSound((EntityPlayer) null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
                return true;
            } else if (item == Items.BUCKET) {
                if (i > 0 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        --heldItem.stackSize;

                        if (heldItem.stackSize == 0) {
                            playerIn.setHeldItem(hand, new ItemStack(Items.WATER_BUCKET));
                        } else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
                            playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false);
                        }
                    }

                    playerIn.addStat(StatList.CAULDRON_USED);
                    worldIn.playSound((EntityPlayer) null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return true;
            } else if (item == Items.GLASS_BOTTLE) {
                if (i > 0 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        ItemStack itemstack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
                        playerIn.addStat(StatList.CAULDRON_USED);
                        --heldItem.stackSize;

                        if (heldItem.stackSize == 0) {
                            playerIn.setHeldItem(hand, itemstack3);
                        } else if (!playerIn.inventory.addItemStackToInventory(itemstack3)) {
                            playerIn.dropItem(itemstack3, false);
                        } else if (playerIn instanceof EntityPlayerMP) {
                            ((EntityPlayerMP) playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
                        }
                    }

                    worldIn.playSound((EntityPlayer) null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return true;
            } else if (item == Items.POTIONITEM && PotionUtils.getPotionFromItem(itemstack) == PotionTypes.WATER) {
                if (i < 3 && !worldIn.isRemote) {
                    if (!playerIn.capabilities.isCreativeMode) {
                        ItemStack itemstack2 = new ItemStack(Items.GLASS_BOTTLE);
                        playerIn.addStat(StatList.CAULDRON_USED);
                        playerIn.setHeldItem(hand, itemstack2);

                        if (playerIn instanceof EntityPlayerMP) {
                            ((EntityPlayerMP) playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
                        }
                    }

                }

                return true;
            } else {
                if (i > 0 && item instanceof ItemArmor) {
                    ItemArmor itemarmor = (ItemArmor) item;

                    if (itemarmor.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && itemarmor.hasColor(itemstack) && !worldIn.isRemote) {
                        itemarmor.removeColor(itemstack);
                        playerIn.addStat(StatList.ARMOR_CLEANED);
                        return true;
                    }
                }
                return true;
            }
        }
    }
}