package org.confluence.delight.data.gen.language;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.confluence.delight.ConfluenceDelight;

import java.util.function.Supplier;

public abstract class AbstractModLanguageProvider extends LanguageProvider {
    public AbstractModLanguageProvider(PackOutput output, String locale) {
        super(output, ConfluenceDelight.MODID, locale);
    }

    protected void addItem(Supplier<? extends Item> key, String name, String tooltip) {
        addItem(key, name);
        add(key.get().getDescriptionId() + ".tooltip", tooltip);
    }

    protected void addCreativeTab(Supplier<? extends CreativeModeTab> key, String name) {
        add(key.get().getDisplayName().getString(), name);
    }
}
