/*
 * 
 */
package raiti.RaitisMod.Core.block;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import raiti.RaitisMod.Core.RaitisModCoreMain;
import raiti.RaitisMod.Core.TileEntity.BlackHallChestTile;
import raiti.RaitisMod.Core.gui.GuiHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * <h1>BlackHallChestBlock</h1>
 * <br>
 *
 * @author Raiti
 * @version 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class BlackHallChestBlock extends BlockContainer {
	
	
	public BlackHallChestBlock() {
		super(Material.iron);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockName("BlackHallChest");
		this.setHardness(7F);
		this.setResistance(10F);
	}
	//-------------------------------------コンストラクター
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
	                                EntityPlayer player, int p_149727_6_, float hitX, float hitY, float hitZ) {
		
		BlackHallChestTile tile = (BlackHallChestTile) world.getTileEntity(x, y, z);
		
		if (tile != null & !world.isRemote) {
			player.openGui(RaitisModCoreMain.INSTANCE, GuiHandler.AlotmoreChestGUI, world, x, y, z);
		}
		
		
		return true;
		
	}
	
	
	/**
	 * <h1>createNewTileEntity</h1>
	 * オーバーライド
	 *
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new BlackHallChestTile();
	}
	
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		
		if (item.hasTagCompound()) {
			BlackHallChestTile tile = (BlackHallChestTile) createNewTileEntity(world, 0);
			world.setTileEntity(x, y, z, tile);
			NBTTagCompound compound = item.getTagCompound().getCompoundTag("ChestItem");
			
			if (compound != null) {
				ItemStack stack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("Item"));
				long size = compound.getLong("Size");
				tile.setStack(stack);
				tile.setSize(size);
			}
			
		}
	}
	
	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		BlackHallChestTile tile = (BlackHallChestTile) world.getTileEntity(x, y, z);
		ItemStack stack = new ItemStack(this, 1, 0);
		if ((!world.isRemote) && tile != null) {
			if (tile.getItemType() != null) {
				NBTTagCompound compound = new NBTTagCompound();
				stack.setTagCompound(tile.writeToNBTOfItem(compound));
			}
			EntityItem drop = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, stack);
			world.spawnEntityInWorld(drop);
		}
		
	}
	
	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return false;
	}
}
