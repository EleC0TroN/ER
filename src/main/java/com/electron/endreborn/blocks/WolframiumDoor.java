package com.electron.endreborn.blocks; 

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class WolframiumDoor extends DoorBlock implements IForgeBlock {

    public WolframiumDoor() {
        super(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(5.25f, 5.5f).sound(SoundType.METAL));
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 2;
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }
}
