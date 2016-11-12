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
import raiti.RaitisMod.API.Util.BlockUtil;
import raiti.RaitisMod.Core.block.Blocks;
import raiti.RaitisMod.Core.gui.GuiHandler;
import raiti.RaitisMod.Core.item.RItems;
import raiti.RaitisMod.Core.tool.Tools;
import raiti.RaitisMod.Factory.FactoryRegister;


/** <h1>RaitisModCore</h1>
 * modのメインクラス<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class RaitisModCore {
	
	@SuppressWarnings("WeakerAccess")
	public static ConfigRegister CONFIG = new ConfigRegister();
	
	static void preinit(FMLPreInitializationEvent event) {
		CONFIG = new ConfigRegister();
		CONFIG.load();
		RItems.addItem();
		Blocks.addBlock();
		Tools.addTool();
		FactoryRegister.RegisterPerInit(event);
		System.out.println(Loader.isModLoaded("Avaritia"));
	}
	
	static void init(FMLInitializationEvent event){
		
		NetworkRegistry.INSTANCE.registerGuiHandler(RaitisModCoreMain.INSTANCE, new GuiHandler());
		RaitisModCoreMain.PROXY.registerTileEntity();
		FactoryRegister.RegisterInti(event);
	}
	
	static void posInit(FMLPostInitializationEvent event){
		
		if(CONFIG.getBooleanMapData("ProjectE") && Loader.isModLoaded("ProjectE")){
			GameRegistry.addShapelessRecipe(new ItemStack(RItems.emc,1,0), net.minecraft.init.Blocks.cobblestone, ObjHandler.philosStone);
		}
		
		FactoryRegister.RegisterPosInit(event);
		
	}
	
	
	
}
