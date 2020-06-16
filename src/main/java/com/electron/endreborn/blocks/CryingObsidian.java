package com.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.CompassItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class CryingObsidian extends Block  implements IForgeBlock {
    public CryingObsidian() {
        super(Block.Properties.create(Material.PORTAL, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 6000.0f).lightValue(7).sound(SoundType.STONE));
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
