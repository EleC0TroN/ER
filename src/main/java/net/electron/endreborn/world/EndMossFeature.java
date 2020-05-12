package net.electron.endreborn.world;


import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class EndMossFeature extends Feature<DefaultFeatureConfig> {
	public EndMossFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> p_i49908_1_) {
		super(p_i49908_1_);
	}

	public boolean generate(IWorld worldIn, StructureAccessor accessor, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
		int i = 0;

		BlockState blockstate = net.electron.endreborn.blocks.Blocks.END_MOSS.getDefaultState();
		BlockState blockstate2 = net.electron.endreborn.blocks.Blocks.END_MOSS_BLOCK.getDefaultState();

		for(int j = 0; j < 1024; ++j) {
			BlockPos blockpos = pos.add(rand.nextInt(16) - rand.nextInt(12), pos.getY(), rand.nextInt(16) - rand.nextInt(8));
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && blockstate.canPlaceAt(worldIn, blockpos) && !worldIn.isAir(blockpos) && worldIn.isAir(blockpos.up())) {
				if (!worldIn.isAir(blockpos.down())) {
					worldIn.setBlockState(blockpos, blockstate, 2);
				}
				++i;
				if (worldIn.isAir(blockpos.down())) {
					worldIn.setBlockState(blockpos, blockstate2, 2);
					for(int f = 0; f < rand.nextInt(6)+1; ++f) {
						if(worldIn.getBlockState(blockpos).getBlock() == net.electron.endreborn.blocks.Blocks.END_MOSS_BLOCK) {
							worldIn.setBlockState(blockpos.down(f), blockstate2, 2);
						}
					}
				}
			}
		}
		return i > 0;
	}

}