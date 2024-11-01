package baguchan.frostrealm.client.render;

import baguchan.frostrealm.FrostRealm;
import baguchan.frostrealm.client.FrostModelLayers;
import baguchan.frostrealm.client.model.FrostWraithModel;
import baguchan.frostrealm.client.render.state.FrostWraithRenderState;
import baguchan.frostrealm.entity.hostile.FrostWraith;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FrostWraithRenderer extends MobRenderer<FrostWraith, FrostWraithRenderState, FrostWraithModel<FrostWraithRenderState>> {
	private static final ResourceLocation WRAITH = ResourceLocation.fromNamespaceAndPath(FrostRealm.MODID, "textures/entity/frost_wraith/frost_wraith.png");
	private static final RenderType WRAITH_GLOW = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(FrostRealm.MODID, "textures/entity/frost_wraith/frost_wraith_glow.png"));

	private static final float HALF_SQRT_3 = (float) (Math.sqrt(30.0) / 2.0);

	public FrostWraithRenderer(EntityRendererProvider.Context p_173952_) {
		super(p_173952_, new FrostWraithModel<>(p_173952_.bakeLayer(FrostModelLayers.FROST_WRAITH)), 0.5F);
		this.addLayer(new EyesLayer<FrostWraithRenderState, FrostWraithModel<FrostWraithRenderState>>(this) {
			@Override
			public RenderType renderType() {
				return WRAITH_GLOW;
			}
		});
	}

	@Override
	public FrostWraithRenderState createRenderState() {
		return new FrostWraithRenderState();
	}

	@Override
	public ResourceLocation getTextureLocation(FrostWraithRenderState p_368654_) {
		return WRAITH;
	}
}