package net.electron.endreborn.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks
{
    public static final Block TUNGSTEN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0F).build());
    public static final Block TUNGSTEN_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block END_TUNGSTEN_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block BURNED_END_STONE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block OBSIDIAN_GLASS = new GlassBlock(FabricBlockSettings.of(Material.GLASS).hardness(50.0f).resistance(6000.0f).nonOpaque().build());
    public static final Block OBSIDIAN_GLASS_PANE = new PaneBase(FabricBlockSettings.of(Material.GLASS).hardness(25.0f).resistance(6000.0f).nonOpaque().build());
    public static final Block QUARTZ_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block OGANA_WEED = new OganaPlant(FabricBlockSettings.copy(net.minecraft.block.Blocks.DEAD_BUSH).build());
    public static final Block DRAGONITE = new PlantBase(FabricBlockSettings.copy(net.minecraft.block.Blocks.DEAD_BUSH).build());
    public static final Block CRACKED_END_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block CRACKED_PURPUR = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block CHISELED_END_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block PURPUR_LANTERN = new LanternBlock(FabricBlockSettings.of(Material.STONE).hardness(3.0F).lightLevel(10).build());
    public static final Block END_STONE_PILLAR = new PillarBlock(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block END_MOSS = new EndMoss();
    public static final Block END_CORAL = new EndstonePlant(FabricBlockSettings.copy(net.minecraft.block.Blocks.DEAD_BUSH).build());
    public static final Block ENDORIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(5.0F).build());
    public static final Block END_MOSS_BLOCK = new EndMoss();
    public static final Block ROOTS = new RootsBlock();
    public static final Block XORCITE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block DECORATIVE_XORCITE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block PURPUR_CHAIN = new ChainBlock(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block PURPUR_WALL = new WallBlock(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block POTTED_DRAGONITE = new FlowerPotBlock(DRAGONITE, AbstractBlock.Settings.of(Material.SUPPORTED).breakInstantly().nonOpaque());
    public static void registerBlocks()
    {
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "tungsten_block"), TUNGSTEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "tungsten_ore"), TUNGSTEN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "end_tungsten_ore"), END_TUNGSTEN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "burned_end_stone"), BURNED_END_STONE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "quartz_ore"), QUARTZ_ORE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "end_moss"), END_MOSS);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "ogana_weed"), OGANA_WEED);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "dragonite"), DRAGONITE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "cracked_end_bricks"), CRACKED_END_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "chiseled_end_bricks"), CHISELED_END_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "cracked_purpur"), CRACKED_PURPUR);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "obsidian_glass"), OBSIDIAN_GLASS);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "obsidian_glass_pane"), OBSIDIAN_GLASS_PANE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "purpur_lantern"), PURPUR_LANTERN);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "end_moss_block"), END_MOSS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "end_stone_pillar"), END_STONE_PILLAR);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "end_coral"), END_CORAL);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "endorium_block"), ENDORIUM_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "xorcite"), XORCITE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "decorative_xorcite"), DECORATIVE_XORCITE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "mushroom_roots"), ROOTS);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "purpur_chain"), PURPUR_CHAIN);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "purpur_wall"), PURPUR_WALL);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "potted_dragonite"), POTTED_DRAGONITE);
    }
}