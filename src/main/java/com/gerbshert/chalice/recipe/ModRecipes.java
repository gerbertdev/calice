package com.gerbshert.chalice.recipe;

import com.gerbshert.chalice.block.ModBlocks;
import com.gerbshert.chalice.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 05-Feb-17.
 */
public class ModRecipes {
    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModItems.chaliceWater, 1), "ioi", " i ", "iii", Character.valueOf('i'), Items.GOLD_INGOT, Character.valueOf('o'), ModItems.pearlWater);

        GameRegistry.addRecipe(new ItemStack(ModItems.chaliceVoid, 1), "ioi", " i ", "iii", Character.valueOf('i'), Items.GOLD_INGOT, Character.valueOf('o'), ModItems.pearlVoid);

        GameRegistry.addRecipe(new ItemStack(ModItems.pearlVoid, 1), " x ", "xox", " x ", Character.valueOf('x'), ModItems.corporealVoid, Character.valueOf('o'), Items.ENDER_PEARL);

        GameRegistry.addRecipe(new ItemStack(ModItems.pearlWater, 1), " x ", "xox", " x ", Character.valueOf('x'), Items.WATER_BUCKET, Character.valueOf('o'), Items.ENDER_PEARL);

        GameRegistry.addRecipe(new ItemStack(ModItems.seedWater, 8), " x ", "xox", " x ", Character.valueOf('o'), ModItems.chaliceWater.setContainerItem(ModItems.chaliceWater), Character.valueOf('x'), Items.SLIME_BALL);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.seedPond), ModItems.seedWater, ModItems.seedWater, ModItems.seedWater, ModItems.seedWater,ModItems.seedWater);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.seedLake), ModItems.seedPond, ModItems.seedPond);


        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.seedOcean), ModItems.seedLake, ModItems.seedLake, ModItems.seedPond);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.cauldronBoundless, 1), "i i", "ioi", "iti",
                Character.valueOf('i'), Items.IRON_INGOT, Character.valueOf('o'), ModItems.pearlWater, Character.valueOf('t'), Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.cauldronVoid, 1), "i i", "ioi", "iti",
                Character.valueOf('i'), Items.IRON_INGOT, Character.valueOf('o'), ModItems.pearlVoid, Character.valueOf('t'), Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    }
}
