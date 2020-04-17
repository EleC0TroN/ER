package net.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;

public class PlantBase extends FlowerBlock {
	   protected PlantBase(Block.Settings settings) 
	    {
	        super(StatusEffects.LEVITATION, 5, settings);
	    }
}
