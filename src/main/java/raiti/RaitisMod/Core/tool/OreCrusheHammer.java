/*
 * 
 */
package raiti.RaitisMod.Core.tool;

import java.util.Set;

import raiti.RaitisMod.Core.block.Blocks;
import raiti.RaitisMod.Core.block.DirtyIronBlock;
import raiti.RaitisMod.Core.block.RaitisModsMaterial;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;
import scala.tools.nsc.doc.model.Public;

/** <h1>OreCrusheHammer</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class OreCrusheHammer extends ItemTool{
	
	private static final ToolMaterial matelial = EnumHelper.addToolMaterial("OreCrusheHammer",3, 15, 10.0F, 100, 22);
	
	private static final Set canHarvestBlock = Sets.newHashSet(new Block[] {Blocks.dirtyironblock} );
	

	/**<B>コンストラクター</B><br>
	 * @param p_i45333_1_
	 * @param p_i45333_2_
	 * @param p_i45333_3_
	 */
	public OreCrusheHammer() {
		super(0, matelial, canHarvestBlock);
		this.setUnlocalizedName("OreCrusheHammer");
		this.setTextureName("raitismod:orecrushehammer");
		
	}
	
	@Override
	public boolean func_150897_b(Block block) {
		return block.getHarvestTool(0).equals("OreCrusheHammer");
	}
	
	@Override
	public float func_150893_a(ItemStack itemStack, Block block) {
		if (block.getMaterial() == RaitisModsMaterial.DirtyMetalBlock) {
			return this.efficiencyOnProperMaterial;
		}
		return super.func_150893_a(itemStack, block);
	}
	
	
	
	
}
