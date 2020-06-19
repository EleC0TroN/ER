package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.PaxelItem;
import com.electron.endreborn.items.materials.ModMaterials;
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
    public static final Item WOLFRAMIUM_PAXEL = new PaxelItem(ModMaterials.TOOL_WOLFRAMIUM, 6, -3.1f, new Item.Properties().group(EndReborn.ENDOMPAT));

    public static final Item ENDORIUM_PLATE = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_ROD = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_DUST = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_CRYSTAL = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_SHARD = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_DIRTY = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_CLUMP = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_PAXEL = new PaxelItem(ModMaterials.TOOL_ENDORIUM, 6, -3.1f, new Item.Properties().group(EndReborn.ENDOMPAT));

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerItems(RegistryEvent.Register<Item> event) {

        if (ImmersiveEngineering.isInstalled()) {
            registerItem(WOLFRAMIUM_PLATE, "wolframium_plate");
            registerItem(WOLFRAMIUM_ROD, "wolframium_rod");

            registerItem(ENDORIUM_PLATE, "endorium_plate");
            registerItem(ENDORIUM_ROD, "endorium_rod");

        }
        if (ImmersiveEngineering.isInstalled() || Mekanism.isInstalled()) {
            registerItem(ENDORIUM_DUST, "endorium_dust");
            registerItem(WOLFRAMIUM_DUST, "wolframium_dust");

        }
        if (Mekanism.isInstalled()) {
            registerItem(ENDORIUM_CRYSTAL, "endorium_crystals");
            registerItem(ENDORIUM_DIRTY, "endorium_dirty_dusts");
            registerItem(ENDORIUM_SHARD, "endorium_shards");
            registerItem(ENDORIUM_CLUMP, "endorium_clumps");
            registerItem(ENDORIUM_PAXEL, "endorium_paxel");
            registerItem(WOLFRAMIUM_PAXEL, "wolframium_paxel");
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
