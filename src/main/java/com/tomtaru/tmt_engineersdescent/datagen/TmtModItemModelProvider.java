package com.tomtaru.tmt_engineersdescent.datagen;

import com.tomtaru.tmt_engineersdescent.Tmt_engineersdescent;
import com.tomtaru.tmt_engineersdescent.registry.TmtModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class TmtModItemModelProvider extends ItemModelProvider {

    public TmtModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tmt_engineersdescent.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(TmtModItems.PENDORITE_GRIT.getId().getPath());

    }

    private void simpleItem(String name) {
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + name));
    }
}