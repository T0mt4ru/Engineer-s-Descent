package com.tomtaru.tmt_engineersdescent.datagen.recipeproviders;


import com.tomtaru.tmt_engineersdescent.TmtModData;
import com.tomtaru.tmt_engineersdescent.registry.TmtModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class TmtVanillaRecipes {

    public static void build(RecipeOutput output) {

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(TmtModItems.PENDORITE_GRIT),
                        RecipeCategory.MISC,
                        BuiltInRegistries.ITEM.get(TmtModData.ModPedia.ND.id("pendorite_ingot")),
                        0.15f,
                        200)
                .unlockedBy("has_pendorite", InventoryChangeTrigger.TriggerInstance.hasItems(
                        BuiltInRegistries.ITEM.get(TmtModData.ModPedia.ND.id("pendorite_ingot"))))
                .save(output, TmtModData.ModPedia.ED.id("smelting/pendorite_dust"));
    }
}