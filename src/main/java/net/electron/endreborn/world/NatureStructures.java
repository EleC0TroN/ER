package net.electron.endreborn.world;

import net.earthcomputer.libstructure.LibStructure;
import net.electron.endreborn.EndReborn;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class NatureStructures {
    public static StructureFeature<DefaultFeatureConfig> END_SHIPWRECK = new EndShipwreckStructure(DefaultFeatureConfig.CODEC);
    public static StructureFeature<DefaultFeatureConfig> END_CRYPT = new EndCryptStructure(DefaultFeatureConfig.CODEC);

    public static StructurePieceType END_SHIPWRECK_PIECE = EndShipwreckPieces.Piece::new;
    public static final StructurePieceType END_CRYPT_PIECE = EndCryptPieces.Piece::new;

    public static void registerStructures() {
        LibStructure.registerStructure(new Identifier(EndReborn.MODID, "end_shipwreck"), NatureStructures.END_SHIPWRECK, GenerationStep.Feature.SURFACE_STRUCTURES, new StructureConfig(32, 10, 5772459), NatureStructures.END_SHIPWRECK.configure(FeatureConfig.DEFAULT));
        Registry.register(Registry.STRUCTURE_PIECE, "end_shipwreck_piece", END_SHIPWRECK_PIECE);
        LibStructure.registerStructure(new Identifier(EndReborn.MODID, "end_crypt"), NatureStructures.END_CRYPT, GenerationStep.Feature.UNDERGROUND_STRUCTURES, new StructureConfig(36, 10, 6872459), NatureStructures.END_CRYPT.configure(FeatureConfig.DEFAULT));
        Registry.register(Registry.STRUCTURE_PIECE, "end_crypt_piece", END_CRYPT_PIECE);

    }
}
