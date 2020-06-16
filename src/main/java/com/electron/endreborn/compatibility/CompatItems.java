package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CompatItems {

    // Immersive Engineering
    public static final Item WOLFRAMIUM_PLATE = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item WOLFRAMIUM_ROD = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item WOLFRAMIUM_DUST = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));

    public static final Item ENDORIUM_PLATE = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_ROD = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_DUST = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerItems(RegistryEvent.Register<Item> event) {

        if (ImmersiveEngineering.isInstalled()) {
            registerItem(WOLFRAMIUM_PLATE, "wolframium_plate");
            registerItem(WOLFRAMIUM_ROD, "wolframium_rod");
            registerItem(WOLFRAMIUM_DUST, "wolframium_dust");

            registerItem(ENDORIUM_PLATE, "endorium_plate");
            registerItem(ENDORIUM_ROD, "endorium_rod");
            registerItem(ENDORIUM_DUST, "endorium_dust");

        }

    }
    private static void registerItem(Item item, String name) {
        item.setRegistryName(new ResourceLocation(EndReborn.MODID, name));
        ForgeRegistries.ITEMS.register(item);
    }
    private static void registerBlockItem(BlockItem item, Block block, String name, String mod, @Nullable ItemGroup group) {
        ItemGroup modGroup = ModList.get().isLoaded(mod) ? group : null;
        item.setRegistryName(new ResourceLocation(EndReborn.MODID, name));
        ForgeRegistries.ITEMS.register(item);
    }
}
