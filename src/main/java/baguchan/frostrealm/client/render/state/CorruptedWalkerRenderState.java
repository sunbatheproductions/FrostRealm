package baguchan.frostrealm.client.render.state;

import baguchan.frostrealm.entity.hostile.part.CorruptedWalkerPartContainer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class CorruptedWalkerRenderState extends LivingEntityRenderState {
    public List<CorruptedWalkerPartContainer> container = Lists.newArrayList();
}
