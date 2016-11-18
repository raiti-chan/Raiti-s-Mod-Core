/*
 * 
 */
package raiti.RaitisMod.Core.Item.Tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import raiti.RaitisMod.Core.Item.RItem;

/**
 * らいちちゃんの魔法の杖 (未実装)
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RaitiWand extends RItem {
	
	public RaitiWand() {
		setUnlocalizedName("RaitiWand");
		setTextureName("raitismod:raitiwand");
		setMaxStackSize(1);
		setFull3D();
		setNoRepair();
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
		// TODO 自動生成されたメソッド・スタブ
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
	
}
