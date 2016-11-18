/*
 * 
 */
package raiti.RaitisMod.Core.Block;

import net.minecraft.item.Item;
import raiti.RaitisMod.Core.Item.IRItem;
import raiti.RaitisMod.Core.Util.Annotations.ItemBlockClass;
import raiti.RaitisMod.Core.Util.Annotations.NonRegister;
import raiti.RaitisMod.Core.Util.BlockUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import raiti.RaitisMod.Core.Item.BlockItem.BlackHoleChestItem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ブロックレジスター
 * Created by Raiti-chan on 2016/11/18.
 * @author Raiti-chan
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RBlockRegister {
	private RBlockRegister() {}
	//==================================================================================================================
	public static final RBlock comstonebl = BlockUtil.createBlock("CompressedStoneIngotBlock", "compressed_stone_ingot_block", CreativeTabs.tabBlock, Material.rock,25.0F,2000.0F,Block.soundTypeMetal,-1,-1.0F,"pickaxe",3);
	
	public static final RBlock dirtycoalblock = new DirtyIronBlock(net.minecraft.init.Items.coal,0,"Coal","coal");
	public static final RBlock dirtyironblock = new DirtyIronBlock(net.minecraft.init.Items.iron_ingot,0,"Iron","iron");
	public static final RBlock dirtygoldblock = new DirtyIronBlock(net.minecraft.init.Items.gold_ingot,0,"Gold","gold");
	public static final RBlock dirtyredstoneblock = new DirtyIronBlock(net.minecraft.init.Items.redstone,0,"Redstone","redstone");
	public static final RBlock dirtydiamondblock = new DirtyIronBlock(net.minecraft.init.Items.diamond,0,"Diamond","diamond");
	public static final RBlock dirtyEmeraldblock = new DirtyIronBlock(net.minecraft.init.Items.emerald,0,"Emerald","Emerald");
	public static final RBlock dirtylapisblock = new DirtyIronBlock(net.minecraft.init.Items.dye,4,"Lapislazuli","lapislazuli");
	
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
