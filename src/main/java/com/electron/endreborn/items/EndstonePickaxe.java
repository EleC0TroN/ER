package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

public class EndstonePickaxe extends PickaxeItem {
	public EndstonePickaxe() {
		super(ModMaterials.TOOL_ENDSTONE, 1, -2.8f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
