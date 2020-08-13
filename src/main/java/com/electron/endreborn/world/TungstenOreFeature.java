package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class TungstenOreFeature extends Feature<NoFeatureConfig> {
    public TungstenOreFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49880_1_) {
        super(p_i49880_1_);
    }


    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {     int i = 0;
        BlockState blockstate = ModBlocks.END_WOLFRAMIUM_ORE.get().getDefaultState();
        BlockState blockstate2 = ModBlocks.WOLFRAMIUM_ORE.get().getDefaultState();

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
