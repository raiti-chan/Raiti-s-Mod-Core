package raiti.RaitisMod.Core.Item;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * まな板の元素材
 * <br>Created by Raiti-chan on 2016/12/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class CuttingBoardBase extends  SimpleMetaItem{
	
	/**
	 * コンストラクタ
	 */
	public CuttingBoardBase() {
		super(4);
		this.setUnlocalizedName("CuttingBoardBase");
		this.setTextureName("cutting_board_base");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	/**
	 * エフェクトを出す場合trueを返す
	 * @param itemStack アイテム
	 * @param pass 数値
	 * @return エフェクトをかける場合true
	 */
	@Override
	public boolean hasEffect(ItemStack itemStack, int pass) {
		return !(itemStack.getItemDamage() == 0);
	}
}
