package endreborn.compat;

import endreborn.mod.blocks.ContainerEntropyUser;
import endreborn.mod.gui.GuiEUser;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.util.text.translation.I18n;

import java.util.IllegalFormatException;

@JEIPlugin
public class JEICompat implements IModPlugin
{
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {
        final IJeiHelpers helpers = registry.getJeiHelpers();
        final IGuiHelper gui = helpers.getGuiHelper();

        registry.addRecipeCategories(new EUserCategory(gui));
    }

    @Override
    public void register(IModRegistry registry)
    {
        final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();

        registry.addRecipes(EUserMaker.getRecipes(jeiHelpers), JEICategories.USER);
        registry.addRecipeClickArea(GuiEUser.class, 109, 43, 24, 17, JEICategories.USER);
        recipeTransfer.addRecipeTransferHandler(ContainerEntropyUser.class, JEICategories.USER, 0, 1, 3, 36);

    }

    public static String translateToLocal(String key)
    {
        if(I18n.canTranslate(key))
        {
            return I18n.translateToLocal(key);
        }

        else
        {
            return I18n.translateToFallback(key);
        }
    }

    public static String translateToLocalFormatted(String key, Object... format)
    {
        String string = translateToLocal(key);
        try
        {
            return String.format(string, format);
        }
        catch(IllegalFormatException exception)
        {
            return "FormatError: " + string;
        }
    }
}
