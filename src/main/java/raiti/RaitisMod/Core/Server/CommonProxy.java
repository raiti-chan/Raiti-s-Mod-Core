/*
 * 
 */
package raiti.RaitisMod.Core.Server;

import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import raiti.RaitisMod.Factory.TileEntity.TileEntityThermalGenerator;

/**
 * サーバー用プロキシ―クラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class CommonProxy {
	
	/**
	 * 空いてるレンダ―IDを取得しますが{@link CommonProxy}では-1を返します。
	 *
	 * @return -1
	 */
	public int getNewRenderType() {
		return -1;
	}
	
	/**
	 * ワールドを取得しますが、{@link CommonProxy}ではnullを返します。<br>
	 *
	 * @return null
	 */
	@SuppressWarnings("unused")
	public World getClientWorld() {
		return null;
	}
	
	/**
	 * {@link net.minecraft.tileentity.TileEntity}を{@link GameRegistry}に登録するメソッドです。
	 */
	public final void registerTileEntity() {
		GameRegistry.registerTileEntity(BlackHoleChestTile.class, "BlackHoleChestTile");
		
		//Factory=======================================================================================================
		GameRegistry.registerTileEntity(TileEntityThermalGenerator.class, "ThermalGenerator");
	}
	
	/**
	 * レンダ―をレジスターに登録するメソッド<br>
	 * {@link CommonProxy}では何も行いません
	 */
	public void registerRenderer() {
	}
	
	/**
	 * {@link net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer}をブロックやアイテムに関連付けるメソッドです<br>
	 * {@link CommonProxy}では何も行いません
	 */
	public void registerTileEntitySpecialRenderer() {
	}
}
