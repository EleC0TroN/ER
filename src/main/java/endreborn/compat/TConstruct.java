package endreborn.compat;

import endreborn.init.ItemInit;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.material.MaterialRenderInfoLoader;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class TConstruct {
    public static Material endorium    = new Material("endorium",  0x1b_7b_6b);
    public static Material wolframium    = new Material("wolframium", 0x9C_A9_8C);

    public static final AbstractTrait endoriumTrait      = new EndoriumTrait();
    public static final AbstractTrait wolframiumTrait      = new WolframiumTrait();

    static void preInit()
    {
        TinkerRegistry.addMaterialStats(TConstruct.endorium,
                new HeadMaterialStats(1024, 5.5f, 8.0f, HarvestLevels.OBSIDIAN),
                new BowMaterialStats(1.2f, 2f, 5),
                new HandleMaterialStats(1.4f, 1024),
                new ArrowShaftMaterialStats(1.4f, 5));
        TinkerRegistry.integrate(TConstruct.endorium).preInit();

        TinkerRegistry.addMaterialStats(TConstruct.wolframium,
                new HeadMaterialStats(512, 5.5f, 6.5f, HarvestLevels.DIAMOND),
                new BowMaterialStats(0.5f, 1f, 0),
                new HandleMaterialStats(1.4f, 512),
                new ArrowShaftMaterialStats(1.4f, 1));
        TinkerRegistry.integrate(TConstruct.wolframium).preInit();

    }

    static void init()
    {
        TConstruct.endorium.addItem(ItemInit.INGOT_ENDORIUM, 1, Material.VALUE_Ingot);
        TConstruct.endorium
                .addTrait(TConstruct.endoriumTrait)
                .setCraftable(true).setCastable(false)
                .setRepresentativeItem(ItemInit.INGOT_ENDORIUM);

        TConstruct.wolframium.addItem(ItemInit.INGOT_WOLFRAMIUM, 1, Material.VALUE_Ingot);
        TConstruct.wolframium
                .addTrait(TConstruct.wolframiumTrait)
                .setCraftable(true).setCastable(false)
                .setRepresentativeItem(ItemInit.INGOT_WOLFRAMIUM);

    }

    static void postInit()
    {

    }
}