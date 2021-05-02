package com.electron.endreborn.mobs;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class EndGuardRenderer extends MobRenderer<EndGuardMob, EndGuardModel<EndGuardMob>> {
    private static final ResourceLocation GUARD_NORMAL_TEXTURES = new ResourceLocation("endreborn:textures/entity/end_guard_normal.png");
    private static final ResourceLocation GUARD_AGR_TEXTURES = new ResourceLocation("endreborn:textures/entity/end_guard_agressive.png");

    public EndGuardRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EndGuardModel<>(), 0.9F);

    }

    public static class RenderFactory implements IRenderFactory<EndGuardMob> {
        @Override
        public EntityRenderer<? super EndGuardMob> createRenderFor(EntityRendererManager manager) {
            return new EndGuardRenderer(manager);
        }
    }
    public ResourceLocation getTextureLocation(EndGuardMob entity) {
        return entity.isAttacking() ? GUARD_AGR_TEXTURES : GUARD_NORMAL_TEXTURES;
    }
    protected void setupRotations(EndGuardMob p_225621_1_, MatrixStack p_225621_2_, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        super.setupRotations(p_225621_1_, p_225621_2_, p_225621_3_, p_225621_4_, p_225621_5_);

            float f1 = p_225621_1_.animationPosition - p_225621_1_.animationSpeed * (1.0F - p_225621_5_) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            p_225621_2_.mulPose(Vector3f.ZP.rotationDegrees(1.5F * f2));

    }
}