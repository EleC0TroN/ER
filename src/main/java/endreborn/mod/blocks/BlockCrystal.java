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

public class BlockCrystal extends BlockBase {
	
	public BlockCrystal(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(3.0F);
		setResistance(25.0F);
		setHarvestLevel("pickaxe", 2);
		
	} 
	 @Override
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
		{
			tooltip.add(I18n.format("tile.lormyte.tooltip"));
		}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.LORMYTE_CRYSTAL;
	}
}

