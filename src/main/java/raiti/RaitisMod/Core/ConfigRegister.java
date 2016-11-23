package raiti.RaitisMod.Core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
	private final HashMap<BooleanMapKey, Boolean> BooleanMap = new HashMap<>();
	
	private final HashMap<IntegerMapKey, Integer> IntegerMap = new HashMap<>();
	
	/**
	 *
	 */
	private Property blackHoleChestRecipes = null;
	
	/**
	 * configの初期化
	 */
	public ConfigRegister() {
		Config = new Configuration(new File("config/Raitismod/Core.cfg"));
	}
	
	/**
	 * ファイルの読み込み
	 */
	public void load() {
		Config.load();
		
		for (BooleanMapKey key : BooleanMapKey.values()) {
			BooleanMap.put(key, Config.getBoolean(key.getName(), key.getGroupKey().toString(), key.getDefaultValue(), key.getComment()));
		}
		
		for (IntegerMapKey key : IntegerMapKey.values()) {
			IntegerMap.put(key, Config.getInt(key.getName(), key.getGroupKeys().toString(), key.getDefaultValue(), key.getMinValue(), key.getMaxValue(), key.getComment()));
		}
		
		String enderPearl = Item.itemRegistry.getNameForObject(Items.ender_pearl);
		String chest = Item.itemRegistry.getNameForObject(Item.getItemFromBlock(Blocks.chest));
		blackHoleChestRecipes = Config.get("Recipe", "BlackHoleChest", new String[]{
				enderPearl, enderPearl, enderPearl,
				enderPearl, chest, enderPearl,
				enderPearl, enderPearl, enderPearl}, "ブラックホールチェストのレシピ。アイテムの指定はMineTweaker 3と同じだけど、絶対に3×3(合計9)で何もないところはnullと書いてね");
		Config.save();
	}
	
	/**
	 * BooleanMapのデータをキーから取得
	 *
	 * @param key キー
	 * @return 値
	 */
	public boolean getBooleanMapData(BooleanMapKey key) {
		return BooleanMap.get(key);
	}
	
	/**
	 * IntegerMapのデータをキーから取得
	 *
	 * @param key キー
	 * @return 値
	 */
	public int getIntegerMapData(IntegerMapKey key) {
		return IntegerMap.get(key);
	}
	
	public Property getBlackHoleChestRecipes() {
		return blackHoleChestRecipes;
	}
	
	public enum BooleanMapKey {
		Cooperation_Avaritia(ConfigGroupKey.Cooperation, true, "Avaritiaと連携する?"),
		Cooperation_ProjectE(ConfigGroupKey.Cooperation, true, "ProjectEと連携する?");
		
		private final ConfigGroupKey GroupKey;
		private final boolean DefaultValue;
		private final String Comment;
		private final String name;
		
		BooleanMapKey(ConfigGroupKey groupKey, boolean defaultValue, String comment) {
			this.GroupKey = groupKey;
			this.DefaultValue = defaultValue;
			this.Comment = comment;
			this.name = super.toString().split("_",2)[1];
		}
		
		public ConfigGroupKey getGroupKey() {
			return GroupKey;
		}
		
		public String getComment() {
			return Comment;
		}
		
		public boolean getDefaultValue() {
			return DefaultValue;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public enum IntegerMapKey {
		BlackHoleChest_MaxVirtualSlot(ConfigGroupKey.BlackHoleChest, 64, 1, 10000, "ブラックホールチェストの仮想スロット最大数。推奨64")
		;
		
		private final ConfigGroupKey GroupKeys;
		private final int DefaultValue;
		private final int MinValue;
		private final int MaxValue;
		private final String Comment;
		private final String name;
		
		IntegerMapKey(ConfigGroupKey groupKeys, int defaultValue, int minValue, int maxValue, String comment){
			this.GroupKeys = groupKeys;
			this.DefaultValue = defaultValue;
			this.MinValue = minValue;
			this.MaxValue = maxValue;
			this.Comment = comment;
			this.name = super.toString().split("_",2)[1];
		}
		
		public ConfigGroupKey getGroupKeys() {
			return GroupKeys;
		}
		
		public int getDefaultValue() {
			return DefaultValue;
		}
		
		public int getMinValue() {
			return MinValue;
		}
		
		public int getMaxValue() {
			return MaxValue;
		}
		
		public String getComment() {
			return Comment;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public enum ConfigGroupKey {
		Cooperation,
		BlackHoleChest,
	}
	
}
