package com.electron.endreborn;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = EndReborn.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EndTab extends ItemGroup {
	public EndTab() {
		super("endgroup"); 
	}
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.CRACKED_END_BRICKS.get());
	}	
}
