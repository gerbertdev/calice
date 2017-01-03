package com.gerbshert.chalice.client;

import com.gerbshert.chalice.item.ChaliceItems;
import com.gerbshert.chalice.libraries.Config;
import com.gerbshert.chalice.libraries.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
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
        if (Config.enableVoidChalice) {
            return new ItemStack(ChaliceItems.chaliceVoid);
        } else {
            return new ItemStack(Items.BUCKET);
        }
    }
}
