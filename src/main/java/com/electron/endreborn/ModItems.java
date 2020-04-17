package com.electron.endreborn;

import com.electron.endreborn.items.EnderBoots;
import com.electron.endreborn.items.EndoriumAxe;
import com.electron.endreborn.items.EndoriumHoe;
import com.electron.endreborn.items.EndoriumPickaxe;
import com.electron.endreborn.items.EndoriumShovel;
import com.electron.endreborn.items.EndoriumSword;
import com.electron.endreborn.items.EndstoneAxe;
import com.electron.endreborn.items.EndstoneHoe;
import com.electron.endreborn.items.EndstonePickaxe;
import com.electron.endreborn.items.EndstoneShovel;
import com.electron.endreborn.items.EndstoneSword;
import com.electron.endreborn.items.IronHammer;
import com.electron.endreborn.items.OganaFruit;
import com.electron.endreborn.items.WolframiumArmor;
import com.electron.endreborn.items.WolframiumAxe;
import com.electron.endreborn.items.WolframiumHoe;
import com.electron.endreborn.items.WolframiumPickaxe;
import com.electron.endreborn.items.WolframiumShovel;
import com.electron.endreborn.items.WolframiumSword;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EndReborn.MODID);
	
	//Items
	public static final RegistryObject<Item> ESSENCE = ITEMS.register("essence", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> SIMPLE_QUARTZ = ITEMS.register("simple_quartz", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> WOLFRAMIUM_INGOT = ITEMS.register("wolframium_ingot", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> WOLFRAMIUM_NUGGET = ITEMS.register("wolframium_nugget", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<WolframiumSword> WOLFRAMIUM_SWORD = ITEMS.register("wolframium_sword", WolframiumSword::new);
	public static final RegistryObject<WolframiumAxe> WOLFRAMIUM_AXE = ITEMS.register("wolframium_axe", WolframiumAxe::new);
	public static final RegistryObject<WolframiumShovel> WOLFRAMIUM_SHOVEL = ITEMS.register("wolframium_shovel", WolframiumShovel::new);
	public static final RegistryObject<WolframiumHoe> WOLFRAMIUM_HOE = ITEMS.register("wolframium_hoe", WolframiumHoe::new);
	public static final RegistryObject<WolframiumPickaxe> WOLFRAMIUM_PICKAXE = ITEMS.register("wolframium_pickaxe", WolframiumPickaxe::new);
	public static final RegistryObject<Item> ENDORIUM_NUGGET = ITEMS.register("endorium_nugget", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> ENDORIUM_INGOT = ITEMS.register("endorium_ingot", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<EndoriumSword> ENDORIUM_SWORD = ITEMS.register("endorium_sword", EndoriumSword::new);
	public static final RegistryObject<EndoriumAxe> ENDORIUM_AXE = ITEMS.register("endorium_axe", EndoriumAxe::new);
	public static final RegistryObject<EndoriumShovel> ENDORIUM_SHOVEL = ITEMS.register("endorium_shovel", EndoriumShovel::new);
	public static final RegistryObject<EndoriumHoe> ENDORIUM_HOE = ITEMS.register("endorium_hoe", EndoriumHoe::new);
	public static final RegistryObject<EndoriumPickaxe> ENDORIUM_PICKAXE = ITEMS.register("endorium_pickaxe", EndoriumPickaxe::new);
	public static final RegistryObject<EndstoneSword> ENDSTONE_SWORD = ITEMS.register("end_stone_sword", EndstoneSword::new);
	public static final RegistryObject<EndstoneAxe> ENDSTONE_AXE = ITEMS.register("end_stone_axe", EndstoneAxe::new);
	public static final RegistryObject<EndstoneShovel> ENDSTONE_SHOVEL = ITEMS.register("end_stone_shovel", EndstoneShovel::new);
	public static final RegistryObject<EndstoneHoe> ENDSTONE_HOE = ITEMS.register("end_stone_hoe", EndstoneHoe::new);
	public static final RegistryObject<EndstonePickaxe> ENDSTONE_PICKAXE = ITEMS.register("end_stone_pickaxe", EndstonePickaxe::new);
	public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<OganaFruit> OGANA_FRUIT = ITEMS.register("ogana", OganaFruit::new);
	public static final RegistryObject<IronHammer> IRON_HAMMER = ITEMS.register("iron_hammer", IronHammer::new);
	
	//Armor
	public static final RegistryObject<WolframiumArmor> WOLFRAMIUM_HELMET = ITEMS.register("wolframium_helmet", () -> new WolframiumArmor(EquipmentSlotType.HEAD));
	public static final RegistryObject<WolframiumArmor> WOLFRAMIUM_CHESTPLATE = ITEMS.register("wolframium_chestplate", () -> new WolframiumArmor(EquipmentSlotType.CHEST));
	public static final RegistryObject<WolframiumArmor> WOLFRAMIUM_LEGGINGS = ITEMS.register("wolframium_leggings", () -> new WolframiumArmor(EquipmentSlotType.LEGS));
	public static final RegistryObject<WolframiumArmor> WOLFRAMIUM_BOOTS = ITEMS.register("wolframium_boots", () -> new WolframiumArmor(EquipmentSlotType.FEET));
	public static final RegistryObject<EnderBoots> ENDER_BOOTS = ITEMS.register("ender_boots", () -> new EnderBoots(EquipmentSlotType.FEET));

	//Blocks
	public static final RegistryObject<BlockItem> WOLFRAMIUM_DOOR = ITEMS.register("wolframium_door", () -> new BlockItem(ModBlocks.WOLFRAMIUM_DOOR.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> WOLFRAMIUM_TRAPDOOR = ITEMS.register("wolframium_trapdoor", () -> new BlockItem(ModBlocks.WOLFRAMIUM_TRAPDOOR.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> WOLFRAMIUM_BLOCK = ITEMS.register("wolframium_block", () -> new BlockItem(ModBlocks.WOLFRAMIUM_BLOCK.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> WOLFRAMIUM_BARS = ITEMS.register("wolframium_bars", () -> new BlockItem(ModBlocks.WOLFRAMIUM_BARS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> WOLFRAMIUM_ORE = ITEMS.register("wolframium_ore", () -> new BlockItem(ModBlocks.WOLFRAMIUM_ORE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_STONE_SMOOTH = ITEMS.register("burned_end_stone", () -> new BlockItem(ModBlocks.END_STONE_SMOOTH.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> QUARTZ_ORE = ITEMS.register("quartz_ore", () -> new BlockItem(ModBlocks.QUARTZ_ORE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> OBSIDIAN_ORE = ITEMS.register("obsidian_ore", () -> new BlockItem(ModBlocks.OBSIDIAN_ORE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> DRAGONITE = ITEMS.register("dragonite", () -> new BlockItem(ModBlocks.DRAGONITE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MOSS = ITEMS.register("end_moss", () -> new BlockItem(ModBlocks.END_MOSS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> OGANA_PLANT = ITEMS.register("ogana_fruit", () -> new BlockItem(ModBlocks.OGANA_PLANT.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	
}
