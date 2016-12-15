package com.gerbshert.cotv.client;

import com.gerbshert.cotv.items.ChaliceItems;
import com.gerbshert.cotv.libraries.Strings;
import net.minecraft.creativetab.CreativeTabs;
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
    public ItemStack getTabIconItem() {

        return new ItemStack(ChaliceItems.chaliceVoid);
    }
}
