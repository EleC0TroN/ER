package com.electron.endreborn;

import com.electron.endreborn.compatibility.CompatTab;
import com.electron.endreborn.compatibility.ImmersiveEngineering;
import com.electron.endreborn.compatibility.Quark;
import com.electron.endreborn.compatibility.VanillaBoom;
import com.electron.endreborn.world.NatureGen;
import com.electron.endreborn.world.NatureStructures;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("endreborn")
public class EndReborn
{
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
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, this::onEntityRegistry);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Structure.class, this::onStructureRegistry);
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
        MinecraftForge.EVENT_BUS.register(this);
        if (ImmersiveEngineering.isInstalled()) {
            ImmersiveEngineering.ITEMS.register(modEventBus);
        }
        if (Quark.isInstalled()) {
            Quark.ITEMS.register(modEventBus);
        }
        if (VanillaBoom.isInstalled()) {
            VanillaBoom.ITEMS.register(modEventBus);
        }
    }

    @SubscribeEvent
    public void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
        IForgeRegistry<EntityType<?>> registry = event.getRegistry();
        ModMobs.registerEntity(registry);
    }
    @SubscribeEvent
    public void onStructureRegistry(final RegistryEvent.Register<Structure<?>> event) {

<<<<<<< Updated upstream
    @SubscribeEvent
    public void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
        IForgeRegistry<EntityType<?>> registry = event.getRegistry();
        ModMobs.registerEntity(registry);
    }

    @SubscribeEvent
    public void onStructureRegistry(final RegistryEvent.Register<Structure<?>> event) {
        IForgeRegistry<Structure<?>> registry = event.getRegistry();
        NatureStructures.registerStructures(registry);
    }
    private void setup(final FMLCommonSetupEvent event) {

=======
    }
    private void setup(final FMLCommonSetupEvent event) {
        NatureGen.initGen();
>>>>>>> Stashed changes
    }

}
