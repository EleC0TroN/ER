package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class WolframiumShovel extends ShovelItem {
	public WolframiumShovel() {
		super(ModMaterials.TOOL_WOLFRAMIUM, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
