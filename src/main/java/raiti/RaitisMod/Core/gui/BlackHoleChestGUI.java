/*
 * 
 */
package raiti.RaitisMod.Core.gui;

import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;
import raiti.RaitisMod.Core.container.BlackHallChestContainer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/** <h1>BlackHallChestContainer</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class BlackHoleChestGUI extends GuiContainer{
	
	private static final ResourceLocation texture = new ResourceLocation("raitismod","textures/gui/alotmorechest.png");
	
	private IInventory lowerChestInventory , alotmorechestinventry;
	
	/**<B>コンストラクター</B><br>
	 *
	 */
	@SuppressWarnings("WeakerAccess")
	public BlackHoleChestGUI(IInventory plaInv, IInventory tileInv) {
		super(new BlackHallChestContainer(plaInv, tileInv));
		lowerChestInventory = plaInv;
		alotmorechestinventry = tileInv;
	}
	
	 /**<h1>drawGuiContainerForegroundLayer</h1>
	 * オーバーライド
	 * @see net.minecraft.client.gui.inventory.GuiContainer#drawGuiContainerForegroundLayer(int, int)
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		this.fontRendererObj.drawString(this.lowerChestInventory.hasCustomInventoryName() ? this.lowerChestInventory.getInventoryName() : I18n.format(this.lowerChestInventory.getInventoryName()), 8, this.ySize -96 +2, 4210752);
		this.fontRendererObj.drawString(this.alotmorechestinventry.hasCustomInventoryName() ? this.alotmorechestinventry.getInventoryName() : I18n.format(this.alotmorechestinventry.getInventoryName()), 8, 6, 4210752);
		String text = ((BlackHoleChestTile)this.alotmorechestinventry).getSize()+": Items";
		this.fontRendererObj.drawString(text, this.xSize-(35+((text.length()-7)*6)), 60, 4210752);
		ItemStack item = this.alotmorechestinventry.getStackInSlot(0);
		if(item != null) {
			this.fontRendererObj.drawString(item.getDisplayName(), 50, 20, 4210752);
		}
		
	}

	/**<h1>drawGuiContainerBackgroundLayer</h1>
	 * オーバーライド
	 * @see net.minecraft.client.gui.inventory.GuiContainer#drawGuiContainerBackgroundLayer(float, int, int)
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
}
