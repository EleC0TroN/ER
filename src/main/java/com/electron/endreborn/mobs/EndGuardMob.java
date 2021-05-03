package com.electron.endreborn.mobs;

import com.electron.endreborn.blocks.EndstonePlant;
import com.electron.endreborn.blocks.OganaWeed;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EndGuardMob extends MonsterEntity {
    private int attackTimer;
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(EndGuardMob.class, DataSerializers.BOOLEAN);

    public EndGuardMob(EntityType<? extends EndGuardMob> type, World worldIn) {
        super(type, worldIn);
        this.stepHeight = 0.7F;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setPathPriority(PathNodeType.LAVA, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.0D, 32.0F));

        this.goalSelector.addGoal(7, new LookAtGoal(this, MobEntity.class, 2.0F));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 2.0F));

        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (p_213619_0_) -> {
            return p_213619_0_ instanceof IMob && !(p_213619_0_ instanceof CreeperEntity) && !(p_213619_0_ instanceof EndGuardMob) && !(p_213619_0_ instanceof EndermanEntity) && !(p_213619_0_ instanceof EndormanMob) && !(p_213619_0_ instanceof ShulkerEntity);
        }));
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.256D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(1.0D);
    }
    @OnlyIn(Dist.CLIENT)
    public boolean isAttacking() {
        return this.dataManager.get(ATTACKING);
    }
    public void setAttacking(boolean attacking) {
        this.dataManager.set(ATTACKING, attacking);
    }
    protected void registerData() {
        super.registerData();
        this.dataManager.register(ATTACKING, false);
    }
    protected int decreaseAirSupply(int air) {
        return air;
    }

    public void livingTick() {
        super.livingTick();
        if (this.attackTimer > 0) {
            --this.attackTimer;
            this.setAttackTarget(null);
            this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (this.attackTimer <= 0) {
            this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.256D);
        }
        if (this.world.isRemote && this.getHealth() <= 50 && this.getHealth() != 0) {
            this.world.addParticle(ParticleTypes.SMOKE, this.getPosX(), this.getPosY() + 2.75D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
        }
        this.setAttacking(this.attackTimer > 0);
        if (this.isMovementBlocked()|| this.isInWaterOrBubbleColumn()) {
            this.setAttacking(false);
            this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (horizontalMag(this.getMotion()) > (double)2.5000003E-7F && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor(this.getPosX());
            int j = MathHelper.floor(this.getPosY() - (double)0.2F);
            int k = MathHelper.floor(this.getPosZ());
            BlockPos pos = new BlockPos(i, j, k);
            BlockState blockstate = this.world.getBlockState(pos);
            if (!blockstate.isAir(this.world, pos)) {
                this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getPosX() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), this.getPosY() + 0.1D, this.getPosZ() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
            }
        }
        if (this.collided && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
            boolean flag = false;
            AxisAlignedBB axisalignedbb = this.getBoundingBox().grow(0.2D);

            for(BlockPos blockpos : BlockPos.getAllInBoxMutable(MathHelper.floor(axisalignedbb.minX), MathHelper.floor(axisalignedbb.minY), MathHelper.floor(axisalignedbb.minZ), MathHelper.floor(axisalignedbb.maxX), MathHelper.floor(axisalignedbb.maxY), MathHelper.floor(axisalignedbb.maxZ))) {
                BlockState blockstate = this.world.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof LeavesBlock || block instanceof OganaWeed || block instanceof EndstonePlant || block instanceof FlowerBlock || block instanceof DoorBlock || block instanceof TallGrassBlock) {
                    flag = this.world.destroyBlock(blockpos, true, this) || flag;
                }
            }
        }
    }

    private float func_226511_et_() {
        return (float)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
    }

    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }
    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTimer = 15;
        this.world.setEntityState(this, (byte)4);
        float f = this.func_226511_et_();
        float f1 = f > 0.0F ? f / 2.0F + (float)this.rand.nextInt((int)f) : 0.0F;
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f1);
        if (flag) {
            entityIn.setMotion(entityIn.getMotion().add(0.0, (double)0.1F, 0.0D));
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTimer = 28;
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 0.9F, 0.9F);
        } else {
            super.handleStatusUpdate(id);
        }

    }
    @OnlyIn(Dist.CLIENT)
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