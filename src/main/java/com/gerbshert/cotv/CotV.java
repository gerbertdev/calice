package com.gerbshert.cotv;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Arrays;
import java.util.Random;


/**
 * Created by Gabriel on 28-Apr-16.
 */
@Mod(modid = CotV.MOD_ID, version = CotV.VERSION, name = CotV.NAME)
public class CotV {
    public static final String MOD_ID = "cotv";
    public static final String VERSION = "1_8_9.0.0";
    public static final String NAME = "Chalice of the Void";

    public static String[] defaultBlackList = {"example", "fluids"};
    public static String[] fluidBlacklist;

    public static Item toolChalice;
    public static Item toolChalice_WAPC;
    public static Item itemVoidPearl;

    public static void registerItems() {
        toolChalice = new ChaliceItem("toolChalice");
        toolChalice_WAPC = new ChaliceItem("toolChalice_WAPC");
        itemVoidPearl = new VPearlItem("itemVoidPearl");
    }

    public static void renderItems() {
        renderMe(toolChalice, "toolChalice");
        renderMe(toolChalice_WAPC, "toolChalice_WAPC");
        renderMe(itemVoidPearl, "itemVoidPearl");
    }

    public static void renderMe(Item myItem, String myName) {
        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        renderItem.getItemModelMesher().register(myItem, 0, new ModelResourceLocation(MOD_ID + ":" + myName, "inventory"));
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        fluidBlacklist = config.get(config.CATEGORY_GENERAL, "Black-listed Fluids", defaultBlackList).getStringList();

        registerItems();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new ItemStack(itemVoidPearl, 1), " x ", "xox", " x ", Character.valueOf('x'), Blocks.obsidian, Character.valueOf('o'), Items.ender_pearl);
        GameRegistry.addRecipe(new ItemStack(toolChalice, 1), "ioi", " i ", "iii", Character.valueOf('i'), Items.gold_ingot, Character.valueOf('o'), itemVoidPearl);
        //GameRegistry.addRecipe(new ItemStack(toolChalice,1),"ioi"," i ","iii",Character.valueOf('i'), "ingotBrass",Character.valueOf('o'), itemVoidPearl);
        ItemStack green = new ItemStack(Items.dye, 1, 2);
        GameRegistry.addShapelessRecipe(new ItemStack(toolChalice_WAPC, 1), toolChalice, green);
        if (event.getSide() == Side.CLIENT) {
            System.out.println("You are running Chalice of the Void on a client! Thanks so much :3 for the support this mod! ~ Gerb");
            renderItems();
        } else {
            System.out.println("You are running Chalice of the Void on a server! Thanks so much :3 for the support this mod! ~ Gerb");
        }
    }

    private static class VPearlItem extends Item {
        public VPearlItem(String name) {
            maxStackSize = 1;
            setCreativeTab(CreativeTabs.tabMaterials);
            setUnlocalizedName(MOD_ID + "." + name);
            GameRegistry.registerItem(this, name);
        }
    }

    public static class ChaliceItem extends Item {
        public ChaliceItem(String name) {
            maxStackSize = 1;
            if (name != "toolChalice_WAPC") {
                setCreativeTab(CreativeTabs.tabTools);
            }
            setUnlocalizedName(MOD_ID + "." + name);
            GameRegistry.registerItem(this, name);
        }

        public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);
            if (movingobjectposition == null) {
                return itemStackIn;
            } else {
                if ((movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)) {
                    BlockPos blockpos = movingobjectposition.getBlockPos();
                    Block block = worldIn.getBlockState(blockpos).getBlock();
                    int block_id = GameData.getBlockRegistry().getId(block);
                    if (block instanceof BlockFluidBase || block instanceof BlockFluidFinite || block instanceof BlockFluidClassic || block instanceof BlockLiquid || block instanceof BlockStaticLiquid) {
                        if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                            return itemStackIn;
                        } else if (Arrays.asList(fluidBlacklist).contains(block.toString())) {
                            return itemStackIn;
                        } else {
                            int count = 0;
                            while (count != 5) {
                                Random rand = new Random();
                                int randomNum = rand.nextInt(5) % 5;
                                int randomNum2 = rand.nextInt(5) % 5;
                                worldIn.spawnParticle(EnumParticleTypes.BLOCK_DUST, blockpos.getX() + randomNum * .2, blockpos.getY(), blockpos.getZ() + randomNum2 * .2, 0, 0, 0, block_id);
                                count++;
                            }
                            if (playerIn.isSneaking()) {
                                worldIn.setBlockToAir(blockpos);
                                Block blockN = worldIn.getBlockState(blockpos.north()).getBlock();
                                Block blockE = worldIn.getBlockState(blockpos.east()).getBlock();
                                Block blockS = worldIn.getBlockState(blockpos.south()).getBlock();
                                Block blockW = worldIn.getBlockState(blockpos.west()).getBlock();
                                Block blockNW = worldIn.getBlockState(blockpos.north().west()).getBlock();
                                Block blockNE = worldIn.getBlockState(blockpos.north().east()).getBlock();
                                Block blockSE = worldIn.getBlockState(blockpos.south().east()).getBlock();
                                Block blockSW = worldIn.getBlockState(blockpos.south().west()).getBlock();
                                if (blockN instanceof BlockFluidBase || blockN instanceof BlockFluidFinite || blockN instanceof BlockFluidClassic || blockN instanceof BlockLiquid || blockN instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.north());
                                }
                                if (blockE instanceof BlockFluidBase || blockE instanceof BlockFluidFinite || blockE instanceof BlockFluidClassic || blockE instanceof BlockLiquid || blockE instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.east());
                                }
                                if (blockS instanceof BlockFluidBase || blockS instanceof BlockFluidFinite || blockS instanceof BlockFluidClassic || blockS instanceof BlockLiquid || blockS instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.south());
                                }
                                if (blockW instanceof BlockFluidBase || blockW instanceof BlockFluidFinite || blockW instanceof BlockFluidClassic || blockW instanceof BlockLiquid || blockW instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.west());
                                }
                                if (blockNW instanceof BlockFluidBase || blockNW instanceof BlockFluidFinite || blockNW instanceof BlockFluidClassic || blockNW instanceof BlockLiquid || blockNW instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.north().west());
                                }
                                if (blockNE instanceof BlockFluidBase || blockNE instanceof BlockFluidFinite || blockNE instanceof BlockFluidClassic || blockNE instanceof BlockLiquid || blockNE instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.north().east());
                                }
                                if (blockSE instanceof BlockFluidBase || blockSE instanceof BlockFluidFinite || blockSE instanceof BlockFluidClassic || blockSE instanceof BlockLiquid || blockSE instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.south().east());
                                }
                                if (blockSW instanceof BlockFluidBase || blockSW instanceof BlockFluidFinite || blockSW instanceof BlockFluidClassic || blockSW instanceof BlockLiquid || blockSW instanceof BlockStaticLiquid) {
                                    worldIn.setBlockToAir(blockpos.south().west());
                                }
                            } else {
                                worldIn.setBlockToAir(blockpos);
                            }
                            return itemStackIn;
                        }
                    }
                }
            }
            return itemStackIn;
        }
    }
}