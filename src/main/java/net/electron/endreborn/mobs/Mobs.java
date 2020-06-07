package net.electron.endreborn.mobs;


import net.fabricmc.fabric.api.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.List;


public class Mobs {

        public static EntityType<EndGuardMob> ENDGUARD = Registry.register(Registry.ENTITY_TYPE, new Identifier("endreborn", "endguard"), FabricEntityTypeBuilder.<EndGuardMob>create(SpawnGroup.CREATURE, EndGuardMob::new).size(1.7f, 3.4f).setImmuneToFire().build());
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(Mobs.ENDGUARD, EndGuardMob.createEndguardAttributes());
    }

}