package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class XorciteClusterFeature extends Feature<DefaultFeatureConfig> {
    public XorciteClusterFeature(Codec<DefaultFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int i = 0;
        BlockState blockstate = ModBlocks.XORCITE.getDefaultState();
        if (pos.getY() >= 60 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.END_STONE && worldIn.isAir(pos.up())) {
            for (int j = 0; j < 1024; ++j) {
                BlockPos blockpos4 = pos.add(rand.nextInt(10) - rand.nextInt(9), -rand.nextInt(4), rand.nextInt(10) - rand.nextInt(9));
                if (worldIn.getBlockState(blockpos4).getBlock() == Blocks.END_STONE) {
                    worldIn.setBlockState(blockpos4, blockstate, 2);
                    ++i;
                }
            }
        }
        return i > 0;
    }
}

