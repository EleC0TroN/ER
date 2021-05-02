package com.electron.endreborn;

import com.electron.endreborn.items.*;
import com.electron.endreborn.items.materials.ModToolMaterials;
import com.electron.endreborn.items.relic.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndReborn.MODID);

	public static final RegistryObject<Item> ENDORIUM_NUGGET = ITEMS.register("endorium_nugget", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> ENDORIUM_INGOT = ITEMS.register("endorium_ingot", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<SwordItem> ENDORIUM_SWORD = ITEMS.register("endorium_sword", () -> new SwordItem(ModToolMaterials.ENDORIUM, 3, -2.4f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<AxeItem> ENDORIUM_AXE = ITEMS.register("endorium_axe", () -> new AxeItem(ModToolMaterials.ENDORIUM, 6f, -3.1f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<ShovelItem> ENDORIUM_SHOVEL = ITEMS.register("endorium_shovel", () -> new ShovelItem(ModToolMaterials.ENDORIUM, 1.5f, -3f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<HoeItem> ENDORIUM_HOE = ITEMS.register("endorium_hoe", () -> new HoeItem(ModToolMaterials.ENDORIUM,-3, -1f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<PickaxeItem> ENDORIUM_PICKAXE = ITEMS.register("endorium_pickaxe", () -> new PickaxeItem(ModToolMaterials.ENDORIUM, 1, -2.8f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> ENDORIUM_BLOCK = ITEMS.register("endorium_block", () -> new BlockItem(ModBlocks.ENDORIUM_BLOCK.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<IronHammer> TUNGSTEN_HAMMER = ITEMS.register("tungsten_hammer", () -> new IronHammer(new Item.Properties().tab(EndReborn.ENDGROUP).defaultDurability(48)));
	public static final RegistryObject<SwordItem> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () -> new SwordItem(ModToolMaterials.TUNGSTEN, 3, -2.4f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<AxeItem> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () -> new AxeItem(ModToolMaterials.TUNGSTEN, 6f, -3.1f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<ShovelItem> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel", () -> new ShovelItem(ModToolMaterials.TUNGSTEN, 1.5f, -3f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<HoeItem> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () -> new HoeItem(ModToolMaterials.TUNGSTEN,-2, -1.0F, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<PickaxeItem> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () -> new PickaxeItem(ModToolMaterials.TUNGSTEN, 1, -2.8f, new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<TungstenArmorItem> TUNGSTEN_HELMET = ITEMS.register("tungsten_helmet", () -> new TungstenArmorItem(EquipmentSlotType.HEAD));
	public static final RegistryObject<TungstenArmorItem> TUNGSTEN_CHESTPLATE = ITEMS.register("tungsten_chestplate", () -> new TungstenArmorItem(EquipmentSlotType.CHEST));
	public static final RegistryObject<TungstenArmorItem> TUNGSTEN_LEGGINGS = ITEMS.register("tungsten_leggings", () -> new TungstenArmorItem(EquipmentSlotType.LEGS));
	public static final RegistryObject<TungstenArmorItem> TUNGSTEN_BOOTS = ITEMS.register("tungsten_boots", () -> new TungstenArmorItem(EquipmentSlotType.FEET));
	public static final RegistryObject<Item> RIZIKI_RELIC = ITEMS.register("riziki_relic", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP).stacksTo(1)));
	public static final RegistryObject<Item> HVILA_RELIC = ITEMS.register("hvila_relic", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP).stacksTo(1)));
	public static final RegistryObject<BlockItem> TUNGSTEN_BLOCK = ITEMS.register("tungsten_block", () -> new BlockItem(ModBlocks.TUNGSTEN_BLOCK.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> ESSENCE = ITEMS.register("essence", EssenceItem::new);
	public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<EnderTransmitter> TRANSMITTER = ITEMS.register("ender_transmitter", () -> new EnderTransmitter(new Item.Properties().tab(EndReborn.ENDGROUP).defaultDurability(16)));
	public static final RegistryObject<EnderBoots> ENDER_BOOTS = ITEMS.register("ender_boots", () -> new EnderBoots(EquipmentSlotType.FEET));
	public static final RegistryObject<BlockItem> OBSIDIAN_GLASS_PANE = ITEMS.register("obsidian_glass_pane", () -> new BlockItem(ModBlocks.OBSIDIAN_GLASS_PANE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> OBSIDIAN_GLASS = ITEMS.register("obsidian_glass", () -> new BlockItem(ModBlocks.OBSIDIAN_GLASS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));

	//Unwanted
	public static final RegistryObject<SwordItem> ENDSTONE_SWORD = ITEMS.register("end_stone_sword", () -> new SwordItem(ModToolMaterials.ENDSTONE, 3, -2.4f, new Item.Properties().tab(null)));
	public static final RegistryObject<AxeItem> ENDSTONE_AXE = ITEMS.register("end_stone_axe", () -> new AxeItem(ModToolMaterials.ENDSTONE, 6f, -3.1f, new Item.Properties().tab(null)));
	public static final RegistryObject<ShovelItem> ENDSTONE_SHOVEL = ITEMS.register("end_stone_shovel", () -> new ShovelItem(ModToolMaterials.ENDSTONE, 1.5f, -3f, new Item.Properties().tab(null)));
	public static final RegistryObject<HoeItem> ENDSTONE_HOE = ITEMS.register("end_stone_hoe", () -> new HoeItem(ModToolMaterials.ENDSTONE,1, -1f, new Item.Properties().tab(null)));
	public static final RegistryObject<PickaxeItem> ENDSTONE_PICKAXE = ITEMS.register("end_stone_pickaxe", () -> new PickaxeItem(ModToolMaterials.ENDSTONE, 1, -2.8f, new Item.Properties().tab(null)));
	//
	public static final RegistryObject<BlockItem> END_CORAL = ITEMS.register("end_coral", () -> new BlockItem(ModBlocks.END_CORAL.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> TUNGSTEN_END_ORE = ITEMS.register("end_tungsten_ore", () -> new BlockItem(ModBlocks.TUNGSTEN_END_ORE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_STONE_SMOOTH = ITEMS.register("burned_end_stone", () -> new BlockItem(ModBlocks.END_STONE_SMOOTH.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CRACKED_END_BRICKS = ITEMS.register("cracked_end_bricks", () -> new BlockItem(ModBlocks.CRACKED_END_BRICKS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CHISELED_END_BRICKS = ITEMS.register("chiseled_end_bricks", () -> new BlockItem(ModBlocks.CHISELED_END_BRICKS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_STONE_PILLAR = ITEMS.register("end_stone_pillar", () -> new BlockItem(ModBlocks.END_STONE_PILLAR.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));

	public static final RegistryObject<PurpurEye> PURPUR_EYE = ITEMS.register("purpur_eye", () -> new PurpurEye(new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> PURPUR_LANTERN = ITEMS.register("purpur_lantern", () -> new BlockItem(ModBlocks.PURPUR_LANTERN.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> PURPUR_CHAIN = ITEMS.register("purpur_chain", () -> new BlockItem(ModBlocks.PURPUR_CHAIN.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> PURPUR_WALL = ITEMS.register("purpur_wall", () -> new BlockItem(ModBlocks.PURPUR_WALL.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> CRACKED_PURPUR = ITEMS.register("cracked_purpur", () -> new BlockItem(ModBlocks.CRACKED_PURPUR.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> OGANA_FRUIT = ITEMS.register("ogana", () -> new Item(new Item.Properties().tab(EndReborn.ENDGROUP).food(Foods.SWEET_BERRIES)));
	public static final RegistryObject<BlockItem> OGANA_WEED = ITEMS.register("ogana_weed", () -> new BlockItem(ModBlocks.OGANA_WEED.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MOSS_BLOCK = ITEMS.register("end_moss_block", () -> new BlockItem(ModBlocks.END_MOSS_BLOCK.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> END_MOSS = ITEMS.register("end_moss", () -> new BlockItem(ModBlocks.END_MOSS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));

	public static final RegistryObject<BlockItem> XORCITE = ITEMS.register("xorcite", () -> new BlockItem(ModBlocks.XORCITE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> DECORATIVE_XORCITE = ITEMS.register("decorative_xorcite", () -> new BlockItem(ModBlocks.XORCITE_DECORATIVE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> XORCITE_BRICKS = ITEMS.register("xorcite_bricks", () -> new BlockItem(ModBlocks.XORCITE_BRICKS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> XORCITE_BRICKS_STAIRS = ITEMS.register("xorcite_brick_stairs", () -> new BlockItem(ModBlocks.XORCITE_BRICKS_STAIRS.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> XORCITE_BRICKS_SLAB = ITEMS.register("xorcite_brick_slab", () -> new BlockItem(ModBlocks.XORCITE_BRICKS_SLAB.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> XORCITE_BRICKS_WALL = ITEMS.register("xorcite_brick_wall", () -> new BlockItem(ModBlocks.XORCITE_BRICKS_WALL.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));

	public static final RegistryObject<Item> SIMPLE_QUARTZ = ITEMS.register("simple_quartz", () -> new Item(new Item.Properties().tab(null)));
	public static final RegistryObject<BlockItem> DRAGONITE = ITEMS.register("dragonite", () -> new BlockItem(ModBlocks.DRAGONITE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<IronHammer> IRON_HAMMER = ITEMS.register("iron_hammer", () -> new IronHammer(new Item.Properties().tab(EndReborn.ENDGROUP).defaultDurability(32)));
	public static final RegistryObject<BlockItem> TUNGSTEN_ORE = ITEMS.register("tungsten_ore", () -> new BlockItem(ModBlocks.TUNGSTEN_ORE.get(), new Item.Properties().tab(EndReborn.ENDGROUP)));
	public static final RegistryObject<BlockItem> QUARTZ_ORE = ITEMS.register("quartz_ore", () -> new BlockItem(ModBlocks.QUARTZ_ORE.get(), new Item.Properties().tab(null)));

	public static final RegistryObject<UpgradableSwordItem> RIZIKI_ENDORIUM_SWORD = ITEMS.register("riziki_endorium_sword", () -> new UpgradableSwordItem(ModToolMaterials.ENDORIUM, 3, -2.4f, 1, 0, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradableAxeItem> RIZIKI_ENDORIUM_AXE = ITEMS.register("riziki_endorium_axe", () -> new UpgradableAxeItem(ModToolMaterials.ENDORIUM, 6f, -3.1f, 1, 0, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradableShovelItem> RIZIKI_ENDORIUM_SHOVEL = ITEMS.register("riziki_endorium_shovel", () -> new UpgradableShovelItem(ModToolMaterials.ENDORIUM, 1.5f, -3f, 1, 0, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradableHoeItem> RIZIKI_ENDORIUM_HOE = ITEMS.register("riziki_endorium_hoe", () -> new UpgradableHoeItem(ModToolMaterials.ENDORIUM,-3, -1f, 1, 0, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradablePickaxeItem> RIZIKI_ENDORIUM_PICKAXE = ITEMS.register("riziki_endorium_pickaxe", () -> new UpgradablePickaxeItem(ModToolMaterials.ENDORIUM, 1, -2.8f, 1, 0, new Item.Properties().tab(null)));

	public static final RegistryObject<UpgradableSwordItem> HVILA_ENDORIUM_SWORD = ITEMS.register("hvila_endorium_sword", () -> new UpgradableSwordItem(ModToolMaterials.ENDORIUM, 3, -2.4f, 0, 1, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradableAxeItem> HVILA_ENDORIUM_AXE = ITEMS.register("hvila_endorium_axe", () -> new UpgradableAxeItem(ModToolMaterials.ENDORIUM_FLEXIBILITY, 6f, -3.1f, 0, 1, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradableShovelItem> HVILA_ENDORIUM_SHOVEL = ITEMS.register("hvila_endorium_shovel", () -> new UpgradableShovelItem(ModToolMaterials.ENDORIUM_FLEXIBILITY, 1.5f, -3f, 0, 1, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradableHoeItem> HVILA_ENDORIUM_HOE = ITEMS.register("hvila_endorium_hoe", () -> new UpgradableHoeItem(ModToolMaterials.ENDORIUM_FLEXIBILITY,-3, -1f, 0, 1, new Item.Properties().tab(null)));
	public static final RegistryObject<UpgradablePickaxeItem> HVILA_ENDORIUM_PICKAXE = ITEMS.register("hvila_endorium_pickaxe", () -> new UpgradablePickaxeItem(ModToolMaterials.ENDORIUM_FLEXIBILITY, 1, -2.8f, 0, 1, new Item.Properties().tab(null)));

	public static final RegistryObject<MobSpawnEgg> ENDGUARD_EGG = ITEMS.register("endguard_egg", () -> new MobSpawnEgg(ModMobs.ENDGUARD, 5060690, 9725844, (new Item.Properties()).tab(ItemGroup.TAB_MISC)));

}
