package baguchan.frostrealm.client.render.state;

import baguchan.frostrealm.entity.Yeti;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.AnimationState;

public class YetiRenderState extends HumanoidRenderState {

    public final AnimationState sitAnimationState = new AnimationState();
    public final AnimationState sitPoseAnimationState = new AnimationState();

    public final AnimationState sitUpAnimationState = new AnimationState();
    public Yeti.State state = Yeti.State.IDLING;

}
