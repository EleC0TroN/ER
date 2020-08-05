package net.electron.endreborn.mobs;

import net.fabricmc.fabric.api.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Mobs {
    public static EntityType<EndGuardMob> ENDGUARD = Registry.register(Registry.ENTITY_TYPE, new Identifier("endreborn", "endguard"), FabricEntityTypeBuilder.<EndGuardMob>create(SpawnGroup.CREATURE, EndGuardMob::new).size(1.55f, 3.4f).trackable(32, 3).setImmuneToFire().build());
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(Mobs.ENDGUARD, EndGuardMob.createEndguardAttributes());
    }
}