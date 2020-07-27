package com.electron.endreborn.mobs;

import com.electron.endreborn.blocks.EndstonePlant;
import com.electron.endreborn.blocks.OganaPlant;
import com.electron.endreborn.blocks.OganaWeed;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
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
    private static final RangedInteger field_234196_bu_ = TickRangeConverter.func_233037_a_(20, 39);
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
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 200.0D).func_233815_a_(Attributes.field_233821_d_, 0.28D).func_233815_a_(Attributes.field_233820_c_, 1.0D).func_233815_a_(Attributes.field_233823_f_, 16.0D);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    protected void collideWithEntity(Entity entityIn) {

        super.collideWithEntity(entityIn);
    }

    public void livingTick() {
        super.livingTick();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.world.isRemote && this.getHealth() <= 50 && this.getHealth() != 0) {
            this.world.addParticle(ParticleTypes.SMOKE, this.getPosX(), this.getPosY() + 2.75D, this.getPosZ(), 0.0D, 0.0D, 0.0D);

        }
        this.setAttacking(this.attackTimer > 0);
        if (this.isMovementBlocked()) {
            this.setAttacking(false);
            this.getAttribute(Attributes.field_233821_d_).setBaseValue(0.0D);
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

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.func_233682_c_(compound);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.func_241358_a_((ServerWorld)this.world, compound);
    }

    public void func_230258_H__() {
        this.func_230260_a__(field_234196_bu_.func_233018_a_(this.rand));
    }
    public void func_230260_a__(int p_230260_1_) {
        this.field_234197_bv_ = p_230260_1_;
    }
    public int func_230256_F__() {
        return this.field_234197_bv_;
    }

    public void func_230259_a_(@Nullable UUID p_230259_1_) {
        this.field_234198_bw_ = p_230259_1_;
    }
    public UUID func_230257_G__() {
        return this.field_234198_bw_;
    }
    private float func_226511_et_() {
        return (float)this.func_233637_b_(Attributes.field_233823_f_);
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
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTimer = 20;
            this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
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

    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
    }

    public boolean isNotColliding(IWorldReader worldIn) {
        BlockPos blockpos = this.func_233580_cy_();
        BlockPos blockpos1 = blockpos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos1);
        if (!blockstate.func_235719_a_(worldIn, blockpos1, this)) {
            return false;
        } else {
            for(int i = 1; i < 3; ++i) {
                BlockPos blockpos2 = blockpos.up(i);
                BlockState blockstate1 = worldIn.getBlockState(blockpos2);
                if (!WorldEntitySpawner.func_234968_a_(worldIn, blockpos2, blockstate1, blockstate1.getFluidState(), EntityType.IRON_GOLEM)) {
                    return false;
                }
            }

            return WorldEntitySpawner.func_234968_a_(worldIn, blockpos, worldIn.getBlockState(blockpos), Fluids.EMPTY.getDefaultState(), EntityType.IRON_GOLEM) && worldIn.checkNoEntityCollision(this);
        }
    }
}