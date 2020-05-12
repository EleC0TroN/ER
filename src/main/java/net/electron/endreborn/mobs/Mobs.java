package net.electron.endreborn.mobs;


import net.fabricmc.fabric.api.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.List;


public class Mobs {

        public static EntityType<LimusMob> LIMUS = Registry.register(Registry.ENTITY_TYPE, new Identifier("endreborn", "limus"), FabricEntityTypeBuilder.<LimusMob>create(SpawnGroup.AMBIENT, LimusMob::new).setImmuneToFire().build());
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(Mobs.LIMUS, LimusMob.createLimusAttributes());
    }
    public static void registerEntitySpawn() {
        for (Biome biome : Registry.BIOME) {
            List<Biome.SpawnEntry> spawnList = biome.getEntitySpawnList(SpawnGroup.CREATURE);
            if (biome.equals(Biomes.END_MIDLANDS)) {
                spawnList.add(new Biome.SpawnEntry(Mobs.LIMUS, 6, 0, 4));
            }
            if (biome.equals(Biomes.END_HIGHLANDS)) {
                spawnList.add(new Biome.SpawnEntry(Mobs.LIMUS, 6, 0, 4));
            }
        }
    }
}