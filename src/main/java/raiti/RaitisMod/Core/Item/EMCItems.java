/*
 * 
 */
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
 * 固形EMC
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class EMCItems extends RItem {
	
	private IIcon[] iicons = new IIcon[21];
	
	public EMCItems() {
		super();
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("EMC");
		this.setTextureName("emc");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iicon) {
		for(int i = 0 ; i < this.iicons.length ; i++) {
			this.iicons[i] = iicon.registerIcon(this.getIconString() +"_"+i);
		}
	}
	
	

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta) {
		if(this.iicons.length < meta) return null;
		return this.iicons[meta];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i = 0 ; i < this.iicons.length ; i ++) {
			list.add(new ItemStack(this,1,i));
		}
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
}
