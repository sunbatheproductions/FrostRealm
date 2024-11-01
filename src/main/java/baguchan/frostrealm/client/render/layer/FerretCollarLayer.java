package baguchan.frostrealm.client.render.layer;

import baguchan.frostrealm.FrostRealm;
import baguchan.frostrealm.client.model.FerretModel;
import baguchan.frostrealm.client.render.state.FerretRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class FerretCollarLayer<T extends FerretRenderState> extends RenderLayer<T, FerretModel<T>> {
    private static final ResourceLocation COLLAR_LOCATION = ResourceLocation.fromNamespaceAndPath(FrostRealm.MODID, "textures/entity/ferret/ferret_collar.png");

    public FerretCollarLayer(RenderLayerParent<T, FerretModel<T>> p_117707_) {
        super(p_117707_);
    }

    public void render(
            PoseStack p_117720_,
            MultiBufferSource p_117721_,
            int p_117722_,
            T p_117723_,
            float p_117724_,
            float p_117725_
    ) {
        if (p_117723_.collarColor != null && !p_117723_.isInvisible) {
            int i = p_117723_.collarColor.getTextureDiffuseColor();
            VertexConsumer vertexconsumer = p_117721_.getBuffer(RenderType.entityCutoutNoCull(COLLAR_LOCATION));
            this.getParentModel().renderToBuffer(p_117720_, vertexconsumer, p_117722_, OverlayTexture.NO_OVERLAY, i);
        }
    }
}
