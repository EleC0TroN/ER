package net.electron.endreborn.world;

import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class FeatureGen {

	public static void initGen() {
		Biomes.FOREST.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.DRAGONITE_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
		Biomes.DARK_FOREST.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.DRAGONITE_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));

		Biomes.THE_END.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.WEED_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
		Biomes.END_MIDLANDS.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.WEED_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
		Biomes.END_HIGHLANDS.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.WEED_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
		Biomes.THE_END.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.PLANT_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
		Biomes.END_MIDLANDS.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.PLANT_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));
		Biomes.END_HIGHLANDS.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.PLANT_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))));

		Biomes.THE_END.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.END_CORAL_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));
		Biomes.END_MIDLANDS.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.END_CORAL_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));
		Biomes.SMALL_END_ISLANDS.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(NatureFeatures.END_CORAL_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));

		Biomes.END_MIDLANDS.addFeature(GenerationStep.Feature.RAW_GENERATION, NatureFeatures.MOSS.configure(new DefaultFeatureConfig()).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
		Biomes.THE_END.addFeature(GenerationStep.Feature.RAW_GENERATION, NatureFeatures.MOSS.configure(new DefaultFeatureConfig()).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
		Biomes.END_BARRENS.addFeature(GenerationStep.Feature.RAW_GENERATION, NatureFeatures.MOSS.configure(new DefaultFeatureConfig()).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
		Biomes.SMALL_END_ISLANDS.addFeature(GenerationStep.Feature.RAW_GENERATION, NatureFeatures.MOSS.configure(new DefaultFeatureConfig()).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));

		Biomes.THE_END.addFeature(GenerationStep.Feature.RAW_GENERATION, NatureFeatures.OBSIDIAN_ORE.configure(new DefaultFeatureConfig()).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(4))));
		Biomes.END_MIDLANDS.addFeature(GenerationStep.Feature.RAW_GENERATION, NatureFeatures.END_DECO.configure(new DefaultFeatureConfig()).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));

		Biomes.END_MIDLANDS.addFeature(GenerationStep.Feature.RAW_GENERATION, NatureFeatures.ENDSHROOM.configure(new DefaultFeatureConfig()).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(3))));

	}
	public static void initOres() {
		Biomes.DESERT.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, ModBlocks.WOLF_ORE.getDefaultState(), 4)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(17, 0, 0, 64))));
		Biomes.DESERT_HILLS.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, ModBlocks.WOLF_ORE.getDefaultState(), 4)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(17, 0, 0, 64))));
		Biomes.FLOWER_FOREST.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, ModBlocks.QUARTZ_ORE.getDefaultState(), 2)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(12, 0, 0, 64))));
		Biomes.FOREST.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, ModBlocks.QUARTZ_ORE.getDefaultState(), 2)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(12, 0, 0, 64))));
		Biomes.MOUNTAINS.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, ModBlocks.QUARTZ_ORE.getDefaultState(), 2)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(12, 0, 0, 128))));

	}
}