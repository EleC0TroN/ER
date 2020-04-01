package endreborn.init;

import endreborn.EndReborn;
import endreborn.Reference;
import endreborn.mod.entity.*;
import endreborn.mod.entity.render.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitiesInit {

    public static void init() {
        int id = 1;
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "endguard"), EntityEGuard.class, "endguard", id++, EndReborn.instance, 64, 3, false, 9654933, 11237052);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "watcher"), EntityWatcher.class, "watcher", id++, EndReborn.instance, 64, 3, false, 461076, 2236447);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "endlord"), EntityLord.class, "endlord", id++, EndReborn.instance, 64, 3, false, 461076, 681365);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "chronologist"), EntityChronologist.class, "chronologist", id++, EndReborn.instance, 64, 3, false, 461076, 13680725);

    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityEGuard.class, RenderEGuard.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, RenderWatcher.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityLord.class, RenderLord.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityChronologist.class, RenderChronologist.FACTORY);
    }
}

