package endreborn.compat;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import endreborn.utils.RecipesUser;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class EUserMaker
{
    public static List<EUserRecipe> getRecipes(IJeiHelpers helpers)
    {
    	IStackHelper stackhelper = helpers.getStackHelper();
        RecipesUser instance = RecipesUser.getInstance();
        Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
        List<EUserRecipe> jeiRecipes = Lists.newArrayList();

        for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet())
        {
            for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
            {
                ItemStack input0 = entry.getKey();
                ItemStack input1 = entry.getKey();
                ItemStack input2 = ent.getKey();
                ItemStack output = ent.getValue();

                List<ItemStack> inputs = Lists.newArrayList(input1, input2, input0);
                EUserRecipe recipe = new EUserRecipe(inputs, output);
                jeiRecipes.add(recipe);
            }
        }

        return jeiRecipes;
    }
}
