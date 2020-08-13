package com.electron.endreborn;

import com.electron.endreborn.blocks.*;
import com.electron.endreborn.blocks.MushroomBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
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
	public static final RegistryObject<Block> OBSIDIAN_ORE = BLOCKS.register("obsidian_ore", CryingObsidian::new);
	public static final RegistryObject<Block> WOLFRAMIUM_ORE = BLOCKS.register("wolframium_ore", RockBlock::new);
	public static final RegistryObject<WolframiumDoor> WOLFRAMIUM_DOOR = BLOCKS.register("wolframium_door", WolframiumDoor::new);
	public static final RegistryObject<WolframiumTrapdoor> WOLFRAMIUM_TRAPDOOR = BLOCKS.register("wolframium_trapdoor", WolframiumTrapdoor::new);
	public static final RegistryObject<Block> WOLFRAMIUM_BLOCK = BLOCKS.register("wolframium_block", MetalBlock::new);
	public static final RegistryObject<WolframiumBars> WOLFRAMIUM_BARS = BLOCKS.register("wolframium_bars", WolframiumBars::new);
	public static final RegistryObject<Block> DRAGONITE = BLOCKS.register("dragonite", PlantBlock::new);
	public static final RegistryObject<Block> END_MOSS = BLOCKS.register("end_moss", EndMoss::new);
	public static final RegistryObject<Block> OGANA_WEED = BLOCKS.register("ogana_weed", OganaWeed::new);
	public static final RegistryObject<Block> END_STONE_PILLAR = BLOCKS.register("end_stone_pillar", PillarBlock::new);
	public static final RegistryObject<Block> PURPUR_LANTERN = BLOCKS.register("purpur_lantern", EndLantern::new);
	public static final RegistryObject<Block> CRACKED_PURPUR = BLOCKS.register("cracked_purpur", RockBlock::new);
	public static final RegistryObject<Block> OBSIDIAN_GLASS = BLOCKS.register("obsidian_glass", () -> new GlassBlock(Block.Properties.create(Material.GLASS, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 6000.0f).sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> END_MOSS_BLOCK = BLOCKS.register("end_moss_block", EndMoss::new);
	public static final RegistryObject<Block> END_MUSHROOM = BLOCKS.register("end_mushroom", MushroomBlock::new);
	public static final RegistryObject<Block> END_CORAL = BLOCKS.register("end_coral", EndstonePlant::new);
	public static final RegistryObject<Block> ROOTS = BLOCKS.register("mushroom_roots", RootsBlock::new);
	public static final RegistryObject<Block> ENDORIUM_BLOCK = BLOCKS.register("endorium_block", MetalBlock::new);
	public static final RegistryObject<Block> POTTED_DRAGONITE = BLOCKS.register("potted_dragonite", () -> new FlowerPotBlock(DRAGONITE.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f, 0.0f).notSolid()));
	public static final RegistryObject<Block> END_WOLFRAMIUM_ORE = BLOCKS.register("end_wolframium_ore", RockBlock::new);

	public static final RegistryObject<Block> WOLFRAMIUM_SHEETMETAL = BLOCKS.register("sheetmetal_wolframium", MetalBlock::new);
	public static final RegistryObject<Block> ENDORIUM_SHEETMETAL = BLOCKS.register("sheetmetal_endorium", MetalBlock::new);
	public static final RegistryObject<Block> FRAMED_OBSIDIAN_GLASS = BLOCKS.register("framed_obsidian_glass", () -> new GlassBlock(Block.Properties.create(Material.GLASS, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 6000.0f).sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> PURPUR_WALL = BLOCKS.register("purpur_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(2.55f, 3.5f).sound(SoundType.STONE).notSolid()));
	public static final RegistryObject<Block> ENDSTONE_BUTTON = BLOCKS.register("end_stone_button", () -> new CustomButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(2.55f, 3.5f).sound(SoundType.STONE).notSolid()));

	public static void initRender(FMLClientSetupEvent event) {
		renderCutout(OGANA_WEED.get());
		renderCutout(PURPUR_WALL.get());
		renderCutout(FRAMED_OBSIDIAN_GLASS.get());
		renderCutout(POTTED_DRAGONITE.get());
		renderCutout(ROOTS.get());
		renderCutout(DRAGONITE.get());
		renderCutout(OBSIDIAN_GLASS.get());
		renderCutout(WOLFRAMIUM_BARS.get());
		renderCutout(WOLFRAMIUM_DOOR.get());
		renderCutout(END_CORAL.get());
		renderCutout(PURPUR_LANTERN.get());
		renderCutout(WOLFRAMIUM_TRAPDOOR.get());
	}
	private static void renderCutout(Block block) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
}