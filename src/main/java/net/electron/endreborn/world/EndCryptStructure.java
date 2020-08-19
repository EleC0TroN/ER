package net.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.electron.endreborn.EndReborn;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class EndCryptStructure extends StructureFeature<DefaultFeatureConfig> {
    public EndCryptStructure(Codec<DefaultFeatureConfig> p_i231989_1_) {
        super(p_i231989_1_);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return EndCryptStructure.Start::new;
    }

    public String getName() {
        return EndReborn.MODID + ":end_crypt";
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureFeature, int i, int j, BlockBox blockBox, int k, long l) {
            super(structureFeature, i, j, blockBox, k, l);
        }
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, int i, int j, Biome biome, DefaultFeatureConfig shipwreckFeatureConfig) {
            int surfaceY = chunkGenerator.getHeightInGround(i * 16, j * 16, Heightmap.Type.WORLD_SURFACE_WG);
            if (surfaceY >= 60) {
                BlockPos blockpos = new BlockPos(i * 16, surfaceY-15, j * 16);
                BlockRotation blockRotation = BlockRotation.random(this.random);
                EndCryptPieces.start(structureManager, blockpos, blockRotation, this.children, this.random);
            }
            this.setBoundingBoxFromChildren();
        }
    }
}
