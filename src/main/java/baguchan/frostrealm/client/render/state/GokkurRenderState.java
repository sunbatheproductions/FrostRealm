package baguchan.frostrealm.client.render.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class GokkurRenderState extends LivingEntityRenderState {

    public float snowProgress;
    public boolean grass;

    public AnimationState rollAnimationState = new AnimationState();
    public AnimationState startRollAnimationState = new AnimationState();

}
