package net.electron.endreborn.mobs;

import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class EndGuardModel<T extends EndGuardMob> extends CompositeEntityModel<T> {
    private final ModelPart bipedLeftLeg;
    private final ModelPart bipedRightLeg;
    private final ModelPart bipedBody;
    private final ModelPart chest;
    private final ModelPart bipedHead;
    private final ModelPart bipedRightArm;
    private final ModelPart bipedLeftArm;

    public EndGuardModel() {
        this.bipedLeftLeg = (new ModelPart(this, 68, 50)).setTextureSize(128, 128);;
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.setPivot(5.0F, 6.0F, 0.0F);
        this.bipedLeftLeg.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 18.0F, 8.0F, 0.0F);

        this.bipedRightLeg = (new ModelPart(this, 68, 50)).setTextureSize(128, 128);;
        this.bipedRightLeg.setPivot(-5.0F, 6.0F, 0.0F);
        this.bipedRightLeg.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 18.0F, 8.0F, 0.0F);

        this.bipedBody = (new ModelPart(this, 0, 33)).setTextureSize(128, 128);;
        this.bipedBody.setPivot(-1.0F, -7.0F, -3.0F);
        this.bipedBody.addCuboid(-9.0F, 7.0F, -2.0F, 20.0F, 6.0F, 10.0F, 0.0F);

        this.chest = (new ModelPart(this)).setTextureSize(128, 128);;
        this.chest.setPivot(1.0F, 9.0F, 3.0F);
        this.bipedBody.addChild(chest);
        this.chest.pitch = 0.1745F;
        this.chest.setTextureOffset(0, 0).addCuboid(-11.0F, -21.6548F, -6.0547F, 22.0F, 21.0F, 12.0F, 0.0F);

        this.bipedHead = (new ModelPart(this)).setTextureSize(128, 128);
        this.bipedHead.setPivot(0.0F, -17.0F, -7.0F);
        this.bipedHead.setTextureOffset(0, 49).addCuboid(-5.0F, -10.0F, -5.0F, 10.0F, 9.0F, 10.0F, 0.0F);
        this.bipedHead.setTextureOffset(0, 68).addCuboid(-5.5F, -2.0F, -6.0F, 11.0F, 2.0F, 9.0F, 0.0F);

        this.bipedLeftArm = (new ModelPart(this)).setTextureSize(128, 128);;
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.setPivot(11.0F, -14.0F, -4.0F);
        this.bipedLeftArm.setTextureOffset(68, 0).addCuboid(0.0F, -4.0F, -4.0F, 8.0F, 42.0F, 8.0F, 0.0F);
        this.bipedLeftArm.setTextureOffset(0, 79).addCuboid(0.0F, -9.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F);
        this.bipedLeftArm.setTextureOffset(0, 71).addCuboid(4.0F, -9.0F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F);

        this.bipedRightArm = (new ModelPart(this)).setTextureSize(128, 128);;
        this.bipedRightArm.setPivot(-11.0F, -14.0F, -4.0F);
        this.bipedRightArm.setTextureOffset(68, 0).addCuboid(-8.0F, -4.0F, -4.0F, 8.0F, 42.0F, 8.0F, 0.0F);
        this.bipedRightArm.setTextureOffset(0, 79).addCuboid(-8.0F, -9.0F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F);
        this.bipedRightArm.setTextureOffset(0, 71).addCuboid(-4.0F, -9.0F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F);

    }

    public void setAngles(EndGuardMob entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

        this.bipedHead.yaw = headYaw * ((float)Math.PI / 180F);
        this.bipedHead.pitch = headPitch * ((float)Math.PI / 180F);
        this.bipedLeftLeg.pitch = -1.5F * this.triangleWave(limbAngle, 13.0F) * limbDistance;
        this.bipedRightLeg.pitch = 1.5F * this.triangleWave(limbAngle, 13.0F) * limbDistance;
        this.bipedLeftLeg.yaw = 0.0F;
        this.bipedRightLeg.yaw = 0.0F;
        this.bipedLeftArm.pitch = 1.2F * this.triangleWave(limbAngle, 13.0F) * limbDistance;
        this.bipedRightArm.pitch = -1.2F * this.triangleWave(limbAngle, 13.0F) * limbDistance;
        this.bipedBody.yaw = -0.25F * this.triangleWave(limbAngle, 13.0F) * limbDistance;
        this.bipedLeftArm.yaw = 0.0F;
        this.bipedRightArm.yaw = 0.0F;

        float f = MathHelper.sin(this.handSwingProgress * -(float)Math.PI);
        float f1 = -MathHelper.sin((1.0F - (1.0F - this.handSwingProgress) * (1.0F - this.handSwingProgress)) * (float)Math.PI);
        this.bipedRightArm.pitch += f * 1.2F - f1 * 0.4F;
        this.bipedRightArm.yaw += f * 0.9F - f1 * 0.4F;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedBody.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedRightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        bipedLeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public Iterable<ModelPart> getParts() {
        return ImmutableList.of(this.bipedHead, this.bipedBody, this.bipedLeftLeg, this.bipedRightLeg, this.bipedRightArm, this.bipedLeftArm, this.chest);
    }

    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
