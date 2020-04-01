package endreborn.utils;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class EndUtils 
{
	public static ItemStack copyStackWithAmount(ItemStack stack, int amount)
	{
		if(stack.isEmpty())
			return ItemStack.EMPTY;
		ItemStack s2 = stack.copy();
		s2.setCount(amount);
		return s2;
	}
	public static <T> ArrayList<T> toArray(T... list)
	{
		ArrayList<T> array = new ArrayList<>();
		for(T componant : list)
			array.add(componant);
		return array;
	}
}
