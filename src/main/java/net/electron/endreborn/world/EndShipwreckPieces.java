package net.electron.endreborn.world;

import com.google.common.collect.ImmutableMap;
import net.electron.endreborn.EndReborn;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EndShipwreckPieces {
    private static final Identifier SHIPWRECK = new Identifier(EndReborn.MODID + ":end_shipwreck");
    private static final Identifier BEACON = new Identifier(EndReborn.MODID + ":end_beacon");
    public static final Map<Identifier, BlockPos> RES = ImmutableMap.of(SHIPWRECK, BlockPos.ORIGIN, BEACON, BlockPos.ORIGIN);

    public static void start(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces, Random random) {
        double chance = random.nextDouble();
        if (chance < 0.5D) {
            pieces.add(new EndShipwreckPieces.Piece(manager, SHIPWRECK, pos, rotation));
        }
        if (chance > 0.5D) {
            pieces.add(new EndShipwreckPieces.Piece(manager, BEACON, pos, rotation));
        }
    }

    public static class Piece extends SimpleStructurePiece {
        private final Identifier template;
        private final BlockRotation rotation;

        public Piece(StructureManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation) {
            super(NatureStructures.END_SHIPWRECK_PIECE, 0);
            this.template = identifier;
            BlockPos blockPos = BlockPos.ORIGIN;
            this.pos = pos.add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            this.rotation = rotation;
            this.initializeStructureData(manager);
        }

        public Piece(StructureManager manager, CompoundTag tag) {
            super(NatureStructures.END_SHIPWRECK_PIECE, tag);
            this.template = new Identifier(tag.getString("Template"));
            this.rotation = BlockRotation.valueOf(tag.getString("Rot"));
            this.initializeStructureData(manager);
        }

        private void initializeStructureData(StructureManager manager) {
            Structure structure = manager.getStructureOrBlank(this.template);
            StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(this.rotation).setMirror(BlockMirror.NONE).setPosition((BlockPos)EndShipwreckPieces.RES.get(this.template)).addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
            this.setStructureData(structure, this.pos, structurePlacementData);
        }

        protected void toNbt(CompoundTag tag) {
            super.toNbt(tag);
            tag.putString("Template", this.template.toString());
            tag.putString("Rot", this.rotation.name());
        }
        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {
            if ("Chest".equals(metadata)) {
                BlockEntity blockEntity = world.getBlockEntity(pos.down());
                if (blockEntity instanceof ChestBlockEntity) {
                    ((ChestBlockEntity)blockEntity).setLootTable(LootTables.NETHER_BRIDGE_CHEST, random.nextLong());
                }
            }
        }
        public boolean generate(StructureWorldAccess serverWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            boolean bl = super.generate(serverWorldAccess, structureAccessor, chunkGenerator, random, boundingBox, chunkPos, blockPos);
            return bl;
        }
    }
}