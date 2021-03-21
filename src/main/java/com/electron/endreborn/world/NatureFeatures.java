package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NatureFeatures {
	protected static final BlockState END_STONE = Blocks.END_STONE.getDefaultState();
	protected static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
	protected static final BlockState END_CORAL = ModBlocks.END_CORAL.get().getDefaultState();
	protected static final BlockState DRAGONITE = ModBlocks.DRAGONITE.get().getDefaultState();
	protected static final BlockState END_MOSS = ModBlocks.END_MOSS.get().getDefaultState();
	protected static final BlockState OGANA = ModBlocks.OGANA_WEED.get().getDefaultState();
	protected static final BlockState AIR = Blocks.AIR.getDefaultState();

	public static final Feature<NoFeatureConfig> OBSIDIAN_ORE_CONFIG = new ObsidianOreFeature(NoFeatureConfig.field_236558_a_);
	public static final Feature<NoFeatureConfig> END_DECORATOR_CONFIG = new EndDecoratorFeature(NoFeatureConfig.field_236558_a_);
	public static final Feature<NoFeatureConfig> XORCITE_ORE_CONFIG = new XorciteClusterFeature(NoFeatureConfig.field_236558_a_);
	public static final Feature<NoFeatureConfig> TUNGSTEN_CONFIG = new TungstenOreFeature(NoFeatureConfig.field_236558_a_);
	public static final Feature<NoFeatureConfig> TUNGSTEN_END_CONFIG = new TungstenEndFeature(NoFeatureConfig.field_236558_a_);

	public static final ConfiguredFeature<?, ?> END_CORAL_FEATURE = Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(NatureFeatures.END_CORAL, ImmutableList.of(NatureFeatures.END_STONE), ImmutableList.of(NatureFeatures.AIR), ImmutableList.of(NatureFeatures.AIR)))
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).square().func_242731_b(12).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(65, 40.0D, 0.3D)));
	public static final ConfiguredFeature<?, ?> DRAGONITE_FEATURE = Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(NatureFeatures.DRAGONITE, ImmutableList.of(NatureFeatures.GRASS_BLOCK), ImmutableList.of(NatureFeatures.AIR), ImmutableList.of(NatureFeatures.AIR)))
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).square().func_242731_b(3).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(40, 20.0D, 0.2D)));
	public static ConfiguredFeature<?, ?> OGANA_FEATURE = Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(NatureFeatures.OGANA, ImmutableList.of(NatureFeatures.END_MOSS), ImmutableList.of(NatureFeatures.AIR), ImmutableList.of(NatureFeatures.AIR)))
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).square().func_242731_b(5).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(40, 20.0D, 0.2D)));
	public static ConfiguredFeature<?, ?> OBSIDIAN_ORE_FEATURE = NatureFeatures.OBSIDIAN_ORE_CONFIG.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).func_242731_b(15);
	public static ConfiguredFeature<?, ?> END_DECORATOR_FEATURE = NatureFeatures.END_DECORATOR_CONFIG.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).func_242731_b(9);
	public static ConfiguredFeature<?, ?> XORCITE_FEATURE = NatureFeatures.XORCITE_ORE_CONFIG.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).func_242731_b(2);
	public static ConfiguredFeature<?, ?> TUNGSTEN_FEATURE = NatureFeatures.TUNGSTEN_CONFIG.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).func_242731_b(5);
	public static ConfiguredFeature<?, ?> TUNGSTEN_END_FEATURE = NatureFeatures.TUNGSTEN_END_CONFIG.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
			.withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).func_242731_b(5);

}
