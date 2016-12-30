/*
 * 
 */
package raiti.RaitisMod.Core.Client.Gui;

import raiti.RaitisMod.Core.Container.BlackHoleChestContainer;
import raiti.RaitisMod.Core.RaitisModCoreMain;
import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * ブラックホールチェストのGUI
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class BlackHoleChestGUI extends GuiContainer {
	
	public static final int GUI_ID = 0;
	
	private static final ResourceLocation texture = new ResourceLocation(RaitisModCoreMain.MOD_ID + ":textures/gui/blackhole_chest_gui.png");
	
	private IInventory lowerChestInventory, blackHoleChestInventory;
	
	@SuppressWarnings("WeakerAccess")
	public BlackHoleChestGUI(IInventory plaInv, IInventory tileInv) {
		super(new BlackHoleChestContainer(plaInv, tileInv));
		lowerChestInventory = plaInv;
		blackHoleChestInventory = tileInv;
	}
	
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i1, int i2) {
		this.fontRendererObj.drawString(this.lowerChestInventory.hasCustomInventoryName() ? this.lowerChestInventory.getInventoryName() : I18n.format(this.lowerChestInventory.getInventoryName()), 8, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(this.blackHoleChestInventory.hasCustomInventoryName() ? this.blackHoleChestInventory.getInventoryName() : I18n.format(this.blackHoleChestInventory.getInventoryName()), 8, 6, 4210752);
		String text = ((BlackHoleChestTile) this.blackHoleChestInventory).getSize() + ": Items";
		this.fontRendererObj.drawString(text, this.xSize - (35 + ((text.length() - 7) * 6)), 60, 4210752);
		ItemStack item = this.blackHoleChestInventory.getStackInSlot(0);
		if (item != null) {
			this.fontRendererObj.drawString(item.getDisplayName(), 50, 20, 4210752);
		}
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i1, int i2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
}
