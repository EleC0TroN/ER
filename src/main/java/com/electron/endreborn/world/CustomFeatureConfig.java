package com.electron.endreborn.world;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class CustomFeatureConfig implements IFeatureConfig {
    public final BlockState state;

    public CustomFeatureConfig(BlockState state) {
        this.state = state;
    }

    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("state"), BlockState.serialize(ops, this.state).getValue())));
    }

    public static <T> CustomFeatureConfig deserialize(Dynamic<T> p_214685_0_) {
        BlockState blockstate = p_214685_0_.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        return new CustomFeatureConfig(blockstate);
    }
}
