package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.electron.endreborn.items.materials.Materials;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnderBootsItem extends ArmorItem {
    public EnderBootsItem(EquipmentSlot slot) {
        super(Materials.ENDER_BOOTS, slot, new Item.Settings().group(EndReborn.END_GROUP));
    }
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.ender_boots"));
    }

}
