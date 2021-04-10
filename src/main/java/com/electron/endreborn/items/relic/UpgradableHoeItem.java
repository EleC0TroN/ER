package com.electron.endreborn.items.relic;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class UpgradableHoeItem extends HoeItem {

    private final int sharpness;
    private final int flexibility;

    public UpgradableHoeItem(IItemTier itemTier, int attackDamage, float attackSpeed, int sharpness, int flexibility, Properties properties) {
        super(itemTier, attackDamage, attackSpeed, properties);

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
        return new TranslationTextComponent("item.endreborn.endorium_hoe");
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.REPLACEABLE_PLANT && material != Material.LEAVES ? 1.0F : 1.0F + this.sharpness;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("tooltip.relic").withStyle(TextFormatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(new TranslationTextComponent("tooltip.hoe_sharpness").withStyle(TextFormatting.DARK_GRAY));
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
