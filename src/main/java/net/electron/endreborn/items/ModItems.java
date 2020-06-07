package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.electron.endreborn.blocks.ModBlocks;
import net.electron.endreborn.items.materials.Materials;
import net.electron.endreborn.mobs.Mobs;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{
    //ModItems
    public static final Item WOLF_INGOT = new Item(new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_NUGGET = new Item(new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item ESSENCE = new Item(new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item SIMPLE_QUARTZ = new Item(new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item END_NUGGET = new Item(new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item END_INGOT = new Item(new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item OBSIDIAN_SHARD = new Item(new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item OGANA_FRUIT = new OganaFruit();
    public static final Item ENDER_TRANSMITTER = new EnderTransmitter();
    public static final Item PURPUR_EYE = new PurpurEye();
    public static final Item ENDGUARD_EGG = new SpawnEggItem(Mobs.ENDGUARD, 5060690, 9725844, (new Item.Settings()).group(ItemGroup.MISC));

    //Tools
	public static final Item WOLF_SWORD = new SwordItem(Materials.WOLF_TOOL, 3, -2.4F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_PICKAXE = new PickaxeBase(Materials.WOLF_TOOL, 2, -2.8F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_AXE = new AxeBase(Materials.WOLF_TOOL, 6, -3.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_SHOVEL = new ShovelBase(Materials.WOLF_TOOL, 2.5F, -3.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_HOE = new HoeBase(Materials.WOLF_TOOL, 0.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item END_SWORD = new SwordItem(Materials.ENDSTONE, 3, -2.4F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item END_PICKAXE = new PickaxeBase(Materials.ENDSTONE, 1, -2.8F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item END_AXE = new AxeBase(Materials.ENDSTONE, 5, -3.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item END_SHOVEL = new ShovelBase(Materials.ENDSTONE, 1.5F, -3.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item END_HOE = new HoeBase(Materials.ENDSTONE, 0.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item ENDOR_SWORD = new SwordItem(Materials.ENDORIUM, 3, -2.4F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item ENDOR_PICKAXE = new PickaxeBase(Materials.ENDORIUM, 1, -2.8F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item ENDOR_AXE = new AxeBase(Materials.ENDORIUM, 5, -3.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item ENDOR_SHOVEL = new ShovelBase(Materials.ENDORIUM, 1.5F, -3.0F, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item ENDOR_HOE = new HoeBase(Materials.ENDORIUM, 0.0F, new Item.Settings().group(EndReborn.END_GROUP));

    //Armor
    public static final Item WOLF_HELMET = new ArmorItem(Materials.WOLF_ARMOR, EquipmentSlot.HEAD, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_CHEST = new ArmorItem(Materials.WOLF_ARMOR, EquipmentSlot.CHEST, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_LEGS = new ArmorItem(Materials.WOLF_ARMOR, EquipmentSlot.LEGS, new Item.Settings().group(EndReborn.END_GROUP));
    public static final Item WOLF_BOOTS = new ArmorItem(Materials.WOLF_ARMOR, EquipmentSlot.FEET, new Item.Settings().group(EndReborn.END_GROUP));
   
    public static void registerItems()
    {
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_ingot"), WOLF_INGOT);
		Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_nugget"), WOLF_NUGGET);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_sword"), WOLF_SWORD);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_pickaxe"), WOLF_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_axe"), WOLF_AXE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_shovel"), WOLF_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_hoe"), WOLF_HOE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_stone_sword"), END_SWORD);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_stone_pickaxe"), END_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_stone_axe"), END_AXE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_stone_shovel"), END_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_stone_hoe"), END_HOE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "essence"), ESSENCE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "ogana"), OGANA_FRUIT);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_nugget"), END_NUGGET);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_ingot"), END_INGOT);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "simple_quartz"), SIMPLE_QUARTZ);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_sword"), ENDOR_SWORD);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_pickaxe"), ENDOR_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_axe"), ENDOR_AXE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_hoe"), ENDOR_HOE);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_shovel"), ENDOR_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "obsidian_shard"), OBSIDIAN_SHARD);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "ender_transmitter"), ENDER_TRANSMITTER);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "purpur_eye"), PURPUR_EYE);

        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_helmet"), WOLF_HELMET);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_chestplate"), WOLF_CHEST);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_leggings"), WOLF_LEGS);
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_boots"), WOLF_BOOTS);

        //Blocks
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_block"), new BlockItem(ModBlocks.WOLF_BLOCK, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "burned_end_stone"), new BlockItem(ModBlocks.BURNED_END_STONE, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_door"), new BlockItem(ModBlocks.WOLF_DOOR, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_trapdoor"), new BlockItem(ModBlocks.WOLF_TRAPDOOR, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_bars"), new BlockItem(ModBlocks.WOLF_BARS, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "wolframium_ore"), new BlockItem(ModBlocks.WOLF_ORE, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "obsidian_ore"), new BlockItem(ModBlocks.OBSIDIAN_ORE, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "quartz_ore"), new BlockItem(ModBlocks.QUARTZ_ORE, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_moss"), new BlockItem(ModBlocks.END_MOSS, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "ogana_fruit"), new BlockItem(ModBlocks.OGANA_PLANT, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "ogana_weed"), new BlockItem(ModBlocks.OGANA_WEED, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "dragonite"), new BlockItem(ModBlocks.DRAGONITE, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "chiseled_end_bricks"), new BlockItem(ModBlocks.CHISELED_END_BRICKS, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "cracked_end_bricks"), new BlockItem(ModBlocks.CRACKED_END_BRICKS, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "cracked_purpur"), new BlockItem(ModBlocks.CRACKED_PURPUR, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "obsidian_glass"), new BlockItem(ModBlocks.OBSIDIAN_GLASS, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "purpur_lantern"), new BlockItem(ModBlocks.PURPUR_LANTERN, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_moss_block"), new BlockItem(ModBlocks.END_MOSS_BLOCK, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_stone_pillar"), new BlockItem(ModBlocks.END_STONE_PILLAR, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_coral"), new BlockItem(ModBlocks.END_CORAL, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "endorium_block"), new BlockItem(ModBlocks.ENDORIUM_BLOCK, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "end_mushroom"), new BlockItem(ModBlocks.ENDSHROOM, new Item.Settings().group(EndReborn.END_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("endreborn", "mushroom_roots"), new BlockItem(ModBlocks.ENDSHROOM_ROOTS, new Item.Settings().group(EndReborn.END_GROUP)));

    }
}
