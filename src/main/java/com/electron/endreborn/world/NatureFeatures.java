package com.electron.endreborn.world;

import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;

public class NatureFeatures {
	public static final Feature<BushConfig> END_MOSS = new EndMossFeature(BushConfig::deserialize);
	public static final Feature<BushConfig> CRACKED_PURPUR = new CrackedPurpurFeature(BushConfig::deserialize);
}
