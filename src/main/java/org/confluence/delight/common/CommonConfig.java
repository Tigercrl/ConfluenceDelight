package org.confluence.delight.common;

import org.confluence.delight.ConfluenceDelight;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = ConfluenceDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec SPEC = BUILDER.build();


    @SubscribeEvent
    public static void onLoad(ModConfigEvent event) {
        if (event.getConfig().getModId().equals(ConfluenceDelight.MODID) &&
                event.getConfig().getType() == ModConfig.Type.CLIENT
        ) {
        }
    }
}
