package com.gerbshert.chalice.utility;

import com.gerbshert.chalice.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeEnd;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Gabriel on 06-Feb-17.
 */
public class EventHandler {
    @SubscribeEvent
    public void useBucket(PlayerInteractEvent.RightClickItem event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player_ = (EntityPlayer) event.getEntity();
            World world = player_.getEntityWorld();
            BlockPos pos = player_.getPosition();
            ItemStack inHand = player_.getHeldItem(event.getHand());
            if (inHand.getItem() == Items.BUCKET) {
                if (world.getBiome(pos) instanceof BiomeEnd) {

                    ItemStack newIS = new ItemStack(ModItems.corporealVoid, 1);

                    player_.dropItem(newIS, false);
                }
            }
        }
    }

    @SubscribeEvent
    public void getVoid(EntityItemPickupEvent event) {
        if (event.getItem().getEntityItem().getItem() == ModItems.corporealVoid) {
            event.getEntityPlayer().addStat(Achievements.achievementCorporealVoid, 1);
        }
    }
}
