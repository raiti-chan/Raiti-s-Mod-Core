package raiti.RaitisMod.Core.Block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import raiti.RaitisMod.Core.Client.Gui.CuttingBoardGUI;
import raiti.RaitisMod.Core.RaitisModCoreMain;

/**
 * <br>Created by Raiti-chan on 2016/12/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class CuttingBoardBlock extends RBlock {
	
	public CuttingBoardBlock() {
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockName("CuttingBord");
		this.setHardness(2.5F);
		this.setStepSound(soundTypeWood);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float px, float py, float pz) {
		if (world.isRemote) {
			return true;
		} else {
			player.openGui(RaitisModCoreMain.INSTANCE, CuttingBoardGUI.GUI_ID, world, x, y, z);
			return true;
		}
		
		
	}
}
