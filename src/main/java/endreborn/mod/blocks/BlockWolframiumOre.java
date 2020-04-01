package endreborn.mod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWolframiumOre extends BlockBase {
	
	public BlockWolframiumOre(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(4.0F);
		setResistance(25.0F);
		setHarvestLevel("pickaxe", 2);
		
	} 
	
}