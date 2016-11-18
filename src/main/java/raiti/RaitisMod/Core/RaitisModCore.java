/*
 * 
 */
package raiti.RaitisMod.Core;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.item.ItemStack;
import raiti.RaitisMod.Core.Block.RBlockRegister;
import raiti.RaitisMod.Core.Client.Gui.GuiHandler;
import raiti.RaitisMod.Core.Item.RItemRegister;
import raiti.RaitisMod.Core.Recipe.RecipeRegister;
import raiti.RaitisMod.Core.Util.OreDictionaryRegister;
import raiti.RaitisMod.Factory.FactoryRegister;


/**
 * Raiti'sMODのコアクラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RaitisModCore {
	
	/**
	 * コンフィグ
	 */
	@SuppressWarnings("WeakerAccess")
	public static ConfigRegister CONFIG = new ConfigRegister();
	
	
	static void preinit(FMLPreInitializationEvent event) {
		CONFIG = new ConfigRegister();
		CONFIG.load();
		RItemRegister.initItemRegister();
		RBlockRegister.initRegister();
		FactoryRegister.RegisterPerInit(event);
		OreDictionaryRegister.OreDictionaryRegisterPreInit(event);
		System.out.println(Loader.isModLoaded("Avaritia"));
	}
	
	static void init(FMLInitializationEvent event){
		RecipeRegister.registeringRecipe();
		NetworkRegistry.INSTANCE.registerGuiHandler(RaitisModCoreMain.INSTANCE, new GuiHandler());
		RaitisModCoreMain.PROXY.registerTileEntity();
		RaitisModCoreMain.PROXY.registerTileEntitySpecialRenderer();
		FactoryRegister.RegisterInti(event);
	}
	
	static void posInit(FMLPostInitializationEvent event){
		
		if(CONFIG.getBooleanMapData("ProjectE") && Loader.isModLoaded("ProjectE")){
			GameRegistry.addShapelessRecipe(new ItemStack(RItemRegister.EMC,1,0), net.minecraft.init.Blocks.cobblestone, ObjHandler.philosStone);
		}
		
		FactoryRegister.RegisterPosInit(event);
		
	}
	
	
	
}
