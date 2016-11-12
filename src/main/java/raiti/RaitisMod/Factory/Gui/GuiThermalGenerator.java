package raiti.RaitisMod.Factory.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import raiti.RaitisMod.Factory.Gui.Container.ContainerThermalGenerator;

/**
 * Created by Raiti on 2016/10/10.
 */
public class GuiThermalGenerator  extends GuiContainer{
	
	private static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation("raitismod","textures/gui/GuiThermalGenerator.png");
	
	
	
	public GuiThermalGenerator() {
		super(new ContainerThermalGenerator(null,null));
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		
	}
}
