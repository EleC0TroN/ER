package com.electron.endreborn.blocks;

import com.electron.endreborn.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.potion.Effects;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class RootsBlock extends FlowerBlock{
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 5.0D, 4.0D, 15.0D, 16.0D, 15.0D);
    protected static final VoxelShape SHAPE1 = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 15.0D, 16.0D, 15.0D);

    public static final BooleanProperty DOUBLE = BlockStateProperties.ATTACHED;

    public RootsBlock() {
        super(Effects.BLINDNESS, 5, Block.Properties.create(Material.PLANTS, MaterialColor.STONE).doesNotBlockMovement().sound(SoundType.PLANT));
    }
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == ModBlocks.XORCITE.get() || block == ModBlocks.XORCITE_DECORATIVE.get();
    }
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing != Direction.DOWN) {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            Block block = facingState.getBlock();
            return stateIn.with(DOUBLE, Boolean.valueOf(block == ModBlocks.ROOTS.get()));
        }
    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Block block = context.getWorld().getBlockState(context.getPos().down()).getBlock();
        return this.getDefaultState().with(DOUBLE, Boolean.valueOf(block == ModBlocks.ROOTS.get()));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DOUBLE);
    }
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return this.isValidGround(worldIn.getBlockState(pos.up()), worldIn, pos.up()) ;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vector3d = state.getOffset(worldIn, pos);
        return state.get(DOUBLE) ? SHAPE1.withOffset(vector3d.x, vector3d.y, vector3d.z) : SHAPE.withOffset(vector3d.x, vector3d.y, vector3d.z);
    }
    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }
}
