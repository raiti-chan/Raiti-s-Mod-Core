/*
 * 
 */
package raiti.RaitisMod.Core.container;

import raiti.RaitisMod.Core.TileEntity.AlotmoreChestTile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/** <h1>AlotmoreChestContainer</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class AlotmoreChestContainer extends Container{
	
	
	private AlotmoreChestTile chest;
	private InventoryPlayer playerInventry;
	
	
	
	public AlotmoreChestContainer(IInventory plaInv, IInventory tileInv) {
		this.chest = (AlotmoreChestTile) tileInv;
		chest.setContainer(this);
		this.playerInventry = (InventoryPlayer) plaInv;
		
		this.addSlotToContainer(new AlotmoreChestSlot(chest , 2, 44, 38,false,true));
		this.addSlotToContainer(new AlotmoreChestSlot(chest , 1, 8, 38,true,false));
		this.addSlotToContainer(new AlotmoreChestSlot(chest , 0, 124,35,false,false));
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(plaInv,  x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		for (int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(plaInv, x, 8 + x * 18, 142));
		}
	}
	
	/**<h1>transferStackInSlot</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.Container#transferStackInSlot(net.minecraft.entity.player.EntityPlayer, int)
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		return null;
	}

	
	/**<h1>canInteractWith</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.Container#canInteractWith(net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}
}

class AlotmoreChestSlot extends Slot {
	
	/**
	 * スロットのアクセスレベル
	 */
	private boolean in = false , out = false ;
	
	/**<B>コンストラクター</B><br>
	 * @param inventry インベントリー
	 * @param index スロットインデックス
	 * @param x スロット座標
	 * @param y スロット座標
	 */
	public AlotmoreChestSlot(IInventory inventry, int index, int x, int y,boolean in,boolean out) {
		super(inventry, index, x, y);
		this.in = in;
		this.out = out;
	}
	
	/**<h1>isItemValid</h1>
	 * オーバーライド<br>
	 * falseが返される場合スロットにアイテムは入れられない
	 * @see net.minecraft.inventory.Slot#isItemValid(net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean isItemValid(ItemStack inStack) {
		if(this.in == true) {
			AlotmoreChestTile tile = (AlotmoreChestTile)this.inventory;
			if(tile.getStackInSlot(0) == null) {
				return true;
			}else if (tile.getStackInSlot(0).isItemEqual(inStack)){
				return true;
			}
		}
		
		return false;
	}
	
}
