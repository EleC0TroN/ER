package com.electron.endreborn.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.EyeOfEnderEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

public class PurpurEye extends Item {
    public PurpurEye(Item.Properties builder) {
        super(builder);
    }

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(p_77659_1_, p_77659_2_, RayTraceContext.FluidMode.NONE);
        if (raytraceresult.getType() == RayTraceResult.Type.BLOCK && p_77659_1_.getBlockState(((BlockRayTraceResult)raytraceresult).getBlockPos()).is(Blocks.END_PORTAL_FRAME)) {
            return ActionResult.pass(itemstack);
        } else {
            p_77659_2_.startUsingItem(p_77659_3_);
            if (p_77659_1_ instanceof ServerWorld) {
                BlockPos blockpos = ((ServerWorld)p_77659_1_).getChunkSource().getGenerator().findNearestMapFeature((ServerWorld)p_77659_1_, Structure.END_CITY, p_77659_2_.blockPosition(), 100, false);
                if (blockpos != null) {
                    EyeOfEnderEntity eyeofenderentity = new EyeOfEnderEntity(p_77659_1_, p_77659_2_.getX(), p_77659_2_.getY(0.5D), p_77659_2_.getZ());
                    eyeofenderentity.setItem(itemstack);
                    eyeofenderentity.signalTo(blockpos);
                    p_77659_1_.addFreshEntity(eyeofenderentity);
                    if (p_77659_2_ instanceof ServerPlayerEntity) {
                        CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayerEntity)p_77659_2_, blockpos);
                    }

                    p_77659_1_.playSound((PlayerEntity)null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), SoundEvents.CHORUS_FLOWER_GROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    p_77659_1_.levelEvent((PlayerEntity)null, 1003, p_77659_2_.blockPosition(), 0);
                    if (!p_77659_2_.abilities.instabuild) {
                        itemstack.shrink(1);
                    }

                    p_77659_2_.awardStat(Stats.ITEM_USED.get(this));
                    p_77659_2_.swing(p_77659_3_, true);
                    return ActionResult.success(itemstack);
                }
            }

            return ActionResult.consume(itemstack);
        }
    }
}