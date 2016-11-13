/*
 * 
 */
package raiti.RaitisMod.Core.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;
import raiti.RaitisMod.Core.block.Blocks;
import raiti.RaitisMod.Core.renderer.BlackHoleChestRenderer;
import raiti.RaitisMod.Core.renderer.itemRenderer.BlackHoleChestItemRenderer;
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
		GameRegistry.registerTileEntity(BlackHoleChestTile.class, "BlackHoleChestTile");
		BlackHoleChestRenderer blackHoleChestRenderer = new BlackHoleChestRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(BlackHoleChestTile.class, blackHoleChestRenderer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Blocks.alotmorechest), new BlackHoleChestItemRenderer(blackHoleChestRenderer, new BlackHoleChestTile()));
		//Factory=======================================================================================================
		GameRegistry.registerTileEntity(TileEntityThermalGenerator.class, "ThermalGenerator");
	}
	
}
