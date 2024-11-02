package baguchan.frostrealm.client.render.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class SnowPileQuailRenderState extends LivingEntityRenderState {
    public final AnimationState shakeAnimationState = new AnimationState();
    public final AnimationState popEggAnimationState = new AnimationState();
    public float flap;
    public float flapSpeed;
}
