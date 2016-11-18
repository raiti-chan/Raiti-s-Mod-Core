package raiti.RaitisMod.Core.Item.Tool;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/**
 * ツールマテリアルEnum定数
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public enum RToolMaterial {
	WOOD(ToolMaterial.WOOD),
	STONE(ToolMaterial.STONE),
	IRON(ToolMaterial.IRON),
	GOLD(ToolMaterial.GOLD),
	DIAMOND(ToolMaterial.EMERALD),
	COMPRESSED_STONE(2, 250, 6.0F, 2.0F, 14),
	ORE_CRUSHE_HAMMER(3, 15, 10.0F, 100, 22),;
	
	/**
	 * 内部的に保持している{@link ToolMaterial}
	 */
	private final ToolMaterial material;
	
	/**
	 * 既に定められている{@link ToolMaterial}を利用して定数を作成します。
	 * @param material 既に定められたToolMaterial
	 */
	RToolMaterial(ToolMaterial material) {
		this.material = material;
	}
	
	/**
	 * 新規{@link ToolMaterial}を生成して定数を作成します。
	 * @param harvestLevel 採掘レベル
	 * @param maxUses 最大耐久値
	 * @param efficiency 採掘速度
	 * @param damage ダメージ指数
	 * @param enchantAbility エンチャント
	 */
	RToolMaterial(int harvestLevel, int maxUses, float efficiency, float damage, int enchantAbility) {
		this.material = EnumHelper.addToolMaterial(this.toString(), harvestLevel, maxUses, efficiency, damage, enchantAbility);
	}
	
	/**
	 * 内部的に保持している{@link ToolMaterial}を取得します。
	 * @return 保持しているツールマテリアル。
	 */
	public ToolMaterial getMaterial() {
		return this.material;
	}
	
}
