/*
 * 
 */
package raiti.RaitisMod.Core.block;

import raiti.RaitisMod.API.Util.BlockUtil;
import raiti.RaitisMod.Core.item.RItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import raiti.RaitisMod.Core.item.blockItem.BlackHoleChestItem;

/** <h1>ManyBlock</h1>
 * 様々な通常ブロックを追加します<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
@SuppressWarnings("WeakerAccess")
public class Blocks {
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * 無効
	 */
	private Blocks() {
	}
	
	//==================================================================================================================
	
	public static final Block comstonebl = BlockUtil.CreatBlock("comstoneingotblock", "raitismod:comstone_block", CreativeTabs.tabBlock, Material.rock,25.0F,2000.0F,Block.soundTypeMetal,-1,-1.0F,"pickaxe",3);
	
	public static final Block dirtycoalblock = new DirtyIronBlock(net.minecraft.init.Items.coal,0,"Coal","coal");
	public static final Block dirtyironblock = new DirtyIronBlock(net.minecraft.init.Items.iron_ingot,0,"Iron","iron");
	public static final Block dirtygoldblock = new DirtyIronBlock(net.minecraft.init.Items.gold_ingot,0,"Gold","gold");
	public static final Block dirtyredstoneblock = new DirtyIronBlock(net.minecraft.init.Items.redstone,0,"Redstone","redstone");
	public static final Block dirtydiamondblock = new DirtyIronBlock(net.minecraft.init.Items.diamond,0,"Diamond","diamond");
	public static final Block dirtyEmeraldblock = new DirtyIronBlock(net.minecraft.init.Items.emerald,0,"Emerald","Emerald");
	public static final Block dirtylapisblock = new DirtyIronBlock(net.minecraft.init.Items.dye,4,"Lapislazuli","lapislazuli");
	
	public static final Block alotmorechest = new BlackHoleChestBlock();
	
	public static final Block testBlock = new TestBlock();
	
	//==================================================================================================================
	
	/**
	 * <h1>addBlock</h1>
	 * ブロックを追加します<br>
	 */
	public static void addBlock() {
		
		GameRegistry.registerBlock(comstonebl, "comstoneingotblock");

		GameRegistry.registerBlock(dirtycoalblock, "dirtycoalblock");
		GameRegistry.registerBlock(dirtyironblock, "dirtyironblock");
		GameRegistry.registerBlock(dirtygoldblock, "dirtygoldblock");
		GameRegistry.registerBlock(dirtyredstoneblock, "dirtyredstoneblock");
		GameRegistry.registerBlock(dirtydiamondblock, "dirtydiamondblock");
		GameRegistry.registerBlock(dirtyEmeraldblock, "dirtyemeraldblock");
		GameRegistry.registerBlock(dirtylapisblock, "dirtylapislazuliblock");
		
		GameRegistry.registerBlock(alotmorechest, BlackHoleChestItem.class, "alotmorechest");
		
		GameRegistry.registerBlock(testBlock, "testblock");
		
		addCraftRecipe();
		addSmeltingRecipe();
		
	}
	
	/**
	 * <h1>addCraftRecipe</h1>
	 * クラフトレシピの登録<br>
	 */
	private static void addCraftRecipe() {
		
		GameRegistry.addRecipe(new ItemStack(comstonebl),"iii","iii","iii",'i',RItems.comstoneingot);
		GameRegistry.addShapelessRecipe(new ItemStack(RItems.comstoneingot,9),comstonebl);
		
		GameRegistry.addRecipe(new ItemStack(dirtyironblock), "SSS","SIS","SSS",'S',comstonebl,'I',net.minecraft.init.Blocks.iron_block);
		
	}
	
	/**
	 * <h1>addSmeltingRecipe</h1>
	 * 精錬レシピの登録<br>
	 */
	private static void addSmeltingRecipe() {
		
	}
}
