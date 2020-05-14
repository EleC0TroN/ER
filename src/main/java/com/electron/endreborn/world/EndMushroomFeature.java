package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.item.ChorusFruitItem;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class EndMushroomFeature extends Feature<NoFeatureConfig> {
    public EndMushroomFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49880_1_) {
        super(p_i49880_1_);
    }


    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        float f = (float)(rand.nextInt(3) + 2);

        for(int i = 0; f > 0.5F; --i) {
            for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
                for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
                        if (worldIn.getBlockState(pos).getBlock() == Blocks.END_STONE && pos.getY() <=50 && pos.getY() >=30) {
                            if (worldIn.isAirBlock(pos.add(j, i, k))) {
                                this.setBlockState(worldIn, pos.add(j, i, k), ModBlocks.END_MUSHROOM.get().getDefaultState());
                            }
                        }
                    }
                }
            }

            f = (float)((double)f - ((double)rand.nextInt(2) + 1.0D));
        }
        int i = 0;
        for(int j = 0; j < 64; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(6), rand.nextInt(8) - rand.nextInt(6), rand.nextInt(8) - rand.nextInt(6));
            if (worldIn.getBlockState(blockpos.up()).getBlock() == ModBlocks.END_MUSHROOM.get() && worldIn.isAirBlock(blockpos) ) {
                    worldIn.setBlockState(blockpos, ModBlocks.ROOTS.get().getDefaultState(), 2);
                    ++i;
            }
        }
        return true;
    }
}