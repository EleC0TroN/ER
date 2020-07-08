package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.electron.endreborn.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class XorciteClusterFeature extends Feature<DefaultFeatureConfig> {
    public XorciteClusterFeature(Codec<DefaultFeatureConfig> p_i231932_1_) {
        super(p_i231932_1_);
    }

    public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int i = 0;
        BlockState blockstate = ModBlocks.XORCITE.getDefaultState();

        if (pos.getY() <= 53 && pos.getY() >= 46 && worldIn.getBlockState(pos.down()).getBlock() == Blocks.END_STONE && worldIn.isAir(pos.up())) {
            for (int j = 0; j < 2024; ++j) {
                BlockPos blockpos4 = pos.add(rand.nextInt(16) - rand.nextInt(15), rand.nextInt(6), rand.nextInt(16) - rand.nextInt(16));
                if (worldIn.getBlockState(blockpos4).getBlock() == Blocks.END_STONE) {
                    worldIn.setBlockState(blockpos4, blockstate, 2);
                    ++i;
                }
            }

            for (int j = 0; j < 256; ++j) {
                BlockPos blockpos4 = pos.add(rand.nextInt(16) - rand.nextInt(15), rand.nextInt(6), rand.nextInt(16) - rand.nextInt(16));
                if (worldIn.getBlockState(blockpos4.up()).getBlock() == ModBlocks.XORCITE && worldIn.isAir(blockpos4)) {
                    worldIn.setBlockState(blockpos4, ModBlocks.ROOTS.getDefaultState().with(Properties.ATTACHED, false), 2);
                    ++i;
                }
            }
        }
        return i > 0;
    }
}

