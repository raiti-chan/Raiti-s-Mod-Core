package raiti.RaitisMod.Core.Item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * メタ値で分けられたアイテム
 * <br>Created by Raiti-chan on 2016/12/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class SimpleMetaItem extends RItem {
	
	/**
	 * アイテムのテクスチャ―
	 */
	private IIcon[] icons;
	
	/**
	 * メタデータで分けられたアイテムの生成
	 *
	 * @param maxMeta メタ最大値
	 */
	public SimpleMetaItem(int maxMeta) {
		icons = new IIcon[maxMeta];
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	/**
	 * テクスチャのレジスター処理
	 *
	 * @param register register
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		for (int i = 0; i < this.icons.length; i++) {
			this.icons[i] = register.registerIcon(this.getIconString() + "_" + i);
		}
	}
	
	/**
	 * メタ値によるアイコンの変更
	 *
	 * @param meta メタ値
	 * @return 対応したアイコン
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		return this.icons[meta];
	}
	
	/**
	 * クリエイティブタブにアイテムを登録します
	 * @param item アイテム
	 * @param tab クリエイティブタブ
	 * @param list リスト
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < this.icons.length; i++) {
			list.add(new ItemStack(this, 1, i));
		}
		
	}
	
	/**
	 * メタ値の取得
	 *
	 * @param meta メタ値
	 * @return メタ値
	 */
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	/**
	 * メタ値ごとのUnlocalizedNameの取得
	 *
	 * @param itemStack アイテム
	 * @return 名前
	 */
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
	}
}
