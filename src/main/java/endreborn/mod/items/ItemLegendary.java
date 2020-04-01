package endreborn.mod.items;

import endreborn.init.ItemInit;
import endreborn.EndReborn;
import endreborn.utils.IHasModel;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLegendary extends Item implements IHasModel
{
    public ItemLegendary(String name)
    {
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
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
	    return EnumRarity.RARE;
	}
}
