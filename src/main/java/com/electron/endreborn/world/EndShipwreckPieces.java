package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;

public class EndShipwreckPieces {
    private static final BlockPos OFFSET = new BlockPos(4, 0, 15);
    private static final ResourceLocation[] SHIP = new ResourceLocation[]{new ResourceLocation(EndReborn.MODID + ":end_shipwreck"), new ResourceLocation(EndReborn.MODID + ":end_beacon")};

    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {

        int x = pos.getX();
        int z = pos.getZ();

        ResourceLocation resourcelocation = SHIP[random.nextInt(SHIP.length)];
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndShipwreckPieces.Piece(templateManager, resourcelocation, blockpos, rotation));

    }

    public static class Piece extends TemplateStructurePiece
    {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn)
        {
            super(NatureStructures.END_SHIPWRECK_PIECE, 0);
            this.resourceLocation = resourceLocationIn;

            this.templatePosition = pos;
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound)
        {
            super(NatureStructures.END_SHIPWRECK_PIECE, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }


        private void setupPiece(TemplateManager templateManager)
        {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).setCenterOffset(EndShipwreckPieces.OFFSET).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void readAdditional(CompoundNBT tagCompound)
        {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }


        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
            if (function.startsWith("Chest")) {
                BlockPos blockpos = pos.down();
                if (sbb.isVecInside(blockpos)) {
                    LockableLootTileEntity.setLootTable(worldIn, rand, blockpos, LootTables.CHESTS_NETHER_BRIDGE);
                }
            }
        }

        public boolean func_230383_a_(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator chunk, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos, BlockPos blockPos)
        {
            BlockPos blockpos = this.template.getSize();
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));

            boolean flag = super.func_230383_a_(worldIn, p_230383_2_, chunk, randomIn, structureBoundingBoxIn, chunkPos, blockPos);
            return flag;
        }
    }

}