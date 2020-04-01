package endreborn.mod.food;

import endreborn.init.ItemInit;
import endreborn.EndReborn;
import endreborn.utils.IHasModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;


public class FoodEnderFlesh extends ItemFood implements IHasModel
{
	public FoodEnderFlesh(String name) 
	{
		super(4, 0.4F, false);
		setUnlocalizedName(name);
    	setRegistryName(name);
    	setCreativeTab(EndReborn.endertab);
    	setPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 100, 1), 0.6F);
    	ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		EndReborn.proxy.registerItemRenderer(this, 0, "inventory");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add(I18n.format("tile.flesh.tooltip"));
	}
}

