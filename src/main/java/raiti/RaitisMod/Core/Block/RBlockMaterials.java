package raiti.RaitisMod.Core.Block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * ブロックマテリアルのEnum定数
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public enum RBlockMaterials {
	DirtyMetalBlock(new RBlockMaterial(MapColor.ironColor).setRequiresTool()),;
	
	/**
	 * 内部保持{@link Material}
	 */
	private Material material;
	
	RBlockMaterials(Material material) {
		this.material = material;
	}
	
	/**
	 * 内部保持マテリアルの取得
	 *
	 * @return 内部保持マテリアル
	 */
	public Material getMaterial() {
		return material;
	}
	
	/**
	 * 基本マテリアルクラス
	 */
	public static class RBlockMaterial extends Material {
		RBlockMaterial(MapColor color) {
			super(color);
		}
		
		@Override
		public Material setRequiresTool() {
			return super.setRequiresTool();
		}
	}
	
	
}
