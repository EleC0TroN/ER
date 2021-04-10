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

public class CrackedDecoratorFeature extends Feature<NoFeatureConfig> {

    public CrackedDecoratorFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        BlockState brickstate = ModBlocks.CRACKED_END_BRICKS.get().defaultBlockState();
        BlockState blockstate = ModBlocks.CRACKED_PURPUR.get().defaultBlockState();
        for(int j = 0; j < 512; ++j) {
            BlockPos blockpos = pos.offset(rand.nextInt(8) - rand.nextInt(6), rand.nextInt(8) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(6));
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.PURPUR_BLOCK) {
                worldIn.setBlock(blockpos, blockstate, 2);
                ++i;
            }
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE_BRICKS && blockstate.canSurvive(worldIn, blockpos) && !worldIn.isEmptyBlock(blockpos)) {
                worldIn.setBlock(blockpos, brickstate, 2);
                ++i;
            }
        }
        return i > 0;
    }
}