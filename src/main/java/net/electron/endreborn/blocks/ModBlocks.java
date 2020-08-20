package net.electron.endreborn.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class ModBlocks {
    public static final Block TUNGSTEN_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL, MaterialColor.GRAY).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final Block TUNGSTEN_ORE = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.DIRT).requiresTool().strength(1.5F, 6.0F));
    public static final Block END_TUNGSTEN_ORE = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.SAND).requiresTool().strength(3.0F, 9.0F));
    public static final Block BURNED_END_STONE = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.SAND).requiresTool().strength(3.0F, 9.0F));
    public static final Block OBSIDIAN_GLASS = new GlassBlock(AbstractBlock.Settings.of(Material.GLASS).strength(8.0F, 800.0F).nonOpaque().allowsSpawning(ModBlocks::never).solidBlock(ModBlocks::never).suffocates(ModBlocks::never).blockVision(ModBlocks::never));
    public static final Block OBSIDIAN_GLASS_PANE = new PaneBase(AbstractBlock.Settings.of(Material.GLASS).strength(6.0F, 800.0F).nonOpaque().allowsSpawning(ModBlocks::never).solidBlock(ModBlocks::never).suffocates(ModBlocks::never).blockVision(ModBlocks::never));
    public static final Block QUARTZ_ORE = new Block(FabricBlockSettings.of(Material.STONE).resistance(3.0f).hardness(3.0F).build());
    public static final Block OGANA_WEED = new OganaPlant(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.DEAD_BUSH));
    public static final Block DRAGONITE = new PlantBase(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.DEAD_BUSH));
    public static final Block CRACKED_END_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.SAND).requiresTool().strength(3.0F, 9.0F));
    public static final Block CRACKED_PURPUR = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.MAGENTA).requiresTool().strength(1.5F, 6.0F));
    public static final Block CHISELED_END_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.SAND).requiresTool().strength(3.0F, 9.0F));
    public static final Block PURPUR_LANTERN = new LanternBlock(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).lightLevel((state) -> { return 10; }).nonOpaque());
    public static final Block END_STONE_PILLAR = new PillarBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.SAND).requiresTool().strength(3.0F, 9.0F));
    public static final Block END_MOSS = new EndMoss(AbstractBlock.Settings.of(Material.STONE, MaterialColor.PURPLE).requiresTool().strength(3.0F, 9.0F));
    public static final Block END_CORAL = new EndstonePlant(AbstractBlock.Settings.copy(net.minecraft.block.Blocks.DEAD_BUSH));
    public static final Block ENDORIUM_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL, MaterialColor.GREEN).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final Block END_MOSS_BLOCK = new EndMoss(AbstractBlock.Settings.of(Material.STONE, MaterialColor.PURPLE).requiresTool().strength(3.0F, 9.0F));
    public static final Block ROOTS = new RootsBlock();
    public static final Block XORCITE = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.LAPIS).requiresTool().strength(3.0F, 9.0F));
    public static final Block DECORATIVE_XORCITE = new Block(AbstractBlock.Settings.of(Material.STONE, MaterialColor.LAPIS).requiresTool().strength(3.0F, 9.0F));
    public static final Block PURPUR_CHAIN = new ChainBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.CLEAR).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque());
    public static final Block PURPUR_WALL = new WallBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.MAGENTA).requiresTool().strength(1.5F, 6.0F));
    public static final Block POTTED_DRAGONITE = new FlowerPotBlock(DRAGONITE, AbstractBlock.Settings.of(Material.SUPPORTED).breakInstantly().nonOpaque());
    public static void registerBlocks() {
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

    private static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }
    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }
}