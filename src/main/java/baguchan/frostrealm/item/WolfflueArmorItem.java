package baguchan.frostrealm.item;

import baguchan.frostrealm.registry.FrostArmorMaterials;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;

public class WolfflueArmorItem extends FrostAnimalArmorItem {
    private final ResourceLocation textureLocation;

    public WolfflueArmorItem(FrostArmorMaterials.FrostArmorMaterial armorMaterial, Item.Properties p_316341_) {
        super(armorMaterial, FrostAnimalArmorItem.BodyType.CANINE, p_316341_);
        ResourceLocation resourcelocation = armorMaterial.modelId().withPath(p_323717_ -> "textures/entity/wolfflue/armor/" + p_323717_);
        this.textureLocation = resourcelocation.withSuffix(".png");

    }

    public ResourceLocation getTexture() {
        return this.textureLocation;
    }
    @Override
    public SoundEvent getBreakingSound() {
        return SoundEvents.WOLF_ARMOR_BREAK;
    }
}
