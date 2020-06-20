package endreborn.handlers;

import endreborn.init.ItemInit;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {

    public static void registerOres() {
    	OreDictionary.registerOre("ingotEndorium", ItemInit.INGOT_ENDORIUM);
        OreDictionary.registerOre("ingotTungsten", ItemInit.INGOT_WOLFRAMIUM);
        OreDictionary.registerOre("nuggetTungsten", ItemInit.NUGGET_WOLFRAMIUM);
        OreDictionary.registerOre("tungstenIngot", ItemInit.INGOT_WOLFRAMIUM);
        OreDictionary.registerOre("dustObsidian", ItemInit.CATALYST);
        OreDictionary.registerOre("dustObsidian", ItemInit.CATALYST);
        OreDictionary.registerOre("hammerIron", ItemInit.HAMMER_IRON);
        OreDictionary.registerOre("hammer", ItemInit.HAMMER_IRON);
        OreDictionary.registerOre("shardLormyte", ItemInit.LORMYTE_CRYSTAL);
        OreDictionary.registerOre("essence", ItemInit.END_ESSENCE);
    }

}
