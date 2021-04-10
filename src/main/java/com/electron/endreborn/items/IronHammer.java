package com.electron.endreborn.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Random;

public class IronHammer extends Item {
	public IronHammer(Properties builder) {
		super(builder);
	}
	@Override
    public boolean hasContainerItem(ItemStack stack) {
    	return true;
    }

	@Nonnull
	@Override
	public ItemStack getContainerItem(@Nonnull ItemStack stack)
	{
		ItemStack container = stack.copy();
		if(container.hurt(1, new Random(), null))
			return ItemStack.EMPTY;
		else
			return container;
	}
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		  stack.hurtAndBreak(1, attacker, null);
	      return true;
	}
}
