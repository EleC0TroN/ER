package com.electron.endreborn;

import com.electron.endreborn.compatibility.CompatTab;
import com.electron.endreborn.compatibility.ImmersiveEngineering;
import com.electron.endreborn.compatibility.Quark;
import com.electron.endreborn.compatibility.VanillaBoom;
import com.electron.endreborn.compatibility.mekanism.Mekanism;
import com.electron.endreborn.mobs.EndGuardMob;
import com.electron.endreborn.world.NatureGen;
import com.electron.endreborn.world.NatureStructures;
import com.electron.endreborn.world.StructurePieces;
import com.mojang.serialization.Codec;
import mekanism.api.chemical.slurry.Slurry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";
	public static final ItemGroup ENDGROUP = new EndTab();
    public static final ItemGroup ENDOMPAT = new CompatTab();
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public EndReborn() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON_SPEC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModMobs.ENTITY_TYPES.register(modEventBus);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, this::onEntityRegistry);
        MinecraftForge.EVENT_BUS.register(this);
        StructurePieces.init();
        if (ModList.get().isLoaded("mekanism")) {
            IEventBus modEventBus2 = FMLJavaModLoadingContext.get().getModEventBus();
            Mekanism.ITEMS.register(modEventBus2);
            modEventBus.addGenericListener(Slurry.class, this::registerSlurries);
        }
        ImmersiveEngineering.ITEMS.register(modEventBus);
        VanillaBoom.ITEMS.register(modEventBus);
        Quark.ITEMS.register(modEventBus);

        modEventBus.addGenericListener(Structure.class, this::onRegisterStructures);
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
    }

    public void registerSlurries(RegistryEvent.Register<Slurry> event) {
        event.getRegistry().register(Mekanism.CLEAN_TUNGSTEN_SLURRY);
        event.getRegistry().register(Mekanism.DIRTY_TUNGSTEN_SLURRY);
    }
    public void onRegisterStructures(final RegistryEvent.Register<Structure<?>> event) {
        NatureStructures.registerStructures(event);
        NatureStructures.registerConfiguredStructures();
    }
    public void biomeModification(final BiomeLoadingEvent event) {
        event.getGeneration().getStructures().add(() -> NatureStructures.END_SHIPWRECK_CONFIGURED);
    }

    @SubscribeEvent
    public void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
        GlobalEntityTypeAttributes.put(ModMobs.ENDGUARD.get(), EndGuardMob.func_234200_m_().create());
    }
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();
            if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.getDimensionKey().equals(World.OVERWORLD)){
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
            tempMap.put(NatureStructures.END_SHIPWRECK, DimensionStructuresSettings.field_236191_b_.get(NatureStructures.END_SHIPWRECK));
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
        }
    }
    private void setup(final FMLCommonSetupEvent event) {
        new NatureGen();
    }
}
