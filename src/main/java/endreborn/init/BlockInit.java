package endreborn.init;

import java.util.ArrayList;
import java.util.List;

import endreborn.mod.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Material END_FORGE = (new Material(MapColor.STONE));
	
	public static final Block BLOCK_ENDORIUM = new BlockEndBase("block_endorium", Material.IRON);
	public static final Block END_STONE_SMOOTH = new BlockEndBase("block_end_stone_smooth", Material.ROCK);
	public static final Block END_STONE_PILLAR = new BlockPillar("block_end_stone_pillar", Material.ROCK);
	public static final Block PURPUR_LAMP = new LampBase("block_purpur_lamp", Material.ROCK);
	public static final Block ENDER_FLOWER = new EnderCropBase("crop_ender_flower");
	public static final Block DRAGON_BUSH = new DragonBush("crop_dragonite");
	public static final Block ESSENCE_ORE = new BlockEssenceOre("block_essence_ore", Material.ROCK);
	public static final Block PHANTOM_BLOCK = new BlockPhantom("block_phantom", Material.BARRIER, false);
	public static final Block ENTROPY_END_STONE = new BlockEndBase("block_entropy_end_stone", Material.ROCK);
	public static final Block LORMYTE_CRYSTAL = new BlockCrystal("block_lormyte_crystal", Material.ROCK);
	public static final Block DECORATIVE_LORMYTE = new BlockCrystal("block_decorative_lormyte", Material.ROCK);
	public static final Block BLOCK_WOLFRAMIUM = new BlockEndBase("block_wolframium", Material.IRON);
	public static final Block ORE_WOLFRAMIUM = new BlockWolframiumOre("block_wolframium_ore", Material.ROCK);
	public static final Block BLOCK_RUNE = new BlockRune("block_rune", Material.ROCK);
	public static final Block BLOCK_END_MAGMA = new BlockEndMagma("block_end_magma");
	public static final Block BLOCK_END_FORGE = new BlockEndForge("block_end_forge");
	public static final Block DRAGON_ESSENCE = new BlockDragonEssence("dragon_essence");
	public static final Block BLOCK_E_USER = new BlockEntropyUser("entropy_user");
	public static final Block BROKEN_FLOWER = new CutoutBlock("broken_ender_flower", Material.PLANTS);

	public static final Block STAIRS_END_BRICKS = new BlockStairsBase("e_end_bricks_stairs", Blocks.END_BRICKS);
	public static final Block STAIRS_SMOOTH_END_STONE = new BlockStairsBase("smooth_end_stone_stairs", BlockInit.END_STONE_SMOOTH);
	
	public static final Block WALL_END_BRICKS = new BlockWallBase("e_end_bricks_wall", Blocks.END_BRICKS);
	public static final Block WALL_PURPUR = new BlockWallBase("e_purpur_wall", Blocks.PURPUR_BLOCK);
	public static final Block WALL_SMOOTH_END_STONE = new BlockWallBase("smooth_end_stone_wall", BlockInit.END_STONE_SMOOTH);
	
}
