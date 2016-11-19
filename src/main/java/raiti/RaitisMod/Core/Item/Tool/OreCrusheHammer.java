/*
 * 
 */
package raiti.RaitisMod.Core.Item.Tool;

import java.util.Set;

import raiti.RaitisMod.Core.Block.RBlockMaterials;
import raiti.RaitisMod.Core.Block.RBlockRegister;

import static raiti.RaitisMod.Core.Item.Tool.RToolMaterial.ORE_CRUSHE_HAMMER;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * 鉱石粉砕ハンマー
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class OreCrusheHammer extends RItemTool{
	
	private static final Set canHarvestBlock = Sets.newHashSet(RBlockRegister.dirtyOreBlock);
	
	public OreCrusheHammer() {
		super(0, ORE_CRUSHE_HAMMER, canHarvestBlock);
		this.setUnlocalizedName("OreCrusheHammer");
		this.setTextureName("ore_crushe_hammer");
		
	}
	
	@Override
	public boolean func_150897_b(Block block) {
		return block.getHarvestTool(0).equals("OreCrusheHammer");
	}
	
	@Override
	public float func_150893_a(ItemStack itemStack, Block block) {
		if (block.getMaterial() == RBlockMaterials.DirtyMetalBlock.getMaterial()) {
			return this.efficiencyOnProperMaterial;
		}
		return super.func_150893_a(itemStack, block);
	}
	
	
	
	
}
