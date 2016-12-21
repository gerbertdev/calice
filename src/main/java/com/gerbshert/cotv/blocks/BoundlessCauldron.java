package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.Chalice;
import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.fluids.capability.templates.EmptyFluidHandler;

import static net.minecraftforge.fluids.FluidUtil.tryFillContainer;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class BoundlessCauldron extends Block{

    public BoundlessCauldron(Material materialIn) {
        super(materialIn);
        setRegistryName(Strings.MOD_ID, "cauldronBoundless");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronBoundless");
        setCreativeTab(Chalice.chaliceTab);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        Item inHand = playerIn.getActiveItemStack().getItem();
        if (inHand instanceof ItemBucket){
        }
        super.onBlockClicked(worldIn, pos, playerIn);
    }
}
