package com.electron.endreborn;

import com.electron.endreborn.mobs.EndormanMob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndReborn.MODID)
public class ModEvents {
	
	@SubscribeEvent
	public static void onEnderSpawn(LivingSpawnEvent.SpecialSpawn event) {
		if (ModConfigs.COMMON.balance.enderman_tweaks.get() && !event.getEntityLiving().level.isClientSide()) {
			LivingEntity entity = event.getEntityLiving();
			if (entity instanceof EndermanEntity) {
				entity.remove();
				EndormanMob endor = new EndormanMob(ModMobs.ENDOR.get(), entity.level);
				endor.copyPosition(entity);
				int i = entity.level.getRandom().nextInt(5);
				endor.setEndorSize(i);
				entity.level.addFreshEntity(endor);
			}
		}
	}

	@SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
		  ItemStack feet = event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET);
		  if(feet.getItem() == ModItems.ENDER_BOOTS.get()) {
	        if (event.getSource().getDirectEntity() instanceof Entity) {
	        	float amount = event.getAmount();
	            if (!event.getEntityLiving().level.isClientSide) {
	                for(int i = 0; i < 16; ++i) {
	                   double d3 = event.getEntityLiving().getX() + (event.getEntityLiving().getRandom().nextDouble() - 0.5D) * 16.0D;
	                   double d4 = MathHelper.clamp(event.getEntityLiving().getY() + (double)(event.getEntityLiving().getRandom().nextInt(16) - 8), 0.0D, (double)(event.getEntityLiving().level.getHeight() - 1));
	                   double d5 = event.getEntityLiving().getZ() + (event.getEntityLiving().getRandom().nextDouble() - 0.5D) * 16.0D;
	                   if (event.getEntityLiving().isPassenger()) {
	                	   event.getEntityLiving().stopRiding();
	                   }
	                   if (event.getEntityLiving().randomTeleport(d3, d4, d5, true)) {
	                	   amount = amount / 2;
	                       event.setAmount(amount);
	                      break;
	                   }
	                }
	            }
			}
		}
	}
}
