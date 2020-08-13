package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.ModConfigs;
import com.electron.endreborn.compatibility.EndergeticExpansiom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class NatureGen {
	private static final ObsidianOreFeature OBSIDIAN_ORE = new ObsidianOreFeature(null);

	public static void initGen() {

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			if (biome == Biomes.FOREST || biome == Biomes.DARK_FOREST) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.DRAGONITE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.dragonite_rarity.get()))));
			}
			if (biome == Biomes.MOUNTAINS || biome == Biomes.GRAVELLY_MOUNTAINS || biome == Biomes.MOUNTAIN_EDGE || biome == Biomes.MODIFIED_BADLANDS_PLATEAU) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new TungstenOreFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_ore_rarity.get()))));
			}
			if (biome.getCategory().equals(Biome.Category.THEEND)) {
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndDecoratorFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.moss_rarity.get()))));

				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new ObsidianOreFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get()))));

				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.OGANA_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));

			}
		}
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new CrackedDecoratorFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.decorator_rarity.get()))));
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, new EndMushroomFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.endshrooms_rarity.get()))));

		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new TungstenOreFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_ore_rarity.get()))));
		Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new TungstenOreFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(ModConfigs.COMMON.balance.tungsten_ore_rarity.get()))));

		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
		Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
		Biomes.THE_END.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(NatureFeatures.END_CORAL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));

		if(ModConfigs.COMMON.balance.new_structures_end.get()) {
			Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			Biomes.END_MIDLANDS.addStructure(NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			Biomes.END_HIGHLANDS.addStructure(NatureStructures.END_SHIPWRECK.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

			Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, NatureStructures.END_CRYPT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, NatureStructures.END_CRYPT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			Biomes.END_MIDLANDS.addStructure(NatureStructures.END_CRYPT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			Biomes.END_HIGHLANDS.addStructure(NatureStructures.END_CRYPT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			if (EndergeticExpansiom.isInstalled()) {
				EndergeticExpansiom.POISE_BIOME.addStructure(NatureStructures.END_CRYPT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
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
