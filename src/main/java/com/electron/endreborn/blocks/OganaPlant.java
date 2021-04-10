package com.electron.endreborn.blocks;

import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.compatibility.EndergeticExpansiom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.extensions.IForgeBlock;

public class OganaPlant extends FlowerBlock implements IForgeBlock {
	protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 15.0D, 10.0D, 15.0D);

	public OganaPlant() {
        super(Effects.LEVITATION, 5, Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.GRASS).noCollission().sound(SoundType.GRASS));
    }
	@Override
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
	    Block block = state.getBlock();
	    return block == ModBlocks.END_MOSS.get();
	}
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
	    return this.mayPlaceOn(worldIn.getBlockState(pos.below()), worldIn, pos.below()) ;
	}
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Vector3d vector3d = state.getOffset(worldIn, pos);
		return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
	}

	public OffsetType getOffsetType() {
		return OffsetType.XZ;
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
	    return true;
	}
}
