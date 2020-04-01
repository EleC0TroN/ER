package endreborn.mod.items;

import endreborn.init.ItemInit;
import endreborn.EndReborn;
import endreborn.utils.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class ItemEnderBow extends ItemBow implements IHasModel{

	public float charge;

	public int anim_0;
	public int anim_1;
	public int anim_2;
	public ItemEnderBow(String name, float chargeTime, int anim_0, int anim_1, int anim_2) {
		maxStackSize = 1;
		setUnlocalizedName(name);
    	setRegistryName(name);
        this.setMaxStackSize(1);
    	setCreativeTab(EndReborn.endertab);
    	
    	ItemInit.ITEMS.add(this);

		charge = chargeTime;

		this.anim_0 = anim_0;
		this.anim_1 = anim_1;
		this.anim_2 = anim_2;


		setMaxDamage(1024);

		addPropertyOverride(new ResourceLocation("pull"), (stack, worldIn, entityIn) -> {
			if (entityIn == null)
				return 0.0F;
			else
			{
				ItemStack itemstack = entityIn.getActiveItemStack();
				return itemstack != null && itemstack.getItem() == ItemInit.ENDER_BOW ? (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
			}
		});
		addPropertyOverride(new ResourceLocation("pulling"), (stack, worldIn, entityIn) -> entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World par2World, EntityPlayer par3EntityPlayer, EnumHand hand)
	{

		ItemStack par1ItemStack = par3EntityPlayer.getHeldItem(hand);
		boolean flag = findAmmo(par3EntityPlayer) != null;

		ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(par1ItemStack, par2World, par3EntityPlayer, hand, flag);
		if(ret != null) return ret;

		if (!par3EntityPlayer.capabilities.isCreativeMode && !flag)
			return !flag ? new ActionResult(EnumActionResult.FAIL, par1ItemStack) : new ActionResult(EnumActionResult.PASS, par1ItemStack);
			else
			{
				par3EntityPlayer.setActiveHand(hand);
				return new ActionResult(EnumActionResult.SUCCESS, par1ItemStack);
			}
	}
	@Override
	public int getItemEnchantability()
	{
		return 1;
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return ItemInit.INGOT_ENDORIUM == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	@Override
	public void registerModels() 
	{
		EndReborn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}