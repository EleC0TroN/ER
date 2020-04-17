package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

public class WolframiumHoe extends HoeItem {
	public WolframiumHoe() {
		super(ModMaterials.TOOL_WOLFRAMIUM,-1f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
