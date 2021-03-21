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
    private static final RangedInteger field_234196_bu_ = TickRangeConverter.convertRange(20, 39);
    private int field_234197_bv_;
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(EndGuardMob.class, DataSerializers.BOOLEAN);
    private UUID field_234198_bw_;

    public EndGuardMob(EntityType<? extends EndGuardMob> type, World worldIn) {
        super(type, worldIn);
        this.stepHeight = 1.0F;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
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
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("AttackTimer", this.attackTimer);
    }
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.attackTimer = compound.getInt("AttackTimer");
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

    public static AttributeModifierMap.MutableAttribute func_234200_m_() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 200.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.28D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 14.0D);
    }

    protected int decreaseAirSupply(int air) { return air; }
    protected void collideWithEntity(Entity entityIn) {

        super.collideWithEntity(entityIn);
    }

    public void livingTick() {
        super.livingTick();
        if (this.attackTimer > 0) {
            --this.attackTimer;
            this.setAttackTarget(null);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (this.attackTimer <= 0) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        }
        if (this.world.isRemote && this.getHealth() <= 50 && this.getHealth() != 0) {
            this.world.addParticle(ParticleTypes.SMOKE, this.getPosX(), this.getPosY() + 2.75D, this.getPosZ(), 0.0D, 0.0D, 0.0D);

        }
        this.setAttacking(this.attackTimer > 0);
        if (this.isMovementBlocked()) {
            this.setAttacking(false);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        }
        if (horizontalMag(this.getMotion()) > (double)2.5000003E-7F && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor(this.getPosX());
            int j = MathHelper.floor(this.getPosY() - (double)0.1F);
            int k = MathHelper.floor(this.getPosZ());
            BlockPos pos = new BlockPos(i, j, k);
            BlockState blockstate = this.world.getBlockState(pos);
            if (!blockstate.isAir(this.world, pos)) {
                this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getPosX() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), this.getPosY() + 0.1D, this.getPosZ() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
            }
        }
        if (this.collidedHorizontally && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
            boolean flag = false;
            AxisAlignedBB axisalignedbb = this.getBoundingBox().grow(0.2D);

            for(BlockPos blockpos : BlockPos.getAllInBoxMutable(MathHelper.floor(axisalignedbb.minX), MathHelper.floor(axisalignedbb.minY), MathHelper.floor(axisalignedbb.minZ), MathHelper.floor(axisalignedbb.maxX), MathHelper.floor(axisalignedbb.maxY), MathHelper.floor(axisalignedbb.maxZ))) {
                BlockState blockstate = this.world.getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof LeavesBlock || block instanceof OganaWeed || block instanceof OganaPlant || block instanceof EndstonePlant || block instanceof FlowerBlock || block instanceof DoorBlock || block instanceof TallGrassBlock) {
                    flag = this.world.destroyBlock(blockpos, true, this) || flag;
                }
            }
        }
        if (!this.world.isRemote) {
            this.func_241359_a_((ServerWorld)this.world, true);
        }

    }
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }
    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    public void func_230258_H__() {
        this.setAngerTime(field_234196_bu_.getRandomWithinRange(this.rand));
    }

    public void setAngerTime(int time) {
        this.field_234197_bv_ = time;
    }

    public int getAngerTime() {
        return this.field_234197_bv_;
    }

    public void setAngerTarget(@Nullable UUID target) {
        this.field_234198_bw_ = target;
    }

    public UUID getAngerTarget() {
        return this.field_234198_bw_;
    }

    private float func_226511_et_() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte)4);
        float f = this.func_226511_et_();
        float f1 = (int)f > 0 ? f / 2.0F + (float)this.rand.nextInt((int)f) : f;
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f1);
        if (flag) {
            entityIn.setMotion(entityIn.getMotion().add(0.0D, (double)0.1F, 0.0D));
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }
    @OnlyIn(Dist.CLIENT)
    public Vector3d func_241205_ce_() {
        return new Vector3d(0.0D, (double)(0.875F * this.getEyeHeight()), (double)(this.getWidth() * 0.4F));
    }
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTimer = 25;
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        } else {
            super.handleStatusUpdate(id);
        }

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

    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
    }

    public boolean isNotColliding(IWorldReader worldIn) {
        BlockPos blockpos = this.getPosition();
        BlockPos blockpos1 = blockpos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos1);
        if (!blockstate.canSpawnMobs(worldIn, blockpos1, this)) {
            return false;
        } else {
            for(int i = 1; i < 3; ++i) {
                BlockPos blockpos2 = blockpos.up(i);
                BlockState blockstate1 = worldIn.getBlockState(blockpos2);
                if (!WorldEntitySpawner.func_234968_a_(worldIn, blockpos2, blockstate1, blockstate1.getFluidState(), ModMobs.ENDGUARD.get())) {
                    return false;
                }
            }
            return WorldEntitySpawner.func_234968_a_(worldIn, blockpos, worldIn.getBlockState(blockpos), Fluids.EMPTY.getDefaultState(), ModMobs.ENDGUARD.get()) && worldIn.checkNoEntityCollision(this);
        }
    }
}