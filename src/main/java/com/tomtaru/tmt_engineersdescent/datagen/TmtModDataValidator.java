package com.tomtaru.tmt_engineersdescent.datagen;

import com.tomtaru.tmt_engineersdescent.TmtModData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class TmtModDataValidator {

    public static void validate() {
        List<String> missing = new ArrayList<>();

        for (TmtModData.TreePedia tree : TmtModData.TreePedia.TREEPEDIA) {
            checkIfPresent(tree, tree.log(), missing);
            checkIfPresent(tree, tree.wood(), missing);
            checkIfPresent(tree, tree.planks(), missing);
        }

        for (TmtModData.OrePedia ore : TmtModData.OrePedia.OREPEDIA) {
            checkIfPresent(ore, ore.raw(), missing);
            checkIfPresent(ore, ore.oreBlock(), missing);
        }

        for (TmtModData.HerbaPedia herb : TmtModData.HerbaPedia.HERBAPEDIA) {
            checkIfPresent(herb, herb.seedItem(), missing);
            checkIfPresent(herb, herb.produceItem(), missing);
            if (herb.secondaryItem() != null) {
                checkIfPresent(herb, herb.secondaryItem(), missing);
            }
        }

        if (!missing.isEmpty()) {
            throw new IllegalStateException(
                    "Engineer's Descent: " + missing.size() +
                            " referenced item(s)/block(s) are missing from the registry:\n  " +
                            String.join("\n  ", missing)
            );
        }
    }

    private static void checkIfPresent(Object owner, ResourceLocation id, List<String> missing) {
        if (!BuiltInRegistries.ITEM.containsKey(id) && !BuiltInRegistries.BLOCK.containsKey(id)) {
            missing.add(owner + " -> " + id);
        }
    }
}