package raiti.RaitisMod.Core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.HashMap;

/**
 * Raiti'sModのConfig管理クラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class ConfigRegister {
	
	/**
	 * メインコンフィグファイル
	 */
	private Configuration Config;
	
	/**
	 * Booleanの値のコンフィグマップ
	 */
	private final HashMap<String,Boolean> BooleanMap = new HashMap<>();
	
	/**
	 *
	 */
	private Property blackHoleChestRecipes = null;
	
	/**
	 *configの初期化
	 */
	public ConfigRegister(){
		Config = new Configuration(new File("config/Raitismod/Core.cfg"));
	}
	
	/**
	 * ファイルの読み込み
	 */
	public void load(){
		Config.load();

		BooleanMap.put("CoopAvaritia",Config.getBoolean("Avaritia","Cooperation",true,"Avaritiaと連携する？"));
		BooleanMap.put("ProjectE",Config.getBoolean("ProjectE","Cooperation",true,"ProjectEと連携する？"));
		String enderPearl = Item.itemRegistry.getNameForObject(Items.ender_pearl);
		String chest = Item.itemRegistry.getNameForObject(Item.getItemFromBlock(Blocks.chest));
		blackHoleChestRecipes = Config.get("Recipe","BlackHoleChest",new String[] {
				enderPearl,enderPearl,enderPearl,
				enderPearl,chest,enderPearl,
				enderPearl,enderPearl,enderPearl}, "ブラックホールチェストのレシピ。アイテムの指定はMineTweaker 3と同じだけど、絶対に3×3(合計9)で何もないところはnullと書いてね");
		Config.save();
	}
	
	/**
	 * BooleanMapのデータをキーから取得
	 * @param key キー
	 * @return 値
	 */
	public boolean getBooleanMapData(String key){
		return BooleanMap.get(key);
	}
	
	public Property getBlackHoleChestRecipes() {
		return blackHoleChestRecipes;
	}
}
