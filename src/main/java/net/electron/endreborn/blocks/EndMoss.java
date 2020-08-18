package net.electron.endreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class EndMoss extends Block {
	
	public EndMoss() {
        super(Block.Settings.of(Material.STONE, MaterialColor.PURPLE).strength(3.0f, 3.0f));
    }
	protected boolean canPlantOnTop(BlockState floor, BlockView view, BlockPos pos) {
	      Block block = floor.getBlock();
	      return block == Blocks.BEDROCK || block == Blocks.OBSIDIAN || block == ModBlocks.OGANA_WEED;
	   }
	@Override
	public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
	      return !this.canPlantOnTop(worldIn.getBlockState(pos.down()), worldIn, pos.down()) ;
    }
	public void onSteppedOn(World worldIn, BlockPos pos, Entity entityIn) {
	      double d0 = Math.abs(entityIn.getVelocity().y);
	      if (d0 < 0.1D && !entityIn.isSneaking()) {
	         double d1 = 0.8D + d0 * 0.2D;
	         entityIn.setVelocity(entityIn.getVelocity().multiply(d1, 1.0D, d1));
	      
	      super.onSteppedOn(worldIn, pos, entityIn);
	      }
	}
}
