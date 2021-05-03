package com.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class EndLantern extends LanternBlock implements IForgeBlock {

    public EndLantern() {
        super(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.25f, 5.5f).lightValue(12).sound(SoundType.STONE));
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
