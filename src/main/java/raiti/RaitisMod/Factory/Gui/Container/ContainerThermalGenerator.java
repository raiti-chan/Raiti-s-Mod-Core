package raiti.RaitisMod.Factory.Gui.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import raiti.RaitisMod.Factory.TileEntity.TileEntityThermalGenerator;

/**
 * Created by Raiti on 2016/10/10.
 */
public class ContainerThermalGenerator extends Container {
	
	private InventoryPlayer PlayerInventory;
	private TileEntityThermalGenerator thermalGenerator;
	
	public ContainerThermalGenerator(InventoryPlayer playerInventory, TileEntityThermalGenerator thermalGenerator){
		this.PlayerInventory = playerInventory;
		this.thermalGenerator = thermalGenerator;
		
		this.addSlotToContainer(new Slot(thermalGenerator,));
		
		for (int y = 0; y < 3; y++){
			for (int x = 0; y < 9; x++){
				this.addSlotToContainer(new Slot(playerInventory, x+y*9+8, 8+x*18, 84+y*18));
			}
		}
		
		for (int x = 0; x < 9; x++){
			this.addSlotToContainer(new Slot(playerInventory,x,8+x*18,142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}
}
