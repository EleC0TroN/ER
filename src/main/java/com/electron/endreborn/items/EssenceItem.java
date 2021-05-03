package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EssenceItem extends Item {
    public EssenceItem() {
        super(new Item.Properties().tab(EndReborn.ENDGROUP));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 2000;
    }
}
