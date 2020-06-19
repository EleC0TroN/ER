package com.electron.endreborn.compatibility;

import net.minecraftforge.fml.ModList;

public class Mekanism {

    public static boolean isInstalled() {
        return ModList.get() != null && ModList.get().getModContainerById("mekanism").isPresent();
    }
}
