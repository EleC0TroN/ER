package com.electron.endreborn.mobs;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
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

        this.bipedLeftLeg = (new ModelRenderer(this, 52, 100)).setTexSize(128, 128);;
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.setPos(5.0F, 6.0F, 0.0F);
        this.bipedLeftLeg.addBox(-4.0F, -1.0F, -4.0F, 8.0F, 19.0F, 8.0F, 0.0F);

        this.bipedRightLeg = (new ModelRenderer(this, 52, 100)).setTexSize(128, 128);;
        this.bipedRightLeg.setPos(-5.0F, 6.0F, 0.0F);
        this.bipedRightLeg.addBox(-4.0F, -1.0F, -4.0F, 8.0F, 19.0F, 8.0F, 0.0F);

        this.bipedBody = (new ModelRenderer(this, 68, 16)).setTexSize(128, 128);;
        this.bipedBody.setPos(0.0F, 14.75F, 0.0F);
        this.bipedBody.addBox(-8.0F, -14.75F, -5.0F, 16.0F, 7.0F, 10.0F, 0.0F);

        this.chest = (new ModelRenderer(this)).setTexSize(128, 128);;
        this.chest.setPos(0.0F, -14.75F, 0.0F);
        this.bipedBody.addChild(chest);
        this.setRotationAngle(chest, 0.0436F, 0.0F, 0.0F);
        this.chest.texOffs(0, 0).addBox(-11.0F, -19.0F, -5.5F, 22.0F, 20.0F, 12.0F, 0.0F);

        this.bipedHead = (new ModelRenderer(this)).setTexSize(128, 128);
        this.bipedHead.setPos(0.0F, -19.0F, -4.0F);
        this.setRotationAngle(bipedHead, 0.0436F, 0.0F, 0.0F);
        this.bipedHead.texOffs(0, 50).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F);
        this.bipedHead.texOffs(0, 70).addBox(-5.5F, -3.0F, -6.0F, 11.0F, 3.0F, 9.0F, 0.0F);

        this.bipedLeftArm = (new ModelRenderer(this)).setTexSize(128, 128);;
        this.bipedLeftArm.setPos(11.0F, -13.0F, 0.0F);
        this.bipedLeftArm.texOffs(85, 50).addBox(0.0F, -8.0F, -4.0F, 8.0F, 42.0F, 8.0F, 0.0F);
        this.bipedLeftArm.texOffs(0, 79).addBox(4.0F, -9.0F, 3.0F, 0.0F, 6.0F, 3.0F, 0.0F);

        this.bipedRightArm = (new ModelRenderer(this)).setTexSize(128, 128);;
        this.bipedRightArm.setPos(-11.0F, -13.0F, 0.0F);
        this.bipedRightArm.texOffs(52, 50).addBox(-8.0F, -8.0F, -4.0F, 8.0F, 42.0F, 8.0F, 0.0F);
        this.bipedRightArm.texOffs(0, 79).addBox(-4.0F, -9.0F, 3.0F, 0.0F, 6.0F, 3.0F, 0.0F);

    }

    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.bipedHead, this.bipedBody, this.bipedLeftLeg, this.bipedRightLeg, this.bipedRightArm, this.bipedLeftArm, this.chest);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedLeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bipedHead.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.bipedHead.xRot = headPitch * ((float)Math.PI / 180F);
        this.bipedLeftLeg.xRot = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedRightLeg.xRot = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedLeftLeg.yRot = 0.0F;
        this.bipedRightLeg.yRot = 0.0F;
        this.bipedLeftArm.xRot = 1.1F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedRightArm.xRot = -1.1F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedBody.yRot = -0.25F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        this.bipedLeftArm.yRot = 0.0F;
        this.bipedRightArm.yRot = 0.0F;
        float f = MathHelper.sin(this.attackTime * -(float)Math.PI);
        float f1 = -MathHelper.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float)Math.PI);
        this.bipedRightArm.xRot += f - f1 * 0.3F;
        this.bipedRightArm.yRot += f * 0.9F - f1 * 0.3F;
    }

    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
