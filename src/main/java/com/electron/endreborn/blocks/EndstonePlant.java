package com.electron.endreborn.blocks;

import com.electron.endreborn.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.extensions.IForgeBlock;

public class EndstonePlant extends BushBlock implements IForgeBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 15.0D, 5.0D, 15.0D);

    public EndstonePlant() {
        super(Block.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_YELLOW).noCollission().sound(SoundType.STONE));
    }
    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.END_STONE || block == Blocks.END_STONE_BRICKS || block == ModBlocks.CRACKED_END_BRICKS.get() || block == ModBlocks.END_STONE_SMOOTH.get() || block == ModBlocks.END_STONE_PILLAR.get();
    }
    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return this.mayPlaceOn(worldIn.getBlockState(pos.below()), worldIn, pos.below()) ;
    }
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vector3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }
}

