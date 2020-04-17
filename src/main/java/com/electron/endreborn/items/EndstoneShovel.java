package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class EndstoneShovel extends ShovelItem {
	public EndstoneShovel() {
		super(ModMaterials.TOOL_ENDSTONE, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
