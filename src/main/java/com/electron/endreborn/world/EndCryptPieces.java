package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import com.electron.endreborn.ModConfigs;
import com.google.common.collect.ImmutableMap;
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

public class EndCryptPieces {

    private static final ResourceLocation TOP = new ResourceLocation(EndReborn.MODID + ":end_crypt_top");
    private static final ResourceLocation FRONT = new ResourceLocation(EndReborn.MODID + ":end_crypt_front");
    private static final ResourceLocation CROSS = new ResourceLocation(EndReborn.MODID + ":end_crypt_cross");
    private static final ResourceLocation ROOM = new ResourceLocation(EndReborn.MODID + ":end_crypt_room");
    private static final ResourceLocation LEFT = new ResourceLocation(EndReborn.MODID + ":end_crypt_left");

    private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(TOP, new BlockPos(0, 1, 0), FRONT, new BlockPos(0, 1, 0), LEFT, new BlockPos(0, 1, 0), CROSS, new BlockPos(0, 1, 0), ROOM, new BlockPos(0, 1, 0));


    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random)
    {
        int x = pos.getX();
        int z = pos.getZ();
        int r = random.nextInt(ModConfigs.COMMON.balance.crypt_size.get()) + 2;
        int c = 0;

        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new EndCryptPieces.Piece(templateManager, TOP, blockpos, rotation));
        for (int j = r; j > 0; --j) {
            int r1 = random.nextInt(13);
            if (r1 >= 0 && r1 < 7) {
                c = c+1;
                rotationOffSet = new BlockPos(0, 0, -7 * c).rotate(rotation);
                blockpos = rotationOffSet.add(x, pos.getY(), z);
                pieceList.add(new EndCryptPieces.Piece(templateManager, FRONT, blockpos, rotation));
            } else if (r1 >= 7 && r1 < 13) {
                c = c+1;
                int t = random.nextInt(7);
                int r2 = random.nextInt(10);
                int r3 = random.nextInt(4);
                int c1 = 0;
                int c2 = 0;

                rotationOffSet = new BlockPos(0, 0, -7 * c).rotate(rotation);
                blockpos = rotationOffSet.add(x, pos.getY(), z);
                pieceList.add(new EndCryptPieces.Piece(templateManager, CROSS, blockpos, rotation));
                if (r3 >= 3) {
                    for (int k = t; k > 0; --k) {
                        if (r2 >= 1 && r2 < 5) {
                            c1 = c1 + 1;
                            rotationOffSet = new BlockPos(-7 * c1, 0, -7 * c).rotate(rotation);
                            blockpos = rotationOffSet.add(x, pos.getY(), z);
                            pieceList.add(new EndCryptPieces.Piece(templateManager, LEFT, blockpos, rotation));
                        } else if (r2 >= 7 && r2 <= 10) {
                            c1 = c1 + 1;
                            rotationOffSet = new BlockPos(-7 * c1, 0, -7 * c).rotate(rotation);
                            blockpos = rotationOffSet.add(x, pos.getY(), z);
                            pieceList.add(new EndCryptPieces.Piece(templateManager, ROOM, blockpos, rotation));
                            k = 0;
                        }
                    }
                } else if (r3 < 3){
                    int r4 = random.nextInt(5);
                    for (int i = t; i > 0; --i) {
                        if (r4 > 1) {
                            c2 = c2 + 1;
                            rotationOffSet = new BlockPos(7 * c2, 0, -7 * c).rotate(rotation);
                            blockpos = rotationOffSet.add(x, pos.getY(), z);
                            pieceList.add(new EndCryptPieces.Piece(templateManager, LEFT, blockpos, rotation));
                        } else if (r4 <=1){
                            c2 = c2 + 1;
                            rotationOffSet = new BlockPos(7 * c2, 0, -7 * c).rotate(rotation);
                            blockpos = rotationOffSet.add(x, pos.getY(), z);
                            pieceList.add(new EndCryptPieces.Piece(templateManager, ROOM, blockpos, rotation));
                            i = 0;
                        }
                    }
                }
            }
        }
        c = 0;
    }

    public static class Piece extends TemplateStructurePiece
    {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn)
        {
            super(NatureStructures.END_CRYPT_PIECE, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = EndCryptPieces.OFFSET.get(resourceLocation);
            this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(NatureStructures.END_CRYPT_PIECE, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void readAdditional(CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());
        }

        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
            if (function.startsWith("Chest")) {
                BlockPos blockpos = pos.up();
                if (sbb.isVecInside(blockpos)) {
                    LockableLootTileEntity.setLootTable(worldIn, rand, blockpos, LootTables.CHESTS_END_CITY_TREASURE);
                }
            }
        }


        public boolean func_230383_a_(ISeedReader worldIn, StructureManager p_230383_2_, ChunkGenerator chunk, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos, BlockPos blockPos)
        {
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            BlockPos blockpos = EndCryptPieces.OFFSET.get(this.resourceLocation);
            this.templatePosition.add(Template.transformedBlockPos(placementsettings, new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));

            return super.func_230383_a_(worldIn, p_230383_2_, chunk, randomIn, structureBoundingBoxIn, chunkPos, blockPos);
        }
    }

}
