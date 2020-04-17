package net.electron.endreborn.world;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class FeatureGen {

	public static final Feature<OreFeatureConfig> OBSIDIAN_ORE = Registry.register(
			Registry.FEATURE,
			new Identifier("endreborn", "obsidian_ore"),
			new ObsidianOreFeature(OreFeatureConfig::deserialize)
		);
	public static final Feature<OreFeatureConfig> END_NATURE = Registry.register(
			Registry.FEATURE,
			new Identifier("endreborn", "end_moss"),
			new EndMossFeature(OreFeatureConfig::deserialize)
		);
	public static final Feature<OreFeatureConfig> END_PLANT = Registry.register(
			Registry.FEATURE,
			new Identifier("endreborn", "end_plant"),
			new EndPlantFeature(OreFeatureConfig::deserialize)
		);
	public static final Feature<OreFeatureConfig> PLANT = Registry.register(
			Registry.FEATURE,
			new Identifier("endreborn", "plant"),
			new PlantFeature(OreFeatureConfig::deserialize)
		);
}