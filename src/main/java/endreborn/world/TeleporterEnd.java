package endreborn.world;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterEnd extends Teleporter
{
	private final WorldServer world;
	private double x, y, z;
	
	public TeleporterEnd(WorldServer world, double x, double y, double z)
	{
		super(world);
		
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void placeInPortal(Entity entity, float rotationYaw)
	{
		this.world.getBlockState(new BlockPos((int)this.x, (int)this.y, (int)this.z));
		entity.setPosition(x, y, z);
		entity.motionX = 0.0F;
		entity.motionY = 0.0F;
		entity.motionZ = 0.0F;
	}
	
	public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z)
	{
		int oldDimension = player.getEntityWorld().provider.getDimension();
		EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
		MinecraftServer server = player.getEntityWorld().getMinecraftServer();
		WorldServer worldServer = server.getWorld(dimension);
		
		if(worldServer == null || server == null) throw new IllegalArgumentException("Dimension: " + dimension + " doesn't exist");
		worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, 
				new TeleporterEnd(worldServer, x, y, z));
		player.setPositionAndUpdate(x, y, z);
	}
}
