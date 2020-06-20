package endreborn.utils;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import endreborn.handlers.ConfigsHandler;
import endreborn.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesUser
{
    private static final RecipesUser INSTANCE = new RecipesUser();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();

    public static RecipesUser getInstance()
    {
        return INSTANCE;
    }
    private RecipesUser()
    {
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem0)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem0).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem0).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem1)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem1).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem1).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem2)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem2).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem2).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem3)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem3).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem3).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem4)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem4).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem4).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem5)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem5).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem5).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem6)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem6).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem6).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem7)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem7).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem7).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem8)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem8).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem8).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem9)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem9).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem9).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem10)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem10).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem10).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem11)) {
    	addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem11).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem11).get(0));
    	}
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem12)) {
        addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem12).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem12).get(0));
        }
    	if (OreDictionary.doesOreNameExist(ConfigsHandler.RECIPES.materializerItem13)) {
        addAltarRecipe(new ItemStack(ItemInit.CATALYST), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem13).get(0), OreDictionary.getOres(ConfigsHandler.RECIPES.materializerItem13).get(0));
        }
    }


    public void addAltarRecipe(ItemStack input1, ItemStack input2, ItemStack result)
    {
        if(!getAltarResult(input1, input2).isEmpty()) return;
        this.smeltingList.put(input1, input2, result);
    }

    public ItemStack getAltarResult(ItemStack input1, ItemStack input2)
    {
        for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet())
        {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
            {
                for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }
}