package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class CrackedDecoratorFeature extends Feature<NoFeatureConfig> {
    public CrackedDecoratorFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49908_1_) {
        super(p_i49908_1_);
    }
    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int i = 0;
        BlockState brickstate = ModBlocks.CRACKED_END_BRICKS.get().getDefaultState();
        BlockState blockstate = ModBlocks.CRACKED_PURPUR.get().getDefaultState();
        for(int j = 0; j < 64; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(6), rand.nextInt(8) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(6));
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.PURPUR_BLOCK) {
                worldIn.setBlockState(blockpos, blockstate, 2);
                ++i;
            }
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE_BRICKS && blockstate.isValidPosition(worldIn, blockpos) && !worldIn.isAirBlock(blockpos)) {
                worldIn.setBlockState(blockpos, brickstate, 2);
                ++i;
            }
        }
        return i > 0;
    }
}