package com.electron.endreborn.items.materials;

import com.electron.endreborn.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModToolMaterials implements IItemTier {
    TUNGSTEN(2, 200, 7.0F, 2.5F, 0, () -> {
        return Ingredient.of(ModItems.TUNGSTEN_INGOT.get());
    }),
    ENDORIUM(3, 1200, 9.0F, 4.0F, 16, () -> {
        return Ingredient.of(ModItems.ENDORIUM_INGOT.get());
    }),
    ENDORIUM_FLEXIBILITY(3, 1200, 10.8F, 4.0F, 16, () -> {
        return Ingredient.of(ModItems.ENDORIUM_INGOT.get());
    }),
    ENDSTONE(1, 180, 3.0F, 1.0F, 10, () -> {
        return Ingredient.of(ModItems.END_STONE_SMOOTH.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private ModToolMaterials (int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    public int getUses() {
        return this.maxUses;
    }

    public float getSpeed() {
        return this.efficiency;
    }

    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    public int getLevel() {
        return this.harvestLevel;
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}