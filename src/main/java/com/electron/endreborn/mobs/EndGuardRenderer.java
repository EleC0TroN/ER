package com.electron.endreborn.mobs;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
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
    public ResourceLocation getEntityTexture(EndGuardMob entity) {
        return entity.isAttacking() ? GUARD_AGR_TEXTURES : GUARD_NORMAL_TEXTURES;
    }

    protected void applyRotations(EndGuardMob entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

    }
}