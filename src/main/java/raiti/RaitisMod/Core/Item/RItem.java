package raiti.RaitisMod.Core.Item;

import net.minecraft.item.Item;
import raiti.RaitisMod.Core.RaitisModCoreMain;

/**
 * Raiti'sMODのアイテムのベースクラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RItem extends Item implements IRItem {
	
	public RItem() {
	}
	
	/**
	 * このRItemの名前
	 */
	private String rItemName;
	
	/**
	 * テクスチャ―名を指定します。頭に " {@link RaitisModCoreMain#MOD_ID raitismodcore}: " が前に付きます。
	 *
	 * @param textureName テクスチャ―名
	 * @return 自身
	 */
	@Override
	public Item setTextureName(String textureName) {
		return super.setTextureName(RaitisModCoreMain.MOD_ID + ":" + textureName);
	}
	
	/**
	 * 従来のForgeの{@link Item#setTextureName(String)}です。ドメイン名は勝手に追加されません。
	 *
	 * @param textureName テクスチャ―名
	 * @return 自身
	 */
	@SuppressWarnings("unused")
	public Item setTextureNameNonDomain(String textureName) {
		return super.setTextureName(textureName);
	}
	
	/**
	 * アイテム名を設定します。頭に" {@link RaitisModCoreMain#MOD_ID RaitisModCore}. "が付きます
	 *
	 * @param name アイテム名
	 * @return 自身
	 */
	@Override
	public Item setUnlocalizedName(String name) {
		this.rItemName = name;
		return super.setUnlocalizedName(RaitisModCoreMain.MOD_ID + "." + name);
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
