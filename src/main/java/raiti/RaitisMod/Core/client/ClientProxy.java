/*
 * 
 */
package raiti.RaitisMod.Core.client;

import raiti.RaitisMod.Core.TileEntity.BlackHallChestTile;
import raiti.RaitisMod.Core.server.CommonProxy;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import raiti.RaitisMod.Factory.TileEntity.TileEntityThermalGenerator;

/** <h1>ClientProxy</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class ClientProxy extends CommonProxy{
	
	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
	
	@Override
	public void registerTileEntity() {
		GameRegistry.registerTileEntity(BlackHallChestTile.class, "BlackHallChestTile");
		
		//Factory=======================================================================================================
		GameRegistry.registerTileEntity(TileEntityThermalGenerator.class, "ThermalGenerator");
	}
	
}
