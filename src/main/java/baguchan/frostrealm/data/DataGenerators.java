package baguchan.frostrealm.data;

import baguchan.frostrealm.FrostRealm;
import baguchan.frostrealm.data.generator.*;
import baguchan.frostrealm.data.generator.recipe.CraftingGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = FrostRealm.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		DatapackBuiltinEntriesProvider datapackProvider = new RegistryDataGenerator(packOutput, event.getLookupProvider());

		CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();
		generator.addProvider(event.includeServer(), datapackProvider);
		event.getGenerator().addProvider(event.includeServer(), new FrostAdvancementData(packOutput, lookupProvider, event.getExistingFileHelper()));
		event.getGenerator().addProvider(event.includeClient(), new BlockstateGenerator(packOutput, event.getExistingFileHelper()));
		event.getGenerator().addProvider(event.includeClient(), new ItemModelGenerator(packOutput, event.getExistingFileHelper()));
		generator.addProvider(event.includeClient(), new FrostEquipmentModelProvider(packOutput));

		event.getGenerator().addProvider(event.includeServer(), LootGenerator.create(packOutput, lookupProvider));

		event.getGenerator().addProvider(event.includeServer(), new Runner(packOutput, lookupProvider));
		generator.addProvider(event.includeServer(), new FrostDataMaps(packOutput, lookupProvider));
		BlockTagsProvider blocktags = new BlockTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper());
		event.getGenerator().addProvider(event.includeServer(), blocktags);
		event.getGenerator().addProvider(event.includeServer(), new ItemTagGenerator(packOutput, lookupProvider, blocktags.contentsGetter(), event.getExistingFileHelper()));
		event.getGenerator().addProvider(event.includeServer(), new EntityTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper()));
		event.getGenerator().addProvider(event.includeServer(), new FluidTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper()));
		event.getGenerator().addProvider(event.includeServer(), new BiomeTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper()));
		event.getGenerator().addProvider(event.includeServer(), new DamageTypeTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper()));
	}

	public static final class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
			super(output, lookupProvider);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
			return new CraftingGenerator(lookupProvider, output);
		}

		@Override
		public String getName() {
			return FrostRealm.MODID + "recipes";
		}
	}
}