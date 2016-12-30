package raiti.RaitisMod.Core.Item.Tool;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import raiti.RaitisMod.Core.Item.RItemRegister;

/**
 * 圧縮石の斧
 * <br>Created by Raiti-chan on 2016/12/29.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class CompressedStoneAxe extends RItemTool {
	
	public CompressedStoneAxe() {
		super(3.0F, RToolMaterial.COMPRESSED_STONE);
		this.setUnlocalizedName("CompressedStoneAxe");
		this.setTextureName("compressed_stone_axe");
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("axe");
	}
	
	@Override
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
		return 1.0F;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		if (entity.isSneaking() && block instanceof BlockWood && world.rand.nextInt(10) < 3) {
			if (!world.isRemote) {
				ItemStack stack = new ItemStack(RItemRegister.Cutting_board_base, world.rand.nextInt(4) + 1);
				EntityItem item = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, stack);
				world.spawnEntityInWorld(item);
				world.setBlockToAir(x,y,z);
				world.markBlockForUpdate(x,y,z);
			}
			Minecraft.getMinecraft().renderGlobal.playAuxSFX(null, 2001, x, y, z, Block.getIdFromBlock(block));
			return false;
		}
		
		
		return super.onBlockDestroyed(itemStack, world, block, x, y, z, entity);
	}
}
