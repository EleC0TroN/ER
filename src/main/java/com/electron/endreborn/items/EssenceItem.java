package com.electron.endreborn.items;

import com.electron.endreborn.EndReborn;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class EssenceItem extends Item {
    public EssenceItem() {
        super(new Item.Properties().group(EndReborn.ENDGROUP));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 2000;
    }
}
