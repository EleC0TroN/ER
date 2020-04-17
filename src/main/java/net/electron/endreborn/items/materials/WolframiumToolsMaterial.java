package net.electron.endreborn.items.materials;

import net.electron.endreborn.items.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WolframiumToolsMaterial implements ToolMaterial{

	@Override
	public int getDurability() {
		return 250;
	}

	@Override
	public float getMiningSpeed() {
		return 5f;
	}

	@Override
	public float getAttackDamage() {
		return 2.5f;
	}

	@Override
	public int getMiningLevel() {
		return 2;
	}

	@Override
	public int getEnchantability() {
		return 16;
	}

	@Override
	public Ingredient getRepairIngredient() {
		Ingredient repairMaterial = Ingredient.ofItems(Items.WOLF_INGOT);
        return repairMaterial;
	}

}
