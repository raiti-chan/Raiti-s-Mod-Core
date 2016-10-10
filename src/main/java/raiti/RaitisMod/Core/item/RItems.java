/*
 * 
 */
package raiti.RaitisMod.Core.item;

import raiti.RaitisMod.API.Util.ItemUtil;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/** <h1>ManyItem</h1>
 * 様々な基本アイテムを追加します<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class RItems {
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * 無効
	 */
	private RItems() {
	}
	
	//==================================================================================================================
	
	/**
	 * 8,64倍圧縮ストーン
	 */
	public static Item comst = new Compressedstone();

	/**
	 * 圧縮ストーンインゴット
	 */
	public static Item comstoneingot = ItemUtil.CreatItem("comstoneingot", "raitismod:comstoneingot", CreativeTabs.tabMaterials);
	
	/**
	 * EmcItems1B～1024MB
	 */
	public static Item emc = new EMCItems();
	
	
	//==================================================================================================================
	
	/**
	 * <h1>addItem</h1>
	 * アイテムを追加します<br>
	 */
	public static void addItem() {
		
		GameRegistry.registerItem(comst, "comstone");
		GameRegistry.registerItem(emc, "emc");
		GameRegistry.registerItem(comstoneingot, "comstoneingot");
		
		
		
		
		
		
		addCraftRecipe();
		addSmeltingRecipe();
		
	}
	
	/**
	 * <h1>addCraftRecipe</h1>
	 * クラフトレシピの登録<br>
	 */
	private static void addCraftRecipe() {
		GameRegistry.addRecipe(new ItemStack(comst,1,0), "SSS","SDS","SSS",'S',Blocks.cobblestone,'D',Blocks.dirt);
		GameRegistry.addRecipe(new ItemStack(comst,1,1), "SSS","SDS","SSS",'S',new ItemStack(comst,1,0),'D',Blocks.dirt);
		
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,1), new ItemStack(emc,1,0), new ItemStack(emc,1,0));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,2), new ItemStack(emc,1,1), new ItemStack(emc,1,1));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,3), new ItemStack(emc,1,2), new ItemStack(emc,1,2));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,4), new ItemStack(emc,1,3), new ItemStack(emc,1,3));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,5), new ItemStack(emc,1,4), new ItemStack(emc,1,4));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,6), new ItemStack(emc,1,5), new ItemStack(emc,1,5));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,7), new ItemStack(emc,1,6), new ItemStack(emc,1,6));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,8), new ItemStack(emc,1,7), new ItemStack(emc,1,7));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,9), new ItemStack(emc,1,8), new ItemStack(emc,1,8));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,10), new ItemStack(emc,1,9), new ItemStack(emc,1,9));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,11), new ItemStack(emc,1,10), new ItemStack(emc,1,10));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,12), new ItemStack(emc,1,11), new ItemStack(emc,1,11));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,13), new ItemStack(emc,1,12), new ItemStack(emc,1,12));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,14), new ItemStack(emc,1,13), new ItemStack(emc,1,13));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,15), new ItemStack(emc,1,14), new ItemStack(emc,1,14));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,16), new ItemStack(emc,1,15), new ItemStack(emc,1,15));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,17), new ItemStack(emc,1,16), new ItemStack(emc,1,16));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,18), new ItemStack(emc,1,17), new ItemStack(emc,1,17));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,19), new ItemStack(emc,1,18), new ItemStack(emc,1,18));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,20), new ItemStack(emc,1,19), new ItemStack(emc,1,19));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,1,21), new ItemStack(emc,1,20), new ItemStack(emc,1,20));
		
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,0), new ItemStack(emc,1,1));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,1), new ItemStack(emc,1,2));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,2), new ItemStack(emc,1,3));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,3), new ItemStack(emc,1,4));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,4), new ItemStack(emc,1,5));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,5), new ItemStack(emc,1,6));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,6), new ItemStack(emc,1,7));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,7), new ItemStack(emc,1,8));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,8), new ItemStack(emc,1,9));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,9), new ItemStack(emc,1,10));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,10), new ItemStack(emc,1,11));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,11), new ItemStack(emc,1,12));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,12), new ItemStack(emc,1,13));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,13), new ItemStack(emc,1,14));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,14), new ItemStack(emc,1,15));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,15), new ItemStack(emc,1,16));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,16), new ItemStack(emc,1,17));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,17), new ItemStack(emc,1,18));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,18), new ItemStack(emc,1,19));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,19), new ItemStack(emc,1,20));
		GameRegistry.addShapelessRecipe(new ItemStack(emc,2,20), new ItemStack(emc,1,21));
		
		
	}
	
	/**
	 * <h1>addSmeltingRecipe</h1>
	 * 精錬レシピの登録<br>
	 */
	private static void addSmeltingRecipe() {
		GameRegistry.addSmelting(new ItemStack(comst,1,1), new ItemStack(comstoneingot), 1F);
	}
	
	
	
}
