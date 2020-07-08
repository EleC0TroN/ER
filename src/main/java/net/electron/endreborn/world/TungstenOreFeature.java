package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class TungstenOreFeature extends Feature<DefaultFeatureConfig> {
    public TungstenOreFeature(Codec<DefaultFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int i = 0;
        BlockState blockstate = ModBlocks.END_TUNGSTEN_ORE.getDefaultState();
        BlockState blockstate2 = ModBlocks.TUNGSTEN_ORE.getDefaultState();

        if (worldIn.getBiome(pos) != Biomes.END_MIDLANDS && pos.getY() <= 40 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.GRANITE) {
            for (int j = 0; j < rand.nextInt(4); ++j) {
                BlockPos blockpos = pos.add(rand.nextInt(2), rand.nextInt(2), rand.nextInt(2));
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.GRANITE) {
                    worldIn.setBlockState(blockpos, blockstate2, 2);
                    ++i;
                }
            }
        } else if (worldIn.getBiome(pos) == Biomes.END_HIGHLANDS || worldIn.getBiome(pos) == Biomes.END_MIDLANDS && pos.getY() <= 70 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.END_STONE) {
            for (int j = 0; j <  rand.nextInt(6); ++j) {
                BlockPos blockpos = pos.add(rand.nextInt(2), rand.nextInt(2), rand.nextInt(2));
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE) {
                    worldIn.setBlockState(blockpos, blockstate, 2);
                    ++i;
                }
            }
        }
        return i > 0;
    }
}

