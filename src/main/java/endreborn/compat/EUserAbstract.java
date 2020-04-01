package endreborn.compat;

import endreborn.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class EUserAbstract<T extends IRecipeWrapper> implements IRecipeCategory<T>
{
    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/entropy_user.png");

    protected static final int input1 = 0;
    protected static final int input2 = 1;
    protected static final int fuel = 2;
    protected static final int output = 3;

    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    protected final IDrawableAnimated animatedArrow;

    public EUserAbstract(IGuiHelper helper)
    {
        staticFlame = helper.createDrawable(TEXTURES, 176, 3, 40, 10);
        animatedFlame = helper.createAnimatedDrawable(staticFlame, 20, IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic staticArrow = helper.createDrawable(TEXTURES, 176, 13, 24, 17);
        animatedArrow = helper.createAnimatedDrawable(staticArrow, 20, IDrawableAnimated.StartDirection.LEFT, false);
    }
}