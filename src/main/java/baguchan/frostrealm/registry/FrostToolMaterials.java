package baguchan.frostrealm.registry;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class FrostToolMaterials {
    public static final FrostToolMaterial ASTRIUM = new FrostToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 320, 6.0F, 2.0F, 16);
    public static final FrostToolMaterial SILVER_MOON = new FrostToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 560, 7.0F, 2.0F, 20);
    public static final FrostToolMaterial GLACINIUM = new FrostToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2531, 9.5F, 5.5F, 18);

    public record FrostToolMaterial(
            TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus,
            int enchantmentValue
    ) {

        private Item.Properties applyCommonProperties(Item.Properties p_363001_) {
            return p_363001_.durability(this.durability).enchantable(this.enchantmentValue);
        }

        public Item.Properties applyToolProperties(Item.Properties p_361405_, TagKey<Block> p_360697_, float p_363434_, float p_364177_) {
            HolderGetter<Block> holdergetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
            return this.applyCommonProperties(p_361405_)
                    .component(
                            DataComponents.TOOL,
                            new Tool(
                                    List.of(
                                            Tool.Rule.deniesDrops(holdergetter.getOrThrow(this.incorrectBlocksForDrops)),
                                            Tool.Rule.minesAndDrops(holdergetter.getOrThrow(p_360697_), this.speed)
                                    ),
                                    1.0F,
                                    1
                            )
                    )
                    .attributes(this.createToolAttributes(p_363434_, p_364177_));
        }

        private ItemAttributeModifiers createToolAttributes(float p_360296_, float p_360629_) {
            return ItemAttributeModifiers.builder()
                    .add(
                            Attributes.ATTACK_DAMAGE,
                            new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double) (p_360296_ + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND
                    )
                    .add(
                            Attributes.ATTACK_SPEED,
                            new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double) p_360629_, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND
                    )
                    .build();
        }

        public Item.Properties applySwordProperties(Item.Properties p_363768_, float p_361044_, float p_361067_) {
            HolderGetter<Block> holdergetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
            return this.applyCommonProperties(p_363768_)
                    .component(
                            DataComponents.TOOL,
                            new Tool(
                                    List.of(
                                            Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F),
                                            Tool.Rule.overrideSpeed(holdergetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)
                                    ),
                                    1.0F,
                                    2
                            )
                    )
                    .attributes(this.createSwordAttributes(p_361044_, p_361067_));
        }

        private ItemAttributeModifiers createSwordAttributes(float p_364643_, float p_363683_) {
            return ItemAttributeModifiers.builder()
                    .add(
                            Attributes.ATTACK_DAMAGE,
                            new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double) (p_364643_ + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND
                    )
                    .add(
                            Attributes.ATTACK_SPEED,
                            new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double) p_363683_, AttributeModifier.Operation.ADD_VALUE),
                            EquipmentSlotGroup.MAINHAND
                    ).build();
        }
    }
}