package endreborn.mod.gui;

import endreborn.Reference;
import endreborn.mod.blocks.ContainerEntropyUser;
import endreborn.mod.blocks.TileEntropyUser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiEUser extends GuiContainer
{
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/entropy_user.png");
    private final InventoryPlayer player;
    private final TileEntropyUser tileEntity;

    public GuiEUser(InventoryPlayer player, TileEntropyUser tileEntity)
    {
        super(new ContainerEntropyUser(player, tileEntity));

        this.player = player;
        this.tileEntity = tileEntity;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float ticks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, ticks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        String tileName = this.tileEntity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 4, 855309);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 855309);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float ticks, int x, int y)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if(TileEntropyUser.isBurning(tileEntity))
        {
            int k = this.getBurnLeftScaled(10);
            this.drawTexturedModalRect(this.guiLeft + 68, this.guiTop + 17 + 9 - k, 176, 12 - k, 40, k + 1); //fuelbar
        }

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(this.guiLeft + 110, this.guiTop + 43, 176, 13, l + 1, 16); //progressbar
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileEntity.getField(1);
        if(i == 0) i = 200;
        return this.tileEntity.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileEntity.getField(2);
        int j = this.tileEntity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}