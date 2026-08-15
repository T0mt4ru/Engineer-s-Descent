package com.tomtaru.tmt_engineersdescent.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.StackWithChance;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmt_engineersdescent.TmtModData;
import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class TmtCrusherRecipes {

    private static final float chanceGuaranteed = 1.0F;
    private static final float chanceLow = 0.25F;
    private static final float chanceMedium = 0.5F;
    private static final float chanceHigh = 0.75F;

    private static final int energyStone= 6000;
    private static final int energyDeepslate = (int) Math.floor(energyStone * 1.25);

    private static final List<StackWithChance> noSecondaries = List.of();

    public static void build(RecipeOutput output) {

        for (TmtModData.SandPedia sandType : TmtModData.SandPedia.SANDPEDIA) {

            TagOutput sandOutput = new TagOutput(new IngredientWithSize(sandType.getIngredient(sandType.sand()),2));

            List<StackWithChance> secondaries = List.of(
                    new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(TmtModData.ModPedia.IE.modid(), "dust_saltpeter")),1), chanceMedium),
                    new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(sandType.getDye()),1), chanceLow)
            );

            generateCrusherRecipe(output,
                    sandType.getIngredient(sandType.sandstone()),
                    sandOutput,
                    energyStone,
                    secondaries,
                    sandType.sandstone().getPath());

            generateCrusherRecipe(output,
                    sandType.getIngredient(sandType.chiseledSandstone()),
                    sandOutput,
                    energyStone,
                    secondaries,
                    sandType.chiseledSandstone().getPath());

            generateCrusherRecipe(output,
                    sandType.getIngredient(sandType.cutSandstone()),
                    sandOutput,
                    energyStone,
                    secondaries,
                    sandType.cutSandstone().getPath());

            generateCrusherRecipe(output,
                    sandType.getIngredient(sandType.smoothSandstone()),
                    sandOutput,
                    energyStone,
                    secondaries,
                    sandType.smoothSandstone().getPath());

        }




    }

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
}