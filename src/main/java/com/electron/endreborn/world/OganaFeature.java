package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class OganaFeature extends Feature<NoFeatureConfig> {
    public OganaFeature(Codec<NoFeatureConfig> p_i231936_1_) {
        super(p_i231936_1_);
    }

    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        if (reader.isAirBlock(pos) && reader.getBlockState(pos.down()).isIn(ModBlocks.END_MOSS.get()) || reader.getBlockState(pos.down()).isIn(ModBlocks.END_MOSS_BLOCK.get())) {
            for (int j = 0; j < 6; ++j) {
                BlockPos blockpos = pos.add(pos.getX() - rand.nextInt(4), pos.getY(), pos.getZ() - rand.nextInt(4));

                reader.setBlockState(blockpos, ModBlocks.OGANA_WEED.get().getDefaultState(), 2);
                ++i;
            }
        }
        return i > 0;
    }
}
