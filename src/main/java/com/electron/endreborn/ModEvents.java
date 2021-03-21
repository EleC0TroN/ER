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
		if (ModConfigs.COMMON.balance.enderman_tweaks.get() && !event.getEntityLiving().world.isRemote()) {
			LivingEntity entity = event.getEntityLiving();
			if (entity instanceof EndermanEntity) {
				entity.remove();
				EndormanMob endor = new EndormanMob(ModMobs.ENDOR, entity.world);
				endor.copyLocationAndAnglesFrom(entity);
				int i = entity.world.getRandom().nextInt(5);
				endor.setEndorSize(i);
				entity.world.addEntity(endor);
			}
		}
	}

	@SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
		  ItemStack feet = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET);
		  if(feet.getItem() == ModItems.ENDER_BOOTS.get()) {
	        if (event.getSource().getTrueSource() instanceof Entity) {
	        	float amount = event.getAmount();
	            if (!event.getEntityLiving().world.isRemote) {
	                for(int i = 0; i < 16; ++i) {
	                   double d3 = event.getEntityLiving().getPosX() + (event.getEntityLiving().getRNG().nextDouble() - 0.5D) * 16.0D;
	                   double d4 = MathHelper.clamp(event.getEntityLiving().getPosY() + (double)(event.getEntityLiving().getRNG().nextInt(16) - 8), 0.0D, (double)(event.getEntityLiving().world.func_234938_ad_() - 1));
	                   double d5 = event.getEntityLiving().getPosZ() + (event.getEntityLiving().getRNG().nextDouble() - 0.5D) * 16.0D;
	                   if (event.getEntityLiving().isPassenger()) {
	                	   event.getEntityLiving().stopRiding();
	                   }
	                   if (event.getEntityLiving().attemptTeleport(d3, d4, d5, true)) {
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
