package com.electron.endreborn.items;

import java.util.List;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class EnderBoots extends ArmorItem {
	public EnderBoots(EquipmentSlotType slot) {
        super(ModMaterials.ENDER_BOOTS, slot, new Properties().group(EndReborn.ENDGROUP));
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
	    tooltip.add(new TranslationTextComponent("tooltip.ender_boots"));
	}
}

