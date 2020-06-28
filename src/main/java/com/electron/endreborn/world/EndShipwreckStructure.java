package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
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

public class EndShipwreckStructure extends Structure<NoFeatureConfig> {
    public EndShipwreckStructure(Codec<NoFeatureConfig> p_i231989_1_) {
        super(p_i231989_1_);
    }

    public Structure.IStartFactory getStartFactory() {
        return EndShipwreckStructure.Start::new;
    }

    public String getStructureName() {
        return EndReborn.MODID + ":end_shipwreck";
    }

    public int getSize() {
        return 3;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> p_i225806_1_, int p_i225806_2_, int p_i225806_3_, MutableBoundingBox p_i225806_4_, int p_i225806_5_, long p_i225806_6_) {
            super(p_i225806_1_, p_i225806_2_, p_i225806_3_, p_i225806_4_, p_i225806_5_, p_i225806_6_);
        }

        public void func_230364_a_(ChunkGenerator p_230364_1_, TemplateManager p_230364_2_, int p_230364_3_, int p_230364_4_, Biome p_230364_5_, NoFeatureConfig p_230364_6_) {


            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

            int surfaceY = p_230364_1_.func_222531_c(p_230364_3_ * 16, p_230364_4_ * 16, Heightmap.Type.WORLD_SURFACE_WG);
            if (surfaceY >= 55) {
                BlockPos blockpos = new BlockPos(p_230364_3_ * 16, surfaceY - 2, p_230364_4_ * 16);

                EndShipwreckPieces.start(p_230364_2_, blockpos, rotation, this.components, this.rand);

                this.recalculateStructureSize();
            }
        }
    }
}