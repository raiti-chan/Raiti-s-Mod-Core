package raiti.RaitisMod.Core;

import net.minecraftforge.common.config.Configuration;

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
	
}
