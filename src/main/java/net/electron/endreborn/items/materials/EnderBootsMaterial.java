package net.electron.endreborn.items.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EnderBootsMaterial implements ArmorMaterial
{
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 320};
    private static final int[] PROTECTION_AMOUNTS = new int[]{3, 5, 6, 6};

    @Override
    public int getDurability(EquipmentSlot equipmentSlot)
    {
        return BASE_DURABILITY[equipmentSlot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot equipmentSlot)
    {
        return PROTECTION_AMOUNTS[equipmentSlot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability()
    {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return null;
    }

    @Override
    public String getName()
    {
        return "ender";
    }

    @Override
    public float getToughness()
    {
        return 2;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.0f;
    }
}