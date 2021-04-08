package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class TungstenOreFeature extends Feature<NoFeatureConfig> {
    public TungstenOreFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        BlockState blockstate = ModBlocks.TUNGSTEN_ORE.get().getDefaultState();
        if (pos.getY() <= 40 && worldIn.getBlockState(pos).getBlock() == Blocks.GRANITE) {
            for (int j = 0; j < rand.nextInt(4); ++j) {
                BlockPos blockpos = pos.add(rand.nextInt(2), rand.nextInt(2), rand.nextInt(2));
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.GRANITE) {
                    worldIn.setBlockState(blockpos, blockstate, 2);
                    ++i;
                }
            }
        }
        return i > 0;
    }
}
