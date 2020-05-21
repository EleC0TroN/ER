package com.electron.endreborn;

import com.electron.endreborn.items.*;
import com.electron.endreborn.items.materials.ModMaterials;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EndReborn.MODID);

	//Items
	public static final RegistryObject<Item> ESSENCE = ITEMS.register("essence", EssenceItem::new);
	public static final RegistryObject<Item> SIMPLE_QUARTZ = ITEMS.register("simple_quartz", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> WOLFRAMIUM_INGOT = ITEMS.register("wolframium_ingot", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> WOLFRAMIUM_NUGGET = ITEMS.register("wolframium_nugget", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<SwordItem> WOLFRAMIUM_SWORD = ITEMS.register("wolframium_sword", () -> new SwordItem(ModMaterials.TOOL_WOLFRAMIUM, 3, -2.4f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<AxeItem> WOLFRAMIUM_AXE = ITEMS.register("wolframium_axe", () -> new AxeItem(ModMaterials.TOOL_WOLFRAMIUM, 6f, -3.1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<ShovelItem> WOLFRAMIUM_SHOVEL = ITEMS.register("wolframium_shovel", () -> new ShovelItem(ModMaterials.TOOL_WOLFRAMIUM, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<HoeItem> WOLFRAMIUM_HOE = ITEMS.register("wolframium_hoe", () -> new HoeItem(ModMaterials.TOOL_WOLFRAMIUM,-1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<PickaxeItem> WOLFRAMIUM_PICKAXE = ITEMS.register("wolframium_pickaxe", () -> new PickaxeItem(ModMaterials.TOOL_WOLFRAMIUM, 1, -2.8f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> ENDORIUM_NUGGET = ITEMS.register("endorium_nugget", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> ENDORIUM_INGOT = ITEMS.register("endorium_ingot", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<SwordItem> ENDORIUM_SWORD = ITEMS.register("endorium_sword", () -> new SwordItem(ModMaterials.TOOL_ENDORIUM, 3, -2.4f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<AxeItem> ENDORIUM_AXE = ITEMS.register("endorium_axe", () -> new AxeItem(ModMaterials.TOOL_ENDORIUM, 6f, -3.1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<ShovelItem> ENDORIUM_SHOVEL = ITEMS.register("endorium_shovel", () -> new ShovelItem(ModMaterials.TOOL_ENDORIUM, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<HoeItem> ENDORIUM_HOE = ITEMS.register("endorium_hoe", () -> new HoeItem(ModMaterials.TOOL_ENDORIUM,-1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<PickaxeItem> ENDORIUM_PICKAXE = ITEMS.register("endorium_pickaxe", () -> new PickaxeItem(ModMaterials.TOOL_ENDORIUM, 1, -2.8f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<SwordItem> ENDSTONE_SWORD = ITEMS.register("end_stone_sword", () -> new SwordItem(ModMaterials.TOOL_ENDSTONE, 3, -2.4f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<AxeItem> ENDSTONE_AXE = ITEMS.register("end_stone_axe", () -> new AxeItem(ModMaterials.TOOL_ENDSTONE, 6f, -3.1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<ShovelItem> ENDSTONE_SHOVEL = ITEMS.register("end_stone_shovel", () -> new ShovelItem(ModMaterials.TOOL_ENDSTONE, 1.5f, -3f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<HoeItem> ENDSTONE_HOE = ITEMS.register("end_stone_hoe", () -> new HoeItem(ModMaterials.TOOL_ENDSTONE,-1f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<PickaxeItem> ENDSTONE_PICKAXE = ITEMS.register("end_stone_pickaxe", () -> new PickaxeItem(ModMaterials.TOOL_ENDSTONE, 1, -2.8f, new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard", () -> new Item(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<OganaFruit> OGANA_FRUIT = ITEMS.register("ogana", OganaFruit::new);
	public static final RegistryObject<IronHammer> IRON_HAMMER = ITEMS.register("iron_hammer", IronHammer::new);
	public static final RegistryObject<PurpurEye> PURPUR_EYE = ITEMS.register("purpur_eye", () -> new PurpurEye(new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<EnderTransmitter> TRANSMITTER = ITEMS.register("ender_transmitter", () -> new EnderTransmitter(new Item.Properties().group(EndReborn.ENDGROUP).defaultMaxDamage(16)));
	public static final RegistryObject<Item> ENDGUARD_EGG = ITEMS.register("endguard_egg", () -> new SpawnEggItem(ModMobs.ENDGUARD, 5060690, 9725844, (new Item.Properties()).group(ItemGroup.MISC)));

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
	public static final RegistryObject<BlockItem> PURPUR_LANTERN = ITEMS.register("purpur_lantern", () -> new BlockItem(ModBlocks.PURPUR_LANTERN.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_STONE_PILLAR = ITEMS.register("end_stone_pillar", () -> new BlockItem(ModBlocks.END_STONE_PILLAR.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CRACKED_PURPUR = ITEMS.register("cracked_purpur", () -> new BlockItem(ModBlocks.CRACKED_PURPUR.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> OGANA_WEED = ITEMS.register("ogana_weed", () -> new BlockItem(ModBlocks.OGANA_WEED.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> OBSIDIAN_GLASS = ITEMS.register("obsidian_glass", () -> new BlockItem(ModBlocks.OBSIDIAN_GLASS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CRACKED_END_BRICKS = ITEMS.register("cracked_end_bricks", () -> new BlockItem(ModBlocks.CRACKED_END_BRICKS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CHISELED_END_BRICKS = ITEMS.register("chiseled_end_bricks", () -> new BlockItem(ModBlocks.CHISELED_END_BRICKS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MOSS_BLOCK = ITEMS.register("end_moss_block", () -> new BlockItem(ModBlocks.END_MOSS_BLOCK.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_CORAL = ITEMS.register("end_coral", () -> new BlockItem(ModBlocks.END_CORAL.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MUSHROOM = ITEMS.register("end_mushroom", () -> new BlockItem(ModBlocks.END_MUSHROOM.get(), new Item.Properties().group(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> ROOTS = ITEMS.register("mushroom_roots", () -> new BlockItem(ModBlocks.ROOTS.get(), new Item.Properties().group(EndReborn.ENDGROUP)));

}
