package baguchan.frostrealm.client.armpose;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.neoforged.neoforge.client.IArmPoseTransformer;

public class RubHandArmPose implements IArmPoseTransformer {

	@Override
    public void applyTransform(HumanoidModel<?> model, HumanoidRenderState entity, HumanoidArm arm) {
        if (entity.isUsingItem) {
            model.rightArm.zRot = -0.5F + Mth.cos((entity.ageInTicks) * 0.6662F) * 0.25F;
            model.rightArm.xRot = -0.75F;
            model.leftArm.zRot = 0.5F - Mth.cos((entity.ageInTicks) * 0.6662F) * 0.25F;
            model.leftArm.xRot = -0.75F;
        } else {
            model.rightArm.zRot = -0.5F;
            model.rightArm.xRot = -0.75F;
            model.leftArm.zRot = 0.5F;
            model.leftArm.xRot = -0.75F;
        }
    }
}
