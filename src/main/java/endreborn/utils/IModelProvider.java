package endreborn.utils;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

public interface IModelProvider {
    default void gatherVariants(Int2ObjectMap<String> variants) {
        variants.put(0, "inventory");
    }
}
