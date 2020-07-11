package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
<<<<<<< Updated upstream
import com.google.common.collect.ImmutableMap;
=======
>>>>>>> Stashed changes
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
<<<<<<< Updated upstream
import net.minecraft.world.gen.feature.structure.*;
=======
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
>>>>>>> Stashed changes
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EndShipwreckPieces {
    private static final ResourceLocation[] SHIP = new ResourceLocation[]{new ResourceLocation(EndReborn.MODID + ":end_shipwreck"), new ResourceLocation(EndReborn.MODID + ":end_beacon")};
<<<<<<< Updated upstream
    private static final BlockPos OFFSET = new BlockPos(4, 0, 15);
    public static void addStructure(TemplateManager p_207617_0_, BlockPos p_207617_1_, Rotation p_207617_2_, List<StructurePiece> p_207617_3_, Random random) {
=======

    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {

        int x = pos.getX();
        int z = pos.getZ();

>>>>>>> Stashed changes
        ResourceLocation resourcelocation = SHIP[random.nextInt(SHIP.length)];
        int nope = random.nextInt(100);
        if(nope >= 50) {
            p_207617_3_.add(new EndShipwreckPieces.Piece(p_207617_0_, resourcelocation, p_207617_1_, p_207617_2_, 0));
        }
    }


<<<<<<< Updated upstream
    public static class Piece extends TemplateStructurePiece {
        private final ResourceLocation field_207615_d;
        private final Rotation field_207616_e;

        public Piece(TemplateManager p_i49313_1_, ResourceLocation p_i49313_2_, BlockPos p_i49313_3_, Rotation p_i49313_4_, int p_i49313_5_) {
=======
        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn)
        {
>>>>>>> Stashed changes
            super(NatureStructures.END_SHIPWRECK_PIECE, 0);
            this.field_207615_d = p_i49313_2_;
            BlockPos blockpos = EndShipwreckPieces.OFFSET;
            this.templatePosition = p_i49313_3_.add(blockpos.getX(), blockpos.getY() - p_i49313_5_, blockpos.getZ());
            this.field_207616_e = p_i49313_4_;
            this.func_207614_a(p_i49313_1_);
        }

        public Piece(TemplateManager p_i50566_1_, CompoundNBT p_i50566_2_) {
            super(NatureStructures.END_SHIPWRECK_PIECE, p_i50566_2_);
            this.field_207615_d = new ResourceLocation(p_i50566_2_.getString("Template"));
            this.field_207616_e = Rotation.valueOf(p_i50566_2_.getString("Rot"));
            this.func_207614_a(p_i50566_1_);
        }

        private void func_207614_a(TemplateManager p_207614_1_) {
            Template template = p_207614_1_.getTemplateDefaulted(this.field_207615_d);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.field_207616_e).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readAdditional(CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.field_207615_d.toString());
            tagCompound.putString("Rot", this.field_207616_e.name());
        }

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
            if (function.startsWith("Chest")) {
                BlockPos blockpos = pos.down();
                if (sbb.isVecInside(blockpos)) {
                    LockableLootTileEntity.setLootTable(worldIn, rand, blockpos, LootTables.CHESTS_NETHER_BRIDGE);
                }
            }
        }

<<<<<<< Updated upstream
        @Override
        public boolean func_230383_a_(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator p_230383_3_, Random p_230383_4_, MutableBoundingBox p_230383_5_, ChunkPos p_230383_6_, BlockPos p_230383_7_) {
            BlockPos blockpos = this.template.getSize();

            BlockPos blockpos1 = this.templatePosition;
            int i = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, blockpos1.getX(), blockpos1.getZ());
            BlockPos blockpos2 = this.templatePosition;
            this.templatePosition = this.templatePosition.add(0, i - 90 - 1, 0);
            boolean flag = super.func_230383_a_(worldIn, p_230383_2_, p_230383_3_, p_230383_4_, p_230383_5_, p_230383_6_, p_230383_7_);

            this.templatePosition = blockpos2;

=======
        public boolean func_230383_a_(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator chunk, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos, BlockPos blockPos)
        {
            BlockPos blockpos = this.template.getSize();
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));

            boolean flag = super.func_230383_a_(worldIn, p_230383_2_, chunk, randomIn, structureBoundingBoxIn, chunkPos, blockPos);
>>>>>>> Stashed changes
            return flag;
        }
    }
}