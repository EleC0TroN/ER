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
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.MonsterEntity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public class EndormanMob extends MonsterEntity {
    private static final DataParameter<Integer> SIZE = EntityDataManager.createKey(EndormanMob.class, DataSerializers.VARINT);
    private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final AttributeModifier ATTACKING_SPEED_BOOST = new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", (double)0.15F, AttributeModifier.Operation.ADDITION);
    private static final DataParameter<Optional<BlockState>> CARRIED_BLOCK = EntityDataManager.createKey(EndormanMob.class, DataSerializers.OPTIONAL_BLOCK_STATE);
    private static final DataParameter<Boolean> SCREAMING = EntityDataManager.createKey(EndormanMob.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> field_226535_bx_ = EntityDataManager.createKey(EndormanMob.class, DataSerializers.BOOLEAN);
    private static final Predicate<LivingEntity> field_213627_bA = (p_213626_0_) -> {
        return p_213626_0_ instanceof EndermiteEntity && ((EndermiteEntity)p_213626_0_).isSpawnedByPlayer();
    };
    private int field_226536_bz_ = Integer.MIN_VALUE;
    private int targetChangeTime;

    public EndormanMob(EntityType<? extends EndormanMob> type, World worldIn) {
        super(type, worldIn);
        this.stepHeight = 1.0F;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
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
        this.targetSelector.addGoal(1, new EndormanMob.FindPlayerGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EndermiteEntity.class, 10, true, false, field_213627_bA));
    }

    public static AttributeModifierMap.MutableAttribute func_234287_m_() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 40.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.3F).func_233815_a_(Attributes.field_233823_f_, 7.0D).func_233815_a_(Attributes.field_233819_b_, 64.0D);
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
        ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.field_233821_d_);
        if (entitylivingbaseIn == null) {
            this.targetChangeTime = 0;
            this.dataManager.set(SCREAMING, false);
            this.dataManager.set(field_226535_bx_, false);
            modifiableattributeinstance.removeModifier(ATTACKING_SPEED_BOOST);
        } else {
            this.targetChangeTime = this.ticksExisted;
            this.dataManager.set(SCREAMING, true);
            if (!modifiableattributeinstance.hasModifier(ATTACKING_SPEED_BOOST)) {
                modifiableattributeinstance.func_233767_b_(ATTACKING_SPEED_BOOST);
            }
        }

        super.setAttackTarget(entitylivingbaseIn); //Forge: Moved down to allow event handlers to write data manager values.
    }
    public void setEndorSize(int sizeIn) {
        this.dataManager.set(SIZE, MathHelper.clamp(sizeIn, 1, 6));
    }

    public int getEndorSize() {
        return this.dataManager.get(SIZE);
    }

    private void updateEndorSize() {
        this.recalculateSize();
        this.getAttribute(Attributes.field_233823_f_).setBaseValue(7 + this.getEndorSize());
        this.getAttribute(Attributes.field_233821_d_).setBaseValue((double)(0.3 - 0.02 * this.getEndorSize()));
        this.getAttribute(Attributes.field_233818_a_).setBaseValue(40 + 3 * this.getEndorSize());

    }
    protected void registerData() {
        super.registerData();
        this.dataManager.register(CARRIED_BLOCK, Optional.empty());
        this.dataManager.register(SCREAMING, false);
        this.dataManager.register(field_226535_bx_, false);
        this.dataManager.register(SIZE, 0);
    }

    public void func_226539_l_() {
        if (this.ticksExisted >= this.field_226536_bz_ + 400) {
            this.field_226536_bz_ = this.ticksExisted;
            if (!this.isSilent()) {
                this.world.playSound(this.getPosX(), this.getPosYEye(), this.getPosZ(), SoundEvents.ENTITY_ENDERMAN_STARE, this.getSoundCategory(), 1.5F, 1.0F, false);
            }
        }

    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        if (SIZE.equals(key)) {
            this.updateEndorSize();
        }
        if (SCREAMING.equals(key) && this.func_226537_et_() && this.world.isRemote) {
            this.func_226539_l_();
        }

        super.notifyDataManagerChange(key);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        BlockState blockstate = this.getHeldBlockState();
        if (blockstate != null) {
            compound.put("carriedBlockState", NBTUtil.writeBlockState(blockstate));
        }

    }

    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {

        this.setEndorSize(0);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        BlockState blockstate = null;
        if (compound.contains("carriedBlockState", 10)) {
            blockstate = NBTUtil.readBlockState(compound.getCompound("carriedBlockState"));
            if (blockstate.isAir()) {
                blockstate = null;
            }
        }
        this.setEndorSize(compound.getInt("Size"));
        this.setHeldBlockState(blockstate);
    }

    /**
     * Checks to see if this enderman should be attacking this player
     */

    private boolean shouldAttackPlayer(PlayerEntity player) {
        ItemStack itemstack = player.inventory.armorInventory.get(3);
        if (itemstack.getItem() == Blocks.CARVED_PUMPKIN.asItem()) {
            return false;
        } else {
            int i = this.getEndorSize();
            Vector3d vector3d = player.getLook(1.0F).normalize();
            Vector3d vector3d1 = new Vector3d(this.getPosX() - player.getPosX(), this.getPosYEye() + (0.2F * (float)i) - player.getPosYEye(), this.getPosZ() - player.getPosZ());
            double d0 = vector3d1.length();
            vector3d1 = vector3d1.normalize();
            double d1 = vector3d.dotProduct(vector3d1);
            return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
        }
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return sizeIn.height - 0.35F;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void livingTick() {

        if (this.world.isRemote) {
            for(int i = 0; i < 2; ++i) {
                this.world.addParticle(ParticleTypes.PORTAL, this.getPosXRandom(0.5D), this.getPosYRandom() - 0.25D, this.getPosZRandom(0.5D), (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }
        }

        this.isJumping = false;
        super.livingTick();
    }

    protected void updateAITasks() {
        if (this.world.isDaytime() && this.ticksExisted >= this.targetChangeTime + 600) {
            float f = this.getBrightness();
            if (f > 0.5F && this.world.canSeeSky(this.func_233580_cy_()) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
                this.setAttackTarget((LivingEntity)null);
                this.teleportRandomly();
            }
        }

        super.updateAITasks();
    }

    /**
     * Teleport the enderman to a random nearby position
     */
    protected boolean teleportRandomly() {
        if (!this.world.isRemote() && this.isAlive()) {
            double d0 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 64.0D;
            double d1 = this.getPosY() + (double)(this.rand.nextInt(64) - 32);
            double d2 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 64.0D;
            return this.teleportTo(d0, d1, d2);
        } else {
            return false;
        }
    }

    /**
     * Teleport the enderman to another entity
     */
    private boolean teleportToEntity(Entity p_70816_1_) {
        Vector3d vector3d = new Vector3d(this.getPosX() - p_70816_1_.getPosX(), this.getPosYHeight(0.5D) - p_70816_1_.getPosYEye(), this.getPosZ() - p_70816_1_.getPosZ());
        vector3d = vector3d.normalize();
        double d0 = 16.0D;
        double d1 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.x * 16.0D;
        double d2 = this.getPosY() + (double)(this.rand.nextInt(16) - 8) - vector3d.y * 16.0D;
        double d3 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.z * 16.0D;
        return this.teleportTo(d1, d2, d3);
    }

    /**
     * Teleport the enderman
     */
    private boolean teleportTo(double x, double y, double z) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z);

        while(blockpos$mutable.getY() > 0 && !this.world.getBlockState(blockpos$mutable).getMaterial().blocksMovement()) {
            blockpos$mutable.move(Direction.DOWN);
        }

        BlockState blockstate = this.world.getBlockState(blockpos$mutable);
        boolean flag = blockstate.getMaterial().blocksMovement();
        boolean flag1 = blockstate.getFluidState().isTagged(FluidTags.WATER);
        if (flag && !flag1) {
            net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
            if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
            boolean flag2 = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                this.world.playSound((PlayerEntity)null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
                this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return flag2;
        } else {
            return false;
        }
    }

    protected SoundEvent getAmbientSound() {
        return this.isScreaming() ? SoundEvents.ENTITY_ENDERMAN_SCREAM : SoundEvents.ENTITY_ENDERMAN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_ENDERMAN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMAN_DEATH;
    }

    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropSpecialItems(source, looting, recentlyHitIn);
        BlockState blockstate = this.getHeldBlockState();
        if (blockstate != null) {
            this.entityDropItem(blockstate.getBlock());
        }

    }

    public void setHeldBlockState(@Nullable BlockState state) {
        this.dataManager.set(CARRIED_BLOCK, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getHeldBlockState() {
        return this.dataManager.get(CARRIED_BLOCK).orElse((BlockState)null);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (source instanceof IndirectEntityDamageSource) {
            for(int i = 0; i < 64; ++i) {
                if (this.teleportRandomly()) {
                    return true;
                }
            }

            return false;
        } else {
            boolean flag = super.attackEntityFrom(source, amount);
            if (!this.world.isRemote() && this.rand.nextInt(10) != 0) {
                this.teleportRandomly();
            }

            return flag;
        }
    }

    public boolean isScreaming() {
        return this.dataManager.get(SCREAMING);
    }

    public boolean func_226537_et_() {
        return this.dataManager.get(field_226535_bx_);
    }

    public void func_226538_eu_() {
        this.dataManager.set(field_226535_bx_, true);
    }

    static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        private final EndormanMob enderman;
        /** The player */
        private PlayerEntity player;
        private int aggroTime;
        private int teleportTime;
        private final EntityPredicate field_220791_m;
        private final EntityPredicate field_220792_n = (new EntityPredicate()).setLineOfSiteRequired();

        public FindPlayerGoal(EndormanMob p_i45842_1_) {
            super(p_i45842_1_, PlayerEntity.class, false);
            this.enderman = p_i45842_1_;
            this.field_220791_m = (new EntityPredicate()).setDistance(this.getTargetDistance()).setCustomPredicate((p_220790_1_) -> {
                return p_i45842_1_.shouldAttackPlayer((PlayerEntity)p_220790_1_);
            });
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            this.player = this.enderman.world.getClosestPlayer(this.field_220791_m, this.enderman);
            return this.player != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.aggroTime = 5;
            this.teleportTime = 0;
            this.enderman.func_226538_eu_();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.player = null;
            super.resetTask();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            if (this.player != null) {
                if (!this.enderman.shouldAttackPlayer(this.player)) {
                    return false;
                } else {
                    this.enderman.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.nearestTarget != null && this.field_220792_n.canTarget(this.enderman, this.nearestTarget) ? true : super.shouldContinueExecuting();
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.player != null) {
                if (--this.aggroTime <= 0) {
                    this.nearestTarget = this.player;
                    this.player = null;
                    super.startExecuting();
                }
            } else {
                if (this.nearestTarget != null && !this.enderman.isPassenger()) {
                    if (this.enderman.shouldAttackPlayer((PlayerEntity)this.nearestTarget)) {
                        if (this.nearestTarget.getDistanceSq(this.enderman) < 16.0D) {
                            this.enderman.teleportRandomly();
                        }

                        this.teleportTime = 0;
                    } else if (this.nearestTarget.getDistanceSq(this.enderman) > 256.0D && this.teleportTime++ >= 30 && this.enderman.teleportToEntity(this.nearestTarget)) {
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

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            if (this.enderman.getHeldBlockState() == null) {
                return false;
            } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.enderman.world, this.enderman)) {
                return false;
            } else {
                return this.enderman.getRNG().nextInt(2000) == 0;
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            Random random = this.enderman.getRNG();
            IWorld iworld = this.enderman.world;
            int i = MathHelper.floor(this.enderman.getPosX() - 1.0D + random.nextDouble() * 2.0D);
            int j = MathHelper.floor(this.enderman.getPosY() + random.nextDouble() * 2.0D);
            int k = MathHelper.floor(this.enderman.getPosZ() - 1.0D + random.nextDouble() * 2.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            BlockState blockstate = iworld.getBlockState(blockpos);
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate1 = iworld.getBlockState(blockpos1);
            BlockState blockstate2 = this.enderman.getHeldBlockState();
            if (blockstate2 != null && this.func_220836_a(iworld, blockpos, blockstate2, blockstate, blockstate1, blockpos1)  && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(enderman, net.minecraftforge.common.util.BlockSnapshot.create(iworld, blockpos1), net.minecraft.util.Direction.UP)) {
                iworld.setBlockState(blockpos, blockstate2, 3);
                this.enderman.setHeldBlockState((BlockState)null);
            }

        }

        private boolean func_220836_a(IWorldReader p_220836_1_, BlockPos p_220836_2_, BlockState p_220836_3_, BlockState p_220836_4_, BlockState p_220836_5_, BlockPos p_220836_6_) {
            return p_220836_4_.isAir(p_220836_1_, p_220836_2_) && !p_220836_5_.isAir(p_220836_1_, p_220836_6_) && p_220836_5_.func_235785_r_(p_220836_1_, p_220836_6_) && p_220836_3_.isValidPosition(p_220836_1_, p_220836_2_);
        }
    }

    static class StareGoal extends Goal {
        private final EndormanMob field_220835_a;
        private LivingEntity field_226540_b_;

        public StareGoal(EndormanMob p_i50520_1_) {
            this.field_220835_a = p_i50520_1_;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            this.field_226540_b_ = this.field_220835_a.getAttackTarget();
            if (!(this.field_226540_b_ instanceof PlayerEntity)) {
                return false;
            } else {
                double d0 = this.field_226540_b_.getDistanceSq(this.field_220835_a);
                return d0 > 256.0D ? false : this.field_220835_a.shouldAttackPlayer((PlayerEntity)this.field_226540_b_);
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.field_220835_a.getNavigator().clearPath();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            this.field_220835_a.getLookController().setLookPosition(this.field_226540_b_.getPosX(), this.field_226540_b_.getPosYEye(), this.field_226540_b_.getPosZ());
        }
    }

    static class TakeBlockGoal extends Goal {
        private final EndormanMob enderman;

        public TakeBlockGoal(EndormanMob p_i45841_1_) {
            this.enderman = p_i45841_1_;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            if (this.enderman.getHeldBlockState() != null) {
                return false;
            } else if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.enderman.world, this.enderman)) {
                return false;
            } else {
                return this.enderman.getRNG().nextInt(20) == 0;
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            Random random = this.enderman.getRNG();
            World world = this.enderman.world;
            int i = MathHelper.floor(this.enderman.getPosX() - 2.0D + random.nextDouble() * 4.0D);
            int j = MathHelper.floor(this.enderman.getPosY() + random.nextDouble() * 3.0D);
            int k = MathHelper.floor(this.enderman.getPosZ() - 2.0D + random.nextDouble() * 4.0D);
            BlockPos blockpos = new BlockPos(i, j, k);
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = blockstate.getBlock();
            Vector3d vector3d = new Vector3d((double)MathHelper.floor(this.enderman.getPosX()) + 0.5D, (double)j + 0.5D, (double)MathHelper.floor(this.enderman.getPosZ()) + 0.5D);
            Vector3d vector3d1 = new Vector3d((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D);
            BlockRayTraceResult blockraytraceresult = world.rayTraceBlocks(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, this.enderman));
            boolean flag = blockraytraceresult.getPos().equals(blockpos);
            if (block.isIn(BlockTags.ENDERMAN_HOLDABLE) && flag) {
                this.enderman.setHeldBlockState(blockstate);
                world.removeBlock(blockpos, false);
            }

        }
    }
}

