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
            public static String name = "balance";

            public static ConfigValue<Integer> obsidian_ore_rarity;
            public static ConfigValue<Integer> moss_rarity;
            public static ConfigValue<Integer> decorator_rarity;
            public static ConfigValue<Integer> tungsten_ore_rarity;
            public static ConfigValue<Integer> dragonite_rarity;
            public static ConfigValue<Integer> quartz_rarity;
            public static ConfigValue<Integer> xorcite_clusters_rarity;
            public static ConfigValue<Boolean> new_structures_end;
            public static ConfigValue<Integer> crypt_size;
            public static ConfigValue<Boolean> enderman_tweaks;
            public static ConfigValue<Boolean> end_decorator;

            public Balance(ForgeConfigSpec.Builder builder) {
                builder.push(name);
                new_structures_end = builder
                        .comment("The End new structures generation")
                        .define("new_structures_end", true);

                end_decorator = builder
                        .comment("End Moss, Endstone Coral generation")
                        .define("tungsten_ore", true);

                enderman_tweaks = builder
                        .comment("Random model size | If enabled, server logs can spam with warning about enderman spawning")
                        .define("enderman_tweaks", false);

                obsidian_ore_rarity = builder
                        .comment("Crying Obsidian spawn rarity")
                        .defineInRange("obsidian_ore_rarity", 6, 0, 64);

                crypt_size = builder
                        .comment("End Crypt maximum size")
                        .defineInRange("crypt_size", 8, 0, 64);

                moss_rarity = builder
                        .comment("End Moss spawn rarity")
                        .defineInRange("moss_rarity", 4, 0, 64);

                decorator_rarity = builder
                        .comment("Cracked Purpur and Cracked End Bricks spawn rarity")
                        .defineInRange("decorator_rarity", 4, 0, 64);

                dragonite_rarity = builder
                        .comment("Dragonite flower spawn rarity")
                        .defineInRange("dragonite_rarity", 1, 0, 64);

                quartz_rarity = builder
                        .comment("Quartz Ore spawn rarity")
                        .defineInRange("quartz_rarity", 4, 0, 64);

                xorcite_clusters_rarity = builder
                        .comment("Xorcite Clusters spawn rarity")
                        .defineInRange("xorcite_clusters_rarity", 8, 0, 64);

                tungsten_ore_rarity = builder
                        .comment("Tungsten Ore spawn rarity")
                        .defineInRange("tungsten_rarity", 4, 0, 64);

                builder.pop();
            }
        }
    }
}
