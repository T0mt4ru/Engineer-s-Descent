package com.tomtaru.tmt_engineersdescent.datagen;

import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import net.minecraft.core.HolderLookup;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Tmt_engineersdescent.MODID)
public class TmtModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();
        var blockTagsProvider = new BlockTagsProvider(packOutput, lookupProvider, Tmt_engineersdescent.MODID, existingFileHelper) {
            @Override
            protected void addTags(HolderLookup.Provider provider) {

            }
        };

        generator.addProvider(event.includeServer(), new TmtModRecipeProvider(packOutput, lookupProvider));
        //generator.addProvider(event.includeServer(), new ModFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new TmtModItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        //generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        //generator.addProvider(event.includeClient(), new TmtModItemModelProvider(packOutput, existingFileHelper));
    }
}