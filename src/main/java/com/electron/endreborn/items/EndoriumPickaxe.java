package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.materials.ModMaterials;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

public class EndoriumPickaxe extends PickaxeItem {
	public EndoriumPickaxe() {
		super(ModMaterials.TOOL_ENDORIUM, 1, -2.8f, new Item.Properties().group(EndReborn.ENDGROUP));
	}
}
