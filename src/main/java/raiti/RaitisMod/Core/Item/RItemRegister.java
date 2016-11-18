package raiti.RaitisMod.Core.Item;

import net.minecraft.item.Item;
import raiti.RaitisMod.Core.Item.Tool.OreCrusheHammer;
import raiti.RaitisMod.Core.Item.Tool.RItemTool;
import raiti.RaitisMod.Core.Util.Annotations.NonRegister;
import raiti.RaitisMod.Core.Util.ItemUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;

import java.lang.reflect.Field;

/**
 * アイテムレジスター
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RItemRegister {
	private RItemRegister() {
	}
	
	//==================================================================================================================
	public static final RItem Compressed_stone = new CompressedStone();
	public static RItem Compressed_stone_ingot = ItemUtil.createItem("CompressedStoneIngot", "compressed_stone_ingot", CreativeTabs.tabMaterials);
	public static RItem EMC = new EMCItems();
	public static RItemTool OreCrusheHammer = new OreCrusheHammer();
	
	
	//==================================================================================================================
	
	/**
	 * レジスターを初期化します。
	 */
	public static void initItemRegister() {
		Class<RItemRegister> itemRegisterClass = RItemRegister.class;
		Field[] fields = itemRegisterClass.getFields();
		for (Field field : fields) {
			try {
				Object o = field.get(null);
				if (o instanceof IRItem && field.getAnnotation(NonRegister.class) == null) {
					GameRegistry.registerItem((Item) o, ((IRItem) o).getRItemName());
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
