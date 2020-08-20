package net.electron.endreborn.mixin;

import net.electron.endreborn.world.NatureConfguredFeatures;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DefaultBiomeCreator.class)
public abstract class TheEndBiomeMixin {

    private static Biome method_31065(net.minecraft.world.biome.GenerationSettings.Builder builder) {
        SpawnSettings.Builder builder2 = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addEndMobs(builder2);
        return (new net.minecraft.world.biome.Biome.Builder()).precipitation(Biome.Precipitation.NONE).category(Biome.Category.THEEND).depth(0.1F).scale(0.2F).temperature(0.5F).downfall(0.5F).effects((new net.minecraft.world.biome.BiomeEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0).moodSound(BiomeMoodSound.CAVE).build()).spawnSettings(builder2.build()).generationSettings(builder.build()).build();
    }
    @Inject(at = @At("RETURN"), method = "createTheEnd", cancellable = true)
    private static void createTheEnd(CallbackInfoReturnable<Biome> cir) {
        net.minecraft.world.biome.GenerationSettings.Builder builder1 = (new net.minecraft.world.biome.GenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.END)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.END_SPIKE)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, NatureConfguredFeatures.END_CORAL_CONFIGURED)
                .feature(GenerationStep.Feature.RAW_GENERATION, NatureConfguredFeatures.END_MOSS_CONFIGURED)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, NatureConfguredFeatures.WEED_CONFIGURED)
                .feature(GenerationStep.Feature.RAW_GENERATION, NatureConfguredFeatures.ESSENCE_CONFIGURED);
        cir.setReturnValue(method_31065(builder1));
    }

    @Inject(at = @At("RETURN"), method = "createEndMidlands", cancellable = true)
    private static void createEndMidlands(CallbackInfoReturnable<Biome> cir) {
        net.minecraft.world.biome.GenerationSettings.Builder builder1 = (new net.minecraft.world.biome.GenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.END)
                .structureFeature(ConfiguredStructureFeatures.END_CITY)
                .structureFeature(NatureConfguredFeatures.END_SHIPWRECK_CONFIGURED)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, NatureConfguredFeatures.END_CORAL_CONFIGURED)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, NatureConfguredFeatures.WEED_CONFIGURED)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, NatureConfguredFeatures.END_DECO_CONFIGURED)
                .feature(GenerationStep.Feature.UNDERGROUND_ORES, NatureConfguredFeatures.END_TUNGSTEN_CONFIGURED)
                .feature(GenerationStep.Feature.RAW_GENERATION, NatureConfguredFeatures.END_MOSS_CONFIGURED);
        cir.setReturnValue(method_31065(builder1));
    }

    @Inject(at = @At("RETURN"), method = "createSmallEndIslands", cancellable = true)
    private static void createSmallEndIslands(CallbackInfoReturnable<Biome> cir) {
        net.minecraft.world.biome.GenerationSettings.Builder builder1 = (new net.minecraft.world.biome.GenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.END)
                .feature(GenerationStep.Feature.RAW_GENERATION, NatureConfguredFeatures.XORCITE_CONFIGURED);
        cir.setReturnValue(method_31065(builder1));
    }

    @Inject(at = @At("RETURN"), method = "createEndHighlands", cancellable = true)
    private static void createEndHighlands(CallbackInfoReturnable<Biome> cir) {
        net.minecraft.world.biome.GenerationSettings.Builder builder1 = (new net.minecraft.world.biome.GenerationSettings.Builder()).surfaceBuilder(ConfiguredSurfaceBuilders.END)
                .structureFeature(ConfiguredStructureFeatures.END_CITY)
                .structureFeature(NatureConfguredFeatures.END_CRYPT_CONFIGURED)
                .feature(GenerationStep.Feature.RAW_GENERATION, NatureConfguredFeatures.END_MOSS_CONFIGURED)
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, ConfiguredFeatures.END_GATEWAY)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.CHORUS_PLANT);
        cir.setReturnValue(method_31065(builder1));
    }
}
