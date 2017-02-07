package com.gerbshert.chalice.item;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.library.Strings;
import net.minecraft.item.Item;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class ModIBase extends Item {
    public ModIBase(String objectName, int stackSize, boolean appearsInTab) {
        this.maxStackSize = stackSize;
        this.setUnlocalizedName(Strings.MOD_ID + "." + objectName);
        this.setRegistryName(Strings.MOD_ID, objectName);
        if (appearsInTab) {
            this.setCreativeTab(Chalice.chaliceTab);
        }
    }
}
