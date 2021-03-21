package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class ImmersiveEngineering {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndReborn.MODID);

    public static final RegistryObject<BlockItem> ENDORIUM_SHEETMETAL = ITEMS.register("sheetmetal_endorium", () -> new BlockItem(ModBlocks.ENDORIUM_SHEETMETAL.get(), new Item.Properties().group(ImmersiveEngineering.isInstalled() ? EndReborn.ENDOMPAT : null)));
    public static final RegistryObject<BlockItem> TUNGSTEN_SHEETMETAL = ITEMS.register("sheetmetal_tungsten", () -> new BlockItem(ModBlocks.TUNGSTEN_SHEETMETAL.get(), new Item.Properties().group(ImmersiveEngineering.isInstalled() ? EndReborn.ENDOMPAT : null)));

    public static boolean isInstalled() {
        return ModList.get() != null && ModList.get().getModContainerById("immersiveengineering").isPresent();
    }
}
