package com.electron.endreborn;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = EndReborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfigs {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;
    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = specPair.getLeft();
        COMMON_SPEC = specPair.getRight();
    }
    public static class CommonConfig {
        public final Balance balance;
        public CommonConfig(final ForgeConfigSpec.Builder builder) {
            balance = new Balance(builder);
        }
        public static class Balance {
            public static String name = "general";

            public static ConfigValue<Integer> rarity_obsidian_ore;
            public static ConfigValue<Integer> rarity_moss;
            public static ConfigValue<Integer> rarity_ogana;
            public static ConfigValue<Integer> rarity_tungsten_ore;
            public static ConfigValue<Integer> rarity_tungsten_end;
            public static ConfigValue<Integer> rarity_dragonite;
            public static ConfigValue<Integer> rarity_xorcite_clusters;

            public static ConfigValue<Integer> crypt_size;
            public static ConfigValue<Boolean> enderman_tweaks;
            public static ConfigValue<Boolean> end_coral;
            public static ConfigValue<Boolean> end_shipwreck;
            public static ConfigValue<Boolean> end_deco;
            public static ConfigValue<Boolean> end_crypt;

            public Balance(ForgeConfigSpec.Builder builder) {
                builder.push(name);
                end_shipwreck = builder
                        .comment("End Shipwreck and End Beacon generation")
                        .define("end_shipwreck", true);

                end_deco = builder
                        .comment("Cracked blocks generation in The End")
                        .define("end_deco", true);

                end_crypt = builder
                        .comment("End Crypt generation")
                        .define("end_crypt", true);

                end_coral = builder
                        .comment("Endstone Coral generation")
                        .define("end_coral", true);

                enderman_tweaks = builder
                        .comment("Random model size | If enabled, server logs can spam with warning about enderman spawning")
                        .define("enderman_tweaks", false);

                crypt_size = builder
                        .comment("End Crypt maximum size")
                        .defineInRange("crypt_size", 8, 0, 16);

                rarity_obsidian_ore = builder
                        .comment("Crying Obsidian spawn rarity")
                        .defineInRange("rarity_obsidian_ore", 15, 0, 32);

                rarity_moss = builder
                        .comment("End Moss spawn rarity")
                        .defineInRange("rarity_moss", 4, 0, 16);

                rarity_ogana = builder
                        .comment("End Moss spawn rarity")
                        .defineInRange("rarity_ogana", 5, 0, 16);

                rarity_dragonite = builder
                        .comment("Dragonite flower spawn rarity")
                        .defineInRange("rarity_dragonite", 3, 0, 16);

                rarity_xorcite_clusters = builder
                        .comment("Xorcite Clusters spawn rarity")
                        .defineInRange("rarity_xorcite_clusters", 1, 0, 16);

                rarity_tungsten_ore = builder
                        .comment("Tungsten Ore spawn rarity")
                        .defineInRange("rarity_tungsten_ore", 3, 0, 16);

                rarity_tungsten_end = builder
                        .comment("Tungsten Ore spawn rarity")
                        .defineInRange("rarity_tungsten_end", 2, 0, 16);

                builder.pop();
            }
        }
    }
}
