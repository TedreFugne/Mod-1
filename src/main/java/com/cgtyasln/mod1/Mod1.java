package com.cgtyasln.mod1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cgtyasln.mod1.init.BlockInit;
import com.cgtyasln.mod1.init.BlockInitNew;
import com.cgtyasln.mod1.init.ItemInitNew;
import com.cgtyasln.mod1.init.ModTileEntityTypes;
import com.cgtyasln.mod1.world.gen.ModOreGen;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("mod1")
public class Mod1
{
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "mod1";
	public static Mod1 instance;
	
    public Mod1() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        
        ItemInitNew.ITEMS.register(modEventBus);
        BlockInitNew.BLOCKS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) 
    {
    	final IForgeRegistry <Item> registry = event.getRegistry();
    
    	BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> 
    	{
    		final Item.Properties properties = new Item.Properties().group(Mod1ItemGroup.instance);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	LOGGER.debug("Registered BlockItems!");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
    	
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) 
    {
    	ModOreGen.generateOre();
    }
    
    public static class Mod1ItemGroup extends ItemGroup 
    {
    	public static final Mod1ItemGroup instance = new Mod1ItemGroup(ItemGroup.GROUPS.length, "modtab");
    	private Mod1ItemGroup(int index, String label) 
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon() 
    	{
    		return new ItemStack(BlockInit.mod1_block);
    	}
    }
}
