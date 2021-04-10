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

public class TungstenEndFeature extends Feature<NoFeatureConfig> {
    public TungstenEndFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
            BlockState blockstate = ModBlocks.TUNGSTEN_END_ORE.get().defaultBlockState();
            if (pos.getY() <= 70 && worldIn.getBlockState(pos.below()).getBlock() == Blocks.END_STONE) {
                for (int j = 0; j < rand.nextInt(6); ++j) {
                    BlockPos blockpos = pos.offset(rand.nextInt(2), rand.nextInt(2), rand.nextInt(2));
                    if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE) {
                        worldIn.setBlock(blockpos, blockstate, 2);
                        ++i;
                    }
                }
            }
        return i > 0;
    }
}
