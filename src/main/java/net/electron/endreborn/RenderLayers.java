package net.electron.endreborn;

import net.electron.endreborn.blocks.ModBlocks;
import net.electron.endreborn.mobs.EndGuardRenderer;
import net.electron.endreborn.mobs.Mobs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.EntityType;

@Environment(EnvType.CLIENT)
public class RenderLayers  implements ClientModInitializer
{
	@Override
	public void onInitializeClient() {
		init();
		mobRenderer(Mobs.ENDGUARD, EndGuardRenderer.class);
	}
	private void init() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.END_CORAL, ModBlocks.OBSIDIAN_GLASS, ModBlocks.OBSIDIAN_GLASS_PANE, ModBlocks.DRAGONITE, ModBlocks.OGANA_WEED, ModBlocks.ROOTS, ModBlocks.PURPUR_CHAIN, ModBlocks.POTTED_DRAGONITE);
	}

	public static void mobRenderer(EntityType<?> entity, Class<? extends EntityRenderer<?>> renderer)
	{
		EntityRendererRegistry.INSTANCE.register(entity, (entityRenderDispatcher, context) -> {
			EntityRenderer<?> render = null;
			try
			{
				render = renderer.getConstructor(entityRenderDispatcher.getClass()).newInstance(entityRenderDispatcher);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return render;
		});
	}
}
