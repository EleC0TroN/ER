package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.electron.endreborn.EndReborn;
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

public class EndShipwreckStructure extends StructureFeature<DefaultFeatureConfig> {
    public EndShipwreckStructure(Codec<DefaultFeatureConfig> p_i231989_1_) {
        super(p_i231989_1_);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return EndShipwreckStructure.Start::new;
    }

    public String getName() {
        return EndReborn.MODID + ":end_shipwreck";
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, int i, int j, BlockBox blockBox, int k, long l) {
            super(structureFeature, i, j, blockBox, k, l);
        }
        public void init(ChunkGenerator chunkGenerator, StructureManager structureManager, int i, int j, Biome biome, DefaultFeatureConfig defaultFeatureConfig) {
            int surfaceY = chunkGenerator.getHeightInGround(i * 16, j * 16, Heightmap.Type.WORLD_SURFACE_WG);
            if (surfaceY >= 55) {
                BlockPos blockpos = new BlockPos(i * 16, surfaceY-3, j * 16);
                BlockRotation blockRotation = BlockRotation.random(this.random);
                EndShipwreckPieces.start(structureManager, blockpos, blockRotation, this.children, this.random);
            }
            this.setBoundingBoxFromChildren();
        }

    }
}