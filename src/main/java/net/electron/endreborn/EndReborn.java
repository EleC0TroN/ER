package net.electron.endreborn;

import net.electron.endreborn.blocks.ModBlocks;
import net.electron.endreborn.items.ModItems;
import net.electron.endreborn.mobs.Mobs;
import net.electron.endreborn.world.FeatureGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class EndReborn implements ModInitializer {
	public static final ItemGroup END_GROUP = FabricItemGroupBuilder.build(
		new Identifier("endreborn", "general"),
		() -> new ItemStack(net.minecraft.block.Blocks.END_STONE));
	public static final String MODID = "endreborn";
	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		new Mobs();
		FeatureGen.initGen();
		FeatureGen.initOres();
		Mobs.registerEntityAttributes();
	}
}


