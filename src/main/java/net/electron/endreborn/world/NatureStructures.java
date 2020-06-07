package net.electron.endreborn.world;

import net.minecraft.structure.MineshaftGenerator;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;

import java.util.Locale;

public class NatureStructures {

    public static StructurePieceType END_CRYPT_PIECE = registerPieces(EndCryptPieces.Piece::new, "end_crypt_piece");
    public static final StructureFeature<?> END_CRYPT = Registry.register(Registry.STRUCTURE_FEATURE, "end_crypt", null);

    static StructurePieceType registerPieces(StructurePieceType pieceType, String id) {
        return (StructurePieceType) Registry.register(Registry.STRUCTURE_PIECE, id.toLowerCase(Locale.ROOT), pieceType);
    }

}
