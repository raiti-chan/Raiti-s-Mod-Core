/*
 * 
 */
package raiti.RaitisMod.Core.Block;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
public class DirtyIronBlock extends RBlock {
	
	
	private Item droppedItem;
	
	private int meta;
	
	public DirtyIronBlock(Item droppedItem, int meta, String blockName, String textureName) {
		super(RBlockMaterials.DirtyMetalBlock.getMaterial());
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("Dirty" + blockName + "Block");
		setBlockTextureName("dirty_" + textureName + "_block");
		setHardness(4F);
		setHarvestLevel("OreCrusheHammer", 2);
		this.droppedItem = droppedItem;
		this.meta = meta;
	}
	
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return droppedItem;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return quantityDroppedWithBonus(fortune, random);
	}
	
	@Override
	public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_) {
		
		if (p_149679_1_ > 0) {
			int j = p_149679_2_.nextInt(p_149679_1_ + 2) - 1;
			
			if (j < 0) {
				j = 0;
			}
			
			return this.quantityDropped(p_149679_2_) + j;
		}
		
		return this.quantityDropped(p_149679_2_);
		
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 9 + random.nextInt(2);
	}
	
	@Override
	public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_,
	                         int p_149636_5_, int p_149636_6_) {
		super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
	}
	
	@Override
	public int damageDropped(int p_149692_1_) {
		return meta;
	}
	
}
