package endreborn.compat;

import endreborn.EndReborn;
import endreborn.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
public enum EndCompat {
   
    @SuppressWarnings("WeakerAccess")
    TCONSTRUCT("Tinkers' Construct") {
        @Override
        protected boolean preInit() {
            TConstruct.preInit();
            return true;
        }

        @Override
        protected void init() {
            TConstruct.init();
        }

        @Override
        protected void postInit() {
            TConstruct.postInit();
        }
    };

    protected boolean preInit() { return true; }
    protected void init() {}
    protected void postInit() {}


    final private String modName;

    private boolean isActivated = false;

    public boolean isActivated() {
        return isActivated;
    }
    public static void preInitCompat() {
        for (EndCompat compat : EndCompat.values()) {
            if (Loader.isModLoaded(compat.name().toLowerCase())) {
                try {
                    compat.isActivated = compat.preInit();

                    if (compat.isActivated()) {
                        EndReborn.LOGGER.info(Reference.MODID + " has loaded compatibility for mod " + compat.modName + ".");
                    } else {
                        EndReborn.LOGGER.info(Reference.MODID + " couldn't activate compatibility for mod " + compat.modName + "!");
                    }
                } catch (Exception e) {
                    compat.isActivated = false;
                    EndReborn.LOGGER.info(Reference.MODID + " had a " + e.getLocalizedMessage() + " error loading " + compat.modName + " compatibility!");
                    EndReborn.LOGGER.catching(e.fillInStackTrace());
                }
            } else {
                compat.isActivated = false;
                EndReborn.LOGGER.info(Reference.MODID + " has skipped compatibility for mod " + compat.modName + ".");
            }
        }
    }

    public static void initCompat() {
        for (EndCompat compat : EndCompat.values()) {
            if (compat.isActivated) {
                try {
                    compat.init();
                } catch (Exception e) {
                    compat.isActivated = false;
                    EndReborn.LOGGER.info(Reference.MODID + " had a " + e.getLocalizedMessage() + " error loading " + compat.modName + " compatibility in init!");
                    EndReborn.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }

    public static void postInitCompat() {
        for (EndCompat compat : EndCompat.values()) {
            if (compat.isActivated) {
                try {
                    compat.postInit();
                } catch (Exception e) {
                    compat.isActivated = false;
                    EndReborn.LOGGER.info(Reference.MODID + " had a " + e.getLocalizedMessage() + " error loading " + compat.modName + " compatibility in postInit!");
                    EndReborn.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    EndCompat(String modName) {
        this.modName = modName;
    }

    static void registerSidedHandler(Side side, Object handler) {
        if (FMLCommonHandler.instance().getSide() == side) {
            MinecraftForge.EVENT_BUS.register(handler);
        }
    }
}
