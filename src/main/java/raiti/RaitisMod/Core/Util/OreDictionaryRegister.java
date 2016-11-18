package raiti.RaitisMod.Core.Util;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import raiti.RaitisMod.Core.Item.RItemRegister;

import java.util.ArrayList;

/**
 * 鉱石辞書のEnum定数
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public enum OreDictionaryRegister {
	stickWood,
	ingotIron,
	CompressedStoneIngot(new ItemStack(RItemRegister.Compressed_stone_ingot)),;
	
	/**
	 * この鉱石辞書に登録されているアイテム配列
	 */
	private ItemStack[] stacks;
	
	/**
	 * このMODでは追加しないが、参照はする場合の登録の場合true
	 */
	private boolean useOnly = false;
	
	/**
	 * enumの登録
	 *
	 * @param itemStack 追加するItemStack配列
	 */
	@SuppressWarnings("unused")
	OreDictionaryRegister(ItemStack... itemStack) {
		this.stacks = itemStack;
	}
	
	/**
	 * 既存鉱石辞書を表現するために使用
	 */
	OreDictionaryRegister() {
		ArrayList<ItemStack> stackList = OreDictionary.getOres(this.toString());
		stacks = new ItemStack[stackList.size()];
		int i = 0;
		for (ItemStack stack : stackList) {
			stacks[i++] = stack;
		}
		this.useOnly = true;
	}
	
	/**
	 * ItemStack配列を取得
	 *
	 * @return ItemStack配列
	 */
	public ItemStack[] getStacks() {
		return stacks;
	}
	
	
	/**
	 * 鉱石辞書登録関数
	 *
	 * @param event FMLイベント
	 */
	public static void OreDictionaryRegisterPreInit(FMLPreInitializationEvent event) {
		//鉱石辞書登録
		for (OreDictionaryRegister element : OreDictionaryRegister.values()) {
			if (element.getStacks() == null || element.useOnly) continue;
			for (ItemStack stack : element.getStacks()) {
				if (stack == null) continue;
				OreDictionary.registerOre(element.toString(), stack);
			}
			
		}
		
		
	}
}
