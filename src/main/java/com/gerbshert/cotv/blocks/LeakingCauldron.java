package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.Chalice;
import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class LeakingCauldron extends Block {

    public LeakingCauldron(Material blockMaterialIn) {
        super(blockMaterialIn);
        setRegistryName(Strings.MOD_ID, "cauldronLeaking");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronLeaking");
        setCreativeTab(Chalice.chaliceTab);
    }
}
