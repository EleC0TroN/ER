package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.ModConfigs;
import net.minecraft.world.biome.BeachBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.ForestFlowerBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.ShipwreckConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;

public class NatureGen {
	private static final ObsidianOreFeature OBSIDIAN_ORE = new ObsidianOreFeature(null);

	public static void initGen() {

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (biome == Biomes.FOREST || biome == Biomes.DARK_FOREST) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.DRAGONITE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get()))));
			}

			if (biome.getCategory().equals(Biome.Category.THEEND)) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));

				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new ObsidianOreFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get()))));

				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_PLANT_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(12))));

			}
		}
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new CrackedDecoratorFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.decorator_rarity.get()))));
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndMushroomFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.endshrooms_rarity.get()))));

		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
		Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
		Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));

		if(ModConfigs.COMMON.balance.new_structures_end.get()) {
			Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			Biomes.END_MIDLANDS.addStructure(NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			Biomes.END_HIGHLANDS.addStructure(NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		}
	}
	public static void initOres() {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(ModConfigs.COMMON.balance.quartz_rarity.get(), 0, 0, 64));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.QUARTZ_ORE.get().getDefaultState(), 3))
						.withPlacement(customConfig));
			}
			if (!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(ModConfigs.COMMON.balance.wolframium_rarity.get(), 0, 0, 64));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.WOLFRAMIUM_ORE.get().getDefaultState(), 4))
						.withPlacement(customConfig));
			}
		}
	}

}
