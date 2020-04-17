package net.electron.endreborn.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Settings;
import net.minecraft.block.FlowerBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks
{
    public static final Block WOLF_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0F).build());
    public static final Block WOLF_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block WOLF_DOOR = new DoorBase(FabricBlockSettings.of(Material.METAL).hardness(4.0F).build());
    public static final Block WOLF_TRAPDOOR = new TrapdoorBase(FabricBlockSettings.of(Material.METAL).hardness(4.0F).build());
    public static final Block WOLF_BARS = new PaneBase(FabricBlockSettings.of(Material.METAL).hardness(4.0F).build());
    public static final Block BURNED_END_STONE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block OBSIDIAN_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(8.0F).build());
    public static final Block QUARTZ_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).build());
    public static final Block OGANA_PLANT = new OganaPlant(FabricBlockSettings.copy(net.minecraft.block.Blocks.DEAD_BUSH).build());
    public static final Block OGANA_WEED = new OganaPlant(FabricBlockSettings.copy(net.minecraft.block.Blocks.DEAD_BUSH).build());
    public static final Block DRAGONITE = new PlantBase(FabricBlockSettings.copy(net.minecraft.block.Blocks.DEAD_BUSH).build());
    public static final Block END_MOSS = new EndMoss();
    public static void registerBlocks()
    {
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "wolframium_block"), WOLF_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "wolframium_ore"), WOLF_ORE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "burned_end_stone"), BURNED_END_STONE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "wolframium_door"), WOLF_DOOR);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "wolframium_trapdoor"), WOLF_TRAPDOOR);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "wolframium_bars"), WOLF_BARS);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "obsidian_ore"), OBSIDIAN_ORE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "quartz_ore"), QUARTZ_ORE);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "end_moss"), END_MOSS);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "ogana_fruit"), OGANA_PLANT);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "ogana_weed"), OGANA_WEED);
        Registry.register(Registry.BLOCK, new Identifier("endreborn", "dragonite"), DRAGONITE);
      
    }
}