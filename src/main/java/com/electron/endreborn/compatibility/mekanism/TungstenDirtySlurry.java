package com.electron.endreborn.compatibility.mekanism;

import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Set;

public class TungstenDirtySlurry extends Slurry {
    public TungstenDirtySlurry() {
        super((SlurryBuilder)SlurryBuilder.dirty().color(2107689));
        this.setRegistryName(new ResourceLocation("endreborn", "dirty_tungsten"));
    }

    public boolean isIn(@Nonnull ITag<Slurry> tags) {
        return true;
    }

    @Nonnull
    public Set<ResourceLocation> getTags() {
        return Collections.emptySet();
    }
}

