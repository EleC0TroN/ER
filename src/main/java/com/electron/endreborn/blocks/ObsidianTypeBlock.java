package com.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class ObsidianTypeBlock extends Block implements IForgeBlock {

    public ObsidianTypeBlock() {
        super(Block.Properties.create(Material.ROCK, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 6000.0f).sound(SoundType.STONE).notSolid());
    }
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 3;
    }
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }
}
