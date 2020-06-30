package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.ModConfigs;
import com.electron.endreborn.compatibility.EndergeticExpansiom;
import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class NatureGen {

	public static void initGen() {
		ForgeRegistries.BIOMES.getValues().stream().forEach((biome -> {
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.HILLS)) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new TungstenOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_rarity.get()))));
			}
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.DRAGONITE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get()))));
			}
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.END)) {
				Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new ObsidianOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get()))));
				Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new CrackedDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.decorator_rarity.get()))));
				Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.RAW_GENERATION, new XorciteClusterFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.xorcite_cluster_rarity.get()))));
				Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.RAW_GENERATION, new XorciteClusterFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.xorcite_cluster_rarity.get()))));
				Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new TungstenOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_rarity.get()))));
				Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new TungstenOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_rarity.get()))));
				Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
				Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
				Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));

			}
		}));
	}
	public static void initOres() {
		ForgeRegistries.BIOMES.getValues().stream().forEach((biome -> {
			if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER) && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.END)) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.QUARTZ_ORE.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(ModConfigs.COMMON.balance.quartz_rarity.get(), 0, 0, 64))));
			}
		}));
	}
}
