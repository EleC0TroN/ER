package endreborn.utils;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import endreborn.init.BlockInit;
import endreborn.init.ItemInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@ParametersAreNonnullByDefault
public final class EndForge
{
    public static boolean hasAction(World world, BlockPos pos, ItemStack stack, @Nullable EnumFacing face)
    {
        IBlockState state = world.getBlockState(pos);
        if (stack.getItem() == ItemInit.INGOT_ENDORIUM)
        {
            return state.getMaterial() == BlockInit.END_FORGE && state.isNormalCube() && face == EnumFacing.UP;
        }

        return false;
    }

    /**
     * Performs the action
     *
     * @return true if the event should be cancelled
     */
    public static boolean performAction(World world, BlockPos pos, EntityPlayer player, ItemStack stack, @Nullable EnumFacing face, EnumHand hand)
    {
        if (stack.getItem() == ItemInit.INGOT_ENDORIUM)
        {
            return handleForgerI(world, pos, player, stack, hand);
        }
        
        return false;
    }

    private static boolean handleForgerI(World world, BlockPos pos, EntityPlayer player, ItemStack stack, EnumHand hand)
    {
        if (!world.isRemote)
        {
            {
                {
                    EndHelper.dropItemInWorldExact(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ItemInit.INFUSED_METALL, 1));
                }
                player.setHeldItem(hand, EndHelper.consumeItem(player, stack));
            }
            world.playSound(null, pos, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return true;
    }
    
}
