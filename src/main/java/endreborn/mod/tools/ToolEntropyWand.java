package endreborn.mod.tools;

import endreborn.EndReborn;
import endreborn.init.BlockInit;
import endreborn.init.ItemInit;
import endreborn.utils.IHasModel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ToolEntropyWand extends ItemSword implements IHasModel
{

    public ToolEntropyWand(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxDamage(128);
        setCreativeTab(EndReborn.endertab);

        ItemInit.ITEMS.add(this);
    }
    @Override
    public void registerModels()
    {
        EndReborn.proxy.registerItemRenderer(this, 0, "inventory");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add(I18n.format("tile.wand.tooltip"));
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.PLAYERS, 0.5F, player.world.rand.nextFloat() * 0.1F + 0.9F);
        entity.attackEntityFrom(DamageSource.WITHER, 7);
        return true;
    }
    public static boolean convert(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.END_STONE) {
            if (!world.isRemote) {
                world.setBlockState(pos, BlockInit.ENTROPY_END_STONE.getDefaultState());
            }
            return true;
        }
        return false;
    }
    public static boolean convert2(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.STONE) {
            if (!world.isRemote) {
                world.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
            }
            return true;
        }
        return false;
    }
    public static boolean convert3(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.COBBLESTONE) {
            if (!world.isRemote) {
                world.setBlockState(pos, Blocks.GRAVEL.getDefaultState());
            }
            return true;
        }
        return false;
    }
    public static boolean convert4(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.GRAVEL) {
            if (!world.isRemote) {
                world.setBlockState(pos, Blocks.SAND.getDefaultState());
            }
            return true;
        }
        return false;
    }
    public static boolean convert5(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.LOG || state.getBlock() == Blocks.LOG2) {
            if (!world.isRemote) {
                world.setBlockState(pos, Blocks.COAL_BLOCK.getDefaultState());
            }
            return true;
        }
        return false;
    }
    public static boolean convert6(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.SANDSTONE) {
            if (!world.isRemote) {
                world.setBlockState(pos, Blocks.SAND.getDefaultState());
            }
            return true;
        }
        return false;
    }
    public static boolean convert7(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.TALLGRASS || state.getBlock() == Blocks.RED_FLOWER || state.getBlock() == Blocks.YELLOW_FLOWER) {
            if (!world.isRemote) {
                world.setBlockState(pos, Blocks.DEADBUSH.getDefaultState());
            }
            return true;
        }
        return false;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        if (this.convert(worldIn, pos)) {
            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(2, player);
            }
            worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 0, 1, 0, 0.0D, 0.0D, 0.0D);
            return EnumActionResult.SUCCESS;
        }
        if (this.convert2(worldIn, pos)) {
            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(2, player);
            }
            return EnumActionResult.SUCCESS;
        }
        if (this.convert3(worldIn, pos)) {
            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(2, player);
            }
            return EnumActionResult.SUCCESS;
        }
        if (this.convert4(worldIn, pos)) {
            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(2, player);
            }
            return EnumActionResult.SUCCESS;
        }
        if (this.convert5(worldIn, pos)) {
            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(2, player);
            }
            return EnumActionResult.SUCCESS;
        }
        if (this.convert6(worldIn, pos)) {
            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(2, player);
            }
            return EnumActionResult.SUCCESS;
        }
        if (this.convert7(worldIn, pos)) {
            if (!player.capabilities.isCreativeMode)
            {
                stack.damageItem(2, player);
            }
            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.PASS;
    }
}

