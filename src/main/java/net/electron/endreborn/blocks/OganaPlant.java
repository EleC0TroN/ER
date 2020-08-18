package net.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class OganaPlant extends FlowerBlock {
	protected OganaPlant(Block.Settings settings)
	    {
	        super(StatusEffects.LEVITATION, 5, settings);
	    }
	protected boolean canPlantOnTop(BlockState floor, WorldView world, BlockPos pos) {
		      Block block = floor.getBlock();
		      return block == ModBlocks.END_MOSS;
	}
	@Override
	public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
	      return this.canPlantOnTop(worldIn.getBlockState(pos.down()), worldIn, pos.down()) ;
    }
}
