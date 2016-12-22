package com.gerbshert.chalice.items;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.libraries.Strings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.gerbshert.chalice.libraries.Config;

import static com.gerbshert.chalice.libraries.Config.*;

/**
 * Created by Gabriel on 14-Dec-16.
 */
public class ChaliceItems {
    //Create Item
    public static Item chaliceSea = new ChaliceSea().setCreativeTab(Chalice.chaliceTab);
    public static Item chaliceVoid = new ChaliceVoid().setCreativeTab(Chalice.chaliceTab);
    public static Item itemSeaPearl = new Item().setUnlocalizedName(Strings.MOD_ID + "." + "itemSeaPearl").setRegistryName(Strings.MOD_ID, "itemSeaPearl").setCreativeTab(Chalice.chaliceTab);
    public static Item itemVoidPearl = new Item().setUnlocalizedName(Strings.MOD_ID + "." + "itemVoidPearl").setRegistryName(Strings.MOD_ID, "itemVoidPearl").setCreativeTab(Chalice.chaliceTab);

    //Register Item
    public static void registerItems() {
        if ((enableSeaChalice && enableSeaPearl) || !disableOnIngredientRemoved) {
            GameRegistry.register(chaliceSea);
        }
        if ((enableVoidChalice && enableVoidPearl) || !disableOnIngredientRemoved) {
            GameRegistry.register(chaliceVoid);
        }
        if (enableSeaPearl) {
            GameRegistry.register(itemSeaPearl);
        }
        if (enableVoidPearl) {
            GameRegistry.register(itemVoidPearl);
        }
    }

    //Register Item Recipes
    public static void registerItemsRecipes() {
        if ((enableSeaChalice && (enableSeaPearl) || !disableOnIngredientRemoved)) {
            GameRegistry.addRecipe(new ItemStack(chaliceSea, 1), "ioi", " i ", "iii", Character.valueOf('i'), Items.GOLD_INGOT, Character.valueOf('o'), itemSeaPearl);
        }
        if ((enableVoidChalice && (enableVoidPearl) || !disableOnIngredientRemoved)) {
            GameRegistry.addRecipe(new ItemStack(chaliceVoid, 1), "ioi", " i ", "iii", Character.valueOf('i'), Items.GOLD_INGOT, Character.valueOf('o'), itemVoidPearl);
        }
        if (enableVoidPearl) {
            GameRegistry.addRecipe(new ItemStack(itemVoidPearl, 1), " x ", "xox", " x ", Character.valueOf('x'), Blocks.OBSIDIAN, Character.valueOf('o'), Items.ENDER_PEARL);
        }
        if (enableSeaPearl) {
            GameRegistry.addRecipe(new ItemStack(itemSeaPearl, 1), " x ", "xox", " x ", Character.valueOf('x'), Blocks.LAPIS_BLOCK, Character.valueOf('o'), Items.ENDER_PEARL);
        }
        //GameRegistry.addRecipe(new ItemStack(toolChalice,1),"ioi"," i ","iii",Character.valueOf('i'), "ingotBrass",Character.valueOf('o'), itemVoidPearl);
    }

    //Render Item
    public static void renderItems() {
        if ((enableSeaChalice && (enableSeaPearl) || !disableOnIngredientRemoved)) {
            renderMe(chaliceSea);
        }
        if ((enableVoidChalice && (enableVoidPearl) || !disableOnIngredientRemoved)) {
            renderMe(chaliceVoid);
        }
        if (enableSeaPearl) {
            renderMe(itemSeaPearl);
        }
        if (enableVoidPearl) {
            renderMe(itemVoidPearl);
        }
    }

    public static void renderMe(Item myItem) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(myItem, 0, new ModelResourceLocation(myItem.getRegistryName(), "inventory"));
    }
}
