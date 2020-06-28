package com.electron.endreborn.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MushroomBlock extends Block{

    public MushroomBlock() {
        super(Block.Properties.create(Material.PLANTS, MaterialColor.STONE).hardnessAndResistance(1.0f, 1.5f).sound(SoundType.STONE));
    }
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (entityIn.isSuppressingBounce()) {
            super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
        } else {
            entityIn.onLivingFall(fallDistance, 0.0F);
        }

    }
    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.onLanded(worldIn, entityIn);
        } else {
            this.func_226946_a_(entityIn);
        }

    }

    private void func_226946_a_(Entity p_226946_1_) {
        Vector3d vec3d = p_226946_1_.getMotion();
        if (vec3d.y < 0.0D) {
            double d0 = p_226946_1_ instanceof LivingEntity ? 0.8D : 0.6D;
            p_226946_1_.setMotion(vec3d.x, -vec3d.y * d0, vec3d.z);
        }

    }
}
