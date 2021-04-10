package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class NatureStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, EndReborn.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> END_SHIPWRECK = STRUCTURE_FEATURES.register("end_shipwreck", () -> new EndShipwreckStructure(NoFeatureConfig.CODEC));
    public static final RegistryObject<Structure<NoFeatureConfig>> END_CRYPT = STRUCTURE_FEATURES.register("end_crypt", () -> new EndCryptStructure(NoFeatureConfig.CODEC));

    public static void setupStructures() {
        setupStructure(END_SHIPWRECK.get(), new StructureSeparationSettings(22, 1, 22620210), false);
        setupStructure(END_CRYPT.get(), new StructureSeparationSettings(24, 1, 10210262), false);
    }

    public static <F extends Structure<?>> void setupStructure(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder().addAll(Structure.NOISE_AFFECTING_FEATURES).add(structure).build();
        }
        DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                .putAll(DimensionStructuresSettings.DEFAULTS)
                .put(structure, structureSeparationSettings)
                .build();
    }

    public static void register(IEventBus modBus) {
        STRUCTURE_FEATURES.register(modBus);
    }

    public static void addDimensionSpacing(WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();
            if (!(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator) && serverWorld.dimension().equals(World.END)) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
                tempMap.put(END_SHIPWRECK.get(), DimensionStructuresSettings.DEFAULTS.get(END_SHIPWRECK.get()));
                tempMap.put(END_CRYPT.get(), DimensionStructuresSettings.DEFAULTS.get(END_CRYPT.get()));
                serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
            }
        }
    }
}