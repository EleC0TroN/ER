package com.electron.endreborn.items;

import com.electron.endreborn.ModItems;
import com.electron.endreborn.ModMobs;
import com.electron.endreborn.mobs.LimusMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class LimusEgg extends Item {
    public LimusEgg(Item.Properties builder) {
        super(builder);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            LimusMob mob = ModMobs.LIMUS.get().create(playerIn.world);
            mob.setLocationAndAngles(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), playerIn.rotationYaw, 0.0F);
            playerIn.world.addEntity(mob);
        }
        playerIn.addStat(Stats.ITEM_USED.get(this));
        if (!playerIn.abilities.isCreativeMode) {

            if (itemstack.isEmpty()) {
                playerIn.setHeldItem(handIn, new ItemStack(Items.GLASS_BOTTLE));
            } else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
                playerIn.dropItem(new ItemStack(Items.GLASS_BOTTLE), false);
            }
            itemstack.shrink(1);
        }

        return ActionResult.resultSuccess(itemstack);
    }
}