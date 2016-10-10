/*
 * 
 */
package raiti.RaitisMod.Core.tool;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

/** <h1>Tools</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class Tools {
	
	//==================================================================================================================
	
	public static ItemTool OreCrusheHammer = new OreCrusheHammer();
	
	//==================================================================================================================
	
	//-------------------------------------コンストラクター
	private Tools() {
		
		
		
	}
	
	/**
	 * <h1>addTool</h1>
	 * ツールを追加します<br>
	 */
	public static void addTool() {
		
		GameRegistry.registerItem(OreCrusheHammer, "OreCrushHammer");
		
		addCraftRecipe();
		addSmeltingRecipe();
		
	}
	
	/**
	 * <h1>addCraftRecipe</h1>
	 * クラフトレシピの登録<br>
	 */
	private static void addCraftRecipe() {
		GameRegistry.addRecipe(new ItemStack(OreCrusheHammer), " SN"," OS","O  ",'S',raiti.RaitisMod.Core.item.RItems.comstoneingot,'N',Items.nether_star,'O',Blocks.obsidian);
	}
	
	/**
	 * <h1>addSmeltingRecipe</h1>
	 * 精錬レシピの登録<br>
	 */
	private static void addSmeltingRecipe() {
		
	}
}
