package com.electron.endreborn;

import com.electron.endreborn.world.NatureStructures;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = EndReborn.MODID)
public class ModEvents {

	@SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
		  ItemStack feet = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET);
		  if(feet.getItem() == ModItems.ENDER_BOOTS.get()) {
	        if (event.getSource().getTrueSource() instanceof Entity) {
	        	float amount = event.getAmount();

	            if (!event.getEntityLiving().world.isRemote) {

	                for(int i = 0; i < 16; ++i) {
	                   double d3 = event.getEntityLiving().getPosX() + (event.getEntityLiving().getRNG().nextDouble() - 0.5D) * 16.0D;
	                   double d4 = MathHelper.clamp(event.getEntityLiving().getPosY() + (double)(event.getEntityLiving().getRNG().nextInt(16) - 8), 0.0D, (double)(event.getEntityLiving().world.getActualHeight() - 1));
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
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{

		/**
		 * This method will be called by Forge when it is time for the mod to register features.
		 */
		@SubscribeEvent
		public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event)
		{
			//registers the structures/features.
			//If you don't do this, you'll crash.
			NatureStructures.registerStructures(event);

			EndReborn.LOGGER.log(Level.INFO, "features/structures registered.");
		}
	}
}
