package endreborn.mod.items;

import endreborn.init.ItemInit;
import endreborn.EndReborn;
import endreborn.utils.IHasModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWorldMirror extends Item implements IHasModel
{
    public ItemWorldMirror(String name)
    {
    	setUnlocalizedName(name);
    	setRegistryName(name);
    	this.maxStackSize = 1;
    	setCreativeTab(EndReborn.endertab);
    	
    	ItemInit.ITEMS.add(this);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn,
            EntityPlayer playerIn, EnumHand handIn )
    {
        ItemStack mainhand = playerIn.getHeldItemMainhand();
        {
            mainhand.damageItem(1, playerIn);
            playerIn.getCooldownTracker().setCooldown(this, 1000);
            BlockPos blockpos = worldIn.provider.getRandomizedSpawnPoint();
            worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            playerIn.setPositionAndUpdate(blockpos.getX(), blockpos.getY(),
                    blockpos.getZ());
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS,
                playerIn.getHeldItem(handIn));
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
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
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add(I18n.format("tile.mirror.tooltip_0"));
        tooltip.add(I18n.format("tile.mirror.tooltip_1"));
    }

}
