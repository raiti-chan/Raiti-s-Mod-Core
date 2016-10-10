/*
 * 
 */
package raiti.RaitisMod.Core.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/** <h1>EMCItems</h1>
 * EMCItem<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class EMCItems extends Item {
	
	private IIcon[] iicons = new IIcon[21];
	
	/**
	 * <B>コンストラクター</B><br>
	 */
	public EMCItems() {
		super();
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("emc");
		this.setTextureName("raitismod:emc");
	}
	
	/**
	 * <h1>registerIcons</h1>
	 * オーバーライド<br>
	 * アイコンの取得
	 * @see net.minecraft.item.Item#registerIcons(net.minecraft.client.renderer.texture.IIconRegister)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iicon) {
		for(int i = 0 ; i < this.iicons.length ; i++) {
			this.iicons[i] = iicon.registerIcon(this.getIconString() +"_"+i);
		}
	}
	
	
	/**<h1>getIconFromDamage</h1>
	 * オーバーライド<br>
	 * ダメージ値によるアイコンの取得
	 * @see net.minecraft.item.Item#getIconFromDamage(int)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		if(this.iicons.length < meta) return null;
		return this.iicons[meta];
	}
	
	/**<h1>getSubItems</h1>
	 * オーバーライド<br>
	 * アイテムの登録
	 * @see net.minecraft.item.Item#getSubItems(net.minecraft.item.Item, net.minecraft.creativetab.CreativeTabs, java.util.List)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i = 0 ; i < this.iicons.length ; i ++) {
			list.add(new ItemStack(this,1,i));
		}
	}
	
	
	/**<h1>getMetadata</h1>
	 * オーバーライド<br>
	 * メタデータの取得
	 * @see net.minecraft.item.Item#getMetadata(int)
	 */
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	/**<h1>getUnlocalizedName</h1>
	 * オーバーライド
	 * @see net.minecraft.item.Item#getUnlocalizedName(net.minecraft.item.ItemStack)
	 */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
}
