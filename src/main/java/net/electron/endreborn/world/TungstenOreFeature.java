package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class TungstenOreFeature extends Feature<DefaultFeatureConfig> {
    public TungstenOreFeature(Codec<DefaultFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int i = 0;
        BlockState blockstate2 = ModBlocks.TUNGSTEN_ORE.getDefaultState();
        if (worldIn.getBlockState(pos).getBlock() == Blocks.GRANITE) {
            for (int j = 0; j < rand.nextInt(4); ++j) {
                BlockPos blockpos = pos.add(rand.nextInt(2), rand.nextInt(2), rand.nextInt(2));
                if (!worldIn.getBlockState(blockpos).isAir()) {
                    worldIn.setBlockState(blockpos, blockstate2, 2);
                }
                ++i;
            }
        }
        return i > 0;
    }
}

