package com.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.BuriedTreasureConfig;

public class ProbabilityFeatureConfig implements IFeatureConfig {
    public static final Codec<ProbabilityFeatureConfig> field_236457_a_ = Codec.FLOAT.xmap(ProbabilityFeatureConfig::new, (p_236458_0_) -> {
        return p_236458_0_.probability;
    });
    public final float probability;

    public ProbabilityFeatureConfig(float probability) {
        this.probability = probability;
    }
}