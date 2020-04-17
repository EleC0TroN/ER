package com.electron.endreborn.items;

import java.util.List;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModItems;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class WolframiumArmor extends ArmorItem {
	public WolframiumArmor(EquipmentSlotType slot) {
        super(ModMaterials.ARMOR_WOLFRAMIUM, slot, new Properties().group(EndReborn.ENDGROUP));
	}
	
	@Override
	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);	

    	if(head.getItem() == ModItems.WOLFRAMIUM_HELMET.get() || chest.getItem() == ModItems.WOLFRAMIUM_CHESTPLATE.get() || legs.getItem() == ModItems.WOLFRAMIUM_LEGGINGS.get() || feet.getItem() == ModItems.WOLFRAMIUM_BOOTS.get()) {
			player.removeActivePotionEffect(Effects.LEVITATION); 
		}
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return false;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ModItems.WOLFRAMIUM_INGOT.get();
	}
    
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
	    tooltip.add(new TranslationTextComponent("tooltip.wolframium_armor"));
	}
}

