package com.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class ObsidianOreFeature extends Feature<NoFeatureConfig> {
	public ObsidianOreFeature(Codec<NoFeatureConfig> p_i231932_1_) {
		super(p_i231932_1_);
	}


	public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		int i = 0;
			int u = rand.nextInt(3);
			BlockState blockstate = Blocks.CRYING_OBSIDIAN.defaultBlockState();
			if (u>=2) {
				for (int j = 0; j < 196; ++j) {
					BlockPos blockpos = pos.offset(rand.nextInt(4) - rand.nextInt(2), rand.nextInt(8) - rand.nextInt(4), rand.nextInt(4) - rand.nextInt(2));
					if (worldIn.getBlockState(blockpos).getBlock() == Blocks.OBSIDIAN) {
						worldIn.setBlock(blockpos, blockstate, 2);
						++i;
					}
				}
			}
		return i > 0;
	}
}