/*
 * 
 */
package raiti.RaitisMod.Core.Util;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import raiti.RaitisMod.Core.Block.RBlock;

/**
 * 簡易ブロックを追加作成し、追加します<br>
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class BlockUtil {
	private BlockUtil() {
	}
	
	/**
	 * 簡易ブロックを作成します
	 *
	 * @param name         ブロック名
	 * @param textureName  テクスチャー名
	 * @param addTab       ブロックを追加するタブ
	 * @param material     ブロックマテリアル
	 * @param hardness     ブロックの硬さ
	 * @param resistance   爆破耐性
	 * @param StepSound    ブロックの上を歩いた時の音
	 * @param LightOpacity ブロックの透過係数 デフォルト0
	 * @param LightLevel   ブロックの明るさ 1.0F ～ 15.0F
	 * @param toolClass    適正ツール名
	 * @param level        ハーベストレベル
	 * @return ブロック
	 */
	public static RBlock createBlock(String name, String textureName, CreativeTabs addTab, Material material, float hardness, float resistance, SoundType StepSound, int LightOpacity, float LightLevel, String toolClass, int level) {
		RBlock block = new NonFunctionalBlock(material);
		block.setBlockName(name);
		block.setBlockTextureName(textureName);
		if (addTab != null) block.setCreativeTab(addTab);
		if (hardness != -1) block.setHardness(hardness);
		if (resistance != -1) block.setResistance(resistance);
		if (StepSound != null) block.setStepSound(StepSound);
		if (LightOpacity != -1) block.setLightOpacity(LightOpacity);
		if (LightLevel != -1) block.setLightLevel(LightLevel);
		if (toolClass != null) block.setHarvestLevel(toolClass, level);
		return block;
		
	}
	
	/**
	 * 簡易ブロックを生作成します
	 *
	 * @param name        ブロック名
	 * @param textureName テクスチャ―名
	 * @param addTab      追加するタブ
	 * @param material    ブロックマテリアル
	 * @return 生成されたブロック
	 */
	@SuppressWarnings("unused")
	public static Block createBlock(String name, String textureName, CreativeTabs addTab, Material material) {
		return createBlock(name, textureName, addTab, material, -1.0F, -1.0F, null, -1, -1.0F, null, -1);
	}
	
	
}
