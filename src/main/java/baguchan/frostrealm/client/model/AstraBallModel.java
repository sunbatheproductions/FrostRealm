package baguchan.frostrealm.client.model;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class AstraBallModel<T extends LivingEntityRenderState> extends EntityModel<T> {
    private final ModelPart root;
    private final ModelPart bone;
    private final ModelPart bone2;

    public AstraBallModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
        this.bone = this.root.getChild("bone");
        this.bone2 = this.root.getChild("bone2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(29, 0).addBox(-10.0F, 0.0F, -6.0F, 5.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition bone2 = root.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(19, 0).addBox(6.0F, 0.0F, -6.0F, 5.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity) {
        super.setupAnim(entity);
        float f = entity.ageInTicks * 0.65F;


        this.bone.yRot = f;
        this.bone2.yRot = f;
        this.root.yRot = entity.yRot * ((float) Math.PI / 180F);
        this.root.xRot = entity.xRot * ((float) Math.PI / 180F);
    }
}