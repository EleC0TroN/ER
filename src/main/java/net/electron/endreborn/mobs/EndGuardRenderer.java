package net.electron.endreborn.mobs;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EndGuardRenderer extends MobEntityRenderer<EndGuardMob, EndGuardModel<EndGuardMob>> {
    private static final Identifier GUARD_NORMAL_TEXTURES = new Identifier("endreborn:textures/entity/end_guard_normal.png");
    private static final Identifier GUARD_AGR_TEXTURES = new Identifier("endreborn:textures/entity/end_guard_agressive.png");

    public EndGuardRenderer(EntityRenderDispatcher renderManagerIn) {
        super(renderManagerIn, new EndGuardModel<>(), 0.9F);
    }
    @Override
    public Identifier getTexture(EndGuardMob entity) {
        return entity.isAttacking() ? GUARD_AGR_TEXTURES : GUARD_NORMAL_TEXTURES;
    }
}