package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class XorciteCaveFeature extends Feature<NoFeatureConfig> {
    public XorciteCaveFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        double chance = rand.nextDouble();

        if (chance > 0.68D) {
            int o = rand.nextInt(7);
            int o1 = o - 1;
            float f = (float) (o + o + o) * 0.333F + 0.5F;

            if (pos.getY() <= 44 && pos.getY() > 31) {

                    for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-o, -o, -o), pos.add(o, o, o))) {
                        if (blockpos.distanceSq(pos) <= (double) (f * f) && reader.getBlockState(blockpos).getBlock() == Blocks.END_STONE) {
                            reader.setBlockState(blockpos, NatureFeatures.XORCITE, 2);
                        }
                    }
                    for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-o1, -o1, -o1), pos.add(o1, o1, o1))) {
                        if (o1 > 1 && blockpos.distanceSq(pos) <= (double) (f * f) && reader.getBlockState(blockpos).getBlock() == ModBlocks.XORCITE.get() || reader.getBlockState(blockpos).getBlock() == ModBlocks.TUNGSTEN_END_ORE.get() || reader.getBlockState(blockpos).getBlock() == ModBlocks.END_CORAL.get()) {
                            reader.setBlockState(blockpos, NatureFeatures.AIR, 2);
                        }
                    }
                }
            }
        return true;
    }
}

