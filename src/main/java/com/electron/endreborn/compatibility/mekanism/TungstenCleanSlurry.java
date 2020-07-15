package com.electron.endreborn.compatibility.mekanism;

import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Set;

public class TungstenCleanSlurry extends Slurry {
    public TungstenCleanSlurry() {
        super((SlurryBuilder)SlurryBuilder.clean().color(2107689));
        this.setRegistryName(new ResourceLocation("endreborn", "clean_tungsten"));
    }

    public boolean isIn(@Nonnull ITag<Slurry> tags) {
        return true;
    }

    @Nonnull
    public Set<ResourceLocation> getTags() {
        return Collections.emptySet();
    }
}
