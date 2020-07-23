package com.cgtyasln.mod1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cgtyasln.mod1.init.BlockInit;
import com.cgtyasln.mod1.init.ModTileEntityTypes;
import com.cgtyasln.mod1.world.gen.ModOreGen;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
        
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
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
