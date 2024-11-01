package baguchan.frostrealm.client;

import baguchan.frostrealm.FrostRealm;
import baguchan.frostrealm.api.recipe.AttachableCrystal;
import baguchan.frostrealm.client.animation.SpearAttackAnimations;
import baguchan.frostrealm.data.resource.registries.AttachableCrystals;
import baguchan.frostrealm.registry.FrostAnimations;
import baguchan.frostrealm.registry.FrostDataCompnents;
import baguchan.frostrealm.registry.FrostItems;
import baguchan.frostrealm.utils.aurorapower.AuroraPowerUtils;
import baguchi.bagus_lib.animation.BaguAnimationController;
import baguchi.bagus_lib.client.event.BagusModelEvent;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.UUID;

@EventBusSubscriber(modid = FrostRealm.MODID, value = Dist.CLIENT)
public class ClientEvents {
    protected static final UUID BASE_ATTACK_DAMAGE_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    protected static final UUID BASE_ATTACK_SPEED_UUID = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");
    public static final DecimalFormat ATTRIBUTE_MODIFIER_FORMAT = Util.make(new DecimalFormat("#.##"), (p_41704_) -> {
        p_41704_.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT));
    });

    @SubscribeEvent
    public static void onAuroraToolTip(ItemTooltipEvent event) {
        AuroraPowerUtils.getAuroraPowers(event.getItemStack()).addToTooltip(event.getContext(), component -> {
            event.getToolTip().add(component);
        }, TooltipFlag.NORMAL);
        @Nullable Holder<AttachableCrystal> attachableCrystal = event.getItemStack().get(FrostDataCompnents.ATTACH_CRYSTAL);
        int damage = event.getItemStack().getOrDefault(FrostDataCompnents.CRYSTAL_USED, 0);

        if (attachableCrystal != null) {
            int damage2 = (attachableCrystal.value().getUse() - damage);
            event.getToolTip().add(Component.translatable(Util.makeDescriptionId("attach_crystal", event.getContext().registries().lookup(AttachableCrystals.ATTACHABLE_CRYSTAL_REGISTRY_KEY).get().getOrThrow(attachableCrystal.getKey()).getKey().location()))
                    .append(" ").append(damage2 + " / " + attachableCrystal.value().getUse()));
        }
    }

    @SubscribeEvent
    public static void animationEvent(BagusModelEvent.PostAnimate bagusModelEvent) {
        BaguAnimationController animationController = bagusModelEvent.getBaguAnimationController();
        if (bagusModelEvent.getEntityRenderState().getMainHandItem().is(FrostItems.FROST_SPEAR.get())) {
            if (bagusModelEvent.getEntityRenderState().mainArm == HumanoidArm.RIGHT) {
                bagusModelEvent.getModel().getAnyDescendantWithName("right_arm").get().resetPose();
                bagusModelEvent.getModel().getAnyDescendantWithName("left_arm").get().resetPose();
                bagusModelEvent.applyStatic(SpearAttackAnimations.idle_right);
                if (animationController.getAnimationState(FrostAnimations.ATTACK).isStarted()) {
                    bagusModelEvent.animate(animationController.getAnimationState(FrostAnimations.ATTACK), SpearAttackAnimations.spear_attack_right, bagusModelEvent.getEntityRenderState().ageInTicks, 2.0F);
                } else {
                    bagusModelEvent.applyStatic(SpearAttackAnimations.idle_right);
                }
            } else {
                bagusModelEvent.getModel().getAnyDescendantWithName("right_arm").get().resetPose();
                bagusModelEvent.getModel().getAnyDescendantWithName("left_arm").get().resetPose();
                if (animationController.getAnimationState(FrostAnimations.ATTACK).isStarted()) {
                    bagusModelEvent.animate(animationController.getAnimationState(FrostAnimations.ATTACK), SpearAttackAnimations.spear_attack_left, bagusModelEvent.getEntityRenderState().ageInTicks, 2.0F);
                } else {
                    bagusModelEvent.applyStatic(SpearAttackAnimations.idle_left);
                }
            }
        }
    }
}
