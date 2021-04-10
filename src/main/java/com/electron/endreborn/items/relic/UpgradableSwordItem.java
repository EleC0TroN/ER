package com.electron.endreborn.items.relic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class UpgradableSwordItem extends SwordItem {

    private final int sharpness;
    private final int flexibility;

    public UpgradableSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, int sharpness, int flexibility, Properties builder) {
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
        return new TranslationTextComponent("item.endreborn.endorium_sword");
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("tooltip.relic").withStyle(TextFormatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(new TranslationTextComponent("tooltip.sword_sharpness").withStyle(TextFormatting.DARK_GRAY));
        } else if (this.flexibility > 0) {
            tooltip.add(new TranslationTextComponent("tooltip.sword_flexibility").withStyle(TextFormatting.DARK_GRAY));
            tooltip.add(new TranslationTextComponent("tooltip.uni_flexibility_n").withStyle(TextFormatting.DARK_GRAY));
        }
    }
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15 + this.sharpness*5;
        } else {
            Material material = state.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && material != Material.CORAL && !state.is(BlockTags.LEAVES) && material != Material.DIRT ? 1.0F : 1.5F + this.sharpness;
        }
    }

    public boolean hurtEnemy(ItemStack p_77644_1_, LivingEntity p_77644_2_, LivingEntity p_77644_3_) {
        p_77644_1_.hurtAndBreak(1 + this.flexibility, p_77644_3_, (p_220039_0_) -> {
            p_220039_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public boolean mineBlock(ItemStack p_179218_1_, World p_179218_2_, BlockState p_179218_3_, BlockPos p_179218_4_, LivingEntity p_179218_5_) {
        if (p_179218_3_.getDestroySpeed(p_179218_2_, p_179218_4_) != 0.0F) {
            p_179218_1_.hurtAndBreak(2 - this.flexibility, p_179218_5_, (p_220044_0_) -> {
                p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }
    public boolean isCorrectToolForDrops(BlockState blockIn) {
        return blockIn.is(Blocks.COBWEB);
    }

}
