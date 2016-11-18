/*
 * 
 */
package raiti.RaitisMod.Core.Util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import raiti.RaitisMod.Core.Item.RItem;

/**
 * 簡易アイテムを追加作成し、追加します
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class ItemUtil {
	private ItemUtil() {
	}
	
	/**
	 * 簡易アイテムを生成します。
	 * @param name アイテム名
	 * @param textureName テクスチャー名
	 * @param addTab アイテムを追加するタブ
	 * @param stackSize 最大スタックサイズ
	 * @param hasSubtype ダメージ値でアイテムが分けられているか
	 * @param MaxDam 最大耐久値
	 * @param isFull3D アイテムを3Dで表示するか
	 * @param containerItem クラフト時に帰ってくるアイテム
	 * @param PotionEffect 指定文字列に対応した素材として醸造台で使える。PotionHelper参照
	 * @param isRepair 金床で修復ができるか
	 * @return 生成されたアイテム
	 */
	public static RItem createItem(String name , String textureName , CreativeTabs addTab , int stackSize , boolean hasSubtype , int MaxDam , boolean isFull3D,
	                              Item containerItem , String PotionEffect , boolean isRepair) {
		RItem item = new RItem();
		item.setUnlocalizedName(name);
		item.setTextureName(textureName);
		if(addTab != null) item.setCreativeTab(addTab);
		item.setMaxStackSize(stackSize);
		item.setHasSubtypes(hasSubtype);
		item.setMaxDamage(MaxDam);
		if(isFull3D) item.setFull3D();
		if(containerItem != null) item.setContainerItem(containerItem);
		if(PotionEffect != null) item.setPotionEffect(PotionEffect);
		if(!isRepair)item.setNoRepair();
		
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
		return createItem(name, textureName, addTab, 64, false, 0, false, null, null, true);
	}
	
}
