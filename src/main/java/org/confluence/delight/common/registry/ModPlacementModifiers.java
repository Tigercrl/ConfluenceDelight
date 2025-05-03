package org.confluence.delight.common.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.world.filter.BiomeFilter;

import java.util.function.Supplier;

public class ModPlacementModifiers {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, ConfluenceDelight.MODID);
    public static final Supplier<PlacementModifierType<BiomeFilter>> BIOME =
            PLACEMENT_MODIFIERS.register("biome", () -> () -> BiomeFilter.CODEC);
}