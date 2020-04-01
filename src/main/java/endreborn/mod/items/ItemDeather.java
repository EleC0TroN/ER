package endreborn.mod.items;

import endreborn.init.ItemInit;
import endreborn.EndReborn;
import endreborn.utils.ItemData;
import io.netty.buffer.ByteBuf;
import endreborn.utils.IHasModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemDeather extends ItemSword implements IHasModel {
	public ItemDeather(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(EndReborn.endertab);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		EndReborn.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand) {

		if (player.world.isRemote) {

			return false;
		}
		player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT, SoundCategory.PLAYERS, 0.2F, player.world.rand.nextFloat() * 0.1F + 0.9F);
		Vec3d dir = player.getPositionVector().subtract(target.getPositionVector());
		if(getMode(stack) == 0) {
			target.addVelocity(dir.x * 0.3, dir.y * 0.3, dir.z * 0.3);

		}
		if(getMode(stack) == 1) {
			target.addVelocity(dir.x * -0.3, dir.y * -0.3, dir.z * -0.3);
		}
		if (!player.capabilities.isCreativeMode) {
			stack.damageItem(1, player);
		}
		return true;
	}
	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, @Nonnull EnumHand hand) {
		ItemStack itemstack = entityplayer.getHeldItem(hand);

		if (entityplayer.isSneaking()) {
			if (!world.isRemote) {
				toggleMode(itemstack);
				world.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.PLAYERS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			}

			return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
		}

		return new ActionResult<>(EnumActionResult.PASS, itemstack);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add(I18n.format("tile.deather.tooltip"));
		tooltip.add(I18n.format("tile.deather_mode.tooltip") + ": " + getModeName(stack));
	}
	public int getMode(ItemStack itemStack) {
		return ItemData.getInt(itemStack, "mode");
	}

	public String getModeName(ItemStack itemStack) {
		int mode = getMode(itemStack);

		switch (mode) {
			case 0:
				return I18n.format("tile.deather_mode.off");
			case 1:
				return I18n.format("tile.deather_mode.on");
		}

		return null;
	}

	public void toggleMode(ItemStack itemStack) {
		ItemData.setInt(itemStack, "mode", getMode(itemStack) < 1 ? getMode(itemStack) + 1 : 0);
	}

}