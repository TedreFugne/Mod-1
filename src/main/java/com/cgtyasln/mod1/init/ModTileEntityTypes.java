package com.cgtyasln.mod1.init;

import com.cgtyasln.mod1.Mod1;
import com.cgtyasln.mod1.tileentity.QuarryTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes 
{
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Mod1.MOD_ID);
	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry", () -> TileEntityType.Builder.create(QuarryTileEntity::new, BlockInit.quarry).build(null));
}
