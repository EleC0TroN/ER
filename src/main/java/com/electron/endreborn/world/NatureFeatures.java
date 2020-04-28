package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;

public class NatureFeatures {
	public static final BlockClusterFeatureConfig DRAGONITE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.DRAGONITE.get().getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
	public static final BlockClusterFeatureConfig OGANA_WEED_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.OGANA_WEED.get().getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
	public static final BlockClusterFeatureConfig OGANA_PLANT_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.OGANA_PLANT.get().getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
}
