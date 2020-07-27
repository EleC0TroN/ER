package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.google.common.collect.ImmutableSet;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BeachBiome;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.IglooStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Locale;

public class NatureStructures {
    public static Structure<NoFeatureConfig> END_SHIPWRECK = new EndShipwreckStructure(NoFeatureConfig.field_236558_a_);
    public static Structure<NoFeatureConfig> END_CRYPT = new EndCryptStructure(NoFeatureConfig.field_236558_a_);

    public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> END_CRYPT_FEATURE = NatureStructures.END_CRYPT.func_236391_a_(NoFeatureConfig.field_236559_b_);
    public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> END_SHIPWRECK_FEATURE = NatureStructures.END_SHIPWRECK.func_236391_a_(NoFeatureConfig.field_236559_b_);


    public static void registerStructures(IForgeRegistry<Structure<?>> registry) {
        registry.register(END_SHIPWRECK.setRegistryName(EndReborn.MODID, "end_shipwreck"));
        Structure.field_236365_a_.put(EndReborn.MODID + ":" + "end_shipwreck", END_SHIPWRECK);
        ImmutableSet.of(DimensionSettings.Preset.field_236122_b_, DimensionSettings.Preset.field_236123_c_, DimensionSettings.Preset.field_236124_d_,
                DimensionSettings.Preset.field_236125_e_, DimensionSettings.Preset.field_236126_f_, DimensionSettings.Preset.field_236127_g_)
                .forEach(p -> p.func_236137_b_().func_236108_a_().func_236195_a_().put(END_SHIPWRECK, new StructureSeparationSettings(32, 10, 16729632)));
        registry.register(END_CRYPT.setRegistryName(EndReborn.MODID, "end_crypt"));
        Structure.field_236365_a_.put(EndReborn.MODID + ":" + "end_crypt", END_CRYPT);
        ImmutableSet.of(DimensionSettings.Preset.field_236122_b_, DimensionSettings.Preset.field_236123_c_, DimensionSettings.Preset.field_236124_d_,
                DimensionSettings.Preset.field_236125_e_, DimensionSettings.Preset.field_236126_f_, DimensionSettings.Preset.field_236127_g_)
                .forEach(p -> p.func_236137_b_().func_236108_a_().func_236195_a_().put(END_CRYPT, new StructureSeparationSettings(36, 10, 11733342)));

    }
}