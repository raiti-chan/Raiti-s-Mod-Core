/*
 * 
 */
package raiti.RaitisMod.Core.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/** <h1>RaitiWand</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class RaitiWand extends Item{
	//-------------------------------------コンストラクター
	public RaitiWand() {
		setUnlocalizedName("RaitiWand");
		setTextureName("raitismod:raitiwand");
		setMaxStackSize(1);
		setFull3D();
		setNoRepair();
	}
	
	/**<h1>onItemRightClick</h1>
	 * オーバーライド
	 * @see net.minecraft.item.Item#onItemRightClick(net.minecraft.item.ItemStack, net.minecraft.world.World, net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
		// TODO 自動生成されたメソッド・スタブ
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
	
}
