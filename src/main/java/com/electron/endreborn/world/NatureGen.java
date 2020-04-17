package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class NatureGen {
	public static void init() {
		addFeature(Biomes.DARK_FOREST, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.DRAGONITE.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(1)));
		addFeature(Biomes.FOREST, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.DRAGONITE.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(1)));
		
		addFeature(Biomes.THE_END, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new BushConfig(ModBlocks.END_MOSS.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		addFeature(Biomes.END_MIDLANDS, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new BushConfig(ModBlocks.END_MOSS.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		addFeature(Biomes.SMALL_END_ISLANDS, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new BushConfig(ModBlocks.END_MOSS.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));

		addFeature(Biomes.THE_END, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_PLANT.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		addFeature(Biomes.END_MIDLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_PLANT.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		addFeature(Biomes.SMALL_END_ISLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_PLANT.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		addFeature(Biomes.THE_END, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_WEED.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		addFeature(Biomes.END_MIDLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_WEED.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		addFeature(Biomes.SMALL_END_ISLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_WEED.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
	}
	public static void addFeature(Biome biome, GenerationStage.Decoration decorationStage, ConfiguredFeature<?> featureIn) {
	    biome.addFeature(decorationStage, featureIn);
	}
}