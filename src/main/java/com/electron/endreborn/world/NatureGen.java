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

	public static void initGen() {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (biome == Biomes.FOREST || biome == Biomes.DARK_FOREST) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.DRAGONITE.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get())));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.DRAGONITE.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get())));
			}
			if (biome.getCategory().equals(Biome.Category.THEEND)) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_PLANT.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ModBlocks.OGANA_WEED.get().getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(12)));

				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.END_MOSS, new NoFeatureConfig(), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get())));
			}
			Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.CRACKED_PURPUR, new NoFeatureConfig(), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(ModConfigs.COMMON.balance.decorator_rarity.get())));
			Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(NatureFeatures.OBSIDIAN_ORE, new NoFeatureConfig(), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get())));
		}
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
		}
	}
}