package net.electron.endreborn;

import net.electron.endreborn.blocks.ModBlocks;
import net.electron.endreborn.items.ModItems;
import net.electron.endreborn.mobs.Mobs;
import net.electron.endreborn.world.NatureConfguredFeatures;
import net.electron.endreborn.world.NatureFeatures;
import net.electron.endreborn.world.NatureStructures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;

public class EndReborn implements ModInitializer {
	public static final ItemGroup END_GROUP = FabricItemGroupBuilder.build(
		new Identifier("endreborn", "general"),
		() -> new ItemStack(Blocks.END_STONE_BRICKS));
	public static final String MODID = "endreborn";

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		NatureStructures.registerStructures();
		new Mobs();

		BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("enderite_ore_feature"),
				NatureConfguredFeatures.ESSENCE_CONFIGURED);
		NatureFeatures.init();
		Mobs.registerEntityAttributes();
    }
}


