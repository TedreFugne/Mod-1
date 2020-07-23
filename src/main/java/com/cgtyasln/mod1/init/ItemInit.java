package com.cgtyasln.mod1.init;

import java.util.function.Supplier;

import com.cgtyasln.mod1.Mod1;
import com.cgtyasln.mod1.Mod1.Mod1ItemGroup;
import com.cgtyasln.mod1.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Mod1.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Mod1.MOD_ID)
public class ItemInit 
{
	public static final Item mod1_item = null;
	public static final Item special_item = null;
	
	//Tools
	public static final Item mod1_sword = null;
	public static final Item mod1_pickaxe = null;
	public static final Item mod1_shovel = null;
	public static final Item mod1_axe = null;
	public static final Item mod1_hoe = null;
	
	//Armor
	public static final Item mod1_helmet = null;
	public static final Item mod1_chestplate = null;
	public static final Item mod1_leggings = null;
	public static final Item mod1_boots = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new Item(new Item.Properties().group(Mod1ItemGroup.instance).food(new Food.Builder().hunger(6).saturation(1.2F).build())).setRegistryName("mod1_item"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(Mod1ItemGroup.instance)).setRegistryName("special_item"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.MOD1, 7, 5.0F, new Item.Properties().group(Mod1.Mod1ItemGroup.instance)).setRegistryName("mod1_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.MOD1, 4, 5.0F, new Item.Properties().group(Mod1.Mod1ItemGroup.instance)).setRegistryName("mod1_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.MOD1, 2, 5.0F, new Item.Properties().group(Mod1.Mod1ItemGroup.instance)).setRegistryName("mod1_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.MOD1, 11, 3.0F, new Item.Properties().group(Mod1.Mod1ItemGroup.instance)).setRegistryName("mod1_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.MOD1, 5.0F, new Item.Properties().group(Mod1.Mod1ItemGroup.instance)).setRegistryName("mod1_hoe"));
		
		//Armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.MOD1, EquipmentSlotType.HEAD, new Item.Properties().group(Mod1ItemGroup.instance)).setRegistryName("mod1_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.MOD1, EquipmentSlotType.CHEST, new Item.Properties().group(Mod1ItemGroup.instance)).setRegistryName("mod1_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.MOD1, EquipmentSlotType.LEGS, new Item.Properties().group(Mod1ItemGroup.instance)).setRegistryName("mod1_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.MOD1, EquipmentSlotType.FEET, new Item.Properties().group(Mod1ItemGroup.instance)).setRegistryName("mod1_boots"));

	}
	
	public enum ModItemTier implements IItemTier 
	{	
		MOD1(4, 1500, 15.0F, 7.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.mod1_item);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) 
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public float getAttackDamage() 
		{
			return this.attackDamage;
		}

		@Override
		public float getEfficiency() 
		{
			return this.efficiency;
		}

		@Override
		public int getEnchantability() 
		{
			return this.enchantability;
		}

		@Override
		public int getHarvestLevel() 
		{
			return this.harvestLevel;
		}

		@Override
		public int getMaxUses() 
		{
			return this.maxUses;
		}

		@Override
		public Ingredient getRepairMaterial() 
		{
			return this.repairMaterial.getValue();
		}
		
	}
	
	public enum ModArmorMaterial implements IArmorMaterial
	{
		MOD1(Mod1.MOD_ID + ":mod1", 5, new int[] {7,9, 11, 7}, 420, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 6.9F, () -> {
			return Ingredient.fromItems(ItemInit.mod1_item);
		});
		
		private static final int[] MAX_DAMAGE_ARRAY = new int [] { 16, 16, 16, 16 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) 
		{
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) 
		{
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}	

		@Override
		public int getDurability(EquipmentSlotType slotIn) 
		{
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getEnchantability() 
		{
			return this.enchantability;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() 
		{
			return this.name;
		}

		@Override
		public Ingredient getRepairMaterial() 
		{
			return this.repairMaterial.getValue();
		}

		@Override
		public SoundEvent getSoundEvent() 
		{
			return this.soundEvent;
		}

		@Override
		public float getToughness() 
		{
			return this.toughness;
		}		
	}
}
