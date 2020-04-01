package endreborn.mod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockEndBase extends BlockBase {
	
	public BlockEndBase(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 2);
		
	} 

}
