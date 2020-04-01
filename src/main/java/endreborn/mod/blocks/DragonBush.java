package endreborn.mod.blocks;

import endreborn.EndReborn;
import endreborn.init.BlockInit;
import endreborn.init.ItemInit;
import endreborn.utils.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DragonBush extends BlockCrops implements IHasModel
{

    public DragonBush(String name) 
    {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
			if(this.isMaxAge(state))
			{
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.DRAGONITE_BERRIES, 2)));
				worldIn.setBlockState(pos, this.withAge(3));
				return true;
			}
		}
		
		return false;
	}
    
    @Override
    protected Item getSeed() 
    {

        return ItemInit.DRAGONITE_SEEDS;
    }

    @Override
    protected Item getCrop() 
    {

        return ItemInit.DRAGONITE_BERRIES;
    }
    
    @Override
	public void registerModels() 
	{
    	EndReborn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}