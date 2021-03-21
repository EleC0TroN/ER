package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
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
import net.minecraft.world.gen.feature.structure.IglooStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class EndShipwreckStructure extends Structure<NoFeatureConfig> {
    public EndShipwreckStructure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }
    
    public String getStructureName() {
        return EndReborn.MODID + ":end_shipwreck";
    }

    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return EndShipwreckStructure.Start::new;
    }

    public GenerationStage.Decoration func_236396_f_() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        public void func_230364_a_(DynamicRegistries p_230364_1_, ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig p_230364_6_) {
            int surfaceY = generator.getHeight(chunkX * 16, chunkZ * 16, Heightmap.Type.WORLD_SURFACE_WG);
            if (surfaceY >= 55) {
                BlockPos blockpos = new BlockPos(chunkX * 16, surfaceY-3, chunkZ * 16);
                Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
                EndShipwreckPieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);
            }
            this.recalculateStructureSize();
        }
    }
}