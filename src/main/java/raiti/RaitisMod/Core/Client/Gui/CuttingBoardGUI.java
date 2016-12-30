package raiti.RaitisMod.Core.Client.Gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import raiti.RaitisMod.Core.Container.CuttingBoardContainer;

/**
 * <br>Created by Raiti-chan on 2016/12/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class CuttingBoardGUI extends GuiContainer {
	
	public static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");
	
	public static final int GUI_ID = 500;
	
	public CuttingBoardGUI(InventoryPlayer inventoryPlayer, World world, int x, int y, int z) {
		super(new CuttingBoardContainer(inventoryPlayer, world, x, y, z));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		this.fontRendererObj.drawString(I18n.format("GUI.RaitisModCore.CuttingBoard.name"), 28, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(ChatFormatting.BOLD + "x2", 110, this.ySize - 110, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}
