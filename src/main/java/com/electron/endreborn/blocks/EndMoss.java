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
        super(Block.Properties.create(Material.PORTAL, MaterialColor.GRASS).hardnessAndResistance(3.25f, 5.5f).sound(SoundType.STONE)
        		);
    }
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	      return block == Blocks.BEDROCK || block == Blocks.OBSIDIAN || block == ModBlocks.OGANA_WEED.get();
	   }
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
	      return !this.isValidGround(worldIn.getBlockState(pos.down()), worldIn, pos.down()) ;
    }
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
	      double d0 = Math.abs(entityIn.getMotion().y);
	      if (d0 < 0.1D && !entityIn.isSprinting()) {
	         double d1 = 0.8D + d0 * 0.2D;
	         entityIn.setMotion(entityIn.getMotion().mul(d1, 1.0D, d1));
	      
	      super.onEntityWalk(worldIn, pos, entityIn);
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
