package com.electron.endreborn.mobs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public class EndormanMob extends MonsterEntity implements IAngerable {
    private static final DataParameter<Integer> SIZE = EntityDataManager.defineId(EndormanMob.class, DataSerializers.INT);
    private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final AttributeModifier ATTACKING_SPEED_BOOST = new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", (double)0.15F, AttributeModifier.Operation.ADDITION);
    private static final DataParameter<Optional<BlockState>> CARRIED_BLOCK = EntityDataManager.defineId(EndormanMob.class, DataSerializers.BLOCK_STATE);
    private static final DataParameter<Boolean> SCREAMING = EntityDataManager.defineId(EndormanMob.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> field_226535_bx_ = EntityDataManager.defineId(EndormanMob.class, DataSerializers.BOOLEAN);
    private static final Predicate<LivingEntity> field_213627_bA = (p_213626_0_) -> {
        return p_213626_0_ instanceof EndermiteEntity && ((EndermiteEntity)p_213626_0_).isPlayerSpawned();
    };
    private int lastStareSound = Integer.MIN_VALUE;
    private int targetChangeTime;
    private static final RangedInteger field_234286_bz_ = TickRangeConverter.rangeOfSeconds(20, 39);
    private int field_234284_bA_;
    private UUID field_234285_bB_;

    public EndormanMob(EntityType<? extends EndormanMob> type, World worldIn) {
        super(type, worldIn);
        this.maxUpStep = 1.0F;
        this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new EndormanMob.StareGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 0.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(10, new EndormanMob.PlaceBlockGoal(this));
        this.goalSelector.addGoal(11, new EndormanMob.TakeBlockGoal(this));
        this.targetSelector.addGoal(1, new EndormanMob.FindPlayerGoal(this, this::isAngryAt));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EndermiteEntity.class, 10, true, false, field_213627_bA));
        this.targetSelector.addGoal(4, new ResetAngerGoal<>(this, false));
    }

    public static AttributeModifierMap.MutableAttribute func_234287_m_() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.ATTACK_DAMAGE, 7.0D).add(Attributes.FOLLOW_RANGE, 64.0D);
    }
    public void setTarget(@Nullable LivingEntity entitylivingbaseIn) {
        ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (entitylivingbaseIn == null) {
            this.targetChangeTime = 0;
            this.entityData.set(SCREAMING, false);
            this.entityData.set(field_226535_bx_, false);
            modifiableattributeinstance.removeModifier(ATTACKING_SPEED_BOOST);
        } else {
            this.targetChangeTime = this.tickCount;
            this.entityData.set(SCREAMING, true);
            if (!modifiableattributeinstance.hasModifier(ATTACKING_SPEED_BOOST)) {
                modifiableattributeinstance.addTransientModifier(ATTACKING_SPEED_BOOST);
            }
        }

        super.setTarget(entitylivingbaseIn); //Forge: Moved down to allow event handlers to write data manager values.
    }

    public void setEndorSize(int sizeIn) {
        this.entityData.set(SIZE, MathHelper.clamp(sizeIn, 1, 6));
    }

    public int getEndorSize() {
        return this.entityData.get(SIZE);
    }

    private void updateEndorSize() {
        this.refreshDimensions();
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7 + this.getEndorSize());
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)(0.3 - 0.02 * this.getEndorSize()));
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40 + 3 * this.getEndorSize());

    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CARRIED_BLOCK, Optional.empty());
        this.entityData.define(SCREAMING, false);
        this.entityData.define(field_226535_bx_, false);
        this.entityData.define(SIZE, 0);
    }

    public void setAngerTime(int time) {
        this.field_234284_bA_ = time;
    }

    public void setRemainingPersistentAngerTime(int p_230260_1_) {
        this.field_234284_bA_ = p_230260_1_;
    }

    public int getRemainingPersistentAngerTime() {
        return this.field_234284_bA_;
    }

    public void startPersistentAngerTimer() {
        this.setAngerTime(field_234286_bz_.randomValue(this.random));
    }
    public void setPersistentAngerTarget(@Nullable UUID p_230259_1_) {
        this.field_234285_bB_ = p_230259_1_;
    }

    public UUID getPersistentAngerTarget() {
        return this.field_234285_bB_;
    }

    public void playStareSound() {
        if (this.tickCount >= this.lastStareSound + 400) {
            this.lastStareSound = this.tickCount;
            if (!this.isSilent()) {
                this.level.playLocalSound(this.getX(), this.getEyeY(), this.getZ(), SoundEvents.ENDERMAN_STARE, this.getSoundSource(), 2.5F, 1.0F, false);
            }
        }
    }
    public void onSyncedDataUpdated(DataParameter<?> key) {
        if (SIZE.equals(key)) {
            this.updateEndorSize();
        }
        if (SCREAMING.equals(key) && this.hasBeenStaredAt() && this.level.isClientSide) {
            this.playStareSound();
        }
        super.onSyncedDataUpdated(key);
    }


    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        BlockState blockstate = this.getHeldBlockState();
        if (blockstate != null) {
            p_213281_1_.put("carriedBlockState", NBTUtil.writeBlockState(blockstate));
        }

        this.addPersistentAngerSaveData(p_213281_1_);
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        BlockState blockstate = null;
        if (p_70037_1_.contains("carriedBlockState", 10)) {
            blockstate = NBTUtil.readBlockState(p_70037_1_.getCompound("carriedBlockState"));
            if (blockstate.isAir()) {
                blockstate = null;
            }
        }

        this.setHeldBlockState(blockstate);
        if(!level.isClientSide) //FORGE: allow this entity to be read from nbt on client. (Fixes MC-189565)
            this.readPersistentAngerSaveData((ServerWorld)this.level, p_70037_1_);
    }

    private boolean isLookingAtMe(PlayerEntity player) {
        ItemStack itemstack = player.inventory.armor.get(3);
        if (itemstack.getItem() == Blocks.CARVED_PUMPKIN.asItem()) {
            return false;
        } else {
            int i = this.getEndorSize();
            Vector3d vector3d = player.getViewVector(1.0F).normalize();
            Vector3d vector3d1 = new Vector3d(this.getX() - player.getX(), this.getEyeY() + (0.2F * (float)i) - player.getEyeY(), this.getZ() - player.getZ());
            double d0 = vector3d1.length();
            vector3d1 = vector3d1.normalize();
            double d1 = vector3d.dot(vector3d1);
            return d1 > 1.0D - 0.025D / d0 ? player.canSee(this) : false;
        }
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return sizeIn.height - 0.35F;
    }

    public void aiStep() {
        if (this.level.isClientSide) {
            for(int i = 0; i < 2; ++i) {
                this.level.addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
            }
        }

        this.jumping = false;
        if (!this.level.isClientSide) {
            this.updatePersistentAnger((ServerWorld)this.level, true);
        }

        super.aiStep();
    }

    public boolean isSensitiveToWater() {
        return true;
    }

    protected void customServerAiStep() {
        if (this.level.isDay() && this.tickCount >= this.targetChangeTime + 600) {
            float f = this.getBrightness();
            if (f > 0.5F && this.level.canSeeSky(this.blockPosition()) && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
                this.setTarget((LivingEntity)null);
                this.teleport();
            }
        }
        super.customServerAiStep();
    }

    protected boolean teleport() {
        if (!this.level.isClientSide() && this.isAlive()) {
            double d0 = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
            double d1 = this.getY() + (double)(this.random.nextInt(64) - 32);
            double d2 = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
            return this.teleport(d0, d1, d2);
        } else {
            return false;
        }
    }

    private boolean teleportTowards(Entity p_70816_1_) {
        Vector3d vector3d = new Vector3d(this.getX() - p_70816_1_.getX(), this.getY(0.5D) - p_70816_1_.getEyeY(), this.getZ() - p_70816_1_.getZ());
        vector3d = vector3d.normalize();
        double d0 = 16.0D;
        double d1 = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vector3d.x * 16.0D;
        double d2 = this.getY() + (double)(this.random.nextInt(16) - 8) - vector3d.y * 16.0D;
        double d3 = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vector3d.z * 16.0D;
        return this.teleport(d1, d2, d3);
    }

    private boolean teleport(double x, double y, double z) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z);

        while(blockpos$mutable.getY() > 0 && !this.level.getBlockState(blockpos$mutable).getMaterial().blocksMotion()) {
            blockpos$mutable.move(Direction.DOWN);
        }

        BlockState blockstate = this.level.getBlockState(blockpos$mutable);
        boolean flag = blockstate.getMaterial().blocksMotion();
        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
        if (flag && !flag1) {
            net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
            if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
            boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2 && !this.isSilent()) {
                this.level.playSound((PlayerEntity)null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
                this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return flag2;
        } else {
            return false;
        }
    }

    protected SoundEvent getAmbientSound() {
        return this.isScreaming() ? SoundEvents.ENDERMAN_SCREAM : SoundEvents.ENDERMAN_AMBIENT;
    }
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ENDERMAN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    protected void dropCustomDeathLoot(DamageSource p_213333_1_, int p_213333_2_, boolean p_213333_3_) {
        super.dropCustomDeathLoot(p_213333_1_, p_213333_2_, p_213333_3_);
        BlockState blockstate = this.getHeldBlockState();
        if (blockstate != null) {
            this.spawnAtLocation(blockstate.getBlock());
        }

    }
    public void setHeldBlockState(@Nullable BlockState state) {
        this.entityData.set(CARRIED_BLOCK, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getHeldBlockState() {
        return this.entityData.get(CARRIED_BLOCK).orElse((BlockState)null);
    }

    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        if (this.isInvulnerableTo(p_70097_1_)) {
            return false;
        } else if (p_70097_1_ instanceof IndirectEntityDamageSource) {
            for(int i = 0; i < 64; ++i) {
                if (this.teleport()) {
                    return true;
                }
            }

            return false;
        } else {
            boolean flag = super.hurt(p_70097_1_, p_70097_2_);
            if (!this.level.isClientSide() && !(p_70097_1_.getEntity() instanceof LivingEntity) && this.random.nextInt(10) != 0) {
                this.teleport();
            }

            return flag;
        }
    }

    public boolean isScreaming() {
        return this.entityData.get(SCREAMING);
    }

    public boolean hasBeenStaredAt() {
        return this.entityData.get(field_226535_bx_);
    }

    public void setBeingStaredAt() {
        this.entityData.set(field_226535_bx_, true);
    }

    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.getHeldBlockState() != null;
    }

    static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        private final EndormanMob enderman;
        private PlayerEntity pendingTarget;
        private int aggroTime;
        private int teleportTime;
        private final EntityPredicate startAggroTargetConditions;
        private final EntityPredicate continueAggroTargetConditions = (new EntityPredicate()).allowUnseeable();

        public FindPlayerGoal(EndormanMob p_i241912_1_, @Nullable Predicate<LivingEntity> p_i241912_2_) {
            super(p_i241912_1_, PlayerEntity.class, 10, false, false, p_i241912_2_);
            this.enderman = p_i241912_1_;
            this.startAggroTargetConditions = (new EntityPredicate()).range(this.getFollowDistance()).selector((p_220790_1_) -> {
                return p_i241912_1_.isLookingAtMe((PlayerEntity)p_220790_1_);
            });
        }

        public boolean canUse() {
            this.pendingTarget = this.enderman.level.getNearestPlayer(this.startAggroTargetConditions, this.enderman);
            return this.pendingTarget != null;
        }

        public void start() {
            this.aggroTime = 5;
            this.teleportTime = 0;
            this.enderman.setBeingStaredAt();
        }

        public void stop() {
            this.pendingTarget = null;
            super.stop();
        }

        public boolean canContinueToUse() {
            if (this.pendingTarget != null) {
                if (!this.enderman.isLookingAtMe(this.pendingTarget)) {
                    return false;
                } else {
                    this.enderman.lookAt(this.pendingTarget, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.target != null && this.continueAggroTargetConditions.test(this.enderman, this.target) ? true : super.canContinueToUse();
            }
        }

        public void tick() {
            if (this.enderman.getTarget() == null) {
                super.setTarget((LivingEntity)null);
            }

            if (this.pendingTarget != null) {
                if (--this.aggroTime <= 0) {
                    this.target = this.pendingTarget;
                    this.pendingTarget = null;
                    super.start();
                }
            } else {
                if (this.target != null && !this.enderman.isPassenger()) {
                    if (this.enderman.isLookingAtMe((PlayerEntity)this.target)) {
                        if (this.target.distanceToSqr(this.enderman) < 16.0D) {
                            this.enderman.teleport();
                        }

                        this.teleportTime = 0;
                    } else if (this.target.distanceToSqr(this.enderman) > 256.0D && this.teleportTime++ >= 30 && this.enderman.teleportTowards(this.target)) {
                        this.teleportTime = 0;
                    }
                }

                super.tick();
            }

        }
    }

    static class PlaceBlockGoal extends Goal {
        private final EndormanMob enderman;

        public PlaceBlockGoal(EndormanMob p_i45843_1_) {
            this.enderman = p_i45843_1_;
        }

        public boolean canUse() {
            if (this.enderman.getHeldBlockState() == null) {
                return false;
            } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.enderman.level, this.enderman)) {
                return false;
            } else {
                return this.enderman.getRandom().nextInt(2000) == 0;
            }
        }

        public void tick() {
            Random random = this.enderman.getRandom();
            World world = this.enderman.level;
            int i = MathHelper.floor(this.enderman.getX() - 1.0D + random.nextDouble() * 2.0D);
            int j = MathHelper.floor(this.enderman.getY() + random.nextDouble() * 2.0D);
            int k = MathHelper.floor(this.enderman.getZ() - 1.0D + random.nextDouble() * 2.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            BlockState blockstate = world.getBlockState(blockpos);
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate1 = world.getBlockState(blockpos1);
            BlockState blockstate2 = this.enderman.getHeldBlockState();
            if (blockstate2 != null) {
                blockstate2 = Block.updateFromNeighbourShapes(blockstate2, this.enderman.level, blockpos);
                if (this.canPlaceBlock(world, blockpos, blockstate2, blockstate, blockstate1, blockpos1) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(enderman, net.minecraftforge.common.util.BlockSnapshot.create(world.dimension(), world, blockpos1), net.minecraft.util.Direction.UP)) {
                    world.setBlock(blockpos, blockstate2, 3);
                    this.enderman.setHeldBlockState((BlockState)null);
                }

            }
        }

        private boolean canPlaceBlock(World p_220836_1_, BlockPos p_220836_2_, BlockState p_220836_3_, BlockState p_220836_4_, BlockState p_220836_5_, BlockPos p_220836_6_) {
            return p_220836_4_.isAir(p_220836_1_, p_220836_2_) && !p_220836_5_.isAir(p_220836_1_, p_220836_6_) && !p_220836_5_.is(Blocks.BEDROCK) && !p_220836_5_.is(net.minecraftforge.common.Tags.Blocks.ENDERMAN_PLACE_ON_BLACKLIST) && p_220836_5_.isCollisionShapeFullBlock(p_220836_1_, p_220836_6_) && p_220836_3_.canSurvive(p_220836_1_, p_220836_2_) && p_220836_1_.getEntities(this.enderman, AxisAlignedBB.unitCubeFromLowerCorner(Vector3d.atLowerCornerOf(p_220836_2_))).isEmpty();
        }
    }

    static class StareGoal extends Goal {
        private final EndormanMob enderman;
        private LivingEntity target;

        public StareGoal(EndormanMob p_i50520_1_) {
            this.enderman = p_i50520_1_;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            this.target = this.enderman.getTarget();
            if (!(this.target instanceof PlayerEntity)) {
                return false;
            } else {
                double d0 = this.target.distanceToSqr(this.enderman);
                return d0 > 256.0D ? false : this.enderman.isLookingAtMe((PlayerEntity)this.target);
            }
        }

        public void start() {
            this.enderman.getNavigation().stop();
        }

        public void tick() {
            this.enderman.getLookControl().setLookAt(this.target.getX(), this.target.getEyeY(), this.target.getZ());
        }
    }

    static class TakeBlockGoal extends Goal {
        private final EndormanMob enderman;

        public TakeBlockGoal(EndormanMob p_i45841_1_) {
            this.enderman = p_i45841_1_;
        }

        public boolean canUse() {
            if (this.enderman.getHeldBlockState() != null) {
                return false;
            } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.enderman.level, this.enderman)) {
                return false;
            } else {
                return this.enderman.getRandom().nextInt(20) == 0;
            }
        }

        public void tick() {
            Random random = this.enderman.getRandom();
            World world = this.enderman.level;
            int i = MathHelper.floor(this.enderman.getX() - 2.0D + random.nextDouble() * 4.0D);
            int j = MathHelper.floor(this.enderman.getY() + random.nextDouble() * 3.0D);
            int k = MathHelper.floor(this.enderman.getZ() - 2.0D + random.nextDouble() * 4.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = blockstate.getBlock();
            Vector3d vector3d = new Vector3d((double)MathHelper.floor(this.enderman.getX()) + 0.5D, (double)j + 0.5D, (double)MathHelper.floor(this.enderman.getZ()) + 0.5D);
            Vector3d vector3d1 = new Vector3d((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D);
            BlockRayTraceResult blockraytraceresult = world.clip(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, this.enderman));
            boolean flag = blockraytraceresult.getBlockPos().equals(blockpos);
            if (block.is(BlockTags.ENDERMAN_HOLDABLE) && flag) {
                world.removeBlock(blockpos, false);
                this.enderman.setHeldBlockState(blockstate.getBlock().defaultBlockState());
            }

        }
    }
}

