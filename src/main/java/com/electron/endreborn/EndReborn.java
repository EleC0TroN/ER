package com.electron.endreborn;

import com.electron.endreborn.compatibility.CompatTab;
import com.electron.endreborn.compatibility.ImmersiveEngineering;
import com.electron.endreborn.compatibility.Quark;
import com.electron.endreborn.world.NatureGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("endreborn")
public class EndReborn
{
    public static final String MODID = "endreborn";
	public static final ItemGroup ENDGROUP = new EndTab();
    public static final ItemGroup ENDOMPAT = new CompatTab();
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ResourceLocation END_SHIPWRECK_LOOT = new ResourceLocation(MODID, "chests/end_shipwreck");

    public EndReborn() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON_SPEC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modEventBus);
        ModMobs.preInitEntityTypes();
        ModItems.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        ImmersiveEngineering.ITEMS.register(modEventBus);
        Quark.ITEMS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
    	NatureGen.initGen();
    }
}
