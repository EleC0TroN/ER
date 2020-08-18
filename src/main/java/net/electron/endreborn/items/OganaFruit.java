package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;

public class OganaFruit extends Item {
	public OganaFruit() {
		super(new Item.Settings().group(EndReborn.END_GROUP).food(FoodComponents.SWEET_BERRIES));
	}
}
