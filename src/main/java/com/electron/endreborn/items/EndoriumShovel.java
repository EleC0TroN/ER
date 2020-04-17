package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class EndoriumShovel extends ShovelItem {
	public EndoriumShovel() {
		super(ModMaterials.TOOL_ENDORIUM, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
