package endreborn.mod.tools.axes;

import endreborn.init.ItemInit;
import endreborn.EndReborn;
import endreborn.utils.IHasModel;
import net.minecraft.item.ItemAxe;

public class EndoriumAxe extends ItemAxe implements IHasModel
{

	public EndoriumAxe(String name, ToolMaterial material) {
		super(material, 9f, -3.1f);
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
