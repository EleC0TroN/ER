package com.electron.endreborn;

import com.electron.endreborn.mobs.EndGuardRenderer;
import com.electron.endreborn.mobs.EndormanRenderer;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClient {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ModBlocks.initRender(event);
        RenderingRegistry.registerEntityRenderingHandler(ModMobs.ENDGUARD, new EndGuardRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(ModMobs.ENDOR, new EndormanRenderer.RenderFactory());
    }
}
