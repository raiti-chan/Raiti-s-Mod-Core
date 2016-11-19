package raiti.RaitisMod.Core.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import raiti.RaitisMod.Core.Client.Renderer.SolidWaterBlockRender;

/**
 * 固形水源ブロック
 * <br>Created by Raiti-chan on 2016/11/19.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class SolidWaterBlock extends RBlock {
	
	public SolidWaterBlock() {
		super(Material.glass);
		this.setBlockName("SolidWater");
		this.setHardness(1.0F);
		this.setResistance(1.5F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setLightOpacity(2);
		this.setStepSound(soundTypeGlass);
		this.setBlockBounds(1F / 16F, 1F / 16F, 1 / 16F, 15F / 16F, 15F / 16F, 15F / 16F);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		ForgeDirection flag = null;
		
		for (ForgeDirection forgeDirection : ForgeDirection.values()) {
			if ((world.getBlock(x + forgeDirection.offsetX, y + forgeDirection.offsetY, z + forgeDirection.offsetZ) == Blocks.water|| world.getBlock(x + forgeDirection.offsetX, y + forgeDirection.offsetY, z + forgeDirection.offsetZ) == Blocks.flowing_water) && flag == null) {
				flag = forgeDirection;
			}
		}
		
		if (flag != null) {
			Block block1 = world.getBlock(x, y, z);
			Minecraft.getMinecraft().renderGlobal.playAuxSFX(null, 2001, x, y, z, Block.getIdFromBlock(this));
			world.setBlock(x, y, z, Blocks.flowing_water, 0, 2);
			world.notifyBlockChange(x, y, z, block1);
		}
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isBlockNormalCube() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean isNormalCube() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return SolidWaterBlockRender.RenderID;
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		return Blocks.glass.getIcon(0, 0);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return Blocks.glass.getIcon(0, 0);
	}
	
}
