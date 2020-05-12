package net.electron.endreborn;

import net.electron.endreborn.blocks.Blocks;
import net.electron.endreborn.items.Items;
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

	@Override
	public void onInitialize() {
		Items.registerItems();
		Blocks.registerBlocks();
		new Mobs();
		Mobs.registerEntitySpawn();
		FeatureGen.initGen();
		FeatureGen.initOres();
		Mobs.registerEntityAttributes();
	}
}


