package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
<<<<<<< Updated upstream
import net.minecraft.world.biome.provider.BiomeProvider;
=======
>>>>>>> Stashed changes
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
<<<<<<< Updated upstream
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class EndShipwreckStructure extends Structure<NoFeatureConfig> {
    public EndShipwreckStructure(Codec<NoFeatureConfig> p_i51440_1_) {
        super(p_i51440_1_);
=======
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class EndShipwreckStructure extends Structure<NoFeatureConfig> {
    public EndShipwreckStructure(Codec<NoFeatureConfig> p_i231989_1_) {
        super(p_i231989_1_);
    }

    public Structure.IStartFactory getStartFactory() {
        return EndShipwreckStructure.Start::new;
>>>>>>> Stashed changes
    }

    public String getStructureName() {
        return EndReborn.MODID + ":end_shipwreck";
    }

<<<<<<< Updated upstream
    protected boolean func_230363_a_(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_, SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_, Biome p_230363_8_, ChunkPos p_230363_9_, NoFeatureConfig p_230363_10_) {
        int i = p_230363_6_ >> 4;
        int j = p_230363_7_ >> 4;
        p_230363_5_.setSeed((long) (i ^ j << 4) ^ p_230363_3_);
        p_230363_5_.nextInt();
        for (int k = p_230363_6_ - 10; k <= p_230363_6_ + 10; ++k) {
            for (int l = p_230363_7_ - 10; l <= p_230363_7_ + 10; ++l) {
                ChunkPos chunkpos = Structure.field_236381_q_.func_236392_a_(p_230363_1_.func_235957_b_().func_236197_a_(Structure.field_236381_q_), p_230363_3_, p_230363_5_, k, l);
                if (k == chunkpos.x && l == chunkpos.z) {
                    return false;
                }
            }
        }

        return true;
    }

    public Structure.IStartFactory getStartFactory() {
        return EndShipwreckStructure.Start::new;
    }

    public GenerationStage.Decoration func_236396_f_() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }


    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> p_i225806_1_, int p_i225806_2_, int p_i225806_3_, MutableBoundingBox p_i225806_4_, int p_i225806_5_, long p_i225806_6_) {
            super(p_i225806_1_, p_i225806_2_, p_i225806_3_, p_i225806_4_, p_i225806_5_, p_i225806_6_);
        }

        public void func_230364_a_(ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig p_230364_6_) {

            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int surfaceY = generator.func_222531_c(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            int nope = rand.nextInt(100);
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
=======
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
>>>>>>> Stashed changes
            if (surfaceY >= 55) {
                BlockPos blockpos = new BlockPos(p_230364_3_ * 16, surfaceY - 2, p_230364_4_ * 16);

<<<<<<< Updated upstream
                EndShipwreckPieces.addStructure(templateManagerIn, blockpos, rotation, this.components, this.rand);
=======
                EndShipwreckPieces.start(p_230364_2_, blockpos, rotation, this.components, this.rand);

                this.recalculateStructureSize();
>>>>>>> Stashed changes
            }
            this.recalculateStructureSize();
        }
    }
}