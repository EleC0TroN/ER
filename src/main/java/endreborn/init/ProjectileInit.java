package endreborn.init;

import endreborn.EndReborn;
import endreborn.Reference;
import endreborn.mod.entity.EntityColdFireball;
import endreborn.mod.entity.render.RenderColdFireball;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ProjectileInit
{
    public static void initEntities()
    {
        int id = -1;

        registerEntity(EntityColdFireball.class, "end_fireball", id++, 30, 1, true);

    }

    @SideOnly(Side.CLIENT)
    public static void registerEntityRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityColdFireball.class, renderManager -> new RenderColdFireball(renderManager));

    }

    private static void registerEntity(Class<? extends Entity> clazz, String name, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, name), clazz, Reference.MODID + "." + name, id, EndReborn.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
    }

}