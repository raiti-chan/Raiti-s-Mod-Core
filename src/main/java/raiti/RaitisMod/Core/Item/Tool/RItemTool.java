package raiti.RaitisMod.Core.Item.Tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import raiti.RaitisMod.Core.Item.IRItem;
import raiti.RaitisMod.Core.RaitisModCoreMain;

import java.util.Set;


/**
 * Raiti'sMODのItemToolのベースクラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class RItemTool extends ItemTool implements IRItem {
	
	@SuppressWarnings("WeakerAccess")
	protected RItemTool(float damageBase, RToolMaterial material, Set canHarvestBlock) {
		super(damageBase, material.getMaterial(), canHarvestBlock);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	@SuppressWarnings("WeakerAccess")
	protected RItemTool(float damageBase, RToolMaterial material) {
		this(damageBase, material, null);
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
		return super.setTextureName(RaitisModCoreMain.MOD_ID + ":tool/" + textureName);
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
