package raiti.RaitisMod.Core;

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.HashMap;

/**
 * Created by Raiti on 2016/10/10.
 */
public class ConfigRegister {
	
	private Configuration Config;
	
	private final HashMap<String,Boolean> BooleanMap = new HashMap<>();
	
	private boolean coopAva = true;
	private boolean coopProE = true;
	
	public ConfigRegister(){
		Config = new Configuration(new File("config/Raitismod/CoreMain.cfg"));
	}
	
	public void load(){
		Config.load();

		BooleanMap.put("CoopAvaritia",Config.getBoolean("Avaritia","Cooperation",true,"Avaritiaと連携する？"));
		BooleanMap.put("ProjectE",Config.getBoolean("ProjectE","Cooperation",true,"ProjectEと連携する？"));
		
		Config.save();
	}
	
	public boolean getBooleanMapData(String key){
		return BooleanMap.get(key);
	}
	
}
