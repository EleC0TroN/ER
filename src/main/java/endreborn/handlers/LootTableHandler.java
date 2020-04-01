package endreborn.handlers;

import endreborn.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation END_GUARD = LootTableList.register(new ResourceLocation(Reference.MODID, "endguard"));
	public static final ResourceLocation WATCHER = LootTableList.register(new ResourceLocation(Reference.MODID, "watcher"));
	public static final ResourceLocation LORD = LootTableList.register(new ResourceLocation(Reference.MODID, "lord"));
}
