package endreborn.mod.items;

import endreborn.init.ItemInit;

import java.util.List;

import javax.annotation.Nullable;

import endreborn.EndReborn;
import endreborn.utils.IHasModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDragoniteTea extends Item implements IHasModel
{
    public ItemDragoniteTea(String name)
    {
    	setUnlocalizedName(name);
    	setRegistryName(name);
        this.setMaxStackSize(1);
    	setCreativeTab(EndReborn.endertab);
    	
    	ItemInit.ITEMS.add(this);
    }

	@Override
	public void registerModels() 
	{
		EndReborn.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	    {
		 ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);

	        if (!worldIn.isRemote)
	        {
	            double d0 = entityLiving.posX;
	            double d1 = entityLiving.posY;
	            double d2 = entityLiving.posZ;

	            for (int i = 0; i < 16; ++i)
	            {
	                double d3 = entityLiving.posX + (entityLiving.getRNG().nextDouble() - 0.5D) * 16.0D;
	                double d4 = MathHelper.clamp(entityLiving.posY + (double)(entityLiving.getRNG().nextInt(16) - 8), 0.0D, (double)(worldIn.getActualHeight() - 1));
	                double d5 = entityLiving.posZ + (entityLiving.getRNG().nextDouble() - 0.5D) * 16.0D;

	                if (entityLiving.isRiding())
	                {
	                    entityLiving.dismountRidingEntity();
	                }

	                if (entityLiving.attemptTeleport(d3, d4, d5))
	                {
	                    worldIn.playSound((EntityPlayer)null, d0, d1, d2, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
	                    entityLiving.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
	                    break;
	                }
	            }

	            if (entityLiving instanceof EntityPlayer)
	            {
	                ((EntityPlayer)entityLiving).getCooldownTracker().setCooldown(this, 20);
	            }

	            if (entityLiving instanceof EntityPlayer)
	            {
	                ((EntityPlayer)entityLiving).getCooldownTracker().setCooldown(this, 20);
	            }

	        if (entityLiving instanceof EntityPlayer && !((EntityPlayer)entityLiving).capabilities.isCreativeMode)
	        {
	            stack.shrink(1);
	            
	        }

	        
	    }
	        return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
	    }

	    public int getMaxItemUseDuration(ItemStack stack)
	    {
	        return 16;
	    }

	    @SideOnly(Side.CLIENT)
	    public ItemStack getDefaultInstance()
	    {
	        return PotionUtils.addPotionToItemStack(super.getDefaultInstance(), PotionTypes.HEALING);
	    }
	    public EnumAction getItemUseAction(ItemStack stack)
	    {
	        return EnumAction.DRINK;
	    }

	    @Override
	    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, net.minecraft.nbt.NBTTagCompound nbt) {
	        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
	        tooltip.add(I18n.format("tile.tea.tooltip"));
	    }
	    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
	    	
	        playerIn.setActiveHand(handIn);
	        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	    }
}