package com.tomtaru.tmt_engineersdescent.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.StackWithChance;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmt_engineersdescent.TmtModData;
import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class TmtCrusherRecipes {

    private static final float chanceGuaranteed = 1.0F;
    private static final float chanceLow = 0.1F;
    private static final float chanceMedium = 0.33F;
    private static final float chanceHigh = 0.75F;

    private static final int energyStone = 6000;
    private static final int energyDeepslate = (int) Math.floor(energyStone * 1.25);

    private static final List<StackWithChance> noSecondaries = List.of();

    /**
     *
     * @param crusherOutput
     * @param input
     * @param output
     * @param energy
     * @param secondaryOutputs
     * @param recipeName
     */

    private static void generateCrusherRecipe(RecipeOutput crusherOutput, Ingredient input, TagOutput output, int energy, List<StackWithChance> secondaryOutputs, String recipeName) {
        CrusherRecipe recipe = new CrusherRecipe(
                output,
                input,
                energy,
                secondaryOutputs
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "crusher/" + recipeName);
        crusherOutput.accept(id, recipe, null);
    }

    public static void build(RecipeOutput output) {

        for (TmtModData.OrePedia oreType : TmtModData.OrePedia.OREPEDIA) {

            TagOutput dustOutput = new TagOutput(new IngredientWithSize(oreType.getTag(oreType.dust()), 1));

            List<StackWithChance> secondaries = List.of(
                    new StackWithChance(new TagOutput(oreType.getTag(oreType.dust()), 1), chanceMedium)
            );

            generateCrusherRecipe(output,
                    oreType.getIngredient(oreType.raw()),
                    dustOutput,
                    energyStone,
                    secondaries,
                    oreType.oreName()
            );
        }
    }
}