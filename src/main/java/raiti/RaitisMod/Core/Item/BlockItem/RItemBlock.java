package raiti.RaitisMod.Core.Item.BlockItem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import raiti.RaitisMod.Core.Block.IRBlock;
import raiti.RaitisMod.Core.Block.RBlock;
import raiti.RaitisMod.Core.Item.IRItem;

/**
 * Raiti'sMODのItemBlockのベースクラス
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class RItemBlock extends ItemBlock implements IRItem {
	
	public RItemBlock(Block block) {
		super(block);
	}
	
	@Override
	public String getRItemName() {
		return ((IRBlock) this.field_150939_a).getRItemName();
	}
}
