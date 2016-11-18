package raiti.RaitisMod.Core.Item.BlockItem;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import raiti.RaitisMod.Core.Block.RBlock;

import java.util.List;

/**
 * ブラックホールチェストのアイテム
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class BlackHoleChestItem extends RItemBlock {
	
	public BlackHoleChestItem(Block block) {
		super(block);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean isDebug) {
		NBTTagCompound tags = item.getTagCompound();
		NBTTagCompound compound = tags != null ? tags.getCompoundTag("ChestItem") : null;
		if (compound != null) {
			ItemStack stack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("Item"));
			if (stack != null) list.add(StatCollector.translateToLocal("itemStack.RaitisModCore.BlackHoleChestItem.item.name") + stack.getDisplayName());
			if (stack != null)list.add(StatCollector.translateToLocal("itemStack.RaitisModCore.BlackHoleChestItem.size.name") + compound.getLong("Size"));
			if (stack == null)list.add(StatCollector.translateToLocal("itemStack.RaitisModCore.BlackHoleChestItem.null.name"));
		} else list.add(StatCollector.translateToLocal("itemStack.RaitisModCore.BlackHoleChestItem.null.name"));
		
	}
	
}
