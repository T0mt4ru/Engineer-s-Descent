package com.tomtaru.tmt_engineersdescent.datagen.recipeproviders;

import blusunrize.immersiveengineering.api.crafting.ClocheRecipe;
import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import blusunrize.immersiveengineering.api.crafting.StackWithChance;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import com.tomtaru.tmt_engineersdescent.TmtModData;
import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

import java.util.List;

public class TmtClocheRecipes {

    private static final FluidIngredient fluidWater = FluidIngredient.tag(TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath("c", "water")));
    private static final FluidIngredient fluidLava = FluidIngredient.tag(TagKey.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath("c", "lava")));

    private static final int timeStandard = 1600;
    private static final int timeHalved = timeStandard / 2;
    private static final int timeDoubled = timeStandard * 2;

    private static final float chanceGuaranteed = 1.0f;
    private static final float chanceHigh = 0.75f;
    private static final float chanceMedium = 0.5f;
    private static final float chanceLow = 0.25f;




    private static void generateClocheRecipe(
            RecipeOutput clocheOutput, Ingredient seedItem, ResourceLocation cropOutput,int cropYield,
            ResourceLocation cropSecondaries, Ingredient soilItem, FluidIngredient fluidIngredient, int time,
            ClocheRenderFunction clocheRenderFunction, String recipeName) {

        List<StackWithChance> outputs;

        if (cropSecondaries != null) {
        outputs = List.of(
                new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(cropOutput), cropYield), chanceGuaranteed),
                new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(cropSecondaries), 1), chanceMedium)
        );
        } else {
            outputs = List.of(
                    new StackWithChance(new TagOutput(BuiltInRegistries.ITEM.get(cropOutput), cropYield), chanceGuaranteed)
            );
        }

        ClocheRecipe recipe = new ClocheRecipe(
                outputs,
                seedItem,
                soilItem,
                time,
                fluidIngredient,
                clocheRenderFunction
        );

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Tmt_engineersdescent.MODID, "cloche/" + recipeName);
        clocheOutput.accept(id, recipe, null);

    }


    public static void build(RecipeOutput output) {


        for (TmtModData.HerbaPedia herbType : TmtModData.HerbaPedia.HERBAPEDIA) {

            generateClocheRecipe(output,
                    herbType.getIngredient(herbType.seedItem()),
                    herbType.produceItem(),
                    herbType.getYield(),
                    herbType.secondaryItem(),
                    herbType.getSoil(),
                    fluidLava,
                    timeStandard,
                    herbType.getClocheRenderFunction(),
                    herbType.seedItem().getPath()
            );
        }
    }
}