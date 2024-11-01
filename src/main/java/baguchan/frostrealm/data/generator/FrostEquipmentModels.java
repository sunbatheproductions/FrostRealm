package baguchan.frostrealm.data.generator;

import baguchan.frostrealm.FrostRealm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentModel;

import java.util.function.BiConsumer;

public interface FrostEquipmentModels {
    ResourceLocation ASTRIUM = FrostRealm.prefix("astrium");
    ResourceLocation FROST_BOAR_FUR = FrostRealm.prefix("frost_boar_fur");
    ResourceLocation YETI_FUR = FrostRealm.prefix("yeti_fur");

    static void bootstrap(BiConsumer<ResourceLocation, EquipmentModel> p_371586_) {
        p_371586_.accept(ASTRIUM, onlyHumanoid("astrium"));
        p_371586_.accept(FROST_BOAR_FUR, onlyHumanoid("frost_boar_fur"));
        p_371586_.accept(YETI_FUR, onlyHumanoid("yeti_fur"));
    }


    private static EquipmentModel onlyHumanoid(String p_371738_) {
        return EquipmentModel.builder().addHumanoidLayers(FrostRealm.prefix(p_371738_)).build();
    }

    private static EquipmentModel onlyHumanoidAndWolf(String p_371738_) {
        return EquipmentModel.builder().addHumanoidLayers(FrostRealm.prefix(p_371738_)).addLayers(EquipmentModel.LayerType.WOLF_BODY, EquipmentModel.Layer.onlyIfDyed(FrostRealm.prefix(p_371738_), false)).build();
    }
}