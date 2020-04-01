package endreborn.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesInit 
{

	public static void init() 
	{
		GameRegistry.addSmelting(BlockInit.ORE_WOLFRAMIUM, new ItemStack(ItemInit.INGOT_WOLFRAMIUM, 1), 1.5f);
	}
}