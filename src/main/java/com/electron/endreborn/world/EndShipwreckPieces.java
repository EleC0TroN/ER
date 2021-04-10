package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EndShipwreckPieces {

    private static final ResourceLocation SHIPWRECK = new ResourceLocation(EndReborn.MODID + ":end_shipwreck");
    private static final ResourceLocation BEACON = new ResourceLocation(EndReborn.MODID + ":end_beacon");
    private static final Map<ResourceLocation, BlockPos> RES = ImmutableMap.of(SHIPWRECK, BlockPos.ZERO, BEACON, BlockPos.ZERO);

    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        double chance = random.nextDouble();
        if (chance < 0.5D) {
            pieceList.add(new EndShipwreckPieces.Piece(templateManager, SHIPWRECK, pos, rotation));
        }
        if (chance > 0.5D) {
            pieceList.add(new EndShipwreckPieces.Piece(templateManager, BEACON, pos, rotation));
        }
    }

    public static class Piece extends TemplateStructurePiece {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
            super(StructurePieces.END_SHIPWRECK_PIECE, 0);
            this.resourceLocation = resourceLocationIn;
            this.templatePosition = pos;
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(StructurePieces.END_SHIPWRECK_PIECE, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.get(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).setRotationPivot(BlockPos.ZERO).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_AND_AIR);
            this.setup(template, this.templatePosition, placementsettings);
        }

        protected void addAdditionalSaveData(CompoundNBT tagCompound) {
            super.addAdditionalSaveData(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {
            if (function.startsWith("Chest")) {
                BlockPos blockpos = pos.below();
                if (sbb.isInside(blockpos)) {
                    LockableLootTileEntity.setLootTable(worldIn, rand, blockpos, EndReborn.END_SHIPWRECK_LOOT);
                }
            }
        }
        @Override
        public boolean postProcess(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator chunk, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos, BlockPos blockPos) {
            BlockPos blockpos = this.template.getSize();
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.templatePosition.offset(Template.calculateRelativePosition(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));

            boolean flag = super.postProcess(worldIn, p_230383_2_, chunk, randomIn, structureBoundingBoxIn, chunkPos, blockPos);
            return flag;
        }
    }
}