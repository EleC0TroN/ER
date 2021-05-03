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

public class EndDecoratorFeature extends Feature<NoFeatureConfig> {
	   public EndDecoratorFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49908_1_) {
		      super(p_i49908_1_);
		   }

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		int i = 0;
		BlockState blockstate = ModBlocks.END_MOSS.get().getDefaultState();
		BlockState blockstate2 = ModBlocks.END_MOSS_BLOCK.get().getDefaultState();

		for (int j = 0; j < 568; ++j) {
			BlockPos blockpos = pos.add(rand.nextInt(13) - rand.nextInt(12), pos.getY(), rand.nextInt(13) - rand.nextInt(12));
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && blockstate.isValidPosition(worldIn, blockpos) && blockpos.getY() >= 50) {
				if (!worldIn.isAirBlock(blockpos.down()) && !worldIn.isAirBlock(blockpos) && worldIn.isAirBlock(blockpos.up())) {
					worldIn.setBlockState(blockpos, blockstate, 2);
				}
				++i;

				if (worldIn.isAirBlock(blockpos.down()) && worldIn.isAirBlock(blockpos.up())) {
					worldIn.setBlockState(blockpos, blockstate2, 2);
					int u = rand.nextInt(6);
					for (int f = 0; f < u + 1; ++f) {
						if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS_BLOCK.get()) {
							if (worldIn.isAirBlock(blockpos.down(f))) {
								worldIn.setBlockState(blockpos.down(f), blockstate2, 2);
							}
						}
					}
				}
			}
		}
		BlockPos blockpos_new = pos.add(rand.nextInt(12) - rand.nextInt(4), pos.getY(), rand.nextInt(12) - rand.nextInt(4));

		for (int j = 0; j < 628; ++j) {
			BlockPos blockpos = blockpos_new.add(rand.nextInt(10) - rand.nextInt(9), pos.getY(), rand.nextInt(10) - rand.nextInt(9));
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && blockstate.isValidPosition(worldIn, blockpos) && blockpos.getY() >= 55) {
				if (!worldIn.isAirBlock(blockpos.down()) && !worldIn.isAirBlock(blockpos) && worldIn.isAirBlock(blockpos.up())) {
					worldIn.setBlockState(blockpos, blockstate, 2);
				}
				++i;

				if (worldIn.isAirBlock(blockpos.down()) && worldIn.isAirBlock(blockpos.up())) {
					worldIn.setBlockState(blockpos, blockstate2, 2);
					int u = rand.nextInt(6);
					for (int f = 0; f < u + 1; ++f) {
						if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS_BLOCK.get()) {
							if (worldIn.isAirBlock(blockpos.down(f))) {
								worldIn.setBlockState(blockpos.down(f), blockstate2, 2);
							}
						}
					}
				}
			}
		}
		return i > 0;
	}
}