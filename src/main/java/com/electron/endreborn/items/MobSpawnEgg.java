package com.electron.endreborn.items;

import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;

public class MobSpawnEgg extends SpawnEggItem {
    private final Lazy<? extends EntityType<?>> typeIn;

    public MobSpawnEgg(RegistryObject<? extends EntityType<?>> typemIn, int primaryColorIn, int secondaryColorIn, Properties builder) {
        super(null, primaryColorIn, secondaryColorIn, builder);
        this.typeIn = Lazy.of(typemIn);
    }
    @Override
    public EntityType<?> getType(CompoundNBT nbt) {
        return this.typeIn.get();
    }
}
