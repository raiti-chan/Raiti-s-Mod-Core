/*
 * 
 */
package raiti.RaitisMod.Core.server;

import raiti.RaitisMod.Core.TileEntity.AlotmoreChestTile;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import raiti.RaitisMod.Factory.TileEntity.TileEntityThermalGenerator;

/** <h1>CommonProxy</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class CommonProxy {
	
	public World getClientWorld() {
		return null;
	}
	
	public void registerTileEntity() {
		GameRegistry.registerTileEntity(AlotmoreChestTile.class, "AlotmoreChestTile");
		
		//Factory=======================================================================================================
		GameRegistry.registerTileEntity(TileEntityThermalGenerator.class, "ThermalGenerator");
	}
	
}
