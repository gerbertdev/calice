package com.gerbshert.chalice.block;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class CBlockBase extends Block{
    public CBlockBase(String objectName, Material materialIn, boolean appearsInTab) {
        super(materialIn);
        this.setRegistryName(Strings.MOD_ID, objectName);
        this.setUnlocalizedName(Strings.MOD_ID + ":" + objectName);
        if (appearsInTab) {
            this.setCreativeTab(Chalice.chaliceTab);
        }
    }
}
