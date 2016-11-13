package raiti.RaitisMod.Core.item.blockItem;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by Raiti-chan on 2016/11/12.
 *
 * @author Raiti-chan
 */
public class BlackHoleChestItem extends ItemBlock {
	
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
			if (stack != null) list.add(StatCollector.translateToLocal("itemStack.BlackHoleChestItem.item.name") + stack.getDisplayName());
			if (stack != null)list.add(StatCollector.translateToLocal("itemStack.BlackHoleChestItem.size.name") + compound.getLong("Size"));
			if (stack == null)list.add(StatCollector.translateToLocal("itemStack.BlackHoleChestItem.null.name"));
		} else list.add(StatCollector.translateToLocal("itemStack.BlackHoleChestItem.null.name"));
		
	}
	
}
