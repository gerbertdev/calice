package com.gerbshert.chalice.client;

import com.gerbshert.chalice.item.ModItems;
import com.gerbshert.chalice.library.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Gabriel on 14-Dec-16.
 */
public class ChaliceTab extends CreativeTabs {
    public ChaliceTab() {
        super(Strings.MOD_ID);
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.chaliceVoid;
    }
}
