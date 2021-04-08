package com.electron.endreborn.items.relic;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class UpgradablePickaxeItem extends PickaxeItem {

    private final int sharpness;
    private final int flexibility;

    public UpgradablePickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, int sharpness, int flexibility, Properties builder) {
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

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip.relic").mergeStyle(TextFormatting.GRAY));
        if (this.sharpness > 0) {
            tooltip.add(new TranslationTextComponent("tooltip.pickaxe_sharpness").mergeStyle(TextFormatting.DARK_GRAY));
        } else if (this.flexibility > 0){
            tooltip.add(new TranslationTextComponent("tooltip.uni_flexibility").mergeStyle(TextFormatting.DARK_GRAY));
            tooltip.add(new TranslationTextComponent("tooltip.uni_flexibility_n").mergeStyle(TextFormatting.DARK_GRAY));
        }
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(2 + this.flexibility, attacker, (p_220045_0_) -> {
            p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        Material material = blockIn.getMaterial();
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE) {
            return i >= blockIn.getHarvestLevel();
        } else if (sharpness > 0) {
            if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE || blockIn.getHarvestTool() == ToolType.SHOVEL) {
                return i >= blockIn.getHarvestLevel();
            }
        }
        return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
    }
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        if (sharpness > 0) {
            return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK && material != Material.SAND ? super.getDestroySpeed(stack, state) : this.efficiency;
        }
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;
    }
}
