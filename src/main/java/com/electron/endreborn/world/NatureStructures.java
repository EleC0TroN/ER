package com.electron.endreborn.world;

import com.electron.endreborn.EndReborn;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Locale;

//=====================================================
//If You are looking for a good structures tutorial, check this page
//https://github.com/TelepathicGrunt/StructureTutorialMod/blob/master/src
//=====================================================

public class NatureStructures {
    public static Structure<NoFeatureConfig> END_SHIPWRECK = new EndShipwreckStructure(NoFeatureConfig::deserialize);
    public static IStructurePieceType END_SHIPWRECK_PIECE = EndShipwreckPieces.Piece::new;

    public static void registerStructures(RegistryEvent.Register<Feature<?>> event)
    {
        IForgeRegistry<Feature<?>> registry = event.getRegistry();

        register(registry, END_SHIPWRECK, "end_shipwreck");
        registerPieces(END_SHIPWRECK_PIECE, "end_shipwreck_piece");
    }

    static IStructurePieceType registerPieces(IStructurePieceType structurePiece, String key)
    {
        return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
    }

    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey)
    {
        entry.setRegistryName(new ResourceLocation(EndReborn.MODID, registryKey));
        registry.register(entry);
        return entry;
    }
}
