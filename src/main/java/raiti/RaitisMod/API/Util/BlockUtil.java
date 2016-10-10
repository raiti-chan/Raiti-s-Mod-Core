/*
 * 
 */
package raiti.RaitisMod.API.Util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/** <h1>BlockUtil</h1>
 * 簡易ブロックを追加作成し、追加します<br>
 * @author Raiti
 * @version 1.0.0
 * 
 */
public class BlockUtil {
	//-------------------------------------コンストラクター
	/**
	 * <B>コンストラクター</B><br>
	 * 無効
	 */
	private BlockUtil() {
	}
	
	/**
	 * <h1>CreatItem</h1>
	 * 簡易ブロックを作成します<br>
	 * @param name ブロック名
	 * @param textureName テクスチャー名
	 * @param addTab ブロックを追加するタブ
	 * @param material ブロックマテリアル
	 * @param hardness ブロックの硬さ
	 * @param resistance 爆破耐性
	 * @param StepSound ブロックの上を歩いた時の音
	 * @param LightOpacity ブロックの透過係数 デフォルト0
	 * @param LightLevel ブロックの明るさ 1.0F ～ 15.0F
	 * @param toolClass 適正ツール名
	 * @param level ハーベストレベル
	 * @return ブロック
	 */
	public static Block CreatBlock(String name , String textureName , CreativeTabs addTab,Material material,float hardness ,float resistance, SoundType StepSound,int LightOpacity, float LightLevel,String toolClass,int level) {
		Block block = new NonFunctionalBlock(material);
		block.setBlockName(name);
		block.setBlockTextureName(textureName);
		if(addTab != null) block.setCreativeTab(addTab);
		if(hardness != -1) block.setHardness(hardness);
		if(resistance != -1) block.setResistance(resistance);
		if(StepSound != null) block.setStepSound(StepSound);
		if(LightOpacity != -1) block.setLightOpacity(LightOpacity);
		if(LightLevel != -1) block.setLightLevel(LightLevel);
		if(toolClass != null)block.setHarvestLevel(toolClass, level);
		return block;
		
	}
	
	/**
	 * <h1>CreatItem</h1>
	 * 簡易ブロックを作成します<br>
	 * @param name アイテム名
	 * @param textureName テクスチャー名
	 * @param addTab 追加するタブ
	 * @return ブロック
	 */
	public static Block CreatBlock(String name , String textureName , CreativeTabs addTab,Material material) {
		return CreatBlock(name, textureName, addTab , material,-1.0F,-1.0F,null,-1,-1.0F,null,-1);
	}
	
	
	
}
