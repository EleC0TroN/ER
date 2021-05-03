package com.electron.endreborn.items.materials;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterials implements IArmorMaterial {
    TUNGSTEN("tungsten", 17, new int[]{2, 5, 6, 2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () -> {
        return Ingredient.fromItems(ModItems.TUNGSTEN_INGOT.get());
    }),
    ENDER("ender", 21, new int[]{2, 0, 0, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F, () -> {
        return null;
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final LazyValue<Ingredient> repairIngredient;

    private ModArmorMaterials(String p_i231593_3_, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, Supplier<Ingredient> p_i231593_10_) {
        this.name = p_i231593_3_;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.repairIngredient = new LazyValue<>(p_i231593_10_);
    }

    public int getDurability(EquipmentSlotType p_200896_1_) {
        return HEALTH_PER_SLOT[p_200896_1_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDamageReductionAmount(EquipmentSlotType p_200902_1_) {
        return this.slotProtections[p_200902_1_.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantmentValue;
    }

    public SoundEvent getSoundEvent() {
        return this.sound;
    }

    public Ingredient getRepairMaterial() {
        return this.repairIngredient.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return EndReborn.MODID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

}
