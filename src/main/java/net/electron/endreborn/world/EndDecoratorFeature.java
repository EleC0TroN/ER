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

public class EndDecoratorFeature extends Feature<DefaultFeatureConfig> {
    public EndDecoratorFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(ServerWorldAccess worldIn, StructureAccessor accessor, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        int i = 0;
        BlockState brickstate = ModBlocks.CRACKED_END_BRICKS.getDefaultState();
        BlockState blockstate = ModBlocks.CRACKED_PURPUR.getDefaultState();
        for(int j = 0; j < 512; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(6), rand.nextInt(8) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(6));
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.PURPUR_BLOCK) {
                worldIn.setBlockState(blockpos, blockstate, 2);
                ++i;
                if (worldIn.getBlockState(blockpos).getBlock() == Blocks.END_STONE_BRICKS && blockstate.canPlaceAt(worldIn, blockpos) && !worldIn.isAir(blockpos)) {
                    worldIn.setBlockState(blockpos, brickstate, 2);
                    ++i;
                }
            }

        }
        return i > 0;
    }

}
