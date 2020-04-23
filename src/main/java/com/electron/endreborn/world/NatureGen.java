package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.ModConfigs;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class NatureGen {
	private static final ObsidianOreFeature OBSIDIAN_ORE = new ObsidianOreFeature(null);
	public static final Feature<BushConfig> END_MOSS = new EndMossFeature(BushConfig::deserialize);

	public static void initGen() {
		addFeature(Biomes.DARK_FOREST, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.DRAGONITE.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get())));
		addFeature(Biomes.FOREST, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.DRAGONITE.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get())));
		
		addFeature(Biomes.THE_END, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new BushConfig(null), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get())));
		addFeature(Biomes.END_MIDLANDS, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new BushConfig(null), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get())));
		addFeature(Biomes.SMALL_END_ISLANDS, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new BushConfig(null), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get())));
		addFeature(Biomes.END_HIGHLANDS, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new BushConfig(null), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get())));

		addFeature(Biomes.END_HIGHLANDS, GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.CRACKED_PURPUR, new BushConfig(null), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(4)));

		addFeature(Biomes.THE_END, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_PLANT.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
		addFeature(Biomes.END_MIDLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_PLANT.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
		addFeature(Biomes.SMALL_END_ISLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_PLANT.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
		addFeature(Biomes.THE_END, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_WEED.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
		addFeature(Biomes.END_MIDLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_WEED.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
		addFeature(Biomes.SMALL_END_ISLANDS, GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_WEED.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
	}
	public static void initOres() {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ModBlocks.QUARTZ_ORE.get().getDefaultState(),
										2
								),
								Placement.COUNT_RANGE, new CountRangeConfig(ModConfigs.COMMON.balance.quartz_rarity.get(), 0, 0, 64)
						)
				);

			}
			if (!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(Feature.ORE,
								new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										ModBlocks.WOLFRAMIUM_ORE.get().getDefaultState(),
										4
								),
								Placement.COUNT_RANGE, new CountRangeConfig(ModConfigs.COMMON.balance.wolframium_rarity.get(), 0, 0, 64)
						)
				);
			}
			Biomes.THE_END.addFeature(
					GenerationStage.Decoration.VEGETAL_DECORATION,
					Biome.createDecoratedFeature(OBSIDIAN_ORE,
							new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									ModBlocks.OBSIDIAN_ORE.get().getDefaultState(), 4),
							Placement.COUNT_RANGE, new CountRangeConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get(), 50, 100, 200)));
		}
	}
	public static void addFeature(Biome biome, GenerationStage.Decoration decorationStage, ConfiguredFeature<?> featureIn) {
		biome.addFeature(decorationStage, featureIn);
	}
}
