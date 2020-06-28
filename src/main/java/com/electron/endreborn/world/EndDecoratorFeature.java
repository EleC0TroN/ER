package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class EndDecoratorFeature extends Feature<NoFeatureConfig> {
	   public EndDecoratorFeature(Codec<NoFeatureConfig> p_i231932_1_) {
		   super(p_i231932_1_);
	   }

	public boolean func_230362_a_(ISeedReader worldIn, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random rand, BlockPos pos, NoFeatureConfig p_230362_6_) {
		      int i = 0;

		      BlockState blockstate = ModBlocks.END_MOSS.get().getDefaultState();
		      BlockState blockstate2 = ModBlocks.END_MOSS_BLOCK.get().getDefaultState();

				  for (int j = 0; j < 1024; ++j) {
					  BlockPos blockpos = pos.add(rand.nextInt(16) - rand.nextInt(12), pos.getY(), rand.nextInt(16) - rand.nextInt(8));
					  if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE && blockstate.isValidPosition(worldIn, blockpos) &&  blockpos.getY() >=55) {
						  if (!worldIn.isAirBlock(blockpos.down()) && !worldIn.isAirBlock(blockpos) && worldIn.isAirBlock(blockpos.up())) {
							  worldIn.setBlockState(blockpos, blockstate, 2);
						  }
						  ++i;

						  if (worldIn.isAirBlock(blockpos.down()) && worldIn.isAirBlock(blockpos.up())) {
							  worldIn.setBlockState(blockpos, blockstate2, 2);
							  int r = rand.nextInt(3);
							  int u = rand.nextInt(6);
							  for (int f = 0; f < u + 1; ++f) {
								  if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS_BLOCK.get()) {
								  	if (worldIn.isAirBlock(blockpos.down(f))) {
										worldIn.setBlockState(blockpos.down(f), blockstate2, 2);
									}
								  }
								  if (r>= 2 && u >=5 && worldIn.getBlockState(blockpos).getBlock() == ModBlocks.END_MOSS_BLOCK.get())
									  if (worldIn.isAirBlock(blockpos.down(f))) {
										  worldIn.setBlockState(blockpos.down(f + 1), ModBlocks.ROOTS.get().getDefaultState().with(BlockStateProperties.ATTACHED, false), 2);
									  }
							  }
						  }
					  }
			  }
		return i > 0;
	 }
}