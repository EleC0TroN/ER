package net.electron.endreborn.blocks;


import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class RootsBlock extends FlowerBlock{
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 5.0D, 4.0D, 15.0D, 16.0D, 15.0D);
    protected static final VoxelShape SHAPE1 = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 15.0D, 16.0D, 15.0D);

    public static final BooleanProperty DOUBLE = Properties.ATTACHED;

    public RootsBlock() {
        super(StatusEffects.BLINDNESS, 5, Settings.of(Material.PLANT, MaterialColor.STONE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
    }
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.XORCITE) || floor.isOf(ModBlocks.DECORATIVE_XORCITE);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        return blockPos.getY() > 0 && ctx.getWorld().getBlockState(blockPos.down()).canReplace(ctx) ? super.getPlacementState(ctx) : null;
    }
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        Block block = world.getBlockState(pos.down()).getBlock();
        world.setBlockState(pos, (BlockState)this.getDefaultState().with(DOUBLE, Boolean.valueOf(block == ModBlocks.ROOTS)), 3);
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DOUBLE});
    }
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return this.canPlantOnTop(world.getBlockState(pos.up()), world, pos.up());
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return state.get(DOUBLE) ? SHAPE1.offset(vec3d.x, vec3d.y, vec3d.z) : SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }
}
