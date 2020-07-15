package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaBoom {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndReborn.MODID);

    public static final RegistryObject<BlockItem> ESSENCE_BLOCK = ITEMS.register("essence_block", () -> new BlockItem(ModBlocks.ESSENCE_BLOCK.get(), new Item.Properties().group(VanillaBoom.isInstalled() ? EndReborn.ENDOMPAT : null)));
    public static final RegistryObject<BlockItem> XORCITE_PILLAR = ITEMS.register("xorcite_pillar", () -> new BlockItem(ModBlocks.XORCITE_PILLAR.get(), new Item.Properties().group(VanillaBoom.isInstalled() ? EndReborn.ENDOMPAT : null)));

    public static boolean isInstalled() {
        return ModList.get() != null && ModList.get().getModContainerById("vanillaboom").isPresent();
    }
}
