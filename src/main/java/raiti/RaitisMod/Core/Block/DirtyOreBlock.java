/*
 * 
 */
package raiti.RaitisMod.Core.Block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * 汚れた鉱石ブロック
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class DirtyOreBlock extends RBlock {
	
	private ItemStack[] droppedItems;
	
	private IIcon[] icons;
	
	public DirtyOreBlock(ItemStack[] droppedItems, String blockName, String textureName) {
		super(RBlockMaterials.DirtyMetalBlock.getMaterial());
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName(blockName);
		setBlockTextureName(textureName);
		setHardness(4F);
		setHarvestLevel("Ore_crushe_hammer", 2);
		this.droppedItems = droppedItems;
		this.icons = new IIcon[droppedItems.length];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		for (int i = 0; i < this.icons.length; i++) {
			this.icons[i] = register.registerIcon(this.getTextureName() + "_" + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		return icons[meta];
	}
	
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < this.icons.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return droppedItems[meta].getItem();
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return quantityDroppedWithBonus(fortune, random);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		
		if (fortune > 0) {
			int j = random.nextInt(fortune + 2) - 1;
			
			if (j < 0) {
				j = 0;
			}
			
			return this.quantityDropped(random) + j;
		}
		
		return this.quantityDropped(random);
		
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 9 + random.nextInt(2);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int i) {
		super.harvestBlock(world, player, x, y, z, i);
	}
	
	@Override
	public int damageDropped(int meta) {
		return this.droppedItems[meta].getItemDamage();
	}
	
}
