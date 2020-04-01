package endreborn.utils;

import endreborn.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class EndSound extends SoundEvent {
    public final String name;

    public final SoundCategory category;

    public EndSound(String soundName) {
        this(soundName, SoundCategory.NEUTRAL);
    }

    public EndSound(String name, SoundCategory category) {
        super(new ResourceLocation(Reference.MODID, name));
        this.name = name;
        this.category = category;
        setRegistryName(new ResourceLocation(Reference.MODID, name));
    }
}
