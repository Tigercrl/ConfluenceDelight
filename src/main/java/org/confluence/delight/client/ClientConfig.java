package org.confluence.delight.client;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.confluence.delight.ConfluenceDelight;

@EventBusSubscriber(modid = ConfluenceDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.BooleanValue TR_LOADING = BUILDER.comment("Whether to use Terraria loading screen").define("trLoading", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean trLoading = false;

    @SubscribeEvent
    public static void onLoad(ModConfigEvent event) {
        if (event.getConfig().getModId().equals(ConfluenceDelight.MODID) &&
                event.getConfig().getType() == ModConfig.Type.CLIENT
        ) {
            ClientConfig.trLoading = TR_LOADING.get();
        }
    }
}
