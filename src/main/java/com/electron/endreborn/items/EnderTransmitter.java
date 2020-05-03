package com.electron.endreborn.items;

import net.minecraft.client.renderer.texture.TextureUtil;
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

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        EnderChestInventory enderchestinventory = playerIn.getInventoryEnderChest();
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (enderchestinventory != null) {
            if (worldIn.isRemote) {
                return ActionResult.resultSuccess(itemstack);
            } else {

                playerIn.openContainer(new SimpleNamedContainerProvider((p_226928_1_, p_226928_2_, p_226928_3_) -> {
                    return ChestContainer.createGeneric9X3(p_226928_1_, p_226928_2_, enderchestinventory);
                }, field_220115_d));
                playerIn.addStat(Stats.OPEN_ENDERCHEST);
                itemstack.attemptDamageItem(1, new Random(), null);
                return ActionResult.resultSuccess(itemstack);
            }
        } else {
            return ActionResult.resultSuccess(itemstack);
        }
    }
}
