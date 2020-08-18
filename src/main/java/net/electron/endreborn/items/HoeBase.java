package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class HoeBase extends HoeItem {
    public HoeBase(ToolMaterial toolMaterial_1, float f, Settings settings) {
        super(toolMaterial_1, 1, f, new Item.Settings().group(EndReborn.END_GROUP));
    }
}