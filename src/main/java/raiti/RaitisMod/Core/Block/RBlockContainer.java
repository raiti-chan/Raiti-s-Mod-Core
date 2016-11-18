package raiti.RaitisMod.Core.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import raiti.RaitisMod.Core.RaitisModCoreMain;

/**
 * Raiti'sMODのContainerブロックの基本クラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public abstract class RBlockContainer extends BlockContainer implements IRBlock {
	
	/**
	 * このRItemの名前
	 */
	private String rItemName;
	
	/**
	 * ブロックを生成します
	 * @param material ブロックマテリアル
	 */
	protected RBlockContainer(Material material) {
		super(material);
	}
	
	/**
	 * テクスチャ―名を指定します。頭に " {@link RaitisModCoreMain#MOD_ID raitismodcore}: " が前に付きます。
	 *
	 * @param textureName テクスチャ―名
	 * @return 自身
	 */
	@Override
	public Block setBlockTextureName(String textureName) {
		return super.setBlockTextureName(RaitisModCoreMain.MOD_ID + ":" + textureName);
	}
	
	/**
	 * 従来のForgeの{@link Block#setBlockTextureName(String)}です。ドメイン名は勝手に追加されません。
	 *
	 * @param textureName テクスチャ―名
	 * @return 自身
	 */
	@SuppressWarnings("unused")
	public Block setBlockTextureNameNonDomain(String textureName) {
		return super.setBlockTextureName(textureName);
	}
	
	/**
	 * アイテム名を設定します。頭に" {@link RaitisModCoreMain#MOD_ID RaitisModCore}. "が付きます
	 *
	 * @param name アイテム名
	 * @return 自身
	 */
	@Override
	public Block setBlockName(String name) {
		this.rItemName = name;
		return super.setBlockName(RaitisModCoreMain.MOD_ID + "." + name);
	}
	
	/**
	 * 設定されたアイテム名を取得します。
	 *
	 * @return 設定されたアイテム名
	 */
	@SuppressWarnings("WeakerAccess")
	@Override
	public String getRItemName() {
		return rItemName;
	}
	
	/**
	 * ブロックの{@link TileEntity}を生成します
	 * @param world ワールド
	 * @param meta メタデータ
	 * @return 生成したTileEntity
	 */
	@Override
	public abstract TileEntity createNewTileEntity(World world, int meta);
	
	
}
