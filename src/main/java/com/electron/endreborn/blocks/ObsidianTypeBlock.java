package com.electron.endreborn.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class ObsidianTypeBlock extends Block implements IForgeBlock {

    public ObsidianTypeBlock() {
        super(Block.Properties.create(Material.PORTAL, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 6000.0f).sound(SoundType.STONE));
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
