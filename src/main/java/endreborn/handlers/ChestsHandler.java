package endreborn.handlers;

import com.google.common.collect.ImmutableList;
import endreborn.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ChestsHandler {
    private static final List<String> CHEST_TABLES = ImmutableList.of("abandoned_mineshaft", "desert_pyramid", "end_city_treasure", "jungle_temple", "nether_bridge", "village_blacksmith");

    public static void init() {
        if(ConfigsHandler.GENERAL.chestLoot) {
            for(String s : CHEST_TABLES) {
                LootTableList.register(new ResourceLocation(Reference.MODID, "inject/chests/" + s));
            }
        }
    }

    @SubscribeEvent
    public static void lootLoad(LootTableLoadEvent evt) {
        String chests_prefix = "minecraft:chests/";
        String name = evt.getName().toString();

        if((ConfigsHandler.GENERAL.chestLoot && name.startsWith(chests_prefix) && CHEST_TABLES.contains(name.substring(chests_prefix.length())))) {
            String file = name.substring("minecraft:".length());
            evt.getTable().addPool(getInjectPool(file));
        }
    }

    private static LootPool getInjectPool(String entryName) {
        return new LootPool(new LootEntry[] {getInjectEntry(entryName)}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0, 1), "endreborn_inject_pool");
    }

    private static LootEntryTable getInjectEntry(String name) {
        return new LootEntryTable(new ResourceLocation(Reference.MODID, "inject/" + name), 1, 0, new LootCondition[0], "endreborn_inject_entry");
    }
}