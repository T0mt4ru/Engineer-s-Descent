package com.tomtaru.tmt_engineersdescent.datagen;

import com.tomtaru.tmt_engineersdescent.datagen.recipeproviders.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class TmtModRecipeProvider extends RecipeProvider {

    public TmtModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        //TmtVanillaRecipes.build(output);
        //FermenterRecipes.build(output);
        //MixerRecipes.build(output);
        //BottlingMachineRecipes.build(output);
        TmtClocheRecipes.build(output);
        //TmtCrusherRecipes.build(output);
        //MetalPressRecipes.build(output);
        TmtSawmillRecipes.build(output);
        //SqueezerRecipes.build(output);
        //BlueprintRecipes.build(output);
        //ThermoelectricRecipes.build(output);
        //RefineryRecipes.build(output);
        //TmtCokeovenRecipes.build(output);
    }
}