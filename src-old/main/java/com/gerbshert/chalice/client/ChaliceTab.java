package com.gerbshert.chalice.client;

import com.gerbshert.chalice.items.ChaliceItems;
import com.gerbshert.chalice.libraries.Config;
import com.gerbshert.chalice.libraries.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
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
        if (Config.enableVoidChalice) {
            return ChaliceItems.chaliceVoid;
        } else {
            return Items.BUCKET;
        }
    }
}
