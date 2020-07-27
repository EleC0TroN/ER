package com.electron.endreborn.compatibility.mekanism;

import com.electron.endreborn.EndReborn;
import mekanism.api.chemical.slurry.Slurry;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class Mekanism {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndReborn.MODID);

    public static final RegistryObject<Item> TUNGSTEN_QIO_DRIVE = ITEMS.register("tungsten_qio_drive", () -> new ItemCompatQIO(QIOCompatTier.ENDOMATIC, new Item.Properties().group(EndReborn.ENDOMPAT)));

    @Nonnull
    public static final Slurry CLEAN_TUNGSTEN_SLURRY = new TungstenCleanSlurry();
    @Nonnull
    public static final Slurry DIRTY_TUNGSTEN_SLURRY = new TungstenDirtySlurry();

}