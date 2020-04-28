package com.electron.endreborn;

import com.electron.endreborn.world.NatureGen;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("endreborn")
public class EndReborn
{
	public static final String MODID = "endreborn";
	public static final ItemGroup ENDGROUP = new EndTab();
    public EndReborn() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
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
    public void doClientStuff(FMLClientSetupEvent event) {

    }
    @SuppressWarnings({"ConstantConditions", "SameReturnValue"})
    public static <T> T Null() {
        return null;
    }
}
