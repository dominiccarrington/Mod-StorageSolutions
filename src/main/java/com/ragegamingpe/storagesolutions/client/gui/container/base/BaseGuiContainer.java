package com.ragegamingpe.storagesolutions.client.gui.container.base;

import com.ragegamingpe.storagesolutions.common.container.base.BaseContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BaseGuiContainer extends GuiContainer
{
    protected int[] topLeft;
    protected final Minecraft mc;
    protected final ResourceLocation background;

    public BaseGuiContainer(Container inventorySlotsIn, ResourceLocation background)
    {
        this(inventorySlotsIn, background, 176, 166);
    }

    public BaseGuiContainer(Container inventorySlotsIn, ResourceLocation background, int width, int height)
    {
        super(inventorySlotsIn);
        this.background = background;
        this.xSize = width;
        this.ySize = height;
        this.mc = Minecraft.getMinecraft();
    }

    @Override
    public void initGui()
    {
        super.initGui();

        topLeft = new int[]{
                (this.width - this.xSize) / 2,
                (this.height - this.ySize) / 2
        };
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawScreen(mouseX, mouseY, partialTicks, true);

        for (GuiButton button : this.buttonList) {
            if (button instanceof GuiTooltipButton) {
                if (button.isMouseOver()) {
                    this.drawHoveringText(((GuiTooltipButton) button).tooltip, mouseX, mouseY);
                }
            }
        }
    }

    protected void drawScreen(int mouseX, int mouseY, float partialTicks, boolean autoDraw)
    {
        if (autoDraw) this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        if (autoDraw) this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        if (this.inventorySlots instanceof BaseContainer) {
            String s = ((BaseContainer) this.inventorySlots).getTileEntityInventory().getDisplayName().getUnformattedText();
            this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
            this.fontRenderer.drawString(((BaseContainer) this.inventorySlots).getPlayerInventory().getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(this.background);
        this.drawTexturedModalRect(topLeft[0], topLeft[1], 0, 0, this.xSize, this.ySize);
    }

    protected class GuiTooltipButton extends GuiButton
    {
        private final String tooltip;

        public GuiTooltipButton(int buttonId, int x, int y, String buttonText, String tooltip)
        {
            this(buttonId, x, y, 200, 16, buttonText, tooltip);
        }

        public GuiTooltipButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, String tooltip)
        {
            super(buttonId, x, y, widthIn, heightIn, buttonText);
            this.tooltip = tooltip;
        }
    }
}
