package endreborn.mod.entity.render;

import java.util.Random;

import endreborn.Reference;
import endreborn.mod.entity.EntityWatcher;
import endreborn.mod.entity.layer.LayerWatcherEyes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWatcher extends RenderLiving<EntityWatcher>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/watcher.png");
	private final Random rnd = new Random();

	public static final Factory FACTORY = new Factory();
	
	public RenderWatcher(RenderManager manager) 
	{
		super(manager, new ModelEnderman(0), 0.5F);
        this.addLayer(new LayerWatcherEyes(this));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityWatcher entity) 
	{
		return TEXTURES;
	}
	 public ModelEnderman getMainModel()
	    {
	        return (ModelEnderman)super.getMainModel();
	    }

	    /**
	     * Renders the desired {@code T} type Entity.
	     */
	    public void doRender(EntityWatcher entity, double x, double y, double z, float entityYaw, float partialTicks)
	    {
	    
	        ModelEnderman modelenderman = this.getMainModel();
	        modelenderman.isAttacking = entity.isScreaming();

	        if (entity.isScreaming())
	        {
	            double d0 = 0.02D;
	            x += this.rnd.nextGaussian() * 0.02D;
	            z += this.rnd.nextGaussian() * 0.02D;
	        }

	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	    }
	
	public static class Factory implements IRenderFactory<EntityWatcher> {

        @Override
        public Render<? super EntityWatcher> createRenderFor(RenderManager manager) {
            return new RenderWatcher(manager);
        }
}
}

