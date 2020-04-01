package endreborn.mod.blocks;

import endreborn.EndReborn;
import endreborn.init.BlockInit;
import endreborn.init.ItemInit;
import endreborn.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockStairsBase extends BlockStairs implements IHasModel
{

	public BlockStairsBase(String name, Block block)
	{
		super(block.getDefaultState());
		setUnlocalizedName(name);
		setHardness(block.getBlockHardness(block.getDefaultState(), null, null));
		setSoundType(block.getSoundType());
		setRegistryName(name);
		setCreativeTab(EndReborn.endertab);
		useNeighborBrightness = true;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		EndReborn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}