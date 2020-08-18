package net.electron.endreborn.world;

import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public abstract class NatureFeatures<FC extends FeatureConfig> {

    public static final Feature<DefaultFeatureConfig> MOSS = register("moss", new EndMossFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> OBSIDIAN_ORE = register("obsidian_ore", new ObsidianOreFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> END_DECO = register("end_deco", new EndDecoratorFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> XORCITE = register("xorcite", new XorciteClusterFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> TUNGSTEN = register("tungsten", new TungstenOreFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> END_TUNGSTEN = register("end_tungsten", new EndTungstenFeature(DefaultFeatureConfig.CODEC));

    public static final RandomPatchFeatureConfig DRAGONITE_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.DRAGONITE.getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
    public static final RandomPatchFeatureConfig WEED_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.OGANA_WEED.getDefaultState()), new SimpleBlockPlacer()) ).tries(5).build();

    public static final RandomPatchFeatureConfig END_CORAL_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.END_CORAL.getDefaultState()), new SimpleBlockPlacer()) ).tries(4).build();

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registry.FEATURE, name, feature);
    }
}
