/*
 * 
 */
package raiti.RaitisMod.Core.Client.Gui;

import net.minecraft.inventory.ContainerWorkbench;
import raiti.RaitisMod.Core.Container.CuttingBoardContainer;
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
public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		switch (ID) {
			case BlackHoleChestGUI.GUI_ID:
				BlackHoleChestTile tile = (BlackHoleChestTile) world.getTileEntity(x, y, z);
				return new BlackHoleChestContainer(player.inventory, tile);
			
			case CuttingBoardGUI.GUI_ID:
				return new CuttingBoardContainer(player.inventory, world, x, y, z);
		}
		
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		switch (ID) {
			case BlackHoleChestGUI.GUI_ID:
				BlackHoleChestTile tile = (BlackHoleChestTile) world.getTileEntity(x, y, z);
				return new BlackHoleChestGUI(player.inventory, tile);
			
			case CuttingBoardGUI.GUI_ID:
				return new CuttingBoardGUI(player.inventory, world, x, y, z);
		}
		
		return null;
	}
}
