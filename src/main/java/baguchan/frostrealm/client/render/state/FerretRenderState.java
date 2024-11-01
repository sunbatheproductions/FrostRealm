package baguchan.frostrealm.client.render.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.item.DyeColor;

import javax.annotation.Nullable;

public class FerretRenderState extends LivingEntityRenderState {

    public boolean isSitting;
    @Nullable
    public DyeColor collarColor;
    public float running;

}
