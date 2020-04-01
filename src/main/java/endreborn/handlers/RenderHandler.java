package endreborn.handlers;

import endreborn.mod.entity.*;
import endreborn.mod.entity.render.*;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityEGuard.class, new IRenderFactory<EntityEGuard>()
		{
			@Override
			public Render<? super EntityEGuard> createRenderFor(RenderManager manager) 
			{
				return new RenderEGuard(manager);
			}
	});
		RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, new IRenderFactory<EntityWatcher>()
		{
		@Override
		public Render<? super EntityWatcher> createRenderFor(RenderManager manager) 
		{
			return new RenderWatcher(manager);
		}
	});
	RenderingRegistry.registerEntityRenderingHandler(EntityLord.class, new IRenderFactory<EntityLord>()
	{
	@Override
	public Render<? super EntityLord> createRenderFor(RenderManager manager) 
	{
		return new RenderLord(manager);
	}
	});
	RenderingRegistry.registerEntityRenderingHandler(EntityChronologist.class, new IRenderFactory<EntityChronologist>()
	{
		@Override
			public Render<? super EntityChronologist> createRenderFor(RenderManager manager)
			{
				return new RenderChronologist(manager);
			}
		});
}
}
