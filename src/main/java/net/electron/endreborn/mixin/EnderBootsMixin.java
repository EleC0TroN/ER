package net.electron.endreborn.mixin;

import net.electron.endreborn.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class EnderBootsMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getArmorItems();

    protected EnderBootsMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void isWithEnderBoots(CallbackInfo cir) {
        if (this.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.ENDER_BOOTS) {
            if (this.hurtTime == 5) {
                if (!world.isClient) {
                    double d = this.getX();
                    double e = this.getY();
                    double f = this.getZ();

                    for(int i2 = 0; i2 < 16; ++i2) {
                        double g = this.getX() + (this.getRandom().nextDouble() - 0.5D) * 16.0D;
                        double h = MathHelper.clamp(this.getY() + (double)(this.getRandom().nextInt(16) - 8), 0.0D, (double)(world.getDimensionHeight() - 1));
                        double j = this.getZ() + (this.getRandom().nextDouble() - 0.5D) * 16.0D;
                        if (this.hasVehicle()) {
                            this.stopRiding();
                        }

                        if (this.teleport(g, h, j, true)) {
                            SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                            world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.PLAYERS, 0.5F, 1.0F);
                            this.playSound(soundEvent, 1.0F, 1.0F);
                            break;
                        }
                    }
                }
            }
        }
    }
}
