package com.electron.endreborn.mobs;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EndermanEyesLayer;
import net.minecraft.client.renderer.entity.layers.HeldBlockLayer;
import net.minecraft.client.renderer.entity.model.EndermanModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class EndormanRenderer extends MobRenderer<EndormanMob, EndermanModel<EndormanMob>> {
    private static final ResourceLocation ENDERMAN_TEXTURES = new ResourceLocation("textures/entity/enderman/enderman.png");
    private final Random rnd = new Random();

    public EndormanRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EndermanModel<>(0.0F), 0.5F);
        this.addLayer(new EndermanEyesLayer<>(this));
        this.addLayer(new HeldBlockNewLayer(this));
    }

    public void render(EndormanMob entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        BlockState blockstate = entityIn.getHeldBlockState();
        int i = entityIn.getEndorSize();
        float f = 1.0F + (0.1F * (float)i) - 0.1F;
        matrixStackIn.scale(f, f, f);
        EndermanModel<EndormanMob> endermanmodel = this.getEntityModel();
        endermanmodel.isCarrying = blockstate != null;
        endermanmodel.isAttacking = entityIn.isScreaming();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    public static class RenderFactory implements IRenderFactory<EndormanMob>
    {
        @Override
        public EntityRenderer<? super EndormanMob> createRenderFor(EntityRendererManager manager)
        {
            return new EndormanRenderer(manager);
        }
    }
    public Vec3d getRenderOffset(EndormanMob entityIn, float partialTicks) {
        if (entityIn.isScreaming()) {
            double d0 = 0.02D;
            return new Vec3d(this.rnd.nextGaussian() * 0.02D, 0.0D, this.rnd.nextGaussian() * 0.02D);
        } else {
            return super.getRenderOffset(entityIn, partialTicks);
        }
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(EndormanMob entity) {
        return ENDERMAN_TEXTURES;
    }


}
