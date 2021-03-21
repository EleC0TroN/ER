package com.electron.endreborn.compatibility.mekanism;

import mekanism.api.tier.BaseTier;
import mekanism.api.tier.ITier;

public enum QIOCompatTier implements ITier {
    ENDOMATIC(BaseTier.ELITE, 4548000L, 2048);

    private final BaseTier baseTier;
    private final long count;
    private final int types;

    private QIOCompatTier(BaseTier tier, long count, int types) {
        this.baseTier = tier;
        this.count = count;
        this.types = types;
    }

    public BaseTier getBaseTier() {
        return this.baseTier;
    }

    public long getMaxCount() {
        return this.count;
    }

    public int getMaxTypes() {
        return this.types;
    }
}

