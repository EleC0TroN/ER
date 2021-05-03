package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModItems;
import com.electron.endreborn.items.materials.ModArmorMaterials;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class TungstenArmor extends ArmorItem {
	public TungstenArmor(EquipmentSlotType slot) {
        super(ModArmorMaterials.TUNGSTEN, slot, new Properties().group(EndReborn.ENDGROUP));
	}
	
	@Override
	public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
	{
		ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
	    ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);	

    	if(head.getItem() == ModItems.TUNGSTEN_HELMET.get() || chest.getItem() == ModItems.TUNGSTEN_CHESTPLATE.get() || legs.getItem() == ModItems.TUNGSTEN_LEGGINGS.get() || feet.getItem() == ModItems.TUNGSTEN_BOOTS.get()) {
			player.removePotionEffect(Effects.LEVITATION);
			player.removePotionEffect(Effects.SLOW_FALLING);
		}
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return false;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip.effect").applyTextStyle(TextFormatting.GRAY));
		tooltip.add(new TranslationTextComponent("tooltip.tungsten_armor").applyTextStyle(TextFormatting.DARK_GRAY));
	}
}

