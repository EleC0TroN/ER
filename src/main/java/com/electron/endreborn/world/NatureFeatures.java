package com.electron.endreborn.world;

import net.minecraft.world.gen.feature.*;

public class NatureFeatures {
	public static final Feature<NoFeatureConfig> END_MOSS = new EndDecoratorFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> CRACKED_PURPUR = new CrackedDecoratorFeature(NoFeatureConfig::deserialize);
	public static final Feature<NoFeatureConfig> OBSIDIAN_ORE = new ObsidianOreFeature(NoFeatureConfig::deserialize);

}
