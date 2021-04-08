package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructurePieces {
    public static IStructurePieceType END_SHIPWRECK_PIECE;
    public static IStructurePieceType END_CRYPT_PIECE;

    public static void init() {
        END_SHIPWRECK_PIECE = Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(EndReborn.MODID, "end_shipwreck_piece"), EndShipwreckPieces.Piece::new);
        END_CRYPT_PIECE = Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(EndReborn.MODID, "end_crypt_piece"), EndCryptPieces.Piece::new);
    }
}
