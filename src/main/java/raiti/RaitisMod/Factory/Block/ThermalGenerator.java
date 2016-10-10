package raiti.RaitisMod.Factory.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import raiti.RaitisMod.Factory.Energy.EnergyBuffer;
import raiti.RaitisMod.Factory.FactoryRegister;
import raiti.RaitisMod.Factory.TileEntity.TileEntityThermalGenerator;

/**
 * Created by Raiti on 2016/10/10.
 */
public class ThermalGenerator extends BlockContainer{
	

	
	public ThermalGenerator() {
		super(Material.iron);
		this.setBlockName("thermal_generator");
		this.setCreativeTab(FactoryRegister.FACTORY_TAB);
		this.setHardness(5F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityThermalGenerator();
	}
	
}
