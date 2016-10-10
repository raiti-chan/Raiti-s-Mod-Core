/*
 * 
 */
package raiti.RaitisMod.Core.gui;

import raiti.RaitisMod.Core.TileEntity.AlotmoreChestTile;
import raiti.RaitisMod.Core.container.AlotmoreChestContainer;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/** <h1>GuiHandler</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class GuiHandler implements IGuiHandler{
	
	public static final int AlotmoreChestGUI = 0;

	/**<h1>getServerGuiElement</h1>
	 * オーバーライド
	 * @see cpw.mods.fml.common.network.IGuiHandler#getServerGuiElement(int, net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, int, int, int)
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == AlotmoreChestGUI) {
			AlotmoreChestTile tile = (AlotmoreChestTile) world.getTileEntity(x, y, z);
			return new AlotmoreChestContainer(player.inventory, tile);
		}
		
		return null;
	}

	/**<h1>getClientGuiElement</h1>
	 * オーバーライド
	 * @see cpw.mods.fml.common.network.IGuiHandler#getClientGuiElement(int, net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, int, int, int)
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == AlotmoreChestGUI) {
			AlotmoreChestTile tile = (AlotmoreChestTile) world.getTileEntity(x, y, z);
			return new AlotmoreChestGUI(player.inventory, tile);
		}
		
		return null;
	}
}
