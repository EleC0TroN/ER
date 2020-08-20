package net.electron.endreborn.world;

import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockStateMatchRuleTest;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class NatureConfguredFeatures {
    public static ConfiguredFeature<?, ?> ESSENCE_CONFIGURED = NatureFeatures.ESSENCE.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(5);
    public static ConfiguredFeature<?, ?> END_MOSS_CONFIGURED =  NatureFeatures.END_MOSS.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(4);
    public static ConfiguredFeature<?, ?> END_DECO_CONFIGURED = NatureFeatures.END_DECO.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(4);
    public static ConfiguredFeature<?, ?> XORCITE_CONFIGURED = NatureFeatures.XORCITE.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(2);
    public static ConfiguredFeature<?, ?> TUNGSTEN_CONFIGURED = NatureFeatures.TUNGSTEN.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(12);
    public static ConfiguredFeature<?, ?> END_TUNGSTEN_CONFIGURED = NatureFeatures.END_TUNGSTEN.configure(new DefaultFeatureConfig()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(1);

    public static ConfiguredFeature<?, ?> END_CORAL_CONFIGURED = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.END_CORAL.getDefaultState()), new SimpleBlockPlacer())).tries(24).build());
    public static ConfiguredFeature<?, ?> DRAGONITE_CONFIGURED = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.DRAGONITE.getDefaultState()), new SimpleBlockPlacer())).tries(5).build());
    public static ConfiguredFeature<?, ?> WEED_CONFIGURED = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.OGANA_WEED.getDefaultState()), new SimpleBlockPlacer())).tries(12).build());

    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> END_SHIPWRECK_CONFIGURED = register("end_shipwreck", NatureStructures.END_SHIPWRECK.configure(DefaultFeatureConfig.INSTANCE));
    public static final ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> END_CRYPT_CONFIGURED = register("end_crypt", NatureStructures.END_CRYPT.configure(DefaultFeatureConfig.INSTANCE));

    private static <FC extends FeatureConfig, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> register(String id, ConfiguredStructureFeature<FC, F> configuredStructureFeature) {
        return (ConfiguredStructureFeature) BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, id, configuredStructureFeature);
    }
}
