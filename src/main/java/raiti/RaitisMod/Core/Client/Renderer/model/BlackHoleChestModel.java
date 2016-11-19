package raiti.RaitisMod.Core.Client.Renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * ブラックホールチェストのモデルコード
 */
public class BlackHoleChestModel extends ModelBase {
	
	private ModelRenderer FD;
	private ModelRenderer FU;
	private ModelRenderer FL;
	private ModelRenderer FR;
	private ModelRenderer BD;
	private ModelRenderer BU;
	private ModelRenderer BL;
	private ModelRenderer BR;
	private ModelRenderer RB;
	private ModelRenderer RU;
	private ModelRenderer LB;
	private ModelRenderer LU;
	
	public BlackHoleChestModel() {
		textureWidth = 64;
		textureHeight = 32;
		
		FD = new ModelRenderer(this, 0, 0);
		FD.addBox(0F, 0F, 0F, 16, 2, 2);
		FD.setRotationPoint(-8F, 22F, -8F);
		FD.setTextureSize(64, 32);
		FD.mirror = true;
		setRotation(FD, 0F, 0F, 0F);
		FU = new ModelRenderer(this, 0, 0);
		FU.addBox(0F, 0F, 0F, 16, 2, 2);
		FU.setRotationPoint(-8F, 8F, -8F);
		FU.setTextureSize(64, 32);
		FU.mirror = true;
		setRotation(FU, 0F, 0F, 0F);
		FL = new ModelRenderer(this, 28, 4);
		FL.addBox(0F, 0F, 0F, 2, 12, 2);
		FL.setRotationPoint(6F, 10F, -8F);
		FL.setTextureSize(64, 32);
		FL.mirror = true;
		setRotation(FL, 0F, 0F, 0F);
		FR = new ModelRenderer(this, 28, 4);
		FR.addBox(0F, 0F, 0F, 2, 12, 2);
		FR.setRotationPoint(-8F, 10F, -8F);
		FR.setTextureSize(64, 32);
		FR.mirror = true;
		setRotation(FR, 0F, 0F, 0F);
		BD = new ModelRenderer(this, 0, 0);
		BD.addBox(0F, 0F, 0F, 16, 2, 2);
		BD.setRotationPoint(-8F, 22F, 6F);
		BD.setTextureSize(64, 32);
		BD.mirror = true;
		setRotation(BD, 0F, 0F, 0F);
		BU = new ModelRenderer(this, 0, 0);
		BU.addBox(0F, 0F, 0F, 16, 2, 2);
		BU.setRotationPoint(-8F, 8F, 6F);
		BU.setTextureSize(64, 32);
		BU.mirror = true;
		setRotation(BU, 0F, 0F, 0F);
		BL = new ModelRenderer(this, 28, 4);
		BL.addBox(0F, 0F, 0F, 2, 12, 2);
		BL.setRotationPoint(6F, 10F, 6F);
		BL.setTextureSize(64, 32);
		BL.mirror = true;
		setRotation(BL, 0F, 0F, 0F);
		BR = new ModelRenderer(this, 28, 4);
		BR.addBox(0F, 0F, 0F, 2, 12, 2);
		BR.setRotationPoint(-8F, 10F, 6F);
		BR.setTextureSize(64, 32);
		BR.mirror = true;
		setRotation(BR, 0F, 0F, 0F);
		RB = new ModelRenderer(this, 0, 4);
		RB.addBox(0F, 0F, 0F, 2, 2, 12);
		RB.setRotationPoint(-8F, 22F, -6F);
		RB.setTextureSize(64, 32);
		RB.mirror = true;
		setRotation(RB, 0F, 0F, 0F);
		RU = new ModelRenderer(this, 0, 4);
		RU.addBox(0F, 0F, 0F, 2, 2, 12);
		RU.setRotationPoint(-8F, 8F, -6F);
		RU.setTextureSize(64, 32);
		RU.mirror = true;
		setRotation(RU, 0F, 0F, 0F);
		LB = new ModelRenderer(this, 0, 4);
		LB.addBox(0F, 0F, 0F, 2, 2, 12);
		LB.setRotationPoint(6F, 22F, -6F);
		LB.setTextureSize(64, 32);
		LB.mirror = true;
		setRotation(LB, 0F, 0F, 0F);
		LU = new ModelRenderer(this, 0, 4);
		LU.addBox(0F, 0F, 0F, 2, 2, 12);
		LU.setRotationPoint(6F, 8F, -6F);
		LU.setTextureSize(64, 32);
		LU.mirror = true;
		setRotation(LU, 0F, 0F, 0F);
	}
	
	public void render(float f) {
		FD.render(f);
		FU.render(f);
		FL.render(f);
		FR.render(f);
		BD.render(f);
		BU.render(f);
		BL.render(f);
		BR.render(f);
		RB.render(f);
		RU.render(f);
		LB.render(f);
		LU.render(f);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	
}
