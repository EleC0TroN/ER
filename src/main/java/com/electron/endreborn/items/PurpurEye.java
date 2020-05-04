package com.electron.endreborn.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.EyeOfEnderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PurpurEye extends Item {
    public PurpurEye(Item.Properties builder) {
        super(builder);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.NONE);
        if (raytraceresult.getType() == RayTraceResult.Type.BLOCK && worldIn.getBlockState(((BlockRayTraceResult)raytraceresult).getPos()).getBlock() == Blocks.END_PORTAL_FRAME) {
            return new ActionResult<>(ActionResultType.FAIL, itemstack);
        } else {
            playerIn.setActiveHand(handIn);
            if (worldIn instanceof ServerWorld) {
                BlockPos blockpos = ((ServerWorld)worldIn).getChunkProvider().getChunkGenerator().findNearestStructure(worldIn, "EndCity", new BlockPos(playerIn), 50, false);
                if (blockpos != null) {
                    EyeOfEnderEntity eyeofenderentity = new EyeOfEnderEntity(worldIn, playerIn.posX, playerIn.posY + (double)(playerIn.getHeight() / 2.0F), playerIn.posZ);
                    eyeofenderentity.func_213863_b(itemstack);
                    eyeofenderentity.moveTowards(blockpos);
                    worldIn.addEntity(eyeofenderentity);
                    if (playerIn instanceof ServerPlayerEntity) {
                        CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayerEntity)playerIn, blockpos);
                    }

                    worldIn.playSound((PlayerEntity)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.4F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    worldIn.playEvent((PlayerEntity)null, 1003, new BlockPos(playerIn), 0);
                    if (!playerIn.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }

                    playerIn.addStat(Stats.ITEM_USED.get(this));

                    return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
                }
            }

            return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
        }
    }
}