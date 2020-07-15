package com.electron.endreborn.compatibility.mekanism;

import com.electron.endreborn.EndReborn;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.slurry.EmptySlurry;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import mekanism.api.math.FloatingLong;
import mekanism.api.math.FloatingLongSupplier;
import mekanism.common.capabilities.energy.BasicEnergyContainer;
import mekanism.common.config.MekanismConfig;
import mekanism.common.config.value.CachedFloatingLongValue;
import mekanism.common.item.ItemEnergized;
import mekanism.common.item.ItemQIODrive;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.SlurryDeferredRegister;
import mekanism.common.registration.impl.SlurryRegistryObject;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;
import java.util.Map;

public class Mekanism {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndReborn.MODID);

    public static final RegistryObject<Item> TUNGSTEN_QIO_DRIVE = ITEMS.register("tungsten_qio_drive", () -> new ItemCompatQIO(QIOCompatTier.ENDOMATIC, new Item.Properties().group(EndReborn.ENDOMPAT)));

    @Nonnull
    public static final Slurry CLEAN_TUNGSTEN_SLURRY = new TungstenCleanSlurry();
    @Nonnull
    public static final Slurry DIRTY_TUNGSTEN_SLURRY = new TungstenDirtySlurry();

    public static boolean isInstalled() {
        return ModList.get() != null && ModList.get().getModContainerById("mekanism").isPresent();
    }
}
