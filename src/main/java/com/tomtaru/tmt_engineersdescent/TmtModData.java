package com.tomtaru.tmt_engineersdescent;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import blusunrize.immersiveengineering.client.utils.ClocheRenderFunctions;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import java.util.List;

public class TmtModData {

    public enum ClocheRenderType {
        GENERIC,
        CROP,
        STEM
    }

    public enum TreeType {
        LOG,
        STEM,
        PEDU,
    }

    public enum PlantCategory {
        FUNGI,
        FLOWER,
        VEGETABLE,
        FRUIT,
        CACTUS,
        REED,
        PUMPKIN,
        SWAMP
    }

    public record ModPedia(String modid, String modName) {
        public static final ModPedia C      = new ModPedia("c", "Common");
        public static final ModPedia FD     = new ModPedia("farmersdelight", "Farmer's Delight");
        public static final ModPedia IE     = new ModPedia("immersiveengineering", "Immersive Engineering");
        public static final ModPedia MC     = new ModPedia("minecraft", "Minecraft");
        public static final ModPedia ND = new ModPedia("netherdescent", "Nether Descent");

        public ResourceLocation id(String path) {
            return ResourceLocation.fromNamespaceAndPath(this.modid, path);
        }
    }

    public record TreePedia(String treeName, TreeType treeType) {
        public static final TreePedia WAILING   = new TreePedia("wailing", TreeType.STEM);
        public static final TreePedia EMBUR     = new TreePedia("embur", TreeType.PEDU);
        public static final TreePedia ARISIAN   = new TreePedia("arisan", TreeType.LOG);
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

    public record HerbaPedia (String herbType, int yield,  ClocheRenderType renderType, PlantCategory category) {

        public static final List<HerbaPedia> HERBAPEDIA = List.of(
        );

        public ResourceLocation seedItem() {
            if (this.herbType.equals("white_puffball_cap")) {
                return ModPedia.ND.id("white_puffball_spores");
            } else if (this.herbType.equals("pale_pumpkin")) {
                return ModPedia.ND.id("pale_pumpkin_seeds");
            } else return ModPedia.ND.id(this.herbType);
        }

        public Holder<Item> getItemHolder(ResourceLocation id) {
            ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
            return BuiltInRegistries.ITEM.getHolderOrThrow(key);
        }

        public Ingredient getIngredient(ResourceLocation id) {
            return Ingredient.of(getItemHolder(id).value());
        }

        public ResourceLocation cropRenderBlock() {
            if (this.herbType.equals("oddion_bulb")) {
                return ModPedia.ND.id(this.herbType.replace("_bulb", "_crop"));
            } else if (this.herbType.equals("blueberries")) {
                return ModPedia.ND.id("blueberry_bush");
            } else if (this.herbType.equals("white_puffball_cap")) {
                return ModPedia.ND.id(this.herbType.replace("_cap", ""));
            } else if (this.category.equals(PlantCategory.REED)) {
                return ModPedia.ND.id(herbType.replace("_shoot", ""));
            } else return ModPedia.ND.id(this.herbType);
        }

        public Block getCropRenderBlock() {
            return BuiltInRegistries.BLOCK.get(cropRenderBlock());
        }

        public ResourceLocation stemRenderBlock() {
            if (this.herbType.equals("pale_pumpkin")) {
                return ModPedia.ND.id("pale_pumpkin_stem");
            }
            throw new IllegalStateException("This crop has no stem!");
        }

        public Block getStemRenderBlock() {
            return BuiltInRegistries.BLOCK.get(stemRenderBlock());
        }

        public ResourceLocation attachedStemRenderBlock() {
            if (this.herbType.equals("pale_pumpkin")) {
                return ModPedia.ND.id("attached_pale_pumpkin_stem");
            }
            throw new IllegalStateException("This crop has no attached stem!");
        }

        public Block getAttachedStemRenderBlock() {
            return BuiltInRegistries.BLOCK.get(attachedStemRenderBlock());
        }

        public ResourceLocation produceItem() {
            return ModPedia.ND.id(this.herbType);
        }

        public ClocheRenderFunction getClocheRenderFunction() {
            return switch (this.renderType) {
                case CROP ->
                    new ClocheRenderFunctions.RenderFunctionCrop(getCropRenderBlock());
                case GENERIC ->
                    new ClocheRenderFunctions.RenderFunctionGeneric(getCropRenderBlock());
                case STEM ->
                    new ClocheRenderFunctions.RenderFunctionStem(getCropRenderBlock(), getStemRenderBlock(), getAttachedStemRenderBlock());
            };
        }

        public int getYield() {
            return this.yield;
        }

        public Ingredient getSoil() {
            return switch (this.category) {
                case FUNGI ->
                        Ingredient.of(Items.MYCELIUM);
                case FLOWER ->
                        Ingredient.of(Items.DIRT);
                case VEGETABLE ->
                        Ingredient.of(Items.DIRT);
                case FRUIT ->
                        Ingredient.of(Items.DIRT);
                case CACTUS ->
                        Ingredient.of(Tags.Items.SANDS);
                case PUMPKIN ->
                        Ingredient.of(Items.DIRT);
                case REED ->
                        Ingredient.of(Items.DIRT);
                case SWAMP ->
                        Ingredient.of(Items.WATER_BUCKET);
            };
        }

        public boolean worksOnRichSoil() {
            return this.category == PlantCategory.FLOWER
                    || this.category == PlantCategory.VEGETABLE
                    || this.category == PlantCategory.PUMPKIN
                    || this.category == PlantCategory.REED
                    || this.category == PlantCategory.FRUIT;
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
