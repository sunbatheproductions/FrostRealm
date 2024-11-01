package baguchan.frostrealm.item;

import baguchan.frostrealm.registry.FrostToolMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SilverMoonSwordItem extends SwordItem {
    public SilverMoonSwordItem(FrostToolMaterials.FrostToolMaterial toolMaterial, float p_362481_, float p_364182_, Properties p_43272_) {
        super(toolMaterial.applySwordProperties(p_43272_, p_362481_, p_364182_));
    }


    @Override
    public float getAttackDamageBonus(Entity p_344900_, float damage, DamageSource p_344972_) {
        if (p_344972_.getDirectEntity() instanceof LivingEntity livingentity) {
            float f = (1 / Mth.sin(Mth.clamp(p_344900_.distanceTo(livingentity) * 0.5F, 0.1F, 1F)));
            float f1 = Mth.clamp(f * f - 1, 0.0F, 3F);
            return f1 * 2F;
        }
        return 0.0F;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, tooltipContext, components, flag);
        components.add(Component.translatable(getDescriptionId() + ".tooltip"));
    }
}
