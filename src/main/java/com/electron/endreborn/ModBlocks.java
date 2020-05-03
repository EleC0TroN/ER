package com.electron.endreborn;

import com.electron.endreborn.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, EndReborn.MODID);

	public static final RegistryObject<Block> END_STONE_SMOOTH = BLOCKS.register("burned_end_stone", RockBlock::new);
	public static final RegistryObject<Block> CRACKED_END_BRICKS = BLOCKS.register("cracked_end_bricks", RockBlock::new);
	public static final RegistryObject<Block> CHISELED_END_BRICKS = BLOCKS.register("chiseled_end_bricks", RockBlock::new);
	public static final RegistryObject<Block> QUARTZ_ORE = BLOCKS.register("quartz_ore", RockBlock::new);
	public static final RegistryObject<Block> OBSIDIAN_ORE = BLOCKS.register("obsidian_ore", ObsidianTypeBlock::new);
	public static final RegistryObject<Block> WOLFRAMIUM_ORE = BLOCKS.register("wolframium_ore", RockBlock::new);
	public static final RegistryObject<WolframiumDoor> WOLFRAMIUM_DOOR = BLOCKS.register("wolframium_door", WolframiumDoor::new);
	public static final RegistryObject<WolframiumTrapdoor> WOLFRAMIUM_TRAPDOOR = BLOCKS.register("wolframium_trapdoor", WolframiumTrapdoor::new);
	public static final RegistryObject<Block> WOLFRAMIUM_BLOCK = BLOCKS.register("wolframium_block", MetalBlock::new);
	public static final RegistryObject<WolframiumBars> WOLFRAMIUM_BARS = BLOCKS.register("wolframium_bars", WolframiumBars::new);
	public static final RegistryObject<Block> DRAGONITE = BLOCKS.register("dragonite", PlantBlock::new);
	public static final RegistryObject<Block> END_MOSS = BLOCKS.register("end_moss", EndMoss::new);
	public static final RegistryObject<Block> OGANA_PLANT = BLOCKS.register("ogana_fruit", EndPlant::new);
	public static final RegistryObject<Block> OGANA_WEED = BLOCKS.register("ogana_weed", EndPlant::new);
	public static final RegistryObject<Block> END_STONE_PILLAR = BLOCKS.register("end_stone_pillar", PillarBlock::new);
	public static final RegistryObject<Block> PURPUR_LANTERN = BLOCKS.register("purpur_lantern", EndLantern::new);
	public static final RegistryObject<Block> CRACKED_PURPUR = BLOCKS.register("cracked_purpur", RockBlock::new);
	public static final RegistryObject<Block> OBSIDIAN_GLASS = BLOCKS.register("obsidian_glass", ObsidianTypeBlock::new);

	public static void initRender(FMLClientSetupEvent event) {
		renderCutout(OGANA_PLANT.get());
		renderCutout(OGANA_WEED.get());
		renderCutout(DRAGONITE.get());
		renderCutoutMipped(OBSIDIAN_GLASS.get());
		renderCutout(WOLFRAMIUM_BARS.get());
		renderCutout(WOLFRAMIUM_DOOR.get());
		renderCutoutMipped(WOLFRAMIUM_TRAPDOOR.get());
	}
	private static void renderCutout(Block block) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	private static void renderCutoutMipped(Block block) { RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped()); }

}