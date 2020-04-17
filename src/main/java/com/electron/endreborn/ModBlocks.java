package com.electron.endreborn;

import com.electron.endreborn.blocks.WolframiumBars;
import com.electron.endreborn.blocks.EndMoss;
import com.electron.endreborn.blocks.EndPlant;
import com.electron.endreborn.blocks.MetalBlock;
import com.electron.endreborn.blocks.ObsidianOre;
import com.electron.endreborn.blocks.PlantBlock;
import com.electron.endreborn.blocks.RockBlock;
import com.electron.endreborn.blocks.WolframiumDoor;
import com.electron.endreborn.blocks.WolframiumTrapdoor;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, EndReborn.MODID);

	public static final RegistryObject<Block> END_STONE_SMOOTH = BLOCKS.register("burned_end_stone", RockBlock::new);
	public static final RegistryObject<Block> QUARTZ_ORE = BLOCKS.register("quartz_ore", RockBlock::new);
	public static final RegistryObject<Block> OBSIDIAN_ORE = BLOCKS.register("obsidian_ore", ObsidianOre::new);
	public static final RegistryObject<Block> WOLFRAMIUM_ORE = BLOCKS.register("wolframium_ore", RockBlock::new);
	public static final RegistryObject<WolframiumDoor> WOLFRAMIUM_DOOR = BLOCKS.register("wolframium_door", WolframiumDoor::new);
	public static final RegistryObject<WolframiumTrapdoor> WOLFRAMIUM_TRAPDOOR = BLOCKS.register("wolframium_trapdoor", WolframiumTrapdoor::new);
	public static final RegistryObject<Block> WOLFRAMIUM_BLOCK = BLOCKS.register("wolframium_block", MetalBlock::new);
	public static final RegistryObject<WolframiumBars> WOLFRAMIUM_BARS = BLOCKS.register("wolframium_bars", WolframiumBars::new);
	public static final RegistryObject<Block> DRAGONITE = BLOCKS.register("dragonite", PlantBlock::new);
	public static final RegistryObject<Block> END_MOSS = BLOCKS.register("end_moss", EndMoss::new);
	public static final RegistryObject<Block> OGANA_PLANT = BLOCKS.register("ogana_fruit", EndPlant::new);
	public static final RegistryObject<Block> OGANA_WEED = BLOCKS.register("ogana_weed", EndPlant::new);
}
