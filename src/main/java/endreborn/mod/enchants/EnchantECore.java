package endreborn.mod.enchants;

import java.util.Random;

import endreborn.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;

public class EnchantECore extends Enchantment {

	public EnchantECore() {
		super(Rarity.RARE, EnumEnchantmentType.ARMOR_CHEST, new EntityEquipmentSlot[] { EntityEquipmentSlot.CHEST });
		setRegistryName(Reference.MODID, "ender_core");
		setName("ender_core");
	}
	
	public void onUserHurt(EntityLivingBase user, Entity attacker, int level) {
		Random r = new Random();
		double x = user.posX + (r.nextDouble() - 0.5D) * 64.0D;
        double y = user.posY + (double)(r.nextInt(64) - 32);
        double z = user.posZ + (r.nextDouble() - 0.5D) * 64.0D;
        if (user instanceof EntityPlayer) {
        	EntityPlayer wearer = (EntityPlayer) user;
        	InventoryPlayer inventory = wearer.inventory;
        	if (inventory.hasItemStack(new ItemStack(Items.ENDER_PEARL))) {
        		inventory.clearMatchingItems(Items.ENDER_PEARL, 0, 1, null);
        		wearer.attemptTeleport(x, y, z);
        		wearer.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
        	}
        }		
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
}
