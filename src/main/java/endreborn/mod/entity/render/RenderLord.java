package endreborn.mod.entity.render;

import endreborn.Reference;
import endreborn.mod.entity.EntityLord;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import java.util.Calendar;

public class RenderLord extends RenderLiving<EntityLord>
{
	public static boolean isNewYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) == calendar.DECEMBER || ((Calendar.MONTH) == calendar.JANUARY && (calendar.get(Calendar.DAY_OF_MONTH) == 1 || calendar.get(Calendar.DAY_OF_MONTH) == 2 || calendar.get(Calendar.DAY_OF_MONTH) == 3));
	}

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/endlord.png");
	public static final ResourceLocation TEXTURES_NEW = new ResourceLocation(Reference.MODID + ":textures/entity/endlord_new.png");

	public static final Factory FACTORY = new Factory();
	
	public RenderLord(RenderManager manager) 
	{
		super(manager, new ModelLord(), 0.4F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityLord entity) 
	{
		if(isNewYear()) {
			return TEXTURES_NEW;
		}
		else return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityLord entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	public static class Factory implements IRenderFactory<EntityLord> {

        @Override
        public Render<? super EntityLord> createRenderFor(RenderManager manager) {
            return new RenderLord(manager);
        }
}
}