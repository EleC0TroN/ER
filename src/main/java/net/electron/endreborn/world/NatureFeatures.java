package net.electron.endreborn.world;

import net.electron.endreborn.EndReborn;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public abstract class NatureFeatures<FC extends FeatureConfig> {
    public static final Feature<DefaultFeatureConfig> ESSENCE = new ObsidianOreFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> END_MOSS = new EndMossFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> END_DECO = new EndDecoratorFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> XORCITE = new XorciteClusterFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> TUNGSTEN = new TungstenOreFeature(DefaultFeatureConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> END_TUNGSTEN = new EndTungstenFeature(DefaultFeatureConfig.CODEC);

    public static void init() {
        registerFeature(ESSENCE, "essence");
        registerFeature(END_MOSS, "end_moss");
        registerFeature(END_DECO, "end_deco");
        registerFeature(XORCITE, "xorcite");
        registerFeature(TUNGSTEN, "tungsten");
        registerFeature(END_TUNGSTEN, "end_tungsten");
    }

    public static void registerFeature(Feature<?> feature, String registryName) {
        Registry.register(Registry.FEATURE, new Identifier(EndReborn.MODID, registryName), feature);
    }
}
