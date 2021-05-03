package com.electron.endreborn;

import com.electron.endreborn.mobs.EndGuardMob;
import com.electron.endreborn.mobs.EndormanMob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModMobs {
    public static EntityType<EndGuardMob> ENDGUARD;
    public static EntityType<EndormanMob> ENDOR;

    @SubscribeEvent
    public static void initEntities(RegistryEvent.Register<EntityType<?>> event) {
        registerEntity(ENDGUARD);
        registerEntity(ENDOR);
    }
    public static void preInitEntityTypes() {
        ENDGUARD = setupEntity("endguard", ENDGUARD, EndGuardMob::new, EntityClassification.MONSTER, 32, 1.55f, 3.4f, 2, false);
        ENDOR = setupEntity("enderman", ENDOR, EndormanMob::new, EntityClassification.MONSTER, 32, 0.6F, 2.9F, 3, true);
    }

    public static <T extends Entity> EntityType<T> setupEntity(String name, EntityType<T> entityType, EntityType.IFactory<T> entityTypeFactory,
                                                               EntityClassification classification, int range, float width, float height, int update, boolean velocity) {
        entityType = EntityType.Builder.create(entityTypeFactory, classification)
                .setTrackingRange(range)
                .size(width, height)
                .setUpdateInterval(update)
                .setShouldReceiveVelocityUpdates(velocity)
                .build(name);
        entityType.setRegistryName(new ResourceLocation(EndReborn.MODID, name));

        return entityType;
    }

    public static <T extends Entity> void registerEntity(EntityType<T> entityType) {
        ForgeRegistries.ENTITIES.register(entityType);
    }
}