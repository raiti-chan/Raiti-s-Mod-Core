package raiti.RaitisMod.Core.Recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import raiti.RaitisMod.Core.Block.RBlockRegister;
import raiti.RaitisMod.Core.Item.RItemRegister;
import raiti.RaitisMod.Core.RaitisModCore;

/**
 * レシピレジスター
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RecipeRegister {
	
	public RecipeRegister() {
	}
	
	//==================================================================================================================
	public static void registeringRecipe() {
		//=圧縮ストーン=================================================================================================
		GameRegistry.addRecipe(new ItemStack(RItemRegister.Compressed_stone, 1, 0), "SSS", "SDS", "SSS", 'S', Blocks.cobblestone, 'D', Blocks.dirt);
		GameRegistry.addRecipe(new ItemStack(RItemRegister.Compressed_stone, 1, 1), "SSS", "SDS", "SSS", 'S', new ItemStack(RItemRegister.Compressed_stone, 1, 0), 'D', Blocks.dirt);
		GameRegistry.addSmelting(new ItemStack(RItemRegister.Compressed_stone, 1, 1), new ItemStack(RItemRegister.Compressed_stone_ingot), 1F);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.comstonebl), "iii", "iii", "iii", 'i', RItemRegister.Compressed_stone_ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.Compressed_stone_ingot, 9), RBlockRegister.comstonebl);
		
		//=鉱石粉砕ハンマー=============================================================================================
		GameRegistry.addRecipe(new ItemStack(RItemRegister.OreCrusheHammer), " SN", " OS", "O  ", 'S', RItemRegister.Compressed_stone_ingot, 'N', Items.nether_star, 'O', Blocks.obsidian);
		//=汚れた鉱石ブロック================================================================================================================
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 0), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.coal_block);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 1), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.iron_block);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 2), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.gold_block);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 3), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.redstone_block);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 4), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.diamond_block);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 5), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.emerald_block);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 6), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.lapis_block);
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.dirtyOreBlock, 1, 7), "SSS", "SIS", "SSS", 'S', RBlockRegister.comstonebl, 'I', Blocks.quartz_block);
		//=固形水源================================================================================================================
		GameRegistry.addRecipe(new ItemStack(RBlockRegister.SolidWaterBlock), "GGG", "GWG", "GGG", 'G', Blocks.glass, 'W', Items.water_bucket);
		//=固形EMC======================================================================================================
		addEmcItemRecipes();
		
		//=ブラックホールチェストのレシピ================================================================================================================
		{
			ItemStack[] itemStacks = new ItemStack[9];
			String itemName;
			boolean flag = false;
			for (int i = 0; i < itemStacks.length; i++) {
				itemName = RaitisModCore.CONFIG.getBlackHoleChestRecipes().getStringList()[i];
				Item item;
				if (itemName.equals("null")) item = null;
				else item = (Item) Item.itemRegistry.getObject(itemName);
				itemStacks[i] = new ItemStack(item);
				if (item != null) flag = true;
			}
			ShapedRecipes blackHoleChestRecipes = new ShapedRecipes(3, 3, itemStacks, new ItemStack(RBlockRegister.alotmorechest));
			if (flag) GameRegistry.addRecipe(blackHoleChestRecipes);
		}
	}
	
	
	/**
	 * 固形EMCのレシピ登録
	 */
	private static void addEmcItemRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 1), new ItemStack(RItemRegister.EMC, 1, 0), new ItemStack(RItemRegister.EMC, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 2), new ItemStack(RItemRegister.EMC, 1, 1), new ItemStack(RItemRegister.EMC, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 3), new ItemStack(RItemRegister.EMC, 1, 2), new ItemStack(RItemRegister.EMC, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 4), new ItemStack(RItemRegister.EMC, 1, 3), new ItemStack(RItemRegister.EMC, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 5), new ItemStack(RItemRegister.EMC, 1, 4), new ItemStack(RItemRegister.EMC, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 6), new ItemStack(RItemRegister.EMC, 1, 5), new ItemStack(RItemRegister.EMC, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 7), new ItemStack(RItemRegister.EMC, 1, 6), new ItemStack(RItemRegister.EMC, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 8), new ItemStack(RItemRegister.EMC, 1, 7), new ItemStack(RItemRegister.EMC, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 9), new ItemStack(RItemRegister.EMC, 1, 8), new ItemStack(RItemRegister.EMC, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 10), new ItemStack(RItemRegister.EMC, 1, 9), new ItemStack(RItemRegister.EMC, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 11), new ItemStack(RItemRegister.EMC, 1, 10), new ItemStack(RItemRegister.EMC, 1, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 12), new ItemStack(RItemRegister.EMC, 1, 11), new ItemStack(RItemRegister.EMC, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 13), new ItemStack(RItemRegister.EMC, 1, 12), new ItemStack(RItemRegister.EMC, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 14), new ItemStack(RItemRegister.EMC, 1, 13), new ItemStack(RItemRegister.EMC, 1, 13));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 15), new ItemStack(RItemRegister.EMC, 1, 14), new ItemStack(RItemRegister.EMC, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 16), new ItemStack(RItemRegister.EMC, 1, 15), new ItemStack(RItemRegister.EMC, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 17), new ItemStack(RItemRegister.EMC, 1, 16), new ItemStack(RItemRegister.EMC, 1, 16));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 18), new ItemStack(RItemRegister.EMC, 1, 17), new ItemStack(RItemRegister.EMC, 1, 17));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 19), new ItemStack(RItemRegister.EMC, 1, 18), new ItemStack(RItemRegister.EMC, 1, 18));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 1, 20), new ItemStack(RItemRegister.EMC, 1, 19), new ItemStack(RItemRegister.EMC, 1, 19));
		
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 0), new ItemStack(RItemRegister.EMC, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 1), new ItemStack(RItemRegister.EMC, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 2), new ItemStack(RItemRegister.EMC, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 3), new ItemStack(RItemRegister.EMC, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 4), new ItemStack(RItemRegister.EMC, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 5), new ItemStack(RItemRegister.EMC, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 6), new ItemStack(RItemRegister.EMC, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 7), new ItemStack(RItemRegister.EMC, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 8), new ItemStack(RItemRegister.EMC, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 9), new ItemStack(RItemRegister.EMC, 1, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 10), new ItemStack(RItemRegister.EMC, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 11), new ItemStack(RItemRegister.EMC, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 12), new ItemStack(RItemRegister.EMC, 1, 13));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 13), new ItemStack(RItemRegister.EMC, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 14), new ItemStack(RItemRegister.EMC, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 15), new ItemStack(RItemRegister.EMC, 1, 16));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 16), new ItemStack(RItemRegister.EMC, 1, 17));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 17), new ItemStack(RItemRegister.EMC, 1, 18));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 18), new ItemStack(RItemRegister.EMC, 1, 19));
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC, 2, 19), new ItemStack(RItemRegister.EMC, 1, 20));
	}
	
	//==================================================================================================================
	public static void registeringCooperationProjectERecipe() {
		GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC,1,0), net.minecraft.init.Blocks.cobblestone, ObjHandler.philosStone);
	}
	
}
