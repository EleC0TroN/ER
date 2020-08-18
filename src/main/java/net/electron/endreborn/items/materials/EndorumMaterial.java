
package net.electron.endreborn.items.materials;

import net.electron.endreborn.items.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EndorumMaterial implements ToolMaterial{

	@Override
	public int getDurability() {
		return 540;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 7f;
	}

	@Override
	public float getAttackDamage() {
		return 4.5f;
	}

	@Override
	public int getMiningLevel() {
		return 3;
	}

	@Override
	public int getEnchantability() {
		return 16;
	}

	@Override
	public Ingredient getRepairIngredient() {
		Ingredient repairMaterial = Ingredient.ofItems(ModItems.END_NUGGET);
        return repairMaterial;
	}

}

