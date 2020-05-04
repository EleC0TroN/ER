package com.electron.endreborn.world;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import com.electron.endreborn.ModBlocks;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;

public class ObsidianOreFeature extends Feature<NoFeatureConfig> {
	public ObsidianOreFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49908_1_) {
		super(p_i49908_1_);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		int i = 0;
		BlockState blockstate = ModBlocks.OBSIDIAN_ORE.get().getDefaultState();
		for (int j = 0; j < 8; ++j) {
			BlockPos blockpos = pos.add(rand.nextInt(2) - rand.nextInt(1), rand.nextInt(6) - rand.nextInt(3), rand.nextInt(2) - rand.nextInt(1));
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.OBSIDIAN) {
				worldIn.setBlockState(blockpos, blockstate, 2);
				++i;
			}
		}
		return i > 0;
	}
}