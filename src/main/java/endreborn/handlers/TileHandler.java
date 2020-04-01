package endreborn.handlers;

import endreborn.Reference;
import endreborn.mod.blocks.TileEntropyUser;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileHandler
{
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntropyUser.class, new ResourceLocation(Reference.MODID + ":entropy_user"));
    }
}
