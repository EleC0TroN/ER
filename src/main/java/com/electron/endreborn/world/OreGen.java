package com.electron.endreborn.world;

import com.electron.endreborn.ModBlocks;
import com.electron.endreborn.ModConfigs;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
	private static final ObsidianOreFeature OBSIDIAN_ORE = new ObsidianOreFeature(null);
    @SuppressWarnings("static-access")
	public static void init() {

        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            if (!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        ModBlocks.QUARTZ_ORE.get().getDefaultState(),
                                        2
                                ),
                                Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)
                        )
                );
                
            }
            if (!biome.getCategory().equals(Biome.Category.NETHER) && !biome.getCategory().equals(Biome.Category.THEEND)) {
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        ModBlocks.WOLFRAMIUM_ORE.get().getDefaultState(),
                                        4
                                ),
                                Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)
                        )
                );
            }
            Biomes.THE_END.addFeature(
            		GenerationStage.Decoration.VEGETAL_DECORATION, 
            		Biome.createDecoratedFeature(OBSIDIAN_ORE, 
            				new OreFeatureConfig(
            				OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
            				ModBlocks.OBSIDIAN_ORE.get().getDefaultState(), 4), 
            				Placement.COUNT_RANGE, new CountRangeConfig(ModConfigs.COMMON.balance.obsidian_ore_rarity.get(), 50, 10, 200)));
        }
    }
}