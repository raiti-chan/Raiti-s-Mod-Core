/*
 * 
 */
package raiti.RaitisMod.API.Util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/** <h1>NonFunctionalBlock</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class NonFunctionalBlock extends Block{

	/**<B>コンストラクター</B><br>
	 * @param p_i45394_1_
	 */
	public NonFunctionalBlock(Material mate) {
		super(mate);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ){
        //ブロックを右クリックした際の動作
        return true;
    }
 
    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
        //ブロックを左クリックした際の動作
    }
 
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock){
        //周囲のブロックが更新された際の動作
    }
 
    @Override
    public int quantityDropped(int meta, int fortune, Random random){
        //ドロップするアイテムを返す
        return quantityDroppedWithBonus(fortune, random);
    }
 
    @Override
    public int quantityDropped(Random random){
        //ドロップさせる量を返す
        return 1;
    }
	
}
