package com.tomtaru.tmt_engineersdescent;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import blusunrize.immersiveengineering.client.utils.ClocheRenderFunctions;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class TmtModData {

    public enum ClocheRenderType {
        GENERIC,
        CROP
    }

    public enum TreeType {
        LOG,
        STEM,
        PEDU,
    }

    public enum PlantCategory {
        WAILING,
        EMBUR,
        ARISIAN,
        SYTHIAN,
        MOSS,
        CRIMSON
    }

    private static final String NOSECONDARIES = null;

    public record ModPedia(String modid, String modName) {
        public static final ModPedia C      = new ModPedia("c", "Common");
        public static final ModPedia FD     = new ModPedia("farmersdelight", "Farmer's Delight");
        public static final ModPedia IE     = new ModPedia("immersiveengineering", "Immersive Engineering");
        public static final ModPedia MC     = new ModPedia("minecraft", "Minecraft");
        public static final ModPedia ND     = new ModPedia("netherdescent", "Nether Descent");

        public ResourceLocation id(String path) {
            return ResourceLocation.fromNamespaceAndPath(this.modid, path);
        }
    }

    public record TreePedia(String treeName, TreeType treeType) {
        public static final TreePedia WAILING   = new TreePedia("wailing", TreeType.STEM);
        public static final TreePedia EMBUR     = new TreePedia("embur", TreeType.PEDU);
        public static final TreePedia ARISIAN   = new TreePedia("arisian", TreeType.LOG);
        public static final TreePedia SYTHIAN   = new TreePedia("sythian", TreeType.STEM);


        public static final List<TreePedia> TREEPEDIA = List.of(
                WAILING, EMBUR, ARISIAN, SYTHIAN
        );

        public ResourceLocation log() {
            return switch (this.treeType) {
                case LOG -> ModPedia.ND.id(this.treeName + "_log");
                case STEM -> ModPedia.ND.id(this.treeName + "_stem");
                case PEDU -> ModPedia.ND.id(this.treeName + "_pedu");
            };
        }

        public ResourceLocation wood() {
            return switch (this.treeType) {
                case LOG -> ModPedia.ND.id(this.treeName + "_wood");
                case STEM, PEDU -> ModPedia.ND.id(this.treeName + "_hyphae");
            };
        }

        public ResourceLocation strippedLog() {
            return switch (this.treeType) {
                case LOG -> ModPedia.ND.id("stripped_" + this.treeName + "_log");
                case STEM -> ModPedia.ND.id("stripped_" + this.treeName + "_stem");
                case PEDU -> ModPedia.ND.id("stripped_" + this.treeName + "_pedu");
            };
        }

        public ResourceLocation strippedWood() {
            return switch (this.treeType) {
                case LOG -> ModPedia.ND.id("stripped_" + this.treeName + "_wood");
                case STEM, PEDU -> ModPedia.ND.id("stripped_" + this.treeName + "_hyphae");
            };
        }

        public ResourceLocation planks() {
            return ModPedia.ND.id(this.treeName + "_planks");
        }

        public ResourceLocation stairs() {
            return ModPedia.ND.id(this.treeName + "_stairs");
        }

        public ResourceLocation slab() {
            return ModPedia.ND.id(this.treeName + "_slab");
        }

        public ResourceLocation door() {
            return ModPedia.ND.id(this.treeName + "_door");
        }

        public ResourceLocation bookshelf() {
            return ModPedia.ND.id(this.treeName + "_bookshelf");
        }

        public Holder<Item> getItemHolder(ResourceLocation id) {
            ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
            return BuiltInRegistries.ITEM.getHolderOrThrow(key);
        }

        public Ingredient getIngredient(ResourceLocation id) {
            return Ingredient.of(getItemHolder(id).value());
        }

        public boolean exists(ResourceLocation id) {
            return BuiltInRegistries.ITEM.containsKey(id);
        }
    }

    public record SoilPedia (String soilName) {
        public static final SoilPedia WAILING           = new SoilPedia("compat/wailing_soil");
        public static final SoilPedia EMBUR             = new SoilPedia("compat/embur_soil");
        public static final SoilPedia SYTHIAN           = new SoilPedia("compat/sythian_soil");
        public static final SoilPedia ARISIAN           = new SoilPedia("compat/arisian_soil");
        public static final SoilPedia MOSS              = new SoilPedia("compat/nether_moss_replacable");
        public static final SoilPedia CRIMSON           = new SoilPedia("compat/crimson_soil");


        public TagKey<Item> getTag() {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, this.soilName));
        }
    }

    public record HerbaPedia (String herbName, int yield, ClocheRenderType renderType, PlantCategory plantCategory, String secondaries) {
        public static final HerbaPedia WAILING_GRASS    = new HerbaPedia("wailing_grass", 1,
                ClocheRenderType.GENERIC, PlantCategory.WAILING, NOSECONDARIES);
        public static final HerbaPedia WAILING_BULB_BLOSSOM = new HerbaPedia("wailing_bulb_blossom", 1,
                ClocheRenderType.GENERIC, PlantCategory.WAILING, NOSECONDARIES);
        public static final HerbaPedia WAILING_FUNGUS = new HerbaPedia("wailing_fungus", 1,
                ClocheRenderType.GENERIC, PlantCategory.WAILING, "wailing_gills");
        public static final HerbaPedia EMBUR_SPROUTS    = new HerbaPedia("embur_sprouts", 1,
                ClocheRenderType.GENERIC, PlantCategory.EMBUR, NOSECONDARIES);
        public static final HerbaPedia EMBUR_ROOTS      = new HerbaPedia("embur_roots", 1,
                ClocheRenderType.GENERIC, PlantCategory.EMBUR, NOSECONDARIES);
        public static final HerbaPedia TALL_EMBUR_ROOTS = new HerbaPedia("tall_embur_roots", 1,
                ClocheRenderType.GENERIC, PlantCategory.EMBUR, NOSECONDARIES);
        public static final HerbaPedia EMBUR_MOSS_BLOCK       = new HerbaPedia("embur_moss_block", 1,
                ClocheRenderType.GENERIC, PlantCategory.MOSS, "embur_cave_moss");
        public static final HerbaPedia TALL_ARISIAN_SPROUTS = new HerbaPedia("tall_arisian_sprouts", 1,
                ClocheRenderType.GENERIC, PlantCategory.ARISIAN, NOSECONDARIES);
        public static final HerbaPedia ARISIAN_SPROUTS = new HerbaPedia("arisian_sprouts", 1,
                ClocheRenderType.GENERIC, PlantCategory.ARISIAN, NOSECONDARIES);
        public static final HerbaPedia ARISIAN_MOSS = new HerbaPedia("arisian_moss_block", 1,
                ClocheRenderType.GENERIC, PlantCategory.MOSS, NOSECONDARIES);
        public static final HerbaPedia ARISIAN_BLOSSOM = new HerbaPedia("arisian_blossom", 1,
                ClocheRenderType.GENERIC, PlantCategory.ARISIAN, NOSECONDARIES);
        public static final HerbaPedia ARISIAN_BRANCH = new HerbaPedia("arisian_branch", 1,
                ClocheRenderType.GENERIC, PlantCategory.ARISIAN, NOSECONDARIES);
        public static final HerbaPedia TALL_ARISIAN_DANDELIONS = new HerbaPedia("tall_arisian_dandelions", 1,
                ClocheRenderType.GENERIC, PlantCategory.ARISIAN, NOSECONDARIES);
        public static final HerbaPedia ARISIAN_DANDELIONS = new HerbaPedia("arisian_dandelions", 1,
                ClocheRenderType.GENERIC, PlantCategory.ARISIAN, NOSECONDARIES);
        public static final HerbaPedia SYTHIAN_SPROUTS = new HerbaPedia("sythian_sprouts", 1,
                ClocheRenderType.GENERIC, PlantCategory.SYTHIAN, NOSECONDARIES);
        public static final HerbaPedia SYTHIAN_ROOTS = new HerbaPedia("sythian_roots", 1,
                ClocheRenderType.GENERIC, PlantCategory.SYTHIAN, NOSECONDARIES);
        public static final HerbaPedia SYTHIAN_STALK = new HerbaPedia("sythian_stalk", 3,
                ClocheRenderType.GENERIC, PlantCategory.SYTHIAN, NOSECONDARIES);
        public static final HerbaPedia TALL_CRIMSON_ROOTS = new HerbaPedia("tall_crimson_roots", 1,
                ClocheRenderType.GENERIC, PlantCategory.CRIMSON, NOSECONDARIES);
        public static final HerbaPedia CRIMSON_BERRIES = new HerbaPedia("crimson_berries", 2,
                ClocheRenderType.CROP, PlantCategory.CRIMSON, NOSECONDARIES);
        public static final HerbaPedia FUNGAL_BULBS =  new HerbaPedia("fungal_bulbs", 1,
                ClocheRenderType.GENERIC, PlantCategory.MOSS, NOSECONDARIES);

        public static final List<HerbaPedia> HERBAPEDIA = List.of(
                WAILING_GRASS, WAILING_FUNGUS, WAILING_BULB_BLOSSOM, EMBUR_SPROUTS, EMBUR_ROOTS, TALL_EMBUR_ROOTS, EMBUR_MOSS_BLOCK, TALL_ARISIAN_SPROUTS,
                ARISIAN_SPROUTS, ARISIAN_MOSS, ARISIAN_BLOSSOM, ARISIAN_BRANCH, TALL_ARISIAN_DANDELIONS,
                ARISIAN_DANDELIONS, SYTHIAN_SPROUTS, SYTHIAN_ROOTS, SYTHIAN_STALK, TALL_CRIMSON_ROOTS, CRIMSON_BERRIES,
                FUNGAL_BULBS
        );

        public ResourceLocation seedItem() {
            return ModPedia.ND.id(this.herbName);
        }

        public Holder<Item> getItemHolder(ResourceLocation id) {
            ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
            return BuiltInRegistries.ITEM.getHolderOrThrow(key);
        }

        public Ingredient getIngredient(ResourceLocation id) {
            return Ingredient.of(getItemHolder(id).value());
        }

        public ResourceLocation cropRenderBlock() {
            if (herbName.equals("crimson_berries")) {
                return ModPedia.ND.id("crimson_berry_bush");
            }
            return ModPedia.ND.id(this.herbName);
        }

        public Block getCropRenderBlock() {
            return BuiltInRegistries.BLOCK.get(cropRenderBlock());
        }

        public ResourceLocation produceItem() {
            return ModPedia.ND.id(this.herbName);
        }

        public ResourceLocation secondaryItem() {
            if (this.secondaries != null) {
                return ModPedia.ND.id(this.secondaries);
            } else {
                return null;
            }
        }

        public ClocheRenderFunction getClocheRenderFunction() {
            return switch (this.renderType) {
                case CROP ->
                    new ClocheRenderFunctions.RenderFunctionCrop(getCropRenderBlock());
                case GENERIC ->
                    new ClocheRenderFunctions.RenderFunctionGeneric(getCropRenderBlock());
            };
        }

        public int getYield() {
            return this.yield;
        }

        public Ingredient getSoil() {
            return switch (this.plantCategory) {
                case WAILING -> Ingredient.of(SoilPedia.WAILING.getTag());
                case EMBUR ->  Ingredient.of(SoilPedia.EMBUR.getTag());
                case ARISIAN -> Ingredient.of(SoilPedia.ARISIAN.getTag());
                case SYTHIAN -> Ingredient.of(SoilPedia.SYTHIAN.getTag());
                case MOSS -> Ingredient.of(SoilPedia.MOSS.getTag());
                case CRIMSON -> Ingredient.of(SoilPedia.CRIMSON.getTag());
            };
        }
    }

    public record SandPedia (String sandType) {
        public static final SandPedia BLACK = new SandPedia("black");
        public static final SandPedia WHITE = new SandPedia("white");
        public static final SandPedia BLUE = new SandPedia("blue");
        public static final SandPedia PURPLE = new SandPedia("purple");
        public static final SandPedia PINK = new SandPedia("pink");
        public static final SandPedia WINDSWEPT = new SandPedia("windswept");

        public static final List<SandPedia> SANDPEDIA = List.of(
                BLACK, WHITE, BLUE, PURPLE, PINK, WINDSWEPT
        );

        public ResourceLocation sand() {
            return ModPedia.ND.id(this.sandType + "_sand");
        }

        public ResourceLocation sandstone() {
            return ModPedia.ND.id(this.sandType + "_sandstone");
        }

        public ResourceLocation chiseledSandstone() {
            return ModPedia.ND.id("chiseled_" + this.sandType + "_sandstone");
        }

        public ResourceLocation smoothSandstone() {
            return ModPedia.ND.id("smooth_" + this.sandType + "_sandstone");
        }

        public ResourceLocation cutSandstone() {
            return ModPedia.ND.id("cut_"+ this.sandType +"_sandstone");
        }

        public ResourceLocation getDye() {
            if (this.sandType.equals("windswept")) {
                return ModPedia.MC.id("wind_charge");
            }
            return ModPedia.MC.id(this.sandType + "_dye");
        }

        public Holder<Item> getItemHolder(ResourceLocation id) {
            ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
            return BuiltInRegistries.ITEM.getHolderOrThrow(key);
        }

        public Ingredient getIngredient(ResourceLocation id) {
            return Ingredient.of(getItemHolder(id).value());
        }
    }
}
