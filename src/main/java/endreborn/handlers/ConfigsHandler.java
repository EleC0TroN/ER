package endreborn.handlers;

import java.util.List;

import endreborn.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;


@Config(modid = Reference.MODID, category = "")
public final class ConfigsHandler
{

    public static final GeneralConfig GENERAL = new GeneralConfig();
    public static final BalanceConfig BALANCE = new BalanceConfig();
    public static final RecipesConfig RECIPES = new RecipesConfig();

    public static class RecipesConfig 
    {
    	 @Config.Name("Materializer Recipes | Item 1")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem0 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 2")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem1 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 3")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem2 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 4")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem3 = "ingotCobalt";

    	 @Config.Name("Materializer Recipes | Item 5")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem4 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 6")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem5 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 7")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem6 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 8")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem7 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 9")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem8 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 10")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem9 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 11")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem10 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 12")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem11 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 12")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem12 = "";
    	 
    	 @Config.Name("Materializer Recipes | Item 12")
         @Config.RequiresMcRestart
         @Config.Comment({"To turn on check the General page | Ore Dictionary | To disable item just leave empty"})
         public String materializerItem13 = "";
    	 
    	 private RecipesConfig() {}
    }
    public static class GeneralConfig
    {
        @Config.Name("Essence Ore")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnEssenceOre = true;
        
        @Config.Name("Experimental feature | Allows custom Materializer recipes")
        @Config.RequiresMcRestart
        @Config.Comment({"May cause crash with some mods(undefined)"})
        public boolean experimentalMaterializer = false;
      
        @Config.Name("End Ruines")
        @Config.RequiresMcRestart
        @Config.Comment({"Allows to spawn."})
        public boolean spawnEndRuines = true;
        
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
        public boolean spawnChronologist = false;

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
        @Config.Name("Observatory Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"The higher the value, the higher the rarity. To disable check the general config"})
        public int obsRare = 600;
        
        @Config.Name("Island Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"The higher the value, the higher the rarity. To disable check the general config"})
        public int islandRare = 200;
        
        @Config.Name("End Ruines Rarity")
        @Config.RangeInt(min = 1, max = 1000)
        @Config.Comment({"The higher the value, the higher the rarity. To disable check the general config"})
        public int ruinesRare = 300;
        
        
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
