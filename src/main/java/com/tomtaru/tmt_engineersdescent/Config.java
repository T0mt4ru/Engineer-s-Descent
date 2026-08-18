package com.tomtaru.tmt_engineersdescent;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;

@EventBusSubscriber(modid = Tmt_engineersdescent.MODID)
public class Config {

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {

    }
}
