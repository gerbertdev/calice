package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.library.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class ModBBase extends Block {
    public ModBBase(String objectName, Material materialIn, boolean appearsInTab) {
        super(materialIn);
        this.setRegistryName(Strings.MOD_ID, objectName.toLowerCase());
        this.setUnlocalizedName(Strings.MOD_ID + "." + objectName.toLowerCase());
        if (appearsInTab) {
            this.setCreativeTab(Chalice.chaliceTab);
        }
    }
}