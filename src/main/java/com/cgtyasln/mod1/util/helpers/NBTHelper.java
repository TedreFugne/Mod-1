package com.cgtyasln.mod1.util.helpers;

import com.cgtyasln.mod1.tileentity.QuarryTileEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class NBTHelper 
{
	public static CompoundNBT toNBT(Object o) 
	{
		if(o instanceof ItemStack) 
		{
			return writeItemStack((ItemStack)o);
		}
		
		if(o instanceof QuarryTileEntity) 
		{
			return writeQuarry((QuarryTileEntity)o);
		}
		
		return null;
	}
	
	private static CompoundNBT writeQuarry(QuarryTileEntity o) 
	{
		CompoundNBT compound = new CompoundNBT();
		compound.putInt("x", o.x);
		compound.putInt("y", o.y);
		compound.putInt("z", o.z);
		return compound;
	}
	
	private static CompoundNBT writeItemStack(ItemStack i) 
	{
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("count", i.getCount());
		nbt.putString("item", i.getItem().getRegistryName().toString());
		nbt.putByte("type", (byte)0);
		return nbt;
	}
}
