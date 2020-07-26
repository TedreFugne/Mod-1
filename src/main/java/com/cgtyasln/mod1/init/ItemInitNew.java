package com.cgtyasln.mod1.init;

import com.cgtyasln.mod1.Mod1;
import com.cgtyasln.mod1.Mod1.Mod1ItemGroup;
import com.cgtyasln.mod1.objects.items.SpecialItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mod1.MOD_ID);
	
	public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", () -> new SpecialItem(new Item.Properties().group(Mod1ItemGroup.instance)));
}
