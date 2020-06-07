package net.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class RootsBlock extends FlowerBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 5.0D, 5.0D, 15.0D, 16.0D, 15.0D);

    protected RootsBlock(Block.Settings settings)
    {
        super(StatusEffects.LEVITATION, 5, settings);
    }
    protected boolean canPlantOnTop(BlockState floor, WorldView world, BlockPos pos) {
        Block block = floor.getBlock();
        return block == ModBlocks.ENDSHROOM;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        return this.canPlantOnTop(worldIn.getBlockState(pos.up()), worldIn, pos.up()) ;
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }
}
