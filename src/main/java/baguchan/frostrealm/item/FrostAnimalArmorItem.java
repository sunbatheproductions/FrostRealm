package baguchan.frostrealm.item;

import baguchan.frostrealm.registry.FrostArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class FrostAnimalArmorItem extends Item {
    private final FrostAnimalArmorItem.BodyType bodyType;

    public FrostAnimalArmorItem(FrostArmorMaterials.FrostArmorMaterial p_371643_, FrostAnimalArmorItem.BodyType p_324315_, Item.Properties p_316341_) {
        super(p_371643_.animalProperties(p_316341_, p_324315_.allowedEntities));
        this.bodyType = p_324315_;
    }

    public FrostAnimalArmorItem(
            FrostArmorMaterials.FrostArmorMaterial p_376793_, FrostAnimalArmorItem.BodyType p_376841_, Holder<SoundEvent> p_381619_, boolean p_380020_, Item.Properties p_376147_
    ) {
        super(p_376793_.animalProperties(p_376147_, p_381619_, p_380020_, p_376841_.allowedEntities));
        this.bodyType = p_376841_;
    }

    @Override
    public SoundEvent getBreakingSound() {
        return this.bodyType.breakingSound;
    }

    public static enum BodyType {
        EQUESTRIAN(SoundEvents.ITEM_BREAK, EntityType.HORSE),
        CANINE(SoundEvents.WOLF_ARMOR_BREAK, EntityType.WOLF);

        final SoundEvent breakingSound;
        final HolderSet<EntityType<?>> allowedEntities;

        private BodyType(SoundEvent p_331429_, EntityType<?>... p_371577_) {
            this.breakingSound = p_331429_;
            this.allowedEntities = HolderSet.direct(EntityType::builtInRegistryHolder, p_371577_);
        }
    }
}
