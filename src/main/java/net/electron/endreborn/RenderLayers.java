package net.electron.endreborn;

import net.electron.endreborn.blocks.Blocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class RenderLayers  implements ClientModInitializer
{
	@Override
	public void onInitializeClient()
	{
		init();
	}
	private void init() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Blocks.DRAGONITE, Blocks.OGANA_PLANT, Blocks.OGANA_WEED);
	}
}
