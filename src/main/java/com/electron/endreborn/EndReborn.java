package com.electron.endreborn;

import com.electron.endreborn.world.NatureGen;
import net.minecraft.item.ItemGroup;
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
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public EndReborn() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.COMMON_SPEC);
        ModBlocks.BLOCKS.register(modEventBus);
        ModMobs.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {
    	NatureGen.initGen();
        NatureGen.initOres();
        ModMobs.registerEntityWorldSpawns();
    }
}
