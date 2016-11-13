/*
 * 
 */
package raiti.RaitisMod.Core.container;

import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * <h1>BlackHallChestContainer</h1>
 * <br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class BlackHallChestContainer extends Container {
	
	
	private BlackHoleChestTile chest;
	@SuppressWarnings("FieldCanBeLocal")
	private InventoryPlayer playerInventry;
	
	
	public BlackHallChestContainer(IInventory plaInv, IInventory tileInv) {
		this.chest = (BlackHoleChestTile) tileInv;
		chest.setContainer(this);
		this.playerInventry = (InventoryPlayer) plaInv;
		
		this.addSlotToContainer(new AlotmoreChestSlot(this.chest, 0, 124, 35, false, false));
		this.addSlotToContainer(new AlotmoreChestSlot(this.chest, 1, 8, 38, true, false));
		this.addSlotToContainer(new AlotmoreChestSlot(this.chest, 2, 44, 38, false, true));
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(this.playerInventry, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		for (int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(this.playerInventry, x, 8 + x * 18, 142));
		}
	}
	
	/**
	 * <h1>transferStackInSlot</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.Container#transferStackInSlot(net.minecraft.entity.player.EntityPlayer, int)
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack stack = null;
		Slot slot = (Slot) this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack slotItem = slot.getStack();
			stack = slotItem.copy();
			if (index > 2) { //インベントリ
				Slot inSlot = (Slot) this.inventorySlots.get(1);
				if (chest.getItemType() == null || (stack.stackSize + chest.getSize() <= chest.getMaxSize() && stack.stackSize + chest.getSize() > -1 && chest.getItemType().isItemEqual(stack))) {
					slotItem.stackSize = 0;
					inSlot.putStack(stack);
					inSlot.onSlotChanged();
				} else if (chest.getItemType().isItemEqual(stack)) {
					int value = (int) (chest.getMaxSize() - chest.getSize());
					if (value > 0) {
						slotItem.stackSize -= value;
						stack.stackSize = value;
						inSlot.putStack(stack);
						inSlot.onSlotChanged();
					}
				}
				slot.onSlotChanged();
			} else if (index == 2) { //搬出スロット
				if (!this.mergeItemStackOnOut(slotItem, 3, 39, true)) {
					return null;
				}
				slot.onSlotChange(slotItem, stack);
			}
			
			if (slotItem.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			
			if (slotItem.stackSize == stack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(player, stack);
		}
		
		return stack;
	}
	
	
	/**
	 * <h1>canInteractWith</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.Container#canInteractWith(net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}
	
	private boolean mergeItemStackOnOut(ItemStack itemStack, int index, int end, boolean bool) {
		boolean flag1 = false;
		int k = index;
		int beforeSize = itemStack.stackSize;
		
		if (bool) {
			k = end - 1;
		}
		
		Slot slot;
		ItemStack itemStack1;
		
		if (itemStack.isStackable()) {
			while (itemStack.stackSize > 0 && (!bool && k < end || bool && k >= index)) {
				slot = (Slot) this.inventorySlots.get(k);
				itemStack1 = slot.getStack();
				
				if (itemStack1 != null && itemStack1.getItem() == itemStack.getItem() && (!itemStack.getHasSubtypes() || itemStack.getItemDamage() == itemStack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(itemStack, itemStack1)) {
					int l = itemStack1.stackSize + itemStack.stackSize;
					
					if (l <= itemStack.getMaxStackSize()) {
						itemStack.stackSize = 0;
						itemStack1.stackSize = l;
						slot.onSlotChanged();
						flag1 = true;
					} else if (itemStack1.stackSize < itemStack.getMaxStackSize()) {
						itemStack.stackSize -= itemStack.getMaxStackSize() - itemStack1.stackSize;
						itemStack1.stackSize = itemStack.getMaxStackSize();
						slot.onSlotChanged();
						flag1 = true;
					}
				}
				
				if (bool) {
					--k;
				} else {
					++k;
				}
			}
		}
		
		if (itemStack.stackSize > 0) {
			if (bool) {
				k = end - 1;
			} else {
				k = index;
			}
			
			while (!bool && k < end || bool && k >= index) {
				slot = (Slot) this.inventorySlots.get(k);
				itemStack1 = slot.getStack();
				
				if (itemStack1 == null) {
					slot.putStack(itemStack.copy());
					slot.onSlotChanged();
					itemStack.stackSize = 0;
					flag1 = true;
					break;
				}
				
				if (bool) {
					--k;
				} else {
					++k;
				}
			}
		}
		
		int lostSize = beforeSize - itemStack.stackSize;
		this.chest.setSize(this.chest.getSize() - lostSize);
		itemStack.stackSize = this.chest.getSize() <= 64 ? (int) this.chest.getSize() : 64;
		if (itemStack.stackSize == 0) {
			this.chest.itemClear();
		}
		
		return flag1;
	}
}

class AlotmoreChestSlot extends Slot {
	
	/**
	 * スロットのアクセスレベル
	 */
	private boolean in = false, out = false;
	
	/**
	 * <B>コンストラクター</B><br>
	 *
	 * @param inventry インベントリー
	 * @param index    スロットインデックス
	 * @param x        スロット座標
	 * @param y        スロット座標
	 */
	AlotmoreChestSlot(IInventory inventry, int index, int x, int y, boolean in, boolean out) {
		super(inventry, index, x, y);
		this.in = in;
		this.out = out;
	}
	
	/**
	 * <h1>isItemValid</h1>
	 * オーバーライド<br>
	 * falseが返される場合スロットにアイテムは入れられない
	 *
	 * @see net.minecraft.inventory.Slot#isItemValid(net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean isItemValid(ItemStack inStack) {
		if (this.in) {
			BlackHoleChestTile tile = (BlackHoleChestTile) this.inventory;
			if (tile.getStackInSlot(0) == null) {
				return true;
			} else if (tile.getStackInSlot(0).isItemEqual(inStack) && tile.getSize() + inStack.stackSize <= tile.getMaxSize()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int getSlotStackLimit() {
		BlackHoleChestTile tile = (BlackHoleChestTile) this.inventory;
		long limit = tile.getMaxSize() - tile.getSize();
		return limit < 64 ? (int) limit : 64;
	}
}
