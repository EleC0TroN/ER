package endreborn.mod.entity.render;

import endreborn.Reference;
import endreborn.mod.entity.EntityWatcher;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWatcher extends RenderLiving<EntityWatcher>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/watcher.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderWatcher(RenderManager manager) 
	{
		super(manager, new ModelEnderman(0), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityWatcher entity) 
	{
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityWatcher entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	public static class Factory implements IRenderFactory<EntityWatcher> {

        @Override
        public Render<? super EntityWatcher> createRenderFor(RenderManager manager) {
            return new RenderWatcher(manager);
        }
}
}

