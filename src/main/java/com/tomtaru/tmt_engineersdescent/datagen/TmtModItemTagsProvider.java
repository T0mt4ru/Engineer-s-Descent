package com.tomtaru.tmt_engineersdescent.datagen;


import com.tomtaru.tmt_engineersdescent.TmtModData;
import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
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
                ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "compat/sythian_soil"));

        TagKey<Item> emburSoilCompat = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "compat/embur_soil"));

        TagKey<Item> crimsonSoilCompat = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "compat/crimson_soil"));

        TagKey<Item> arisianSoilCompat = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "compat/arisian_soil"));

        TagKey<Item> wailingSoilCompat = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "compat/wailing_soil"));

        TagKey<Item> netherMossReplacable = TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "compat/nether_moss_replacable"));

        tag(synthianSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "sythian_nylium")));
        tag(synthianSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "sythian_soil")));

        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.MC.modid(), "netherrack")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.MC.modid(), "basalt")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.MC.modid(), "blackstone")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.MC.modid(), "crimson_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.MC.modid(), "warped_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "blue_netherrack")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "wailing_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "embur_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "sythian_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "crimson_blackstone_nylium")));
        tag(netherMossReplacable).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "sythian_soil")));

        tag(emburSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "embur_nylium")));
        tag(emburSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "embur_moss_block")));

        tag(crimsonSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.MC.modid(), "crimson_nylium")));
        tag(crimsonSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "crimson_blackstone_nylium")));

        tag(arisianSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "arisian_moss_block")));

        tag(wailingSoilCompat).add(TagEntry.element(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.ND.modid(), "wailing_nylium")));
    }
}