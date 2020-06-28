package com.electron.endreborn.world;

import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class EndCryptStructure extends Structure<NoFeatureConfig>
{
    public EndCryptStructure(Codec<NoFeatureConfig> p_i231989_1_) {
        super(p_i231989_1_);
    }

    public Structure.IStartFactory getStartFactory()
    {
        return EndCryptStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> p_i225817_1_, int p_i225817_2_, int p_i225817_3_, MutableBoundingBox p_i225817_4_, int p_i225817_5_, long p_i225817_6_) {
            super(p_i225817_1_, p_i225817_2_, p_i225817_3_, p_i225817_4_, p_i225817_5_, p_i225817_6_);
        }

        public void func_230364_a_(ChunkGenerator p_230364_1_, TemplateManager p_230364_2_, int p_230364_3_, int p_230364_4_, Biome p_230364_5_, NoFeatureConfig p_230364_6_) {
            Rotation rotation = Rotation.randomRotation(this.rand);

            int x = (p_230364_3_ << 4) + 7;
            int z = (p_230364_4_ << 4) + 7;

            int surfaceY = p_230364_1_.func_222531_c(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            if (surfaceY >= 60) {
                BlockPos blockpos = new BlockPos(x, surfaceY - 16, z);

                EndCryptPieces.start(p_230364_2_, blockpos, rotation, this.components, this.rand);

                this.recalculateStructureSize();
            }
        }
    }
}