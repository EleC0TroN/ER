package net.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class EndstonePlant extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 15.0D, 5.0D, 15.0D);

    public EndstonePlant(Settings settings) {
        super(settings);

    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.END_STONE) || floor.isOf(Blocks.END_STONE_BRICKS) || floor.isOf(ModBlocks.END_STONE_PILLAR) || floor.isOf(ModBlocks.END_TUNGSTEN_ORE) || floor.isOf(ModBlocks.BURNED_END_STONE);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

}

