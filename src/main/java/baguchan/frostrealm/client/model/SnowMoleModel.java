package baguchan.frostrealm.client.model;// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

public class SnowMoleModel<T extends LivingEntityRenderState> extends EntityModel<T> {
	private final ModelPart root;
	private final ModelPart handR;
	private final ModelPart handL;

	public SnowMoleModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
		this.handR = this.root.getChild("handR");
		this.handL = this.root.getChild("handL");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 0).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition nose = root.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition handR = root.addOrReplaceChild("handR", CubeListBuilder.create().texOffs(39, 0).addBox(-5.0F, -1.0F, -3.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition handL = root.addOrReplaceChild("handL", CubeListBuilder.create().texOffs(39, 7).addBox(0.0F, -1.0F, -3.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
    public void setupAnim(T entity) {
        super.setupAnim(entity);
        this.root.xRot = entity.yRot * ((float) Math.PI / 180F);
        this.root.yRot = entity.xRot * ((float) Math.PI / 180F);

        this.handR.zRot = Mth.cos(entity.walkAnimationPos * 0.6662F * 0.6F) * 1.25F * entity.walkAnimationSpeed;
        this.handL.zRot = Mth.cos(entity.walkAnimationPos * 0.6662F * 0.6F + (float) Math.PI) * 1.25F * entity.walkAnimationSpeed;
	}
}