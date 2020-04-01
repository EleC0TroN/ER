package endreborn.mod.food;

import endreborn.init.ItemInit;
import endreborn.EndReborn;
import endreborn.utils.IHasModel;
import net.minecraft.item.ItemFood;


public class FoodDragonBerries extends ItemFood implements IHasModel
{

	public FoodDragonBerries(String name) 
	{
		super(1, 0.1F, false);
		setUnlocalizedName(name);
    	setRegistryName(name);
    	setCreativeTab(EndReborn.endertab);
    	
    	ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		EndReborn.proxy.registerItemRenderer(this, 0, "inventory");
	}

}


