package endreborn.handlers;

import endreborn.EndReborn;
import endreborn.init.BlockInit;
import endreborn.init.EntitiesInit;
import endreborn.init.ItemInit;
import endreborn.utils.IHasModel;
import endreborn.world.OreGen;
import endreborn.world.WorldGenCustomStructures;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileHandler.registerTileEntities();
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) 
	{
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS) 
		{
			if(block instanceof IHasModel) 
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		GameRegistry.registerWorldGenerator(new OreGen(), 0);

		SoundHandler.preInit();
    	EntitiesInit.init();
    	TileHandler.registerTileEntities();
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
    
		if(event.getSide() == Side.CLIENT)
		{
			RenderHandler.registerEntityRenders();
		}
		
	}
	public static void initRegistries(FMLInitializationEvent event)
	{
		ChestsHandler.init();
		BannerHandler.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(EndReborn.instance, new GuiHandler());
		OreDictionaryHandler.registerOres();
	}
}

