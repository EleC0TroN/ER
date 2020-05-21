package com.electron.endreborn.mobs;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.feature.structure.EndCityPieces;
import net.minecraft.world.gen.feature.structure.FortressPieces;
import net.minecraft.world.gen.feature.structure.MineshaftPieces;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EndGuardModel <T extends EndGuardMob> extends SegmentedModel<T> {
    private final ModelRenderer bipedLeftLeg;
    private final ModelRenderer bipedRightLeg;
    private final ModelRenderer bipedBody;
    private final ModelRenderer chest;
    private final ModelRenderer bipedHead;
    private final ModelRenderer bipedRightArm;
    private final ModelRenderer bipedLeftArm;

    public EndGuardModel() {
        int i = 128;
        int j = 128;
        this.bipedLeftLeg = (new ModelRenderer(this, 68, 50)).setTextureSize(128, 128);;
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.setRotationPoint(5.0F, 6.0F, 0.0F);
        this.bipedLeftLeg.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 18.0F, 8.0F, 0.0F);

        this.bipedRightLeg = (new ModelRenderer(this, 68, 49)).setTextureSize(128, 128);;
        this.bipedRightLeg.setRotationPoint(-5.0F, 6.0F, 0.0F);
        this.bipedRightLeg.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 18.0F, 8.0F, 0.0F);

        this.bipedBody = (new ModelRenderer(this, 0, 33)).setTextureSize(128, 128);;
        this.bipedBody.setRotationPoint(-1.0F, -7.0F, -3.0F);
        this.bipedBody.addBox(-9.0F, 7.0F, -2.0F, 20.0F, 6.0F, 10.0F, 0.0F);

        this.chest = (new ModelRenderer(this)).setTextureSize(128, 128);;
        this.chest.setRotationPoint(1.0F, 9.0F, 3.0F);
        this.bipedBody.addChild(chest);
        this.setRotationAngle(chest, 0.1745F, 0.0F, 0.0F);
        this.chest.setTextureOffset(0, 0).addBox(-11.0F, -21.6548F, -6.0547F, 22.0F, 21.0F, 12.0F, 0.0F);

        this.bipedHead = (new ModelRenderer(this)).setTextureSize(128, 128);
        this.bipedHead.setRotationPoint(0.0F, -17.0F, -7.0F);
        this.bipedHead.setTextureOffset(0, 49).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 9.0F, 10.0F, 0.0F);
        this.bipedHead.setTextureOffset(0, 68).addBox(-5.5F, -2.0F, -6.0F, 11.0F, 2.0F, 9.0F, 0.0F);

        this.bipedLeftArm = (new ModelRenderer(this)).setTextureSize(128, 128);;
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.setRotationPoint(11.0F, -14.0F, -4.0F);
        this.bipedLeftArm.setTextureOffset(68, 0).addBox(0.0F, -4.0F, -4.0F, 8.0F, 42.0F, 8.0F, 0.0F);
        this.bipedLeftArm.setTextureOffset(0, 79).addBox(0.0F, -9.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F);
        this.bipedLeftArm.setTextureOffset(0, 71).addBox(4.0F, -9.0F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F);

        this.bipedRightArm = (new ModelRenderer(this)).setTextureSize(128, 128);;
        this.bipedRightArm.setRotationPoint(-11.0F, -14.0F, -4.0F);
        this.bipedRightArm.setTextureOffset(68, 0).addBox(-8.0F, -4.0F, -4.0F, 8.0F, 42.0F, 8.0F, 0.0F);
        this.bipedRightArm.setTextureOffset(0, 79).addBox(-8.0F, -9.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F);
        this.bipedRightArm.setTextureOffset(0, 71).addBox(-4.0F, -9.0F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F);
    } 


    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.bipedHead, this.bipedBody, this.bipedLeftLeg, this.bipedRightLeg, this.bipedRightArm, this.bipedLeftArm, this.chest);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedLeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.bipedHead.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.bipedHead.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.bipedLeftLeg.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedRightLeg.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedLeftLeg.rotateAngleY = 0.0F;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftArm.rotateAngleX = 1.2F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedRightArm.rotateAngleX = -1.2F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedBody.rotateAngleY = -0.25F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedLeftArm.rotateAngleY = 0.0F;
        this.bipedRightArm.rotateAngleY = 0.0F;

        float f = MathHelper.sin(this.swingProgress * -(float)Math.PI);
        float f1 = -MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.bipedRightArm.rotateAngleY += f * 1.1F - f1 * 0.4F;
    }

    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
