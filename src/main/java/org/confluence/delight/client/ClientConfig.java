package org.confluence.delight.client;

import org.confluence.delight.ConfluenceDelight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = ConfluenceDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.BooleanValue SHINE_EFFECT_FIX = BUILDER.comment("Whether to fix the shine effect for Confluence Otherworld").define("shineEffectFix", false);
    private static final ModConfigSpec.BooleanValue BETTER_BIOME_BLEND = BUILDER.comment("Whether to use a higher biome blend radius").define("betterBiomeBlend", true);
    private static final ModConfigSpec.BooleanValue TR_LOADING = BUILDER.comment("Whether to use Terraria loading screen").define("trLoading", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean shineEffectFix = true;
    public static boolean betterBiomeBlend = true;
    public static boolean trLoading = true;

    @SubscribeEvent
    public static void onLoad(ModConfigEvent event) {
        if (event.getConfig().getModId().equals(ConfluenceDelight.MODID) &&
                event.getConfig().getType() == ModConfig.Type.CLIENT
        ) {
            ClientConfig.shineEffectFix = SHINE_EFFECT_FIX.get();
            ClientConfig.betterBiomeBlend = BETTER_BIOME_BLEND.get();
            ClientConfig.trLoading = TR_LOADING.get();
            LevelRenderer levelRenderer = Minecraft.getInstance().levelRenderer;
            if (levelRenderer != null) levelRenderer.allChanged();
        }
    }
}
