package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class EndstoneSword extends SwordItem {
	public EndstoneSword() {
		super(ModMaterials.TOOL_ENDSTONE, 3, -2.4f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
