package endreborn.mod.armor;

import endreborn.EndReborn;
import endreborn.init.ItemInit;
import endreborn.utils.IHasModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmourDModel extends ItemArmor implements IHasModel
{

	public ArmourDModel(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(EndReborn.endertab);
		
		ItemInit.ITEMS.add(this);
	}
	@Override
	public void registerModels() 
	{
		EndReborn.proxy.registerItemRenderer(this, 0, "inventory");
	}
	

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		if(stack != ItemStack.EMPTY)
		{
			if(stack.getItem() instanceof ItemArmor)
			{
				ModelDArmor model = new ModelDArmor();
				model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				model.isChild = _default.isChild;
				model.isSneak = _default.isSneak;
				model.isRiding = _default.isRiding;
				model.isChild = _default.isChild;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;
				
				return model;
			}
		}
		return null;
	}
	
}
