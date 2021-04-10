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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class TungstenArmorItem extends ArmorItem {
    public TungstenArmorItem(EquipmentSlotType slot) {
        super(ModArmorMaterials.TUNGSTEN, slot, new Properties().tab(EndReborn.ENDGROUP));
    }

    @Override
    public void onArmorTick(final ItemStack stack, final World world, final PlayerEntity player)
    {
        ItemStack head = player.getItemBySlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlotType.FEET);

        if(head.getItem() == ModItems.TUNGSTEN_HELMET.get() || chest.getItem() == ModItems.TUNGSTEN_CHESTPLATE.get() || legs.getItem() == ModItems.TUNGSTEN_LEGGINGS.get() || feet.getItem() == ModItems.TUNGSTEN_BOOTS.get()) {
            player.removeEffect(Effects.LEVITATION);
            player.removeEffect(Effects.SLOW_FALLING);
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return false;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == ModItems.TUNGSTEN_INGOT.get();
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("tooltip.effect").withStyle(TextFormatting.GRAY));
        tooltip.add(new TranslationTextComponent("tooltip.tungsten_armor").withStyle(TextFormatting.DARK_GRAY));
    }
}


