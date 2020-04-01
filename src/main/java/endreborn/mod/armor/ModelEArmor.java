package endreborn.mod.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEArmor extends ModelBiped {
    public ModelRenderer H1;
    public ModelRenderer H2;
    public ModelRenderer H3;
    public ModelRenderer H4;
    public ModelRenderer H5;
    public ModelRenderer H6;
    public ModelRenderer H7;
    public ModelRenderer H8;
    public ModelRenderer H9;
    public ModelRenderer H10;
    public ModelRenderer H11;
    public ModelRenderer H12;

    public ModelEArmor() {
    	
    	this.textureWidth = 128;
        this.textureHeight = 128;
        this.H6 = new ModelRenderer(this, 67, 50);
        this.H6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H6.addBox(-1.5F, -5.0F, -4.6F, 3, 1, 1, 0.0F);
        this.H1 = new ModelRenderer(this, 65, 2);
        this.H1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H1.addBox(-4.5F, -8.8F, -5.0F, 9, 1, 10, 0.0F);
        this.H8 = new ModelRenderer(this, 67, 82);
        this.H8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H8.addBox(4.0F, -10.0F, -2.5F, 1, 4, 1, 0.0F);
        this.H10 = new ModelRenderer(this, 67, 82);
        this.H10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H10.addBox(4.0F, -10.0F, 1.5F, 1, 4, 1, 0.0F);
        this.H11 = new ModelRenderer(this, 67, 62);
        this.H11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H11.addBox(-6.5F, -0.4F, -4.4F, 5, 1, 1, 0.0F);
        this.setRotateAngle(H11, 0.0F, 0.0F, 0.3839724354387525F);
        this.H4 = new ModelRenderer(this, 67, 38);
        this.H4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H4.addBox(-4.5F, -7.8F, 3.8F, 9, 5, 1, 0.0F);
        this.H5 = new ModelRenderer(this, 67, 27);
        this.H5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H5.addBox(-4.5F, -8.0F, -4.6F, 9, 3, 1, 0.0F);
        this.H9 = new ModelRenderer(this, 67, 82);
        this.H9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H9.addBox(-5.0F, -10.0F, 1.5F, 1, 4, 1, 0.0F);
        this.H2 = new ModelRenderer(this, 67, 96);
        this.H2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H2.addBox(-5.5F, -7.8F, -4.5F, 1, 8, 9, 0.0F);
        this.setRotateAngle(H2, 0.0F, 0.0F, 0.08726646259971647F);
        this.H7 = new ModelRenderer(this, 67, 82);
        this.H7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H7.addBox(-5.0F, -10.0F, -2.5F, 1, 4, 1, 0.0F);
        this.H12 = new ModelRenderer(this, 67, 62);
        this.H12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H12.addBox(1.5F, -0.4F, -4.4F, 5, 1, 1, 0.0F);
        this.setRotateAngle(H12, 0.0F, 0.0F, -0.3839724354387525F);
        this.H3 = new ModelRenderer(this, 67, 96);
        this.H3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H3.addBox(4.5F, -7.8F, -4.5F, 1, 8, 9, 0.0F);
        this.setRotateAngle(H3, 0.0F, 0.0F, -0.08726646259971647F);
        
        this.bipedHead.addChild(H1);
        this.bipedHead.addChild(H2);
        this.bipedHead.addChild(H3);
        this.bipedHead.addChild(H4);
        this.bipedHead.addChild(H5);
        this.bipedHead.addChild(H6);
        this.bipedHead.addChild(H7);
        this.bipedHead.addChild(H8);
        this.bipedHead.addChild(H9);
        this.bipedHead.addChild(H10);
        this.bipedHead.addChild(H11);
        this.bipedHead.addChild(H12);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }
   

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
