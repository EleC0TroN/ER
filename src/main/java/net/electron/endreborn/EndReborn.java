package net.electron.endreborn;


import net.electron.endreborn.blocks.Blocks;
import net.electron.endreborn.items.Items;
import net.electron.endreborn.world.FeatureGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EndReborn implements ModInitializer {
	public static final ItemGroup END_GROUP = FabricItemGroupBuilder.build(
		new Identifier("endreborn", "general"),
		() -> new ItemStack(net.minecraft.block.Blocks.END_STONE));

	@Override
	public void onInitialize() {
		Items.registerItems();
		Blocks.registerBlocks();
		Registry.BIOME.forEach(this::handleBiome);
	}
	private void handleBiome(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
	        	    Feature.ORE.configure(
				new OreFeatureConfig(
				    OreFeatureConfig.Target.NATURAL_STONE,
				    Blocks.QUARTZ_ORE.getDefaultState(),
				    4 //Ore vein size
			   )).createDecoratedFeature(
				Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
				    4, //Number of veins per chunk
				    0, //Bottom Offset
				    0, //Min y level
				    64 //Max y level
			))));
		}
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
	        	    GenerationStep.Feature.UNDERGROUND_ORES,
	        	    Feature.ORE.configure(
				new OreFeatureConfig(
				    OreFeatureConfig.Target.NATURAL_STONE,
				    Blocks.WOLF_ORE.getDefaultState(),
				    4 //Ore vein size
			   )).createDecoratedFeature(
				Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
				    4, //Number of veins per chunk
				    0, //Bottom Offset
				    0, //Min y level
				    64 //Max y level
			))));
		}
		if(biome.getCategory() == Biome.Category.THEEND) {
			biome.addFeature(
	        	    GenerationStep.Feature.UNDERGROUND_ORES,
	        	    FeatureGen.OBSIDIAN_ORE.configure(
				new OreFeatureConfig(
				    OreFeatureConfig.Target.NATURAL_STONE,
				    Blocks.OBSIDIAN_ORE.getDefaultState(),
				    4 //Ore vein size
			   )).createDecoratedFeature(
				Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
				    12, //Number of veins per chunk
				    0, //Bottom Offset
				    0, //Min y level
				    100 //Max y level
			))));
		}
		if(biome.getCategory() == Biome.Category.THEEND) {
			biome.addFeature(
	        	    GenerationStep.Feature.UNDERGROUND_ORES,
	        	    FeatureGen.END_NATURE.configure(
				new OreFeatureConfig(
				    OreFeatureConfig.Target.NATURAL_STONE,
				    Blocks.END_MOSS.getDefaultState(),
				    32 //Ore vein size
			   )).createDecoratedFeature(
				Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
				    16, //Number of veins per chunk
				    0, //Bottom Offset
				    55, //Min y level
				    120 //Max y level
			))));
		}
		if(biome.getCategory() == Biome.Category.THEEND) {
			biome.addFeature(
	        	    GenerationStep.Feature.UNDERGROUND_ORES,
	        	    FeatureGen.END_PLANT.configure(
				new OreFeatureConfig(
				    OreFeatureConfig.Target.NATURAL_STONE,
				    Blocks.OGANA_PLANT.getDefaultState(),
				    6 //Ore vein size
			   )).createDecoratedFeature(
				Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
				    16, //Number of veins per chunk
				    0, //Bottom Offset
				    55, //Min y level
				    120 //Max y level
			))));
		}
		if(biome.getCategory() == Biome.Category.THEEND) {
			biome.addFeature(
	        	    GenerationStep.Feature.UNDERGROUND_ORES,
	        	    FeatureGen.END_PLANT.configure(
				new OreFeatureConfig(
				    OreFeatureConfig.Target.NATURAL_STONE,
				    Blocks.OGANA_WEED.getDefaultState(),
				    32 //Ore vein size
			   )).createDecoratedFeature(
				Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
				    16, //Number of veins per chunk
				    0, //Bottom Offset
				    55, //Min y level
				    120 //Max y level
			))));
		}
		if(biome.getCategory() == Biome.Category.FOREST) {
			biome.addFeature(
	        	    GenerationStep.Feature.UNDERGROUND_ORES,
	        	    FeatureGen.PLANT.configure(
				new OreFeatureConfig(
				    OreFeatureConfig.Target.NATURAL_STONE,
				    Blocks.DRAGONITE.getDefaultState(),
				    5 //Ore vein size
			   )).createDecoratedFeature(
				Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
				    16, //Number of veins per chunk
				    0, //Bottom Offset
				    55, //Min y level
				    100 //Max y level
			))));
		}
	}
}


