package baguchan.frostrealm.registry;

import baguchan.frostrealm.item.*;
import baguchan.frostrealm.item.block.DeferredBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static baguchan.frostrealm.FrostRealm.MODID;

public class FrostItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredHolder<Item, Item> FROST_CRYSTAL = ITEMS.registerItem("frost_crystal", (properties) -> new FrostCrystalItem(properties));

    public static final DeferredHolder<Item, Item> CRYONITE = ITEMS.registerItem("cryonite", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> CRYONITE_CREAM = ITEMS.registerItem("cryonite_cream", (properties) -> new GlimmerRockItem(properties));

    public static final DeferredHolder<Item, Item> WARPED_CRYSTAL = ITEMS.registerItem("warped_crystal", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> VENOM_CRYSTAL = ITEMS.registerItem("venom_crystal", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> UNSTABLE_VENOM_CRYSTAL = ITEMS.registerItem("unstable_venom_crystal", (properties) -> new SmithableCrystalItem(properties));
    public static final DeferredHolder<Item, Item> GLIMMERROCK = ITEMS.registerItem("glimmerrock", (properties) -> new GlimmerRockItem(properties));
    public static final DeferredHolder<Item, Item> ASTRIUM_RAW = ITEMS.registerItem("astrium_raw", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> ASTRIUM_INGOT = ITEMS.registerItem("astrium_ingot", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> STARDUST_CRYSTAL = ITEMS.registerItem("stardust_crystal", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> GLACINIUM_CRYSTAL = ITEMS.registerItem("glacinium_crystal", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> GLACINIUM_INGOT = ITEMS.registerItem("glacinium_ingot", (properties) -> new Item(properties));


    public static final DeferredHolder<Item, Item> FROZEN_FRUIT = ITEMS.registerItem("frozen_fruit", (properties) -> new Item(properties.food(FrostFoods.FROZEN_FRUIT)));
    public static final DeferredHolder<Item, Item> MELTED_FRUIT = ITEMS.registerItem("melted_fruit", (properties) -> new Item(properties.food(FrostFoods.MELTED_FRUIT)));
    public static final DeferredHolder<Item, Item> SUGARBEET = ITEMS.registerItem("sugarbeet", (properties) -> new Item(properties.food(FrostFoods.SUGARBEET)));
    public static final DeferredHolder<Item, Item> SUGARBEET_SEEDS = ITEMS.registerItem("sugarbeet_seeds", (properties) -> new DeferredBlockItem(FrostBlocks.SUGARBEET, properties));
    public static final DeferredHolder<Item, Item> RYE = ITEMS.registerItem("rye", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> RYE_BREAD = ITEMS.registerItem("rye_bread", (properties) -> new Item((properties.food(FrostFoods.RYE_BREAD))));
    public static final DeferredHolder<Item, Item> RYE_PANCAKE = ITEMS.registerItem("rye_pancake", (properties) -> new Item((properties.food(FrostFoods.RYE_PANCAKE))));
    public static final DeferredHolder<Item, Item> RYE_SEEDS = ITEMS.registerItem("rye_seeds", (properties) -> new DeferredBlockItem(FrostBlocks.RYE, properties));
    public static final DeferredHolder<Item, Item> BEARBERRY = ITEMS.registerItem("bearberry", (properties) -> new DeferredBlockItem(FrostBlocks.BEARBERRY_BUSH, properties));
    public static final DeferredHolder<Item, Item> COOKED_BEARBERRY = ITEMS.registerItem("bearberry_cooked", (properties) -> new Item(properties.food(FrostFoods.COOKED_BEARBERRY)));
    public static final DeferredHolder<Item, Item> COOKED_SNOWPILE_QUAIL_EGG = ITEMS.registerItem("cooked_snowpile_quail_egg", (properties) -> new Item(properties.food(FrostFoods.COOKED_SNOWPILE_QUAIL_EGG)));
    public static final DeferredHolder<Item, Item> SNOWPILE_QUAIL_MEAT = ITEMS.registerItem("snowpile_quail_meat", (properties) -> new Item(properties.food(FrostFoods.SNOWPILE_QUAIL_MEAT)));
    public static final DeferredHolder<Item, Item> COOKED_SNOWPILE_QUAIL_MEAT = ITEMS.registerItem("cooked_snowpile_quail_meat", (properties) -> new Item(properties.food(FrostFoods.COOKED_SNOWPILE_QUAIL_MEAT)));
    public static final DeferredHolder<Item, Item> FROST_BOAR_MEAT = ITEMS.registerItem("frost_boar_meat", (properties) -> new Item(properties.food(FrostFoods.FROST_BOAR_MEAT)));
    public static final DeferredHolder<Item, Item> COOKED_FROST_BOAR_MEAT = ITEMS.registerItem("cooked_frost_boar_meat", (properties) -> new Item(properties.food(FrostFoods.COOKED_FROST_BOAR_MEAT)));

    public static final DeferredHolder<Item, Item> FROST_CATALYST = ITEMS.registerItem("frost_catalyst", (properties) -> new FrostCatalystItem(properties.stacksTo(1).durability(64)));
    public static final DeferredHolder<Item, Item> STRAY_NECKLACE_PART = ITEMS.registerItem("stray_necklace_part", (properties) -> new Item(properties));

    public static final DeferredHolder<Item, Item> YETI_FUR = ITEMS.registerItem("yeti_fur", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> FROST_BOAR_FUR = ITEMS.registerItem("frost_boar_fur", (properties) -> new Item(properties));
    public static final DeferredHolder<Item, Item> FROST_SPEAR = ITEMS.registerItem("frost_spear", (properties) -> new FrostSpearItem((properties.attributes(FrostSpearItem.createAttributes()).enchantable(20).durability(1021).rarity(Rarity.UNCOMMON))));
    public static final DeferredHolder<Item, Item> SILVER_MOON = ITEMS.registerItem("silver_moon", (properties) -> new SilverMoonSwordItem(FrostToolMaterials.SILVER_MOON, 3, -2.2F, (properties.rarity(Rarity.RARE))));

    public static final DeferredHolder<Item, Item> ASTRIUM_SWORD = ITEMS.registerItem("astrium_sword", (properties) -> new FrostSwordItem(FrostToolMaterials.ASTRIUM, 3, -2.3F, properties));
    public static final DeferredHolder<Item, Item> ASTRIUM_AXE = ITEMS.registerItem("astrium_axe", (properties) -> new FrostAxeItem(FrostToolMaterials.ASTRIUM, 6F, -3.0F, properties));
    public static final DeferredHolder<Item, Item> ASTRIUM_PICKAXE = ITEMS.registerItem("astrium_pickaxe", (properties) -> new FrostPickaxeItem(FrostToolMaterials.ASTRIUM, 1, -2.7F, properties));
    public static final DeferredHolder<Item, Item> ASTRIUM_SHOVEL = ITEMS.registerItem("astrium_shovel", (properties) -> new FrostShovelItem(FrostToolMaterials.ASTRIUM, 1.5F, -2.9F, properties));
    public static final DeferredHolder<Item, Item> ASTRIUM_HOE = ITEMS.registerItem("astrium_hoe", (properties) -> new FrostHoeItem(FrostToolMaterials.ASTRIUM, -2, -1.0F, properties));
    public static final DeferredHolder<Item, Item> ASTRIUM_SICKLE = ITEMS.registerItem("astrium_sickle", (properties) -> new SickleItem(FrostToolMaterials.ASTRIUM, 8.0F, -3.3F, properties));

    public static final DeferredHolder<Item, Item> GLACINIUM_SWORD = ITEMS.registerItem("glacinium_sword", (properties) -> new FrostSwordItem(FrostToolMaterials.GLACINIUM, 3, -2.6F, properties));
    public static final DeferredHolder<Item, Item> GLACINIUM_AXE = ITEMS.registerItem("glacinium_axe", (properties) -> new FrostAxeItem(FrostToolMaterials.GLACINIUM, 4F, -3.1F, properties));
    public static final DeferredHolder<Item, Item> GLACINIUM_PICKAXE = ITEMS.registerItem("glacinium_pickaxe", (properties) -> new FrostPickaxeItem(FrostToolMaterials.GLACINIUM, 1, -2.9F, properties));
    public static final DeferredHolder<Item, Item> GLACINIUM_SHOVEL = ITEMS.registerItem("glacinium_shovel", (properties) -> new FrostShovelItem(FrostToolMaterials.GLACINIUM, 1.5F, -3.0F, properties));
    public static final DeferredHolder<Item, Item> GLACINIUM_HOE = ITEMS.registerItem("glacinium_hoe", (properties) -> new FrostHoeItem(FrostToolMaterials.GLACINIUM, -2, -1.0F, properties));
    public static final DeferredHolder<Item, Item> GLACINIUM_SICKLE = ITEMS.registerItem("glacinium_sickle", (properties) -> new SickleItem(FrostToolMaterials.GLACINIUM, 6.0F, -3.4F, properties));


    public static final DeferredHolder<Item, Item> YETI_FUR_HELMET = ITEMS.registerItem("yeti_fur_helmet", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.YETI_FUR, ArmorType.HELMET, (properties.durability(ArmorType.HELMET.getDurability(20)))));
    public static final DeferredHolder<Item, Item> YETI_FUR_CHESTPLATE = ITEMS.registerItem("yeti_fur_chestplate", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.YETI_FUR, ArmorType.CHESTPLATE, (properties.durability(ArmorType.CHESTPLATE.getDurability(20)))));
    public static final DeferredHolder<Item, Item> YETI_FUR_LEGGINGS = ITEMS.registerItem("yeti_fur_leggings", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.YETI_FUR, ArmorType.LEGGINGS, (properties.durability(ArmorType.LEGGINGS.getDurability(20)))));
    public static final DeferredHolder<Item, Item> YETI_FUR_BOOTS = ITEMS.registerItem("yeti_fur_boots", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.YETI_FUR, ArmorType.BOOTS, (properties.durability(ArmorType.BOOTS.getDurability(20)))));

    public static final DeferredHolder<Item, Item> FROST_BOAR_FUR_HELMET = ITEMS.registerItem("frost_boar_fur_helmet", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.FROST_BOAR_FUR, ArmorType.HELMET, (properties.durability(ArmorType.HELMET.getDurability(20)))));
    public static final DeferredHolder<Item, Item> FROST_BOAR_FUR_CHESTPLATE = ITEMS.registerItem("frost_boar_fur_chestplate", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.FROST_BOAR_FUR, ArmorType.CHESTPLATE, (properties.durability(ArmorType.CHESTPLATE.getDurability(20)))));
    public static final DeferredHolder<Item, Item> FROST_BOAR_FUR_LEGGINGS = ITEMS.registerItem("frost_boar_fur_leggings", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.FROST_BOAR_FUR, ArmorType.LEGGINGS, (properties.durability(ArmorType.LEGGINGS.getDurability(20)))));
    public static final DeferredHolder<Item, Item> FROST_BOAR_FUR_BOOTS = ITEMS.registerItem("frost_boar_fur_boots", (properties) -> new YetiFurArmorItem(FrostArmorMaterials.FROST_BOAR_FUR, ArmorType.BOOTS, (properties.durability(ArmorType.BOOTS.getDurability(20)))));


    public static final DeferredHolder<Item, Item> ASTRIUM_HELMET = ITEMS.registerItem("astrium_helmet", (properties) -> new FrostArmorItem(FrostArmorMaterials.ASTRIUM, ArmorType.HELMET, (properties.durability(ArmorType.HELMET.getDurability(22)))));
    public static final DeferredHolder<Item, Item> ASTRIUM_CHESTPLATE = ITEMS.registerItem("astrium_chestplate", (properties) -> new FrostArmorItem(FrostArmorMaterials.ASTRIUM, ArmorType.CHESTPLATE, (properties.durability(ArmorType.CHESTPLATE.getDurability(22)))));
    public static final DeferredHolder<Item, Item> ASTRIUM_LEGGINGS = ITEMS.registerItem("astrium_leggings", (properties) -> new FrostArmorItem(FrostArmorMaterials.ASTRIUM, ArmorType.LEGGINGS, (properties.durability(ArmorType.LEGGINGS.getDurability(22)))));
    public static final DeferredHolder<Item, Item> ASTRIUM_BOOTS = ITEMS.registerItem("astrium_boots", (properties) -> new FrostArmorItem(FrostArmorMaterials.ASTRIUM, ArmorType.BOOTS, (properties.durability(ArmorType.BOOTS.getDurability(22)))));
    public static final DeferredHolder<Item, Item> WOLFFLUE_ASTRIUM_ARMOR = ITEMS.registerItem("wolfflue_astrium_armor", (properties) -> new WolfflueArmorItem(FrostArmorMaterials.ASTRIUM_WOLF, (properties.durability(ArmorType.BODY.getDurability(22)))));


    public static final DeferredHolder<Item, Item> MARMOT_SPAWNEGG = ITEMS.registerItem("marmot_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.MARMOT, 0xB18346, 0x9B6B2D, properties));
    public static final DeferredHolder<Item, Item> SNOWPILE_QUAIL_SPAWNEGG = ITEMS.registerItem("snowpile_quail_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.SNOWPILE_QUAIL, 0xFFFFFF, 0xFFFFFF, properties));
    public static final DeferredHolder<Item, Item> YETI_SPAWNEGG = ITEMS.registerItem("yeti_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.YETI, 0xD4D7DB, 0x403656, properties));
    public static final DeferredHolder<Item, Item> FROST_WRAITH_SPAWNEGG = ITEMS.registerItem("frost_wraith_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.FROST_WRAITH, 0x895D7B, 0xD15EBE, properties));
    public static final DeferredHolder<Item, Item> CRYSTAL_FOX_SPAWNEGG = ITEMS.registerItem("crystal_fox_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.CRYSTAL_FOX, 0xF7FFFB, 0x90D3E8, properties));
    public static final DeferredHolder<Item, Item> SNOW_MOLE_SPAWNEGG = ITEMS.registerItem("snow_mole_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.SNOW_MOLE, 0xE4E5E6, 0xB6A7A7, properties));
    public static final DeferredHolder<Item, Item> ASTRA_BALL_SPAWNEGG = ITEMS.registerItem("astra_ball_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.ASTRA_BALL, 0x9352CC, 0xE3A6FF, properties));
    public static final DeferredHolder<Item, Item> FROST_BOAR_SPAWNEGG = ITEMS.registerItem("frost_boar_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.FROST_BOAR, 0x031822, 0x296B89, properties));
    public static final DeferredHolder<Item, Item> WOLFFLUE_SPAWNEGG = ITEMS.registerItem("wolfflue_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.WOLFFLUE, 0x9CAAB1, 0xAFA58A, properties));
    public static final DeferredHolder<Item, Item> FERRET_SPAWNEGG = ITEMS.registerItem("ferret_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.FERRET, 0x795C5A, 0x41312D, properties));
    public static final DeferredHolder<Item, Item> SEAL_SPAWNEGG = ITEMS.registerItem("seal_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.SEAL, 0xFFFFFF, 0xFFFFFF, properties));
    public static final DeferredHolder<Item, Item> STRAY_WARRIOR_SPAWNEGG = ITEMS.registerItem("seeker_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.SEEKER, 6387319, 14543594, properties));
    public static final DeferredHolder<Item, Item> VENOCHEM_SPAWNEGG = ITEMS.registerItem("venochem_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.VENOCHEM, 0x400659, 0xCE5487, properties));
    public static final DeferredHolder<Item, Item> GOKKUR_SPAWNEGG = ITEMS.registerItem("gokkur_spawn_egg", (properties) -> new DeferredSpawnEggItem(FrostEntities.GOKKUR, 0xA09D96, 0x6F6965, properties));
}
