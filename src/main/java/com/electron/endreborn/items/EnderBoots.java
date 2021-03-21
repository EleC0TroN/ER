package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModArmorMaterials;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class EnderBoots extends ArmorItem {
	public EnderBoots(EquipmentSlotType slot) {
        super(ModArmorMaterials.ENDER_BOOTS, slot, new Properties().group(EndReborn.ENDGROUP));
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip.effect").mergeStyle(TextFormatting.GRAY));
	    tooltip.add(new TranslationTextComponent("tooltip.ender_boots").mergeStyle(TextFormatting.DARK_GRAY));
	}
}

