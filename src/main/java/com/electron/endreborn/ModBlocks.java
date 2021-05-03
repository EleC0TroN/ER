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

	public static final RegistryObject<Block> END_STONE_SMOOTH = BLOCKS.register("burned_end_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)));
	public static final RegistryObject<Block> CRACKED_END_BRICKS = BLOCKS.register("cracked_end_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)));
	public static final RegistryObject<Block> CHISELED_END_BRICKS = BLOCKS.register("chiseled_end_bricks", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)));
	public static final RegistryObject<Block> QUARTZ_ORE = BLOCKS.register("quartz_ore", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)));
	public static final RegistryObject<Block> OBSIDIAN_ORE = BLOCKS.register("obsidian_ore", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).lightValue(3).hardnessAndResistance(50.0F, 1200.0F)));
	public static final RegistryObject<Block> TUNGSTEN_ORE = BLOCKS.register("wolframium_ore", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.3F, 6.5F)));
	public static final RegistryObject<WolframiumDoor> TUNGSTEN_DOOR = BLOCKS.register("wolframium_door", WolframiumDoor::new);
	public static final RegistryObject<WolframiumTrapdoor> TUNGSTEN_TRAPDOOR = BLOCKS.register("wolframium_trapdoor", WolframiumTrapdoor::new);
	public static final RegistryObject<Block> TUNGSTEN_BLOCK = BLOCKS.register("wolframium_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(5.5F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<CustomPaneBlock> TUNGSTEN_BARS = BLOCKS.register("wolframium_bars", () -> new CustomPaneBlock(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(5.5F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> DRAGONITE = BLOCKS.register("dragonite", PlantBlock::new);
	public static final RegistryObject<Block> END_MOSS = BLOCKS.register("end_moss", EndMoss::new);
	public static final RegistryObject<Block> OGANA_WEED = BLOCKS.register("ogana_weed", OganaWeed::new);
	public static final RegistryObject<Block> END_STONE_PILLAR = BLOCKS.register("end_stone_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.1F, 6.0F)));
	public static final RegistryObject<Block> PURPUR_LANTERN = BLOCKS.register("purpur_lantern", EndLantern::new);
	public static final RegistryObject<Block> CRACKED_PURPUR = BLOCKS.register("cracked_purpur", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.0F, 6.0F)));
	public static final RegistryObject<Block> OBSIDIAN_GLASS = BLOCKS.register("obsidian_glass", () -> new GlassBlock(Block.Properties.create(Material.GLASS, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 1200f).sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> OBSIDIAN_GLASS_PANE = BLOCKS.register("obsidian_glass_pane", () -> new CustomPaneBlock(Block.Properties.create(Material.GLASS, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 1200f).sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> FRAMED_OBSIDIAN_GLASS_PANE = BLOCKS.register("framed_obsidian_glass_pane", () -> new CustomPaneBlock(Block.Properties.create(Material.GLASS, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 1200f).sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> END_MOSS_BLOCK = BLOCKS.register("end_moss_block", EndMoss::new);
	public static final RegistryObject<Block> END_MUSHROOM = BLOCKS.register("end_mushroom", MushroomBlock::new);
	public static final RegistryObject<Block> END_CORAL = BLOCKS.register("end_coral", EndstonePlant::new);
	public static final RegistryObject<Block> ROOTS = BLOCKS.register("mushroom_roots", RootsBlock::new);
	public static final RegistryObject<Block> ENDORIUM_BLOCK = BLOCKS.register("endorium_block", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.GREEN).hardnessAndResistance(5.5F, 10.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> POTTED_DRAGONITE = BLOCKS.register("potted_dragonite", () -> new FlowerPotBlock(DRAGONITE.get(), Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f, 0.0f).notSolid()));
	public static final RegistryObject<Block> END_TUNGSTEN_ORE = BLOCKS.register("end_wolframium_ore", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(2.3F, 6.5F)));

	public static final RegistryObject<Block> TUNGSTEN_SHEETMETAL = BLOCKS.register("sheetmetal_wolframium", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.GRAY).hardnessAndResistance(5.5F, 6.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> ENDORIUM_SHEETMETAL = BLOCKS.register("sheetmetal_endorium", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.GREEN).hardnessAndResistance(5.5F, 10.0F).sound(SoundType.METAL)));
	public static final RegistryObject<Block> FRAMED_OBSIDIAN_GLASS = BLOCKS.register("framed_obsidian_glass", () -> new GlassBlock(Block.Properties.create(Material.GLASS, MaterialColor.OBSIDIAN).hardnessAndResistance(50.0f, 6000.0f).sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> PURPUR_WALL = BLOCKS.register("purpur_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(2.5f, 6.0f).sound(SoundType.STONE).notSolid()));
	public static final RegistryObject<Block> ENDSTONE_BUTTON = BLOCKS.register("end_stone_button", () -> new CustomButtonBlock(Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(2.55f, 3.5f).sound(SoundType.STONE).notSolid()));

	public static void initRender(FMLClientSetupEvent event) {
		renderCutout(OGANA_WEED.get());
		renderCutout(PURPUR_WALL.get());
		renderCutout(FRAMED_OBSIDIAN_GLASS.get());
		renderCutout(POTTED_DRAGONITE.get());
		renderCutout(ROOTS.get());
		renderCutout(DRAGONITE.get());
		renderCutout(OBSIDIAN_GLASS.get());
		renderCutout(OBSIDIAN_GLASS_PANE.get());
		renderCutout(FRAMED_OBSIDIAN_GLASS_PANE.get());
		renderCutout(TUNGSTEN_BARS.get());
		renderCutout(TUNGSTEN_DOOR.get());
		renderCutout(END_CORAL.get());
		renderCutout(PURPUR_LANTERN.get());
		renderCutout(TUNGSTEN_TRAPDOOR.get());
	}
	private static void renderCutout(Block block) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
}