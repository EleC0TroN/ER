package com.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class EndCryptStructure extends Structure<NoFeatureConfig> {
    public EndCryptStructure(Codec<NoFeatureConfig> p_i231989_1_) {
        super(p_i231989_1_);
    }

    public Structure.IStartFactory getStartFactory() {
        return EndCryptStructure.Start::new;
    }

    public GenerationStage.Decoration func_236396_f_() {
        return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> p_i225806_1_, int p_i225806_2_, int p_i225806_3_, MutableBoundingBox p_i225806_4_, int p_i225806_5_, long p_i225806_6_) {
            super(p_i225806_1_, p_i225806_2_, p_i225806_3_, p_i225806_4_, p_i225806_5_, p_i225806_6_);
        }

        public void func_230364_a_(DynamicRegistries p_230364_1_, ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig p_230364_6_) {
            int surfaceY = generator.getHeight(chunkX * 16, chunkZ * 16, Heightmap.Type.WORLD_SURFACE_WG);
            if (surfaceY >= 60) {
                BlockPos blockpos = new BlockPos(chunkX * 16, surfaceY-15, chunkZ * 16);
                Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
                EndCryptPieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);
            }
            this.recalculateStructureSize();
        }
    }
}