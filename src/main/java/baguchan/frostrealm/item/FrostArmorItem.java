package baguchan.frostrealm.item;

import baguchan.frostrealm.registry.FrostArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

public class FrostArmorItem extends Item {
    public FrostArmorItem(FrostArmorMaterials.FrostArmorMaterial p_371793_, ArmorType p_371848_, Item.Properties p_40388_) {
        super(p_371793_.humanoidProperties(p_40388_, p_371848_));
    }
}
