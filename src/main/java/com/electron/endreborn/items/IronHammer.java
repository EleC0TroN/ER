package com.electron.endreborn.items;

import java.util.Random;

import com.electron.endreborn.EndReborn;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class IronHammer extends Item {
	public IronHammer() {
		super(new Item.Properties().group(EndReborn.ENDGROUP).defaultMaxDamage(64));
	}
	@Override
    public boolean hasContainerItem(ItemStack stack) 
    {
    	return true;
    }

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack container = itemStack.copy();
		container.attemptDamageItem(2, new Random(), null);
		return container;
	}
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		  stack.damageItem(1, attacker, null);
	      return true;
	}
}
