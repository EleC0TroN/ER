package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Random;

public class EndCryptStructure extends StructureFeature<DefaultFeatureConfig> {
    public EndCryptStructure(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public String getName() {
        return "EndCrypt";
    }

    public int getRadius() {
        return 3;
    }

    public StructureStartFactory getStructureStartFactory() {
        return EndCryptStructure.Start::new;
    }

    private static int getGenerationHeight(int chunkX, int chunkZ, ChunkGenerator chunkGenerator) {
        Random random = new Random((long)(chunkX + chunkZ * 10387313));
        BlockRotation blockRotation = BlockRotation.random(random);
        int i = 5;
        int j = 5;
        if (blockRotation == BlockRotation.CLOCKWISE_90) {
            i = -5;
        } else if (blockRotation == BlockRotation.CLOCKWISE_180) {
            i = -5;
            j = -5;
        } else if (blockRotation == BlockRotation.COUNTERCLOCKWISE_90) {
            j = -5;
        }

        int k = (chunkX << 4) + 7;
        int l = (chunkZ << 4) + 7;
        int m = chunkGenerator.getHeightInGround(k, l, Heightmap.Type.WORLD_SURFACE_WG);
        int n = chunkGenerator.getHeightInGround(k, l + j, Heightmap.Type.WORLD_SURFACE_WG);
        int o = chunkGenerator.getHeightInGround(k + i, l, Heightmap.Type.WORLD_SURFACE_WG);
        int p = chunkGenerator.getHeightInGround(k + i, l + j, Heightmap.Type.WORLD_SURFACE_WG);
        return Math.min(Math.min(m, n), Math.min(o, p));
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, int i, int j, BlockBox blockBox, int k, long l) {
            super(structureFeature, i, j, blockBox, k, l);
        }

        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int i, int j, Biome biome, DefaultFeatureConfig defaultFeatureConfig) {
            BlockRotation blockRotation = BlockRotation.random(this.random);
            int k = EndCryptStructure.getGenerationHeight(i, j, chunkGenerator);
            if (k >= 60) {
                BlockPos blockPos = new BlockPos(i * 16 + 8, k, j * 16 + 8);
                EndCryptPieces.addPieces(structureManager, blockPos, blockRotation, this.children, this.random);
                this.setBoundingBoxFromChildren();
            }
        }
    }
}
