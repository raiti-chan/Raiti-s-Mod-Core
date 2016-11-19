package raiti.RaitisMod.Core.Client.Renderer.SpecialRender;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import raiti.RaitisMod.Core.RaitisModCoreMain;
import raiti.RaitisMod.Core.TileEntity.BlackHoleChestTile;
import raiti.RaitisMod.Core.Client.Renderer.model.BlackHoleChestModel;

import java.nio.FloatBuffer;
import java.util.Random;

/**
 * ブラックホールチェストのレンダ―
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class BlackHoleChestRenderer extends TileEntitySpecialRenderer {
	private static final ResourceLocation TEXTURE_END_SKY = new ResourceLocation("minecraft:textures/environment/end_sky.png");
	private static final ResourceLocation TEXTURE_END_PORTAL = new ResourceLocation("minecraft:textures/entity/end_portal.png");
	private static final ResourceLocation TEXTURE_MODEL = new ResourceLocation(RaitisModCoreMain.MOD_ID+":textures/model/blackhole_chest.png");
	private static final Random RANDOM = new Random(31100L);
	private FloatBuffer floatBuffer = GLAllocation.createDirectFloatBuffer(16);
	
	private void renderTileEntityAt(double x, double y, double z) {
		
		BlackHoleChestModel model = new BlackHoleChestModel();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
		GL11.glRotatef(180f, 0f, 0f, 1f);
		this.bindTexture(TEXTURE_MODEL);
		GL11.glPushMatrix();
		model.render(0.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		
		float f1 = (float) this.field_147501_a.field_147560_j;
		float f2 = (float) this.field_147501_a.field_147561_k;
		float f3 = (float) this.field_147501_a.field_147558_l;
		GL11.glDisable(GL11.GL_LIGHTING);
		RANDOM.setSeed(31100L);
		float heightT = 15F / 16F;
		float heightB = 1F / 16F;
		float heightST = 14F / 16F;
		float heightSB = 2F / 16F;
		
		for (int i = 0; i < 16; ++i) {
			GL11.glPushMatrix();
			float f5 = (float) (16 - i);
			float f6 = 0.0625F;
			float f7 = 1.0F / (f5 + 1.0F);
			
			if (i == 0) {
				this.bindTexture(TEXTURE_END_SKY);
				f7 = 0.1F;
				f5 = 65.0F;
				f6 = 0.125F;
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			}
			
			if (i == 1) {
				this.bindTexture(TEXTURE_END_PORTAL);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
				f6 = 0.5F;
			}
			float f8 = (float) (-(y + (double) heightT));
			float f9 = f8 + ActiveRenderInfo.objectY;
			float f10 = f8 + f5 + ActiveRenderInfo.objectY;
			float f11 = f9 / f10;
			f11 += (float) (y + (double) heightT);
			GL11.glTranslatef(f1, f11, f3);
			GL11.glTexGeni(GL11.GL_S, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
			GL11.glTexGeni(GL11.GL_T, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
			GL11.glTexGeni(GL11.GL_R, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
			GL11.glTexGeni(GL11.GL_Q, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_EYE_LINEAR);
			GL11.glTexGen(GL11.GL_S, GL11.GL_OBJECT_PLANE, this.floatFlip(1.0F, 0.0F, 0.0F, 0.0F));
			GL11.glTexGen(GL11.GL_T, GL11.GL_OBJECT_PLANE, this.floatFlip(0.0F, 0.0F, 1.0F, 0.0F));
			GL11.glTexGen(GL11.GL_R, GL11.GL_OBJECT_PLANE, this.floatFlip(0.0F, 0.0F, 0.0F, 1.0F));
			GL11.glTexGen(GL11.GL_Q, GL11.GL_EYE_PLANE, this.floatFlip(0.0F, 1.0F, 0.0F, 0.0F));
			GL11.glEnable(GL11.GL_TEXTURE_GEN_S);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_T);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_R);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_Q);
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_TEXTURE);
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
			GL11.glTranslatef(0.0F, (float) (Minecraft.getSystemTime() % 700000L) / 700000.0F, 0.0F);
			GL11.glScalef(f6, f6, f6);
			GL11.glTranslatef(0.5F, 0.5F, 0.0F);
			GL11.glRotatef((float) (i * i * 4321 + i * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
			GL11.glTranslatef(-f1, -f3, -f2);
			f9 = f8 + ActiveRenderInfo.objectY;
			GL11.glTranslatef(ActiveRenderInfo.objectX * f5 / f9, ActiveRenderInfo.objectZ * f5 / f9, -f2);
			Tessellator tessellator = Tessellator.instance;
			f11 = RANDOM.nextFloat() * 0.5F + 0.1F;
			float f12 = RANDOM.nextFloat() * 0.5F + 0.4F;
			float f13 = RANDOM.nextFloat() * 0.5F + 0.5F;
			
			if (i == 0) {
				f13 = 1.0F;
				f12 = 1.0F;
				f11 = 1.0F;
			}
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
			tessellator.addVertex(x + 2F / 16F, y + heightT, z + 2F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightT, z + 14F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightT, z + 14F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightT, z + 2F / 16F);
			tessellator.draw();
			

			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
			tessellator.addVertex(x + 14F / 16F, y + heightST, z + 2F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightST, z + 14F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightSB, z + 14F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightSB, z + 2F / 16F);
			tessellator.draw();
			
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
			tessellator.addVertex(x + 14F / 16F, y + heightST, z + 14F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightST, z + 14F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightSB, z + 14F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightSB, z + 14F / 16F);
			tessellator.draw();
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			//==================================================================================================================
			GL11.glPushMatrix();
			f5 = (float) (16 - i);
			f6 = 0.0625F;
			f7 = 1.0F / (f5 + 1.0F);
			
			if (i == 0) {
				this.bindTexture(TEXTURE_END_SKY);
				f7 = 0.1F;
				f5 = 65.0F;
				f6 = 0.125F;
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			}
			
			if (i == 1) {
				this.bindTexture(TEXTURE_END_PORTAL);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
				f6 = 0.5F;
			}
			f8 = (float) (-(y + (double) heightB));
			f9 = f8 + ActiveRenderInfo.objectY;
			f10 = f8 + f5 + ActiveRenderInfo.objectY;
			f11 = f9 / f10;
			f11 += (float) (y + (double) heightB);
			GL11.glTranslatef(f1, f11, f3);
			GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
			GL11.glTexGeni(GL11.GL_S, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
			GL11.glTexGeni(GL11.GL_T, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
			GL11.glTexGeni(GL11.GL_R, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
			GL11.glTexGeni(GL11.GL_Q, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_EYE_LINEAR);
			GL11.glTexGen(GL11.GL_S, GL11.GL_OBJECT_PLANE, this.floatFlip(-1.0F, 0.0F, 0.0F, 0.0F));
			GL11.glTexGen(GL11.GL_T, GL11.GL_OBJECT_PLANE, this.floatFlip(0.0F, 0.0F, -1.0F, 0.0F));
			GL11.glTexGen(GL11.GL_R, GL11.GL_OBJECT_PLANE, this.floatFlip(0.0F, 0.0F, 0.0F, 1.0F));
			GL11.glTexGen(GL11.GL_Q, GL11.GL_EYE_PLANE, this.floatFlip(0.0F, -1.0F, 0.0F, 0.0F));
			GL11.glEnable(GL11.GL_TEXTURE_GEN_S);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_T);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_R);
			GL11.glEnable(GL11.GL_TEXTURE_GEN_Q);
			GL11.glCullFace(GL11.GL_FRONT);
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_TEXTURE);
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
			GL11.glTranslatef(0.0F, (float) (Minecraft.getSystemTime() % 700000L) / 700000.0F, 0.0F);
			GL11.glScalef(f6, f6, f6);
			GL11.glTranslatef(0.5F, 0.5F, 0.0F);
			GL11.glRotatef((float) (i * i * 4321 + i * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
			GL11.glTranslatef(-f1, -f3, -f2);
			f9 = f8 + ActiveRenderInfo.objectY;
			GL11.glTranslatef(ActiveRenderInfo.objectX * f5 / f9, ActiveRenderInfo.objectZ * f5 / f9, -f2);
			f11 = RANDOM.nextFloat() * 0.5F + 0.1F;
			f12 = RANDOM.nextFloat() * 0.5F + 0.4F;
			f13 = RANDOM.nextFloat() * 0.5F + 0.5F;
			if (i == 0) {
				f13 = 1.0F;
				f12 = 1.0F;
				f11 = 1.0F;
			}
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
			tessellator.addVertex(x + 14F / 16F, y + heightB, z + 14F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightB, z + 2F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightB, z + 2F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightB, z + 14F / 16F);
			tessellator.draw();
			
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
			tessellator.addVertex(x + 2F / 16F, y + heightST, z + 2F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightST, z + 14F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightSB, z + 14F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightSB, z + 2F / 16F);
			tessellator.draw();
			
			tessellator.startDrawingQuads();
			tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
			tessellator.addVertex(x + 14F / 16F, y + heightST, z + 2F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightST, z + 2F / 16F);
			tessellator.addVertex(x + 2F / 16F, y + heightSB, z + 2F / 16F);
			tessellator.addVertex(x + 14F / 16F, y + heightSB, z + 2F / 16F);
			tessellator.draw();
			
			GL11.glCullFace(GL11.GL_BACK);
			GL11.glPopMatrix();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			//==================================================================================================================
			
			
			
		}
		
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_GEN_S);
		GL11.glDisable(GL11.GL_TEXTURE_GEN_T);
		GL11.glDisable(GL11.GL_TEXTURE_GEN_R);
		GL11.glDisable(GL11.GL_TEXTURE_GEN_Q);
		GL11.glEnable(GL11.GL_LIGHTING);
	}
	
	private FloatBuffer floatFlip(float f1, float f2, float f3, float f4) {
		this.floatBuffer.clear();
		this.floatBuffer.put(f1).put(f2).put(f3).put(f4);
		this.floatBuffer.flip();
		return this.floatBuffer;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		if (tile instanceof BlackHoleChestTile) {
			renderTileEntityAt(x, y, z);
		}
	}
	
}
