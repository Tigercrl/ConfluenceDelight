package org.confluence.delight.data.gen.language;

import net.minecraft.data.PackOutput;
import org.confluence.delight.common.registry.ModCreativeTabs;
import org.confluence.delight.common.registry.ModItems;

public class ModEnUsLanguageProvider extends AbstractModLanguageProvider {
    public ModEnUsLanguageProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("options.biomeBlendRadius.better", "32x32 (Better - Confluence Delight)");
        add("confluence_delight.configuration.shineEffectFix", "Fix shine effect");
        add("confluence_delight.configuration.shineEffectFix.tooltip", "Fix shine effect for Confluence Otherworld");
        add("confluence_delight.configuration.betterBiomeBlend", "Better biome blending");
        add("confluence_delight.configuration.betterBiomeBlend.tooltip", "Use a higher biome blend radius");
        add("confluence_delight.configuration.trLoading", "Terraria loading");
        add("confluence_delight.configuration.trLoading.tooltip", "Use Terraria loading screen");

        addCreativeTab(ModCreativeTabs.FOOD, "Confluence Delight | Food");
        addCreativeTab(ModCreativeTabs.TOOL, "Confluence Delight | Tools");
        addCreativeTab(ModCreativeTabs.DEVELOPER, "Confluence Delight | Developer Items");

        addItem(ModItems.SLIME_PUDDING, "Slime pudding", "'Bouncy and tasty!'");
        addItem(ModItems.PINK_SLIME_PUDDING, "Pink slime pudding", "'Super bouncy!'");

        addItem(ModItems.ADAMANTITE_KNIFE, "Adamantite knife");
        addItem(ModItems.BLOOD_KNIFE, "Blood knife");
        addItem(ModItems.BONE_KNIFE, "Bone knife");
//        addItem(ModItems.CHLOROPHYTE_KNIFE, "Chlorophyte knife");
        addItem(ModItems.COBALT_KNIFE, "Cobalt knife");
        addItem(ModItems.COPPER_KNIFE, "Copper knife");
        addItem(ModItems.FOSSIL_KNIFE, "Fossil knife");
        addItem(ModItems.HALLOWED_KNIFE, "Hallowed knife");
        addItem(ModItems.LEAD_KNIFE, "Lead knife");
//        addItem(ModItems.LUMINITE_KNIFE, "Luminite knife");
//        addItem(ModItems.METEOR_KNIFE, "Meteor knife");
        addItem(ModItems.MOLTEN_KNIFE, "Molten knife");
        addItem(ModItems.MYTHRIL_KNIFE, "Mythril knife");
        addItem(ModItems.ORICHALCUM_KNIFE, "Orichalcum knife");
        addItem(ModItems.PALLADIUM_KNIFE, "Palladium knife");
        addItem(ModItems.PLATINUM_KNIFE, "Platinum knife");
        addItem(ModItems.SHADOW_KNIFE, "Shadow knife");
        addItem(ModItems.SILVER_KNIFE, "Silver knife");
//        addItem(ModItems.SHROOMITE_KNIFE, "Shroomite knife");
        addItem(ModItems.TIN_KNIFE, "Tin knife");
        addItem(ModItems.TITANIUM_KNIFE, "Titanium knife");
        addItem(ModItems.TUNGSTEN_KNIFE, "Tungsten knife");
        addItem(ModItems.ZENISH, "§l§6Z§ae§bn§ci§ds§eh", "'Just suppose it is a weapon'");

        add("confluence_delight.subtitles.cutting_board.knife_cut.hot", "Knife heats");
    }
}
