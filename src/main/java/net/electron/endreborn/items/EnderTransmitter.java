package net.electron.endreborn.items;

import net.electron.endreborn.EndReborn;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class EnderTransmitter extends Item {
    public EnderTransmitter()  {
        super(new Item.Settings().group(EndReborn.END_GROUP).maxCount(1).maxDamage(16));
    }
    public static final TranslatableText field_220115_d = new TranslatableText("container.ender_transmitter");

    public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        EnderChestInventory enderChestInventory = playerIn.getEnderChestInventory();
        ItemStack itemstack = playerIn.getStackInHand(handIn);
        if (enderChestInventory != null) {
            if (worldIn.isClient) {
                return TypedActionResult.success(itemstack);
            } else {

                playerIn.openHandledScreen(new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
                    return GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, enderChestInventory);
                }, field_220115_d));
                playerIn.incrementStat(Stats.OPEN_ENDERCHEST);
                itemstack.damage(1, new Random(), null);
                return TypedActionResult.success(itemstack);
            }
        } else {
            return TypedActionResult.success(itemstack);
        }
    }
}
