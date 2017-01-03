package com.gerbshert.chalice.item;

import com.gerbshert.chalice.Chalice;
import com.gerbshert.chalice.libraries.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class ChaliceItems {
    //Creates Item Objects
    public static Item chaliceSea = new ItemSeaChalice().setCreativeTab(Chalice.chaliceTab);
    public static Item chaliceVoid = new ItemVoidChalice().setCreativeTab(Chalice.chaliceTab);
    public static Item itemSeaPearl = new CItemBase("itemSeaPearl", 3, true);
    public static Item itemVoidPearl = new CItemBase("itemVoidPearl", 3, true);

    //Registers Item Objects
    public static void registerItems() {
        if ((Config.enableSeaChalice && Config.enableSeaPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.register(chaliceSea);
        }
        if ((Config.enableVoidChalice && Config.enableVoidPearl) || !Config.disableOnIngredientRemoved) {
            GameRegistry.register(chaliceVoid);
        }
        if (Config.enableSeaPearl) {
            GameRegistry.register(itemSeaPearl);
        }
        if (Config.enableVoidPearl) {
            GameRegistry.register(itemVoidPearl);
        }
    }

    //Registers Item Rendering
    public static void renderItems() {
        if ((Config.enableSeaChalice && (Config.enableSeaPearl) || !Config.disableOnIngredientRemoved)) {
            renderMe(chaliceSea);
        }
        if ((Config.enableVoidChalice && (Config.enableVoidPearl) || !Config.disableOnIngredientRemoved)) {
            renderMe(chaliceVoid);
        }
        if (Config.enableSeaPearl) {
            renderMe(itemSeaPearl);
        }
        if (Config.enableVoidPearl) {
            renderMe(itemVoidPearl);
        }
    }

    public static void renderMe(Item myItem) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(myItem, 0, new ModelResourceLocation(myItem.getRegistryName(), "inventory"));
    }
}
