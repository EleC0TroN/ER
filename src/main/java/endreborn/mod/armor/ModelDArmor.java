package endreborn.mod.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelDArmor extends ModelBiped {
    public ModelRenderer H1;
    public ModelRenderer H2;
    public ModelRenderer H3;
    public ModelRenderer H4;
    public ModelRenderer H5;
    public ModelRenderer H6;
    public ModelRenderer H11;
    public ModelRenderer H12;
    public ModelRenderer shape27;
    public ModelRenderer shape30;
    public ModelRenderer shape31;
    public ModelRenderer shape32;
    public ModelRenderer shape33;

    public ModelDArmor() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.H11 = new ModelRenderer(this, 67, 122);
        this.H11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H11.addBox(-6.5F, -0.4F, -4.4F, 5, 1, 1, 0.0F);
        this.setRotateAngle(H11, 0.0F, 0.0F, 0.3839724354387525F);
        this.shape32 = new ModelRenderer(this, 0, 0);
        this.shape32.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape32.addBox(1.5F, -13.0F, -1.0F, 1, 2, 3, 0.0F);
        this.shape27 = new ModelRenderer(this, 67, 83);
        this.shape27.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape27.addBox(-3.0F, -8.0F, -12.0F, 6, 3, 8, 0.2F);
        this.shape33 = new ModelRenderer(this, 0, 0);
        this.shape33.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape33.addBox(-2.5F, -13.0F, -1.0F, 1, 2, 3, 0.0F);
        this.H2 = new ModelRenderer(this, 67, 15);
        this.H2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H2.addBox(-5.0F, -7.8F, -4.5F, 1, 6, 9, 0.0F);
        this.H12 = new ModelRenderer(this, 67, 122);
        this.H12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H12.addBox(1.5F, -0.4F, -4.4F, 5, 1, 1, 0.0F);
        this.setRotateAngle(H12, 0.0F, 0.0F, -0.3839724354387525F);
        this.H3 = new ModelRenderer(this, 67, 15);
        this.H3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H3.addBox(4.0F, -7.8F, -4.5F, 1, 6, 9, 0.0F);
        this.shape31 = new ModelRenderer(this, 43, 0);
        this.shape31.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape31.addBox(-2.5F, -9.0F, -10.5F, 1, 1, 2, 0.2F);
        this.H5 = new ModelRenderer(this, 67, 73);
        this.H5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H5.addBox(-4.5F, -7.5F, -4.6F, 9, 3, 1, 0.0F);
        this.shape30 = new ModelRenderer(this, 43, 0);
        this.shape30.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape30.addBox(1.5F, -9.0F, -11.0F, 1, 1, 2, 0.2F);
        this.H6 = new ModelRenderer(this, 67, 50);
        this.H6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H6.addBox(-1.5F, -4.5F, -4.6F, 3, 1, 1, 0.0F);
        this.H4 = new ModelRenderer(this, 67, 38);
        this.H4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H4.addBox(-4.5F, -7.6F, 3.8F, 9, 5, 1, 0.0F);
        this.H1 = new ModelRenderer(this, 69, 99);
        this.H1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.H1.addBox(-4.0F, -11.0F, -4.0F, 8, 5, 8, 0.2F);

        this.bipedHead.addChild(H1);
        this.bipedHead.addChild(H2);
        this.bipedHead.addChild(H3);
        this.bipedHead.addChild(H4);
        this.bipedHead.addChild(H5);
        this.bipedHead.addChild(H6);
        this.bipedHead.addChild(shape32);
        this.bipedHead.addChild(shape27);
        this.bipedHead.addChild(shape33);
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
