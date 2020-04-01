package endreborn;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EndRebornTab extends CreativeTabs
{

	public EndRebornTab(String label) 
	{
		super("endertab");
	}
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Items.ENDER_PEARL);
	}

}
