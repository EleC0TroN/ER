package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBase extends PickaxeItem
{
    public PickaxeBase(ToolMaterial toolMaterial_1, int i, float f, Settings settings)
    {
        super(toolMaterial_1, i, f, new Item.Settings().group(EndReborn.END_GROUP));
    }
}