package raiti.RaitisMod.Core.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raiti.RaitisMod.Core.RaitisModCoreMain;

/**
 * Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 */
public class RBlock extends Block implements IRBlock {
	
	/**
	 * このRItemの名前
	 */
	private String rItemName;
	
	protected RBlock(Material material) {
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
	 * @return 設定されたアイテム名
	 */
	@SuppressWarnings("WeakerAccess")
	@Override
	public String getRItemName() {
		return rItemName;
	}
	
}
