package com.electron.endreborn;

import com.electron.endreborn.mobs.EndGuardMob;
import com.electron.endreborn.mobs.EndormanMob;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModMobs {
    private static String prefix(String path) {
        return EndReborn.MODID + "." + path;
    }
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, EndReborn.MODID);

    public static final RegistryObject<EntityType<EndGuardMob>> ENDGUARD = ENTITY_TYPES
            .register("endguard", () -> EntityType.Builder
                    .of(EndGuardMob::new, EntityClassification.MONSTER)
                    .fireImmune()
                    .setTrackingRange(32)
                    .setUpdateInterval(3)
                    .setShouldReceiveVelocityUpdates(true)
                    .sized(1.55f, 3.4f)
                    .build(prefix("endguard")));
    public static final RegistryObject<EntityType<EndormanMob>> ENDOR = ENTITY_TYPES
            .register("enderman", () -> EntityType.Builder
                    .of(EndormanMob::new, EntityClassification.MONSTER)
                    .setTrackingRange(32)
                    .setUpdateInterval(3)
                    .setShouldReceiveVelocityUpdates(true)
                    .sized(0.6F, 2.9F)
                    .build(prefix("enderman")));
}