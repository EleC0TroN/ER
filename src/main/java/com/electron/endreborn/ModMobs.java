package com.electron.endreborn;

import com.electron.endreborn.mobs.EndGuardMob;
import com.electron.endreborn.mobs.EndormanMob;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModMobs {
    public static final EntityType<EndGuardMob> ENDGUARD = EntityType.Builder.create(EndGuardMob::new, EntityClassification.MONSTER).setTrackingRange(32).setUpdateInterval(3).setShouldReceiveVelocityUpdates(true).size(1.55f, 3.4f).build(prefix("endguard"));
    public static final EntityType<EndormanMob> ENDOR = EntityType.Builder.create(EndormanMob::new, EntityClassification.MONSTER).setTrackingRange(32).setUpdateInterval(3).setShouldReceiveVelocityUpdates(true).size(0.6F, 2.9F).build(prefix("enderman"));
    @SubscribeEvent
    public static void registerEntity(IForgeRegistry<EntityType<?>> event) {
        GlobalEntityTypeAttributes.put(ENDGUARD, EndGuardMob.func_234200_m_().func_233813_a_());
        GlobalEntityTypeAttributes.put(ENDOR, EndormanMob.func_234287_m_().func_233813_a_());

        event.register(ENDGUARD.setRegistryName("endguard"));
        event.register(ENDOR.setRegistryName("enderman"));

    }
    private static String prefix(String path) {
        return EndReborn.MODID + "." + path;
    }
}