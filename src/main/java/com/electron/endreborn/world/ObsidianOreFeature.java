package com.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class ObsidianOreFeature extends Feature<NoFeatureConfig> {
	public ObsidianOreFeature(Codec<NoFeatureConfig> p_i231932_1_) {
		super(p_i231932_1_);
	}

	public boolean func_230362_a_(ISeedReader worldIn, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random rand, BlockPos pos, NoFeatureConfig p_230362_6_) {
		int i = 0;
		BlockState blockstate = Blocks.field_235399_ni_.getDefaultState();
		for (int j = 0; j < 256; ++j) {
			BlockPos blockpos = pos.add(rand.nextInt(4) - rand.nextInt(2), rand.nextInt(8) - rand.nextInt(4), rand.nextInt(4) - rand.nextInt(2));
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.OBSIDIAN) {
				worldIn.setBlockState(blockpos, blockstate, 2);
				++i;
			}
		}
		return i > 0;
	}
}