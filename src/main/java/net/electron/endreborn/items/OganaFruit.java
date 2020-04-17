package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class OganaFruit extends Item {
	public OganaFruit() {
		super(new Item.Settings().group(EndReborn.END_GROUP));
	}
	 public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
	      if (user instanceof ServerPlayerEntity) {
	         ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
	         Criterions.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
	         serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
	      }

	      if (user instanceof PlayerEntity && !((PlayerEntity)user).abilities.creativeMode) {
	         stack.decrement(1);
	      }

	      if (!world.isClient) {
	         user.clearStatusEffects();
	      }

	      return stack;
	   }

	   public int getMaxUseTime(ItemStack stack) {
	      return 8;
	   }

	   public UseAction getUseAction(ItemStack stack) {
	      return UseAction.DRINK;
	   }

	   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
	      user.setCurrentHand(hand);
	      return TypedActionResult.success(user.getStackInHand(hand));
	   }
}
