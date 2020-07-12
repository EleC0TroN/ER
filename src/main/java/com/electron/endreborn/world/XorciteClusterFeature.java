package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class XorciteClusterFeature extends Feature<NoFeatureConfig> {
    public XorciteClusterFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean func_230362_a_(ISeedReader worldIn, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random rand, BlockPos pos, NoFeatureConfig p_230362_6_) {
        int i = 0;
        BlockState blockstate = ModBlocks.XORCITE.get().getDefaultState();

            if (pos.getY() <= 53 && pos.getY() >= 46 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.END_STONE && worldIn.isAirBlock(pos.up())) {
                for (int j = 0; j < 2024; ++j) {
                BlockPos blockpos4 = pos.add(rand.nextInt(16) - rand.nextInt(15), rand.nextInt(6), rand.nextInt(16) - rand.nextInt(16));
                if (worldIn.getBlockState(blockpos4).getBlock() == Blocks.END_STONE) {
                    worldIn.setBlockState(blockpos4, blockstate, 2);
                    ++i;
                }
            }

                for (int j = 0; j < 256; ++j) {
                    BlockPos blockpos4 = pos.add(rand.nextInt(16) - rand.nextInt(15), rand.nextInt(6), rand.nextInt(16) - rand.nextInt(16));
                    if (worldIn.getBlockState(blockpos4.up()).getBlock() == ModBlocks.XORCITE.get() && worldIn.isAirBlock(blockpos4)) {
                        worldIn.setBlockState(blockpos4, ModBlocks.ROOTS.get().getDefaultState().with(BlockStateProperties.ATTACHED, false), 2);
                        ++i;
                    }
                }
        }
        return i > 0;
    }
}
