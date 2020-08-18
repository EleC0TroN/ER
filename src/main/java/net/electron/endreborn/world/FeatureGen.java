package net.electron.endreborn.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltInBiomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FeatureGen {
	public static void initGen(MutableRegistry<Biome> biomes) {

		for(Biome biome : BuiltinRegistries.BIOME) {
			if (biome.getCategory() == Biome.Category.FOREST) {
				addFeature(biome, new Identifier("dragonite"), GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.DRAGONITE_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(2));
			}
			if (biome.getCategory() == Biome.Category.EXTREME_HILLS) {
				addFeature(biome, new Identifier("tungsten"), GenerationStep.Feature.UNDERGROUND_ORES, NatureFeatures.TUNGSTEN.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(2));
			}
			if (biome == biomes.get(BuiltInBiomes.SMALL_END_ISLANDS)) {
				addFeature(biome, new Identifier("xorcite"), GenerationStep.Feature.RAW_GENERATION, NatureFeatures.XORCITE.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(2));
			}
			if (biome == biomes.get(BuiltInBiomes.END_MIDLANDS)) {
				addFeature(biome, new Identifier("end_coral"), GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.END_CORAL_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(15));
				addFeature(biome, new Identifier("end_deco"), GenerationStep.Feature.RAW_GENERATION, NatureFeatures.END_DECO.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(4));
				addFeature(biome, new Identifier("end_tungsten"), GenerationStep.Feature.UNDERGROUND_ORES, NatureFeatures.END_TUNGSTEN.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(2));
				biome.getGenerationSettings().getStructureFeatures().add(() -> NatureStructures.END_SHIPWRECK.configure(FeatureConfig.DEFAULT));
			}
			if (biome == biomes.get(BuiltInBiomes.END_HIGHLANDS)) {
				biome.getGenerationSettings().getStructureFeatures().add(() -> NatureStructures.END_CRYPT.configure(FeatureConfig.DEFAULT));
			}
			if (biome.getCategory() == Biome.Category.THEEND && biome != biomes.get(BuiltInBiomes.SMALL_END_ISLANDS)) {
				addFeature(biome, new Identifier("obsidian_ore"), GenerationStep.Feature.RAW_GENERATION, NatureFeatures.OBSIDIAN_ORE.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(5));
				addFeature(biome, new Identifier("ogana"), GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.WEED_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(2));
				addFeature(biome, new Identifier("end_moss"), GenerationStep.Feature.RAW_GENERATION, NatureFeatures.MOSS.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).repeat(4));
			}
		}
	}
	public static void initOres() {

	}
	private static void addFeature(Biome biome, Identifier identifier, GenerationStep.Feature feature, ConfiguredFeature<?, ?> configuredFeature) {
		List<List<Supplier<ConfiguredFeature<?, ?>>>> features = biome.getGenerationSettings().getFeatures();

		int stepIndex = feature.ordinal();

		while (features.size() <= stepIndex) {
			features.add(Lists.newArrayList());
		}

		List<Supplier<ConfiguredFeature<?, ?>>> stepList = features.get(feature.ordinal());
		if (stepList instanceof ImmutableList) {
			features.set(feature.ordinal(), stepList = new ArrayList<>(stepList));
		}

		if (!BuiltinRegistries.CONFIGURED_FEATURE.getKey(configuredFeature).isPresent()) {
			if (BuiltinRegistries.CONFIGURED_FEATURE.getOrEmpty(identifier).isPresent()) {
				throw new RuntimeException("Duplicate feature: " + identifier.toString());
			}

			BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, identifier, configuredFeature);
		}

		stepList.add(() -> configuredFeature);
	}

}