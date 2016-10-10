/*
 * 
 */
package raiti.RaitisMod.Core.block;

import java.util.Iterator;

import raiti.RaitisMod.Core.RaitisModCoreMain;
import raiti.RaitisMod.Core.TileEntity.AlotmoreChestTile;
import raiti.RaitisMod.Core.gui.GuiHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/** <h1>AlotmoreChest</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class AlotmoreChest extends BlockContainer{


	protected AlotmoreChest() {
		super(Material.iron);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockName("A lot more Chest");
		this.setBlockTextureName("raitismod:alotmorechest_block");
		this.setHardness(4F);
	}
	//-------------------------------------コンストラクター


	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, 
			EntityPlayer player, int p_149727_6_, float hitX, float hitY, float hitZ){
		
		AlotmoreChestTile tile = (AlotmoreChestTile) world.getTileEntity(x, y, z);
		
		if(tile != null & !world.isRemote) {
			player.openGui(RaitisModCoreMain.INSTANCE, GuiHandler.AlotmoreChestGUI, world, x, y, z);
		}
		

		return true;
		
	}



	/**<h1>createNewTileEntity</h1>
	 * オーバーライド
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new AlotmoreChestTile();
	}
    

}
