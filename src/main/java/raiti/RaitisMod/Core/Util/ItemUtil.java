/*
 * 
 */
package raiti.RaitisMod.Core.Util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import raiti.RaitisMod.Core.Item.RItem;
import raiti.RaitisMod.Core.Item.SimpleMetaItem;

/**
 * 簡易アイテムを追加作成し、追加します
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings({"WeakerAccess", "unused", "SameParameterValue"})
public class ItemUtil {
	private ItemUtil() {
	}
	
	/**
	 * 簡易アイテムを生成します。
	 * @param name アイテム名
	 * @param textureName テクスチャー名
	 * @param addTab アイテムを追加するタブ
	 * @param stackSize 最大スタックサイズ
	 * @param containerItem クラフト時に帰ってくるアイテム
	 * @param PotionEffect 指定文字列に対応した素材として醸造台で使える。PotionHelper参照
	 * @return 生成されたアイテム
	 */
	public static RItem createItem(String name, String textureName, CreativeTabs addTab, int stackSize,
	                               Item containerItem, String PotionEffect) {
		RItem item = new RItem();
		item.setUnlocalizedName(name);
		item.setTextureName(textureName);
		if(addTab != null) item.setCreativeTab(addTab);
		item.setMaxStackSize(stackSize);
		if(containerItem != null) item.setContainerItem(containerItem);
		if(PotionEffect != null) item.setPotionEffect(PotionEffect);
		
		return item;
	}
	
	/**
	 * 簡易アイテムを作成します
	 * @param name アイテム名
	 * @param textureName テクスチャー名
	 * @param addTab 追加するタブ
	 * @return 生成されたアイテム
	 */
	public static RItem createItem(String name , String textureName , CreativeTabs addTab) {
		return createItem(name, textureName, addTab, 64, null, null);
	}
	
	/**
	 * メタデータ持ちのアイテムを生成します
	 * @param name アイテム名
	 * @param textureName テクスチャ―名
	 * @param addTab 追加するタブ
	 * @param maxMeta メタ最大値
	 * @return 生成されたアイテム
	 */
	public static RItem createSubTypeItem(String name, String textureName, CreativeTabs addTab, int maxMeta){
		RItem item = new SimpleMetaItem(maxMeta);
		item.setUnlocalizedName(name);
		item.setTextureName(textureName);
		if(addTab != null) item.setCreativeTab(addTab);
		return item;
		
	}
	
}
