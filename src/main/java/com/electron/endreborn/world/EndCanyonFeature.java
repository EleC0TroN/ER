package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockBlobFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class EndCanyonFeature extends Feature<NoFeatureConfig> {
    public EndCanyonFeature(Codec<NoFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean func_230362_a_(ISeedReader worldIn, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random rand, BlockPos pos, NoFeatureConfig p_230362_6_) {
        while (true) {
            label48:
            {
                if (pos.getY() > 3) {
                    if (worldIn.isAirBlock(pos.down())) {
                        break label48;
                    }

                    Block block = worldIn.getBlockState(pos.down()).getBlock();
                    if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.END_STONE || worldIn.getBlockState(pos.down()).getBlock() != ModBlocks.END_MOSS.get()) {
                        break label48;
                    }
                }

                if (pos.getY() <= 3) {
                    return false;
                }

                int i1 = 32;

                for (int i = 0; i1 >= 0 && i < 3; ++i) {
                    int j = i1 + rand.nextInt(2);
                    int k = i1 + rand.nextInt(2);
                    int l = i1 + rand.nextInt(2);
                    float f = (float) (j + k + l) * 0.333F + 0.5F;

                    for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-j, -k, -l), pos.add(j, k, l))) {
                        if (blockpos.distanceSq(pos) <= (double) (f * f)) {
                            worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 4);
                        }
                    }

                    pos = pos.add(-(i1 + 1) + rand.nextInt(2 + i1 * 2), 0 - rand.nextInt(2), -(i1 + 1) + rand.nextInt(2 + i1 * 2));
                }

                return true;
            }

            pos = pos.down();
        }
    }
}
