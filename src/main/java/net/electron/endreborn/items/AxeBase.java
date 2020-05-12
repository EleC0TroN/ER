package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem
{
    public AxeBase(ToolMaterial material, float i, float f, Settings settings)
    {
        super(material, i, f, new Item.Settings().group(EndReborn.END_GROUP));
    }
}