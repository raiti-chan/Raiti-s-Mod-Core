/*
 * 
 */
package raiti.RaitisMod.Core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.IBlockAccess;

/** <h1>TestBlock</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class TestBlock extends Block{

	/**<B>コンストラクター</B><br>
	 * @param p_i45394_1_
	 */
	public TestBlock() {
		super(Material.rock);
		this.setBlockName("TestBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
	/**<h1>canCreatureSpawn</h1>
	 * オーバーライド
	 * @see net.minecraft.block.Block#canCreatureSpawn(net.minecraft.entity.EnumCreatureType, net.minecraft.world.IBlockAccess, int, int, int)
	 */
	@Override
	public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
		return false;
	}
	
}
