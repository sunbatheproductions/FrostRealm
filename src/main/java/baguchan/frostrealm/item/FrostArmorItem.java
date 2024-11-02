package baguchan.frostrealm.item;

import baguchan.frostrealm.registry.FrostArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;

public class FrostArmorItem extends Item {
    public final ArmorType armorType;
    public FrostArmorItem(FrostArmorMaterials.FrostArmorMaterial p_371793_, ArmorType p_371848_, Item.Properties p_40388_) {
        super(p_371793_.humanoidProperties(p_40388_, p_371848_));
        this.armorType = p_371848_;
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return armorType.getSlot();
    }
}
