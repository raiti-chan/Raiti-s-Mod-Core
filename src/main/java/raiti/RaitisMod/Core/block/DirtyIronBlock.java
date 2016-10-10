/*
 * 
 */
package raiti.RaitisMod.Core.block;

import java.util.ArrayList;
import java.util.Random;

import raiti.RaitisMod.Core.tool.OreCrusheHammer;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

/** <h1>DirtyMetalBlock</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class DirtyIronBlock extends Block{
	
	
	
	//-------------------------------------コンストラクター
	
	private Item droppedItem;
	
	private int meta;
	
	/**<B>コンストラクター</B><br>
	 * @param p_i45394_1_
	 */
	public DirtyIronBlock(Item droppedItem,int meta,String blockname,String texturename) {
		super(RaitisModsMaterial.DirtyMetalBlock);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("Dirty"+blockname+"Block");
		setBlockTextureName("raitismod:dirty_"+texturename+"_block");
		setHardness(4F);
		setHarvestLevel("OreCrusheHammer", 2);
		this.droppedItem = droppedItem;
		this.meta = meta;
	}
	
	
	/**<h1>getItemDropped</h1>
	 * オーバーライド
	 * @see net.minecraft.block.Block#getItemDropped(int, java.util.Random, int)
	 */
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return droppedItem;
	}
	
    @Override
    public int quantityDropped(int meta, int fortune, Random random){
        return quantityDroppedWithBonus(fortune, random);
    }
    
    /**<h1>quantityDroppedWithBonus</h1>
     * オーバーライド
     * @see net.minecraft.block.Block#quantityDroppedWithBonus(int, java.util.Random)
     */
    @Override
    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_) {
    	
    	if(p_149679_1_ > 0) {
    		int j = p_149679_2_.nextInt(p_149679_1_ + 2) -1;
    		
    		if(j < 0) {
    			j = 0;
    		}
    		
    		return this.quantityDropped(p_149679_2_) + j;
    	}
    	
    	return this.quantityDropped(p_149679_2_);
       
    }
	
    @Override
    public int quantityDropped(Random random){
        return 9+random.nextInt(2);
    }
    
    /**<h1>harvestBlock</h1>
     * オーバーライド
     * @see net.minecraft.block.Block#harvestBlock(net.minecraft.world.World, net.minecraft.entity.player.EntityPlayer, int, int, int, int)
     */
    @Override
    public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_,
    		int p_149636_5_, int p_149636_6_) {
    	// TODO 自動生成されたメソッド・スタブ
    	super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
    }
    
    /**<h1>damageDropped</h1>
     * オーバーライド
     * @see net.minecraft.block.Block#damageDropped(int)
     */
    @Override
    public int damageDropped(int p_149692_1_) {
    	return meta;
    }
	
}
