/*
 * 
 */
package raiti.RaitisMod.Core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IBlockAccess;
import raiti.RaitisMod.Core.RaitisModCoreMain;
import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;
import raiti.RaitisMod.Core.gui.GuiHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

/**
 * <h1>BlackHoleChestBlock</h1>
 * <br>
 *
 * @author Raiti
 * @version 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class BlackHoleChestBlock extends BlockContainer {
	
	
	public BlackHoleChestBlock() {
		super(Material.iron);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockName("BlackHoleChest");
		this.setHardness(7F);
		this.setResistance(10F);
	}
	//-------------------------------------コンストラクター
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
	                                EntityPlayer player, int p_149727_6_, float hitX, float hitY, float hitZ) {
		
		BlackHoleChestTile tile = (BlackHoleChestTile) world.getTileEntity(x, y, z);
		
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
		return new BlackHoleChestTile();
	}
	
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		
		if (item.hasTagCompound()) {
			BlackHoleChestTile tile = (BlackHoleChestTile) createNewTileEntity(world, 0);
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
		BlackHoleChestTile tile = (BlackHoleChestTile) world.getTileEntity(x, y, z);
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
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int i) {
		return i == 0 && super.shouldSideBeRendered(blockAccess, x, y, z, i);
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		for (int l = 0; l < 4; ++l) {
			double startX;
			double startY = (double) ((float) y + random.nextFloat());
			double startZ;
			double moveX;
			double moveY;
			double moveZ;
			int i1 = random.nextInt(2) * 2 - 1;
			
			moveY = ((double) random.nextFloat() - 0.5D) * 0.5D;
			
			startX = (double) x + 0.5D + 0.25D * (double) i1;
			moveX = (double) (random.nextFloat() * 1.0F * (float) i1);
			startZ = (double) ((float) z + random.nextFloat());
			moveZ = ((double) random.nextFloat() - 0.5D) * 0.5D;
			world.spawnParticle("portal", startX, startY, startZ, moveX, moveY, moveZ);
			
			startX = (double) ((float) x + random.nextFloat());
			moveX = ((double) random.nextFloat() - 0.5D) * 0.5D;
			startZ = (double) z + 0.5D + 0.25D * (double) i1;
			moveZ = (double) (random.nextFloat() * 1.0F * (float) i1);
			world.spawnParticle("portal", startX, startY, startZ, moveX, moveY, moveZ);
			
			
		}
	}
	
	
}
