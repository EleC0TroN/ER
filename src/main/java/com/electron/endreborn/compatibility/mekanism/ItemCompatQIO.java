package com.electron.endreborn.compatibility.mekanism;

import mekanism.api.text.EnumColor;
import mekanism.api.text.TextComponentUtil;
import mekanism.common.MekanismLang;
import mekanism.common.content.qio.IQIODriveItem;
import mekanism.common.registries.MekanismItems;
import mekanism.common.tier.QIODriveTier;
import mekanism.common.util.text.TextUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemCompatQIO extends Item implements IQIODriveItem {
    private final QIOCompatTier tier;

    public ItemCompatQIO(QIOCompatTier tier, Properties properties) {
        super(properties.maxStackSize(1));
        this.tier = tier;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(@Nonnull ItemStack stack, World world, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flag) {
        DriveMetadata meta = DriveMetadata.load(stack);
        tooltip.add(MekanismLang.QIO_ITEMS_DETAIL.translateColored(EnumColor.GRAY, new Object[]{EnumColor.INDIGO, TextUtils.format(meta.getCount()), TextUtils.format(this.getCountCapacity(stack))}));
        tooltip.add(MekanismLang.QIO_TYPES_DETAIL.translateColored(EnumColor.GRAY, new Object[]{EnumColor.INDIGO, TextUtils.format(meta.getTypes()), TextUtils.format(this.getTypeCapacity(stack))}));
    }

    @Nonnull
    public ITextComponent getDisplayName(@Nonnull ItemStack stack) {
        return TextComponentUtil.build(new Object[]{this.tier.getBaseTier().getTextColor(), super.getDisplayName(stack)});
    }

    public long getCountCapacity(ItemStack stack) {
        return this.tier.getMaxCount();
    }

    public int getTypeCapacity(ItemStack stack) {
        return this.tier.getMaxTypes();
    }
}

