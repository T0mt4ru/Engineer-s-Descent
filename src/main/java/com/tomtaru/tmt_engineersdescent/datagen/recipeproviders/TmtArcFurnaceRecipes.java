package com.tomtaru.tmt_engineersdescent.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.*;
import com.tomtaru.tmt_engineersdescent.TmtModData;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class TmtArcFurnaceRecipes {

    /**
     *
     * @param arcOutput
     * @param input
     * @param inputExtra
     * @param arcOutputList
     * @param slagOutput
     * @param secondaries
     * @param time
     * @param energy
     * @param recipeName
     */

    private static void generateArcFurnaceRecipe(
            RecipeOutput arcOutput, IngredientWithSize input, List<IngredientWithSize> inputExtra,
            TagOutputList arcOutputList, TagOutput slagOutput,List<StackWithChance> secondaries,
            int time, int energy, String recipeName) {

        ArcFurnaceRecipe recipe = new ArcFurnaceRecipe(
                arcOutputList, slagOutput, secondaries,
                time, energy,
                input, inputExtra
        );

        ResourceLocation id = TmtModData.ModPedia.ED.id("arcfurnace/" + recipeName);
        arcOutput.accept(id,recipe, null);
    }

    public static void build(RecipeOutput output) {

        for (TmtModData.OrePedia oreType : TmtModData.OrePedia.OREPEDIA) {

            generateArcFurnaceRecipe(output,
                    new IngredientWithSize(Ingredient.of(oreType.getTag(oreType.dust())),1),
                    List.of(),
                    new TagOutputList(new TagOutput(oreType.getTag(oreType.ingot()),1)),
                    TagOutput.EMPTY,
                    List.of(),
                    100,
                    51200,
                    oreType.oreName()
                    );
        }
    }
}
