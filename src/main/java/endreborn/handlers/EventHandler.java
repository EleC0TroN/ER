package endreborn.handlers;

import endreborn.Reference;
import endreborn.init.BlockInit;
import endreborn.init.ItemInit;
import endreborn.mod.entity.EntityChronologist;
import endreborn.mod.entity.EntityEGuard;
import endreborn.mod.entity.EntityWatcher;
import endreborn.utils.EndForge;
import endreborn.world.TeleporterEnd;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.*;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Calendar;


@EventBusSubscriber
public class EventHandler 
{
	@SubscribeEvent
	public void onDragonTick(LivingEvent.LivingUpdateEvent event) {
		EntityLivingBase living = event.getEntityLiving();
		if (living.world.isRemote || !(living instanceof EntityDragon))
			return;
		EntityDragon dragon = (EntityDragon) living;
		if (dragon.deathTicks < 150 || dragon.deathTicks % 10 != 0)
			return;

		for (int i = 0; i < 6; i++) {
			int x = dragon.world.rand.nextInt(256) - 128;
			int z = dragon.world.rand.nextInt(256) - 128;
			BlockPos pos = new BlockPos(x, dragon.world.getHeight(x, z)-1, z);
			if (!dragon.world.isBlockLoaded(pos))
				continue;
			if (dragon.world.getBlockState(pos.down()).getBlock() != Blocks.END_STONE)
				continue;
			dragon.world.setBlockState(pos, BlockInit.DRAGON_ESSENCE.getDefaultState());
		}
	}

	@SubscribeEvent
    public static void playerInteractEvent(PlayerInteractEvent.RightClickBlock event)
    {
        ItemStack stack = event.getItemStack();

        EntityPlayer player = event.getEntityPlayer();
        if (event.getHand() == EnumHand.OFF_HAND)
        {
            ItemStack mainStack = player.getHeldItem(EnumHand.MAIN_HAND);
            if (EndForge.hasAction(event.getWorld(), event.getPos(), mainStack, event.getFace()))
            {
                event.setCancellationResult(EnumActionResult.SUCCESS);
                event.setCanceled(true);
                return;
            }
        }

        if (EndForge.hasAction(event.getWorld(), event.getPos(), stack, event.getFace()))
        {
            if (EndForge.performAction(event.getWorld(), event.getPos(), player, stack, event.getFace(), event.getHand()))
            {
                event.setCancellationResult(EnumActionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEventDrop(LivingDropsEvent event)
	{
	    if (event.getEntity() instanceof EntityDragon)
	    {
	        ItemStack itemStackToDrop = new ItemStack(ItemInit.DRAGON_SCALES, 2);
	        event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX, 
	              event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
	       
	    }
	    if (event.getEntity() instanceof EntityEnderman)
	    {
	        ItemStack itemStackToDrop = new ItemStack(ItemInit.ENDER_FLESH, 1);
	        event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX, 
	              event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
	    }
	    
	    if (event.getEntity() instanceof EntityWatcher)
	    {
	        ItemStack itemStackToDrop = new ItemStack(ItemInit.ENDER_FLESH, 1);
	        event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX, 
	              event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
	    }
		
		if (event.getEntity() instanceof EntityWatcher)
		{
			ItemStack itemStackToDrop = new ItemStack(Items.ENDER_EYE, 1);
			event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX,
					event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
		}
	} 
	@SubscribeEvent
	public static void onLivingSpawn(LivingSpawnEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		if(entity instanceof EntityEnderman && ConfigsHandler.GENERAL.spawnWatcher) {
			if(entity.world.provider.getDimension() == 1 && entity.world.getDifficulty() != EnumDifficulty.PEACEFUL && !entity.world.isRemote) {
				if(entity.getRNG().nextInt(ConfigsHandler.BALANCE.watcherRare) == 1) {
					EntityWatcher watch = new EntityWatcher(entity.world);
					watch.copyLocationAndAnglesFrom(entity);
					entity.world.spawnEntity(watch);
					entity.setDead();
				} 
			}
		}
		if(entity instanceof EntityEnderman && ConfigsHandler.GENERAL.spawnChronologist) {
			if(entity.world.provider.getDimension() == 0 && entity.world.getDifficulty() != EnumDifficulty.PEACEFUL && !entity.world.isRemote) {
				if(entity.getRNG().nextInt(ConfigsHandler.BALANCE.chronRare) == 1) {
					EntityChronologist chron = new EntityChronologist(entity.world);
					chron.copyLocationAndAnglesFrom(entity);
					entity.world.spawnEntity(chron);
					entity.setDead();
				} 
			}
		}
		if(entity instanceof EntityEnderman && ConfigsHandler.GENERAL.spawnEndGuard) {
			if(entity.world.provider.getDimension() == 1 && entity.world.getDifficulty() != EnumDifficulty.PEACEFUL && !entity.world.isRemote) {
				if(entity.getRNG().nextInt(ConfigsHandler.BALANCE.guardRare) == 1) {
					EntityEGuard guard = new EntityEGuard(entity.world);
					guard.copyLocationAndAnglesFrom(entity);
					entity.world.spawnEntity(guard);
					entity.setDead();
				} 
			}
		}
	}
	@SubscribeEvent
    public static void onPlayerPosition(LivingHurtEvent event) 
	{
        if(event.getEntityLiving() instanceof EntityPlayerMP && event.getEntityLiving().dimension == 1 
        		&& ConfigsHandler.GENERAL.teleporterEnd && event.getEntityLiving().getPosition().getY() <= -6)
        {
        	EntityPlayerMP player = (EntityPlayerMP) event.getEntityLiving();
        	PlayerList playerList = player.getEntityWorld().getMinecraftServer().getPlayerList();
        	
        	event.setCanceled(true);
        	playerList.transferPlayerToDimension(player, 0, 
        			new TeleporterEnd((WorldServer) player.getEntityWorld(), 
        					player.getPosition().getX(), 250, player.getPosition().getZ()));
        }
        }
	@SubscribeEvent
	public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equals(Reference.MODID))
		{
			ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);

		}
	}
	
	@SuppressWarnings("static-access")
	public static boolean isDayI() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) == calendar.MAY && calendar.get(Calendar.DAY_OF_MONTH) == 10;
	}
	@SuppressWarnings("static-access")
	public static boolean isDayS() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) == calendar.AUGUST && calendar.get(Calendar.DAY_OF_MONTH) == 20;
	}
	@SuppressWarnings("static-access")
	public static boolean isDayB() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) == calendar.SEPTEMBER && calendar.get(Calendar.DAY_OF_MONTH) == 7;
	}
	@SuppressWarnings("static-access")
	public static boolean isDayY() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) == calendar.FEBRUARY && calendar.get(Calendar.DAY_OF_MONTH) == 11;
	}
	@SuppressWarnings("static-access")
	public static boolean isDayN() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) == calendar.JANUARY && calendar.get(Calendar.DAY_OF_MONTH) == 26;
	}
	@SubscribeEvent
	public void onJoin(EntityJoinWorldEvent e)
	{
		if (e.getEntity() instanceof EntityPlayer && isDayI())
		{
			EntityPlayer player = (EntityPlayer) e.getEntity();
			player.sendMessage(new TextComponentString("[End: Reborn] Hey, thanks for playing with my mod. Happy birthday to me..."));
		}
	}
	@SubscribeEvent
	public void onJoin2(EntityJoinWorldEvent e)
	{
		if (e.getEntity() instanceof EntityPlayer && isDayS())
		{
			EntityPlayer player = (EntityPlayer) e.getEntity();
			player.sendMessage(new TextComponentString("[End: Reborn] Just a very good day;)"));
		}
	}
	@SubscribeEvent
	public void onJoin3(EntityJoinWorldEvent e)
	{
		if (e.getEntity() instanceof EntityPlayer && isDayB())
		{
			EntityPlayer player = (EntityPlayer) e.getEntity();
			player.sendMessage(new TextComponentString("[End: Reborn] Happy birthday to Lord."));
		}
	}
	@SubscribeEvent
	public void onJoin4(EntityJoinWorldEvent e)
	{
		if (e.getEntity() instanceof EntityPlayer && isDayY())
		{
			EntityPlayer player = (EntityPlayer) e.getEntity();
			player.sendMessage(new TextComponentString("[End: Reborn] Happy tea party!"));
		}
	}
	@SubscribeEvent
	public void onJoin5(EntityJoinWorldEvent e)
	{
		if (e.getEntity() instanceof EntityPlayer && isDayN())
		{
			EntityPlayer player = (EntityPlayer) e.getEntity();
			player.sendMessage(new TextComponentString("[End: Reborn] Belive to yorself."));
		}
	}
}	
