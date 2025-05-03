package org.confluence.delight.common.world.filter;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.confluence.delight.common.registry.ModPlacementModifiers;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BiomeFilter extends PlacementFilter {
    public static final MapCodec<BiomeFilter> CODEC = RecordCodecBuilder.mapCodec(
            (builder) -> builder.group(
                    TagKey.codec(Registries.BIOME).listOf().fieldOf("enabledTags").orElse(List.of()).forGetter((instance) -> instance.enabledBiomeTags),
                    TagKey.codec(Registries.BIOME).listOf().fieldOf("disabledTags").orElse(List.of()).forGetter((instance) -> instance.disabledBiomeTags),
                    ResourceKey.codec(Registries.BIOME).listOf().fieldOf("enabled").orElse(List.of()).forGetter((instance) -> instance.enabledBiomes),
                    ResourceKey.codec(Registries.BIOME).listOf().fieldOf("disabled").orElse(List.of()).forGetter((instance) -> instance.disabledBiomes)
            ).apply(builder, BiomeFilter::new)
    );
    private final List<TagKey<Biome>> enabledBiomeTags;
    private final List<TagKey<Biome>> disabledBiomeTags;
    private final List<ResourceKey<Biome>> enabledBiomes;
    private final List<ResourceKey<Biome>> disabledBiomes;

    public BiomeFilter(
            List<TagKey<Biome>> enabledBiomeTags,
            List<TagKey<Biome>> disabledBiomeTags,
            List<ResourceKey<Biome>> enabledBiomes,
            List<ResourceKey<Biome>> disabledBiomes
    ) {
        this.enabledBiomeTags = enabledBiomeTags;
        this.disabledBiomeTags = disabledBiomeTags;
        this.enabledBiomes = enabledBiomes;
        this.disabledBiomes = disabledBiomes;
    }

    protected boolean shouldPlace(PlacementContext context, @NotNull RandomSource random, @NotNull BlockPos pos) {
        Holder<Biome> biome = context.getLevel().getBiome(pos);
        return disabledBiomes.stream().noneMatch(biome::is) && disabledBiomeTags.stream().noneMatch(biome::is)
                && (enabledBiomes.stream().anyMatch(biome::is) || enabledBiomeTags.stream().anyMatch(biome::is));
    }

    @NotNull
    public PlacementModifierType<?> type() {
        return ModPlacementModifiers.BIOME.get();
    }
}