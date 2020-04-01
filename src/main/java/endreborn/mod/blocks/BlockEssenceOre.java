package endreborn.mod.blocks;

import java.util.List;
import java.util.Random;

import endreborn.init.ItemInit;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockEssenceOre extends BlockBase {
	
	public BlockEssenceOre(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(50.0F);
		setResistance(6000.0F);
		setLightLevel(1.0F);
		setHarvestLevel("pickaxe", 3);
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
		tooltip.add(I18n.format("tile.essence.tooltip"));
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.END_ESSENCE;
	}
}