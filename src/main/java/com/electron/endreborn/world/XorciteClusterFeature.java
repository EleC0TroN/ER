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

public class XorciteClusterFeature extends Feature<NoFeatureConfig> {
    public XorciteClusterFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }
//Xorcite Glowing block, particles from it, caves created by spheres
    public boolean generate(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
            BlockState blockstate = ModBlocks.XORCITE.get().getDefaultState();
            if (pos.getY() >= 65 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.END_STONE && worldIn.isAirBlock(pos.up())) {
                for (int j = 0; j < 2276; ++j) {
                    BlockPos blockpos4 = pos.add(rand.nextInt(24) - rand.nextInt(22), -rand.nextInt(4), rand.nextInt(24) - rand.nextInt(22));
                    if (worldIn.getBlockState(blockpos4).getBlock() == Blocks.END_STONE) {
                        worldIn.setBlockState(blockpos4, blockstate, 2);
                        ++i;
                    }
                }
            }
        return i > 0;
    }
}
