package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.BuriedTreasureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class NatureStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, EndReborn.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> END_SHIPWRECK = STRUCTURES.register("end_shipwreck", () -> new EndShipwreckStructure(NoFeatureConfig.field_236558_a_));
    public static final RegistryObject<Structure<NoFeatureConfig>> END_CRYPT = STRUCTURES.register("end_crypt", () -> new EndCryptStructure(NoFeatureConfig.field_236558_a_));

    public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> END_CRYPT_FEATURE = NatureStructures.END_CRYPT.get().func_236391_a_(NoFeatureConfig.field_236559_b_);
    public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> END_SHIPWRECK_FEATURE = NatureStructures.END_SHIPWRECK.get().func_236391_a_(NoFeatureConfig.field_236559_b_);

    public static final IStructurePieceType END_SHIPWRECK_PIECE = Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(EndReborn.MODID, "end_shipwreck_piece"), EndShipwreckPieces.Piece::new);
    public static final IStructurePieceType END_CRYPT_PIECE = Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(EndReborn.MODID, "end_crypt_piece"), EndCryptPieces.Piece::new);

}