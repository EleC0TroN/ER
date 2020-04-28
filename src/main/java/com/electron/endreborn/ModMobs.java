package com.electron.endreborn;

import com.electron.endreborn.mobs.LimusMob;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMobs {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            EndReborn.MODID);

    public static final RegistryObject<EntityType<LimusMob>> LIMUS = ENTITY_TYPES
            .register("limus",
                    () -> EntityType.Builder.<LimusMob>create(LimusMob::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(EndReborn.MODID, "limus").toString()));
    public static void registerEntityWorldSpawns() {
        Biomes.END_MIDLANDS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModMobs.LIMUS.get(), ModConfigs.COMMON.balance.limus_rarity.get(), 1, 5));
        Biomes.END_HIGHLANDS.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ModMobs.LIMUS.get(), ModConfigs.COMMON.balance.limus_rarity.get(), 1, 5));

    }

}