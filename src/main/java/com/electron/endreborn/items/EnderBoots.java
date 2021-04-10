package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModArmorMaterials;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.datafix.fixes.JukeboxRecordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class EnderBoots extends ArmorItem {
	public EnderBoots(EquipmentSlotType slot) {
        super(ModArmorMaterials.ENDER, slot, new Properties().tab(EndReborn.ENDGROUP));
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
		tooltip.add(new TranslationTextComponent("tooltip.effect").withStyle(TextFormatting.GRAY));
	    tooltip.add(new TranslationTextComponent("tooltip.ender_boots").withStyle(TextFormatting.DARK_GRAY));
	}
}

