package com.electron.endreborn;

import com.electron.endreborn.mobs.EndGuardMob;
import com.electron.endreborn.mobs.EndormanMob;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMobs {
    public static final EntityType<EndormanMob> ENDOR = EntityType.Builder.create(EndormanMob::new, EntityClassification.MONSTER).setTrackingRange(32).setUpdateInterval(3).setShouldReceiveVelocityUpdates(true).size(0.6F, 2.9F).build(prefix("enderman"));

    private static String prefix(String path) {
        return EndReborn.MODID + "." + path;
    }
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, EndReborn.MODID);

    public static final RegistryObject<EntityType<EndGuardMob>> ENDGUARD = ENTITY_TYPES
            .register("endguard", () -> EntityType.Builder
                    .create(EndGuardMob::new, EntityClassification.MONSTER)
                    .immuneToFire()
                    .setTrackingRange(32)
                    .setUpdateInterval(3)
                    .setShouldReceiveVelocityUpdates(true)
                    .size(1.55f, 3.4f)
                    .build(prefix("endguard")));
}