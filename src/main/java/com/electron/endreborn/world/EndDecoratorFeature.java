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

public class EndDecoratorFeature extends Feature<NoFeatureConfig> {
	   public EndDecoratorFeature(Codec<NoFeatureConfig> p_i231932_1_) {
		   super(p_i231932_1_);
	   }

	public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		int i = 0;
			BlockState blockstate = ModBlocks.END_MOSS.get().defaultBlockState();
			BlockState blockstate2 = ModBlocks.END_MOSS_BLOCK.get().defaultBlockState();

			for (int j = 0; j < 568; ++j) {
				BlockPos blockpos = pos.offset(rand.nextInt(13) - rand.nextInt(12), pos.getY(), rand.nextInt(13) - rand.nextInt(12));
				if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && blockstate.canSurvive(worldIn, blockpos) && blockpos.getY() >= 50) {
					if (!worldIn.isEmptyBlock(blockpos.below()) && !worldIn.isEmptyBlock(blockpos) && worldIn.isEmptyBlock(blockpos.above())) {
						worldIn.setBlock(blockpos, blockstate, 2);
					}
					++i;

					if (worldIn.isEmptyBlock(blockpos.below()) && worldIn.isEmptyBlock(blockpos.above())) {
						worldIn.setBlock(blockpos, blockstate2, 2);
						int u = rand.nextInt(6);
						for (int f = 0; f < u + 1; ++f) {
							if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS_BLOCK.get()) {
								if (worldIn.isEmptyBlock(blockpos.below(f))) {
									worldIn.setBlock(blockpos.below(f), blockstate2, 2);
								}
							}
						}
					}
				}
			}
			BlockPos blockpos_new = pos.offset(rand.nextInt(12) - rand.nextInt(4), pos.getY(), rand.nextInt(12) - rand.nextInt(4));

			for (int j = 0; j < 628; ++j) {
				BlockPos blockpos = blockpos_new.offset(rand.nextInt(10) - rand.nextInt(9), pos.getY(), rand.nextInt(10) - rand.nextInt(9));
				if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && blockstate.canSurvive(worldIn, blockpos) && blockpos.getY() >= 55) {
					if (!worldIn.isEmptyBlock(blockpos.below()) && !worldIn.isEmptyBlock(blockpos) && worldIn.isEmptyBlock(blockpos.above())) {
						worldIn.setBlock(blockpos, blockstate, 2);
					}
					++i;

					if (worldIn.isEmptyBlock(blockpos.below()) && worldIn.isEmptyBlock(blockpos.above())) {
						worldIn.setBlock(blockpos, blockstate2, 2);
						int u = rand.nextInt(6);
						for (int f = 0; f < u + 1; ++f) {
							if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS_BLOCK.get()) {
								if (worldIn.isEmptyBlock(blockpos.below(f))) {
									worldIn.setBlock(blockpos.below(f), blockstate2, 2);
								}
							}
						}
					}
				}
			}
		return i > 0;
	 }
}