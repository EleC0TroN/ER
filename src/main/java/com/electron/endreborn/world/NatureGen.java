package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModConfigs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class NatureGen {

    @SubscribeEvent
    public static void registerAll(RegistryEvent.Register<Feature<?>> event) {
        if (!event.getName().equals(ForgeRegistries.FEATURES.getRegistryName()))
            return;
        registerGen(NatureFeatures.OBSIDIAN_ORE_CONFIG, "obsidian_ore");
        registerGen(NatureFeatures.END_DECORATOR_CONFIG, "end_decorator");
        registerGen(NatureFeatures.XORCITE_CONFIG, "xorcite");
        registerGen(NatureFeatures.TUNGSTEN_CONFIG, "tungsten");
        registerGen(NatureFeatures.TUNGSTEN_END_CONFIG, "tungsten_end");
    }

    public static Feature<?> registerGen(Feature<?> feature, String name) {
        feature.setRegistryName(new ResourceLocation(EndReborn.MODID, name));
        ForgeRegistries.FEATURES.register(feature);
        return feature;
    }

    public static void addStructures(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.THEEND) {
            if (ModConfigs.COMMON.balance.end_shipwreck.get()) {
                event.getGeneration().getStructures().add(NatureFeatures.CONFIGURED_END_SHIPWRECK);
            }
            if (ModConfigs.COMMON.balance.end_crypt.get()) {
                event.getGeneration().getStructures().add(NatureFeatures.CONFIGURED_END_CRYPT);
            }
        }
    }

    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory() == Biome.Category.THEEND) {
            addSecondFeature(generation, NatureFeatures.OBSIDIAN_ORE_FEATURE);
            addSecondFeature(generation, NatureFeatures.END_DECORATOR_FEATURE);
            if (ModConfigs.COMMON.balance.end_coral.get()) {
                addSecondFeature(generation, NatureFeatures.CITY_DECORATOR_FEATURE);
            }
            if (ModConfigs.COMMON.balance.end_coral.get()) {
                addSecondFeature(generation, NatureFeatures.END_CORAL_FEATURE);
            }
            addSecondFeature(generation, NatureFeatures.XORCITE_FEATURE);
            addSecondFeature(generation, NatureFeatures.OGANA_FEATURE);
            addFirstFeature(generation, NatureFeatures.TUNGSTEN_END_FEATURE);
        }
        if (event.getCategory() == Biome.Category.FOREST) {
            addSecondFeature(generation, NatureFeatures.DRAGONITE_FEATURE);
        }
        if (event.getCategory() == Biome.Category.EXTREME_HILLS) {
            addFirstFeature(generation, NatureFeatures.TUNGSTEN_FEATURE);
        }
    }

    private static void addFirstFeature(BiomeGenerationSettingsBuilder generation, @Nullable ConfiguredFeature<?, ?> feature) {
        if (feature != null) {
            generation.addFeature(GenerationStage.Decoration.RAW_GENERATION, feature);
        }
    }
    private static void addSecondFeature(BiomeGenerationSettingsBuilder generation, @Nullable ConfiguredFeature<?, ?> feature) {
        if (feature != null) {
            generation.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, feature);
        }
    }
}
