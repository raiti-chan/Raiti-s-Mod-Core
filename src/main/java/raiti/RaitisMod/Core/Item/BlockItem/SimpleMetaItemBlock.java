package raiti.RaitisMod.Core.Item.BlockItem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * メタデータ持ちブロックのシンプルなItemBlockクラス
 * <br>Created by Raiti-chan on 2016/11/19.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class SimpleMetaItemBlock extends RItemBlock {
	
	public SimpleMetaItemBlock(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
		
	}
}
