package raiti.RaitisMod.Factory;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import raiti.RaitisMod.Factory.Block.ThermalGenerator;

/**
 * Created by Raiti on 2016/10/10.
 */
public class FactoryRegister {
	
	public static final CreativeTabs FACTORY_TAB = new CreativeTabs("raiti_factory"){
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.beacon);
		}
	};
	
	
//アイテム==============================================================================================================
	
//ブロック==============================================================================================================
	public static ThermalGenerator thermal_generator = new ThermalGenerator();
	
	
	public static void RegisterPerInit(FMLPreInitializationEvent event){
		GameRegistry.registerBlock(thermal_generator,"thermal_generator");
	}
	
	public static void RegisterInti(FMLInitializationEvent event){
		
	}
	
	public static void RegisterPosInit(FMLPostInitializationEvent event){
		
	}
}
