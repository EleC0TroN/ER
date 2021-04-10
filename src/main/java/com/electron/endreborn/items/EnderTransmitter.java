package com.electron.endreborn.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.Random;

public class EnderTransmitter extends Item {
    public EnderTransmitter(Item.Properties builder) {
        super(builder);
    }
    public static final TranslationTextComponent field_220115_d = new TranslationTextComponent("container.ender_transmitter");

    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        EnderChestInventory enderchestinventory = playerIn.getEnderChestInventory();
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (enderchestinventory != null) {
            if (worldIn.isClientSide) {
                return ActionResult.success(itemstack);
            } else {
                playerIn.openMenu(new SimpleNamedContainerProvider((p_226928_1_, p_226928_2_, p_226928_3_) -> {
                    return ChestContainer.threeRows(p_226928_1_, p_226928_2_, enderchestinventory);
                }, field_220115_d));
                playerIn.awardStat(Stats.OPEN_ENDERCHEST);
                itemstack.hurt(1, new Random(), null);
                return ActionResult.success(itemstack);
            }
        } else {
            return ActionResult.success(itemstack);
        }
    }
}
