/*
 * 
 */
package raiti.RaitisMod.Core.Block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import raiti.RaitisMod.Core.Item.BlockItem.SimpleMetaItemBlock;
import raiti.RaitisMod.Core.Util.Annotations.ItemBlockClass;
import raiti.RaitisMod.Core.Util.Annotations.NonRegister;
import raiti.RaitisMod.Core.Util.BlockUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import raiti.RaitisMod.Core.Item.BlockItem.BlackHoleChestItem;

import java.lang.reflect.Field;

/**
 * ブロックレジスター
 * Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RBlockRegister {
	private RBlockRegister() {
	}
	
	//==================================================================================================================
	public static final RBlock comstonebl = BlockUtil.createBlock("CompressedStoneIngotBlock", "compressed_stone_ingot_block", CreativeTabs.tabBlock, Material.rock, 25.0F, 2000.0F, Block.soundTypeMetal, -1, -1.0F, "pickaxe", 3);
	
	private static final ItemStack[] DIRTY_ORE_BLOCK_DROP_ITEMS = {new ItemStack(Items.coal),
			new ItemStack(Items.iron_ingot), new ItemStack(Items.gold_ingot), new ItemStack(Items.redstone),
			new ItemStack(Items.diamond), new ItemStack(Items.emerald), new ItemStack(Items.dye, 1, 4), new ItemStack(Items.quartz)};
	@ItemBlockClass(SimpleMetaItemBlock.class)
	public static final RBlock dirtyOreBlock = new DirtyOreBlock(DIRTY_ORE_BLOCK_DROP_ITEMS, "DirtyOreBlock", "dirty_ore_block");
	
	public static final RBlock SolidWaterBlock = new SolidWaterBlock();
	
	@ItemBlockClass(BlackHoleChestItem.class)
	public static final RBlockContainer alotmorechest = new BlackHoleChestBlock();
	
	
	//==================================================================================================================
	
	/**
	 * レジスターを初期化します。
	 */
	public static void initRegister() {
		Class<RBlockRegister> blockRegisterClass = RBlockRegister.class;
		Field[] fields = blockRegisterClass.getFields();
		for (Field field : fields) {
			try {
				Object o = field.get(null);
				if (o instanceof IRBlock && field.getAnnotation(NonRegister.class) == null) {
					ItemBlockClass annotation = field.getAnnotation(ItemBlockClass.class);
					if (annotation == null) {
						GameRegistry.registerBlock((Block) o, ((IRBlock) o).getRItemName());
					} else {
						GameRegistry.registerBlock((Block) o, annotation.value(), ((IRBlock) o).getRItemName());
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
