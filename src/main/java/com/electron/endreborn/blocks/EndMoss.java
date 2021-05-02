package com.electron.endreborn.blocks;

import com.electron.endreborn.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class EndMoss extends Block implements IForgeBlock {
	
	public EndMoss() {
        super(Block.Properties.of(Material.PORTAL, MaterialColor.GRASS).strength(3.25f, 5.5f).sound(SoundType.STONE)
        		);
    }
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	      return block == Blocks.BEDROCK || block == Blocks.OBSIDIAN || block == ModBlocks.OGANA_WEED.get();
	   }

	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
	      return !this.mayPlaceOn(worldIn.getBlockState(pos.below()), worldIn, pos.below());
    }
	public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
	      double d0 = Math.abs(entityIn.getDeltaMovement().y);
	      if (d0 < 0.1D && !entityIn.isSprinting()) {
	         double d1 = 0.8D + d0 * 0.2D;
	         entityIn.setDeltaMovement(entityIn.getDeltaMovement().multiply(d1, 1.0D, d1));

	      super.stepOn(worldIn, pos, entityIn);
	      }
	}
    @Override
    public int getHarvestLevel(BlockState state) {
        return 1;
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }
}
