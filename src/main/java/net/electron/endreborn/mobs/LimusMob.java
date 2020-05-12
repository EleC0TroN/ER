package net.electron.endreborn.mobs;

import net.electron.endreborn.items.Items;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.Random;

public class LimusMob extends MobEntity {

    public LimusMob(EntityType<? extends LimusMob> entityEntityType, World world) {
        super(entityEntityType, world);
        this.experiencePoints = 1;
        this.moveControl = new LimusMoveControl(this);
    }

    protected boolean canClimb() {
        return false;
    }
    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }
    @Override
    public boolean hasNoGravity() {
        return true;
    }

    public boolean canAvoidTraps() {
        return true;
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(5, new LimusMob.FlyRandomlyGoal(this));
    }

    public static DefaultAttributeContainer.Builder createLimusAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1D);
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.AMBIENT;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP;
    }

    public boolean interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.getItem() == net.minecraft.item.Items.GLASS_BOTTLE) {
            player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1.0F);

            if (itemStack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(Items.LIMUS_BOTTLE));
            } else if (!player.inventory.insertStack(new ItemStack(Items.LIMUS_BOTTLE))) {
                player.dropItem(new ItemStack(Items.LIMUS_BOTTLE), false);
            }
            if(!player.abilities.creativeMode) {
                itemStack.decrement(1);
            }
            this.remove();
            return true;
        } else {
            return super.interactMob(player, hand);
        }
    }
    static class LimusMoveControl extends MoveControl {
        private final LimusMob mob;
        private int collisionCheckCooldown;

        public LimusMoveControl(LimusMob mob) {
            super(mob);
            this.mob = mob;
        }

        public void tick() {
            if (this.state == State.MOVE_TO) {
                if (this.collisionCheckCooldown-- <= 0) {
                    this.collisionCheckCooldown += this.mob.getRandom().nextInt(3) + 1;
                    Vec3d vec3d = new Vec3d(this.targetX - this.mob.getX(), this.targetY - this.mob.getY(), this.targetZ - this.mob.getZ());
                    double d = vec3d.length();
                    vec3d = vec3d.normalize();

                    if (this.willCollide(vec3d, MathHelper.ceil(d))) {
                        this.mob.setVelocity(this.mob.getVelocity().add(vec3d.multiply(0.05D)));
                        ((ServerWorld)this.mob.world).spawnParticles(ParticleTypes.END_ROD, this.mob.getX(), this.mob.getY()-0.1, this.mob.getZ()-0.1, 0, 0,0, 0, (double)0.0F);
                    } else {
                        this.state = State.WAIT;
                    }
                }

            }

        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.mob.getBoundingBox();

            for(int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.mob.world.doesNotCollide(this.mob, box)) {
                    return false;
                }
            }

            return true;
        }
    }
    static class FlyRandomlyGoal extends Goal {
        private final LimusMob mob;

        public FlyRandomlyGoal(LimusMob mob) {
            this.mob = mob;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            MoveControl moveControl = this.mob.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            } else {
                double d = moveControl.getTargetX() - this.mob.getX();
                double e = moveControl.getTargetY() - this.mob.getY();
                double f = moveControl.getTargetZ() - this.mob.getZ();
                double g = d * d + e * e + f * f;
                return g < 1.0D || g > 3600.0D;
            }
        }

        public boolean shouldContinue() { return false;}

        public void start() {
            Random random = this.mob.getRandom();
            double d = this.mob.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double e = this.mob.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double f = this.mob.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.mob.getMoveControl().moveTo(d, e, f, 0.3D);
        }
    }
}
