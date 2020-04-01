package endreborn.mod.enchants;

import endreborn.Reference;
import endreborn.mod.entity.EntityChronologist;
import endreborn.mod.entity.EntityWatcher;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.PotionEffect;

public class EnchantEnder extends Enchantment {

    public EnchantEnder() {
        super(Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND });
        setRegistryName(Reference.MODID, "ender_killer");
        setName("ender_killer");
    }


    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if ((target instanceof EntityEnderman) || (target instanceof EntityWatcher) || (target instanceof EntityChronologist) || (target instanceof EntityEndermite)) {
            ((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 5, level));
        }
    }
    @Override
    public int getMaxLevel() {
        return 2;
    }
}

