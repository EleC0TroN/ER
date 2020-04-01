package endreborn.handlers;

import endreborn.Reference;
import endreborn.mod.blocks.ContainerEntropyUser;
import endreborn.mod.blocks.TileEntropyUser;
import endreborn.mod.gui.GuiEUser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_E_USER) return new ContainerEntropyUser(player.inventory, (TileEntropyUser)world.getTileEntity(new BlockPos(x,y,z)));

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_E_USER) return new GuiEUser(player.inventory, (TileEntropyUser)world.getTileEntity(new BlockPos(x,y,z)));

        return null;
    }
}
