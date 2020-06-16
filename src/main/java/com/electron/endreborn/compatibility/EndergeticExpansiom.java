package com.electron.endreborn.compatibility;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ObjectHolder;

public class EndergeticExpansiom {

    @ObjectHolder("endergetic:poise_grass_block")
    public static final Block POISEMOSS = null;

    @ObjectHolder("endergetic:poise_forest")
    public static final Biome POISE_BIOME = null;

    public static boolean isInstalled() {
        return ModList.get() != null && ModList.get().getModContainerById("endergetic").isPresent();
    }
}
