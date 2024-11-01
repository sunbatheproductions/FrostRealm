package baguchan.frostrealm.client.render;

import baguchan.frostrealm.FrostRealm;
import baguchan.frostrealm.client.FrostModelLayers;
import baguchan.frostrealm.client.model.VenomBallModel;
import baguchan.frostrealm.client.render.state.ProjectileRenderState;
import baguchan.frostrealm.entity.projectile.VenomBall;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class VenomBallRenderer<T extends VenomBall> extends EntityRenderer<T, ProjectileRenderState> {
    private static final ResourceLocation LLAMA_SPIT_LOCATION = ResourceLocation.fromNamespaceAndPath(FrostRealm.MODID, "textures/entity/venom_ball.png");
    private final VenomBallModel<ProjectileRenderState> model;

    public VenomBallRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new VenomBallModel<>(context.bakeLayer(FrostModelLayers.VENOM_BALL));
    }

    @Override
    public void render(ProjectileRenderState llamaSpit, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 4F / 16F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(llamaSpit.yRot - 180F));
        poseStack.mulPose(Axis.XP.rotationDegrees(llamaSpit.xRot));

        poseStack.translate(0.0F, -1.501F + 3F / 16F, -2.5F / 16F);
        this.model.setupAnim(llamaSpit);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(LLAMA_SPIT_LOCATION));
        this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(llamaSpit, poseStack, multiBufferSource, i);
    }

    @Override
    public ProjectileRenderState createRenderState() {
        return new ProjectileRenderState();
    }

    @Override
    public void extractRenderState(T p_362104_, ProjectileRenderState p_361028_, float p_362204_) {
        super.extractRenderState(p_362104_, p_361028_, p_362204_);
        p_361028_.xRot = p_362104_.getXRot(p_362204_);
        p_361028_.yRot = p_362104_.getYRot(p_362204_);
    }

    public ResourceLocation getTextureLocation(ProjectileRenderState llamaSpit) {
        return LLAMA_SPIT_LOCATION;
    }
}