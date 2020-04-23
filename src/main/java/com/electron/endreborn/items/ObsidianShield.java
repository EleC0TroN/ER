package com.electron.endreborn.items;

import com.electron.endreborn.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tags.ItemTags;

public class ObsidianShield extends ShieldItem {
    public ObsidianShield(Properties builder) {
        super(builder);
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 144000;
    }
}
