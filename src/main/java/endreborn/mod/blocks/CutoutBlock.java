package endreborn.mod.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import endreborn.EndReborn;
import endreborn.init.BlockInit;
import endreborn.init.ItemInit;
import endreborn.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CutoutBlock extends Block implements IHasModel
{
	protected static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);

	public CutoutBlock(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock().isReplaceable(world, pos) && world.getBlockState(pos.down()).getBlock() == Blocks.END_STONE;
    }
	@Override
    public Block.EnumOffsetType getOffsetType() 
	{
    return Block.EnumOffsetType.XYZ;
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	 {
	    return BUSH_AABB;
	 }
	 @Nullable
	 public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	 {
	    return NULL_AABB;
	 }
	 @Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			return null;
		}
	 public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }

	    public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }
	@Override
	public void registerModels() 
	{
		EndReborn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
