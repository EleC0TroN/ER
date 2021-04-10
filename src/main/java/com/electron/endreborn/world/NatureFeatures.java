package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.ModConfigs;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;

import java.util.function.Supplier;

public class NatureFeatures {
	protected static final BlockState END_STONE = Blocks.END_STONE.defaultBlockState();
	protected static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.defaultBlockState();
	protected static final BlockState END_CORAL = ModBlocks.END_CORAL.get().defaultBlockState();
	protected static final BlockState DRAGONITE = ModBlocks.DRAGONITE.get().defaultBlockState();
	protected static final BlockState END_MOSS = ModBlocks.END_MOSS.get().defaultBlockState();
	protected static final BlockState OGANA = ModBlocks.OGANA_WEED.get().defaultBlockState();
	protected static final BlockState XORCITE = ModBlocks.XORCITE.get().defaultBlockState();
	protected static final BlockState AIR = Blocks.AIR.defaultBlockState();

	public static final Supplier<StructureFeature<?, ?>> CONFIGURED_END_SHIPWRECK = () -> NatureStructures.END_SHIPWRECK.get().configured(IFeatureConfig.NONE);
	public static final Supplier<StructureFeature<?, ?>> CONFIGURED_END_CRYPT = () -> NatureStructures.END_CRYPT.get().configured(IFeatureConfig.NONE);

	public static void registerConfiguredFeatures() {
		final Registry<StructureFeature<?, ?>> structureRegistry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(structureRegistry, new ResourceLocation(EndReborn.MODID, "end_shipwreck"), CONFIGURED_END_SHIPWRECK.get());
		Registry.register(structureRegistry, new ResourceLocation(EndReborn.MODID, "end_crypt"), CONFIGURED_END_CRYPT.get());
	}

	public static final Feature<NoFeatureConfig> OBSIDIAN_ORE_CONFIG = new ObsidianOreFeature(NoFeatureConfig.CODEC);
	public static final Feature<NoFeatureConfig> END_DECORATOR_CONFIG = new EndDecoratorFeature(NoFeatureConfig.CODEC);
	public static final Feature<NoFeatureConfig> CITY_DECORATOR_CONFIG = new CrackedDecoratorFeature(NoFeatureConfig.CODEC);
	public static final Feature<NoFeatureConfig> XORCITE_CONFIG = new XorciteCaveFeature(NoFeatureConfig.CODEC);
	public static final Feature<NoFeatureConfig> TUNGSTEN_CONFIG = new TungstenOreFeature(NoFeatureConfig.CODEC);
	public static final Feature<NoFeatureConfig> TUNGSTEN_END_CONFIG = new TungstenEndFeature(NoFeatureConfig.CODEC);

	public static final ConfiguredFeature<?, ?> END_CORAL_FEATURE = Feature.SIMPLE_BLOCK.configured(new BlockWithContextConfig(NatureFeatures.END_CORAL, ImmutableList.of(NatureFeatures.END_STONE), ImmutableList.of(NatureFeatures.AIR), ImmutableList.of(NatureFeatures.AIR)))
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE).squared().count(13).decorated(Placement.COUNT_NOISE_BIASED.configured(new TopSolidWithNoiseConfig(65, 40.0D, 0.3D)));
	public static final ConfiguredFeature<?, ?> DRAGONITE_FEATURE = Feature.SIMPLE_BLOCK.configured(new BlockWithContextConfig(NatureFeatures.DRAGONITE, ImmutableList.of(NatureFeatures.GRASS_BLOCK), ImmutableList.of(NatureFeatures.AIR), ImmutableList.of(NatureFeatures.AIR)))
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).squared().count(ModConfigs.COMMON.balance.rarity_dragonite.get()).decorated(Placement.COUNT_NOISE_BIASED.configured(new TopSolidWithNoiseConfig(40, 20.0D, 0.2D)));
	public static ConfiguredFeature<?, ?> OGANA_FEATURE = Feature.SIMPLE_BLOCK.configured(new BlockWithContextConfig(NatureFeatures.OGANA, ImmutableList.of(NatureFeatures.END_MOSS), ImmutableList.of(NatureFeatures.AIR), ImmutableList.of(NatureFeatures.AIR)))
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).squared().count(ModConfigs.COMMON.balance.rarity_ogana.get()).decorated(Placement.COUNT_NOISE_BIASED.configured(new TopSolidWithNoiseConfig(65, 40.0D, 0.3D)));
	public static ConfiguredFeature<?, ?> OBSIDIAN_ORE_FEATURE = NatureFeatures.OBSIDIAN_ORE_CONFIG.configured(IFeatureConfig.NONE)
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(ModConfigs.COMMON.balance.rarity_obsidian_ore.get());
	public static ConfiguredFeature<?, ?> END_DECORATOR_FEATURE = NatureFeatures.END_DECORATOR_CONFIG.configured(IFeatureConfig.NONE)
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(ModConfigs.COMMON.balance.rarity_moss.get());
	public static ConfiguredFeature<?, ?> XORCITE_FEATURE = NatureFeatures.XORCITE_CONFIG.configured(IFeatureConfig.NONE)
			.decorated(Features.Placements.HEIGHTMAP).count(ModConfigs.COMMON.balance.rarity_xorcite_clusters.get());
	public static ConfiguredFeature<?, ?> TUNGSTEN_FEATURE = NatureFeatures.TUNGSTEN_CONFIG.configured(IFeatureConfig.NONE)
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(ModConfigs.COMMON.balance.rarity_tungsten_ore.get());
	public static ConfiguredFeature<?, ?> TUNGSTEN_END_FEATURE = NatureFeatures.TUNGSTEN_END_CONFIG.configured(IFeatureConfig.NONE)
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(ModConfigs.COMMON.balance.rarity_tungsten_end.get());
	public static ConfiguredFeature<?, ?> CITY_DECORATOR_FEATURE = NatureFeatures.CITY_DECORATOR_CONFIG.configured(IFeatureConfig.NONE)
			.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(1);
}
