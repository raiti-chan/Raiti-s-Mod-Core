/*
 * 
 */
package raiti.RaitisMod.Core.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import raiti.RaitisMod.Core.container.BlackHallChestContainer;

/**
 * <h1>BlackHallChestTile</h1>
 * <br>
 *
 * @author Raiti
 * @version 1.0.0
 */
public class BlackHallChestTile extends TileEntity implements ISidedInventory {
	
	
	@SuppressWarnings({"FieldCanBeLocal", "unused"})
	private BlackHallChestContainer container;
	
	private long MAXSIZE = Long.MAX_VALUE;
	
	private long size = 0L;
	
	private ItemStack stack = null;
	
	
	public void setContainer(BlackHallChestContainer container) {
		this.container = container;
	}
	
	/**
	 * <h1>readFromNBT</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.tileentity.TileEntity#readFromNBT(net.minecraft.nbt.NBTTagCompound)
	 */
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.size = par1NBTTagCompound.getLong("Size");
		NBTTagCompound compound = par1NBTTagCompound.getCompoundTag("Item");
		this.stack = ItemStack.loadItemStackFromNBT(compound);
	}
	
	/**
	 * <h1>writeToNBT</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.tileentity.TileEntity#writeToNBT(net.minecraft.nbt.NBTTagCompound)
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setLong("Size", this.size);
		NBTTagCompound compound = new NBTTagCompound();
		if (this.stack != null) this.stack.writeToNBT(compound);
		par1NBTTagCompound.setTag("Item", compound);
	}
	
	public NBTTagCompound writeToNBTOfItem(NBTTagCompound compound){
		NBTTagCompound chestItemCompound = new NBTTagCompound();
		chestItemCompound.setLong("Size", this.size);
		NBTTagCompound compound1 = new NBTTagCompound();
		if (this.stack != null) this.stack.writeToNBT(compound1);
		chestItemCompound.setTag("Item", compound1);
		compound.setTag("ChestItem", chestItemCompound);
		return compound;
	}
	
	/**
	 * <h1>getDescriptionPacket</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.tileentity.TileEntity#getDescriptionPacket()
	 */
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		this.writeToNBT(nbtTagCompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}
	
	/**
	 * <h1>onDataPacket</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.tileentity.TileEntity#onDataPacket(net.minecraft.network.NetworkManager, net.minecraft.network.play.server.S35PacketUpdateTileEntity)
	 */
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}
	
	/**
	 * <h1>getSize</h1>
	 * 内容量の取得<br>
	 *
	 * @return long
	 */
	public long getSize() {
		return this.size;
	}
	
	public void setSize(long size) {
		this.size = size;
	}
	
	public void setStack(ItemStack stack) {
		this.stack = stack;
	}
	
	public void itemClear() {
		this.size = 0;
		this.stack = null;
	}
	
	/**
	 * 保持されてるアイテムの種類をスタック0で取得します
	 *
	 * @return 種類を示すためのItemStack
	 */
	public ItemStack getItemType() {
		if (this.stack == null) return null;
		ItemStack stack = this.stack.copy();
		stack.stackSize = 0;
		return stack;
	}
	
	/**
	 * <h1>getSizeInventory</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#getSizeInventory()
	 */
	@Override
	public int getSizeInventory() {
		return 2;
	}
	
	
	/**
	 * <h1>getStackInSlot</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#getStackInSlot(int)
	 */
	@Override
	public ItemStack getStackInSlot(int index) {
		if (stack != null) {
			if (index == 0) {
				ItemStack ret = this.stack.copy();
				ret.stackSize = 0;
				return ret;
			}
			if (index == 2) {
				return this.stack;
			}
			if (index == 1 && this.MAXSIZE == this.size) {
				return this.stack;
			}
		}
		
		return null;
		
	}
	
	
	/**
	 * <h1>decrStackSize</h1>
	 * オーバーライド<br>
	 * アイテムをとろうとしたとき
	 *
	 * @see net.minecraft.inventory.IInventory#decrStackSize(int, int)
	 */
	@Override
	public ItemStack decrStackSize(int index, int dec) {
		if (!this.worldObj.isRemote) {//サーバーでの処理
			if (index == 2) {
				if (this.stack.stackSize >= dec && this.size > 64) {
					ItemStack ret = this.stack.copy();
					ret.stackSize = dec;
					this.size -= dec;
					if (this.size <= 64) {
						this.stack.stackSize = (int) this.size;
					}
					this.markDirty();
					this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
					return ret;
				} else if (this.size <= 64 && this.size > dec) {
					ItemStack ret = this.stack.copy();
					ret.stackSize = dec;
					this.size -= dec;
					this.stack.stackSize = (int) this.size;
					this.markDirty();
					this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
					return ret;
				} else if (this.size <= 64 && this.size <= dec) {
					ItemStack ret = this.stack.copy();
					this.size = 0;
					this.stack = null;
					this.markDirty();
					this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
					return ret;
				}
			}
		} else {//クライアントでの処理 (こっちで内部アイテムを減らす処理はしない)
			if (index == 2) {
				if (this.stack.stackSize >= dec && this.size > 64) {
					ItemStack ret = this.stack.copy();
					ret.stackSize = dec;
					return ret;
				} else if (this.size <= 64 && this.size > dec) {
					ItemStack ret = this.stack.copy();
					ret.stackSize = dec;
					return ret;
				} else if (this.size <= 64 && this.size <= dec) {
					return this.stack.copy();
				}
			}
		}
		return null;
	}
	
	
	/**
	 * <h1>setInventorySlotContents</h1>
	 * オーバーライド<br>
	 * アイテムをスロットに置いたとき
	 *
	 * @see net.minecraft.inventory.IInventory#setInventorySlotContents(int, net.minecraft.item.ItemStack)
	 */
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (!this.worldObj.isRemote) {//サーバーでの処理
			if (index == 1 && stack != null) {
				if (this.stack == null) {
					this.stack = stack;
					this.size = stack.stackSize;
				} else if (this.stack.isItemEqual(stack) && this.MAXSIZE - this.size > 0) {
					this.size += stack.stackSize;
					if (this.size < 0) this.size = this.MAXSIZE;
					if (this.size <= 64) {
						this.stack.stackSize = (int) this.size;
					} else if (this.size > 64) {
						this.stack.stackSize = 64;
					}
				}
				this.markDirty();
				this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
			}
		}
		
	}
	
	/**
	 * <h1>getStackInSlotOnClosing</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#getStackInSlotOnClosing(int)
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int par) {
		return null;
	}
	
	/**
	 * <h1>getMaxSize</h1>
	 * 貯蔵限界を返します<br>
	 *
	 * @return 貯蔵限界
	 */
	public long getMaxSize() {
		return MAXSIZE;
	}
	
	
	/**
	 * <h1>getInventoryName</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#getInventoryName()
	 */
	@Override
	public String getInventoryName() {
		return StatCollector.translateToLocal("GUI.BlackHallChest.name");
	}
	
	
	/**
	 * <h1>hasCustomInventoryName</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#hasCustomInventoryName()
	 */
	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}
	
	
	/**
	 * <h1>getInventoryStackLimit</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#getInventoryStackLimit()
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	
	/**
	 * <h1>isUseableByPlayer</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#isUseableByPlayer(net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}
	
	
	/**
	 * <h1>openInventory</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#openInventory()
	 */
	@Override
	public void openInventory() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	
	/**
	 * <h1>closeInventory</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#closeInventory()
	 */
	@Override
	public void closeInventory() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	
	/**
	 * <h1>isItemValidForSlot</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.inventory.IInventory#isItemValidForSlot(int, net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		return this.stack == null || (this.stack.isItemEqual(item) && size < MAXSIZE);
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return new int[]{1, 2};
	}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side) {
		return slot == 1;
	}
	
	@Override
	public boolean canExtractItem(int slot, ItemStack stack, int side) {
		return slot == 2;
	}
}
