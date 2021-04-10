package com.electron.endreborn.mobs;

import com.electron.endreborn.ModMobs;
import com.electron.endreborn.blocks.EndstonePlant;
import com.electron.endreborn.blocks.OganaPlant;
import com.electron.endreborn.blocks.OganaWeed;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.UUID;

public class EndGuardMob extends MonsterEntity implements IAngerable {
    private int attackTimer;
    private static final RangedInteger field_234196_bu_ = TickRangeConverter.rangeOfSeconds(20, 39);
    private int field_234197_bv_;
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(EndGuardMob.class, DataSerializers.BOOLEAN);
    private UUID field_234198_bw_;

    public EndGuardMob(EntityType<? extends EndGuardMob> type, World worldIn) {
        super(type, worldIn);
        this.maxUpStep = 0.7F;
        this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
        this.setPathfindingMalus(PathNodeType.LAVA, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.0D, 0.6F));
        this.goalSelector.addGoal(7, new LookAtGoal(this, MobEntity.class, 2.0F));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 1.0F));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (p_213619_0_) -> {
            return p_213619_0_ instanceof IMob && !(p_213619_0_ instanceof CreeperEntity) && !(p_213619_0_ instanceof EndGuardMob) && !(p_213619_0_ instanceof EndermanEntity) && !(p_213619_0_ instanceof EndormanMob) && !(p_213619_0_ instanceof ShulkerEntity);
        }));
        this.targetSelector.addGoal(4, new ResetAngerGoal<>(this, false));
    }
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("AttackTimer", this.attackTimer);
    }
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.attackTimer = compound.getInt("AttackTimer");
    }
    @OnlyIn(Dist.CLIENT)
    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }
    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    public static AttributeModifierMap.MutableAttribute func_234200_m_() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D).add(Attributes.MOVEMENT_SPEED, 0.256D).add(Attributes.ATTACK_KNOCKBACK, 1.0D).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_DAMAGE, 13.5D);
    }

    protected int decreaseAirSupply(int air) { return air; }
    protected void doPush(Entity entityIn) {
        super.doPush(entityIn);
    }

    public void aiStep() {
        super.aiStep();
        if (this.attackTimer > 0) {
            --this.attackTimer;
            this.setTarget(null);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (this.attackTimer <= 0) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.256D);
        }
        if (this.level.isClientSide && this.getHealth() <= 50 && this.getHealth() != 0) {
            this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 2.75D, this.getZ(), 0.0D, 0.0D, 0.0D);
        }
        this.setAttacking(this.attackTimer > 0);
        if (this.isImmobile() || this.isInWaterOrBubble()) {
            this.setAttacking(false);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (getHorizontalDistanceSqr(this.getDeltaMovement()) > (double)2.5000003E-7F && this.random.nextInt(5) == 0) {
            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY() - (double)0.2F);
            int k = MathHelper.floor(this.getZ());
            BlockPos pos = new BlockPos(i, j, k);
            BlockState blockstate = this.level.getBlockState(pos);
            if (!blockstate.isAir(this.level, pos)) {
                this.level.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double)this.random.nextFloat() - 0.5D) * (double)this.getBbWidth(), 4.0D * ((double)this.random.nextFloat() - 0.5D), 0.5D, ((double)this.random.nextFloat() - 0.5D) * 4.0D);
            }
        }
        if (this.horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this)) {
            boolean flag = false;
            AxisAlignedBB axisalignedbb = this.getBoundingBox().inflate(0.2D);

            for(BlockPos blockpos : BlockPos.betweenClosed(MathHelper.floor(axisalignedbb.minX), MathHelper.floor(axisalignedbb.minY), MathHelper.floor(axisalignedbb.minZ), MathHelper.floor(axisalignedbb.maxX), MathHelper.floor(axisalignedbb.maxY), MathHelper.floor(axisalignedbb.maxZ))) {
                BlockState blockstate = this.level.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof LeavesBlock || block instanceof OganaWeed || block instanceof OganaPlant || block instanceof EndstonePlant || block instanceof FlowerBlock || block instanceof DoorBlock || block instanceof TallGrassBlock) {
                    flag = this.level.destroyBlock(blockpos, true, this) || flag;
                }
            }
        }
        if (!this.level.isClientSide) {
            this.updatePersistentAnger((ServerWorld)this.level, true);
        }

    }
    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }
    public boolean removeWhenFarAway(double p_213397_1_) {
        return false;
    }

    public void startPersistentAngerTimer() {
        this.setAngerTime(field_234196_bu_.randomValue(this.random));
    }
    public void setAngerTime(int time) {
        this.field_234197_bv_ = time;
    }

    public int getRemainingPersistentAngerTime() {
        return this.field_234197_bv_;
    }

    public void setRemainingPersistentAngerTime(int p_230260_1_) {
        this.field_234197_bv_ = p_230260_1_;
    }

    public void setPersistentAngerTarget(@Nullable UUID p_230259_1_) {
        this.field_234198_bw_ = p_230259_1_;
    }

    public UUID getPersistentAngerTarget() {
        return this.field_234198_bw_;
    }

    private float func_226511_et_() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public boolean doHurtTarget(Entity entityIn) {
        this.attackTimer = 10;
        this.level.broadcastEntityEvent(this, (byte)4);
        float f = this.func_226511_et_();
        float f1 = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), f1);
        if (flag) {
            entityIn.setDeltaMovement(entityIn.getDeltaMovement().add(0.0D, (double)0.1F, 0.0D));
            this.doEnchantDamageEffects(this, entityIn);
        }

        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }

    @OnlyIn(Dist.CLIENT)
    public Vector3d getLeashOffset() {
        return new Vector3d(0.0D, (double)(0.875F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 4) {
            this.attackTimer = 27;
            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleEntityEvent(id);
        }

    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 0.7F, 1.0F);
    }

    public boolean checkSpawnObstruction(IWorldReader worldIn) {
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.below();
        BlockState blockstate = worldIn.getBlockState(blockpos1);
        if (!blockstate.entityCanStandOn(worldIn, blockpos1, this)) {
            return false;
        } else {
            for(int i = 1; i < 3; ++i) {
                BlockPos blockpos2 = blockpos.above(i);
                BlockState blockstate1 = worldIn.getBlockState(blockpos2);
                if (!WorldEntitySpawner.isValidEmptySpawnBlock(worldIn, blockpos2, blockstate1, blockstate1.getFluidState(), ModMobs.ENDGUARD.get())) {
                    return false;
                }
            }
            return WorldEntitySpawner.isValidEmptySpawnBlock(worldIn, blockpos, worldIn.getBlockState(blockpos), Fluids.EMPTY.defaultFluidState(), ModMobs.ENDGUARD.get()) && worldIn.isUnobstructed(this);
        }
    }
}