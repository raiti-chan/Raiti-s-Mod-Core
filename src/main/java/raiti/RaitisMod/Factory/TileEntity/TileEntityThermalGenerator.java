package raiti.RaitisMod.Factory.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import raiti.RaitisMod.Factory.Energy.EnergyBuffer;

/**
 * Created by Raiti on 2016/10/10.
 */
public class TileEntityThermalGenerator extends TileEntity implements EnergyBuffer{
	
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
}
