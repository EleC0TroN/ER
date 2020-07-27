package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.ModConfigs;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class NatureGen {
	public static void initGen() {
		Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new ObsidianOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get()))));
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new CrackedDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.decorator_rarity.get()))));

		Biomes.END_MIDLANDS.func_235063_a_(NatureStructures.END_SHIPWRECK_FEATURE);
		Biomes.END_HIGHLANDS.func_235063_a_(NatureStructures.END_SHIPWRECK_FEATURE);
		Biomes.END_HIGHLANDS.func_235063_a_(NatureStructures.END_CRYPT_FEATURE);

		Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.RAW_GENERATION, new XorciteClusterFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.xorcite_clusters_rarity.get()))));
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.RAW_GENERATION, new XorciteClusterFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.xorcite_clusters_rarity.get()))));

		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new TungstenOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_ore_rarity.get()))));
		Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new TungstenOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_ore_rarity.get()))));

		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(12))));
		Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
		Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));

		Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));
		Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));
		Biomes.END_BARRENS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));

		Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
		Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));

		Biomes.GRAVELLY_MOUNTAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new TungstenOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_ore_rarity.get()))));
		Biomes.MOUNTAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new TungstenOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_ore_rarity.get()))));

		Biomes.FOREST.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.DRAGONITE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get()))));

		Biomes.PLAINS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.QUARTZ_ORE.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(ModConfigs.COMMON.balance.quartz_rarity.get(), 0, 0, 64))));
		Biomes.DESERT.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.QUARTZ_ORE.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(ModConfigs.COMMON.balance.quartz_rarity.get(), 0, 0, 64))));
		Biomes.FOREST.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.QUARTZ_ORE.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(ModConfigs.COMMON.balance.quartz_rarity.get(), 0, 0, 64))));
		Biomes.MOUNTAINS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.QUARTZ_ORE.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(ModConfigs.COMMON.balance.quartz_rarity.get(), 0, 0, 64))));
	}
}
