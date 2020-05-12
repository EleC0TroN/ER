package net.electron.endreborn.world;

import net.electron.endreborn.blocks.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public abstract class NatureFeatures<FC extends FeatureConfig> {

    public static final Feature<DefaultFeatureConfig> MOSS = register("moss", new EndMossFeature(DefaultFeatureConfig::deserialize));
    public static final Feature<DefaultFeatureConfig> OBSIDIAN_ORE = register("obsidian_ore", new ObsidianOreFeature(DefaultFeatureConfig::deserialize));
    public static final Feature<DefaultFeatureConfig> END_DECO = register("ecnd_deco", new EndDecoratorFeature(DefaultFeatureConfig::deserialize));

    public static final RandomPatchFeatureConfig DRAGONITE_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.DRAGONITE.getDefaultState()), new SimpleBlockPlacer())).tries(4).build();
    public static final RandomPatchFeatureConfig WEED_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OGANA_WEED.getDefaultState()), new SimpleBlockPlacer()) ).tries(4).build();
    public static final RandomPatchFeatureConfig PLANT_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OGANA_PLANT.getDefaultState()), new SimpleBlockPlacer())).tries(4).build();


    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registry.FEATURE, name, feature);
    }
}
