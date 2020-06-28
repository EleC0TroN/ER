package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CompatTab extends ItemGroup {
    public CompatTab() {
        super("endcompatgroup");
    }
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.ENDORIUM_BLOCK.get());
    }
}

