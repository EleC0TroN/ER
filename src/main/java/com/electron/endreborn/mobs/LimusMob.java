package com.electron.endreborn.mobs;

import com.electron.endreborn.ModItems;
import com.electron.endreborn.ModMobs;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.EnumSet;
import java.util.Random;

public class LimusMob extends AmbientEntity {
    // Attributes

    // Constructors
    public LimusMob(EntityType entityType, World world) {
        super(entityType, world);
        this.experienceValue = 1;
        this.entityCollisionReduction = 1;
        this.moveController = new LimusMob.MoveHelperController(this);
    }
    @Override
    public double getYOffset() {
        return 0.1D;
    }
    @Override
    public void fall(float distance, float damageMultiplier) {
    }
    public LimusMob(World world, double x, double y, double z) {
        this(ModMobs.LIMUS.get(), world);
        this.setPosition(x, y, z);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(5, new LimusMob.RandomFlyGoal(this));
    }
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
    }
    @Override
    public boolean hasNoGravity() {
        return true;
    }
    public SoundCategory getSoundCategory() {
        return SoundCategory.AMBIENT;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP;
    }
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() == Items.GLASS_BOTTLE) {
            player.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 0.5F);
            itemstack.shrink(1);
            this.remove();
            if (itemstack.isEmpty()) {
                player.setHeldItem(hand, new ItemStack(ModItems.LIMUS_BOTTLE.get()));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.LIMUS_BOTTLE.get()))) {
                player.dropItem(new ItemStack(ModItems.LIMUS_BOTTLE.get()), false);
            }
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }
    @Override
    public void tick() {
        super.tick();
    }
    static class MoveHelperController extends MovementController {
        private final LimusMob parentEntity;
        private int courseChangeCooldown;

        public MoveHelperController(LimusMob mob) {
            super(mob);
            this.parentEntity = mob;
        }

        public void tick() {
            if (this.action == MovementController.Action.MOVE_TO) {
                if (this.courseChangeCooldown-- <= 0) {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 6;
                    Vec3d vec3d = new Vec3d(this.posX - this.parentEntity.posX, this.posY - this.parentEntity.posY, this.posZ - this.parentEntity.posZ);
                    double d0 = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.func_220673_a(vec3d, MathHelper.ceil(d0))) {
                        this.parentEntity.setMotion(this.parentEntity.getMotion().add(vec3d.scale(0.1D)));
                        ((ServerWorld)this.parentEntity.world).spawnParticle(ParticleTypes.END_ROD, this.parentEntity.posX, this.parentEntity.posY, this.parentEntity.posZ, 0, 0,0, 0, (double)0.1F);
                    } else {
                        this.action = MovementController.Action.WAIT;
                    }
                }

            }
        }

        private boolean func_220673_a(Vec3d p_220673_1_, int p_220673_2_) {
            AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();

            for(int i = 1; i < p_220673_2_; ++i) {
                axisalignedbb = axisalignedbb.offset(p_220673_1_);
                if (!this.parentEntity.world.isCollisionBoxesEmpty(this.parentEntity, axisalignedbb)) {
                    return false;
                }
            }

            return true;
        }
    }
    static class RandomFlyGoal extends Goal {
        private final LimusMob parentEntity;

        public RandomFlyGoal(LimusMob mob) {
            this.parentEntity = mob;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            MovementController movementcontroller = this.parentEntity.getMoveHelper();
            if (!movementcontroller.isUpdating()) {
                return true;
            } else {
                double d0 = movementcontroller.getX() - this.parentEntity.posX;
                double d1 = movementcontroller.getY() - this.parentEntity.posY;
                double d2 = movementcontroller.getZ() - this.parentEntity.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            Random random = this.parentEntity.getRNG();
            double d0 = this.parentEntity.posX + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d1 = this.parentEntity.posY + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double d2 = this.parentEntity.posZ + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
        }
    }
    public void kill() {
        super.remove();
    }
}