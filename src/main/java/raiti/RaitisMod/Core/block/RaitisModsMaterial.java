/*
 * 
 */
package raiti.RaitisMod.Core.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/** <h1>RaitisModsMaterial</h1>
 * <br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class RaitisModsMaterial extends Material {
	
	public static Material DirtyMetalBlock = new RaitisModsMaterial(MapColor.ironColor).setRequiresTool();
	
	/**<B>コンストラクター</B><br>
	 * @param p_i2116_1_
	 */
	public RaitisModsMaterial(MapColor p_i2116_1_) {
		super(p_i2116_1_);
	}
	
}
