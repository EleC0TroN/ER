package net.electron.endreborn.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;

import java.util.Objects;

public class LimusEggBase extends Item {
    private final EntityType<?> type;

    public LimusEggBase(EntityType<?> type, Item.Settings settings) {
        super(settings);
        this.type = type;

    }
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemStack = context.getStack();
            BlockPos blockPos = context.getBlockPos().up(3);
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);

            BlockPos blockPos3;
            if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                blockPos3 = blockPos;
            } else {
                blockPos3 = blockPos.offset(direction);
            }
            EntityType<?> entityType2 = this.getEntityType(itemStack.getTag());
            if (entityType2.spawnFromItemStack(world, itemStack, context.getPlayer(), blockPos3, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockPos.up(3), blockPos3.up(3)) && direction == Direction.UP) != null) {
                itemStack.decrement(1);
                context.getPlayer().inventory.insertStack(new ItemStack(Items.GLASS_BOTTLE));
            }

            return ActionResult.SUCCESS;
        }
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        HitResult hitResult = rayTrace(world, user, RayTraceContext.FluidHandling.SOURCE_ONLY);
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return TypedActionResult.pass(itemStack);
        } else if (world.isClient) {
            return TypedActionResult.success(itemStack);
        } else {
            BlockHitResult blockHitResult = (BlockHitResult)hitResult;
            BlockPos blockPos = blockHitResult.getBlockPos();
            if (!(world.getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
                return TypedActionResult.pass(itemStack);
            } else if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos, blockHitResult.getSide(), itemStack)) {
                EntityType<?> entityType = this.getEntityType(itemStack.getTag());
                if (entityType.spawnFromItemStack(world, itemStack, user, blockPos.up(2), SpawnReason.SPAWN_EGG, false, false) == null) {
                    return TypedActionResult.pass(itemStack);
                } else {
                    if (!user.abilities.creativeMode) {
                        user.inventory.insertStack(new ItemStack(Items.GLASS_BOTTLE));
                        itemStack.decrement(1);
                    }

                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(itemStack);
                }
            } else {
                return TypedActionResult.fail(itemStack);
            }
        }
    }

    public EntityType<?> getEntityType(CompoundTag tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            CompoundTag compoundTag = tag.getCompound("EntityTag");
            if (compoundTag.contains("id", 8)) {
                return (EntityType)EntityType.get(compoundTag.getString("id")).orElse(this.type);
            }
        }

        return this.type;
    }

}
