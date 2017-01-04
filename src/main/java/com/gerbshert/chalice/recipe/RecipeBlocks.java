package com.gerbshert.chalice.recipe;

import com.gerbshert.chalice.block.ChaliceBlocks;
import com.gerbshert.chalice.item.ChaliceItems;
import com.gerbshert.chalice.libraries.Config;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 21-Dec-16.
 */
public class RecipeBlocks {
    public static void registerRecipes() {
        if ((Config.enableSeaCauldron && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.addRecipe(new ItemStack(ChaliceBlocks.cauldronBoundless, 1), "i i", "ioi", "iti",
                    Character.valueOf('i'), Items.IRON_INGOT, Character.valueOf('o'), ChaliceItems.itemSeaPearl, Character.valueOf('t'), Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
        }
        if ((Config.enableVoidCauldron && Config.enableVoidPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.addRecipe(new ItemStack(ChaliceBlocks.cauldronVoid, 1), "i i", "ioi", "iti",
                    Character.valueOf('i'), Items.IRON_INGOT, Character.valueOf('o'), ChaliceItems.itemVoidPearl, Character.valueOf('t'), Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
        }
        if ((Config.enableLeakCauldron && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.addRecipe(new ItemStack(ChaliceBlocks.cauldronLeaking, 1), "i i", "ioi", "iti",
                    Character.valueOf('i'), Items.IRON_INGOT, Character.valueOf('o'), ChaliceItems.itemSeaPearl, Character.valueOf('t'), Blocks.IRON_BARS);
        }
    }
}
