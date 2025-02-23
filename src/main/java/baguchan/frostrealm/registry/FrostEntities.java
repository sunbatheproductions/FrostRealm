package baguchan.frostrealm.registry;

import baguchan.frostrealm.FrostRealm;
import baguchan.frostrealm.entity.Yeti;
import baguchan.frostrealm.entity.animal.*;
import baguchan.frostrealm.entity.hostile.*;
import baguchan.frostrealm.entity.hostile.part.CorruptedWalker;
import baguchan.frostrealm.entity.projectile.VenomBall;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber(modid = FrostRealm.MODID, bus = EventBusSubscriber.Bus.MOD)
public class FrostEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FrostRealm.MODID);

    public static final Supplier<EntityType<Marmot>> MARMOT = ENTITIES.register("marmot", () -> EntityType.Builder.of(Marmot::new, MobCategory.CREATURE).sized(0.65F, 0.6F).eyeHeight(0.4F).build(prefix("marmot")));
    public static final Supplier<EntityType<SnowPileQuail>> SNOWPILE_QUAIL = ENTITIES.register("snowpile_quail", () -> EntityType.Builder.of(SnowPileQuail::new, MobCategory.CREATURE).sized(0.6F, 0.6F).eyeHeight(0.4F).build(prefix("snowpile_quail")));
    public static final Supplier<EntityType<CrystalFox>> CRYSTAL_FOX = ENTITIES.register("crystal_fox", () -> EntityType.Builder.of(CrystalFox::new, MobCategory.CREATURE).sized(0.6F, 0.7F).eyeHeight(0.4F).clientTrackingRange(8).build(prefix("crystal_fox")));
    public static final Supplier<EntityType<SnowMole>> SNOW_MOLE = ENTITIES.register("snow_mole", () -> EntityType.Builder.of(SnowMole::new, MobCategory.CREATURE).sized(0.6F, 0.6F).eyeHeight(0.3F).clientTrackingRange(8).immuneTo(Blocks.POWDER_SNOW).immuneTo(Blocks.POWDER_SNOW_CAULDRON).build(prefix("snow_mole")));
    public static final Supplier<EntityType<Seal>> SEAL = ENTITIES.register("seal", () -> EntityType.Builder.of(Seal::new, MobCategory.CREATURE).sized(0.95F, 0.8F).eyeHeight(0.45F).clientTrackingRange(10).build(prefix("seal")));
    public static final Supplier<EntityType<Wolfflue>> WOLFFLUE = ENTITIES.register("wolfflue", () -> EntityType.Builder.of(Wolfflue::new, MobCategory.CREATURE).sized(1.25F, 1.4F).eyeHeight(1.2F).clientTrackingRange(10).build(prefix("wolfflue")));
    public static final Supplier<EntityType<Ferret>> FERRET = ENTITIES.register("ferret", () -> EntityType.Builder.of(Ferret::new, MobCategory.CREATURE).sized(1.0F, 0.4F).eyeHeight(0.3F).clientTrackingRange(10).build(prefix("ferret")));

    public static final Supplier<EntityType<Yeti>> YETI = ENTITIES.register("yeti", () -> EntityType.Builder.of(Yeti::new, MobCategory.CREATURE).sized(1.6F, 1.95F).eyeHeight(1.75F).build(prefix("yeti")));
    public static final Supplier<EntityType<FrostWraith>> FROST_WRAITH = ENTITIES.register("frost_wraith", () -> EntityType.Builder.of(FrostWraith::new, FrostMobCategory.FROSTREALM_WEATHER_MONSTER).sized(0.6F, 2.1F).build(prefix("frost_wraith")));
    public static final Supplier<EntityType<Seeker>> SEEKER = ENTITIES.register("seeker", () -> EntityType.Builder.of(Seeker::new, MobCategory.MONSTER).sized(0.6F, 1.99F).immuneTo(Blocks.POWDER_SNOW).clientTrackingRange(8).build(prefix("seeker")));

    public static final Supplier<EntityType<AstraBall>> ASTRA_BALL = ENTITIES.register("astra_ball", () -> EntityType.Builder.of(AstraBall::new, MobCategory.MONSTER).sized(0.5F, 0.5F).eyeHeight(0.25F).build(prefix("astra_ball")));
    public static final Supplier<EntityType<FrostBoar>> FROST_BOAR = ENTITIES.register("frost_boar", () -> EntityType.Builder.of(FrostBoar::new, MobCategory.CREATURE).sized(1.8F, 1.95F).eyeHeight(1.5F).build(prefix("frost_boar")));
    public static final Supplier<EntityType<CorruptedWalker>> CORRUPTED_WALKER = ENTITIES.register("corruped_walker", () -> EntityType.Builder.of(CorruptedWalker::new, FrostMobCategory.FROSTREALM_WEATHER_MONSTER).sized(1.0F, 1.0F).eyeHeight(0.8F).fireImmune().build(prefix("corruped_walker")));
    public static final Supplier<EntityType<Venochem>> VENOCHEM = ENTITIES.register("venochem", () -> EntityType.Builder.of(Venochem::new, MobCategory.MONSTER).sized(0.9F, 0.8F).eyeHeight(0.45F).fireImmune().build(prefix("venochem")));
    public static final Supplier<EntityType<Gokkur>> GOKKUR = ENTITIES.register("gokkur", () -> EntityType.Builder.of(Gokkur::new, MobCategory.MONSTER).sized(1.0F, 1.2F).eyeHeight(0.525F).fireImmune().build(prefix("gokkur")));

    public static final Supplier<EntityType<VenomBall>> VENOM_BALL = ENTITIES.register("venom_ball", () -> EntityType.Builder.<VenomBall>of(VenomBall::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(8).updateInterval(30).build(prefix("venom_ball")));


    private static ResourceKey<EntityType<?>> prefix(String path) {
        return ResourceKey.create(Registries.ENTITY_TYPE, FrostRealm.prefix(path));
    }


    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
        event.put(MARMOT.get(), Marmot.createAttributes().build());
        event.put(SNOWPILE_QUAIL.get(), SnowPileQuail.createAttributes().build());
        event.put(CRYSTAL_FOX.get(), CrystalFox.createAttributes().build());
        event.put(SNOW_MOLE.get(), SnowMole.createAttributes().build());
        event.put(SEAL.get(), Seal.createAttributes().build());
        event.put(WOLFFLUE.get(), Wolfflue.createAttributes().build());
        event.put(FERRET.get(), Ferret.createAttributes().build());
        event.put(YETI.get(), Yeti.createAttributeMap().build());
        event.put(FROST_WRAITH.get(), FrostWraith.createAttributes().build());
        event.put(SEEKER.get(), Seeker.createAttributes().build());
        event.put(ASTRA_BALL.get(), AstraBall.createAttributes().build());
        event.put(FROST_BOAR.get(), FrostBoar.createAttributes().build());
        event.put(CORRUPTED_WALKER.get(), CorruptedWalker.createAttributeMap().build());
        event.put(VENOCHEM.get(), Venochem.createAttributes().build());
        event.put(GOKKUR.get(), Gokkur.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawn(RegisterSpawnPlacementsEvent event) {
        event.register(MARMOT.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Marmot::checkFrostAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(SNOWPILE_QUAIL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnowPileQuail::checkFrostAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(CRYSTAL_FOX.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrystalFox::checkFrostAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(SNOW_MOLE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnowMole::checkSnowMoleSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(SEAL.get(), SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Seal::checkSealSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(WOLFFLUE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Wolfflue::checkWolfSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(FERRET.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ferret::checkWolfSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(YETI.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(FROST_WRAITH.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WarpedMonster::checkWarpedMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);

        event.register(SEEKER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Seeker::checkStraySpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(ASTRA_BALL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(FROST_BOAR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FrostBoar::checkFrostAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(VENOCHEM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(GOKKUR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.OR);
    }
}