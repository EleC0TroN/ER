package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class WolframiumSword extends SwordItem {
	public WolframiumSword() {
		super(ModMaterials.TOOL_WOLFRAMIUM, 3, -2.4f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
