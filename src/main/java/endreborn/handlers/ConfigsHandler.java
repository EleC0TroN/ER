package endreborn.handlers;

import endreborn.Reference;
import net.minecraftforge.common.config.Config;


@Config(modid = Reference.MODID, category = "")
public final class ConfigsHandler
{
    public static final GeneralConfig GENERAL = new GeneralConfig();
    public static final BalanceConfig BALANCE = new BalanceConfig();

    public static class GeneralConfig
    {
        @Config.Name("Essence Ore")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnEssenceOre = true;
        
        @Config.Name("New Villagers")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnNewVillagers = true;
        
        @Config.Name("End Guard Mob")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnEndGuard = true;

        @Config.Name("Wolframium Ore")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnWolframiumOre = true;

        @Config.Name("Watcher Mob")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnWatcher = true;
        
        @Config.Name("Chronologist Mob")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnChronologist = true;

        @Config.Name("End Islands")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnEndIsland = true;

        @Config.Name("Observatory")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnObservatory = true;

        @Config.Name("Lormyte")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnLormyte = true;

        @Config.Name("End Magma, Enropy End Stone")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean decoratorEnd = true;
       
        @Config.Name("Chest Loot")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to fill."})
        public boolean chestLoot = true;

        @Config.Name("Panorama")
        @Config.RequiresMcRestart
        @Config.Comment({"Main menu panorama"})
        public boolean panorama = true;

        @Config.Name("End Void Teleporter")
        @Config.RequiresMcRestart
        @Config.Comment({"When player falls to void in The End, he teleports to the Overworld"})
        public boolean teleporterEnd = true;

        private GeneralConfig() {}
    }

    public static class BalanceConfig
    {

        @Config.Name("Island Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"The higher the value, the higher the rarity. To disable check the general config"})
        public int islandRare = 200;
        
        @Config.Name("Essence Rarity In The End")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"The lower the value, the higher the rarity. To disable check the general config"})
        public int essenceRareEnd = 200;

        @Config.Name("Essence Rarity In Overworld")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"The lower the value, the higher the rarity. To disable check the general config"})
        public int essenceRareOver = 80;

        @Config.Name("Wolframium Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"The lower the value, the higher the rarity. To disable check the general config"})
        public int wolframiumRare = 25;

        @Config.Name("End Guard Spawn Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"Chance to spawn = 1/(this number). To disable check the general config"})
        public int guardRare = 50;
        
        @Config.Name("Chronologist Spawn Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"Chance to spawn = 1/(this number). To disable check the general config"})
        public int chronRare = 200;

        @Config.Name("Watcher Spawn Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"Chance to spawn = 1/(this number). To disable check the general config"})
        public int watcherRare = 50;

        private BalanceConfig() {}
    }
}
