package baguchan.frostrealm.client.render.layer;

import baguchan.frostrealm.client.model.SnowPileQuailModel;
import baguchan.frostrealm.client.render.state.SnowPileQuailRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class QuailHeldItemLayer<T extends SnowPileQuailRenderState> extends RenderLayer<T, SnowPileQuailModel<T>> {
	public QuailHeldItemLayer(RenderLayerParent<T, SnowPileQuailModel<T>> p_116994_) {
		super(p_116994_);
	}

	public void render(PoseStack p_117007_, MultiBufferSource p_117008_, int p_117009_, SnowPileQuailRenderState p_117010_, float p_117011_, float p_117012_) {
		if (this.getParentModel() instanceof HeadedModel) {
			BakedModel bakedmodel = p_117010_.getMainHandItemModel();
			if (bakedmodel != null) {
				boolean flag1 = p_117010_.isBaby;
				p_117007_.pushPose();
				if (flag1) {
					float f = 0.75F;
					p_117007_.scale(0.75F, 0.75F, 0.75F);
					p_117007_.translate(0.0D, 0.5D, -0.2D);
				}

				this.getParentModel().body.translateAndRotate(p_117007_);
				this.getParentModel().getHead().translateAndRotate(p_117007_);
				p_117007_.translate(0.0D, 0.05D, -0.42D);
				p_117007_.mulPose(Axis.XP.rotationDegrees(90.0F));
				p_117007_.mulPose(Axis.ZP.rotationDegrees(-60.0F));
				ItemStack itemstack = p_117010_.getMainHandItem();
				Minecraft.getInstance().getItemRenderer().render(itemstack, ItemDisplayContext.GROUND, false, p_117007_, p_117008_, p_117009_, OverlayTexture.NO_OVERLAY, bakedmodel);
				p_117007_.popPose();
			}
		}
	}
}