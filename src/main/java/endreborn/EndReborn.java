package endreborn;

import java.io.File;

import endreborn.compat.EndCompat;
import endreborn.handlers.ConfigsHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import endreborn.handlers.EndVillagerHandler;
import endreborn.handlers.RegistryHandler;
import endreborn.init.RecipesInit;
import endreborn.proxy.CommonProxy;
import endreborn.utils.GuiMainMenuEnd;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class EndReborn 
{
    public static final Logger LOGGER = LogManager.getLogger(Reference.MODID);
	public static File config;
	public static final CreativeTabs endertab = new EndRebornTab("endertab");

    private static boolean compat = true;
    public static boolean voidcraftLoaded = false;
    public static boolean thaumcraftLoaded = false;
    public static boolean activateEndGeneration;
    public static boolean activateVanillaEndOres;
	
    
	@Instance(Reference.MODID)
	public static EndReborn mod;
	
	@Instance
	public static EndReborn instance;

    public static EndReborn getInstance()
    {
        return instance;
    }
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		RegistryHandler.preInitRegistries(event);
        if (compat) {
            try {
                EndCompat.preInitCompat();
            } catch (Exception e) {
                compat = false;
                EndReborn.LOGGER.error(Reference.MODID + " had an error loading preInit compatibility!");
                EndReborn.LOGGER.catching(e.fillInStackTrace());
            }
        } else {
            EndReborn.LOGGER.warn(Reference.MODID + " is skipping! compatibility!");
        }
    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
        if (compat) {
            try {
                EndCompat.initCompat();
            } catch (Exception e) {
                compat = false;
                EndReborn.LOGGER.error(Reference.MODID + " had an error loading init compatibility!");
                EndReborn.LOGGER.catching(e.fillInStackTrace());
            }
        }
        RegistryHandler.initRegistries(event);
    	if(event.getSide() == Side.CLIENT && ConfigsHandler.GENERAL.spawnNewVillagers)
        {
    	EndVillagerHandler.initIEVillagerTrades();
    	EndVillagerHandler.initIEVillagerHouse();
        }
    	RecipesInit.init();
    	
        if(event.getSide() == Side.CLIENT && ConfigsHandler.GENERAL.panorama)
        {
            GuiMainMenuEnd.endMainMenu();
        }
    }
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        if (compat) {
            try {
                EndCompat.postInitCompat();
            } catch (Exception e) {
                EndReborn.LOGGER.error(Reference.MODID + " had an error loading postInit compatibility!");
                EndReborn.LOGGER.catching(e.fillInStackTrace());
            }
        }
    }


}

