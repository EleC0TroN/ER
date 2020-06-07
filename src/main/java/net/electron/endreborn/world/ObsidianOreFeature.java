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


public class ObsidianOreFeature extends Feature<DefaultFeatureConfig> {
	public ObsidianOreFeature(Codec<DefaultFeatureConfig> codec) {
		super(codec);
	}

	public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
		int i = 0;
		BlockState blockstate = ModBlocks.OBSIDIAN_ORE.getDefaultState();
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