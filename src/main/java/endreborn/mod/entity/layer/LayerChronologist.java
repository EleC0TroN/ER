package endreborn.mod.entity.layer;

import endreborn.Reference;
import endreborn.mod.entity.EntityChronologist;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerChronologist implements LayerRenderer<EntityChronologist>
{
    private static final ResourceLocation LAYER_TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/chronologist_layer.png");
    private final RenderLivingBase<?> renderer;
    private final ModelEnderman layerModel = new ModelEnderman(0.25F);

    public LayerChronologist(RenderLivingBase<?> p_i47183_1_)
    {
        this.renderer = p_i47183_1_;
    }

    public void doRenderLayer(EntityChronologist entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderer.bindTexture(LAYER_TEXTURES);
        this.layerModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}