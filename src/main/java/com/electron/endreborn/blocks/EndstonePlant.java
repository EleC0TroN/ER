package com.electron.endreborn.blocks;

import com.electron.endreborn.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.extensions.IForgeBlock;

public class EndstonePlant extends BushBlock implements IForgeBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 15.0D, 5.0D, 15.0D);

    public EndstonePlant() {
        super(Block.Properties.create(Material.PLANTS, MaterialColor.YELLOW).doesNotBlockMovement().sound(SoundType.PLANT));
    }
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.END_STONE || block == Blocks.END_STONE_BRICKS || block == ModBlocks.CRACKED_END_BRICKS.get() || block == ModBlocks.END_STONE_SMOOTH.get() || block == ModBlocks.END_STONE_PILLAR.get();
    }
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return true;
    }
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return this.isValidGround(worldIn.getBlockState(pos.down()), worldIn, pos.down()) ;
    }
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vector3d = state.getOffset(worldIn, pos);
        return SHAPE.withOffset(vector3d.x, vector3d.y, vector3d.z);
    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }
}

