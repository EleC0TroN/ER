package com.electron.endreborn.items.relic;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class UpgradableAxeItem extends AxeItem {

    private final int sharpness;
    private final int flexibility;

    public UpgradableAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, int sharpness, int flexibility, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);

        this.sharpness = sharpness;
        this.flexibility = flexibility;
    }

    public float getSharpness() {
        return this.sharpness;
    }
    public float getFlexibility() {
        return this.flexibility;
    }

    public ITextComponent getName(ItemStack p_200295_1_) {
        return new TranslationTextComponent("item.endreborn.endorium_axe");
    }

    @Override
    public ActionResultType useOn(ItemUseContext p_195939_1_) {
        World world = p_195939_1_.getLevel();
        BlockPos blockpos = p_195939_1_.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState block = blockstate.getToolModifiedState(world, blockpos, p_195939_1_.getPlayer(), p_195939_1_.getItemInHand(), net.minecraftforge.common.ToolType.AXE);
        if (block != null) {
            PlayerEntity playerentity = p_195939_1_.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isClientSide) {
                world.setBlock(blockpos, block, 11);
                if (playerentity != null) {
                    p_195939_1_.getItemInHand().hurtAndBreak(1 - this.sharpness, playerentity, (p_220040_1_) -> {
                        p_220040_1_.broadcastBreakEvent(p_195939_1_.getHand());
                    });
                }
            }

            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            return ActionResultType.PASS;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("tooltip.relic").withStyle(TextFormatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(new TranslationTextComponent("tooltip.axe_sharpness").withStyle(TextFormatting.DARK_GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(new TranslationTextComponent("tooltip.uni_flexibility").withStyle(TextFormatting.DARK_GRAY));
            tooltip.add(new TranslationTextComponent("tooltip.uni_flexibility_n").withStyle(TextFormatting.DARK_GRAY));
        }
    }

    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity p_77644_2_, LivingEntity p_77644_3_) {
        p_77644_1_.hurtAndBreak(2 + this.flexibility, p_77644_3_, (p_220039_0_) -> {
            p_220039_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
        });
        return true;
    }
}
