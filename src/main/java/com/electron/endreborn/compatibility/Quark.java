package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Quark {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EndReborn.MODID);

    public static final RegistryObject<BlockItem> FRAMED_OBSIDIAN_GLASS = ITEMS.register("framed_obsidian_glass", () -> new BlockItem(ModBlocks.FRAMED_OBSIDIAN_GLASS.get(), new Item.Properties().group(Quark.isInstalled() ? EndReborn.ENDOMPAT : null)));
    public static final RegistryObject<BlockItem> ENDSTONE_BUTTON = ITEMS.register("end_stone_button", () -> new BlockItem(ModBlocks.ENDSTONE_BUTTON.get(), new Item.Properties().group(Quark.isInstalled() ? EndReborn.ENDOMPAT : null)));
    public static final RegistryObject<BlockItem> FRAMED_OBSIDIAN_GLASS_PANE = ITEMS.register("framed_obsidian_glass_pane", () -> new BlockItem(ModBlocks.FRAMED_OBSIDIAN_GLASS_PANE.get(), new Item.Properties().group(Quark.isInstalled() ? EndReborn.ENDOMPAT : null)));

    public static boolean isInstalled() {
        return ModList.get() != null && ModList.get().getModContainerById("quark").isPresent();
    }
}
