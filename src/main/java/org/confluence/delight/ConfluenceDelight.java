package org.confluence.delight;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.confluence.delight.client.ClientConfig;
import org.confluence.delight.common.CommonConfig;
import org.confluence.delight.common.registry.*;

@Mod(ConfluenceDelight.MODID)
public class ConfluenceDelight {
    public static final String MODID = "confluence_delight";

    public ConfluenceDelight(IEventBus eventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
        if (FMLEnvironment.dist.isClient()) {
            modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }

        // registry
        ModEffects.EFFECTS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModCreativeTabs.CREATIVE_TABS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModPlacementModifiers.PLACEMENT_MODIFIERS.register(eventBus);
    }

    public static ResourceLocation resource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
