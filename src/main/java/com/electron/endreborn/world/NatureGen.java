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
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.DRAGONITE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get()))));
			}
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.END)) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));

				Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new ObsidianOreFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get()))));

				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));

				Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new CrackedDecoratorFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.decorator_rarity.get()))));

				Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.RAW_GENERATION, new XorciteClusterFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.xorcite_spikes_rarity.get()))));
				Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.RAW_GENERATION, new XorciteClusterFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.xorcite_spikes_rarity.get()))));

				Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
				Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
				Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
				boolean o = false;
				if(ModConfigs.COMMON.balance.new_structures_end.get() && o) {
					Biomes.END_MIDLANDS.func_235063_a_(NatureStructures.END_SHIPWRECK_FEATURE);
					Biomes.END_HIGHLANDS.func_235063_a_(NatureStructures.END_SHIPWRECK_FEATURE);

					if (EndergeticExpansiom.isInstalled()) {
						EndergeticExpansiom.POISE_BIOME.func_235063_a_(NatureStructures.END_CRYPT_FEATURE);
					}
				}
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
