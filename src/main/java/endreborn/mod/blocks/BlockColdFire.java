package endreborn.mod.blocks;

import endreborn.EndReborn;
import endreborn.init.BlockInit;
import endreborn.utils.IHasModel;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockColdFire extends BlockFire implements IHasModel
{

    public BlockColdFire(String name)
    {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(EndReborn.endertab);

        BlockInit.BLOCKS.add(this);
    }

    @Override
    public void registerModels()
    {
        EndReborn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
       
        super.onEntityWalk(worldIn, pos, entityIn);
    }

}