package net.electron.endreborn.world;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.*;

import java.util.Random;
import java.util.function.Function;


public class ObsidianOreFeature extends Feature<DefaultFeatureConfig> {
	public ObsidianOreFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> p_i49908_1_) {
		super(p_i49908_1_);
	}

	public boolean generate(IWorld worldIn, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
		int i = 0;
		BlockState blockstate = net.electron.endreborn.blocks.Blocks.OBSIDIAN_ORE.getDefaultState();
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