package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelBase extends ShovelItem {
    public ShovelBase(ToolMaterial toolMaterial_1, float i, float f, Settings settings) {
        super(toolMaterial_1, i, f, new Item.Settings().group(EndReborn.END_GROUP));
    }
}