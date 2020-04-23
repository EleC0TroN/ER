package com.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class ObsidianOre extends Block implements IForgeBlock {

    public ObsidianOre() {
        super(Block.Properties.create(Material.ROCK, MaterialColor.IRON).hardnessAndResistance(50.0f, 6000.0f).sound(SoundType.STONE));
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 3;
    }
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }
}
