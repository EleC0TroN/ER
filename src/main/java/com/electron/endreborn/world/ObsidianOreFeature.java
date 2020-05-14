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

public class ObsidianOreFeature extends Feature<NoFeatureConfig> {
	public ObsidianOreFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49908_1_) {
		super(p_i49908_1_);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		int i = 0;
		BlockState blockstate = ModBlocks.OBSIDIAN_ORE.get().getDefaultState();
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