/*
 * 
 */
package raiti.RaitisMod.Core.Client.Gui;

import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import raiti.RaitisMod.Core.Container.BlackHoleChestContainer;

/**
 * GUIのハンドラー
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class GuiHandler implements IGuiHandler{
	
	public static final int AlotmoreChestGUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == AlotmoreChestGUI) {
			BlackHoleChestTile tile = (BlackHoleChestTile) world.getTileEntity(x, y, z);
			return new BlackHoleChestContainer(player.inventory, tile);
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == AlotmoreChestGUI) {
			BlackHoleChestTile tile = (BlackHoleChestTile) world.getTileEntity(x, y, z);
			return new BlackHoleChestGUI(player.inventory, tile);
		}
		
		return null;
	}
}
