package com.gerbshert.cotv.blocks;

import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Gabriel on 20-Dec-16.
 */
public class VoidCauldron extends Block {
    public VoidCauldron(Material materialIn) {
        super(materialIn);
        setRegistryName(Strings.MOD_ID, "cauldronVoid");
        setUnlocalizedName(Strings.MOD_ID + ":" + "cauldronVoid");
    }
}
