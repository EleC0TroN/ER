package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class EndshroomFeature extends Feature<DefaultFeatureConfig> {
    public EndshroomFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        float f = (float)(rand.nextInt(3) + 2);

        for(int i = 0; f > 0.5F; --i) {
            for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
                for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
                        if (worldIn.getBlockState(pos).getBlock() == Blocks.END_STONE && pos.getY() <=50 && pos.getY() >=30) {
                            if (worldIn.isAir(pos.add(j, i, k))) {
                                this.setBlockState(worldIn, pos.add(j, i, k), ModBlocks.ENDSHROOM.getDefaultState());
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
            if (worldIn.getBlockState(blockpos.up()).getBlock() == ModBlocks.ENDSHROOM && worldIn.isAir(blockpos) ) {
                worldIn.setBlockState(blockpos, ModBlocks.ENDSHROOM_ROOTS.getDefaultState(), 2);
                ++i;
            }
        }
        return true;
    }
}
