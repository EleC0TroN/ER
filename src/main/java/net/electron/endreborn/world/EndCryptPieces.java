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
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EndCryptPieces {
    private static final Identifier TOP = new Identifier(EndReborn.MODID + ":end_crypt_top");
    private static final Identifier FRONT = new Identifier(EndReborn.MODID + ":end_crypt_front");
    private static final Identifier CROSS = new Identifier(EndReborn.MODID + ":end_crypt_cross");
    private static final Identifier ROOM = new Identifier(EndReborn.MODID + ":end_crypt_room");
    private static final Identifier LEFT = new Identifier(EndReborn.MODID + ":end_crypt_left");

    private static final Map<Identifier, BlockPos> RES = ImmutableMap.of(TOP, BlockPos.ORIGIN, FRONT, BlockPos.ORIGIN, LEFT, BlockPos.ORIGIN, CROSS, BlockPos.ORIGIN, ROOM, BlockPos.ORIGIN);

    public static void start(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces, Random random) {
        int x = pos.getX();
        int z = pos.getZ();
        int r = random.nextInt(6) + 2;
        int c = 0;

        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos rotationOffSet1 = new BlockPos(-1, 0, -1).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        BlockPos blockpos1 = rotationOffSet1.add(x, pos.getY(), z);
        pieces.add(new EndCryptPieces.Piece(manager, TOP, blockpos1, rotation));
        for (int j = r; j > 0; --j) {
            int r1 = random.nextInt(13);
            if (r1 >= 0 && r1 < 7) {
                c = c+1;
                rotationOffSet = new BlockPos(0, 0, -7 * c).rotate(rotation);
                blockpos = rotationOffSet.add(x, pos.getY(), z);
                pieces.add(new EndCryptPieces.Piece(manager, FRONT, blockpos, rotation));
            } else if (r1 >= 7 && r1 < 13) {
                c = c+1;
                int t = random.nextInt(7);
                int r2 = random.nextInt(10);
                int r3 = random.nextInt(4);
                int c1 = 0;
                int c2 = 0;

                rotationOffSet = new BlockPos(0, 0, -7 * c).rotate(rotation);
                blockpos = rotationOffSet.add(x, pos.getY(), z);
                pieces.add(new EndCryptPieces.Piece(manager, CROSS, blockpos, rotation));
                if (r3 >= 3) {
                    for (int k = t; k > 0; --k) {
                        if (r2 >= 1 && r2 < 5) {
                            c1 = c1 + 1;
                            rotationOffSet = new BlockPos(-7 * c1, 0, -7 * c).rotate(rotation);
                            blockpos = rotationOffSet.add(x, pos.getY(), z);
                            pieces.add(new EndCryptPieces.Piece(manager, LEFT, blockpos, rotation));
                        } else if (r2 >= 7 && r2 <= 10) {
                            c1 = c1 + 1;
                            rotationOffSet = new BlockPos(-7 * c1, 0, -7 * c).rotate(rotation);
                            blockpos = rotationOffSet.add(x, pos.getY(), z);
                            pieces.add(new EndCryptPieces.Piece(manager, ROOM, blockpos, rotation));
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
                            pieces.add(new EndCryptPieces.Piece(manager, LEFT, blockpos, rotation));
                        } else if (r4 <=1){
                            c2 = c2 + 1;
                            rotationOffSet = new BlockPos(7 * c2, 0, -7 * c).rotate(rotation);
                            blockpos = rotationOffSet.add(x, pos.getY(), z);
                            pieces.add(new EndCryptPieces.Piece(manager, ROOM, blockpos, rotation));
                            i = 0;
                        }
                    }
                }
            }
        }
        c = 0;
    }

    public static class Piece extends SimpleStructurePiece {
        private final Identifier template;
        private final BlockRotation rotation;

        public Piece(StructureManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation) {
            super(NatureStructures.END_CRYPT_PIECE, 0);
            this.template = identifier;
            BlockPos blockPos = BlockPos.ORIGIN;
            this.pos = pos.add(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            this.rotation = rotation;
            this.initializeStructureData(manager);
        }

        public Piece(StructureManager manager, CompoundTag tag) {
            super(NatureStructures.END_CRYPT_PIECE, tag);
            this.template = new Identifier(tag.getString("Template"));
            this.rotation = BlockRotation.valueOf(tag.getString("Rot"));
            this.initializeStructureData(manager);
        }

        private void initializeStructureData(StructureManager manager) {
            Structure structure = manager.getStructureOrBlank(this.template);
            StructurePlacementData structurePlacementData = (new StructurePlacementData()).setRotation(this.rotation).setMirror(BlockMirror.NONE).setPosition((BlockPos)EndCryptPieces.RES.get(this.template)).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
            this.setStructureData(structure, this.pos, structurePlacementData);
        }

        protected void toNbt(CompoundTag tag) {
            super.toNbt(tag);
            tag.putString("Template", this.template.toString());
            tag.putString("Rot", this.rotation.name());
        }
        protected void handleMetadata(String metadata, BlockPos pos, WorldAccess world, Random random, BlockBox boundingBox) {
            if ("Chest".equals(metadata)) {
                BlockEntity blockEntity = world.getBlockEntity(pos.up());
                if (blockEntity instanceof ChestBlockEntity) {
                    ((ChestBlockEntity) blockEntity).setLootTable(LootTables.END_CITY_TREASURE_CHEST, random.nextLong());
                }
            }
        }
        public boolean generate(ServerWorldAccess serverWorldAccess, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            boolean bl = super.generate(serverWorldAccess, structureAccessor, chunkGenerator, random, boundingBox, chunkPos, blockPos);
            return bl;
        }
    }
}
