package com.cgtyasln.mod1.init;

import com.cgtyasln.mod1.Mod1;
import com.cgtyasln.mod1.Mod1.Mod1ItemGroup;
import com.cgtyasln.mod1.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mod1.MOD_ID)
@Mod.EventBusSubscriber(modid = Mod1.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block mod1_block = null;
	public static final Block special_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5F, 15.0F).sound(SoundType.SAND)).setRegistryName("mod1_block"));
		event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).lightValue(4)).setRegistryName("special_block"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new BlockItem(mod1_block, new Item.Properties().maxStackSize(5).group(Mod1ItemGroup.instance)).setRegistryName("mod1_block"));
		event.getRegistry().register(new BlockItem(special_block, new Item.Properties().group(Mod1ItemGroup.instance)).setRegistryName("special_block"));
	}
	
}
