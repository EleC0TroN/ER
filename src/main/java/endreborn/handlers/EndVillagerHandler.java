package endreborn.handlers;

import java.util.Random;

import javax.annotation.Nonnull;

import endreborn.Reference;
import endreborn.init.ItemInit;
import endreborn.utils.EndUtils;
import endreborn.world.EndVillagerHouse;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

/**
 * @author BluSunrize - 23.07.2016
 */
public class EndVillagerHandler
{
	private static final VillagerRegistry VILLAGER_REGISTRY = VillagerRegistry.instance();
	public static VillagerRegistry.VillagerProfession PROF_EXPLORER;

	@ObjectHolder("minecraft:librarian")
	public static final VillagerProfession LIBRARIAN = null;

	public static void initIEVillagerHouse()
	{
		VILLAGER_REGISTRY.registerVillageCreationHandler(new EndVillagerHouse.VillageManager());
		MapGenStructureIO.registerStructureComponent(EndVillagerHouse.class, Reference.MODID+":ExplorerHouse");
	}
	
	public static void initIEVillagerTrades()
	{
		PROF_EXPLORER = new VillagerRegistry.VillagerProfession(Reference.MODID+":explorer", "endreborn:textures/models/villager_explorer.png", "endreborn:textures/models/villager_explorer_zombie.png");
		ForgeRegistries.VILLAGER_PROFESSIONS.register(PROF_EXPLORER);


		/* Engineer
		 * Deals in treated wood, later metal rods, scaffold and concrete
		 */
		VillagerRegistry.VillagerCareer overworld_explorer = new VillagerRegistry.VillagerCareer(PROF_EXPLORER, Reference.MODID+".overworld_explorer");
		overworld_explorer.addTrade(1,
				new ItemstackForEmerald(new ItemStack(ItemInit.HAMMER_IRON, 1, 0), new EntityVillager.PriceInfo(1, 1)),
				new ItemstackForEmerald(new ItemStack(ItemInit.INGOT_WOLFRAMIUM, 1, 0), new EntityVillager.PriceInfo(-4, -1)),
				new EmeraldForItemstack(new ItemStack(Blocks.IRON_ORE, 1, 0), new EntityVillager.PriceInfo(1, 3))
		);
		VillagerRegistry.VillagerCareer nether_explorer = new VillagerRegistry.VillagerCareer(PROF_EXPLORER, Reference.MODID+".nether_explorer");
		nether_explorer.addTrade(1,
				new EmeraldForItemstack(new ItemStack(Items.GOLD_NUGGET, 1, 0), new EntityVillager.PriceInfo(8, 16)),
				new ItemstackForEmerald(new ItemStack(Blocks.NETHERRACK, 1, 0), new EntityVillager.PriceInfo(-4, -2)),
				new ItemstackForEmerald(new ItemStack(Items.NETHER_WART, 1, 0), new EntityVillager.PriceInfo(-1, -1))
				
		);

		VillagerRegistry.VillagerCareer end_explorer = new VillagerRegistry.VillagerCareer(PROF_EXPLORER, Reference.MODID+".end_explorer");
		end_explorer.addTrade(1,
				new EmeraldForItemstack(new ItemStack(Items.ENDER_PEARL, 3, 0), new EntityVillager.PriceInfo(6, 8)),
				new ItemstackForEmerald(new ItemStack(ItemInit.END_ESSENCE, 3, 0), new EntityVillager.PriceInfo(-2, -1)),
				new ItemstackForEmerald(new ItemStack(Blocks.END_STONE, 3, 0), new EntityVillager.PriceInfo(-4, -2)),
				new ItemstackForEmerald(new ItemStack(ItemInit.CHORUS_SOUP, 3, 0), new EntityVillager.PriceInfo(-2, -1))
		);
	}

	private static class EmeraldForItemstack implements EntityVillager.ITradeList
	{
		public ItemStack buyingItem;
		public EntityVillager.PriceInfo buyAmounts;

		public EmeraldForItemstack(@Nonnull ItemStack item, @Nonnull EntityVillager.PriceInfo buyAmounts)
		{
			this.buyingItem = item;
			this.buyAmounts = buyAmounts;
		}

		@Override
		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
		{
			recipeList.add(new MerchantRecipe(EndUtils.copyStackWithAmount(this.buyingItem, this.buyAmounts.getPrice(random)), Items.EMERALD));
		}
	}

	private static class ItemstackForEmerald implements EntityVillager.ITradeList
	{
		public ItemStack sellingItem;
		public EntityVillager.PriceInfo priceInfo;

		@SuppressWarnings("unused")
		public ItemstackForEmerald(Item par1Item, EntityVillager.PriceInfo priceInfo)
		{
			this.sellingItem = new ItemStack(par1Item);
			this.priceInfo = priceInfo;
		}

		public ItemstackForEmerald(ItemStack stack, EntityVillager.PriceInfo priceInfo)
		{
			this.sellingItem = stack;
			this.priceInfo = priceInfo;
		}

		@Override
		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
		{
			int i = 1;
			if(this.priceInfo!=null)
				i = this.priceInfo.getPrice(random);
			ItemStack itemstack;
			ItemStack itemstack1;
			if(i < 0)
			{
				itemstack = new ItemStack(Items.EMERALD);
				itemstack1 = EndUtils.copyStackWithAmount(sellingItem, -i);
			}
			else
			{
				itemstack = new ItemStack(Items.EMERALD, i, 0);
				itemstack1 = EndUtils.copyStackWithAmount(sellingItem, 1);
			}
			recipeList.add(new MerchantRecipe(itemstack, itemstack1));
		}
	}

}
