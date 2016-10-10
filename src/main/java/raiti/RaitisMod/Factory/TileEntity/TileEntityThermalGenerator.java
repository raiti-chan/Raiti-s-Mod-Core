package raiti.RaitisMod.Factory.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import raiti.RaitisMod.Factory.Energy.EnergyBuffer;

/**
 * Created by Raiti on 2016/10/10.
 */
public class TileEntityThermalGenerator extends TileEntity implements EnergyBuffer,IInventory{
	
	private long BUFFER_ENERGY = 0;
	
	private static final long MAX_ENERGY = 1000;
	
	
	@Override
	public void updateEntity() {
		super.updateEntity();
	}
	
	@Override
	public long getBufferEnergy() {
		return BUFFER_ENERGY;
	}
	
	
	@Override
	public void readFromNBT(NBTTagCompound ntb) {
		super.readFromNBT(ntb);
		BUFFER_ENERGY = ntb.getLong("Energy");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound ntb) {
		super.writeToNBT(ntb);
		ntb.setLong("Energy",this.BUFFER_ENERGY);
	}
	
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound ntb = new NBTTagCompound();
		this.writeToNBT(ntb);
		return new S35PacketUpdateTileEntity(this.xCoord,this.yCoord,this.zCoord,1,ntb);
	}
	
	@Override
	public long getMaxBuffer() {
		return MAX_ENERGY;
	}
	
	@Override
	public long addBufferEnergy(long addEnergy) {
		return 0;
	}
	
	@Override
	public boolean canSendEnergy() {
		return true;
	}
	
	@Override
	public boolean canReceiveEnergy() {
		return false;
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}
	
	
	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return null;
	}
	
	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		return null;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return null;
	}
	
	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		
	}
	
	@Override
	public String getInventoryName() {
		return null;
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 0;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return false;
	}
	
	@Override
	public void openInventory() {
		
	}
	
	@Override
	public void closeInventory() {
		
	}
	
	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}
}
