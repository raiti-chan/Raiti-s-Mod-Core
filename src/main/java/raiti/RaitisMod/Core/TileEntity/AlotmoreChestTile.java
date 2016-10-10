/*
 * 
 */
package raiti.RaitisMod.Core.TileEntity;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.inventory.ISidedInventory;
import raiti.RaitisMod.Core.container.AlotmoreChestContainer;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/** <h1>AlotmoreChestTile</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class AlotmoreChestTile extends TileEntity implements IInventory{
	ISidedInventory
	private AlotmoreChestContainer container;
	
	private long MAXSIZE = Long.MAX_VALUE;
	
	private long size = 0L;
	
	private ItemStack stack = null;
	
	//private ItemStack input = null;
	
	//private ItemStack output = null;
	
	public void setContainer(AlotmoreChestContainer container) {
		this.container = container;
	}
	
	/*
	 * NBTの読み取り。
	 * 
	 * このメソッドでは、NBTを介してString（文字列）を読み込んでいます。
	 * 文字列以外に、変数やboolean、ItemStackなども扱えます。
	 * 
	 * NBTを使えば一時的には記録されますが、
	 * チャンク再生成や再ログイン時にデータが消えてしまいます。
	 * また、このクラスで行われた処理・サーバ側で行われた処理をクライアント側に反映させるためには、
	 * 別途パケット処理も必要です。
	 */
	/**<h1>readFromNBT</h1>
	 * オーバーライド
	 * @see net.minecraft.tileentity.TileEntity#readFromNBT(net.minecraft.nbt.NBTTagCompound)
	 */
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.size = par1NBTTagCompound.getLong("Size");
		NBTTagCompound compound = par1NBTTagCompound.getCompoundTag("Item");
		this.stack = ItemStack.loadItemStackFromNBT(compound);
	}
	
	/**<h1>writeToNBT</h1>
	 * オーバーライド
	 * @see net.minecraft.tileentity.TileEntity#writeToNBT(net.minecraft.nbt.NBTTagCompound)
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setLong("Size", this.size);
		NBTTagCompound compound = new NBTTagCompound();
		if(this.stack != null) this.stack.writeToNBT(compound);
		par1NBTTagCompound.setTag("Item", compound);
	}
	
	/**<h1>getDescriptionPacket</h1>
	 * オーバーライド
	 * @see net.minecraft.tileentity.TileEntity#getDescriptionPacket()
	 */
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		this.writeToNBT(nbtTagCompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}
	
	/**<h1>onDataPacket</h1>
	 * オーバーライド
	 * @see net.minecraft.tileentity.TileEntity#onDataPacket(net.minecraft.network.NetworkManager, net.minecraft.network.play.server.S35PacketUpdateTileEntity)
	 */
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.func_148857_g());
	}
	
	/**
	 * <h1>getSize</h1>
	 * 内容量の取得<br>
	 * @return
	 */
	public long getSize() {
		return this.size;
	}
	
	/**
	 * <h1>setSize</h1>
	 * 内容量のセット<br>
	 * @param par1
	 */
	public void setSize(long par1) {
		this.size = par1;
	}
	
	/**
	 * <h1>getMetadata</h1>
	 * メタデータの取得<br>
	 * @return
	 */
	public int getMetadata() {
		return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
	}

	
	/**<h1>getSizeInventory</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#getSizeInventory()
	 */
	@Override
	public int getSizeInventory() {
		return 2;
	}

	
	/**<h1>getStackInSlot</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#getStackInSlot(int)
	 */
	@Override
	public ItemStack getStackInSlot(int index) {
		if(stack != null) {
			if(index == 0) {
				ItemStack ret = this.stack.copy();
				ret.stackSize = 0;
				return ret;
			}
			if(index == 2) {
				return this.stack;
			}
			if(index == 1 && this.MAXSIZE == this.size) {
				return this.stack;
			}
		}
		
		return null;
		
	}

	
	/**<h1>decrStackSize</h1>
	 * オーバーライド<br>
	 * アイテムをとろうとしたとき
	 * @see net.minecraft.inventory.IInventory#decrStackSize(int, int)
	 */
	@Override
	
	public ItemStack decrStackSize(int index, int dec) {
		System.out.println("AlotmoreChestTile.decrStackSize(int " +index+",int "+dec+")");
		if(index == 2) {
			if(this.stack.stackSize >= dec && this.size > 64) {
				ItemStack ret = this.stack.copy();
				ret.stackSize = dec;
				this.size -= dec;
				if(this.size <= 64) {
					this.stack.stackSize = (int) this.size;
				}
				return ret;
			}else if(this.size <= 64 && this.size > dec) {
				ItemStack ret = this.stack.copy();
				ret.stackSize = dec;
				this.size -= dec;
				this.stack.stackSize = (int) this.size;
				return ret;
			}else if(this.size <= 64 && this.size <= dec) {
				ItemStack ret = this.stack.copy();
				this.size = 0;
				this.stack = null;
				return ret;
			}
		}
		return null;
	}

	
	/**<h1>getStackInSlotOnClosing</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#getStackInSlotOnClosing(int)
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		//System.out.println("AlotmoreChestTile.getStackInSlotOnClosing(int "+p_70304_1_+")");
		return null;
	}

	
	/**<h1>setInventorySlotContents</h1>
	 * オーバーライド<br>
	 * アイテムをスロットに置いたとき
	 * @see net.minecraft.inventory.IInventory#setInventorySlotContents(int, net.minecraft.item.ItemStack)
	 */
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		System.out.println("AlotmoreChestTile.setInventorySlotContents(int "+index+",item "+ stack+")");
		if(index == 1 && stack != null) {
			if(this.stack == null) {
				this.stack = stack;
				this.size = stack.stackSize;
				
			}else if(this.stack.isItemEqual(stack) && this.MAXSIZE - this.size > 0) {
				this.size += stack.stackSize;
				if(this.size < 0) this.size = this.MAXSIZE;
				if(this.size <=64) {
					this.stack.stackSize = (int)this.size;
				}
				
			}

		}
		
	}
	
	/**
	 * <h1>getMaxSize</h1>
	 * 貯蔵限界を返します<br>
	 * @return
	 */
	public long getMaxSize() {
		return MAXSIZE;
	}
	
	
	/**<h1>getInventoryName</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#getInventoryName()
	 */
	@Override
	public String getInventoryName() {
		return "container.alotmorechest";
	}

	
	/**<h1>hasCustomInventoryName</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#hasCustomInventoryName()
	 */
	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	
	/**<h1>getInventoryStackLimit</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#getInventoryStackLimit()
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	
	/**<h1>isUseableByPlayer</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#isUseableByPlayer(net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	
	/**<h1>openInventory</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#openInventory()
	 */
	@Override
	public void openInventory() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
	/**<h1>closeInventory</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#closeInventory()
	 */
	@Override
	public void closeInventory() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	
	/**<h1>isItemValidForSlot</h1>
	 * オーバーライド
	 * @see net.minecraft.inventory.IInventory#isItemValidForSlot(int, net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}
	
}
