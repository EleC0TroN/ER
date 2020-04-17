package com.electron.endreborn.blocks;

import com.electron.endreborn.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.extensions.IForgeBlock;

public class EndPlant extends FlowerBlock implements IForgeBlock {

	public EndPlant() {
        super(Effects.LEVITATION, 5, Block.Properties.create(Material.DRAGON_EGG, MaterialColor.GRASS).doesNotBlockMovement().sound(SoundType.PLANT));
    }
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	    Block block = state.getBlock();
	    return block == ModBlocks.END_MOSS.get();
	}
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
	    return this.isValidGround(worldIn.getBlockState(pos.down()), worldIn, pos.down()) ;
	}
	public BlockRenderLayer getRenderLayer() {
	    return BlockRenderLayer.CUTOUT;
	}
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
	    return true;
	}
}
