package baguchan.frostrealm.client.render.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class VenochemRenderState extends LivingEntityRenderState {
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState shootAnimationState = new AnimationState();
}
