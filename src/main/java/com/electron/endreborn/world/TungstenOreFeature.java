package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class TungstenOreFeature extends Feature<NoFeatureConfig> {
    public TungstenOreFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean func_230362_a_(ISeedReader worldIn, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random rand, BlockPos pos, NoFeatureConfig p_230362_6_) {
        int i = 0;
        BlockState blockstate = ModBlocks.TUNGSTEN_END_ORE.get().getDefaultState();
        BlockState blockstate2 = ModBlocks.TUNGSTEN_ORE.get().getDefaultState();

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
