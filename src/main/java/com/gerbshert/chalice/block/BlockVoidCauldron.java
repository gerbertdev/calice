package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class BlockVoidCauldron extends Block {
    public BlockVoidCauldron(Material materialIn) {
        super(materialIn);
        setRegistryName(Strings.MOD_ID, "cauldronVoid");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronVoid");
        setCreativeTab(Chalice.chaliceTab);
    }

    public void onBlockActivated(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        Item inHand = playerIn.getActiveItemStack().getItem();
        if (inHand instanceof ItemBucket) {
            playerIn.setHeldItem(playerIn.getActiveHand(), new ItemStack(Items.BUCKET, 1));
        }
        super.onBlockClicked(worldIn, pos, playerIn);
    }

}
