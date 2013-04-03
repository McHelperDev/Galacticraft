package micdoodle8.mods.galacticraft.core.client.gui;

import micdoodle8.mods.galacticraft.API.ISchematicPage;
import micdoodle8.mods.galacticraft.API.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.inventory.GCCoreContainerRocketBench;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GCCoreGuiSchematicRocketT1 extends GuiContainer
{
	private GuiButton backButton;
	private GuiButton nextButton;
	
    public GCCoreGuiSchematicRocketT1(InventoryPlayer par1InventoryPlayer, int x, int y, int z)
    {
        super(new GCCoreContainerRocketBench(par1InventoryPlayer, x, y, z));
        this.ySize = 221;
    }

    @Override
    public void initGui()
    {
    	super.initGui();
        this.buttonList.clear();
        this.buttonList.add((backButton = new GuiButton(0, this.width / 2 - 130, this.height / 2 - 30 + 27, 40, 20, "Back")));
        this.buttonList.add((nextButton = new GuiButton(1, this.width / 2 + 90, this.height / 2 - 30 + 27, 40, 20, "Next")));
        this.backButton.enabled = false;
    }

    @Override
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            switch (par1GuiButton.id)
            {
            case 0:
            	SchematicRegistry.flipToLastPage(0);
                break;
            case 1:
            	SchematicRegistry.flipToNextPage(0);
            	break;
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString("Tier 1 Rocket", 7, -20 + 27, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, 202 - 104 + 2 + 27, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/micdoodle8/mods/galacticraft/core/client/gui/rocketbench.png");
        final int var5 = (this.width - this.xSize) / 2;
        final int var6 = (this.height - 220) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, 220);
    }
}