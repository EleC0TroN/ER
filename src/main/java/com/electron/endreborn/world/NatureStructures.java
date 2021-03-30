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

    public static final RegistryObject<Structure<NoFeatureConfig>> END_SHIPWRECK = STRUCTURE_FEATURES.register("end_shipwreck", () -> new EndShipwreckStructure(NoFeatureConfig.field_236558_a_));
    public static final RegistryObject<Structure<NoFeatureConfig>> END_CRYPT = STRUCTURE_FEATURES.register("end_crypt", () -> new EndCryptStructure(NoFeatureConfig.field_236558_a_));

    public static void setupStructures() {
        setupStructure(END_SHIPWRECK.get(), new StructureSeparationSettings(18, 1, 12620210), false);
        setupStructure(END_CRYPT.get(), new StructureSeparationSettings(20, 1, 10210262), false);
    }

    public static <F extends Structure<?>> void setupStructure(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);
        if (transformSurroundingLand) {
            Structure.field_236384_t_ = ImmutableList.<Structure<?>>builder().addAll(Structure.field_236384_t_).add(structure).build();
        }
        DimensionStructuresSettings.field_236191_b_ = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                .putAll(DimensionStructuresSettings.field_236191_b_)
                .put(structure, structureSeparationSettings)
                .build();
    }

    public static void register(IEventBus modBus) {
        STRUCTURE_FEATURES.register(modBus);
    }

    public static void addDimensionSpacing(WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();
            if (!(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator) && serverWorld.getDimensionKey().equals(World.THE_END)) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
                tempMap.put(END_SHIPWRECK.get(), DimensionStructuresSettings.field_236191_b_.get(END_SHIPWRECK.get()));
                tempMap.put(END_CRYPT.get(), DimensionStructuresSettings.field_236191_b_.get(END_CRYPT.get()));
                serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
            }
        }
    }
}