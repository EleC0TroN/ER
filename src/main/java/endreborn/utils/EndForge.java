package endreborn.utils;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import endreborn.init.BlockInit;
import endreborn.init.ItemInit;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
        if (stack.getItem() == ItemInit.INGOT_ENDORIUM || stack.getItem() == Items.SLIME_BALL || stack.getItem() == ItemInit.END_ESSENCE)
        {
            return state.getMaterial() == BlockInit.END_FORGE;
        }

        return false;
    }

    public static boolean performAction(World world, BlockPos pos, EntityPlayer player, ItemStack stack, @Nullable EnumFacing face, EnumHand hand)
    {
        if (stack.getItem() == ItemInit.INGOT_ENDORIUM) {
            return handleForgerI(world, pos, player, stack, hand);
        }
        if (stack.getItem() == Items.SLIME_BALL) {
            return handleForgerS(world, pos, player, stack, hand);
        }
        if (stack.getItem() == ItemInit.END_ESSENCE) {
            return handleForgerB(world, pos, player, stack, hand);
        }
        if (stack.getItem() == ItemInit.END_ESSENCE) {
            return handleForgerB(world, pos, player, stack, hand);
        }
       
        return false;
    }

    private static boolean handleForgerI(World world, BlockPos pos, EntityPlayer player, ItemStack stack, EnumHand hand) {
        if (!world.isRemote) {
            EndHelper.dropItemInWorldExact(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ItemInit.INFUSED_METALL, 1));
            player.setHeldItem(hand, EndHelper.consumeItem(player, stack));
            world.playSound(null, pos, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return true;
    }
    private static boolean handleForgerS(World world, BlockPos pos, EntityPlayer player, ItemStack stack, EnumHand hand) {
        if (!world.isRemote) {
            EndHelper.dropItemInWorldExact(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(Items.MAGMA_CREAM, 1));
            player.setHeldItem(hand, EndHelper.consumeItem(player, stack));
            world.playSound(null, pos, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return true;
    }
    private static boolean handleForgerB(World world, BlockPos pos, EntityPlayer player, ItemStack stack, EnumHand hand) {
        if (!world.isRemote) {
            EndHelper.dropItemInWorldExact(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(Items.BLAZE_POWDER, 1));
            player.setHeldItem(hand, EndHelper.consumeItem(player, stack));
            world.playSound(null, pos, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return true;
    }
    private static boolean handleForgerE(World world, BlockPos pos, EntityPlayer player, ItemStack stack, EnumHand hand) {
        if (!world.isRemote) {
            EndHelper.dropItemInWorldExact(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(BlockInit.BLOCK_END_MAGMA, 1));
            player.setHeldItem(hand, EndHelper.consumeItem(player, stack));
            world.playSound(null, pos, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
        return true;
    }
}