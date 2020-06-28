package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ImmersiveEngineering {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EndReborn.MODID);

    public static final RegistryObject<BlockItem> WOLFRAMIUM_SHEETMETAL = ITEMS.register("sheetmetal_wolframium", () -> new BlockItem(ModBlocks.WOLFRAMIUM_SHEETMETAL.get(), new Item.Properties().group(EndReborn.ENDOMPAT)));
    public static final RegistryObject<BlockItem> ENDORIUM_SHEETMETAL = ITEMS.register("sheetmetal_endorium", () -> new BlockItem(ModBlocks.ENDORIUM_SHEETMETAL.get(), new Item.Properties().group(EndReborn.ENDOMPAT)));

    public static boolean isInstalled() {
        return ModList.get() != null && ModList.get().getModContainerById("immersiveengineering").isPresent();
    }
}
