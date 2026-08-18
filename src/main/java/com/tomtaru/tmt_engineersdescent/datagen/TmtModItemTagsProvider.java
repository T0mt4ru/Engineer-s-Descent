package com.tomtaru.tmt_engineersdescent.datagen;


import com.tomtaru.tmt_engineersdescent.TmtModData;
import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class TmtModItemTagsProvider extends ItemTagsProvider {

    public TmtModItemTagsProvider(PackOutput output,
                                  CompletableFuture<HolderLookup.Provider> lookupProvider,
                                  CompletableFuture<TagLookup<Block>> blockTags,
                                  ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Tmt_engineersdescent.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagKey<Item> synthianSoilCompat = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.ED.id("compat/sythian_soil"));

        TagKey<Item> emburSoilCompat = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.ED.id("compat/embur_soil"));

        TagKey<Item> crimsonSoilCompat = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.ED.id("compat/crimson_soil"));

        TagKey<Item> arisianSoilCompat = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.ED.id("compat/arisian_soil"));

        TagKey<Item> wailingSoilCompat = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.ED.id( "compat/wailing_soil"));

        TagKey<Item> netherMossReplacable = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.ED.id("compat/nether_moss_replacable"));

        TagKey<Item> commonPendoriteOreBlock = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.C.id("ores/pendorite"));

        TagKey<Item> commonPendoriteDust = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.C.id("dusts/pendorite"));

        TagKey<Item> commonRawPendorite = TagKey.create(Registries.ITEM,
                TmtModData.ModPedia.C.id("raw_pendorite"));

        tag(synthianSoilCompat).add(TagEntry.element(TmtModData.ModPedia.ND.id("sythian_nylium")));
        tag(synthianSoilCompat).add(TagEntry.element(TmtModData.ModPedia.ND.id("sythian_soil")));

        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.MC.id("netherrack")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.MC.id("basalt")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.MC.id("blackstone")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.MC.id("crimson_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.MC.id("warped_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.ND.id("blue_netherrack")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.ND.id("wailing_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.ND.id("embur_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.ND.id("sythian_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.ND.id("crimson_blackstone_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(TmtModData.ModPedia.ND.id("sythian_soil")));

        tag(emburSoilCompat).add(TagEntry.element(TmtModData.ModPedia.ND.id("embur_nylium")));
        tag(emburSoilCompat).add(TagEntry.element(TmtModData.ModPedia.ND.id("embur_moss_block")));

        tag(crimsonSoilCompat).add(TagEntry.element(TmtModData.ModPedia.MC.id("crimson_nylium")));
        tag(crimsonSoilCompat).add(TagEntry.element(TmtModData.ModPedia.ND.id("crimson_blackstone_nylium")));

        tag(arisianSoilCompat).add(TagEntry.element(TmtModData.ModPedia.ND.id("arisian_moss_block")));

        tag(wailingSoilCompat).add(TagEntry.element(TmtModData.ModPedia.ND.id("wailing_nylium")));

        tag(commonPendoriteOreBlock).add(TagEntry.element(TmtModData.ModPedia.ND.id("pendorite_ore")));

        tag(commonPendoriteDust).add(TagEntry.element(TmtModData.ModPedia.ED.id("metal_dust_pendorite")));

        tag(commonRawPendorite).add(TagEntry.element(TmtModData.ModPedia.ND.id("raw_pendorite")));
    }
}