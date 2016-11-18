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
import raiti.RaitisMod.Core.Container.BlackHoleChestContainer;

/**
 * ブラックホールチェストのたいるえんちちー
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class BlackHoleChestTile extends TileEntity implements ISidedInventory {
	
	
	@SuppressWarnings({"FieldCanBeLocal", "unused"})
	private BlackHoleChestContainer container;
	
	private long MAXSIZE = Long.MAX_VALUE;
	
	private long size = 0L;
	
	private ItemStack stack = null;
	
	
	public void setContainer(BlackHoleChestContainer container) {
		this.container = container;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.size = par1NBTTagCompound.getLong("Size");
		NBTTagCompound compound = par1NBTTagCompound.getCompoundTag("Item");
		this.stack = ItemStack.loadItemStackFromNBT(compound);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setLong("Size", this.size);
		NBTTagCompound compound = new NBTTagCompound();
		if (this.stack != null) this.stack.writeToNBT(compound);
		par1NBTTagCompound.setTag("Item", compound);
	}
	
	public NBTTagCompound writeToNBTOfItem(NBTTagCompound compound) {
		NBTTagCompound chestItemCompound = new NBTTagCompound();
		chestItemCompound.setLong("Size", this.size);
		NBTTagCompound compound1 = new NBTTagCompound();
		if (this.stack != null) this.stack.writeToNBT(compound1);
		chestItemCompound.setTag("Item", compound1);
		compound.setTag("ChestItem", chestItemCompound);
		return compound;
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		this.writeToNBT(nbtTagCompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}
	
	/**
	 * <h1>getSize</h1>
	 * 内容量の取得<br>
	 *
	 * @return 内容量
	 */
	public long getSize() {
		return this.size;
	}
	
	/**
	 * 内容量のセット
	 *
	 * @param size セットする内容量
	 */
	public void setSize(long size) {
		this.size = size;
	}
	
	/**
	 * 中身のセット
	 *
	 * @param stack ItemStack
	 */
	public void setStack(ItemStack stack) {
		this.stack = stack;
	}
	
	/**
	 * 中身を初期化
	 */
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
	
	@Override
	public int getSizeInventory() {
		return 2;
	}
	
	
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
	 * スロットから取り出そうとしたとき
	 *
	 * @param index スロットインデックス
	 * @param dec   サイズ
	 * @return 不明
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
	 * アイテムをスロットに置いたとき
	 *
	 * @param index スロットインデックス
	 * @param stack 置いたアイテム
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
	
	@Override
	public ItemStack getStackInSlotOnClosing(int par) {
		return null;
	}
	
	/**
	 * 貯蔵限界を返します<br>
	 *
	 * @return 貯蔵限界
	 */
	public long getMaxSize() {
		return MAXSIZE;
	}
	
	@Override
	public String getInventoryName() {
		return StatCollector.translateToLocal("GUI.RaitisModCore.BlackHoleChest.name");
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}
	
	@Override
	public void openInventory() {
		
	}
	
	@Override
	public void closeInventory() {
		
	}
	
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
