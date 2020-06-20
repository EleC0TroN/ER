package endreborn.mod.entity.layer;

import endreborn.Reference;
import endreborn.mod.entity.EntityWatcher;
import endreborn.mod.entity.render.RenderWatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerWatcherEyes implements LayerRenderer<EntityWatcher>
{
    private static final ResourceLocation RES_WATCHER_EYES = new ResourceLocation(Reference.MODID + ":textures/entity/watcher_layer.png");
    private final RenderWatcher endermanRenderer;

    public LayerWatcherEyes(RenderWatcher endermanRendererIn)
    {
        this.endermanRenderer = endermanRendererIn;
    }


	public void doRenderLayer(EntityWatcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
		 this.endermanRenderer.bindTexture(RES_WATCHER_EYES);
	        GlStateManager.enableBlend();
	        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
	        GlStateManager.disableLighting();
	        GlStateManager.depthMask(!entitylivingbaseIn.isInvisible());
	        int i = 61680;
	        int j = 61680;
	        int k = 0;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
	        GlStateManager.enableLighting();
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
	        this.endermanRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	        Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
	        GlStateManager.depthMask(true);
	        GlStateManager.disableBlend();
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}