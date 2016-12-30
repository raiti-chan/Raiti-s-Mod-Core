package raiti.RaitisMod.Core.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * <br>Created by Raiti-chan on 2016/12/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class CuttingBoardContainer extends ContainerWorkbench {
	
	@SuppressWarnings("unchecked")
	public CuttingBoardContainer(InventoryPlayer inventoryPlayer, World world, int x, int y, int z) {
		super(inventoryPlayer, world, x, y, z);
		this.craftResult = new InventoryCuttingResult();
		Slot slot = new SlotCrafting(inventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35);
		slot.slotNumber = 0;
		this.inventorySlots.remove(0);
		this.inventorySlots.add(0, slot);
		this.inventoryItemStacks.remove(0);
		this.inventoryItemStacks.add(0,null);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}
	
	public static class InventoryCuttingResult extends InventoryCraftResult {
		@Override
		public void setInventorySlotContents(int index, ItemStack itemStack) {
			if (itemStack != null) {
				itemStack.stackSize = itemStack.stackSize * 64;
			}
			super.setInventorySlotContents(index, itemStack);
		}
		
		@Override
		public int getInventoryStackLimit() {
			return Integer.MAX_VALUE;
		}
	}
	
}


