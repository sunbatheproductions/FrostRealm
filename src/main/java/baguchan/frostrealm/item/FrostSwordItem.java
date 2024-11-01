package baguchan.frostrealm.item;

import baguchan.frostrealm.registry.FrostToolMaterials;
import net.minecraft.world.item.SwordItem;

public class FrostSwordItem extends SwordItem {
    public FrostSwordItem(FrostToolMaterials.FrostToolMaterial tofuItemTier, float p_362481_, float p_364182_, Properties properties) {
        super(tofuItemTier.applySwordProperties(properties, p_362481_, p_364182_));
    }
}
