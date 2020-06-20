package endreborn.init;

import java.util.ArrayList;
import java.util.List;


import endreborn.Reference;
import endreborn.handlers.SoundHandler;
import endreborn.mod.armor.ArmourBase;
import endreborn.mod.armor.ArmourDModel;
import endreborn.mod.armor.ArmourModel;
import endreborn.mod.food.FoodChorusSoup;
import endreborn.mod.food.FoodDragonBerries;
import endreborn.mod.food.FoodEnderFlesh;
import endreborn.mod.items.*;
import endreborn.mod.tools.*;
import endreborn.mod.tools.axes.EndoriumAxe;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
    public static final List<Item> ITEMS = new ArrayList<Item>();
    
    //Materials
    public static final ToolMaterial TOOL_ENDORIUM = EnumHelper.addToolMaterial("tool_endorium", 4, 1024, 6.5F, 4.0F, 13);
    public static final ToolMaterial TOOL_MAGNIFIER = EnumHelper.addToolMaterial("tool_magnifier", 4, 256, 5.5F, 1.0F, 13);
    public static final ToolMaterial TOOL_END = EnumHelper.addToolMaterial("tool_end", 5, 1024, 6.5F, 9.0F, 14);
    public static final ToolMaterial TOOL_HAMMER = EnumHelper.addToolMaterial("tool_hammer", 2, 300, 1.0F, 4.0F, 9);
    public static final ToolMaterial TOOL_WOLFRAMIUM = EnumHelper.addToolMaterial("tool_wolframium", 3, 512, 5.5F, 2.5F, 11);
    public static final ArmorMaterial ARMOUR_OBSIDIAN = EnumHelper.addArmorMaterial("armour_obsidian", Reference.MODID + ":obsidian", 33, new int[]{4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
    public static final ArmorMaterial ARMOUR_HELMET = EnumHelper.addArmorMaterial("armour_helmet", Reference.MODID + ":helmet", 33, new int[]{4, 7, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
    public static final ArmorMaterial ARMOUR_DRAGON = EnumHelper.addArmorMaterial("armour_dragon", Reference.MODID + ":dragon", 44, new int[]{6, 9, 10, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.0F);
    public static final ArmorMaterial ARMOUR_HELMET_D = EnumHelper.addArmorMaterial("armour_helmet_d", Reference.MODID + ":dragon_helmet", 44, new int[]{6, 9, 10, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.0F);
    
    //Items
    public static final Item INGOT_ENDORIUM = new ItemBase("item_ingot_endorium");
    public static final Item SHARD_OBSIDIAN = new ItemBase("item_shard_obsidian");
    public static final Item RAW_ENDORIUM = new ItemBase("item_raw_endorium");
    public static final Item DRAGONITE_SEEDS = new ItemDragonSeeds("item_dragonite_seeds", 0, false);
    public static final Item ADVANCED_PEARL = new ItemAPearl("item_advanced_ender_pearl");
    public static final Item END_ESSENCE = new ItemBase("item_end_essence");
    public static final Item END_SHARD = new ItemBase("item_end_shard");
    public static final Item END_RUNE = new ItemLegendary("item_end_rune");
    public static final Item LORMYTE_CRYSTAL = new ItemBase("item_lormyte_crystal");
    public static final Item INGOT_WOLFRAMIUM = new ItemBase("item_ingot_wolframium");
    public static final Item ENDER_STRING = new ItemLegendary("item_ender_string");
    public static final Item WORLD_MIRROR = new ItemWorldMirror("item_world_mirror");
    public static final Item DRAGONITE_TEA = new ItemDragoniteTea("item_dragonite_tea");
    public static final Item ANGEL_FEATHER = new ItemBase("item_angel_feather");
    public static final Item DRAGON_SCALES = new ItemBase("dragon_scales");
    public static final Item DEATH_ESSENCE = new ItemBase("death_essence");
    public static final Item INFUSED_METALL = new ItemBase("ingot_infused");
    public static final Item SWORD_SHARD = new ItemBase("sword_shard");
    public static final Item CATALYST = new ItemCatalyst("catalyst");
    public static final Item RECORD = new ItemEndRecord("end_record", SoundHandler.THE_VOID);
    public static final Item NUGGET_WOLFRAMIUM = new ItemBase("wolframium_nugget");
    
    //Tools
    public static final Item PICKAXE_ENDORIUM = new ToolPickaxe("tool_pickaxe_endorium", TOOL_ENDORIUM);
    public static final Item SWORD_ENDORIUM = new ToolSword("tool_sword_endorium", TOOL_ENDORIUM);
    public static final Item HOE_ENDORIUM = new ToolHoe("tool_hoe_endorium", TOOL_ENDORIUM);
    public static final Item AXE_ENDORIUM = new EndoriumAxe("tool_axe_endorium", TOOL_ENDORIUM);
    public static final Item SHOVEL_ENDORIUM = new ToolShovel("tool_shovel_endorium", TOOL_ENDORIUM);
    public static final Item HAMMER_IRON = new ItemHammer("tool_hammer_iron");
    public static final Item ENDER_BOW = new ItemEnderBow("ender_bow", 10, 0, 1, 2);
    public static final Item ENDER_SWORD = new ItemEnderSword("ender_sword", TOOL_END);
    public static final Item ENDER_HOOK = new ItemDeather("tool_magnifier", TOOL_MAGNIFIER);
    public static final Item PICKAXE_WOLFRAMIUM = new ToolPickaxe("tool_pickaxe_wolframium", TOOL_WOLFRAMIUM);
    public static final Item SWORD_WOLFRAMIUM = new ToolSword("tool_sword_wolframium", TOOL_WOLFRAMIUM);
    public static final Item HOE_WOLFRAMIUM = new ToolHoe("tool_hoe_wolframium", TOOL_WOLFRAMIUM);
    public static final Item AXE_WOLFRAMIUM = new EndoriumAxe("tool_axe_wolframium", TOOL_WOLFRAMIUM);
    public static final Item SHOVEL_WOLFRAMIUM = new ToolShovel("tool_shovel_wolframium", TOOL_WOLFRAMIUM);
    public static final Item ENTROPY_WAND = new ToolEntropyWand("entropy_wand", TOOL_MAGNIFIER);

    //Armors
    public static final Item CHESTPLATE_OBSIDIAN = new ArmourBase("armour_chestplate_obsidian", ARMOUR_OBSIDIAN, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_OBSIDIAN = new ArmourBase("armour_leggings_obsidian", ARMOUR_OBSIDIAN, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_OBSIDIAN = new ArmourBase("armour_boots_obsidian", ARMOUR_OBSIDIAN, 1, EntityEquipmentSlot.FEET);
    public static final Item HELMET_OBSIDIAN = new ArmourModel("armour_helmet_helmet", ARMOUR_HELMET, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_DRAGON = new ArmourBase("armour_chestplate_dragon", ARMOUR_DRAGON, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_DRAGON = new ArmourBase("armour_leggings_dragon", ARMOUR_DRAGON, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_DRAGON = new ArmourBase("armour_boots_dragon", ARMOUR_DRAGON, 1, EntityEquipmentSlot.FEET);
    public static final Item HELMET_DRAGON = new ArmourDModel("armour_helmet_dragon", ARMOUR_HELMET_D, 1, EntityEquipmentSlot.HEAD);
    
    //Food
    public static final Item ENDER_FLESH = new FoodEnderFlesh("food_ender_flesh");
    public static final Item DRAGONITE_BERRIES = new FoodDragonBerries("food_dragonite_berries");
    public static final Item CHORUS_SOUP = new FoodChorusSoup(5, "food_chorus_soup");
    
}



