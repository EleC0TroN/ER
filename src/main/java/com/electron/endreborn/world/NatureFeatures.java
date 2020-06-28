package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;

public class NatureFeatures {

	public static final BlockClusterFeatureConfig DRAGONITE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.DRAGONITE.get().getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
	public static final BlockClusterFeatureConfig OGANA_WEED_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.OGANA_WEED.get().getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
	public static final BlockClusterFeatureConfig END_CORAL_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.END_CORAL.get().getDefaultState()), new SimpleBlockPlacer())).tries(4).build();


}
