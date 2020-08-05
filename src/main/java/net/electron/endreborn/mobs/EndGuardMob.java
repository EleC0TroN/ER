package net.electron.endreborn.mobs;

import net.electron.endreborn.blocks.EndstonePlant;
import net.electron.endreborn.blocks.OganaPlant;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Iterator;

public class EndGuardMob extends HostileEntity implements Monster {
    private int attackTimer;
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(EndGuardMob.class, TrackedDataHandlerRegistry.BOOLEAN);
    public EndGuardMob(EntityType<? extends EndGuardMob> type, World worldIn) {
        super(type, worldIn);
        this.stepHeight = 1.0F;
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.add(2, new GoToEntityTargetGoal(this, 1.0D, 0.6F));

        this.goalSelector.add(7, new LookAtEntityGoal(this, MobEntity.class, 2.0F));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 1.0F));

        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
        this.targetSelector.add(3, new FollowTargetGoal<>(this, MobEntity.class, 5, false, false, (p_213619_0_) -> {
            return p_213619_0_ instanceof Monster && !(p_213619_0_ instanceof CreeperEntity) && !(p_213619_0_ instanceof EndGuardMob) && !(p_213619_0_ instanceof EndermanEntity) && !(p_213619_0_ instanceof ShulkerEntity);
        }));
    }

    public static DefaultAttributeContainer.Builder createEndguardAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2.5D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14D);
    }
    @Environment(EnvType.CLIENT)
    public boolean isAttacking() {
        return (Boolean)this.dataTracker.get(ATTACKING);
    }

    public void setAttacking(boolean shooting) {
        this.dataTracker.set(ATTACKING, shooting);
    }

    public void tickMovement() {
        super.tickMovement();
        if (this.attackTimer > 0) {
            --this.attackTimer;
            this.setTarget(null);
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (this.attackTimer <= 0) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.28D);
        }
        if (this.world.isClient() && this.getHealth() <= 50 && this.getHealth() != 0) {
            this.world.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 2.75D, this.getZ(), 0.0D, 0.0D, 0.0D);
        }
        this.setAttacking(this.attackTimer > 0);
        if (this.isImmobile()) {
            this.setAttacking(false);
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (squaredHorizontalLength(this.getVelocity()) > 2.500000277905201E-7D && this.random.nextInt(5) == 0) {
            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY() - 0.20000000298023224D);
            int k = MathHelper.floor(this.getZ());
            BlockState blockState = this.world.getBlockState(new BlockPos(i, j, k));
            if (!blockState.isAir()) {
                this.world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), this.getX() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getWidth(), this.getY() + 0.1D, this.getZ() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getWidth(), 4.0D * ((double)this.random.nextFloat() - 0.5D), 0.5D, ((double)this.random.nextFloat() - 0.5D) * 4.0D);
            }
        }
        if (this.horizontalCollision && this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            boolean bl = false;
            Box box = this.getBoundingBox().expand(0.2D);
            Iterator var8 = BlockPos.iterate(MathHelper.floor(box.minX), MathHelper.floor(box.minY), MathHelper.floor(box.minZ), MathHelper.floor(box.maxX), MathHelper.floor(box.maxY), MathHelper.floor(box.maxZ)).iterator();

            label60:
            while(true) {
                BlockPos blockPos;
                Block block;
                do {
                    if (!var8.hasNext()) {
                        if (!bl && this.onGround) {
                            this.jump();
                        }
                        break label60;
                    }

                    blockPos = (BlockPos)var8.next();
                    BlockState blockState = this.world.getBlockState(blockPos);
                    block = blockState.getBlock();
                } while(!(block instanceof LeavesBlock || block instanceof OganaPlant || block instanceof EndstonePlant || block instanceof FlowerBlock || block instanceof DoorBlock || block instanceof TallPlantBlock));

                bl = this.world.breakBlock(blockPos, true, this) || bl;
            }
        }
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }
    public boolean tryAttack(Entity target) {
        this.attackTimer = 15;
        this.world.sendEntityStatus(this, (byte)4);
        float f = this.getAttackDamage();
        float g = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean bl = target.damage(DamageSource.mob(this), g);
        if (bl) {
            target.setVelocity(target.getVelocity().add(0.0D, 0.1D, 0.0D));
            this.dealDamage(this, target);
        }

        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return bl;
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 4) {
            this.attackTimer = 25;
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleStatus(status);
        }
    }
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }
    @Environment(EnvType.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
    }
}