package com.electron.endreborn;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = EndReborn.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EndTab extends ItemGroup {
	public EndTab() {
		super("endgroup"); 
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.ENDER_PEARL); 
	}	
}
