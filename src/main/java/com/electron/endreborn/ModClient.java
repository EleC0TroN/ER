package com.electron.endreborn;

import com.electron.endreborn.mobs.EndGuardRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClient {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ModBlocks.initRender(event);
        RenderingRegistry.registerEntityRenderingHandler(ModMobs.ENDGUARD.get(), new EndGuardRenderer.RenderFactory());

    }
}
