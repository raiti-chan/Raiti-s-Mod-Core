package raiti.RaitisMod.Core.Client.Renderer.itemRenderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * ブラックホールチェストのアイテムレンダ―
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class BlackHoleChestItemRenderer implements IItemRenderer {
	
	private TileEntitySpecialRenderer renderer;
	
	private TileEntity entity;
	
	public BlackHoleChestItemRenderer(TileEntitySpecialRenderer renderer, TileEntity entity) {
		this.renderer = renderer;
		this.entity = entity;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
			case INVENTORY:
			case ENTITY:
			case EQUIPPED:
			case EQUIPPED_FIRST_PERSON:
			case FIRST_PERSON_MAP:
				return true;
			default:
				return false;
		}
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if (type == ItemRenderType.ENTITY) GL11.glTranslatef(-0.5f, 0.0f, -0.5f);
		this.renderer.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0f);
	}
}
