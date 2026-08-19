package com.tomtaru.tmt_engineersdescent.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.SawmillRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.api.crafting.TagOutputList;

import com.tomtaru.tmt_engineersdescent.TmtModData;
import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;


public class TmtSawmillRecipes {

    /**
     *
     * @param sawingOutput
     * @param input
     * @param energy
     * @param strippedOutput
     * @param secondaryStrippedOutputs
     * @param output
     * @param secondaryOutputs
     * @param recipeName
     */

    private static void generateSawmillRecipe(RecipeOutput sawingOutput, Ingredient input, int energy, TagOutput strippedOutput, TagOutputList secondaryStrippedOutputs, TagOutput output, TagOutputList secondaryOutputs, String recipeName) {
        SawmillRecipe recipe = new SawmillRecipe(
                output,
                strippedOutput,
                input,
                energy,
                secondaryStrippedOutputs,
                secondaryOutputs
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "sawmill/" + recipeName);
        sawingOutput.accept(id, recipe, null);
    }

    public static void build(RecipeOutput output) {
        var energyStandard = 1600;
        var dustTag = new TagOutputList(new TagOutput(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.C.modid(), "dusts/wood"))));

        for(TmtModData.TreePedia treeType : TmtModData.TreePedia.TREEPEDIA) {

            generateSawmillRecipe(output,
                    treeType.getIngredient(treeType.log()),
                    energyStandard,
                    new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.strippedLog()), 1)),
                    dustTag,
                    new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.planks()), 6)),
                    dustTag,
                    treeType.log().getPath());

            generateSawmillRecipe(output,
                    treeType.getIngredient(treeType.wood()),
                    energyStandard,
                    new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.strippedWood()), 1)),
                    dustTag,
                    new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.planks()), 6)),
                    dustTag,
                    treeType.wood().getPath());

            generateSawmillRecipe(output,
                    treeType.getIngredient(treeType.strippedLog()),
                    energyStandard,
                    TagOutput.EMPTY,
                    TagOutputList.EMPTY,
                    new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.planks()), 6)),
                    dustTag,
                    treeType.strippedLog().getPath());

            generateSawmillRecipe(output,
                    treeType.getIngredient(treeType.strippedWood()),
                    energyStandard,
                    TagOutput.EMPTY,
                    TagOutputList.EMPTY,
                    new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.planks()), 6)),
                    dustTag,
                    treeType.strippedWood().getPath());

            if (treeType.exists(treeType.planks()) && treeType.exists(treeType.slab())) {
                generateSawmillRecipe(output,
                        treeType.getIngredient(treeType.planks()),
                        energyStandard,
                        TagOutput.EMPTY,
                        TagOutputList.EMPTY,
                        new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.slab()), 2)),
                        dustTag,
                        treeType.planks().getPath());
            }

            if (treeType.exists(treeType.stairs())) {
                generateSawmillRecipe(output,
                        treeType.getIngredient(treeType.stairs()),
                        energyStandard,
                        TagOutput.EMPTY,
                        TagOutputList.EMPTY,
                        new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.planks()), 1)),
                        dustTag,
                        treeType.stairs().getPath());
            }

            if (treeType.exists(treeType.door())) {
                generateSawmillRecipe(output,
                        treeType.getIngredient(treeType.door()),
                        energyStandard,
                        TagOutput.EMPTY,
                        TagOutputList.EMPTY,
                        new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.planks()), 1)),
                        dustTag,
                        treeType.door().getPath());
            }

            if (treeType.exists(treeType.bookshelf())) {
                generateSawmillRecipe(output,
                        treeType.getIngredient(treeType.bookshelf()),
                        energyStandard,
                        TagOutput.EMPTY,
                        TagOutputList.EMPTY,
                        new TagOutput(new IngredientWithSize(treeType.getIngredient(treeType.planks()), 4)),
                        new TagOutputList(List.of(
                                new TagOutput(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.C.modid(), "dusts/wood"))),
                                new TagOutput(new IngredientWithSize(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.MC.modid(), "book")), 3))
                        )),
                        treeType.bookshelf().getPath());
            }
        }

    }
}