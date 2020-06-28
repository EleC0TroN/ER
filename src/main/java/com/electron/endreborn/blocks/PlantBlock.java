package com.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.extensions.IForgeBlock;

public class PlantBlock extends FlowerBlock implements IForgeBlock {
	public PlantBlock() {
        super(Effects.LEVITATION, 5, Block.Properties.create(Material.PLANTS, MaterialColor.GRASS).doesNotBlockMovement().sound(SoundType.PLANT));
    }
}
