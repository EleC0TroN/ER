package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.compatibility.mekanism.Mekanism;
import com.electron.endreborn.items.PaxelItem;
import com.electron.endreborn.items.materials.ModMaterials;
import mekanism.api.math.FloatingLong;
import mekanism.api.math.FloatingLongSupplier;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.config.MekanismConfig;
import mekanism.common.item.ItemEnergized;
import mekanism.common.registration.impl.ItemDeferredRegister;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
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

    public static final Item ENDORIUM_PLATE = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_ROD = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_DUST = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_PLATE = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_ROD = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_CRYSTAL = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_SHARD = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_DUST = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_DIRTY = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_CLUMP = new Item(new Item.Properties().group(EndReborn.ENDOMPAT));

    public static final Item ENDORIUM_PAXEL = new PaxelItem(ModMaterials.TOOL_ENDORIUM, 6, -2.4f, new Item.Properties().group(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_PAXEL = new PaxelItem(ModMaterials.TOOL_TUNGSTEN, 5, -2.4f, new Item.Properties().group(EndReborn.ENDOMPAT));

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerItems(RegistryEvent.Register<Item> event) {

        if (ImmersiveEngineering.isInstalled()) {
            registerItem(ENDORIUM_PLATE, "endorium_plate");
            registerItem(ENDORIUM_ROD, "endorium_rod");
            registerItem(TUNGSTEN_PLATE, "tungsten_plate");
            registerItem(TUNGSTEN_ROD, "tungsten_rod");

        }
        if (ImmersiveEngineering.isInstalled() || Mekanism.isInstalled()) {
            registerItem(TUNGSTEN_DUST, "tungsten_dust");
            registerItem(ENDORIUM_DUST, "endorium_dust");
        }
        if (Mekanism.isInstalled()) {
            registerItem(TUNGSTEN_CRYSTAL, "tungsten_crystal");
            registerItem(TUNGSTEN_DIRTY, "tungsten_dirty_dust");
            registerItem(TUNGSTEN_SHARD, "tungsten_shard");
            registerItem(TUNGSTEN_CLUMP, "tungsten_clump");
            registerItem(ENDORIUM_PAXEL, "endorium_paxel");
            registerItem(TUNGSTEN_PAXEL, "tungsten_paxel");
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
