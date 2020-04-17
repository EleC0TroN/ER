package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

public class EndstoneAxe extends AxeItem {
	public EndstoneAxe() {
		super(ModMaterials.TOOL_ENDSTONE, 6f, -3.1f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
