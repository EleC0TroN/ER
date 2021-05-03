package com.electron.endreborn;

import com.electron.endreborn.items.*;
import com.electron.endreborn.items.materials.ModToolMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EndReborn.MODID);

	public static final RegistryObject<Item> ENDORIUM_NUGGET = ITEMS.register("endorium_nugget", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> ENDORIUM_INGOT = ITEMS.register("endorium_ingot", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<SwordItem> ENDORIUM_SWORD = ITEMS.register("endorium_sword", () -> new SwordItem(ModToolMaterials.ENDORIUM, 3, -2.4f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<AxeItem> ENDORIUM_AXE = ITEMS.register("endorium_axe", () -> new AxeItem(ModToolMaterials.ENDORIUM, 6f, -3.1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<ShovelItem> ENDORIUM_SHOVEL = ITEMS.register("endorium_shovel", () -> new ShovelItem(ModToolMaterials.ENDORIUM, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<HoeItem> ENDORIUM_HOE = ITEMS.register("endorium_hoe", () -> new HoeItem(ModToolMaterials.ENDORIUM,-1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<PickaxeItem> ENDORIUM_PICKAXE = ITEMS.register("endorium_pickaxe", () -> new PickaxeItem(ModToolMaterials.ENDORIUM, 1, -2.8f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> ENDORIUM_BLOCK = ITEMS.register("endorium_block", () -> new BlockItem(ModBlocks.ENDORIUM_BLOCK.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("wolframium_nugget", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("wolframium_ingot", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<IronHammer> TUNGSTEN_HAMMER = ITEMS.register("tungsten_hammer", () -> new IronHammer(new Item.Properties().group(EndReborn.ENDGROUP).defaultMaxDamage(48)));
	public static final RegistryObject<SwordItem> TUNGSTEN_SWORD = ITEMS.register("wolframium_sword", () -> new SwordItem(ModToolMaterials.TUNGSTEN, 3, -2.4f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<AxeItem> TUNGSTEN_AXE = ITEMS.register("wolframium_axe", () -> new AxeItem(ModToolMaterials.TUNGSTEN, 6f, -3.1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<ShovelItem> TUNGSTEN_SHOVEL = ITEMS.register("wolframium_shovel", () -> new ShovelItem(ModToolMaterials.TUNGSTEN, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<HoeItem> TUNGSTEN_HOE = ITEMS.register("wolframium_hoe", () -> new HoeItem(ModToolMaterials.TUNGSTEN,-1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<PickaxeItem> TUNGSTEN_PICKAXE = ITEMS.register("wolframium_pickaxe", () -> new PickaxeItem(ModToolMaterials.TUNGSTEN, 1, -2.8f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<TungstenArmor> TUNGSTEN_HELMET = ITEMS.register("wolframium_helmet", () -> new TungstenArmor(EquipmentSlotType.HEAD));
	public static final RegistryObject<TungstenArmor> TUNGSTEN_CHESTPLATE = ITEMS.register("wolframium_chestplate", () -> new TungstenArmor(EquipmentSlotType.CHEST));
	public static final RegistryObject<TungstenArmor> TUNGSTEN_LEGGINGS = ITEMS.register("wolframium_leggings", () -> new TungstenArmor(EquipmentSlotType.LEGS));
	public static final RegistryObject<TungstenArmor> TUNGSTEN_BOOTS = ITEMS.register("wolframium_boots", () -> new TungstenArmor(EquipmentSlotType.FEET));
	public static final RegistryObject<BlockItem> TUNGSTEN_BLOCK = ITEMS.register("wolframium_block", () -> new BlockItem(ModBlocks.TUNGSTEN_BLOCK.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> ESSENCE = ITEMS.register("essence", EssenceItem::new);
	public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<EnderTransmitter> TRANSMITTER = ITEMS.register("ender_transmitter", () -> new EnderTransmitter(new Item.Properties().group(EndReborn.ENDGROUP).defaultMaxDamage(16)));
	public static final RegistryObject<EnderBoots> ENDER_BOOTS = ITEMS.register("ender_boots", () -> new EnderBoots(EquipmentSlotType.FEET));
	public static final RegistryObject<BlockItem> OBSIDIAN_GLASS_PANE = ITEMS.register("obsidian_glass_pane", () -> new BlockItem(ModBlocks.OBSIDIAN_GLASS_PANE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> OBSIDIAN_GLASS = ITEMS.register("obsidian_glass", () -> new BlockItem(ModBlocks.OBSIDIAN_GLASS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> OBSIDIAN_ORE = ITEMS.register("obsidian_ore", () -> new BlockItem(ModBlocks.OBSIDIAN_ORE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

	public static final RegistryObject<BlockItem> END_CORAL = ITEMS.register("end_coral", () -> new BlockItem(ModBlocks.END_CORAL.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_TUNGSTEN_ORE = ITEMS.register("end_wolframium_ore", () -> new BlockItem(ModBlocks.END_TUNGSTEN_ORE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_STONE_SMOOTH = ITEMS.register("burned_end_stone", () -> new BlockItem(ModBlocks.END_STONE_SMOOTH.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CRACKED_END_BRICKS = ITEMS.register("cracked_end_bricks", () -> new BlockItem(ModBlocks.CRACKED_END_BRICKS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CHISELED_END_BRICKS = ITEMS.register("chiseled_end_bricks", () -> new BlockItem(ModBlocks.CHISELED_END_BRICKS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_STONE_PILLAR = ITEMS.register("end_stone_pillar", () -> new BlockItem(ModBlocks.END_STONE_PILLAR.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

	public static final RegistryObject<PurpurEye> PURPUR_EYE = ITEMS.register("purpur_eye", () -> new PurpurEye(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> PURPUR_LANTERN = ITEMS.register("purpur_lantern", () -> new BlockItem(ModBlocks.PURPUR_LANTERN.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> PURPUR_WALL = ITEMS.register("purpur_wall", () -> new BlockItem(ModBlocks.PURPUR_WALL.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CRACKED_PURPUR = ITEMS.register("cracked_purpur", () -> new BlockItem(ModBlocks.CRACKED_PURPUR.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> OGANA_FRUIT = ITEMS.register("ogana", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP).food(Foods.SWEET_BERRIES)));
	public static final RegistryObject<BlockItem> OGANA_WEED = ITEMS.register("ogana_weed", () -> new BlockItem(ModBlocks.OGANA_WEED.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> ROOTS = ITEMS.register("mushroom_roots", () -> new BlockItem(ModBlocks.ROOTS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MOSS_BLOCK = ITEMS.register("end_moss_block", () -> new BlockItem(ModBlocks.END_MOSS_BLOCK.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MOSS = ITEMS.register("end_moss", () -> new BlockItem(ModBlocks.END_MOSS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MUSHROOM = ITEMS.register("end_mushroom", () -> new BlockItem(ModBlocks.END_MUSHROOM.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

	public static final RegistryObject<BlockItem> DRAGONITE = ITEMS.register("dragonite", () -> new BlockItem(ModBlocks.DRAGONITE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<IronHammer> IRON_HAMMER = ITEMS.register("iron_hammer", () -> new IronHammer(new Item.Properties().group(EndReborn.ENDGROUP).defaultMaxDamage(32)));
	public static final RegistryObject<BlockItem> TUNGSTEN_ORE = ITEMS.register("wolframium_ore", () -> new BlockItem(ModBlocks.TUNGSTEN_ORE.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> ENDGUARD_EGG = ITEMS.register("endguard_egg", () -> new SpawnEggItem(ModMobs.ENDGUARD, 5060690, 9725844, (new Item.Properties()).group(ItemGroup.MISC)));

	public static final RegistryObject<HorseArmorItem> TUNGSTEN_HORSE_ARMOR = ITEMS.register("wolframium_horse_armor", () -> new HorseArmorItem(6, "wolframium", new Item.Properties().group(null)));
	public static final RegistryObject<BlockItem> TUNGSTEN_DOOR = ITEMS.register("wolframium_door", () -> new BlockItem(ModBlocks.TUNGSTEN_DOOR.get(), new Item.Properties().group(null)));
	public static final RegistryObject<BlockItem> TUNGSTEN_TRAPDOOR = ITEMS.register("wolframium_trapdoor", () -> new BlockItem(ModBlocks.TUNGSTEN_TRAPDOOR.get(), new Item.Properties().group(null)));
	public static final RegistryObject<BlockItem> TUNGSTEN_BARS = ITEMS.register("wolframium_bars", () -> new BlockItem(ModBlocks.TUNGSTEN_BARS.get(), new Item.Properties().group(null)));
	public static final RegistryObject<SwordItem> ENDSTONE_SWORD = ITEMS.register("end_stone_sword", () -> new SwordItem(ModToolMaterials.ENDSTONE, 3, -2.4f, new Item.Properties().group(null)));
	public static final RegistryObject<AxeItem> ENDSTONE_AXE = ITEMS.register("end_stone_axe", () -> new AxeItem(ModToolMaterials.ENDSTONE, 6f, -3.1f, new Item.Properties().group(null)));
	public static final RegistryObject<ShovelItem> ENDSTONE_SHOVEL = ITEMS.register("end_stone_shovel", () -> new ShovelItem(ModToolMaterials.ENDSTONE, 1.5f, -3f, new Item.Properties().group(null)));
	public static final RegistryObject<HoeItem> ENDSTONE_HOE = ITEMS.register("end_stone_hoe", () -> new HoeItem(ModToolMaterials.ENDSTONE,-1f, new Item.Properties().group(null)));
	public static final RegistryObject<PickaxeItem> ENDSTONE_PICKAXE = ITEMS.register("end_stone_pickaxe", () -> new PickaxeItem(ModToolMaterials.ENDSTONE, 1, -2.8f, new Item.Properties().group(null)));
	public static final RegistryObject<Item> SIMPLE_QUARTZ = ITEMS.register("simple_quartz", () -> new Item(new Item.Properties().group(null)));
	public static final RegistryObject<BlockItem> QUARTZ_ORE = ITEMS.register("quartz_ore", () -> new BlockItem(ModBlocks.QUARTZ_ORE.get(), new Item.Properties().group(null)));

}
