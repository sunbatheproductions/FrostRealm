package baguchan.frostrealm.client.render.state;

import baguchi.bagus_lib.entity.AnimationScale;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.world.entity.AnimationState;

public class SeekerRenderState extends SkeletonRenderState {
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState counterAnimationState = new AnimationState();
    public AnimationScale guardAnimationScale = new AnimationScale(0.2F);

}
