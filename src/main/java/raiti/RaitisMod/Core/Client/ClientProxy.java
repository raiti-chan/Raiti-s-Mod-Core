package raiti.RaitisMod.Core.Client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import raiti.RaitisMod.Core.Client.Renderer.SolidWaterBlockRender;
import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;
import raiti.RaitisMod.Core.Block.RBlockRegister;
import raiti.RaitisMod.Core.Client.Renderer.SpecialRender.BlackHoleChestRenderer;
import raiti.RaitisMod.Core.Client.Renderer.itemRenderer.BlackHoleChestItemRenderer;
import raiti.RaitisMod.Core.Server.CommonProxy;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.world.World;

/**
 * クライアントのプロキシ―クラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {
	
	/**
	 * 空いているレンダ―IDを取得します。
	 * @return 空いているレンダ―ID
	 */
	@Override
	public int getNewRenderType() {
		return RenderingRegistry.getNextAvailableRenderId();
	}
	
	/**
	 * {@link net.minecraft.client.multiplayer.WorldClient}を取得します
	 * @return WorldClient
	 */
	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
	
	/**
	 * レンダ―をレジスターに登録します
	 */
	@Override
	public void registerRenderer() {
		RenderingRegistry.registerBlockHandler(new SolidWaterBlockRender());
	}
	
	/**
	 * {@link net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer}をブロックやアイテムに関連付けるメソッド<br>
	 */
	@Override
	public void registerTileEntitySpecialRenderer() {
		// ブラックホールチェスト=======================================================================================
		BlackHoleChestRenderer blackHoleChestRenderer = new BlackHoleChestRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(BlackHoleChestTile.class, blackHoleChestRenderer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RBlockRegister.Black_hole_chest_block), new BlackHoleChestItemRenderer(blackHoleChestRenderer, new BlackHoleChestTile()));
		//==============================================================================================================
	}
}
