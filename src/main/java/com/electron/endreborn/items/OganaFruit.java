package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class OganaFruit extends Item {
	public OganaFruit() {
		super(new Item.Properties().group(EndReborn.ENDGROUP).food(Foods.SWEET_BERRIES));
	}
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
		if (!worldIn.isRemote) {
			entityLiving.clearActivePotions();
		}
		if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
	        stack.shrink(1);
	    }
		return itemstack;
	}
	public int getUseDuration(ItemStack stack) {
		 return 8;
	}
	public UseAction getUseAction(ItemStack stack) {
		 return UseAction.DRINK;
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	     playerIn.setActiveHand(handIn);
	     return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
}
