package com.gerbshert.chalice.recipe;

import com.gerbshert.chalice.item.ChaliceItems;
import com.gerbshert.chalice.libraries.Config;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 21-Dec-16.
 */
public class RecipeItems {
    //Register Item Recipes
    public static void registerRecipes() {
        if ((Config.enableSeaChalice && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.addRecipe(new ItemStack(ChaliceItems.chaliceSea, 1), "ioi", " i ", "iii", Character.valueOf('i'), Items.GOLD_INGOT, Character.valueOf('o'), ChaliceItems.itemSeaPearl);
        }
        if ((Config.enableVoidChalice && Config.enableVoidPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.addRecipe(new ItemStack(ChaliceItems.chaliceVoid, 1), "ioi", " i ", "iii", Character.valueOf('i'), Items.GOLD_INGOT, Character.valueOf('o'), ChaliceItems.itemVoidPearl);
        }
        if (Config.enableVoidPearl) {
            GameRegistry.addRecipe(new ItemStack(ChaliceItems.itemVoidPearl, 1), " x ", "xox", " x ", Character.valueOf('x'), Blocks.OBSIDIAN, Character.valueOf('o'), Items.ENDER_PEARL);
        }
        if (Config.enableSeaPearl) {
            GameRegistry.addRecipe(new ItemStack(ChaliceItems.itemSeaPearl, 1), " x ", "xox", " x ", Character.valueOf('x'), Blocks.LAPIS_BLOCK, Character.valueOf('o'), Items.ENDER_PEARL);
        }
    }
}
