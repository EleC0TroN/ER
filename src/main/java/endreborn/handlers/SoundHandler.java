package endreborn.handlers;

import endreborn.utils.EndSound;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SoundHandler {
    public static final List<SoundEvent> SOUNDS = new ArrayList<>();

    public static final EndSound THE_VOID = reg("the_void");

    private SoundHandler() {
    }

    private static EndSound reg(String name) {
        EndSound event = new EndSound(name);

        SOUNDS.add(event);
        return event;
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> register) {
        try {
            for (Field field : SoundHandler.class.getDeclaredFields()) {
                Object obj = field.get(null);
                if (obj instanceof EndSound) {
                    register.getRegistry().register((EndSound)obj);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void preInit() {
        assert !SOUNDS.isEmpty();
    }
}