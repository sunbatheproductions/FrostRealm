package baguchan.frostrealm.client.render;

import baguchan.frostrealm.FrostRealm;
import baguchan.frostrealm.client.FrostModelLayers;
import baguchan.frostrealm.client.model.AstraBallModel;
import baguchan.frostrealm.entity.hostile.AstraBall;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AstraBallRenderer<T extends AstraBall> extends MobRenderer<T, LivingEntityRenderState, AstraBallModel<LivingEntityRenderState>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(FrostRealm.MODID, "textures/entity/astra_ball.png");

    public AstraBallRenderer(EntityRendererProvider.Context p_173952_) {
        super(p_173952_, new AstraBallModel<>(p_173952_.bakeLayer(FrostModelLayers.ASTRA_BALL)), 0.5F);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(LivingEntityRenderState p_110775_1_) {
        return TEXTURE;
    }
}