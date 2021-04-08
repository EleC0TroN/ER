package com.electron.endreborn;

import com.electron.endreborn.compatibility.CompatTab;
import com.electron.endreborn.compatibility.ImmersiveEngineering;
import com.electron.endreborn.compatibility.Quark;
import com.electron.endreborn.compatibility.VanillaBoom;
import com.electron.endreborn.compatibility.mekanism.Mekanism;
import com.electron.endreborn.mobs.EndGuardMob;
import com.electron.endreborn.mobs.EndormanMob;
import com.electron.endreborn.world.NatureFeatures;
import com.electron.endreborn.world.NatureGen;
import com.electron.endreborn.world.NatureStructures;
import com.electron.endreborn.world.StructurePieces;
import mekanism.api.chemical.slurry.Slurry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("endreborn")
public class EndReborn {
    public static final String MODID = "endreborn";
	public static final ItemGroup ENDGROUP = new EndTab();
    public static final ItemGroup ENDOMPAT = new CompatTab();
    public static final ResourceLocation END_SHIPWRECK_LOOT = new ResourceLocation(MODID, "chests/end_shipwreck");
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public EndReborn() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON_SPEC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModMobs.ENTITY_TYPES.register(modEventBus);
        NatureStructures.STRUCTURE_FEATURES.register(modEventBus);
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

        forgeBus.addListener(NatureGen::onBiomeLoad);
        forgeBus.addListener(NatureGen::addStructures);
        forgeBus.addListener(NatureStructures::addDimensionSpacing);
    }

    public void registerSlurries(RegistryEvent.Register<Slurry> event) {
        event.getRegistry().register(Mekanism.CLEAN_TUNGSTEN_SLURRY);
        event.getRegistry().register(Mekanism.DIRTY_TUNGSTEN_SLURRY);
    }

    @SubscribeEvent
    public void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
        GlobalEntityTypeAttributes.put(ModMobs.ENDGUARD.get(), EndGuardMob.func_234200_m_().create());
        GlobalEntityTypeAttributes.put(ModMobs.ENDOR.get(), EndormanMob.func_234287_m_().create());
    }

    private void setup(final FMLCommonSetupEvent event) {
        new NatureGen();
        event.enqueueWork(() -> {
            NatureStructures.setupStructures();
            NatureFeatures.registerConfiguredFeatures();
        });
    }
}
