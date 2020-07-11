package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.BuriedTreasureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.IForgeRegistry;

public class NatureStructures {
    public static Structure<NoFeatureConfig> END_SHIPWRECK = new EndShipwreckStructure(NoFeatureConfig.field_236558_a_);
    public static Structure<NoFeatureConfig> END_CRYPT = new EndCryptStructure(NoFeatureConfig.field_236558_a_);

    public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> END_CRYPT_FEATURE = NatureStructures.END_CRYPT.func_236391_a_(NoFeatureConfig.field_236559_b_);
    public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> END_SHIPWRECK_FEATURE = NatureStructures.END_SHIPWRECK.func_236391_a_(NoFeatureConfig.field_236559_b_);

    public static final IStructurePieceType END_SHIPWRECK_PIECE = IStructurePieceType.register(EndShipwreckPieces.Piece::new, "end_shipwreck_piece");
    public static final IStructurePieceType END_CRYPT_PIECE = IStructurePieceType.register(EndShipwreckPieces.Piece::new, "end_crypt_piece");

    public static void registerStructures(IForgeRegistry<Structure<?>> registry) {
        registry.register(END_SHIPWRECK.setRegistryName(EndReborn.MODID, "end_shipwreck"));
        registry.register(END_CRYPT.setRegistryName(EndReborn.MODID, "end_crypt"));

    }
}