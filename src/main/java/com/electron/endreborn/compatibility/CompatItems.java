package com.electron.endreborn.compatibility;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.items.PaxelItem;
import com.electron.endreborn.items.materials.ModToolMaterials;
import com.electron.endreborn.items.relic.UpgradablePaxelItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CompatItems {

    public static final Item ENDORIUM_PLATE = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_ROD = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item ENDORIUM_DUST = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_PLATE = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_ROD = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_CRYSTAL = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_SHARD = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_DUST = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_DIRTY = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_CLUMP = new Item(new Item.Properties().tab(EndReborn.ENDOMPAT));

    public static final Item ENDORIUM_PAXEL = new PaxelItem(ModToolMaterials.ENDORIUM, 6, -2.4f, new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item TUNGSTEN_PAXEL = new PaxelItem(ModToolMaterials.ENDORIUM, 5, -2.4f, new Item.Properties().tab(EndReborn.ENDOMPAT));
    public static final Item RIZIKI_ENDORIUM_PAXEL = new UpgradablePaxelItem(ModToolMaterials.ENDORIUM, 6, -2.4f, 1, 0, new Item.Properties().tab(null));
    public static final Item HVILA_ENDORIUM_PAXEL = new UpgradablePaxelItem(ModToolMaterials.ENDORIUM_FLEXIBILITY, 6, -2.4f, 0, 1, new Item.Properties().tab(null));

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerItems(RegistryEvent.Register<Item> event) {
        if (ImmersiveEngineering.isInstalled()) {
            registerItem(ENDORIUM_PLATE, "endorium_plate");
            registerItem(ENDORIUM_ROD, "endorium_rod");
            registerItem(TUNGSTEN_PLATE, "tungsten_plate");
            registerItem(TUNGSTEN_ROD, "tungsten_rod");

        }
        if (ImmersiveEngineering.isInstalled() || ModList.get().getModContainerById("mekanism").isPresent()) {
            registerItem(TUNGSTEN_DUST, "tungsten_dust");
            registerItem(ENDORIUM_DUST, "endorium_dust");
        }
        if (ModList.get().getModContainerById("mekanism").isPresent()) {
            registerItem(TUNGSTEN_CRYSTAL, "tungsten_crystal");
            registerItem(TUNGSTEN_DIRTY, "tungsten_dirty_dust");
            registerItem(TUNGSTEN_SHARD, "tungsten_shard");
            registerItem(TUNGSTEN_CLUMP, "tungsten_clump");
            registerItem(ENDORIUM_PAXEL, "endorium_paxel");
            registerItem(TUNGSTEN_PAXEL, "tungsten_paxel");
            registerItem(RIZIKI_ENDORIUM_PAXEL, "riziki_endorium_paxel");
            registerItem(HVILA_ENDORIUM_PAXEL, "hvila_endorium_paxel");
        }
    }
    private static void registerItem(Item item, String name) {
        item.setRegistryName(new ResourceLocation(EndReborn.MODID, name));
        ForgeRegistries.ITEMS.register(item);
    }
}
