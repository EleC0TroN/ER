package endreborn.mod.entity.render;

import java.util.Random;

import endreborn.Reference;
import endreborn.mod.entity.EntityChronologist;
import endreborn.mod.entity.layer.LayerChronologist;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderChronologist extends RenderLiving<EntityChronologist>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/chronologist.png");

    private final Random rnd = new Random();
    public static final RenderChronologist.Factory FACTORY = new RenderChronologist.Factory();

    public RenderChronologist(RenderManager manager)
    {
        super(manager, new ModelEnderman(0), 0.5F);
        this.addLayer(new LayerChronologist(this));
    }
    @Override
    public void doRender(EntityChronologist entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.isScreaming()) {
            x += rnd.nextGaussian() * 0.02D;
            z += rnd.nextGaussian() * 0.02D;
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        GlStateManager.popMatrix();
    }
    @Override
    protected ResourceLocation getEntityTexture(EntityChronologist entity)
    {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityChronologist entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
    public static class Factory implements IRenderFactory<EntityChronologist> {

        @Override
        public Render<? super EntityChronologist> createRenderFor(RenderManager manager) {
            return new RenderChronologist(manager);
        }
    }
}
