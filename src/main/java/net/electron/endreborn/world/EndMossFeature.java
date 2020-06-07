package net.electron.endreborn.world;


import com.mojang.serialization.Codec;
import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class EndMossFeature extends Feature<DefaultFeatureConfig> {
	public EndMossFeature(Codec<DefaultFeatureConfig> codec) {
		super(codec);
	}

	public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
		int i = 0;

		BlockState blockstate = ModBlocks.END_MOSS.getDefaultState();
		BlockState blockstate2 = ModBlocks.END_MOSS_BLOCK.getDefaultState();

		for(int j = 0; j < 1024; ++j) {
			BlockPos blockpos = pos.add(rand.nextInt(16) - rand.nextInt(12), pos.getY(), rand.nextInt(16) - rand.nextInt(8));
			if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && blockstate.canPlaceAt(worldIn, blockpos) && !worldIn.isAir(blockpos) && worldIn.isAir(blockpos.up()) && blockpos.getY() >=55) {
				if (!worldIn.isAir(blockpos.down())) {
					worldIn.setBlockState(blockpos, blockstate, 2);
				}
				++i;
				if (worldIn.isAir(blockpos.down())) {
					worldIn.setBlockState(blockpos, blockstate2, 2);
					for(int f = 0; f < rand.nextInt(6)+1; ++f) {
						if(worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS_BLOCK) {
							worldIn.setBlockState(blockpos.down(f), blockstate2, 2);
						}
					}
				}
			}
		}
		return i > 0;
	}
}