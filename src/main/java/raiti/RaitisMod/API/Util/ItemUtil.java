/*
 * 
 */
package raiti.RaitisMod.API.Util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/** <h1>ItemUtil</h1>
 * 簡易アイテムを追加作成し、追加します<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class ItemUtil {
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * 無効
	 */
	private ItemUtil() {
	}
	
	/**
	 * <h1>CreatItem</h1>
	 * 簡易アイテムを作成します<br>
	 * @param name アイテム名
	 * @param textureName テクスチャー名
	 * @param addTab アイテムを追加するタブ
	 * @param stackSize 最大スタックサイズ
	 * @param hasSubtype ダメージ値でアイテムが分けられているか
	 * @param MaxDam 最大耐久値
	 * @param isFull3D アイテムを3Dで表示するか
	 * @param containerItem クラフト時に帰ってくるアイテム
	 * @param PotionEffect 指定文字列に対応した素材として醸造台で使える。PotionHelper参照
	 * @param isRpeair 金床で修復ができるか
	 * @return
	 */
	public static Item CreatItem(String name , String textureName , CreativeTabs addTab , int stackSize , boolean hasSubtype , int MaxDam , boolean isFull3D,
									Item containerItem , String PotionEffect , boolean isRpeair) {
		Item item = new Item();
		item.setUnlocalizedName(name);
		item.setTextureName(textureName);
		if(addTab != null) item.setCreativeTab(addTab);
		item.setMaxStackSize(stackSize);
		item.setHasSubtypes(hasSubtype);
		item.setMaxDamage(MaxDam);
		if(isFull3D) item.setFull3D();
		if(containerItem != null) item.setContainerItem(containerItem);
		if(PotionEffect != null) item.setPotionEffect(PotionEffect);
		if(!isRpeair)item.setNoRepair();
		
		return item;
	}
	
	/**
	 * <h1>CreatItem</h1>
	 * 簡易アイテムを作成します<br>
	 * @param name アイテム名
	 * @param textureName テクスチャー名
	 * @param addTab 追加するタブ
	 * @return
	 */
	public static Item CreatItem(String name , String textureName , CreativeTabs addTab) {
		return CreatItem(name, textureName, addTab, 64, false, 0, false, null, null, true);
	}
	
}
